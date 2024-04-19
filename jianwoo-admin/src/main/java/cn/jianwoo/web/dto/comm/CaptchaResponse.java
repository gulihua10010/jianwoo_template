package cn.jianwoo.web.dto.comm;

import java.io.Serializable;

import cn.jianwoo.common.core.domain.R;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * 验证码响应对象
 * 
 * @author jianwoo
 * @date 2023-09-05
 */
@Data
@ToString
@Schema(description = "验证码响应对象")
public class CaptchaResponse extends R implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 是否开启验证码 */
    @Schema(description = "是否开启验证码")
    private Boolean captchaEnabled;

    /** uuid */
    @Schema(description = "uuid")
    private String uuid;

    /** img */
    @Schema(description = "验证码的base64")
    private String img;
}
