package cn.jianwoo.common.enums;

import cn.hutool.core.util.StrUtil;
import cn.jianwoo.common.enums.biz.EnumBO;
import cn.jianwoo.common.utils.MessageUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GuLihua
 * @Description
 * @date 2021-08-24 11:10
 */
public enum ProcessStatus {

    /**
     * 未处理
     */
    INIT("00", "process.status.init"),
    /**
     * 处理中
     */
    PROCESSING("50", "process.status.processing"),

    /**
     * 成功
     */
    SUCCESS("90", "process.status.success"),

    /**
     * 失败
     */
    FAILED("91", "process.status.failed"),

    ;

    private static final Map<String, ProcessStatus> MAPPINGS = new HashMap<>(16);

    static
    {
        for (ProcessStatus type : values())
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
        for (Map.Entry<String, ProcessStatus> entry : MAPPINGS.entrySet())
        {
            enumBO.append(entry.getKey(), entry.getValue().getDesc());
        }
        return enumBO;
    }


    ProcessStatus(String value, String desc)
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
        ProcessStatus type = MAPPINGS.get(value);
        if (type != null)
        {
            return type.getDesc();
        }
        return "";
    }
}
