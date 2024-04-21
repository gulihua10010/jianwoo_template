package cn.jianwoo.web.controller.system;

import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.domain.entity.SysMenu;
import cn.jianwoo.common.core.domain.entity.SysUser;
import cn.jianwoo.common.utils.SecurityUtils;
import cn.jianwoo.framework.web.service.SysLoginService;
import cn.jianwoo.framework.web.service.SysPermissionService;
import cn.jianwoo.system.domain.vo.RouterVo;
import cn.jianwoo.system.service.SysMenuService;
import cn.jianwoo.web.dto.login.LoginRequest;
import cn.jianwoo.web.dto.login.LoginResponse;
import cn.jianwoo.web.dto.login.UserInfoResponse;
import cn.jianwoo.web.dto.user.vo.SysUserVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 登录验证
 * 
 * @author jianwoo
 */
@RestController
@Tag(name = "登录模块")
public class SysLoginController
{
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private SysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    @Operation(summary = "登录", description = "登录")
    public LoginResponse login(@RequestBody
    LoginRequest loginBody)
    {
        LoginResponse response = LoginResponse.getInstance();
        // 生成令牌

        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        response.setToken(token);
        return response;
    }


    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    @Operation(summary = "获取用户信息", description = "获取用户信息")
    public UserInfoResponse getInfo()
    {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        UserInfoResponse response = UserInfoResponse.getInstance();
        SysUserVO vo = new SysUserVO();
        BeanUtils.copyProperties(user, vo);
        response.setUser(vo);
        response.setRoles(roles);
        response.setPermissions(permissions);
        return response;
    }


    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    @Operation(summary = "获取路由信息", description = "获取路由信息")
    public R<List<RouterVo>> getRouters()
    {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return R.ok(menuService.buildMenus(menus));
    }
}
