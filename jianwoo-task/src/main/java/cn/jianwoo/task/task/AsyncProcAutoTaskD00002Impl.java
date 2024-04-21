package cn.jianwoo.task.task;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.domain.Email;
import cn.jianwoo.system.service.EmailService;
import cn.jianwoo.system.task.domain.TaskDataD00002BO;
import cn.jianwoo.system.task.domain.TaskResultBO;
import cn.jianwoo.system.util.NotifyUtil;
import cn.jianwoo.task.service.AsyncAutoTaskService;

import lombok.extern.slf4j.Slf4j;

/**
 * 重新发送邮件
 *
 * @author gulihua
 * @Description
 * @date 2022-05-07 13:46
 */
@Service("asyncProcAutoTaskD00002")
@Slf4j
public class AsyncProcAutoTaskD00002Impl implements AsyncAutoTaskService
{
    @Autowired
    private EmailService emailService;
    @Autowired
    private NotifyUtil notifyUtil;

    @Override
    public TaskResultBO doProc(String taskId, String taskData)
    {

        log.info(">> start D0000 task({}) which data is {} <<", taskId, taskData);

        // read parameter taskData
        TaskDataD00002BO data = JSON.parseObject(taskData, TaskDataD00002BO.class);

        Email email = emailService.queryEmailByOid(data.getOid());
        if (ProcessStatus.SUCCESS.getValue().equals(email.getProcStatus()))
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("email.resend.disable", email.getSubject()));
        }

        Email newEmail = new Email();
        newEmail.setOid(data.getOid());
        newEmail.setProcTime(new Date());
        try
        {
            notifyUtil.sendEmail(email.getSubject(), new String(email.getContent()),
                    JSONArray.parseArray(email.getToEmail()).toArray(new String[0]));
            newEmail.setProcStatus(ProcessStatus.SUCCESS.getValue());
            newEmail.setProcDesc(ProcessStatus.SUCCESS.getDesc());
            emailService.doUpdateEmail(newEmail);
        }
        catch (Exception e)
        {
            newEmail.setProcStatus(ProcessStatus.FAILED.getValue());
            newEmail.setProcDesc(e.getMessage());
            emailService.doUpdateEmail(newEmail);
            return TaskResultBO.FAILED(e.getMessage());
        }

        return TaskResultBO.SUCCESS();
    }
}
