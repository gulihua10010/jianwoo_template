package cn.jianwoo.web.dto.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.jianwoo.common.annotation.Excel;
import cn.jianwoo.common.annotation.Excels;
import cn.jianwoo.common.xss.Xss;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 用户对象 sys_user
 * 
 * @author jianwoo
 */

@EqualsAndHashCode
@Data
@ToString
@Schema(description = "用户")
public class SysUserVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号", cellType = Excel.ColumnType.NUMERIC, prompt = "用户编号")
    @Schema(description = "用户编号")
    private Long userId;

    /** 部门ID */
    @Excel(name = "部门编号", type = Excel.Type.IMPORT)
    @Schema(description = "部门编号")
    private Long deptId;

    /** 用户账号 */
    @Xss(message = "用户账号不能包含脚本字符")
    @NotBlank(message = "用户账号不能为空")
    @Size(min = 0, max = 30, message = "用户账号长度不能超过30个字符")
    @Excel(name = "登录名称")
    @Schema(description = "登录名称", required = true)
    private String userName;

    /** 用户昵称 */

    @Xss(message = "用户昵称不能包含脚本字符")
    @Size(min = 0, max = 30, message = "用户昵称长度不能超过30个字符")
    @Excel(name = "用户名称")
    @Schema(description = "用户名称")
    private String nickName;

    /** 用户邮箱 */

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    @Excel(name = "用户邮箱")
    @Schema(description = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    @Excel(name = "手机号码")
    @Schema(description = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    @Schema(description = "用户性别")
    private String sex;

    /** 用户头像 */
    @Schema(description = "用户头像")
    private String avatar;


    /** 微信openId */
    @Schema(description = "微信openId")
    private String openId;

    /** 密码 */
    @Schema(description = "密码")
    private String password;

    /** 帐号状态（0正常 1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,1=停用")
    @Schema(description = "帐号状态（0正常 1停用）")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @Schema(description = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /** 最后登录IP */
    @Excel(name = "最后登录IP", type = Excel.Type.EXPORT)
    @Schema(description = "最后登录IP")
    private String loginIp;

    /** 最后登录时间 */
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Excel.Type.EXPORT)
    @Schema(description = "最后登录时间")
    private Date loginDate;

    /** 部门对象 */

    @Excels({
            @Excel(name = "部门名称", targetAttr = "deptName", type = Excel.Type.EXPORT),
            @Excel(name = "部门负责人", targetAttr = "leader", type = Excel.Type.EXPORT)
    })
    @Schema(description = "部门对象")
    private SysDeptVO dept;

    /** 角色对象 */
    @Schema(description = "角色对象")
    private List<SysRoleVO> roles;

    /** 角色组 */
    @Schema(description = "角色组")
    private Long[] roleIds;

    /** 岗位组 */
    @Schema(description = "岗位组")
    private Long[] postIds;

    /** 角色ID */
    @Schema(description = "角色ID")
    private Long roleId;

    /* 起始时间 **/
    @Schema(description = "起始时间")
    private String beginTime;

    /* 结束时间 **/
    @Schema(description = "结束时间")
    private String endTime;

    /** 创建者 */
    @Schema(description = "创建者")
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建时间")
    private Date createTime;

    /** 更新者 */
    @Schema(description = "更新者")
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新时间")
    private Date updateTime;

    /** 备注 */
    @Schema(description = "备注")
    private String remark;
}
