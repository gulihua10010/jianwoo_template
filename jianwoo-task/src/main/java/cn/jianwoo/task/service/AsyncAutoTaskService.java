package cn.jianwoo.task.service;

import cn.jianwoo.system.task.domain.TaskResultBO;

/**
 * @author gulihua
 * @Description
 * @date 2022-05-07 11:37
 */
public interface AsyncAutoTaskService
{

    /**
     * 处理自动任务
     *
     * @param taskId 任务id
     * @param taskData 任务数据
     * @return
     * @author gulihua
     */
    TaskResultBO doProc(String taskId, String taskData);
}
