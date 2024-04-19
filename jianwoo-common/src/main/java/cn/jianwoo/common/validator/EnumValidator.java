package cn.jianwoo.common.validator;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.annotation.EnumValid;

import cn.hutool.core.util.StrUtil;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.ValidatorUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 17:55
 */
@Slf4j
public class EnumValidator implements ConstraintValidator<EnumValid, Object>
{

    /** 枚举需要校验的属性名 **/
    private static final String DEFAULT_FIELD = "code";
    /** 枚举类 */
    private Class<?> clazz;
    /** 比较的属性 */
    private String field;

    @Override
    public void initialize(EnumValid constraintAnnotation)
    {
        this.clazz = constraintAnnotation.target();
        this.field = constraintAnnotation.field();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context)
    {
        if (null == value)
        {
            return true;
        }
        if (value instanceof CharSequence && StrUtil.isBlank((CharSequence) value))
        {
            return true;
        }

        if (!clazz.isEnum())
        {
            return ValidatorUtils.getResult(MessageUtils.message("EnumValid"), context);

        }

        Object[] enumOptions = clazz.getEnumConstants();
        List<String> valueList = new ArrayList<>();

        try
        {
            Method method;
            if (StrUtil.equals(field, DEFAULT_FIELD))
            {
                method = clazz.getMethod(field);
            }
            else
            {
                String getMethodName = "get" + upperCaseFirstChar(this.field);
                method = clazz.getMethod(getMethodName);
            }
            for (Object obj : enumOptions)
            {
                Object code = method.invoke(obj, null);
                valueList.add(String.valueOf(code));
            }

            for (Object obj : enumOptions)
            {
                Object code = method.invoke(obj, null);
                if (StrUtil.equals(String.valueOf(value), String.valueOf(code)))
                {
                    return true;
                }
            }
        }
        catch (Exception e)
        {
            log.error(">>>>EnumValidator.isValid exec failed, e:", e);
            return ValidatorUtils.getResult(MessageUtils.message("EnumValid"), context);
        }

        return ValidatorUtils.getResult(MessageUtils.message("EnumValid.value.only.in.range", valueList), context);

    }


    private static String upperCaseFirstChar(String str)
    {
        char[] cs = str.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }

}
