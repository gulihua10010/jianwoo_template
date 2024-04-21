package cn.jianwoo.common.constant;

/**
 * 缓存的key 常量
 *
 * @author jianwoo
 */
public class CacheConstants {
    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "login_tokens:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "captcha_codes:";


    /**
     * 网站配置
     */
    public final static String SYSTEM_CONFIG_KEY = "system:web:config:{0}";
    public final static String SYS_CONFIG_KEY = "system:web:config:";
    /**
     * 网站配置类型
     */
    public final static String SYSTEM_CONFIG_TYPE = "system:web:config:type:{0}";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";

    /**
     * 防重提交 redis key
     */
    public static final String REPEAT_SUBMIT_KEY = "repeat_submit:";

    /**
     * 限流 redis key
     */
    public static final String RATE_LIMIT_KEY = "rate_limit:";

    /**
     * 登录账户密码错误次数 redis key
     */
    public static final String PWD_ERR_CNT_KEY = "pwd_err_cnt:";

}
