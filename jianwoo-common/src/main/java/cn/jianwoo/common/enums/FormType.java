package cn.jianwoo.common.enums;

public enum FormType {

    /**
     * 文本输入框 input[type='text']
     */
    INPUT_TEXT("input_text"),

    /**
     * 文本框 textarea
     */
    TEXTAREA("textarea"),

    /**
     * 图片上传按钮 input[type='file']
     */
    INPUT_FILE_IMAGE("input_file_image"),

    /**
     * 数字输入框 input[type='text'](number)
     */
    INPUT_TEXT_NUMBER("input_text_number"),

    /**
     * checkBox 开关 input[type='checkbox']/switch
     */
    INPUT_CHECKBOX("input_checkbox"),

    /**
     * checkBox 复选框
     */
    MULTI_CHECKBOX("multi_checkbox"),

    /**
     * select选择框 select
     */
    SELECT("select"),

    /**
     * 单选框 input[type='radio']
     */
    RADIO("radio"),;

    /**
     * value
     */
    private String value;

    FormType(String value)
    {
        this.value = value;
    }


    public static FormType getEnum(Integer name)
    {
        FormType[] arry = FormType.values();
        for (int i = 0; i < arry.length; i++)
        {
            if (arry[i].name().equals(name))
            {
                return arry[i];
            }
        }
        return null;
    }


    public String getValue()
    {
        return value;
    }


    public void setValue(String value)
    {
        this.value = value;
    }

}
