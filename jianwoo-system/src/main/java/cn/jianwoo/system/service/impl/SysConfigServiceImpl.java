package cn.jianwoo.system.service.impl;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.jianwoo.common.builder.JwBuilder;
import cn.jianwoo.common.constant.CacheConstants;
import cn.jianwoo.common.constant.CfgType;
import cn.jianwoo.common.constant.ConfigConstants;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.core.redis.RedisCache;
import cn.jianwoo.common.core.text.Convert;
import cn.jianwoo.common.enums.ValueType;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.system.domain.SystemConfig;
import cn.jianwoo.system.domain.bo.SystemConfigBO;
import cn.jianwoo.system.domain.bo.SystemConfigGroupBO;
import cn.jianwoo.system.domain.bo.SystemConfigOptionsBO;
import cn.jianwoo.system.domain.bo.SystemConfigResBO;
import cn.jianwoo.system.domain.extend.SystemConfigExt;
import cn.jianwoo.system.mapper.biz.SystemConfBizMapper;
import cn.jianwoo.system.service.SysConfigService;
import cn.jianwoo.system.service.SystemConfigService;
import lombok.extern.slf4j.Slf4j;

/**
 * 参数配置 服务层实现
 *
 * @author jianwoo
 */
@Service
@Slf4j
public class SysConfigServiceImpl implements SysConfigService
{
    @Autowired
    private SystemConfBizMapper systemConfBizMapper;
    @Autowired
    private SystemConfigService systemConfigService;

    @Autowired
    private RedisCache redisCache;

    /**
     * 项目启动时，初始化参数到缓存
     */
    @PostConstruct
    public void init()
    {
        loadingConfigCache();
    }


    /**
     * 获取验证码开关
     *
     * @return true开启，false关闭
     */
    @Override
    public boolean selectCaptchaEnabled()
    {
        String captchaEnabled = selectConfigByKey(ConfigConstants.SYS_ACCOUNT_CAPTCHA_ENABLE);
        if (StringUtils.isEmpty(captchaEnabled))
        {
            return true;
        }
        return Convert.toBool(captchaEnabled);
    }


    /**
     * 加载参数缓存数据
     */
    @Override
    public void loadingConfigCache()
    {
        List<SystemConfig> configsList = queryAllSystemConf();
        Map<String, Map<String, String>> map = new HashMap<>();
        for (SystemConfig config : configsList)
        {
            String cacheKey = getConfigKeyCacheKey(config.getKey());
            String typeCacheKey = getConfigTypeCacheKey(config.getCfgType());
            String value = null;

            if (ValueType.STRING.getValue().equals(config.getValueType()))
            {
                value = format(config.getStringValue());
            }
            else if (ValueType.FLOAT.getValue().equals(config.getValueType()))
            {
                value = formatFloat2Str(config.getFloatValue());
            }
            else if (ValueType.INTEGER.getValue().equals(config.getValueType()))
            {
                value = formatInt2Str(config.getIntValue());
            }
            else if (ValueType.BOOLEAN.getValue().equals(config.getValueType()))
            {
                value = formatBoolean2Str(config.getBooleanValue());
            }
            else if (ValueType.DATE.getValue().equals(config.getValueType()))
            {
                value = DateUtil.format(config.getDateValue(), "yyyy-MM-dd HH:mm:ss");
            }
            if (!map.containsKey(typeCacheKey))
            {
                map.put(typeCacheKey, new HashMap<>());
            }
            map.get(typeCacheKey).put(config.getKey(), value);
            redisCache.setCacheObject(cacheKey, value);
        }
        map.forEach((k, v) -> {
            redisCache.setCacheObject(k, v);
        });
    }


    /**
     * 清空参数缓存数据
     */
    @Override
    public void clearConfigCache()
    {
        String typeCacheKey = MessageFormat.format(CacheConstants.SYSTEM_CONFIG_KEY, "*");
        Collection<String> keys = redisCache.keys(typeCacheKey);
        redisCache.deleteObject(keys);
    }


    /**
     * 重置参数缓存数据
     */
    @Override
    public void resetConfigCache()
    {
        clearConfigCache();
        loadingConfigCache();
    }


    /**
     * 设置cache key(配置键)
     *
     * @param configKey 配置键
     * @return 配置键key
     */
    private String getConfigKeyCacheKey(String configKey)
    {
        return MessageFormat.format(CacheConstants.SYSTEM_CONFIG_KEY, configKey);
    }


    /**
     * 设置cache key(配置类型)
     *
     * @param configType 配置类型
     * @return 配置类型key
     */
    private String getConfigTypeCacheKey(String configType)
    {
        return MessageFormat.format(CacheConstants.SYSTEM_CONFIG_TYPE, configType);
    }


    @Override
    public List<SystemConfig> queryAllSystemConf()
    {
        return systemConfBizMapper.selectAllSystemConf();
    }


    @Override
    public List<SystemConfigExt> queryEffectiveSystemConf()
    {
        return systemConfBizMapper.selectEffectiveSystemConf();
    }


    @Override
    public void doUpdateSystemConfByKey(SystemConfig systemConfig, String key)
    {
        if (StrUtil.isBlank(key))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("param.not.blank", "key"));
        }
        int updRlt = systemConfBizMapper.updateSystemConfByKey(systemConfig, key);
        if (updRlt == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("system.config.update.failed", key));
        }
    }


    @Override
    public SystemConfigResBO queryConfig()
    {
        List<SystemConfigExt> systemConfList = systemConfBizMapper.selectEffectiveSystemConf();
        List<SystemConfigBO> list = new ArrayList<>();
        List<SystemConfigGroupBO> resList = new ArrayList<>();
        List<SystemConfigGroupBO> tabs = new ArrayList<>();
        SystemConfigResBO resBO = new SystemConfigResBO();
        systemConfList.sort(Comparator.comparingInt(SystemConfigExt::getIndex));
        if (CollUtil.isNotEmpty(systemConfList))
        {
            systemConfList.forEach(o -> {
                SystemConfigBO bo = new SystemConfigBO();
                BeanUtils.copyProperties(o, bo);
                if (ValueType.STRING.getValue().equals(o.getValueType()))
                {
                    bo.setValue(o.getStringValue());
                }
                else if (ValueType.FLOAT.getValue().equals(o.getValueType()))
                {
                    bo.setValue(formatFloat2Str(o.getFloatValue()));
                }
                else if (ValueType.INTEGER.getValue().equals(o.getValueType()))
                {
                    bo.setValue(formatInt2Str(o.getIntValue()));
                }
                else if (ValueType.BOOLEAN.getValue().equals(o.getValueType()))
                {
                    bo.setValue(formatBoolean2Str(o.getBooleanValue()));
                }
                else if (ValueType.DATE.getValue().equals(o.getValueType()))
                {
                    bo.setValue(DateUtil.format(o.getDateValue(), "yyyy-MM-dd HH:mm:ss"));
                }
                if (null == bo.getTabType())
                {
                    bo.setTabType(Constants.BLANK);
                }
                if (StrUtil.isNotBlank(o.getOptions()))
                {
                    JSONArray jsonArray = JSONArray.parseArray(o.getOptions());
                    bo.setOptions(new ArrayList<>());
                    for (int i = 0; i < jsonArray.size(); i++)
                    {
                        SystemConfigOptionsBO opt = new SystemConfigOptionsBO();
                        opt.setValue(jsonArray.getJSONObject(i).getString("value"));
                        opt.setDsp(jsonArray.getJSONObject(i).getString("dsp"));
                        bo.getOptions().add(opt);
                    }
                }
                list.add(bo);
            });
            Map<String, List<SystemConfigBO>> grpMap = list.stream()
                    .collect(Collectors.groupingBy(SystemConfigBO::getTabType));
            grpMap.forEach((k, v) -> {
                SystemConfigGroupBO grpBO = JwBuilder.of(SystemConfigGroupBO::new)
                        .with(SystemConfigGroupBO::setTabCode, k)
                        .with(SystemConfigGroupBO::setTabNameDsp, v.get(0).getTabTypeDsp())
                        .with(SystemConfigGroupBO::setList, v).with(SystemConfigGroupBO::setIndex, v.get(0).getIndex())
                        .build();
                resList.add(grpBO);
                tabs.add(JwBuilder.of(SystemConfigGroupBO::new).with(SystemConfigGroupBO::setIndex, grpBO.getIndex())
                        .with(SystemConfigGroupBO::setTabNameDsp, grpBO.getTabNameDsp()).build());
            });
        }
        resList.sort(Comparator.comparingInt(SystemConfigGroupBO::getIndex));
        tabs.sort(Comparator.comparingInt(SystemConfigGroupBO::getIndex));
        resBO.setData(resList);
        resBO.setTabList(tabs.stream().map(SystemConfigGroupBO::getTabNameDsp).collect(Collectors.toList()));

        return resBO;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void doUpdateConfig(List<SystemConfigBO> configList, String actor)
    {
        log.info(">>Update SystemConf param: [{}]", JSON.toJSONString(configList));
        if (CollUtil.isNotEmpty(configList))
        {
            for (SystemConfigBO o : configList)
            {
                SystemConfig newSystemConf = new SystemConfig();
                if (ValueType.STRING.getValue().equals(o.getValueType()))
                {
                    newSystemConf.setStringValue(o.getValue());
                }
                else if (ValueType.FLOAT.getValue().equals(o.getValueType()))
                {
                    newSystemConf.setFloatValue(formatStr2Float(o.getValue()));
                }
                else if (ValueType.INTEGER.getValue().equals(o.getValueType()))
                {
                    newSystemConf.setIntValue(formatStr2Int(o.getValue()));
                }
                else if (ValueType.BOOLEAN.getValue().equals(o.getValueType()))
                {
                    newSystemConf.setBooleanValue(Boolean.valueOf(o.getValue()));
                }
                else if (ValueType.DATE.getValue().equals(o.getValueType()))
                {
                    newSystemConf.setDateValue(DateUtil.parse(o.getValue(), "yyyy-MM-dd HH:mm:ss"));
                }
                newSystemConf.setUpdateBy(actor);
                this.doUpdateSystemConfByKey(newSystemConf, o.getKey());

                if (null == o.getValue())
                {
                    o.setValue(Constants.BLANK);
                }
                redisCache.setCacheObject(getConfigKeyCacheKey(o.getKey()), o.getValue());
                String typeCacheKey = getConfigTypeCacheKey(o.getTabType());
                redisCache.deleteObject(typeCacheKey);

            }
        }

    }


    @Override
    public String querySystemConfByKey(String key)
    {
        if (org.apache.commons.lang3.StringUtils.isBlank(key)) return null;
        String cacheKey = getConfigKeyCacheKey(key);
        if (redisCache.hasKey(cacheKey))
        {
            // 理论上永远不会为null，因为key存在，且value不能为null
            return redisCache.getCacheObject(cacheKey);
        }
        SystemConfig systemConfig = null;
        systemConfig = systemConfigService.queryEffectiveSystemConfigByKey(key);

        String value = null;

        if (ValueType.STRING.getValue().equals(systemConfig.getValueType()))
        {
            value = format(systemConfig.getStringValue());
        }
        else if (ValueType.FLOAT.getValue().equals(systemConfig.getValueType()))
        {
            value = formatFloat2Str(systemConfig.getFloatValue());
        }
        else if (ValueType.INTEGER.getValue().equals(systemConfig.getValueType()))
        {
            value = formatInt2Str(systemConfig.getIntValue());
        }
        else if (ValueType.BOOLEAN.getValue().equals(systemConfig.getValueType()))
        {
            value = formatBoolean2Str(systemConfig.getBooleanValue());
        }
        else if (ValueType.DATE.getValue().equals(systemConfig.getValueType()))
        {
            value = DateUtil.format(systemConfig.getDateValue(), "yyyy-MM-dd HH:mm:ss");
        }

        redisCache.setCacheObject(cacheKey, value);
        return value;
    }


    @Override
    public String selectConfigByKey(String key)
    {
        try
        {
            return querySystemConfByKey(key);
        }
        catch (Exception e)
        {
            log.error(">>>>System config query exception!!!!", e);
            if (key.startsWith(CfgType.EMAIL.getValue()) || ConfigConstants.SYS_APP_NICK.equals(key))
            {
                return "";
            }
            throw new RuntimeException(e);
        }
    }


    @Override
    public Map<String, Object> querySystemConfByType(String cfgType)
    {
        Map<String, Object> confMap = new HashMap<>();
        if (org.apache.commons.lang3.StringUtils.isBlank(cfgType)) return confMap;
        String typeCacheKey = getConfigTypeCacheKey(cfgType);
        if (redisCache.hasKey(typeCacheKey))
        {
            // 理论上永远不会为null，因为key存在，且value不能为null
            return redisCache.getCacheMap(typeCacheKey);
        }
        List<SystemConfig> systemConfList = null;
        systemConfList = systemConfigService.querySystemConfigsByType(cfgType);

        for (SystemConfig systemConfig : systemConfList)
        {
            String value = null;
            if (ValueType.STRING.getValue().equals(systemConfig.getValueType()))
            {
                value = format(systemConfig.getStringValue());
            }
            else if (ValueType.FLOAT.getValue().equals(systemConfig.getValueType()))
            {
                value = formatFloat2Str(systemConfig.getFloatValue());
            }
            else if (ValueType.INTEGER.getValue().equals(systemConfig.getValueType()))
            {
                value = formatInt2Str(systemConfig.getIntValue());
            }
            else if (ValueType.BOOLEAN.getValue().equals(systemConfig.getValueType()))
            {
                value = formatBoolean2Str(systemConfig.getBooleanValue());
            }
            else if (ValueType.DATE.getValue().equals(systemConfig.getValueType()))
            {
                value = DateUtil.format(systemConfig.getDateValue(), "yyyy-MM-dd HH:mm:ss");
            }
            confMap.put(systemConfig.getKey(), value);
        }

        redisCache.setCacheMap(typeCacheKey, confMap);
        return confMap;
    }


    @Override
    public Map<String, Object> queryByType(String cfgType)
    {
        try
        {
            return querySystemConfByType(cfgType);
        }
        catch (Exception e)
        {
            log.error(">>>>System config query by type throw exception!!!!", e);
            if (cfgType.equals(CfgType.EMAIL.getValue()))
            {
                return new HashMap<>();
            }
            throw new RuntimeException(e);
        }
    }


    private String format(Object v)
    {
        if (v == null)
        {
            return "";
        }
        return String.valueOf(v);

    }


    private String formatFloat2Str(BigDecimal v)
    {
        if (v == null)
        {
            return Constants.ZERO;
        }
        return v.setScale(4, BigDecimal.ROUND_HALF_UP).toString();

    }


    private String formatInt2Str(Integer v)
    {
        if (v == null)
        {
            return Constants.ZERO;
        }
        return v.toString();

    }


    private String formatBoolean2Str(Boolean v)
    {
        if (v == null)
        {
            return Constants.FALSE;
        }
        return v.toString().toLowerCase(Locale.ROOT);

    }


    private BigDecimal formatStr2Float(String v)
    {
        if (org.apache.commons.lang3.StringUtils.isBlank(v))
        {
            return null;
        }
        return new BigDecimal(v);

    }


    private Integer formatStr2Int(String v)
    {
        if (org.apache.commons.lang3.StringUtils.isBlank(v))
        {
            return null;
        }
        return Integer.parseInt(v);

    }
}
