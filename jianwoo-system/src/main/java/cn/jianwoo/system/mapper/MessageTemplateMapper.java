package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.MessageTemplate;
import cn.jianwoo.system.domain.example.MessageTemplateExample;
import org.apache.ibatis.annotations.Param;

/**
 * 消息模板Mapper接口
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
public interface MessageTemplateMapper 
{

    /**
     * 根据条件统计消息模板
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(MessageTemplateExample example);

    /**
     * 根据条件删除消息模板
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(MessageTemplateExample example);

    /**
     * 新增消息模板
     *
     * @param messageTemplate 消息模板
     * @return 结果
     */
    int insert(MessageTemplate messageTemplate);

    /**
     * 根据条件查询消息模板列表
     *
     * @param example example查询条件
     * @return List<MessageTemplate>
     */
    List<MessageTemplate> selectByExample(MessageTemplateExample example);

    /**
     * 根据条件更新消息模板列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") MessageTemplate record, @Param("example") MessageTemplateExample example);

    /**
     * 根据条件更新消息模板列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") MessageTemplate record, @Param("example") MessageTemplateExample example);

    /**
     * 修改消息模板
     *
     * @param messageTemplate 消息模板
     * @return 结果
     */
    int updateByPrimaryKey(MessageTemplate messageTemplate);

    /**
     * 查询消息模板
     * 
     * @param busiSceneCode 消息模板主键
     * @return 消息模板
     */
    MessageTemplate selectByPrimaryKey(String busiSceneCode);

    /**
     * 查询消息模板列表
     * 
     * @param messageTemplate 消息模板
     * @return 消息模板集合
     */
    List<MessageTemplate> selectList(MessageTemplate messageTemplate);

    /**
     * 新增消息模板, 忽略 null 字段
     * 
     * @param messageTemplate 消息模板
     * @return 结果
     */
    int insertSelective(MessageTemplate messageTemplate);

    /**
     * 修改消息模板, 忽略 null 字段
     * 
     * @param messageTemplate 消息模板
     * @return 结果
     */
    int updateByPrimaryKeySelective(MessageTemplate messageTemplate);

    /**
     * 删除消息模板
     * 
     * @param busiSceneCode 消息模板主键
     * @return 结果
     */
    int deleteByPrimaryKey(String busiSceneCode);

    /**
     * 批量删除消息模板
     * 
     * @param busiSceneCodes 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] busiSceneCodes);
}
