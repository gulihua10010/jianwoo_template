package cn.jianwoo.web.controller.system;

import cn.jianwoo.common.constant.ConfigConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.core.domain.model.RegisterBody;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.framework.web.service.SysRegisterService;
import cn.jianwoo.system.service.SysConfigService;

/**
 * 注册验证
 * 
 * @author jianwoo
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private SysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey(ConfigConstants.SYS_ACCOUNT_REGISTER_USER))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }
}
