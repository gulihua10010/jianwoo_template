package cn.jianwoo.web.controller.system;

import cn.hutool.core.collection.CollUtil;
import cn.jianwoo.common.annotation.BizOptLog;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.domain.model.LoginUser;
import cn.jianwoo.common.enums.BusinessType;
import cn.jianwoo.common.enums.ValidateType;
import cn.jianwoo.common.utils.BizValidationUtils;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.SecurityUtils;
import cn.jianwoo.common.utils.bean.CopyBeanUtil;
import cn.jianwoo.system.domain.bo.SystemConfigBO;
import cn.jianwoo.system.domain.bo.SystemConfigResBO;
import cn.jianwoo.system.service.SysConfigService;
import cn.jianwoo.system.util.NotifyUtil;
import cn.jianwoo.web.dto.config.EmailTestRequest;
import cn.jianwoo.web.dto.config.SystemConfigDataVO;
import cn.jianwoo.web.dto.config.SystemConfigGroupVO;
import cn.jianwoo.web.dto.config.SystemConfigRequest;
import cn.jianwoo.web.dto.config.SystemConfigResVO;
import cn.jianwoo.web.dto.config.SystemConfigVO;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 参数配置 信息操作处理
 * 
 * @author jianwoo
 */
@RestController
@RequestMapping("/system/config")
@Slf4j
public class SysConfigController extends BaseController
{
    @Autowired
    private SysConfigService configService;
    @Autowired
    private NotifyUtil notifyUtil;

    /**
     * 根据参数键名查询参数值
     */
    @GetMapping(value = "/configKey/{configKey}")
    public R<String> getConfigKey(@Validated @PathVariable
    String configKey)
    {
        return ok(configService.selectConfigByKey(configKey));
    }


    /**
     * 刷新参数缓存
     */
    @PreAuthorize("@ss.hasPermi('system:config:remove')")
    @BizOptLog(title = "参数管理", businessType = BusinessType.CLEAN)
    @DeleteMapping("/refreshCache")
    public R refreshCache()
    {
        configService.resetConfigCache();
        return ok();
    }


    /**
     * 修改参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:edit')")
    @BizOptLog(title = "参数管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public R edit(@Validated @RequestBody
    SystemConfigRequest request)
    {

        if (CollUtil.isNotEmpty(request.getList()))
        {
            List<SystemConfigBO> list = new ArrayList<>();
            for (SystemConfigVO o : request.getList())
            {
                validateReqSystemConfig(o);
                SystemConfigBO bo = new SystemConfigBO();
                BeanUtils.copyProperties(o, bo);

                list.add(bo);
            }
            LoginUser loginUser = SecurityUtils.getLoginUser();
            configService.doUpdateConfig(list, loginUser.getUsername());
        }
        return ok();
    }


    private void validateReqSystemConfig(SystemConfigVO o)
    {
        if (null != o.getRequired() && o.getRequired())
        {
            BizValidationUtils.paramValidate(o.getValue(), o.getTitleDsp());

        }
        if (StringUtils.isNotBlank(o.getValidateType()))
        {
            String[] validateArr = o.getValidateType().split("\\|");
            JSONObject validateValue = null;
            try
            {
                validateValue = JSONObject.parseObject(o.getValidateValue());
            }
            catch (Exception e)
            {
                log.error("JSON validate Value parse failed, e:", e);
                return;
            }
            for (String valid : validateArr)
            {
                if (ValidateType.MAX_LENGTH.getValue().equals(valid.trim()))
                {
                    JSONObject v = (JSONObject) validateValue.get(ValidateType.MAX_LENGTH.getValue());
                    BizValidationUtils.paramLengthValidate(o.getValue(), Integer.parseInt(v.getString("value")),
                            MessageUtils.message("sys.cfg.length", o.getTitleDsp(), v.getString("value")));
                }
                if (ValidateType.REGEX.getValue().equals(valid.trim()))
                {
                    JSONObject v = (JSONObject) validateValue.get(ValidateType.REGEX.getValue());
                    BizValidationUtils.paramRegexValidate(o.getValue(), v.getString("value"),
                            MessageUtils.message("sys.cfg.regex", v.getString("value"), o.getTitleDsp(), o.getValue()));
                }
                if (ValidateType.NUMBER.getValue().equals(valid.trim()))
                {
                    BizValidationUtils.paramNumberValidate(o.getValue(),
                            MessageUtils.message("sys.cfg.number", o.getTitleDsp()));
                    JSONObject v = (JSONObject) validateValue.get("minNum");
                    if (null != v)
                    {
                        BizValidationUtils.paramNumberMinValidate(o.getValue(), v.getString("value"),
                                MessageUtils.message("sys.cfg.value.little", o.getTitleDsp(), v.getString("value")));
                    }
                    v = (JSONObject) validateValue.get("maxNum");
                    if (null != v)
                    {
                        BizValidationUtils.paramNumberMaxValidate(o.getValue(), v.getString("value"),
                                MessageUtils.message("sys.cfg.value.large", o.getTitleDsp(), v.getString("value")));
                    }

                }

                if (ValidateType.INTEGER.getValue().equals(valid.trim()))
                {
                    BizValidationUtils.paramNumberValidate(o.getValue(),
                            MessageUtils.message("sys.cfg.int", o.getTitleDsp()));
                    JSONObject v = (JSONObject) validateValue.get("minNum");
                    if (null != v)
                    {
                        BizValidationUtils.paramNumberMinValidate(o.getValue(), v.getString("value"),
                                MessageUtils.message("sys.cfg.value.little", o.getTitleDsp(), v.getString("value")));
                    }
                    v = (JSONObject) validateValue.get("maxNum");
                    if (null != v)
                    {
                        BizValidationUtils.paramNumberMaxValidate(o.getValue(), v.getString("value"),
                                MessageUtils.message("sys.cfg.value.large", o.getTitleDsp(), v.getString("value")));
                    }
                }
            }

        }

    }


    @PreAuthorize("@ss.hasPermi('system:config:list')")
    @GetMapping("/list")
    public R<SystemConfigResVO> list()
    {
        SystemConfigResVO response = SystemConfigResVO.getInstance();
        SystemConfigResBO resBO = configService.queryConfig();
        List<SystemConfigGroupVO> list = new ArrayList<>();
        if (CollUtil.isNotEmpty(resBO.getData()))
        {
            resBO.getData().forEach(o -> {
                SystemConfigGroupVO vo = new SystemConfigGroupVO();
                CopyBeanUtil.copyProperties(o, vo);
                list.add(vo);
            });
        }
        SystemConfigDataVO data = new SystemConfigDataVO();
        data.setDataList(list);
        data.setTabList(resBO.getTabList());
        response.setData(data);
        return ok(response);
    }


    /**
     * 修改参数配置
     */
    @PreAuthorize("@ss.hasPermi('system:config:edit')")
    @BizOptLog(title = "参数管理", businessType = BusinessType.UPDATE)
    @PostMapping("/email/test")
    public R doTestEmail(@Validated @RequestBody
    EmailTestRequest request)
    {

        notifyUtil.sendEmail("邮件测试", "<hr>邮件测试</hr><br>这是测试的内容。", request.getEmailTo());
        return ok();
    }

}
