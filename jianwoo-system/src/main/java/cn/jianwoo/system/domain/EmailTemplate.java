package cn.jianwoo.system.domain;

import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 邮件模板对象 email_template
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class EmailTemplate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 邮件模板编号 */
    private String emailTplCode;

    /** 描述 */
    private String desc;

    /** 邮件模板主题 */
    private String subject;

    /** 邮件模板内容,html格式 */
    private String content;

    /** 测试的json数据 */
    private String testJsonData;

    /** 状态 */
    private String status;

}
