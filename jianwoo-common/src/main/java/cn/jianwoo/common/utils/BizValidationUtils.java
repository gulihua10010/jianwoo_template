package cn.jianwoo.common.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson2.JSONObject;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import lombok.extern.slf4j.Slf4j;

/**
 * @author GuLihua
 * @Description
 * @date 2020-08-04 16:03
 */
@Slf4j
public class BizValidationUtils
{

    /**
     * 验证字符串是否为空
     *
     * @param paramValue 字符串值
     * @param paramName 字段名
     * @return
     * @author gulihua
     */
    public static void paramValidate(String paramValue, String paramName)
    {
        if (StringUtils.isBlank(paramValue))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("NotBlank", paramName));
        }

    }


    /**
     * 验证List是否为空
     *
     * @param paramValue List值
     * @param paramName 字段名
     * @return
     * @author gulihua
     */
    public static void paramValidate(List paramValue, String paramName)
    {
        if (CollectionUtils.isEmpty(paramValue))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("NotBlank", paramName));

        }

    }


    /**
     * 验证数组是否为空
     *
     * @param paramValue 数组值
     * @param paramName 字段名
     * @return
     * @author gulihua
     */
    public static void paramValidate(Object[] paramValue, String paramName)
    {
        if (null == paramValue || paramName.length() == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("NotBlank", paramName));

        }

    }


    /**
     * 验证字符串是否为JSON
     *
     * @param paramValue 字符串值
     * @param paramName 字段名
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramJSONValidate(String paramValue, String paramName)
    {
        if (StringUtils.isNotBlank(paramValue))
        {
            try
            {
                JSONObject jsonObject = JSONObject.parseObject(paramValue);
            }
            catch (Exception e)
            {
                throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("JsonValid", paramName));

            }

        }

    }


    /**
     * 验证字符串是否为日期yyyy-MM-dd或yyyy-MM-dd HH:mm:ss
     *
     * @param paramValue 字符串值
     * @param paramName 字段名
     * @return
     * @author gulihua
     */
    public static void paramDateOrTimeValidate(String paramValue, String paramName)

    {
        if (StringUtils.isNotBlank(paramValue))
        {
            if (!ReUtil.isMatch(Constants.DATE_REGEX, StringUtils.trim(paramValue))
                    && !ReUtil.isMatch(Constants.DATETIME_REGEX, StringUtils.trim(paramValue)))
            {
                throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("dateValid", paramName));

            }

        }

    }


    /**
     * (最大长度验证)验证字符串是否小于最大长度
     *
     * @param paramValue 字符串值
     * @param length 最大长度
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramLengthValidate(String paramValue, Integer length, String msg)

    {
        if (null != paramValue && paramValue.length() > length)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 验证日期是否在指定范围内
     *
     * @param paramValue 字符串值
     * @param format 日期格式
     * @param rangeFrom 日期开始
     * @param rangeTo 日期几位数
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramDateRangeValidate(String paramValue, String format, Date rangeFrom, Date rangeTo,
            String msg)
    {
        if (null != paramValue)
        {
            Date date = DateUtil.parse(paramValue, format);
            if ((null != rangeFrom && date.before(rangeFrom)) || (null != rangeTo && date.after(rangeTo)))
            {
                throw new E(HttpStatus.BAD_REQUEST, msg);

            }

        }

    }


    /**
     * (最小长度验证)验证字符串是否大于最小长度
     *
     * @param paramValue 字符串值
     * @param length 最小长度(包含)
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramMinLengthValidate(String paramValue, Integer length, String msg)

    {
        if (null != paramValue && paramValue.length() < length)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * (最大长度验证)验证字符串是否小于最大长度
     *
     * @param paramValue 字符串值
     * @param length 最大长度(包含)
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramMaxLengthValidate(String paramValue, Integer length, String msg)

    {
        if (null != paramValue && paramValue.length() > length)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * (长度范围验证)验证字符串是否在范围之内
     *
     * @param paramValue 字符串值
     * @param min 最小长度
     * @param max 最大长度
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramRangeLengthValidate(String paramValue, Integer min, Integer max, String msg)
    {
        if (null != paramValue && !(paramValue.length() >= min && paramValue.length() <= max))
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * (最小数字验证)验证数字是否大于最小数字
     *
     * @param paramValue 字符串值
     * @param min 最小数字
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramNumberMinValidate(String paramValue, String min, String msg)

    {
        BigDecimal v;
        try
        {
            v = new BigDecimal(paramValue);
        }
        catch (Exception e)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }
        BigDecimal minV;
        try
        {
            minV = new BigDecimal(min);
        }
        catch (Exception e)
        {
            minV = new BigDecimal("0");
        }
        if (v.compareTo(minV) < 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    public static void paramNumberRangeValidate(Integer paramValue, int min, int max, String msg)

    {
        if (paramValue == null)
        {
            return;
        }
        if (paramValue < min || paramValue > max)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    public static void paramNumberRangeValidate(BigDecimal paramValue, int min, int max, String msg)

    {
        if (paramValue == null)
        {
            return;
        }
        if (paramValue.compareTo(new BigDecimal(min)) < 0 || paramValue.compareTo(new BigDecimal(max)) > 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * (最大数字验证)验证数字是否小于最大数字
     *
     * @param paramValue 字符串值
     * @param max 最大数字
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramNumberMaxValidate(String paramValue, String max, String msg)

    {
        BigDecimal v;
        try
        {
            v = new BigDecimal(paramValue);
        }
        catch (Exception e)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }
        BigDecimal maxV;
        try
        {
            maxV = new BigDecimal(max);
        }
        catch (Exception e)
        {
            maxV = new BigDecimal("0");
        }
        if (v.compareTo(maxV) > 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 字符串正则验证
     *
     * @param paramValue 字符串值
     * @param regex 正则表达式
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramRegexValidate(String paramValue, String regex, String msg)

    {
        if (StringUtils.isNotBlank(paramValue) && !Pattern.matches(regex, paramValue))
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 数字格式验证(验证字符串是否为数字)
     *
     * @param paramValue 数字的字符串值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramNumberValidate(String paramValue, String msg)
    {
        if (StringUtils.isNotBlank(paramValue))
        {
            try
            {
                new BigDecimal(paramValue);
            }
            catch (Exception e)
            {
                throw new E(HttpStatus.BAD_REQUEST, msg);

            }
        }

    }


    /**
     * 整型数字格式验证(验证字符串是否为整型数字)
     *
     * @param paramValue 数字的字符串值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramIntegerValidate(String paramValue, String msg)
    {
        if (StringUtils.isNotBlank(paramValue))
        {
            try
            {
                Integer.parseInt(paramValue);
            }
            catch (Exception e)
            {
                throw new E(HttpStatus.BAD_REQUEST, msg);

            }
        }

    }


    /**
     * 验证对象是否为空
     *
     * @param paramValue 对象值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramValidate(Object paramValue, String msg)
    {
        if (null == paramValue)
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 验证日期格式
     *
     * @param paramValue 对象值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramDateValidate(String paramValue, String msg)
    {
        if (StringUtils.isNotBlank(paramValue) && !ReUtil.isMatch(Constants.DATE_REGEX, StringUtils.trim(paramValue)))
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 验证日期时间格式
     *
     * @param paramValue 对象值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramDateTimeValidate(String paramValue, String msg)
    {
        if (StringUtils.isNotBlank(paramValue)
                && !ReUtil.isMatch(Constants.DATETIME_REGEX, StringUtils.trim(paramValue)))
        {
            throw new E(HttpStatus.BAD_REQUEST, msg);

        }

    }


    /**
     * 验证对象是否在数组范围内
     *
     * @param paramValue 对象值
     * @param msg 错误提示消息
     * @param values 数组范围
     * @return
     * @author gulihua
     */
    public static void paramRangeValidate(Object paramValue, String msg, Object... values)

    {
        if (paramValue instanceof String && StrUtil.isBlank((CharSequence) paramValue))
        {
            return;
        }
        boolean valid = false;
        if (null != paramValue)
        {
            for (Object o : values)
            {
                if (paramValue.equals(o))
                {
                    valid = true;
                    break;
                }
            }
            if (!valid)
            {
                throw new E(HttpStatus.BAD_REQUEST, msg);

            }
        }

    }


    /**
     * 验证List内容是否为空
     *
     * @param paramValue 字符串 List值
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramValidateListContent(List<String> paramValue, String msg)

    {
        if (!CollectionUtils.isEmpty(paramValue))
        {
            for (String s : paramValue)
            {
                if (StringUtils.isBlank(s))
                {
                    throw new E(HttpStatus.BAD_REQUEST, msg);

                }
            }

        }

    }


    /**
     * 验证文件最大的长度
     *
     * @param fileObj 文件对象
     * @param maxSize 最大长度
     * @param msg 错误提示消息
     * @return
     * @author gulihua
     */
    public static void paramFileSizeValidate(MultipartFile fileObj, Long maxSize, String msg)
    {
        if (null != fileObj)
        {
            if (fileObj.getSize() > maxSize)
            {
                throw new E(HttpStatus.BAD_REQUEST, msg);

            }
        }

    }

}
