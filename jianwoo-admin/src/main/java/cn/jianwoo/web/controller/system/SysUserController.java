package cn.jianwoo.web.controller.system;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.ArrayUtils;
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
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.Page;
import cn.jianwoo.common.annotation.BizOptLog;
import cn.jianwoo.common.annotation.Log;
import cn.jianwoo.common.core.controller.BaseController;
import cn.jianwoo.common.core.domain.AjaxResult;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.domain.TreeSelect;
import cn.jianwoo.common.core.domain.entity.SysDept;
import cn.jianwoo.common.core.domain.entity.SysRole;
import cn.jianwoo.common.core.domain.entity.SysUser;
import cn.jianwoo.common.core.page.TableDataInfo;
import cn.jianwoo.common.enums.BusinessType;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.common.utils.SecurityUtils;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.common.utils.bean.CopyBeanUtil;
import cn.jianwoo.common.utils.poi.ExcelUtil;
import cn.jianwoo.system.service.SysDeptService;
import cn.jianwoo.system.service.SysPostService;
import cn.jianwoo.system.service.SysRoleService;
import cn.jianwoo.system.service.SysUserService;
import cn.jianwoo.web.dto.user.AuthRoleResponse;
import cn.jianwoo.web.dto.user.UserInfoDetResponse;
import cn.jianwoo.web.dto.user.vo.SysDeptVO;
import cn.jianwoo.web.dto.user.vo.SysPostVO;
import cn.jianwoo.web.dto.user.vo.SysRoleVO;
import cn.jianwoo.web.dto.user.vo.SysUserVO;
import cn.jianwoo.web.dto.user.vo.TreeSelectVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 用户信息
 * 
 * @author jianwoo
 */
@RestController
@RequestMapping("/system/user")
@Tag(name = "用户模块")
public class SysUserController extends BaseController
{
    @Autowired
    private SysUserService userService;

    @Autowired
    private SysRoleService roleService;

    @Autowired
    private SysDeptService deptService;

    @Autowired
    private SysPostService postService;


    /**
     * 获取用户列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/list")
    @Operation(summary = "获取用户列表", description = "获取用户列表")
    @Log
    public TableDataInfo<SysUserVO> list(@ParameterObject
    SysUserVO user)
    {
        Page page = startPage();
        SysUser query = CopyBeanUtil.copyProperties(user, SysUser::new);
        query.getParams().put("beginTime", user.getBeginTime());
        query.getParams().put("endTime", user.getEndTime());
        List<SysUser> list = userService.selectUserPageList(query);
        return getDataTable(CopyBeanUtil.copyListProperties(list, SysUserVO::new), page);
    }


    @BizOptLog(title = "user.name", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:user:export')")
    @PostMapping("/export")
    @Operation(summary = "导出用户数据", description = "导出用户数据")
    @Log
    public void export(HttpServletResponse response, @ParameterObject
    SysUserVO user)
    {

        SysUser query = CopyBeanUtil.copyProperties(user, SysUser::new);
        query.getParams().put("beginTime", user.getBeginTime());
        query.getParams().put("endTime", user.getEndTime());
        List<SysUser> list = userService.selectUserList(query);
        ExcelUtil<SysUserVO> util = new ExcelUtil<SysUserVO>(SysUserVO.class);
        util.exportExcel(response, CopyBeanUtil.copyListProperties(list, SysUserVO::new), "用户数据");
    }


    @BizOptLog(title = "user.name", businessType = BusinessType.IMPORT)
    @PreAuthorize("@ss.hasPermi('system:user:import')")
    @PostMapping("/importData")
    @Operation(summary = "导入用户数据", description = "导入用户数据")
    @Log
    public AjaxResult importData(MultipartFile file, @ParameterObject
    boolean updateSupport) throws Exception
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        List<SysUser> userList = util.importExcel(file.getInputStream());
        String operName = getUsername();
        String message = userService.importUser(userList, updateSupport, operName);
        return success(message);
    }


    @PostMapping("/importTemplate")
    @Operation(summary = "导入模板数据", description = "导入模板数据")
    @Log
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<SysUser> util = new ExcelUtil<SysUser>(SysUser.class);
        util.importTemplateExcel(response, "用户数据");
    }


    /**
     * 根据用户编号获取详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping(value = { "/", "/{userId}" })
    @Operation(summary = "根据用户编号获取详细信息", description = "根据用户编号获取详细信息")
    @Parameter(name = "userId", description = "用户id", in = ParameterIn.PATH, required = true)
    @Log
    public UserInfoDetResponse getInfo(@PathVariable(value = "userId", required = false)
    Long userId)
    {
        UserInfoDetResponse response = UserInfoDetResponse.getInstance();
        userService.checkUserDataScope(userId);
        AjaxResult ajax = AjaxResult.success();
        List<SysRole> roles = roleService.selectRoleAll();
        response.setRoles(CopyBeanUtil.copyListProperties(
                SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()),
                SysRoleVO::new));
        response.setPosts(CopyBeanUtil.copyListProperties(postService.selectPostAll(), SysPostVO::new));
        if (StringUtils.isNotNull(userId))
        {
            SysUser sysUser = userService.selectUserById(userId);
            response.setData(CopyBeanUtil.copyProperties(sysUser, SysUserVO::new));
            response.setPostIds(postService.selectPostListByUserId(userId));
            response.setRoleIds(sysUser.getRoles().stream().map(SysRole::getRoleId).collect(Collectors.toList()));
        }

        return response;
    }


    /**
     * 新增用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:add')")
    @BizOptLog(title = "user.name", businessType = BusinessType.INSERT)
    @PostMapping
    @Operation(summary = "新增用户", description = "新增用户")
    @Log
    public R<SysUserVO> add(@Validated @RequestBody
    SysUserVO userVO)
    {
        SysUser user = CopyBeanUtil.copyProperties(userVO, SysUser::new);

        if (!userService.checkUserNameUnique(user))
        {
            return fail(MessageUtils.message("user.add.failed.account.exist", user.getUserName()));
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
        {
            return fail(MessageUtils.message("user.add.failed.phone.exist", user.getUserName()));
        }
        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
        {
            return fail(MessageUtils.message("user.add.failed.email.exist", user.getUserName()));
        }
        user.setCreateBy(getUsername());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        SysUserVO res = CopyBeanUtil.copyProperties(userService.insertUser(user), SysUserVO::new);
        return ok(res);
    }


    /**
     * 修改用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @BizOptLog(title = "user.name", businessType = BusinessType.UPDATE)
    @PutMapping
    @Operation(summary = "修改用户", description = "修改用户")
    @Log
    public AjaxResult edit(@Validated @RequestBody
    SysUserVO userVO)
    {
        SysUser user = CopyBeanUtil.copyProperties(userVO, SysUser::new);
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        if (!userService.checkUserNameUnique(user))
        {
            return error(MessageUtils.message("user.update.failed.account.exist", user.getUserName()));
        }
        else if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(user))
        {
            return error(MessageUtils.message("user.update.failed.phone.exist", user.getUserName()));
        }
        else if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(user))
        {
            return error(MessageUtils.message("user.update.failed.email.exist", user.getUserName()));
        }
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUser(user));
    }


    /**
     * 删除用户
     */
    @PreAuthorize("@ss.hasPermi('system:user:remove')")
    @BizOptLog(title = "user.name", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    @Operation(summary = "删除用户", description = "删除用户")
    @Parameter(name = "userIds", description = "用户id列表", in = ParameterIn.PATH, required = true)
    @Log
    public AjaxResult remove(@PathVariable
    Long[] userIds)
    {
        if (ArrayUtils.contains(userIds, getUserId()))
        {
            return error("当前用户不能删除");
        }
        return toAjax(userService.deleteUserByIds(userIds));
    }


    /**
     * 重置密码
     */
    @PreAuthorize("@ss.hasPermi('system:user:resetPwd')")
    @BizOptLog(title = "user.name", businessType = BusinessType.UPDATE)
    @PutMapping("/resetPwd")
    @Operation(summary = "重置密码", description = "重置密码")
    @Log
    public AjaxResult resetPwd(@RequestBody
    SysUserVO userVO)
    {
        SysUser user = CopyBeanUtil.copyProperties(userVO, SysUser::new);
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setPassword(SecurityUtils.encryptPassword(user.getPassword()));
        user.setUpdateBy(getUsername());
        return toAjax(userService.resetPwd(user));
    }


    /**
     * 状态修改
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @BizOptLog(title = "user.name", businessType = BusinessType.UPDATE)
    @PutMapping("/changeStatus")
    @Operation(summary = "状态修改", description = "状态修改")
    @Log
    public AjaxResult changeStatus(@RequestBody
    SysUserVO userVO)
    {
        SysUser user = CopyBeanUtil.copyProperties(userVO, SysUser::new);
        userService.checkUserAllowed(user);
        userService.checkUserDataScope(user.getUserId());
        user.setUpdateBy(getUsername());
        return toAjax(userService.updateUserStatus(user));
    }


    /**
     * 根据用户编号获取授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:query')")
    @GetMapping("/authRole/{userId}")
    @Operation(summary = "根据用户编号获取授权角色", description = "根据用户编号获取授权角色")
    @Parameter(name = "userId", description = "用户id", in = ParameterIn.PATH, required = true)
    @Log
    public AuthRoleResponse authRole(@PathVariable("userId")
    Long userId)
    {
        SysUser user = userService.selectUserById(userId);
        List<SysRole> roles = roleService.selectRolesByUserId(userId);
        AuthRoleResponse response = AuthRoleResponse.getInstance();
        response.setUser(CopyBeanUtil.copyProperties(user, SysUserVO::new));
        response.setRoles(CopyBeanUtil.copyListProperties(
                SysUser.isAdmin(userId) ? roles : roles.stream().filter(r -> !r.isAdmin()).collect(Collectors.toList()),
                SysRoleVO::new));
        return response;
    }


    /**
     * 用户授权角色
     */
    @PreAuthorize("@ss.hasPermi('system:user:edit')")
    @BizOptLog(title = "user.name", businessType = BusinessType.GRANT)
    @PutMapping("/authRole")
    @Operation(summary = "用户授权角色", description = "用户授权角色")
    @Log
    @Parameters({ @Parameter(name = "userId", description = "用户id", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "roleIds", description = "角色id列表", required = true, in = ParameterIn.QUERY) })
    public AjaxResult insertAuthRole(Long userId, Long[] roleIds)
    {
        userService.checkUserDataScope(userId);
        userService.insertUserAuth(userId, roleIds);
        return success();
    }


    /**
     * 获取部门树列表
     */
    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/deptTree")
    @Operation(summary = "获取部门树列表", description = "获取部门树列表")
    @Log
    public AjaxResult deptTree(@ParameterObject
    SysDeptVO deptVO)
    {
        List<TreeSelect> depts = deptService.selectDeptTreeList(CopyBeanUtil.copyProperties(deptVO, SysDept::new));
        return success(CopyBeanUtil.copyListProperties(depts, TreeSelectVO::new));
    }


    @PreAuthorize("@ss.hasPermi('system:user:list')")
    @GetMapping("/alllist")
    @Operation(summary = "获取用户列表", description = "获取用户列表")
    @Log
    public R<List<SysUserVO>> listAllUser()
    {
        SysUser query = new SysUser();
        List<SysUser> list = userService.selectUserList(query);
        return ok(CopyBeanUtil.copyListProperties(list, SysUserVO::new));
    }
}
