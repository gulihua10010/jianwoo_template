package cn.jianwoo.system.service.impl;

import java.util.List;

import cn.jianwoo.system.domain.example.SystemConfigExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.mapper.SystemConfigMapper;
import cn.jianwoo.system.domain.SystemConfig;
import cn.jianwoo.system.service.SystemConfigService;
import org.springframework.util.CollectionUtils;

/**
 * 系统配置Service业务层处理
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
@Service
public class SystemConfigServiceImpl implements SystemConfigService
{
    @Autowired
    private SystemConfigMapper systemConfigMapper;

    /**
     * 查询系统配置
     * 
     * @param key 系统配置主键
     * @return 系统配置
     */
    @Override
    public SystemConfig querySystemConfigByKey(String key)
    {
        SystemConfig systemConfig = systemConfigMapper.selectByPrimaryKey(key);
        if (systemConfig == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("systemConfig.not.exist", key));
        }
        return systemConfig;
    }


    /**
     * 查询系统配置列表
     * 
     * @param systemConfig 系统配置
     * @return 系统配置
     */
    @Override
    public List<SystemConfig> querySystemConfigList(SystemConfig systemConfig)
    {
        return systemConfigMapper.selectList(systemConfig);
    }


    /**
     * 新增系统配置
     * 
     * @param systemConfig 系统配置
     * @return 结果
     */
    @Override
    public void doInsertSystemConfig(SystemConfig systemConfig)
    {
        systemConfig.fillInfoBeforeCreate();
        int rows = systemConfigMapper.insertSelective(systemConfig);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("systemConfig.create.failed"));
        }
    }


    /**
     * 修改系统配置
     * 
     * @param systemConfig 系统配置
     * @return 结果
     */
    @Override
    public void doUpdateSystemConfig(SystemConfig systemConfig)
    {
        systemConfig.fillInfoBeforeUpdate();
        int rows = systemConfigMapper.updateByPrimaryKeySelective(systemConfig);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("systemConfig.update.failed", systemConfig.getKey()));
        }
    }


    /**
     * 批量删除系统配置
     * 
     * @param keys 需要删除的系统配置主键
     * @return 结果
     */
    @Override
    public void doDeleteSystemConfigByKeys(String[] keys)
    {
        int rows = systemConfigMapper.deleteByPrimaryKeys(keys);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("systemConfigs.delete.failed", JSON.toJSONString(keys)));
        }
    }


    /**
     * 删除系统配置信息
     * 
     * @param key 系统配置主键
     * @return 结果
     */
    @Override
    public void doDeleteSystemConfigByKey(String key)
    {
        int rows = systemConfigMapper.deleteByPrimaryKey(key);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("systemConfig.delete.failed", key));
        }
    }


    @Override
    public SystemConfig queryEffectiveSystemConfigByKey(String key)
    {
        SystemConfigExample example = new SystemConfigExample();
        example.createCriteria().andValidEqualTo(true).andKeyEqualTo(key);
        List<SystemConfig> systemConfList = systemConfigMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(systemConfList))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("param.invalid", key));
        }
        return systemConfList.get(0);
    }


    @Override
    public List<SystemConfig> querySystemConfigsByType(String cfgType)
    {
        SystemConfigExample example = new SystemConfigExample();
        example.createCriteria().andCfgTypeEqualTo(cfgType);
        List<SystemConfig> systemConfList = systemConfigMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(systemConfList))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("param.invalid", cfgType));

        }
        return systemConfList;
    }
}
