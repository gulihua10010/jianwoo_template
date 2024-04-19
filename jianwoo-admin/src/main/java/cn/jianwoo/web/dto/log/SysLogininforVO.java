package cn.jianwoo.web.dto.log;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.jianwoo.common.annotation.Excel;
import cn.jianwoo.common.annotation.Excel.ColumnType;
import cn.jianwoo.common.core.domain.BaseEntity;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 系统访问记录表 sys_logininfor
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "系统访问记录")
public class SysLogininforVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "序号", cellType = ColumnType.NUMERIC)
    @Schema(description = "序号")
    private Long infoId;

    /** 用户账号 */
    @Excel(name = "用户账号")
    @Schema(description = "用户账号")
    private String userName;

    /** 登录状态 0成功 1失败 */
    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    @Schema(description = "登录状态")
    private String status;

    /** 登录IP地址 */
    @Excel(name = "登录地址")
    @Schema(description = "登录地址")
    private String ipaddr;

    /** 登录地点 */
    @Excel(name = "登录地点")
    @Schema(description = "登录地点")
    private String loginLocation;

    /** 浏览器类型 */
    @Excel(name = "浏览器")
    @Schema(description = "浏览器")
    private String browser;

    /** 操作系统 */
    @Excel(name = "操作系统")
    @Schema(description = "操作系统")
    private String os;

    /** 提示消息 */
    @Excel(name = "提示消息")
    @Schema(description = "提示消息")
    private String msg;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "访问时间")
    private Date loginTime;

}
