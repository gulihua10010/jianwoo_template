package cn.jianwoo.system.domain;

import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 系统配置对象 system_config_facade
 *
 * @author jianwoo
 * @date 2024-04-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SystemConfigFacade extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 配置参数字段名 */
    private String cfgKey;

    /** 描述 */
    private String desc;

    /** 标题显示 */
    private String titleDsp;

    /** 提示显示 */
    private String tipsDsp;

    /** input_text, textarea; input_file_image; input_text_number,input_checkbox:,select, default:input_text */
    private String formType;

    /** 类别名称 */
    private String tabType;

    /** 类别显示 */
    private String tabTypeDsp;

    /** 是否必填 */
    private Boolean required;

    /** 可选类型,json数据,eg:[{'value':'on','dsp':'开启'}] */
    private String options;

    /** maxlength|number|integer|minnum|maxnum|regex... '|'分隔 */
    private String validateType;

    /** 验证值,json数据 eg: {\"maxlength\":{\"value\":50,\"lay-verify\":\"lay-max='50'\"}} */
    private String validateValue;

    /** 排序索引 */
    private Long index;

}
