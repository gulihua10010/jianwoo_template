package cn.jianwoo.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务操作类型
 *
 * @author jianwoo
 */
public enum BusinessType {
    /**
     * 其它
     */
    OTHER(0, "business.type.other"),

    /**
     * 新增
     */
    INSERT(1, "business.type.insert"),

    /**
     * 修改
     */
    UPDATE(2, "business.type.update"),

    /**
     * 删除
     */
    DELETE(3, "business.type.delete"),

    /**
     * 授权
     */
    GRANT(4, "business.type.grant"),

    /**
     * 导出
     */
    EXPORT(5, "business.type.export"),

    /**
     * 导入
     */
    IMPORT(6, "business.type.import"),

    /**
     * 强退
     */
    FORCE(7, "business.type.force"),

    /**
     * 生成代码
     */
    GENCODE(8, "business.type.gencode"),

    /**
     * 清空数据
     */
    CLEAN(9, "business.type.clean"),

    /**
     * 分配成员
     */
    ASSIGN_MEMBER(10, "business.type.assign.member"),

    /**
     * 分配主管
     */
    ASSIGN_LEADER(11, "business.type.assign.leader"),

    /**
     * 分配资源
     */
    ASSIGN_RESOURCE(12, "business.type.assign.resource"),
    ;
    private static final Map<Integer, BusinessType> MAPPINGS = new HashMap<>(16);

    static {
        for (BusinessType type : values()) {
            MAPPINGS.put(type.value, type);
        }
    }

    private final int value;
    private final String desc;

    public int getValue() {
        return this.value;
    }


    public String getDesc() {
        return this.desc;
    }


    BusinessType(int value, String desc) {

        this.value = value;
        this.desc = desc;
    }


    public static String getDesc(int value) {
        BusinessType type = MAPPINGS.get(value);
        if (type == null) {
            return "";
        }
        return type.desc;
    }
}
