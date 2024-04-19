package cn.jianwoo.system.domain;

import java.util.Date;
import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 消息对象 message_profile
 *
 * @author jianwoo
 * @date 2023-10-18
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class MessageProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表自增唯一id */
    private Long id;

    /** busi_type+msg_type+receiver_type+编号 */
    private String busiSceneCode;

    private String busiType;

    /** 10:任务通知,20:资源调整 */
    private String msgType;

    /** 接收类型:10:用户 */
    private String receiverType;

    /**  */
    private String msgTitle;

    /**  */
    private byte[] msgContent;

    /**  */
    private String msgLink;

    /**  */
    private String bizId;

    /**  */
    private byte[] bizParam;

    /**  */
    private String receiverId;

    /**  */
    private String receiverName;

    /**  */
    private String receiverEmail;

    /**  */
    private String receiverMobileNo;

    /** 是否邮件通知 */
    private String emailNotify;

    /** 邮件模板编号,email_notify为1时必填 */
    private String emailTplCode;

    /**  */
    private String flagRead;

    /**  */
    private String flagPopup;

    /**  */
    private Date readTime;

    /** 处理结果,90:成功,91:失败 */
    private String procRslt;

    /**  */
    private Date procTime;

    /**  */
    private Date sendTime;

}
