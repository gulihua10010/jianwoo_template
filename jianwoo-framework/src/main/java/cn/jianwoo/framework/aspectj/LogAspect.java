package cn.jianwoo.framework.aspectj;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.annotation.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * 方法调用打印入参响应日志
 *
 * {@link Aspect} 申明当前类是切面类
 *
 * @author glh
 * @date 2021/2/8
 */
@Aspect
@Component
public class LogAspect
{
    protected final String loggingArgsFormat = "{}.{} param is {}.";
    protected final String loggingReturnFormat = "{}.{} return is {}.";
    protected final String loggingTimeConsumingFormat = "{}.{} execution cost {} ms.";
    protected final String loggingSlowProcessingWarnFormat = "{}.{} execute slowly and it cost {} ms that is more than {} ms.";
    protected final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 基于注解 {@link Log}, 进行切面处理
     */
    @Pointcut(value = "@annotation(cn.jianwoo.common.annotation.Log)")
    public void logPoint()
    {

    }


    /**
     * 执行核心方法
     *
     * 相当于 MethodInterceptor
     *
     * @param point 切点
     * @return 结果
     * @throws Throwable 异常信息
     */
    @Around("logPoint()")
    public Object around(ProceedingJoinPoint point) throws Throwable
    {
        String className = point.getTarget().getClass().getName();
        Method method = getCurrentMethod(point);

        Log log = method.getAnnotation(Log.class);
        String methodName = method.getName();
        try
        {
            final long startMills = System.currentTimeMillis();
            // 1. 入参
            if (log.enableLoggingArgs())
            {
                Object args = point.getArgs();
                if (log.enableJSONPrint())
                {
                    args = JSON.toJSONString(point.getArgs());
                }
                logging(log, loggingArgsFormat, className, methodName, args);
            }

            // 2. 执行方法
            Object result = point.proceed();

            // 3. 结果
            Type type = method.getGenericReturnType();
            if (log.enableLoggingReturn() && !type.equals(Void.TYPE))
            {
                if (Objects.isNull(result))
                {
                    logging(log, loggingReturnFormat, className, methodName, "Null");
                }
                else
                {
                    Object res = result;
                    if (log.enableJSONPrint())
                    {
                        res = JSON.toJSONString(res);
                    }
                    logging(log, loggingReturnFormat, className, methodName, res);
                }
            }

            // 3.1 耗时
            final long slowProcessingThresholdMills = log.slowProcessingThresholdMills();
            if (log.enableLoggingTimeConsuming())
            {
                final long endMills = System.currentTimeMillis();
                long costTime = endMills - startMills;

                // 3.2 慢日志
                if (slowProcessingThresholdMills >= 0 && costTime >= slowProcessingThresholdMills)
                {
                    logger.warn(loggingSlowProcessingWarnFormat, className, methodName, costTime,
                            slowProcessingThresholdMills);
                }
                else
                {
                    logging(log, loggingTimeConsumingFormat, className, methodName, costTime);
                }
            }

            return result;
        }
        catch (Throwable e)
        {
            // 4. 异常
            if (log.enableLoggingException())
            {
                logger.error("{}.{} execute error.", className, methodName, e);
            }

            throw e;
        }
    }


    /**
     * 获取当前方法信息
     *
     * @param point 切点
     * @return 方法
     */
    private Method getCurrentMethod(ProceedingJoinPoint point)
    {
        try
        {
            Signature signature = point.getSignature();
            MethodSignature methodSignature = (MethodSignature) signature;
            Object target = point.getTarget();
            return target.getClass().getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
        }
        catch (NoSuchMethodException e)
        {
            throw new RuntimeException(e);
        }
    }


    private void logging(Log log, String format, Object... arguments)
    {
        switch (log.logLevel())
        {
        case DEBUG:
            logger.debug(format, arguments);
            break;
        case INFO:
            logger.info(format, arguments);
            break;
        case WARN:
            logger.warn(format, arguments);
            break;
        case TRACE:
            logger.trace(format, arguments);
            break;
        case ERROR:
            logger.error(format, arguments);
            break;
        default:
            logger.info(format, arguments);
        }
    }

}
