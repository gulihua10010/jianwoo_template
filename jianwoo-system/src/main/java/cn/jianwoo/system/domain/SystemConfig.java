package cn.jianwoo.system.domain;

import java.math.BigDecimal;
import java.util.Date;
import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 系统配置对象 system_config
 *
 * @author jianwoo
 * @date 2024-04-21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class SystemConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 键 */
    private String key;

    /** 描述 */
    private String desc;

    /** 配置类型 */
    private String cfgType;

    /** s:string, n:number; d:date; b:boolean, default:s */
    private String valueType;

    /** 字符串类型 */
    private String stringValue;

    /** int 类型 */
    private Integer intValue;

    /** float 类型 */
    private BigDecimal floatValue;

    /** boolean 类型 */
    private Boolean booleanValue;

    /** date 类型 */
    private Date dateValue;

    /** 是否有效 */
    private Boolean valid;

}
