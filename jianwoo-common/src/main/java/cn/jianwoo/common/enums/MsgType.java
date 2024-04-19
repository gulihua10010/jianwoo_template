package cn.jianwoo.common.enums;

import java.util.HashMap;
import java.util.Map;

import cn.jianwoo.common.annotation.BizEnum;
import cn.jianwoo.common.enums.biz.EnumBO;
import cn.jianwoo.common.utils.MessageUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 通知类型
 * 
 * @author jianwoo
 */
@BizEnum
public enum MsgType {
    /** 任务通知 */
    NOTIFICATION("10", "msg.type.notification"),
    /**  资源调整 */
    RESOURCE_ADJUSTMENT("20", "msg.type.resource.adjustment");

    private static final Map<String, MsgType> MAPPINGS = new HashMap<>(16);

    static
    {
        for (MsgType type : values())
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
        EnumBO enumBO = new EnumBO("MsgType", "通知类型");
        for (Map.Entry<String, MsgType> entry : MAPPINGS.entrySet())
        {
            enumBO.append(entry.getKey(), entry.getValue().getDesc());
        }
        return enumBO;
    }


    MsgType(String value, String desc)
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
        MsgType type = MAPPINGS.get(value);
        if (type != null)
        {
            return type.getDesc();
        }
        return "";
    }
}
