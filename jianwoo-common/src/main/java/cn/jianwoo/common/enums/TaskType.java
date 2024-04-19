package cn.jianwoo.common.enums;

public enum TaskType {

    /**
     * 发送邮件
     */
    D00001("D00001", "发送邮件"),

    /**
     * 重新发送邮件
     */
    D00002("D00002", "重新发送邮件"),
    ;

    public String getValue()
    {
        return this.value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }


    TaskType(String value)
    {
        this.value = value;
    }


    TaskType(String value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }


    public String getDesc()
    {
        return this.desc;
    }


    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    private String value;
    private String desc;

}
