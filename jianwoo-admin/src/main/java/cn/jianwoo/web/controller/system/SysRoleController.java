package cn.jianwoo.web.controller.system;

import cn.jianwoo.common.annotation.BizOptLog;
import cn.jianwoo.common.annotation.Log;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.domain.entity.SysRole;
import cn.jianwoo.common.core.domain.entity.SysUser;
import cn.jianwoo.common.core.domain.model.LoginUser;
import cn.jianwoo.common.core.page.TableDataInfo;
import cn.jianwoo.common.enums.BusinessType;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.common.utils.bean.CopyBeanUtil;
import cn.jianwoo.common.utils.poi.ExcelUtil;
import cn.jianwoo.framework.web.service.SysPermissionService;
import cn.jianwoo.framework.web.service.TokenService;
import cn.jianwoo.system.domain.SysUserRole;
import cn.jianwoo.system.service.SysRoleService;
import cn.jianwoo.system.service.SysUserService;
import cn.jianwoo.web.dto.user.vo.SysRoleVO;
import cn.jianwoo.web.dto.user.vo.SysUserRoleVO;
import cn.jianwoo.web.dto.user.vo.SysUserVO;
import com.github.pagehelper.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 角色信息
 *
 * @author jianwoo
 */
@RestController
@RequestMapping("/system/role")
@Tag(name = "角色模块")
public class SysRoleController extends BaseController {
    @Autowired
    private SysRoleService roleService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private SysUserService userService;

    @PreAuthorize("@ss.hasPermi('system:role:list')")
    @GetMapping("/list")
    @Operation(summary = "获取角色列表", description = "获取角色列表")
    @Log
    public TableDataInfo<SysRoleVO> list(@ParameterObject
                                         SysRoleVO role) {
        Page page = startPage();
        SysRole query = CopyBeanUtil.copyProperties(role, SysRole::new);
        query.getParams().put("beginTime", role.getBeginTime());
        query.getParams().put("endTime", role.getEndTime());
        List<SysRole> list = roleService.selectPageRoleList(query);
        return getDataTable(CopyBeanUtil.copyListProperties(list, SysRoleVO::new), page);
    }


    @BizOptLog(title = "role.name", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:role:export')")
    @PostMapping("/export")
    @Operation(summary = "role.name", description = "role.name")
    @Log
    public void export(@ParameterObject
                       SysRoleVO role) {

        SysRole query = CopyBeanUtil.copyProperties(role, SysRole::new);
        query.getParams().put("beginTime", role.getBeginTime());
        query.getParams().put("endTime", role.getEndTime());
        List<SysRole> list = roleService.selectRoleList(query);
        ExcelUtil<SysRoleVO> util = new ExcelUtil<SysRoleVO>(SysRoleVO.class);
        util.exportExcel(response, CopyBeanUtil.copyListProperties(list, SysRoleVO::new), "角色数据");
    }


    /**
     * 根据角色编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping(value = "/{roleId}")
    @Operation(summary = "根据角色编号获取详细信息", description = "根据角色编号获取详细信息")
    @Parameter(name = "roleId", description = "角色id", in = ParameterIn.PATH, required = true)
    @Log
    public R<SysRoleVO> getInfo(@PathVariable
                                Long roleId) {
        roleService.checkRoleDataScope(roleId);
        SysRoleVO res = CopyBeanUtil.copyProperties(roleService.selectRoleById(roleId), SysRoleVO::new);
        return ok(res);
    }


    /**
     * 新增角色
     */
    @PreAuthorize("@ss.hasPermi('system:role:add')")
    @BizOptLog(title = "role.name", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增角色", description = "新增角色")
    @Log
    public AjaxResult add(@Validated @RequestBody
                          SysRoleVO roleVO) {
        SysRole role = CopyBeanUtil.copyProperties(roleVO, SysRole::new);
        if (!roleService.checkRoleNameUnique(role)) {
            return error(MessageUtils.message("role.add.failed.name.exist", role.getRoleName()));
        } else if (!roleService.checkRoleKeyUnique(role)) {
            return error(MessageUtils.message("role.add.failed.permission.exist", role.getRoleName()));
        }
        role.setCreateBy(getUsername());
        if (roleService.insertRole(role) <= 0) {
            return error(MessageUtils.message("role.add.failed", role.getRoleName()));
        }
        return success();

    }


    /**
     * 修改保存角色
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改保存角色", description = "修改保存角色")
    @Log
    public AjaxResult edit(@Validated @RequestBody
                           SysRoleVO roleVO) {
        SysRole role = CopyBeanUtil.copyProperties(roleVO, SysRole::new);
        roleService.checkRoleAllowed(role);
        roleService.checkRoleDataScope(role.getRoleId());

        if (!roleService.checkRoleNameUnique(role)) {
            return error(MessageUtils.message("role.update.failed.name.exist", role.getRoleName()));
        } else if (!roleService.checkRoleKeyUnique(role)) {
            return error(MessageUtils.message("role.update.failed.permission.exist", role.getRoleName()));
        }
        role.setUpdateBy(getUsername());

        if (roleService.updateRole(role) > 0) {
            // 更新缓存用户权限
            LoginUser loginUser = getLoginUser();
            if (StringUtils.isNotNull(loginUser.getUser()) && !loginUser.getUser().isAdmin()) {
                loginUser.setPermissions(permissionService.getMenuPermission(loginUser.getUser()));
                loginUser.setUser(userService.selectUserByUserName(loginUser.getUser().getUserName()));
                tokenService.setLoginUser(loginUser);
            }
            return success();
        }
        return error(MessageUtils.message("role.update.failed", role.getRoleName()));
    }


    /**
     * 修改保存数据权限
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.UPDATE)
    @PutMapping("/dataScope")
    @Operation(summary = "修改保存数据权限", description = "修改保存数据权限")
    @Log
    public AjaxResult dataScope(@RequestBody
                                SysRoleVO roleVO) {
        SysRole role = CopyBeanUtil.copyProperties(roleVO, SysRole::new);
        roleService.checkRoleAllowed(role);
        roleService.checkRoleDataScope(role.getRoleId());
        return toAjax(roleService.authDataScope(role));
    }


    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    @Operation(summary = "状态修改", description = "状态修改")
    @Log
    public AjaxResult changeStatus(@RequestBody
                                   SysRoleVO roleVO) {
        SysRole role = CopyBeanUtil.copyProperties(roleVO, SysRole::new);
        roleService.checkRoleAllowed(role);
        roleService.checkRoleDataScope(role.getRoleId());
        role.setUpdateBy(getUsername());
        return toAjax(roleService.updateRoleStatus(role));
    }


    /**
     * 删除角色
     */
    @PreAuthorize("@ss.hasPermi('system:role:remove')")
    @BizOptLog(title = "role.name", businessType = BusinessType.DELETE)
    @DeleteMapping("/{roleIds}")
    @Operation(summary = "删除角色", description = "删除角色")
    @Parameter(name = "roleIds", description = "角色id列表", in = ParameterIn.PATH, required = true)
    @Log
    public AjaxResult remove(@PathVariable
                             Long[] roleIds) {
        return toAjax(roleService.deleteRoleByIds(roleIds));
    }


    /**
     * 获取角色选择框列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:query')")
    @GetMapping("/optionselect")
    @Operation(summary = "获取角色选择框列表", description = "获取角色选择框列表")
    @Log
    public R<SysRoleVO> optionselect() {
        SysRoleVO res = CopyBeanUtil.copyProperties(roleService.selectRoleAll(), SysRoleVO::new);
        return ok(res);
    }


    /**
     * 查询已分配用户角色列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:list')")
    @GetMapping("/authUser/allocatedList")
    @Operation(summary = "查询已分配用户角色列表", description = "查询已分配用户角色列表")
    @Log
    public TableDataInfo<SysUserVO> allocatedList(@ParameterObject
                                                  SysUserVO user) {
        startPage();
        List<SysUser> list = userService.selectAllocatedList(CopyBeanUtil.copyProperties(user, SysUser::new));
        return getDataTable(CopyBeanUtil.copyListProperties(list, SysUserVO::new));
    }


    /**
     * 查询未分配用户角色列表
     */
    @PreAuthorize("@ss.hasPermi('system:role:list')")
    @GetMapping("/authUser/unallocatedList")
    @Operation(summary = "查询未分配用户角色列表", description = "查询未分配用户角色列表")
    @Log
    public TableDataInfo<SysUserVO> unallocatedList(@ParameterObject
                                                    SysUserVO user) {
        startPage();
        List<SysUser> list = userService.selectUnallocatedList(CopyBeanUtil.copyProperties(user, SysUser::new));
        return getDataTable(CopyBeanUtil.copyListProperties(list, SysUserVO::new));
    }


    /**
     * 取消授权用户
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.GRANT)
    @PutMapping("/authUser/cancel")
    @Operation(summary = "取消授权用户", description = "取消授权用户")
    @Log
    public AjaxResult cancelAuthUser(@RequestBody
                                     SysUserRoleVO userRole) {
        return toAjax(roleService.deleteAuthUser(CopyBeanUtil.copyProperties(userRole, SysUserRole::new)));
    }


    /**
     * 批量取消授权用户
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.GRANT)
    @PutMapping("/authUser/cancelAll")
    @Operation(summary = "批量取消授权用户", description = "批量取消授权用户")
    @Log
    @Parameters({@Parameter(name = "roleId", description = "角色id", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "userIds", description = "用户id列表", required = true, in = ParameterIn.QUERY)})
    public AjaxResult cancelAuthUserAll(Long roleId, Long[] userIds) {
        return toAjax(roleService.deleteAuthUsers(roleId, userIds));
    }


    /**
     * 批量选择用户授权
     */
    @PreAuthorize("@ss.hasPermi('system:role:edit')")
    @BizOptLog(title = "role.name", businessType = BusinessType.GRANT)
    @PutMapping("/authUser/selectAll")
    @Operation(summary = "批量选择用户授权", description = "批量选择用户授权")
    @Log
    @Parameters({@Parameter(name = "roleId", description = "角色id", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "userIds", description = "用户id列表", required = true, in = ParameterIn.QUERY)})
    public AjaxResult selectAuthUserAll(Long roleId, Long[] userIds) {
        roleService.checkRoleDataScope(roleId);
        return toAjax(roleService.insertAuthUsers(roleId, userIds));
    }

}
