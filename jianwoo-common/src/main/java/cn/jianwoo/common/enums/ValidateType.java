package cn.jianwoo.common.enums;

public enum ValidateType {

    /**
     * 字符串最大长度验证
     */
    MAX_LENGTH("maxLength"),




    /**
     * 整型数字
     */
    INTEGER("integer"),


    /**
     * 数字
     */
    NUMBER("number"),

    /**
     * 正则验证
     */
    REGEX("regex"),

    ;

    /**
     * value
     */
    private String value;

    ValidateType(String value) {
        this.value = value;
    }


    public static ValidateType getEnum(Integer name) {
        ValidateType[] arry = ValidateType.values();
        for (int i = 0; i < arry.length; i++) {
            if (arry[i].name().equals(name)) {
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
