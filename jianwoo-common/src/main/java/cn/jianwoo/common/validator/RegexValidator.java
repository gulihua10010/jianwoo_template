package cn.jianwoo.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cn.jianwoo.common.annotation.RegexValid;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.ValidatorUtils;

import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 17:55
 */
@Slf4j
public class RegexValidator implements ConstraintValidator<RegexValid, Object>
{
    private String regex;

    private String message;
    private String messageCode;

    @Override
    public void initialize(RegexValid constraintAnnotation)
    {
        regex = constraintAnnotation.regex();
        message = constraintAnnotation.message();
        messageCode = constraintAnnotation.messageCode();
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
            boolean isMatch = ReUtil.isMatch(this.regex, (String) value);
            if (!isMatch)
            {
                if (StrUtil.isNotBlank(messageCode))
                {
                    return ValidatorUtils.getResult(MessageUtils.message(this.messageCode), context);
                }
                if (StrUtil.isNotBlank(message))
                {
                    return ValidatorUtils.getResult(message, context);
                }
                return ValidatorUtils.getResult(MessageUtils.message("regex.invalid"), context);
            }
            return true;
        }
        return false;
    }

}
