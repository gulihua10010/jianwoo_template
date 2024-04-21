package cn.jianwoo.common.constant;

public enum CfgType {

    /**
     * email
     */
    EMAIL("EMAIL"),
    /**
     * system
     */
    SYSTEM("SYSTEM"),

    ;

    /**
     * name
     */
    private String value;

    CfgType(String value)
    {
        this.value = value;
    }


    public String getValue()
    {
        return this.value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }
}
