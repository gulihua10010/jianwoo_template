package cn.jianwoo.common.enums;

/**
 * 操作人类别
 * 
 * @author jianwoo
 */
public enum OperatorType
{
    /**
     * 其它
     */
    OTHER (0,"operator.type.other"),

    /**
     * 后台用户
     */
    MANAGE (1,"operator.type.manage"),

    /**
     * 手机端用户
     */
    MOBILE (2,"operator.type.mobile"),;


    private final int value;
    private final String desc;

    public int getValue()
    {
        return this.value;
    }


    public String getDesc()
    {
        return this.desc;
    }


    OperatorType(int value, String desc)
    {

        this.value = value;
        this.desc = desc;
    }
}
