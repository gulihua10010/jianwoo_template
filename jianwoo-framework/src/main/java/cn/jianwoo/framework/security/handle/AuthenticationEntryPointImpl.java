package cn.jianwoo.framework.security.handle;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.ServletUtils;

/**
 * 认证失败处理类 返回未授权
 * 
 * @author jianwoo
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint, Serializable
{
    private static final long serialVersionUID = -8970718410437077606L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
            throws IOException
    {
        int code = HttpStatus.UNAUTHORIZED;
        String msg = MessageUtils.message("access.no.authentication", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(code, msg)));
    }
}
