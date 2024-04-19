package cn.jianwoo.system.domain;

import java.util.Date;
import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 邮箱对象 email
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class Email extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 表自增唯一id */
    private Long oid;

    /** 收件人, json数组 */
    private String toEmail;

    /** 邮件模板编号 */
    private String emailTplCode;

    /** 邮件主题 */
    private String subject;

    /** 邮件内容 */
    private byte[] content;

    /** 组装的json数据 */
    private String jsonData;

    /** 邮件附件 */
    private String files;

    /** $column.columnComment */
    private String procStatus;

    /** $column.columnComment */
    private String procDesc;

    /** $column.columnComment */
    private Date procTime;

}
