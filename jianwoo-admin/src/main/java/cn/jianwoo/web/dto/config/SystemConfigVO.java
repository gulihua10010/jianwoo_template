package cn.jianwoo.web.dto.config;

import cn.jianwoo.common.enums.FormType;
import cn.jianwoo.common.enums.ValidateType;
import cn.jianwoo.common.enums.ValueType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-25 14:53
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigVO implements Serializable
{
    /**
     * 键名
     */
    private String key;
    /**
     * 配置描述
     */
    private String desc;
    /**
     * 配置标题/标签
     */
    private String titleDsp;
    /**
     * 配置提示
     */
    private String tipsDsp;

    /**
     * 值类型 {@link ValueType}
     */
    private String valueType;
    /**
     * 表单类型 {@link FormType}
     */
    private String formType;
    /**
     * 值
     */
    private String value;
    /**
     * 是否必填
     */
    private Boolean required;
    /**
     * 可选值
     */
    private List<SystemConfigOptionsVO> options;
    /**
     * 验证类型 {@link ValidateType}
     */
    private String validateType;
    /**
     * 验证值
     */
    private String validateValue;
    /**
     * TAG标签名
     */
    private String tabType;
}