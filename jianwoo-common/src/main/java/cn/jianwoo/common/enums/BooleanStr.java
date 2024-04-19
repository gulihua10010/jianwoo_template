package cn.jianwoo.common.enums;

import java.util.HashMap;
import java.util.Map;

import cn.jianwoo.common.annotation.BizEnum;
import cn.jianwoo.common.enums.biz.EnumBO;
import cn.jianwoo.common.utils.MessageUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 布尔值
 * 
 * @author jianwoo
 */
public enum BooleanStr {
    /** 是 */
    TRUE("true", "boolean.str.true"),
    /** 否 */
    FALSE("false", "boolean.str.false");

    private static final Map<String, BooleanStr> MAPPINGS = new HashMap<>(16);

    static
    {
        for (BooleanStr mode : values())
        {
            MAPPINGS.put(mode.value, mode);
        }
    }
    private final String value;
    private final String desc;

    public String getValue()
    {
        return this.value;
    }


    public String getDesc()
    {
        return MessageUtils.message(this.desc);
    }


    BooleanStr(String value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }


    public static String getDesc(String value)
    {
        if (StrUtil.isBlank(value))
        {
            return "";
        }
        BooleanStr mode = MAPPINGS.get(value);
        if (mode != null)
        {
            return mode.getDesc();
        }
        return "";
    }
}
