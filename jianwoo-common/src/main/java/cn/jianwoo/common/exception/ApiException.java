package cn.jianwoo.common.exception;

import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.utils.MessageUtils;

/**
 * Api异常
 * 
 * @author jianwoo
 */
public final class ApiException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    /**
     * api错误信息
     */
    private String apiMessage;

    /**
     * 空构造方法，避免反序列化问题
     */
    public ApiException()
    {
    }


    public ApiException(String msg, String apiMessage)
    {
        super(msg);
        StringBuilder message = new StringBuilder(msg);
        message.append(", ");
        message.append(MessageUtils.message("error.message"));
        message.append(apiMessage);
        this.code = HttpStatus.BAD_REQUEST;
        this.message = message.toString();
    }


    @Override
    public String getMessage()
    {
        return message;
    }


    public Integer getCode()
    {
        return code;
    }

}