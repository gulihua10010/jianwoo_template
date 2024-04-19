package cn.jianwoo.system.service;

import java.util.List;
import cn.jianwoo.system.domain.AsyncProcTaskTypeCfg;

/**
 * 异步任务配置Service接口
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
public interface IAsyncProcTaskTypeCfgService 
{
    /**
     * 查询异步任务配置
     * 
     * @param taskType 异步任务配置主键
     * @return 异步任务配置
     */
     AsyncProcTaskTypeCfg queryAsyncProcTaskTypeCfgByTaskType(String taskType);

    /**
     * 查询异步任务配置列表
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 异步任务配置集合
     */
    List<AsyncProcTaskTypeCfg> queryAsyncProcTaskTypeCfgList(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 新增异步任务配置
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     */
    void doInsertAsyncProcTaskTypeCfg(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 修改异步任务配置
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     */
    void doUpdateAsyncProcTaskTypeCfg(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 批量删除异步任务配置
     * 
     * @param taskTypes 需要删除的异步任务配置主键集合
     */
    void doDeleteAsyncProcTaskTypeCfgByTaskTypes(String[] taskTypes);

    /**
     * 删除异步任务配置信息
     * 
     * @param taskType 异步任务配置主键
     */
    void doDeleteAsyncProcTaskTypeCfgByTaskType(String taskType);
}
