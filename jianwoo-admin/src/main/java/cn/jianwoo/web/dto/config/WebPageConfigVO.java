package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-26 14:57
 */

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class WebPageConfigVO implements Serializable
{
    private static final long serialVersionUID = -173120689091202491L;;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用版本
     */
    private String appVersion;

    /**
     * 应用标识
     */
    private String appNick;

    /**
     * 网站地址
     */
    private String website;

    /**
     * Github地址
     */
    private String githubUrl;

    /**
     * 博客地址
     */
    private String blogUrl;

    /**
     * 小程序码地址
     */
    private String miniProgramCode;

    /**
     * 客服二维码地址
     */
    private String customerQrCodeUrl;

    /** H5 开启百度内容审核 */
    private Boolean h5BdSensitiveEnabled;


    /** 开启手机号登录 */
    private Boolean phoneLogin;

    /** H5 开启原生支付(需要营业执照) */
    private Boolean payNative;

    /** 微信浏览器开启微信登录(需要有服务号,也需要营业执照) */
    private Boolean wxH5wxLogin;

    /** 启用支付(可选值:[ON,OFF,H5,WX]) */
    private String payEnabled;
    /**微信服务号APP ID*/
    private String wxServceAccountAppid;
    /**应用LOGO*/
    private String logo;
    /**聊天会话AI头像*/
    private String aiAvatar;

    /**登录需要验证码*/
    private String loginCaptcha;
    /** H5页面启用支付宝支付 */
    private Boolean aliPayEnable;
    /**uni-ad广告位id*/
    private String adpid;

}