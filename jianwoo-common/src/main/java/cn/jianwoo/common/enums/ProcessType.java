package cn.jianwoo.common.enums;

import java.util.HashMap;
import java.util.Map;

import cn.jianwoo.common.annotation.BizEnum;
import cn.jianwoo.common.enums.biz.EnumBO;
import cn.jianwoo.common.utils.MessageUtils;

import cn.hutool.core.util.StrUtil;

/**
 * 进程类型
 * 
 * @author jianwoo
 */
@BizEnum
public enum ProcessType {
    /** 主进程 */
    MAIN_PROCESS("main", "process.type.main"),
    /** 工具进程 */
    TOOL_PROCESS("tool", "process.type.tool"),
    /**  子进程 */
    SUB_PROCESS("sub", "process.type.sub");

    private static final Map<String, ProcessType> MAPPINGS = new HashMap<>(16);

    static
    {
        for (ProcessType type : values())
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
        EnumBO enumBO = new EnumBO("processType", "进程类型");
        for (Map.Entry<String, ProcessType> entry : MAPPINGS.entrySet())
        {
            enumBO.append(entry.getKey(), entry.getValue().getDesc());
        }
        return enumBO;
    }


    ProcessType(String value, String desc)
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
        ProcessType type = MAPPINGS.get(value);
        if (type != null)
        {
            return type.getDesc();
        }
        return "";
    }
}
