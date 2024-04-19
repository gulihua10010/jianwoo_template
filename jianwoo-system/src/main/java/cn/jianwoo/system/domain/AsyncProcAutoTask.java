package cn.jianwoo.system.domain;

import java.util.Date;
import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 异步任务对象 async_proc_auto_task
 *
 * @author jianwoo
 * @date 2023-12-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class AsyncProcAutoTask extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务id */
    private String taskId;

    /** 任务类型 */
    private String taskType;

    /** 任务数据 */
    private String taskData;

    /** 父任务id */
    private String parentTaskId;

    /** 延迟时间 */
    private Long delayTime;

    /** 是否延迟任务 */
    private Boolean isDelayTask;

    /** 最大重试次数 */
    private Integer timesMaxRetry;

    /** 处理状态(00:未处理,90:成功,91:失败) */
    private String statusProc;

    /** 处理描述 */
    private String statusProcDesc;

    /** 处理开始时间 */
    private Date procStartTime;

    /** 处理结束时间 */
    private Date procEndTime;

    /** 处理失败次数 */
    private Integer timesProcFailed;

    /** 失败原因代码 */
    private String failedReasonCode;

    /** 失败原因描述 */
    private String failedReasonDesc;

}
