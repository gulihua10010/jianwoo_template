package cn.jianwoo.framework.web.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import cn.jianwoo.common.constant.ConfigConstants;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.domain.Email;
import cn.jianwoo.system.service.IEmailService;
import cn.jianwoo.system.service.ISysConfigService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2022-05-12 17:55
 */
@Component
@EnableAspectJAutoProxy
@Aspect
@Slf4j
public class ExceptionAOPHandler
{

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IEmailService emailService;

    @Value("${exception.email.subject-prefix}")
    private String subjectPrefix;

    // 创建切入点,在service层切入
    @Pointcut(value = "(execution(* cn.jianwoo.task.task.*.*(..))||"
            + "execution(* cn.jianwoo.system.service.impl.*.*(..))||"
            + "execution(* cn.jianwoo.framework.web.service.*.*(..))||" + "execution(* cn.jianwoo.mq.*.*(..))) ")
    public void servicePointCut()
    {
    }


    @AfterThrowing(value = "servicePointCut()", throwing = "e")
    public void sendExceptionByMail(JoinPoint joinPoint, Exception e)
    {
        if (e instanceof E)
        {
            return;
        }
        String isNotify = configService.selectConfigByKey(ConfigConstants.EMAIL_EXCEPTION);
        if (!Constants.TRUE.equalsIgnoreCase(isNotify))
        {
            return;
        }
        String name = joinPoint.getSignature().getName();
        List<Object> args = new ArrayList<>();
        if (joinPoint.getArgs() != null)
        {
            args = Arrays.asList(joinPoint.getArgs());
        }

        String appName = configService.selectConfigByKey(ConfigConstants.APP_NAME);
        log.error("===>> [ExceptionAOPHandler]Exception occurs,  method: {}", name);
        log.error("===>> exception: \r\n", e);
        StringBuilder msg = new StringBuilder(
                String.format("===>> [ExceptionAOPHandler]Exception occurs,  method: %s\r\n", name));
        msg.append(e.toString()).append(":").append(e.getMessage()).append("\r\n");
        msg.append(log(e));
        StringBuilder subject = new StringBuilder();
        subject.append("[");
        subject.append(subjectPrefix);
        subject.append("] ");
        subject.append(MessageUtils.message("controller.response.system.exception"));
        subject.append(": ").append(e.getClass());

        // 发送邮件
        try
        {
            Email oldEmail = emailService.queryEmailBySubjectAndIn5Sec(String.format("【%s】%s", appName, subject));
            if (null != oldEmail)
            {
                return;
            }

            emailService.doSendEmail2Admin(subject.toString(), msg.toString());
        }
        catch (Exception ex)
        {
            log.error("defaultExceptionHandler.sendEmail failed, exception:\r\n", ex);
        }

    }


    private String log(Throwable ex)
    {
//        log.error("Exception request param:");
        StringBuilder msg = new StringBuilder();

        StackTraceElement[] error = ex.getStackTrace();
        for (StackTraceElement stackTraceElement : error)
        {
            msg.append(stackTraceElement.toString()).append("\r\n");

        }
//        log.error(msg.toString());
        return msg.toString();
    }

}
