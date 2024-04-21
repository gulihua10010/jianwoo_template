package cn.jianwoo.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.mapper.MessageTemplateMapper;
import cn.jianwoo.system.domain.MessageTemplate;
import cn.jianwoo.system.service.MessageTemplateService;


/**
 * 消息模板Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
@Service
public class MessageTemplateServiceImpl implements MessageTemplateService
{
    @Autowired
    private MessageTemplateMapper messageTemplateMapper;

    /**
     * 查询消息模板
     * 
     * @param busiSceneCode 消息模板主键
     * @return 消息模板
     */
    @Override
    public MessageTemplate queryMessageTemplateByBusiSceneCode(String busiSceneCode)
    {
        MessageTemplate messageTemplate = messageTemplateMapper.selectByPrimaryKey(busiSceneCode);
        if (messageTemplate == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("messageTemplate.not.exist", busiSceneCode));
        }
        return messageTemplate;
    }

    /**
     * 查询消息模板列表
     * 
     * @param messageTemplate 消息模板
     * @return 消息模板
     */
    @Override
    public List<MessageTemplate> queryMessageTemplateList(MessageTemplate messageTemplate)
    {
        return messageTemplateMapper.selectList(messageTemplate);
    }

    /**
     * 新增消息模板
     * 
     * @param messageTemplate 消息模板
     * @return 结果
     */
    @Override
    public void doInsertMessageTemplate(MessageTemplate messageTemplate)
    {
        messageTemplate.fillInfoBeforeCreate();
        int rows = messageTemplateMapper.insertSelective(messageTemplate);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("messageTemplate.create.failed"));
        }
    }

    /**
     * 修改消息模板
     * 
     * @param messageTemplate 消息模板
     * @return 结果
     */
    @Override
    public void doUpdateMessageTemplate(MessageTemplate messageTemplate)
    {
        messageTemplate.fillInfoBeforeUpdate();
        int rows = messageTemplateMapper.updateByPrimaryKeySelective(messageTemplate);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("messageTemplate.update.failed", messageTemplate.getBusiSceneCode()));
        }
    }

    /**
     * 批量删除消息模板
     * 
     * @param busiSceneCodes 需要删除的消息模板主键
     * @return 结果
     */
    @Override
    public void doDeleteMessageTemplateByBusiSceneCodes(String[] busiSceneCodes)
    {
        int rows = messageTemplateMapper.deleteByPrimaryKeys(busiSceneCodes);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("messageTemplates.delete.failed", JSON.toJSONString(busiSceneCodes)));
        }
    }

    /**
     * 删除消息模板信息
     * 
     * @param busiSceneCode 消息模板主键
     * @return 结果
     */
    @Override
    public void doDeleteMessageTemplateByBusiSceneCode(String busiSceneCode)
    {
        int rows = messageTemplateMapper.deleteByPrimaryKey(busiSceneCode);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("messageTemplate.delete.failed", busiSceneCode));
        }
    }
}
