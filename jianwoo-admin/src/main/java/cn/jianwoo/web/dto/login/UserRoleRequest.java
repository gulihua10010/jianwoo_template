package cn.jianwoo.web.dto.login;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 用户角色对象
 * 
 * @author jianwoo
 */
@Schema(description = "登录请求")
@Data
public class UserRoleRequest
{
    /**
     * 角色键集合
     */
    @Schema(description = "角色键集合", required = true)
    @NotEmpty(message = "角色键集合不能为空")
    private List<String> roleKeys;
}
