package cn.jianwoo.common.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import cn.jianwoo.common.annotation.OtherAffect;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.ServletUtils;
import cn.jianwoo.common.utils.ValidatorUtils;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 14:25
 */
public class OtherAffectValidator implements ConstraintValidator<OtherAffect, Object>
{

    private String[] columnValue;

    private String column;

    private boolean isCheck;

    private String[] allowedValues;

    private String[] notAllowedValues;

    private static Validator validator;

    /**
     * 初始化数据
     *
     * @param constraintAnnotation OtherAffect注解实例
     * @return void
     **/
    @Override
    public void initialize(OtherAffect constraintAnnotation)
    {
        columnValue = constraintAnnotation.columnValue();
        column = constraintAnnotation.column();
        isCheck = constraintAnnotation.isCheck();
        allowedValues = constraintAnnotation.allowedValues();
        notAllowedValues = constraintAnnotation.notAllowedValues();
        // 获取校验Validator
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }


    /**
     * 校验逻辑方法
     *
     * @param o 当前字段的值
     * @param context ConstraintValidatorContext校验上下文
     * @return boolean
     **/
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext context)
    {
        // 获取column的请求值,为空的话校验失败
        String columnRequestValue = getColumnRequestValue();
        if (StrUtil.isBlank(columnRequestValue))
        {
            return true;
        }

        // 如果column的值存在于columnValue中
        if (Arrays.asList(columnValue).contains(columnRequestValue))
        {
            // 被注解字段的值为空直接校验不通过
            if (ObjectUtil.isEmpty(o))
            {
                return ValidatorUtils.getResult(MessageUtils.message("not.empty"), context);
            }
            // notAllowedValues、allowedValues存在情况
            boolean b = (notAllowedValues != null && notAllowedValues.length > 0)
                    || (allowedValues != null && allowedValues.length > 0);
            if (b)
            {
                String validResult = ValidatorUtils.validateValues(allowedValues, notAllowedValues, o);
                return ValidatorUtils.getResult(validResult, context);
            }

            // 如果开启校验
            if (isCheck)
            {
                return validObject(o, context);
            }
        }
        return true;
    }


    /**
     * 获取column的请求值
     *
     * @return String
     **/
    private String getColumnRequestValue()
    {
        String paramValue = ServletUtils.getParameter(column);
        // 如果从param获取不到,再找body
        if (StrUtil.isBlank(paramValue))
        {
            HttpServletRequest request = ServletUtils.getRequest();
            // 获取column请求参数值
            String body = ServletUtil.getBody(request);
            if (StrUtil.isNotBlank(body))
            {
                JSONObject jsonObject = JSONUtil.parseObj(body);
                paramValue = String.valueOf(jsonObject.get(column));
            }
        }
        return paramValue;
    }


    /**
     * 校验传入对象
     *
     * @param o 当前字段的值
     * @param context ConstraintValidatorContext校验上下文
     * @return boolean
     **/
    private boolean validObject(Object o, ConstraintValidatorContext context)
    {
        // 定义错误信息
        StringBuffer errorMsg = new StringBuffer();
        boolean result = true;
        // 当被注解属性为列表时
        if (o instanceof ArrayList<?>)
        {
            List<Set<ConstraintViolation<Object>>> collect = new ArrayList<>();
            for (Object oItem : (List<?>) o)
            {
                Set<ConstraintViolation<Object>> constraintViolations = validator.validate(oItem);
                collect.add(constraintViolations);
            }
            result = getListResult(collect);
            ValidatorUtils.getListInfo(errorMsg, collect);
        }
        else
        {
            // 当被注解属性为单个对象时
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(o);
            result = !constraintViolations.isEmpty();
            ValidatorUtils.getOneInfo(errorMsg, constraintViolations);
        }

        // 把自定义返回错误信息写入上下文
        if (!result)
        {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMsg.toString()).addConstraintViolation();
        }
        return result;
    }


    private boolean getListResult(List<Set<ConstraintViolation<Object>>> collect)
    {
        boolean result = true;
        for (Set<ConstraintViolation<Object>> constraintViolations : collect)
        {
            result = !constraintViolations.isEmpty();
            if (!result){
                return result;
            }

        }
        return result;
    }
}
