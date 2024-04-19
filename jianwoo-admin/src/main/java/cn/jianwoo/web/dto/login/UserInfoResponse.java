package cn.jianwoo.web.dto.login;

import java.util.Set;

import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.web.dto.user.vo.SysUserVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gulihua
 * @Description
 * @date 2023-08-18 15:54
 */
@Data
@Schema(description = "获取用户响应")
public class UserInfoResponse extends R
{
    @Schema(description = "用户")
    private SysUserVO user;

    @Schema(description = "角色集合")
    private Set<String> roles;

    @Schema(description = "权限集合")
    private Set<String> permissions;

    public static UserInfoResponse getInstance()
    {
        return new UserInfoResponse();
    }
}
