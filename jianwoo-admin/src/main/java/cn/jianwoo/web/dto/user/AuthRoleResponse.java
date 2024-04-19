package cn.jianwoo.web.dto.user;

import java.util.List;

import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.web.dto.user.vo.SysRoleVO;
import cn.jianwoo.web.dto.user.vo.SysUserVO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author gulihua
 * @Description
 * @date 2023-08-18 15:54
 */
@Data
@Schema(description = "授权角色响应")
public class AuthRoleResponse extends R
{
    @Schema(description = "角色集合", required = true)
    private List<SysRoleVO> roles;
    @Schema(description = "用户信息", required = true)
    private SysUserVO user;

    public static AuthRoleResponse getInstance()
    {
        return new AuthRoleResponse();
    }
}
