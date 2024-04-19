package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.MessageProfile;
import cn.jianwoo.system.domain.example.MessageProfileExample;
import org.apache.ibatis.annotations.Param;

/**
 * 消息Mapper接口
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
public interface MessageProfileMapper 
{

    /**
     * 根据条件统计消息
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(MessageProfileExample example);

    /**
     * 根据条件删除消息
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(MessageProfileExample example);

    /**
     * 新增消息
     *
     * @param messageProfile 消息
     * @return 结果
     */
    int insert(MessageProfile messageProfile);

    /**
     * 根据条件查询消息列表
     *
     * @param example example查询条件
     * @return List<MessageProfile>
     */
    List<MessageProfile> selectByExample(MessageProfileExample example);

    /**
     * 根据条件更新消息列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") MessageProfile record, @Param("example") MessageProfileExample example);

    /**
     * 根据条件更新消息列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") MessageProfile record, @Param("example") MessageProfileExample example);

    /**
     * 修改消息
     *
     * @param messageProfile 消息
     * @return 结果
     */
    int updateByPrimaryKey(MessageProfile messageProfile);

    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    MessageProfile selectByPrimaryKey(Long id);

    /**
     * 查询消息列表
     * 
     * @param messageProfile 消息
     * @return 消息集合
     */
    List<MessageProfile> selectList(MessageProfile messageProfile);

    /**
     * 新增消息, 忽略 null 字段
     * 
     * @param messageProfile 消息
     * @return 结果
     */
    int insertSelective(MessageProfile messageProfile);

    /**
     * 修改消息, 忽略 null 字段
     * 
     * @param messageProfile 消息
     * @return 结果
     */
    int updateByPrimaryKeySelective(MessageProfile messageProfile);

    /**
     * 删除消息
     * 
     * @param id 消息主键
     * @return 结果
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(Long[] ids);
}
