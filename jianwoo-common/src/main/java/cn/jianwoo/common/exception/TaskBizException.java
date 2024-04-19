package cn.jianwoo.common.exception;

import cn.jianwoo.common.constant.HttpStatus;

/**
 * 任务异常
 * 
 * @author jianwoo
 */
public final class TaskBizException extends RuntimeException
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
     * 空构造方法，避免反序列化问题
     */
    public TaskBizException()
    {
    }


    public TaskBizException(Throwable cause)
    {
        super(cause);
        this.message = cause == null ? null : cause.getMessage();
    }


    public TaskBizException(String msg, Object... args)
    {
        super(args == null || args.length == 0 ? msg : String.format(msg, args));
        this.code = HttpStatus.BAD_REQUEST;
        this.message = args == null || args.length == 0 ? msg : String.format(msg, args);
    }


    public TaskBizException(Integer code, String msg, Object... args)
    {
        super(args == null || args.length == 0 ? msg : String.format(msg, args));
        this.code = code;
        this.message = args == null || args.length == 0 ? msg : String.format(msg, args);
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