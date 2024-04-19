package cn.jianwoo.system.service;

import java.util.List;
import cn.jianwoo.system.domain.EmailTemplate;

/**
 * 邮件模板Service接口
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
public interface IEmailTemplateService 
{
    /**
     * 查询邮件模板
     * 
     * @param emailTplCode 邮件模板主键
     * @return 邮件模板
     */
     EmailTemplate queryEmailTemplateByEmailTplCode(String emailTplCode);

    /**
     * 查询邮件模板列表
     * 
     * @param emailTemplate 邮件模板
     * @return 邮件模板集合
     */
    List<EmailTemplate> queryEmailTemplateList(EmailTemplate emailTemplate);

    /**
     * 新增邮件模板
     * 
     * @param emailTemplate 邮件模板
     */
    void doInsertEmailTemplate(EmailTemplate emailTemplate);

    /**
     * 修改邮件模板
     * 
     * @param emailTemplate 邮件模板
     */
    void doUpdateEmailTemplate(EmailTemplate emailTemplate);

    /**
     * 批量删除邮件模板
     * 
     * @param emailTplCodes 需要删除的邮件模板主键集合
     */
    void doDeleteEmailTemplateByEmailTplCodes(String[] emailTplCodes);

    /**
     * 删除邮件模板信息
     * 
     * @param emailTplCode 邮件模板主键
     */
    void doDeleteEmailTemplateByEmailTplCode(String emailTplCode);
}
