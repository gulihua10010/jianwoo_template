package cn.jianwoo.common.constant;

public enum CfgType {

    /**
     * email
     */
    EMAIL("email"),
    /**
     * system
     */
    SYSTEM("system"),
    /**
     * 七牛云
     */
    QINIUYUN("qiniuyun"),

    ;

    /**
     * name
     */
    private String value;

    CfgType(String value) {
        this.value = value;
    }


    public String getValue() {
        return this.value;
    }


    public void setValue(String value) {
        this.value = value;
    }
}
