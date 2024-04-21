package cn.jianwoo.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import cn.jianwoo.system.domain.Email;

/**
 * 邮箱Service接口
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
public interface EmailService
{
    /**
     * 查询邮箱
     * 
     * @param oid 邮箱主键
     * @return 邮箱
     */
    Email queryEmailByOid(Long oid);


    /**
     * 查询邮箱列表
     * 
     * @param email 邮箱
     * @return 邮箱集合
     */
    List<Email> queryEmailList(Email email);


    /**
     * 新增邮箱
     * 
     * @param email 邮箱
     */
    void doInsertEmail(Email email);


    /**
     * 修改邮箱
     * 
     * @param email 邮箱
     */
    void doUpdateEmail(Email email);


    /**
     * 批量删除邮箱
     * 
     * @param oids 需要删除的邮箱主键集合
     */
    void doDeleteEmailByOids(Long[] oids);


    /**
     * 删除邮箱信息
     * 
     * @param oid 邮箱主键
     */
    void doDeleteEmailByOid(Long oid);


    /**
     * 重发邮件
     *
     * @param oid 主键
     * @return 任务 ID
     * 
     */
    String doReSendEmail(Long oid);


    /**
     * 查询 5 秒内是否有相同主题的邮件发送，解决异常邮件发送多封相同的问题
     * 
     * @param subject 邮件主题
     * @date 11:07 2023/12/12
     * @author gulihua
     *
     * @return Email
     * @throws
     **/
    Email queryEmailBySubjectAndIn5Sec(String subject);


    /**
     * 发送邮件（使用邮件模板）
     *
     * @param tplCode 邮件模板编号
     * @param jsonData json 数据
     * @param emailTo 收件人
     * 
     */
    void doSendEmailTpl(String tplCode, JSONObject jsonData, String... emailTo);


    /**
     * 发送邮件给管理员（使用邮件模板）
     *
     * @param tplCode 邮件模板编号
     * @param jsonData json 数据
     * 
     */
    void doSendEmail2AdminTpl(String tplCode, JSONObject jsonData);


    /**
     * 发送邮件
     *
     * @param subject 主题
     * @param content 内容
     * @param emailTo 收件人
     * 
     */
    void doSendEmail(String subject, String content, String... emailTo);


    /**
     * 发送邮件给管理员
     *
     * @param subject 主题
     * @param content 内容
     * 
     */
    void doSendEmail2Admin(String subject, String content);
}
