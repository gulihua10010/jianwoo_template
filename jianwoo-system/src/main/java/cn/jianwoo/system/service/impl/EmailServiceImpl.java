package cn.jianwoo.system.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import cn.jianwoo.common.constant.ConfigConstants;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.common.enums.TaskType;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.CommUtils;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.domain.Email;
import cn.jianwoo.system.domain.EmailTemplate;
import cn.jianwoo.system.domain.example.EmailExample;
import cn.jianwoo.system.mapper.EmailMapper;
import cn.jianwoo.system.service.IAsyncProcAutoTaskService;
import cn.jianwoo.system.service.IEmailService;
import cn.jianwoo.system.service.IEmailTemplateService;
import cn.jianwoo.system.service.ISysConfigService;
import cn.jianwoo.system.task.domain.TaskDataD00001BO;
import cn.jianwoo.system.task.domain.TaskDataD00002BO;
import cn.jianwoo.system.util.NotifyUtil;
import cn.jianwoo.system.util.TransactionUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 邮箱Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
@Service
@Slf4j
public class EmailServiceImpl implements IEmailService
{
    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private IAsyncProcAutoTaskService asyncProcAutoTaskService;
    @Autowired
    private TransactionUtils transactionUtils;
    @Autowired
    private NotifyUtil notifyUtil;
    @Autowired
    private ISysConfigService sysConfigService;
    @Autowired
    private IEmailTemplateService emailTemplateService;

    /**
     * 查询邮箱
     * 
     * @param oid 邮箱主键
     * @return 邮箱
     */
    @Override
    public Email queryEmailByOid(Long oid)
    {
        Email email = emailMapper.selectByPrimaryKey(oid);
        if (email == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("email.not.exist", oid));
        }
        return email;
    }


    /**
     * 查询邮箱列表
     * 
     * @param email 邮箱
     * @return 邮箱
     */
    @Override
    public List<Email> queryEmailList(Email email)
    {
        return emailMapper.selectList(email);
    }


    /**
     * 新增邮箱
     * 
     * @param email 邮箱
     * @return 结果
     */
    @Override
    public void doInsertEmail(Email email)
    {
        email.fillInfoBeforeCreate();
        int rows = emailMapper.insertSelective(email);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.create.failed"));
        }
    }


    /**
     * 修改邮箱
     * 
     * @param email 邮箱
     * @return 结果
     */
    @Override
    public void doUpdateEmail(Email email)
    {
        email.fillInfoBeforeUpdate();
        int rows = emailMapper.updateByPrimaryKeySelective(email);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.update.failed", email.getOid()));
        }
    }


    /**
     * 批量删除邮箱
     * 
     * @param oids 需要删除的邮箱主键
     * @return 结果
     */
    @Override
    public void doDeleteEmailByOids(Long[] oids)
    {
        int rows = emailMapper.deleteByPrimaryKeys(oids);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("emails.delete.failed", JSON.toJSONString(oids)));
        }
    }


    /**
     * 删除邮箱信息
     * 
     * @param oid 邮箱主键
     * @return 结果
     */
    @Override
    public void doDeleteEmailByOid(Long oid)
    {
        int rows = emailMapper.deleteByPrimaryKey(oid);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.delete.failed", oid));
        }
    }


    @Override
    public String doReSendEmail(Long oid)
    {
        Email email = this.queryEmailByOid(oid);
        if (ProcessStatus.SUCCESS.getValue().equals(email.getProcStatus()))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.resend.disable", email.getSubject()));
        }
        TaskDataD00002BO taskDataD0010BO = new TaskDataD00002BO();
        taskDataD0010BO.setOid(oid);
        String taskId = null;
        taskId = asyncProcAutoTaskService.doCreateTask(TaskType.D00002.getValue(),
                JSONObject.toJSONString(taskDataD0010BO));
        if (taskId != null)
        {
            transactionUtils.doTriggerTaskAfterCommit(taskId);
        }
        return taskId;
    }


    @Override
    public Email queryEmailBySubjectAndIn5Sec(String subject)
    {
        EmailExample example = new EmailExample();
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.SECOND, -5);
        example.createCriteria().andSubjectEqualTo(subject).andCreateTimeBetween(calendar.getTime(), now);
        List<Email> list = emailMapper.selectByExample(example);
        if (CollUtil.isNotEmpty(list))
        {
            return list.get(0);
        }
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void doSendEmailTpl(String tplCode, JSONObject jsonData, String... emailTos)
    {

        String appName = sysConfigService.selectConfigByKey(ConfigConstants.APP_NAME);
        EmailTemplate tpl = emailTemplateService.queryEmailTemplateByEmailTplCode(tplCode);
        String subject = String.format("【%s】%s", appName, tpl.getSubject());
        subject = CommUtils.doRenderTpl(subject, jsonData);
        String content = CommUtils.doRenderTpl(tpl.getContent(), jsonData);
        if (StrUtil.isBlank(content))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.content.empty"));
        }
        Email email = new Email();
        email.setEmailTplCode(tplCode);
        email.setContent(content.getBytes());
        email.setToEmail(JSONObject.toJSONString(emailTos));
        email.setSubject(subject);
        email.setJsonData(jsonData.toString());
        email.setProcTime(new Date());
        email.setProcStatus(ProcessStatus.INIT.getValue());
        email.setProcDesc(ProcessStatus.INIT.getDesc());

        try
        {
            this.doInsertEmail(email);
            this.createD00001Task(email.getOid());
        }
        catch (Exception e)
        {
            email.setProcStatus(ProcessStatus.FAILED.getValue());
            String msg = null;
            if (StrUtil.isNotBlank(e.getMessage()))
            {
                msg = e.getMessage();
                if (msg.length() > 2000)
                {
                    msg = msg.substring(0, 2000);
                }
            }
            email.setProcDesc(msg);
            this.doInsertEmail(email);
            throw e;
        }

    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void doSendEmail2AdminTpl(String tplCode, JSONObject jsonData)
    {
        String appName = sysConfigService.selectConfigByKey(ConfigConstants.APP_NAME);
        EmailTemplate tpl = emailTemplateService.queryEmailTemplateByEmailTplCode(tplCode);
        String subject = String.format("【%s】%s", appName, tpl.getSubject());
        subject = CommUtils.doRenderTpl(subject, jsonData);
        String content = CommUtils.doRenderTpl(tpl.getContent(), jsonData);
        String emailTo = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_ADMIN);
        String[] emailTos = {};
        if (StrUtil.isNotBlank(emailTo))
        {
            emailTos = emailTo.split(Constants.COMMA_SEPARATOR);
        }
        if (StrUtil.isBlank(content))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.content.empty"));
        }
        Email email = new Email();
        email.setEmailTplCode(tplCode);
        email.setContent(content.getBytes());
        email.setToEmail(JSON.toJSONString(emailTos));
        email.setSubject(subject);
        email.setJsonData(jsonData.toString());
        email.setProcTime(new Date());
        email.setProcStatus(ProcessStatus.INIT.getValue());
        email.setProcDesc(ProcessStatus.INIT.getDesc());
        try
        {
            this.doInsertEmail(email);
            this.createD00001Task(email.getOid());
        }
        catch (Exception e)
        {
            email.setProcStatus(ProcessStatus.FAILED.getValue());
            String msg = null;
            if (StrUtil.isNotBlank(e.getMessage()))
            {
                msg = e.getMessage();
                if (msg.length() > 2000)
                {
                    msg = msg.substring(0, 2000);
                }
            }
            email.setProcDesc(msg);
            this.doInsertEmail(email);
            throw e;
        }
    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void doSendEmail(String subject, String content, String... emailTos)
    {
        String appName = sysConfigService.selectConfigByKey(ConfigConstants.APP_NAME);
        subject = String.format("【%s】%s", appName, subject);
        Email email = new Email();
        email.setContent(content.getBytes());
        email.setToEmail(JSONObject.toJSONString(emailTos));
        email.setSubject(subject);
        email.setProcTime(new Date());
        email.setProcStatus(ProcessStatus.INIT.getValue());
        email.setProcDesc(ProcessStatus.INIT.getDesc());
        try
        {
            this.doInsertEmail(email);
            this.createD00001Task(email.getOid());
        }
        catch (Exception e)
        {
            email.setProcStatus(ProcessStatus.FAILED.getValue());
            String msg = null;
            if (StrUtil.isNotBlank(e.getMessage()))
            {
                msg = e.getMessage();
                if (msg.length() > 2000)
                {
                    msg = msg.substring(0, 2000);
                }
            }
            email.setProcDesc(msg);
            this.doInsertEmail(email);
            throw e;
        }

    }


    @Override
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRES_NEW)
    public void doSendEmail2Admin(String subject, String content)
    {
        if (StrUtil.isBlank(content))
        {
            log.error(">>>>sendEmail2Admin[subject={}]:: content is empty!!!", subject);
            return;
        }
        String emailTo = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_ADMIN);
        String appName = sysConfigService.selectConfigByKey(ConfigConstants.APP_NAME);
        subject = String.format("【%s】%s", appName, subject);
        String[] emailTos = {};
        if (StrUtil.isNotBlank(emailTo))
        {
            emailTos = emailTo.split(Constants.COMMA_SEPARATOR);
        }
        Email email = new Email();
        email.setContent(content.getBytes());
        email.setToEmail(JSON.toJSONString(emailTos));
        email.setSubject(subject);
        email.setProcTime(new Date());
        email.setProcStatus(ProcessStatus.INIT.getValue());
        email.setProcDesc(ProcessStatus.INIT.getDesc());
        try
        {
            this.doInsertEmail(email);
            this.createD00001Task(email.getOid());
        }
        catch (Exception e)
        {
            email.setProcStatus(ProcessStatus.FAILED.getValue());
            String msg = null;
            if (StrUtil.isNotBlank(e.getMessage()))
            {
                msg = e.getMessage();
                if (msg.length() > 2000)
                {
                    msg = msg.substring(0, 2000);
                }
            }
            email.setProcDesc(msg);
            this.doInsertEmail(email);
            throw e;
        }

    }


    private void createD00001Task(Long emailOid)
    {
        TaskDataD00001BO taskDataD00001 = new TaskDataD00001BO();
        taskDataD00001.setEmailOid(emailOid);

        String taskId = null;
        taskId = asyncProcAutoTaskService.doCreateTask(TaskType.D00001.getValue(),
                JSONObject.toJSONString(taskDataD00001));
        if (taskId != null)
        {
            transactionUtils.doTriggerTaskAfterCommit(taskId);
        }
    }

}
