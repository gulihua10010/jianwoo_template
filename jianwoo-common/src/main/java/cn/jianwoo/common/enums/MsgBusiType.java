package cn.jianwoo.common.enums;

import java.util.HashMap;
import java.util.Map;

import cn.jianwoo.common.annotation.BizEnum;
import cn.jianwoo.common.enums.biz.EnumBO;
import cn.jianwoo.common.utils.MessageUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 通知业务类型
 * 
 * @author jianwoo
 */
@BizEnum
public enum MsgBusiType {
    /** 项目 */
    PROJECT("10", "msg.busi.type.project"),



    ;

    private static final Map<String, MsgBusiType> MAPPINGS = new HashMap<>(16);

    static
    {
        for (MsgBusiType type : values())
        {
            MAPPINGS.put(type.value, type);
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


    public static EnumBO getEnumList()
    {
        EnumBO enumBO = new EnumBO("MsgBusiType", "通知业务类型");
        for (Map.Entry<String, MsgBusiType> entry : MAPPINGS.entrySet())
        {
            enumBO.append(entry.getKey(), entry.getValue().getDesc());
        }
        return enumBO;
    }


    MsgBusiType(String value, String desc)
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
        MsgBusiType type = MAPPINGS.get(value);
        if (type != null)
        {
            return type.getDesc();
        }
        return "";
    }
}
