package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.AsyncProcTaskTypeCfg;
import cn.jianwoo.system.domain.example.AsyncProcTaskTypeCfgExample;
import org.apache.ibatis.annotations.Param;

/**
 * 异步任务配置Mapper接口
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
public interface AsyncProcTaskTypeCfgMapper 
{

    /**
     * 根据条件统计异步任务配置
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(AsyncProcTaskTypeCfgExample example);

    /**
     * 根据条件删除异步任务配置
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(AsyncProcTaskTypeCfgExample example);

    /**
     * 新增异步任务配置
     *
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    int insert(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 根据条件查询异步任务配置列表
     *
     * @param example example查询条件
     * @return List<AsyncProcTaskTypeCfg>
     */
    List<AsyncProcTaskTypeCfg> selectByExample(AsyncProcTaskTypeCfgExample example);

    /**
     * 根据条件更新异步任务配置列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") AsyncProcTaskTypeCfg record, @Param("example") AsyncProcTaskTypeCfgExample example);

    /**
     * 根据条件更新异步任务配置列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") AsyncProcTaskTypeCfg record, @Param("example") AsyncProcTaskTypeCfgExample example);

    /**
     * 修改异步任务配置
     *
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    int updateByPrimaryKey(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 查询异步任务配置
     * 
     * @param taskType 异步任务配置主键
     * @return 异步任务配置
     */
    AsyncProcTaskTypeCfg selectByPrimaryKey(String taskType);

    /**
     * 查询异步任务配置列表
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 异步任务配置集合
     */
    List<AsyncProcTaskTypeCfg> selectList(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 新增异步任务配置, 忽略 null 字段
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    int insertSelective(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 修改异步任务配置, 忽略 null 字段
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    int updateByPrimaryKeySelective(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg);

    /**
     * 删除异步任务配置
     * 
     * @param taskType 异步任务配置主键
     * @return 结果
     */
    int deleteByPrimaryKey(String taskType);

    /**
     * 批量删除异步任务配置
     * 
     * @param taskTypes 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] taskTypes);
}
