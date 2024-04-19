package cn.jianwoo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.jianwoo.common.validator.RegexValidator;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 14:24
 */

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { RegexValidator.class })
public @interface RegexValid {

    /**
     * 正则
     */
    String regex();


    /**
     * 自定义错误信息
     */
    String message() default "";


    /**
     * 自定义错误信息国际化代码
     */
    String messageCode() default "";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}
