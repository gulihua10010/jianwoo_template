package cn.jianwoo.task.task;

import com.alibaba.fastjson2.JSONArray;
import cn.jianwoo.common.enums.ProcessStatus;
import cn.jianwoo.system.domain.Email;
import cn.jianwoo.system.util.NotifyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.system.service.EmailService;
import cn.jianwoo.system.task.domain.TaskDataD00001BO;
import cn.jianwoo.system.task.domain.TaskResultBO;
import cn.jianwoo.task.service.AsyncAutoTaskService;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * 发送邮件
 *
 * @author gulihua
 * @Description
 * @date 2022-05-07 13:46
 */
@Service("asyncProcAutoTaskD00001")
@Slf4j
public class AsyncProcAutoTaskD00001Impl implements AsyncAutoTaskService
{
    @Autowired
    private EmailService emailService;
    @Autowired
    private NotifyUtil notifyUtil;

    @Override
    public TaskResultBO doProc(String taskId, String taskData)
    {

        log.info(">> start D00001 task({}) which data is {} <<", taskId, taskData);

        // read parameter taskData
        TaskDataD00001BO data = JSON.parseObject(taskData, TaskDataD00001BO.class);
        Email email = emailService.queryEmailByOid(data.getEmailOid());
        if (ProcessStatus.SUCCESS.getValue().equals(email.getProcStatus()))
        {
            return TaskResultBO.SUCCESS();
        }
        Email newEmail = new Email();
        newEmail.setOid(email.getOid());
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
