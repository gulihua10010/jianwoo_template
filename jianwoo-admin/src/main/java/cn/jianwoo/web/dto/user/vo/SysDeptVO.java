package cn.jianwoo.web.dto.user.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 部门表 sys_dept
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "部门")
public class SysDeptVO  implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 部门ID */
    @Schema(description = "部门ID", required = true)
    private Long deptId;

    /** 父部门ID */
    @Schema(description = "父部门ID")
    private Long parentId;

    /** 祖级列表 */
    @Schema(description = "祖级列表")
    private String ancestors;

    /** 部门名称 */

    @NotBlank(message = "部门名称不能为空")
    @Size(min = 0, max = 30, message = "部门名称长度不能超过30个字符")
    @Schema(description = "部门名称", required = true)
    private String deptName;

    /** 显示顺序 */
    @NotNull(message = "显示顺序不能为空")
    @Schema(description = "显示顺序", required = true)
    private Integer orderNum;

    /** 负责人 */
    @Schema(description = "负责人")
    private String leader;

    /** 联系电话 */
    @Size(min = 0, max = 11, message = "联系电话长度不能超过11个字符")
    @Schema(description = "联系电话")
    private String phone;

    /** 邮箱 */

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    @Schema(description = "邮箱")
    private String email;

    /** 部门状态:0正常,1停用 */
    @Schema(description = "部门状态:0正常,1停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @Schema(description = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /** 父部门名称 */
    @Schema(description = "父部门名称")
    private String parentName;

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


    /** 子部门 */
    @Schema(description = "子部门")
    private List<SysDeptVO> children = new ArrayList<SysDeptVO>();


}
