package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.AsyncProcAutoTask;
import cn.jianwoo.system.domain.example.AsyncProcAutoTaskExample;
import org.apache.ibatis.annotations.Param;

/**
 * 异步任务Mapper接口
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
public interface AsyncProcAutoTaskMapper 
{

    /**
     * 根据条件统计异步任务
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(AsyncProcAutoTaskExample example);

    /**
     * 根据条件删除异步任务
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(AsyncProcAutoTaskExample example);

    /**
     * 新增异步任务
     *
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    int insert(AsyncProcAutoTask asyncProcAutoTask);

    /**
     * 根据条件查询异步任务列表
     *
     * @param example example查询条件
     * @return List<AsyncProcAutoTask>
     */
    List<AsyncProcAutoTask> selectByExample(AsyncProcAutoTaskExample example);

    /**
     * 根据条件更新异步任务列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") AsyncProcAutoTask record, @Param("example") AsyncProcAutoTaskExample example);

    /**
     * 根据条件更新异步任务列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") AsyncProcAutoTask record, @Param("example") AsyncProcAutoTaskExample example);

    /**
     * 修改异步任务
     *
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    int updateByPrimaryKey(AsyncProcAutoTask asyncProcAutoTask);

    /**
     * 查询异步任务
     * 
     * @param taskId 异步任务主键
     * @return 异步任务
     */
    AsyncProcAutoTask selectByPrimaryKey(String taskId);

    /**
     * 查询异步任务列表
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 异步任务集合
     */
    List<AsyncProcAutoTask> selectList(AsyncProcAutoTask asyncProcAutoTask);

    /**
     * 新增异步任务, 忽略 null 字段
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    int insertSelective(AsyncProcAutoTask asyncProcAutoTask);

    /**
     * 修改异步任务, 忽略 null 字段
     * 
     * @param asyncProcAutoTask 异步任务
     * @return 结果
     */
    int updateByPrimaryKeySelective(AsyncProcAutoTask asyncProcAutoTask);

    /**
     * 删除异步任务
     * 
     * @param taskId 异步任务主键
     * @return 结果
     */
    int deleteByPrimaryKey(String taskId);

    /**
     * 批量删除异步任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] taskIds);
}
