package cn.jianwoo.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cn.jianwoo.common.validator.CpuCoreValidator;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 17:54
 */
@Constraint(validatedBy = { CpuCoreValidator.class })
@Target({ ElementType.FIELD, ElementType.TYPE_USE, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CpuCoreValid {

    String message() default "";


    Class<?>[] groups() default {};


    Class<? extends Payload>[] payload() default {};
}