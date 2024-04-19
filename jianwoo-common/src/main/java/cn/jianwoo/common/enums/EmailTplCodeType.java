package cn.jianwoo.common.enums;

/***
 * 邮件模板类型
 */
public enum EmailTplCodeType {

    /** 服务器过期通知 **/
    SERVER_EXPIRATION("SERVER_EXPIRATION", "服务器过期通知"),

    ;

    /** 值 */
    private String value;
    /** 描述 */
    private String desc;

    public String getValue()
    {
        return this.value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }


    public String getDesc()
    {
        return this.desc;
    }


    public void setDesc(String desc)
    {
        this.desc = desc;
    }


    public static String getDesc(String value)
    {
        for (EmailTplCodeType type : EmailTplCodeType.values())
        {
            if (type.value.equals(value))
            {
                return type.getDesc();
            }
        }
        return "";
    }


    EmailTplCodeType(String value, String desc)
    {
        this.value = value;
        this.desc = desc;
    }
}
