package cn.jianwoo.system.service;

import java.util.List;
import cn.jianwoo.system.domain.MessageTemplate;

/**
 * 消息模板Service接口
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
public interface IMessageTemplateService 
{
    /**
     * 查询消息模板
     * 
     * @param busiSceneCode 消息模板主键
     * @return 消息模板
     */
     MessageTemplate queryMessageTemplateByBusiSceneCode(String busiSceneCode);

    /**
     * 查询消息模板列表
     * 
     * @param messageTemplate 消息模板
     * @return 消息模板集合
     */
    List<MessageTemplate> queryMessageTemplateList(MessageTemplate messageTemplate);

    /**
     * 新增消息模板
     * 
     * @param messageTemplate 消息模板
     */
    void doInsertMessageTemplate(MessageTemplate messageTemplate);

    /**
     * 修改消息模板
     * 
     * @param messageTemplate 消息模板
     */
    void doUpdateMessageTemplate(MessageTemplate messageTemplate);

    /**
     * 批量删除消息模板
     * 
     * @param busiSceneCodes 需要删除的消息模板主键集合
     */
    void doDeleteMessageTemplateByBusiSceneCodes(String[] busiSceneCodes);

    /**
     * 删除消息模板信息
     * 
     * @param busiSceneCode 消息模板主键
     */
    void doDeleteMessageTemplateByBusiSceneCode(String busiSceneCode);
}
