package cn.jianwoo.common.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 入参响应打印日志配置注解
 *
 * @author gulh
 * @date 2021/2/8
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Log {

    /**
     * Whether to enable logging arguments, default is true.
     *
     * @return {@link Boolean}, default is {@link Boolean#TRUE}
     *
     */
    boolean enableLoggingArgs() default true;


    /**
     * Whether to enable logging return, default is true.
     *
     * @return {@link Boolean}, default is {@link Boolean#TRUE}
     */
    boolean enableLoggingReturn() default true;


    /**
     * Whether to enable logging time consuming, default is false.
     *
     * @return {@link Boolean}, default is {@link Boolean#FALSE}
     */
    boolean enableLoggingTimeConsuming() default false;


    /**
     * The value of slow processing threshold which is in milliseconds.<br>
     * If the conditions shown below is , system will enable the slow processing monitoring. <br>
     * {@link #enableLoggingTimeConsuming()} is true <br>
     * {@link #slowProcessingThresholdMills()} > 0 <br>
     * Actual time consuming > {@link #slowProcessingThresholdMills()} <br>
     *
     * @return The value which is in milliseconds, default is 500.
     *
     */
    long slowProcessingThresholdMills() default 500;


    /**
     * Log level for logging args, return, time consuming
     *
     * @return {@link Level#DEBUG}
     */
    Level logLevel() default Level.INFO;


    /**
     * Whether to enable logging exception, default is false.
     *
     * @return {@link Boolean}, default is {@link Boolean#TRUE}
     */
    boolean enableLoggingException() default true;



    /**
     * Whether to enable parameter json printing
     *
     * @return {@link Boolean}, default is {@link Boolean#TRUE}
     */
    boolean enableJSONPrint() default true;

    /**
     * 日志级别
     */
    enum Level {
        /**
         * log.debug()
         */
        DEBUG,

        /**
         * log.info()
         */
        INFO,

        /**
         * log.warn()
         */

        WARN,
        /**
         * log.trace()
         */
        TRACE,

        /**
         * log.error()
         */
        ERROR
    }
}
