package cn.jianwoo.system.util;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.ConfigConstants;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.system.service.SysConfigService;

import cn.hutool.extra.mail.MailAccount;
import cn.hutool.extra.mail.MailUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * 邮件发送工具类
 *
 * @author GuLihua
 * @Description
 * @date 2021-07-13 10:42
 */
@Slf4j
@Component
public class NotifyUtil
{

    @Autowired
    private SysConfigService sysConfigService;

    private void sendEmail(List<String> emailTo, String subject, String content, boolean isHtml)
    {
        log.info(">>Start Send Email::emailTo = [{}], subject = [{}], content = [{}]", JSON.toJSONString(emailTo),
                subject, content);
        try
        {

            MailAccount account = fetchMailAcct();
            log.info("<<Fetch Email account::[{}]", JSON.toJSONString(account));

            MailUtil.send(account, emailTo, subject, content, isHtml);

        }
        catch (Exception e)
        {
            log.error(">>Start Send Email failed, e\r\n", e);
            throw new E(e);

        }
    }


    private MailAccount fetchMailAcct()
    {
        MailAccount account = null;

        String host = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_HOST);

        String port = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_PORT);
        String sender = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_USER);
        String user = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_USER);
        String senderNick = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_NICK);
        String pwd = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_PWD);

        account = new MailAccount();
        account.setHost(host);
        account.setPort(new BigDecimal(port).intValue());
        account.setAuth(true);
        account.setFrom(String.format("%s <%s>", senderNick, sender));
        account.setUser(user);
        account.setPass(pwd);
        account.setSslEnable(true);
        account.setSocketFactoryClass("javax.net.ssl.SSLSocketFactory");
        account.setSocketFactoryFallback(false);
        account.setSocketFactoryPort(new BigDecimal(port).intValue());

        account.setStarttlsEnable(true);

        return account;

    }


    /**
     * 发送邮件(纯文本)
     *
     * @param emailTos 收件人(支持多个)
     * @param subject 主题
     * @param content 内容
     * @author gulihua
     */
    public void sendEmailText(List<String> emailTos, String subject, String content)
    {

        String appName = sysConfigService.selectConfigByKey(ConfigConstants.APP_NAME);
        subject = String.format("【%s】%s", appName, subject);
        sendEmail(emailTos, subject, content, false);
    }


    /**
     * 发送邮件(纯文本)
     *
     * @param emailTo 收件人
     * @param subject 主题
     * @param content 内容
     * @author gulihua
     */
    public void sendEmailText(String emailTo, String subject, String content)
    {
        sendEmail(Collections.singletonList(emailTo), subject, content, false);
    }


    /**
     * 发送邮件(支持HTML)
     *
     * @param emailTos 收件人
     * @param subject 主题
     * @param content 内容
     * @author gulihua
     */
    public void sendEmail(String subject, String content, String... emailTos)
    {
        sendEmail(Arrays.asList(emailTos), subject, content, true);
    }


    /**
     * 发送邮件给管理员(支持HTML)
     *
     * @param subject 主题
     * @param content 内容
     * @author gulihua
     */
    public void sendEmail2Admin(String subject, String content)
    {
        String emailTo = sysConfigService.selectConfigByKey(ConfigConstants.EMAIL_ADMIN);
        sendEmail(Collections.singletonList(emailTo), subject, content, true);
    }

}
