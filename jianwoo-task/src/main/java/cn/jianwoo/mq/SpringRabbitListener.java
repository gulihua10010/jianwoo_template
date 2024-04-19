package cn.jianwoo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.jianwoo.common.constant.TaskConstants;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.system.domain.AsyncProcAutoTask;
import cn.jianwoo.system.domain.AsyncProcTaskTypeCfg;
import cn.jianwoo.system.service.IAsyncProcAutoTaskService;
import cn.jianwoo.system.service.IAsyncProcTaskTypeCfgService;
import cn.jianwoo.system.task.domain.TaskResultBO;
import cn.jianwoo.task.service.AsyncAutoTaskService;

import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 消息队列监听
 * 
 * @author gulihua
 * @date 2023-07-31 21:05
 */

@Component
@Slf4j
public class SpringRabbitListener
{

    @Autowired
    private IAsyncProcTaskTypeCfgService asyncProcTaskTypeCfgService;
    @Autowired
    private IAsyncProcAutoTaskService asyncProcAutoTaskService;

    @RabbitListener(queues = { "${mq.queue.task_name}", "${mq.queue.dead_name}" })
    public void listenTaskMessage(String msg)
    {

        log.info(">> Start consuming Rabbit MQ, receive msg [{}]...", msg);
        String taskId = msg;
        try
        {

            AsyncProcAutoTask task = asyncProcAutoTaskService.queryAsyncProcAutoTaskByTaskId(taskId);

            AsyncProcTaskTypeCfg asyncProcTaskTypeCfg = asyncProcTaskTypeCfgService
                    .queryAsyncProcTaskTypeCfgByTaskType(task.getTaskType());

            AsyncAutoTaskService service = SpringUtil.getBean(asyncProcTaskTypeCfg.getExecSrvId());
            try
            {
                if (!ProcessStatus.INIT.getValue().equals(task.getStatusProc()))
                {
                    log.warn(">>>>SpringRabbitListener::Task {} has already been processed ", taskId);
                    return;
                }
                asyncProcAutoTaskService.doUpdateTaskStatus(taskId, ProcessStatus.PROCESSING.getValue());
                TaskResultBO res = service.doProc(taskId, task.getTaskData());
                if (TaskConstants.SUCCESS_CODE.equals(res.getCode()))
                {
                    asyncProcAutoTaskService.doUpdateTask(taskId, true, TaskConstants.SUCCESS_CODE, null, res.getMsg(),
                            task.getTimesProcFailed(), task.getTimesMaxRetry());
                }
                else
                {
                    asyncProcAutoTaskService.doUpdateTask(taskId, false, res.getCode(), res.getMsg(), null,
                            task.getTimesProcFailed(), task.getTimesMaxRetry());
                }
            }
            catch (Exception e)
            {
                log.error("SpringRabbitListener.listenTaskMessage exec failed, e:\r\n", e);
                asyncProcAutoTaskService.doUpdateTask(taskId, false, TaskConstants.FAILED_CODE, e.getMessage(), null,
                        task.getTimesProcFailed(), task.getTimesMaxRetry());
            }
        }
        catch (Exception e)
        {
            log.error("SpringRabbitListener.listenTaskMessage exec failed, e:", e);
        }
        log.info(">> End consuming Rabbit MQ!!");
    }
}
