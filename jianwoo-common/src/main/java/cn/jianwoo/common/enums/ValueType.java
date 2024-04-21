package cn.jianwoo.common.enums;

public enum ValueType {

    /**
     * 字符串
     */
    STRING("S","字符串"),

    /**
     * 浮点型
     */
    FLOAT("F","浮点型"),


    /**
     * 整型
     */
    INTEGER("I","整型"),

    /**
     * 日期
     */
    DATE("D","日期"),

    /**
     * 布尔
     */
    BOOLEAN("B","布尔"),

    ;

    /**
     * value
     */
    private String value;
    private String desc;

    ValueType(String value) {
        this.value = value;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    ValueType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static ValueType getEnum(String value) {
        ValueType[] arry = ValueType.values();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i].value.equals(value)) {
                return arry[i];
            }
        }
        return null;
    }


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }

}
