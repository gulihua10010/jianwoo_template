package cn.jianwoo.system.service.impl;

import java.util.Date;
import java.util.List;

import cn.jianwoo.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.CommUtils;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.domain.AsyncProcAutoTask;
import cn.jianwoo.system.domain.AsyncProcTaskTypeCfg;
import cn.jianwoo.system.mapper.AsyncProcAutoTaskMapper;
import cn.jianwoo.system.service.AsyncProcAutoTaskService;
import cn.jianwoo.system.service.AsyncProcTaskTypeCfgService;
import cn.jianwoo.system.service.SequenceService;

import cn.hutool.core.util.StrUtil;

/**
 * 异步任务Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
@Service
@Slf4j
public class AsyncProcAutoTaskServiceImpl implements AsyncProcAutoTaskService
{
    @Autowired
    private AsyncProcAutoTaskMapper asyncProcAutoTaskMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private SequenceService sequenceService;

    @Autowired
    private AsyncProcTaskTypeCfgService asyncProcTaskTypeCfgService;

    @Value("${mq.queue.task_name}")
    private String taskName;
    @Value("${mq.queue.delayed_name}")
    private String delayedName;

    /**
     * 查询异步任务
     * 
     * @param taskId 异步任务主键
     * @return 异步任务
     */
    @Override
    public AsyncProcAutoTask queryAsyncProcAutoTaskByTaskId(String taskId)
    {
        AsyncProcAutoTask asyncProcAutoTask = asyncProcAutoTaskMapper.selectByPrimaryKey(taskId);
        if (asyncProcAutoTask == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("asyncProcAutoTask.not.exist", taskId));
        }
        return asyncProcAutoTask;
    }


    /**
     * 查询异步任务列表
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 异步任务
     */
    @Override
    public List<AsyncProcAutoTask> queryAsyncProcAutoTaskList(AsyncProcAutoTask asyncProcAutoTask)
    {
        return asyncProcAutoTaskMapper.selectList(asyncProcAutoTask);
    }


    /**
     * 新增异步任务
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    @Override
    public void doInsertAsyncProcAutoTask(AsyncProcAutoTask asyncProcAutoTask)
    {
        asyncProcAutoTask.fillInfoBeforeCreate();
        int rows = asyncProcAutoTaskMapper.insertSelective(asyncProcAutoTask);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("asyncProcAutoTask.create.failed"));
        }
    }


    /**
     * 修改异步任务
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    @Override
    public void doUpdateAsyncProcAutoTask(AsyncProcAutoTask asyncProcAutoTask)
    {
        asyncProcAutoTask.fillInfoBeforeUpdate();
        int rows = asyncProcAutoTaskMapper.updateByPrimaryKeySelective(asyncProcAutoTask);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("asyncProcAutoTask.update.failed", asyncProcAutoTask.getTaskId()));
        }
    }


    /**
     * 批量删除异步任务
     * 
     * @param taskIds 需要删除的异步任务主键
     * @return 结果
     */
    @Override
    public void doDeleteAsyncProcAutoTaskByTaskIds(String[] taskIds)
    {
        int rows = asyncProcAutoTaskMapper.deleteByPrimaryKeys(taskIds);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("asyncProcAutoTasks.delete.failed", JSON.toJSONString(taskIds)));
        }
    }


    /**
     * 删除异步任务信息
     * 
     * @param taskId 异步任务主键
     * @return 结果
     */
    @Override
    public void doDeleteAsyncProcAutoTaskByTaskId(String taskId)
    {
        int rows = asyncProcAutoTaskMapper.deleteByPrimaryKey(taskId);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("asyncProcAutoTask.delete.failed", taskId));
        }
    }


    @Override
    public synchronized String doCreateTask(String taskType, String taskData)
    {
        AsyncProcTaskTypeCfg asyncProcTaskTypeCfg;
        asyncProcTaskTypeCfg = asyncProcTaskTypeCfgService.queryAsyncProcTaskTypeCfgByTaskType(taskType);
        Date now = new Date();
        String preTaskId = CommUtils.generatePreTaskId();
        String taskId = preTaskId.concat(sequenceService.queryTaskNextSeq().toString());
        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskType(taskType);
        task.setTaskId(taskId);
        task.setTaskData(taskData);
        task.setTimesMaxRetry(asyncProcTaskTypeCfg.getTimesMaxRetry());
        task.setStatusProc(ProcessStatus.INIT.getValue());
        task.setStatusProcDesc(ProcessStatus.INIT.getDesc());
        task.setProcStartTime(now);
        task.setUpdateTime(now);
        this.doInsertAsyncProcAutoTask(task);
        return task.getTaskId();
    }


    @Override
    public String doCreateTask(String parentTaskId, String taskType, String taskData)
    {
        AsyncProcTaskTypeCfg asyncProcTaskTypeCfg;
        asyncProcTaskTypeCfg = asyncProcTaskTypeCfgService.queryAsyncProcTaskTypeCfgByTaskType(taskType);
        Date now = new Date();
        String preTaskId = CommUtils.generatePreTaskId();
        String taskId = preTaskId.concat(sequenceService.queryTaskNextSeq().toString());
        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskType(taskType);
        task.setParentTaskId(parentTaskId);
        task.setTaskId(taskId);
        task.setTaskData(taskData);
        task.setTimesMaxRetry(asyncProcTaskTypeCfg.getTimesMaxRetry());
        task.setStatusProc(ProcessStatus.INIT.getValue());
        task.setStatusProcDesc(ProcessStatus.INIT.getDesc());
        task.setProcStartTime(now);
        task.setUpdateTime(now);
        this.doInsertAsyncProcAutoTask(task);
        return task.getTaskId();
    }


    @Override
    public synchronized String doCreateDelayTask(String taskType, String taskData, Long delayTime)
    {
        AsyncProcTaskTypeCfg asyncProcTaskTypeCfg;
        asyncProcTaskTypeCfg = asyncProcTaskTypeCfgService.queryAsyncProcTaskTypeCfgByTaskType(taskType);
        Date now = new Date();
        String preTaskId = CommUtils.generatePreTaskId();
        String taskId = preTaskId.concat(sequenceService.queryTaskNextSeq().toString());
        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskType(taskType);
        task.setTaskId(taskId);
        task.setTaskData(taskData);
        task.setIsDelayTask(true);
        task.setDelayTime(delayTime);
        if (task.getDelayTime() == null)
        {
            task.setDelayTime(asyncProcTaskTypeCfg.getDelayTime());
        }
        task.setTimesMaxRetry(asyncProcTaskTypeCfg.getTimesMaxRetry());
        task.setStatusProc(ProcessStatus.INIT.getValue());
        task.setStatusProcDesc(ProcessStatus.INIT.getDesc());
        task.setProcStartTime(now);
        task.setUpdateTime(now);
        this.doInsertAsyncProcAutoTask(task);
        return task.getTaskId();
    }


    @Override
    public String doCreateDelayTask(String parentTaskId, String taskType, String taskData, Long delayTime)
    {
        AsyncProcTaskTypeCfg asyncProcTaskTypeCfg;
        asyncProcTaskTypeCfg = asyncProcTaskTypeCfgService.queryAsyncProcTaskTypeCfgByTaskType(taskType);
        Date now = new Date();
        String preTaskId = CommUtils.generatePreTaskId();
        String taskId = preTaskId.concat(sequenceService.queryTaskNextSeq().toString());
        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskType(taskType);
        task.setParentTaskId(parentTaskId);
        task.setTaskId(taskId);
        task.setTaskData(taskData);
        task.setIsDelayTask(true);
        task.setDelayTime(delayTime);
        if (task.getDelayTime() == null)
        {
            task.setDelayTime(asyncProcTaskTypeCfg.getDelayTime());
        }
        task.setTimesMaxRetry(asyncProcTaskTypeCfg.getTimesMaxRetry());
        task.setStatusProc(ProcessStatus.INIT.getValue());
        task.setStatusProcDesc(ProcessStatus.INIT.getDesc());
        task.setProcStartTime(now);
        task.setUpdateTime(now);
        this.doInsertAsyncProcAutoTask(task);
        return task.getTaskId();
    }


    @Override
    public void doUpdateTask(String taskId, boolean isSuccess, String code, String reason, String desc,
            Integer failedTimes, Integer maxRetryimes)
    {
        Date now = new Date();

        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskId(taskId);
        task.setStatusProc(ProcessStatus.SUCCESS.getValue());
        if (StrUtil.isBlank(desc))
        {
            desc = ProcessStatus.SUCCESS.getDesc();
        }
        task.setStatusProcDesc(desc);
        task.setProcEndTime(now);
        task.setUpdateTime(now);

        if (!isSuccess)
        {
            task.setStatusProc(ProcessStatus.FAILED.getValue());
            if (StrUtil.isBlank(reason))
            {
                reason = "process failed";
            }
            task.setStatusProcDesc(reason);
            task.setFailedReasonDesc(reason);
            if (failedTimes == null || failedTimes != -1)
            {
                task.setTimesProcFailed(failedTimes == null ? 1 : failedTimes + 1);
            }
            task.setFailedReasonCode(code);
        }

        this.doUpdateAsyncProcAutoTask(task);

        // 失败重试
        if (!isSuccess)
        {
            // 只针对系统触发，不针对手动触发
            if (failedTimes == null || failedTimes != -1)
            {
                if (task.getTimesProcFailed() <= maxRetryimes)
                {
                    this.doSendTask(taskId);
                }

            }

        }

    }


    @Override
    public void doUpdateTaskStatus(String taskId, String status)
    {
        AsyncProcAutoTask task = new AsyncProcAutoTask();
        task.setTaskId(taskId);
        task.setStatusProc(status);
        task.setStatusProcDesc(ProcessStatus.getDesc(status));
        this.doUpdateAsyncProcAutoTask(task);
    }


    @Override
    public void doSendTask(String taskId)
    {

        rabbitTemplate.convertAndSend(taskName, taskId);

    }


    @Override
    public void doSendDelayTask(String taskId, long delayTime)
    {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration(String.valueOf(delayTime));
        Message message = new Message(taskId.getBytes(), messageProperties);
        rabbitTemplate.convertAndSend(delayedName + "_exchange", Constants.DELAYED_ROUTE, message);

    }
}
