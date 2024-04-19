package cn.jianwoo.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import org.springframework.transaction.annotation.Transactional;
import cn.jianwoo.system.mapper.EmailTemplateMapper;
import cn.jianwoo.system.domain.EmailTemplate;
import cn.jianwoo.system.service.IEmailTemplateService;


/**
 * 邮件模板Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
@Service
public class EmailTemplateServiceImpl implements IEmailTemplateService 
{
    @Autowired
    private EmailTemplateMapper emailTemplateMapper;

    /**
     * 查询邮件模板
     * 
     * @param emailTplCode 邮件模板主键
     * @return 邮件模板
     */
    @Override
    public EmailTemplate queryEmailTemplateByEmailTplCode(String emailTplCode)
    {
        EmailTemplate emailTemplate = emailTemplateMapper.selectByPrimaryKey(emailTplCode);
        if (emailTemplate == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("emailTemplate.not.exist", emailTplCode));
        }
        return emailTemplate;
    }

    /**
     * 查询邮件模板列表
     * 
     * @param emailTemplate 邮件模板
     * @return 邮件模板
     */
    @Override
    public List<EmailTemplate> queryEmailTemplateList(EmailTemplate emailTemplate)
    {
        return emailTemplateMapper.selectList(emailTemplate);
    }

    /**
     * 新增邮件模板
     * 
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    @Override
    public void doInsertEmailTemplate(EmailTemplate emailTemplate)
    {
        emailTemplate.fillInfoBeforeCreate();
        int rows = emailTemplateMapper.insertSelective(emailTemplate);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("emailTemplate.create.failed"));
        }
    }

    /**
     * 修改邮件模板
     * 
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    @Override
    public void doUpdateEmailTemplate(EmailTemplate emailTemplate)
    {
        emailTemplate.fillInfoBeforeUpdate();
        int rows = emailTemplateMapper.updateByPrimaryKeySelective(emailTemplate);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("emailTemplate.update.failed", emailTemplate.getEmailTplCode()));
        }
    }

    /**
     * 批量删除邮件模板
     * 
     * @param emailTplCodes 需要删除的邮件模板主键
     * @return 结果
     */
    @Override
    public void doDeleteEmailTemplateByEmailTplCodes(String[] emailTplCodes)
    {
        int rows = emailTemplateMapper.deleteByPrimaryKeys(emailTplCodes);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("emailTemplates.delete.failed", JSON.toJSONString(emailTplCodes)));
        }
    }

    /**
     * 删除邮件模板信息
     * 
     * @param emailTplCode 邮件模板主键
     * @return 结果
     */
    @Override
    public void doDeleteEmailTemplateByEmailTplCode(String emailTplCode)
    {
        int rows = emailTemplateMapper.deleteByPrimaryKey(emailTplCode);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("emailTemplate.delete.failed", emailTplCode));
        }
    }
}
