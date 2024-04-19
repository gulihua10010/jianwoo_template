package cn.jianwoo.common.validator;

import java.util.Locale;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.jianwoo.common.annotation.MemSizeValid;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 17:55
 */
@Slf4j
public class MemSizeValidator implements ConstraintValidator<MemSizeValid, Object>
{

    @Override
    public void initialize(MemSizeValid constraintAnnotation)
    {
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
        if (value instanceof String)
        {
            return isMemSize((String) value);
        }
        return false;
    }


    private static boolean isMemSize(String maxSize)
    {
        return ReUtil.isMatch("^\\d+(K|KB|M|MB|G|GB|T|TB)$", maxSize.toUpperCase(Locale.ROOT));

    }

}
