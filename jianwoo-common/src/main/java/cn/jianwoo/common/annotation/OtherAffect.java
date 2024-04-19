package cn.jianwoo.common.annotation;


import cn.jianwoo.common.validator.OtherAffectValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 14:24
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(OtherAffect.List.class)
@Constraint(validatedBy = {OtherAffectValidator.class})
public @interface OtherAffect {

    /**
     * 决定该字段是否需要校验的字段名
     */
    String column();

    /**
     * column的会触发该校验的条件值
     **/
    String[] columnValue();

    /**
     * 条件触发时,只允许填的值(被注解属性不为对象)
     */
    String[] allowedValues() default { };

    /**
     * 条件触发时,不允许填的值(被注解属性不为对象)
     */
    String[] notAllowedValues() default { };

    /**
     * 自定义错误信息
     */
    String message() default "";

    /**
     * 是否校验属性,开启则对其校验,不开启只判空。(一般需要校验对象或是对象列表时使用,默认关闭)
     */
    boolean isCheck() default false;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List {
        OtherAffect[] value();
    }

}
