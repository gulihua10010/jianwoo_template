package cn.jianwoo.web.dto.login;

import cn.jianwoo.common.core.domain.R;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gulihua
 * @Description
 * @date 2023-08-18 15:54
 */
@Data
@Schema(description = "登录响应")
public class LoginResponse extends R
{
    @Schema(description = "token")
    private String token;

    public static LoginResponse getInstance()
    {
        return new LoginResponse();
    }
}
