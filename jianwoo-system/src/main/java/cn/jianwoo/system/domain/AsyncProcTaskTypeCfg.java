package cn.jianwoo.system.domain;

import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 异步任务配置对象 async_proc_task_type_cfg
 *
 * @author jianwoo
 * @date 2023-12-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class AsyncProcTaskTypeCfg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务类型 */
    private String taskType;

    /** 任务类型名称 */
    private String taskTypeName;

    /** 执行服务beanId */
    private String execSrvId;

    /** 是否延迟任务 */
    private Boolean isDelayTask;

    /** 延迟时间 */
    private Long delayTime;

    /** 最大重试次数 */
    private Integer timesMaxRetry;

}
