package cn.jianwoo.common.enums;

import io.jsonwebtoken.Claims;

/**
 * 通用常量信息
 * 
 * @author jianwoo
 */
public class Constants
{

    /**
     * 配置参数加密关键词
     */
    public static final String SECRET = "secret";

    /**
     * LDAP
     */
    public static final String LDAP = "ldap";
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";

    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";

    /**
     * 空字符串
     */
    public static final String BLACK = "";

    /**
     * www主域
     */
    public static final String WWW = "www.";

    /**
     * http请求
     */
    public static final String HTTP = "http://";

    /**
     * https请求
     */
    public static final String HTTPS = "https://";

    /**
     * 通用成功标识
     */
    public static final String SUCCESS = "0";

    /**
     * 通用失败标识
     */
    public static final String FAIL = "1";

    /**
     * 登录成功
     */
    public static final String LOGIN_SUCCESS = "Success";

    /**
     * 注销
     */
    public static final String LOGOUT = "Logout";

    /**
     * 注册
     */
    public static final String REGISTER = "Register";

    /**
     * 登录失败
     */
    public static final String LOGIN_FAIL = "Error";

    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION = 2;

    /**
     * 令牌
     */
    public static final String TOKEN = "token";

    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";

    /**
     * 令牌前缀
     */
    public static final String LOGIN_USER_KEY = "login_user_key";

    /**
     * 用户ID
     */
    public static final String JWT_USERID = "userid";

    /**
     * 用户名称
     */
    public static final String JWT_USERNAME = Claims.SUBJECT;

    /**
     * 用户头像
     */
    public static final String JWT_AVATAR = "avatar";

    /**
     * 创建时间
     */
    public static final String JWT_CREATED = "created";

    /**
     * 用户权限
     */
    public static final String JWT_AUTHORITIES = "authorities";
    /** 系统标识 */
    public static final String SYSTEM = "system";

    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";

    /**
     * RMI 远程方法调用
     */
    public static final String LOOKUP_RMI = "rmi:";

    /**
     * LDAP 远程方法调用
     */
    public static final String LOOKUP_LDAP = "ldap:";

    /**
     * LDAPS 远程方法调用
     */
    public static final String LOOKUP_LDAPS = "ldaps:";

    /**
     * 定时任务白名单配置（仅允许访问的包名，如其他需要可以自行添加）
     */
    public static final String[] JOB_WHITELIST_STR = { "cn.jianwoo" };

    /**
     * 定时任务违规的字符
     */
    public static final String[] JOB_ERROR_STR = { "java.net.URL", "javax.naming.InitialContext", "org.yaml.snakeyaml",
            "org.springframework", "org.apache", "cn.jianwoo.common.utils.file", "cn.jianwoo.common.config" };

    public static final String COMMA_SEPARATOR = ",";
    public static final String ALIYUN_ECS_IMAGE_IMPORT_ROLE_POLICY = "AliyunECSImageImportRolePolicy";
    public static final String ALIYUN_ECS_IMAGE_IMPORT_DEFAULT_ROLE = "AliyunECSImageImportDefaultRole";

    public static final String DELAYED_ROUTE = "DELAYED_ROUTE";
    public static final String DEAD_ROUTE = "DEAD_ROUTE";

    public static final String YES = "Y";
    public static final String NO = "N";
    public static final String TRUE = "TRUE";
    public static final String FALSE = "FALSE";
    public static final String TRUE_1 = "1";
    public static final String FALSE_0 = "0";

    public static final String ONE = "1";
    public static final String ZERO = "0";
    public static final String FAILED = "FAILED";

    public static final String NEGATIVE_ONE = "-1";

    public static final String URL_SEPARATOR = "/";
    public static final String BLANK = "";
    public static final String SPACE = " ";
    public static final String SEMICOLON = ";";
    public static final String FILE_END_LINE = "\r\n";
    public static final String ELLIPSIS = "...";
    public static final String URL_PARAM_PREFIX = "?";
    public static final String SYMBOL_AMD = "&";
    public static final String SYMBOL_EQUALS = "=";

    public static final String SYMBOL_PERCENT = "%";
    public static final String SYMBOL_AIT = "@";
    public static final String DEFAULT_CHARSET = "UTF-8";
    public static final String HASH_ALGORITHM = "MD5";
    public static final String CONTENT_TYPE_JSON = "application/json;charset=UTF-8";

    public static final String SEPARATE_HYPHEN = "_";
    public static final String FILE_POINT = ".";
    // asterisk
    public static final String ASTERISK = "*";
    // Protocol
    public static final String FILE_PROTOCOL = "file:";

    public static final String BLOG_AUTHOR = "博主";
    public static final String UNKNOW = "未知";
    public static final String ANAONYMOUS = "匿名";
    public static final String ALL = "ALL";
    public static final String RESOURCE_URL = "/res/";
    public static final String PROTOCOL_HTTPS = "https";
    public static final String SIGN_TYPE_RSA2 = "RSA2";
    public static final String SIGN_TYPE_RSA = "RSA";

    // validate length
    public static final Integer TITLE_LENGTH = 100;
    public static final Integer AUTHOR_LENGTH = 10;
    public static final Integer TAGS_LENGTH = 15;

    public static final Integer MENU_TEXT_LENGTH = 10;
    public static final Integer MENU_NAME_LENGTH = 20;
    public static final Integer URL_LENGTH = 100;
    public static final Integer NICK_LENGTH = 20;
    public static final Integer EMAIL_LENGTH = 30;

    public static final Integer COMMENT_MIN_CONTENT_LENGTH = 5;
    public static final Integer COMMENT_MAX_CONTENT_LENGTH = 200;

    public static final Integer MESSAGE_BOARD_MIN_CONTENT_LENGTH = 5;
    public static final Integer MESSAGE_BOARD_MAX_CONTENT_LENGTH = 200;
    // reg
    public static final String MENU_NAME_REGEX = "^[_#$@\\d\\w]*$";
    public static final String CLEAR_HTML_TAGS_WITHOUT_MEDIA_REGEX = "\\<(?!img |/?video|source ).*?>";
    public static final String CLEAR_HTML_TAGS_REGEX = "\\<.*?>";
    public static final String NEW_LINE_REGEX = "\n";
    public static final String EMAIL_REGEX = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
    public static final String PHONE_REGEX = "^1\\d{10}$";
    // 密码包含 数字,英文,字符中的两种以上，长度6-20
    public static final String PASSWORD_REGEX = "^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)(?!([^(0-9a-zA-Z)])+$).{6,20}$";
    // 日期正则:yyyy-MM-dd
    public static final String DATE_REGEX = "^(\\d{4})[-\\/](\\d{1}|0\\d{1}|1[0-2])([-\\/](\\d{1}|0\\d{1}|[1-2][0-9]|3[0-1]))*$";
    // 日期时间正则:yyyy-MM-dd HH:mm:ss
    public static final String DATETIME_REGEX = "^(\\d{4})[-\\/](\\d{1}|0\\d{1}|1[0-2])([-\\/](\\d{1}|0\\d{1}|[1-2][0-9]|3[0-1]))*\\s(\\d{1}|[0-1]\\d{1}|2[0-3])[:]([0-5]\\d{1})[:]([0-5]\\d{1})$";
    // url正则
    public static final String URL_REGEX = "^http(s?):\\/\\/(([\\w-]+\\.)+[\\w-]+|((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3})(:\\d{1,5})?(\\/.*)?$";
    // ipv4正则
    public static final String IPV4_REGEX = "^((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})(\\.((2(5[0-5]|[0-4]\\d))|[0-1]?\\d{1,2})){3}$";

    // 昵称 (中文数字英文和$_)
    public static final String NICK_REGEX = "^[\u4E00-\u9FFF\\d\\w_$]+$";

}
