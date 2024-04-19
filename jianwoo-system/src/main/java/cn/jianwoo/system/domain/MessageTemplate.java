package cn.jianwoo.system.domain;

import cn.jianwoo.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 消息模板对象 message_template
 *
 * @author jianwoo
 * @date 2023-10-18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class MessageTemplate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * busi_type+msg_type+receiver_type组成
     */
    private String busiSceneCode;

    private String busiType;

    /**
     * 10:任务通知,20:资源调整
     */
    private String msgType;

    /**
     * 接收类型:10:用户
     */
    private String receiverType;

    /**
     * 消息描述
     */
    private String msgDesc;

    /**
     *
     */
    private String msgTitleTemplate;

    /**
     *
     */
    private byte[] msgContentTemplate;

    /**
     *
     */
    private String msgLinkTemplate;

    /**
     * 状态
     */
    private String status;

    /**
     * 是否邮件通知
     */
    private String emailNotify;

    /**
     * 邮件模板编号,email_notify为1时必填
     */
    private String emailTplCode;

}
