package cn.jianwoo.system.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import cn.jianwoo.common.core.domain.entity.SysUser;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.common.utils.CommUtils;
import cn.jianwoo.system.domain.MessageTemplate;
import cn.jianwoo.system.service.IMessageTemplateService;
import cn.jianwoo.system.service.ISysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import org.springframework.transaction.annotation.Transactional;
import cn.jianwoo.system.mapper.MessageProfileMapper;
import cn.jianwoo.system.domain.MessageProfile;
import cn.jianwoo.system.service.IMessageProfileService;

/**
 * 消息Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
@Service
@Slf4j
public class MessageProfileServiceImpl implements IMessageProfileService
{
    @Autowired
    private MessageProfileMapper messageProfileMapper;
    @Autowired
    private IMessageTemplateService messageTemplateService;
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
    @Override
    public MessageProfile queryMessageProfileById(Long id)
    {
        MessageProfile messageProfile = messageProfileMapper.selectByPrimaryKey(id);
        if (messageProfile == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("messageProfile.not.exist", id));
        }
        return messageProfile;
    }


    /**
     * 查询消息列表
     * 
     * @param messageProfile 消息
     * @return 消息
     */
    @Override
    public List<MessageProfile> queryMessageProfileList(MessageProfile messageProfile)
    {
        return messageProfileMapper.selectList(messageProfile);
    }


    /**
     * 新增消息
     * 
     * @param messageProfile 消息
     * @return 结果
     */
    @Override
    public void doInsertMessageProfile(MessageProfile messageProfile)
    {
        messageProfile.fillInfoBeforeCreate();
        int rows = messageProfileMapper.insertSelective(messageProfile);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("messageProfile.create.failed"));
        }
    }


    /**
     * 修改消息
     * 
     * @param messageProfile 消息
     * @return 结果
     */
    @Override
    public void doUpdateMessageProfile(MessageProfile messageProfile)
    {
        messageProfile.fillInfoBeforeUpdate();
        int rows = messageProfileMapper.updateByPrimaryKeySelective(messageProfile);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("messageProfile.update.failed", messageProfile.getId()));
        }
    }


    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键
     * @return 结果
     */
    @Override
    public void doDeleteMessageProfileByIds(Long[] ids)
    {
        int rows = messageProfileMapper.deleteByPrimaryKeys(ids);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("messageProfiles.delete.failed", JSON.toJSONString(ids)));
        }
    }


    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     * @return 结果
     */
    @Override
    public void doDeleteMessageProfileById(Long id)
    {
        int rows = messageProfileMapper.deleteByPrimaryKey(id);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("messageProfile.delete.failed", id));
        }
    }


    @Override
    public void doCreateMsg(String busiSceneCode, String userName, JSONObject msgData, String bizId)
    {
        MessageTemplate messageTemplate;
        messageTemplate = messageTemplateService.queryMessageTemplateByBusiSceneCode(busiSceneCode);

        SysUser userProfile = sysUserService.selectUserByUserName(userName);
        if (userProfile == null)
        {
            log.warn(">>>>The receiver [{}] does not exist", userName);
            return;
        }
        Date now = new Date();
        MessageProfile messageProfile = new MessageProfile();
        messageProfile.setBusiSceneCode(busiSceneCode);
        messageProfile.setBusiType(messageTemplate.getBusiType());
        messageProfile.setMsgType(messageTemplate.getMsgType());
        messageProfile.setReceiverType(messageTemplate.getReceiverType());
        messageProfile.setMsgTitle(CommUtils.doRenderTpl(messageTemplate.getMsgTitleTemplate(), msgData));
        messageProfile.setMsgLink(CommUtils.doRenderTpl(messageTemplate.getMsgLinkTemplate(), msgData));
        String content = CommUtils.doRenderTpl(new String(messageTemplate.getMsgContentTemplate()), msgData);
        messageProfile.setMsgContent(content == null ? null : content.getBytes(StandardCharsets.UTF_8));
        messageProfile.setBizId(bizId);
        messageProfile.setReceiverId(userProfile.getUserName());
        messageProfile.setReceiverName(userProfile.getUserName());
        messageProfile.setReceiverEmail(userProfile.getEmail());
        messageProfile.setEmailNotify(messageTemplate.getEmailNotify());
        messageProfile.setEmailTplCode(messageTemplate.getEmailTplCode());
        messageProfile.setEmailTplCode(messageTemplate.getEmailTplCode());
        messageProfile.setProcRslt(ProcessStatus.SUCCESS.getValue());
        messageProfile.setProcTime(now);
        messageProfile.setSendTime(now);
        messageProfile.setCreateTime(now);
        messageProfile.setUpdateTime(now);
        messageProfile.setBizParam(msgData.toJSONString().getBytes(StandardCharsets.UTF_8));

        this.doInsertMessageProfile(messageProfile);

    }
}
