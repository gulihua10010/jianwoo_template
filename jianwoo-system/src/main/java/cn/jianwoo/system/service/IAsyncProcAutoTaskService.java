package cn.jianwoo.system.service;

import java.util.List;
import cn.jianwoo.system.domain.AsyncProcAutoTask;

/**
 * 异步任务Service接口
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
public interface IAsyncProcAutoTaskService
{
    /**
     * 查询异步任务
     * 
     * @param taskId 异步任务主键
     * @return 异步任务
     */
    AsyncProcAutoTask queryAsyncProcAutoTaskByTaskId(String taskId);


    /**
     * 查询异步任务列表
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 异步任务集合
     */
    List<AsyncProcAutoTask> queryAsyncProcAutoTaskList(AsyncProcAutoTask asyncProcAutoTask);


    /**
     * 新增异步任务
     * 
     * @param asyncProcAutoTask 异步任务
     */
    void doInsertAsyncProcAutoTask(AsyncProcAutoTask asyncProcAutoTask);


    /**
     * 修改异步任务
     * 
     * @param asyncProcAutoTask 异步任务
     */
    void doUpdateAsyncProcAutoTask(AsyncProcAutoTask asyncProcAutoTask);


    /**
     * 批量删除异步任务
     * 
     * @param taskIds 需要删除的异步任务主键集合
     */
    void doDeleteAsyncProcAutoTaskByTaskIds(String[] taskIds);


    /**
     * 删除异步任务信息
     * 
     * @param taskId 异步任务主键
     */
    void doDeleteAsyncProcAutoTaskByTaskId(String taskId);


    /**
     * 创建任务
     *
     * @param taskType 任务类型
     * @param taskData 任务数据
     * @return
     * @author gulihua
     */
    String doCreateTask(String taskType, String taskData);


    /**
     * 创建任务
     *
     * @param parentTaskId 父任务ID
     * @param taskType 任务类型
     * @param taskData 任务数据
     * @return
     * @author gulihua
     */
    String doCreateTask(String parentTaskId, String taskType, String taskData);


    /**
     * 创建延迟任务
     *
     * @param taskType 任务类型
     * @param taskData 任务数据
     * @param delayTime 延迟时间（单位：毫秒）
     * @return
     * @author gulihua
     */
    String doCreateDelayTask(String taskType, String taskData, Long delayTime);


    /**
     * 创建延迟任务
     *
     * @param parentTaskId 父任务ID
     * @param taskType 任务类型
     * @param taskData 任务数据
     * @param delayTime 延迟时间（单位：毫秒）
     * @return
     * @author gulihua
     */
    String doCreateDelayTask(String parentTaskId, String taskType, String taskData, Long delayTime);


    /**
     * 更新任务
     *
     * @param taskId 任务ID
     * @param isSuccess 是否成功
     * @param code 失败代码
     * @param reason 失败原因
     * @param desc 处理描述
     * @param failedTimes 之前失败次数
     * @param maxRetryimes 最大重试次数
     * @return
     * @author gulihua
     */
    void doUpdateTask(String taskId, boolean isSuccess, String code, String reason, String desc, Integer failedTimes,
            Integer maxRetryimes);


    /**
     * 更新任务状态
     *
     * @param taskId 任务ID
     * @param status 状态
     * @return
     * @author gulihua
     */
    void doUpdateTaskStatus(String taskId, String status);


    /**
     * 发送任务到 MQ
     *
     * @param taskId 任务ID
     * @return
     * @author gulihua
     */
    void doSendTask(String taskId);


    /**
     * 发送延迟任务到 MQ
     *
     * @param taskId 任务ID
     * @param delayTime 延迟时间（单位：毫秒）
     * @return
     * @author gulihua
     */
    void doSendDelayTask(String taskId, long delayTime);
}
