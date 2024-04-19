package cn.jianwoo.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.jianwoo.common.annotation.CpuCoreValid;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 17:55
 */
@Slf4j
public class CpuCoreValidator implements ConstraintValidator<CpuCoreValid, Object>
{

    @Override
    public void initialize(CpuCoreValid constraintAnnotation)
    {
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context)
    {
        if (null == value)
        {
            return true;
        }
        if (value instanceof Integer)
        {
            return (Integer) value > 0;
        }
        return false;
    }

}
