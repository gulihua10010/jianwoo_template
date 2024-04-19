package cn.jianwoo.common.exception.user;

/**
 * 用户密码不正确或不符合规范异常类
 * 
 * @author jianwoo
 */
public class UserLoginFailedException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserLoginFailedException()
    {
        super("login.failed", null);
    }
    public UserLoginFailedException(String msg)
    {
        super(msg, null);
    }
}
