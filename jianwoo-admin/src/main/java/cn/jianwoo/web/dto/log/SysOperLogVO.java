package cn.jianwoo.web.dto.log;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import cn.jianwoo.common.annotation.Excel;
import cn.jianwoo.common.annotation.Excel.ColumnType;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 操作日志记录表 oper_log
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "操作日志记录")
public class SysOperLogVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 日志主键 */
    @Excel(name = "操作序号", cellType = ColumnType.NUMERIC)
    @Schema(description = "日志主键/操作序号")
    private Long operId;

    /** 操作模块 */
    @Excel(name = "操作模块")
    @Schema(description = "操作模块")
    private String title;

    /** 业务类型（0其它 1新增 2修改 3删除） */
    @Excel(name = "业务类型", readConverterExp = "0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    @Schema(description = "业务类型, 0=其它,1=新增,2=修改,3=删除,4=授权,5=导出,6=导入,7=强退,8=生成代码,9=清空数据")
    private Integer businessType;

    @Schema(description = "业务类型描述")
    private String businessTypeDesc;

    /** 业务类型数组 */
    @Schema(description = "业务类型数组")
    private Integer[] businessTypes;

    /** 请求方法 */
    @Excel(name = "请求方法")
    @Schema(description = "请求方法")
    private String method;

    /** 请求方式 */
    @Excel(name = "请求方式")
    @Schema(description = "请求方式")
    private String requestMethod;

    /** 操作类别（0其它 1后台用户 2手机端用户） */
    @Excel(name = "操作类别", readConverterExp = "0=其它,1=后台用户,2=手机端用户")
    @Schema(description = "操作类别")
    private Integer operatorType;
    @Schema(description = "操作类别描述")
    private String operatorTypeDesc;
    /** 操作人员 */
    @Excel(name = "操作人员")
    @Schema(description = "操作人员")
    private String operName;

    /** 部门名称 */
    @Excel(name = "部门名称")
    @Schema(description = "部门名称")
    private String deptName;

    /** 请求url */
    @Excel(name = "请求地址")
    @Schema(description = "请求地址")
    private String operUrl;

    /** 操作地址 */
    @Excel(name = "操作地址")
    @Schema(description = "操作IP地址")
    private String operIp;

    /** 操作地点 */
    @Excel(name = "操作地点")
    @Schema(description = "操作地点")
    private String operLocation;

    /** 请求参数 */
    @Excel(name = "请求参数")
    @Schema(description = "请求参数")
    private String operParam;

    /** 返回参数 */
    @Excel(name = "返回参数")
    @Schema(description = "返回参数")
    private String jsonResult;

    /** 操作状态（0正常 1异常） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=异常")
    @Schema(description = "状态")
    private Integer status;

    /** 错误消息 */
    @Excel(name = "错误消息")
    @Schema(description = "错误消息")
    private String errorMsg;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Schema(description = "操作时间")
    private Date operTime;

    /** 消耗时间 */
    @Excel(name = "消耗时间，单位：毫秒", suffix = "毫秒")
    @Schema(description = "消耗时间")
    private Long costTime;

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
