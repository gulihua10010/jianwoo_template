package cn.jianwoo.common.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-05 14:07
 */
public class ValidatorUtils
{

    /**
     * 验证器工程
     */
    private static ValidatorFactory factory;
    /**
     * 对象验证器
     */
    public static Validator validator;
    /**
     * 方法验证器
     */
    public static ExecutableValidator executableValidator;

    static
    {
        initValidator();
        clean();
    }

    /**
     * 初始化ValidatorFactory和Validator
     **/
    public static void initValidator()
    {
        factory = Validation.byProvider(HibernateValidator.class).configure().failFast(true).buildValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * 初始化ValidatorFactory和ExecutableValidator
     **/
    public static void initExecutableValidator()
    {
        factory = Validation.buildDefaultValidatorFactory();
        executableValidator = factory.getValidator().forExecutables();
    }


    /**
     * 关闭ValidatorFactory工厂
     **/
    public static void clean()
    {
        factory.close();
    }


    /**
     * 对类中的某方法参数校验
     **/
    public static <T> Set<ConstraintViolation<T>> validMethod(T t, Method method, Object[] parameterValues)
    {
        return executableValidator.validateParameters(t, method, parameterValues);
    }


    /**
     * 校验对象
     *
     * @Param [object：待检验对象, groups：对象分组]
     **/
    public static void validateObject(Object object, Class<?>... groups)
    {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(object, groups);
        if (CollectionUtil.isNotEmpty(constraintViolations))
        {
            String errorMsg = MessageUtils.message("param.valid.exception", object.getClass().getSimpleName(),
                    getErrorMsg(constraintViolations));
            throw new E(HttpStatus.BAD_REQUEST, errorMsg);
        }

    }


    /**
     * 校验对象列表
     *
     * @param objectList 待校验对象列表
     * @param groups 校验分组
     **/
    public static void validateObjectList(List<Object> objectList, Class<?>... groups)
    {
        for (Object o : objectList)
        {
            validateObject(o, groups);
        }
    }


    /**
     * 校验填入值是否合法 目前用于：DictValidator、EnumValidator
     *
     * @param allowedValues 允许填入值数组(在codeValues再)
     * @param notAllowedValues 不允许填入值数组
     * @param value 当前填入值须校验的值
     * @return String
     **/
    public static String validateValues(String[] allowedValues, String[] notAllowedValues, Object value)
    {
        // notAllowedValues存在情况
        if (notAllowedValues != null && notAllowedValues.length > 0)
        {
            List<String> notAllowedList = Arrays.asList(notAllowedValues);
            if (notAllowedList.contains(String.valueOf(value)))
            {
                return MessageUtils.message("param.value.illegal", notAllowedList);
            }
        }

        // allowedValues存在情况
        if (allowedValues != null && allowedValues.length > 0)
        {
            List<String> allowedList = Arrays.asList(allowedValues);
            if (!allowedList.contains(String.valueOf(value)))
            {
                return MessageUtils.message("param.value.only.in.range", Arrays.toString(allowedValues));
            }
        }
        return "";
    }


    /**
     * 校验填入值是否合法 目前用于：DictValidator、EnumValidator
     *
     * @param allowedValues 允许填入值数组(在codeValues再)
     * @param notAllowedValues 不允许填入值数组
     * @param value 当前填入值须校验的值
     * @param codeValues 默认可填值
     * @return String
     **/
    public static String validateValues(String[] allowedValues, String[] notAllowedValues, Object value,
            List<Object> codeValues)
    {
        // notAllowedValues存在情况
        if (notAllowedValues != null && notAllowedValues.length > 0)
        {
            List<String> notAllowedList = Arrays.asList(notAllowedValues);
            codeValues.removeAll(notAllowedList);
            if (notAllowedList.contains(String.valueOf(value)))
            {
                return MessageUtils.message("param.value.illegal", notAllowedList);
            }
        }

        // allowedValues存在情况
        if (allowedValues != null && allowedValues.length > 0)
        {
            List<String> allowedList = Arrays.asList(allowedValues);
            // 将codeValues统一转成String
            List<String> stringCodeValues = codeValues.stream().map(String::valueOf).collect(Collectors.toList());
            if (!stringCodeValues.containsAll(allowedList))
            {
                // @VerifyEnum填入allowedValues存在非枚举code值
                throw new E(MessageUtils.message("param.allowedValues.illegal"));
            }
            else
            {
                if (allowedList.contains(String.valueOf(value)))
                {
                    return "";
                }
                else
                {
                    return MessageUtils.message("param.value.only.in.range", Arrays.toString(allowedValues));
                }
            }
        }

        // 校验字段值是否是字典允许数据
        if (codeValues.contains(value))
        {
            return "";
        }
        else
        {
            // 重置错误提示
            return MessageUtils.message("param.value.only.in.range", Arrays.toString(allowedValues));
        }
    }


    /**
     * 获取校验错误消息
     * 
     * @param c
     * @return
     */
    public static String getErrorMsg(Set<ConstraintViolation<Object>> c)
    {
        StringBuffer msg = new StringBuffer();
        if (CollectionUtil.isNotEmpty(c))
        {
            for (ConstraintViolation<Object> constraintViolation : c)
            {
                String itemMessage = constraintViolation.getMessage();
                String itemName = constraintViolation.getPropertyPath().toString();
                msg.append(MessageUtils.message("param.field.error.msg", itemName, itemMessage));
            }
        }
        return msg.toString();
    }


    /**
     * 拼装单个对象校验信息
     *
     * @Param [s, c]
     * @return void
     **/
    public static void getOneInfo(StringBuffer s, Set<ConstraintViolation<Object>> c)
    {
        if (CollectionUtil.isNotEmpty(c))
        {
            s.append("{ ");
            for (ConstraintViolation<Object> constraintViolation : c)
            {
                String itemMessage = constraintViolation.getMessage();
                String itemName = constraintViolation.getPropertyPath().toString();
                s.append(MessageUtils.message("param.field.error.msg", itemName, itemMessage));
            }
            s.append(" }");
        }
    }


    /**
     * 拼装多个对象校验信息
     *
     * @Param [s, collect]
     * @return void
     **/
    public static void getListInfo(StringBuffer s, List<Set<ConstraintViolation<Object>>> collect)
    {
        for (int i = 0; i < collect.size(); i++)
        {
            Set<ConstraintViolation<Object>> constraintViolations = collect.get(i);
            if (CollectionUtil.isNotEmpty(constraintViolations))
            {
                s.append("[");
                s.append(MessageUtils.message("param.list.error.msg", i));
                getOneInfo(s, constraintViolations);
                s.append(" ]");
            }
        }
    }


    /**
     * 注解校验,获取处理校验结果
     *
     * @param errorMsg 错误信息
     * @param context 校验上下文
     * @return boolean
     **/
    public static boolean getResult(String errorMsg, ConstraintValidatorContext context)
    {
        if (StrUtil.isNotBlank(errorMsg))
        {
            // 重置错误提示
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(errorMsg).addConstraintViolation();
            return false;
        }
        return true;
    }
}
