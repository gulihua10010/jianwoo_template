package cn.jianwoo.web.dto.user;

import java.util.List;

import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.web.dto.user.vo.SysPostVO;
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
@Schema(description = "获取用户响应")
public class UserInfoDetResponse extends R
{
    @Schema(description = "角色集合", required = true)
    private List<SysRoleVO> roles;

    @Schema(description = "岗位集合", required = true)
    private List<SysPostVO> posts;

    @Schema(description = "用户信息", required = true)
    private SysUserVO data;
    @Schema(description = "角色集合", required = true)
    private List<Long> roleIds;
    @Schema(description = "岗位id集合", required = true)
    private List<Long> postIds;

    public static UserInfoDetResponse getInstance()
    {
        return new UserInfoDetResponse();
    }
}
