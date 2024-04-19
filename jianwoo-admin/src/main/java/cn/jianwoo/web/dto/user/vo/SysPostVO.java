package cn.jianwoo.web.dto.user.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import cn.jianwoo.common.core.domain.BaseEntity;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;
import java.util.Date;

/**
 * 岗位表 sys_post
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "岗位")
public class SysPostVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 岗位序号 */
    @Schema(description = "岗位序号")
    private Long postId;

    /** 岗位编码 */

    @NotBlank(message = "岗位编码不能为空")
    @Size(min = 0, max = 64, message = "岗位编码长度不能超过64个字符")
    @Schema(description = "岗位编码", required = true)
    private String postCode;

    /** 岗位名称 */

    @NotBlank(message = "岗位名称不能为空")
    @Size(min = 0, max = 50, message = "岗位名称长度不能超过50个字符")
    @Schema(description = "岗位名称", required = true)
    private String postName;

    /** 岗位排序 */
    @NotNull(message = "显示顺序不能为空")
    @Schema(description = "岗位排序", required = true)
    private Integer postSort;

    /** 状态（0正常 1停用） */
    @Schema(description = "状态（0正常 1停用）")
    private String status;

    /** 用户是否存在此岗位标识 默认不存在 */
    @Schema(description = "用户是否存在此岗位标识 默认不存")
    private boolean flag = false;

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
