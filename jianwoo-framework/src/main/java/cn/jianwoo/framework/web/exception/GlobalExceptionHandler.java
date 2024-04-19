package cn.jianwoo.framework.web.exception;

import javax.servlet.http.HttpServletRequest;

import cn.jianwoo.common.exception.ApiException;
import cn.jianwoo.common.exception.base.BaseException;
import cn.jianwoo.common.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.exception.DemoModeException;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 * 
 * @author jianwoo
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private static final List<String> EXCLUDE_CODE_LIST = Arrays.asList("OtherAffect", "EnumValid","RegexValid");

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public AjaxResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return AjaxResult.error(HttpStatus.FORBIDDEN, MessageUtils.message("controller.response.no.permission"));
    }


    /**
     * 请求方式不支持
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException e,
            HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',不支持'{}'请求", requestURI, e.getMethod());
        return AjaxResult.error(e.getMessage());
    }


    /**
     * 业务异常
     */
    @ExceptionHandler(E.class)
    public AjaxResult handleServiceException(E e, HttpServletRequest request)
    {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return StringUtils.isNotNull(code) ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(ApiException.class)
    public AjaxResult handleServiceException(ApiException e, HttpServletRequest request)
    {
        log.error(e.getMessage(), e);
        Integer code = e.getCode();
        return StringUtils.isNotNull(code) ? AjaxResult.error(code, e.getMessage()) : AjaxResult.error(e.getMessage());
    }

    /**
     * 请求路径中缺少必需的路径变量
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public AjaxResult handleMissingPathVariableException(MissingPathVariableException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求路径中缺少必需的路径变量'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error(MessageUtils.message("controller.response.missing.path.variable", e.getVariableName()));
    }


    /**
     * 请求参数类型不匹配
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public AjaxResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
            HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求参数类型不匹配'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error(MessageUtils.message("controller.response.parameter.not.match", e.getName(),
                e.getRequiredType().getName(), e.getValue()));
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult handleCaptchaException(BaseException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生异常.", requestURI, e);
        return AjaxResult.error(e.getMessage());
    }


    /**
     * 处理日期解析异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public AjaxResult handleDateParseException(HttpMessageNotReadableException e, HttpServletRequest request)
    {
        if (e.getMessage() != null && e.getMessage().contains("yyyy-MM-dd HH:mm:ss"))
        {
            return AjaxResult.error(MessageUtils.message("controller.response.date.parse.exception"));
        }
        else if (e.getMessage() != null && e.getMessage().contains("JSON parse error"))
        {
            return AjaxResult.error(MessageUtils.message("controller.response.json.parse.exception"));
        }
        else if (e.getMessage() != null && e.getMessage().contains("Required request body is missing"))
        {
            return AjaxResult.error(MessageUtils.message("controller.response.request.body.missing"));
        }
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return AjaxResult.error(MessageUtils.message("controller.response.request.exception"));
    }


    /**
     * 拦截未知的运行时异常
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult handleRuntimeException(RuntimeException e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生未知异常.", requestURI, e);
        return AjaxResult.error(MessageUtils.message("controller.response.system.exception"));
    }


    /**
     * 系统异常
     */
    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e, HttpServletRequest request)
    {
        String requestURI = request.getRequestURI();
        log.error("请求地址'{}',发生系统异常.", requestURI, e);
        return AjaxResult.error(MessageUtils.message("controller.response.system.exception"));
    }


    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult handleBindException(BindException e)
    {
        log.error(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        // 校验注解名称
        String code = fieldError.getCode();
        // 校验字段名称
        String field = fieldError.getField();
        String defaultMessage = fieldError.getDefaultMessage();

        List<Object> args = Arrays.stream(Optional.ofNullable(fieldError.getArguments()).orElse(new Object[] {}))
                .filter(argument -> !(argument instanceof DefaultMessageSourceResolvable)).map(Object::toString)
                .collect(Collectors.toList());
        args.add(0, field);
        // 默认根据注解名称取，如果没有则取默认消息
        String errorMsg = MessageUtils.message(code, args.toArray());
        if (StringUtils.isNotBlank(errorMsg) && !EXCLUDE_CODE_LIST.contains(code))
        {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, errorMsg);
        }
        if (EXCLUDE_CODE_LIST.contains(code))
        {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, String.format("[%s]%s", field, defaultMessage));
        }
        return AjaxResult.error(HttpStatus.BAD_REQUEST, defaultMessage);
    }


    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleMethodArgumentNotValidException(MethodArgumentNotValidException e)
    {
        log.error(e.getMessage(), e);
        FieldError fieldError = e.getBindingResult().getFieldError();
        // 校验注解名称
        String code = fieldError.getCode();
        // 校验字段名称
        String field = fieldError.getField();
        // 检验失败默认消息
        String defaultMessage = fieldError.getDefaultMessage();

        List<Object> args = Arrays.stream(Optional.ofNullable(fieldError.getArguments()).orElse(new Object[] {}))
                .filter(argument -> !(argument instanceof DefaultMessageSourceResolvable)).map(Object::toString)
                .collect(Collectors.toList());
        args.add(0, field);
        // 默认根据注解名称取，如果没有则取默认消息
        String errorMsg = MessageUtils.message(code, args.toArray());
        if (StringUtils.isNotBlank(errorMsg) && !EXCLUDE_CODE_LIST.contains(code))
        {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, errorMsg);
        }

        if (EXCLUDE_CODE_LIST.contains(code))
        {
            return AjaxResult.error(HttpStatus.BAD_REQUEST, String.format("[%s]%s", field, defaultMessage));
        }
        return AjaxResult.error(HttpStatus.BAD_REQUEST, defaultMessage);
    }


    /**
     * 演示模式异常
     */
    @ExceptionHandler(DemoModeException.class)
    public AjaxResult handleDemoModeException(DemoModeException e)
    {
        return AjaxResult.error(MessageUtils.message("controller.response.demonstration.mode.no.operation.allowed"));
    }
}
