package cn.jianwoo.web.dto.user.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.jianwoo.common.annotation.Excel;
import cn.jianwoo.common.core.domain.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 角色表 sys_role
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "角色")
public class SysRoleVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 角色ID */
    @Excel(name = "角色序号", cellType = Excel.ColumnType.NUMERIC)
    @Schema(description = "角色序号")
    private Long roleId;

    /** 角色名称 */

    @NotBlank(message = "角色名称不能为空")
    @Size(min = 0, max = 30, message = "角色名称长度不能超过30个字符")
    @Excel(name = "角色名称")
    @Schema(description = "角色名称", required = true)
    private String roleName;

    /** 角色权限 */

    @Excel(name = "角色权限")
    @Schema(description = "角色键", required = true)
    private String roleKey;

    /** 数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限） */
    @Excel(name = "数据范围", readConverterExp = "1=所有数据权限,2=自定义数据权限,3=本部门数据权限,4=本部门及以下数据权限,5=仅本人数据权限")
    @Schema(description = "数据范围（1：所有数据权限；2：自定义数据权限；3：本部门数据权限；4：本部门及以下数据权限；5：仅本人数据权限")
    private String dataScope;

    /** 菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示） */
    @Schema(description = "菜单树选择项是否关联显示（ 0：父子不互相关联显示 1：父子互相关联显示）")
    private boolean menuCheckStrictly;

    /** 部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ） */
    @Schema(description = "部门树选择项是否关联显示（0：父子不互相关联显示 1：父子互相关联显示 ）")
    private boolean deptCheckStrictly;

    /** 角色状态（0正常 1停用） */
    @Excel(name = "角色状态", readConverterExp = "0=正常,1=停用")
    @Schema(description = "角色状态（0正常 1停用）")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    @Schema(description = "删除标志（0代表存在 2代表删除）")
    private String delFlag;

    /** 用户是否存在此角色标识 默认不存在 */
    @Schema(description = "用户是否存在此角色标识 默认不存在")
    private boolean flag = false;

    /** 菜单组 */
    @Schema(description = "菜单组")
    private Long[] menuIds;

    /** 项目（数据权限） */
    @Schema(description = "项目（数据权限）")
    private Long[] projectIds;

    /** 角色菜单权限 */
    @Schema(description = "角色菜单权限")
    private Set<String> permissions;

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
