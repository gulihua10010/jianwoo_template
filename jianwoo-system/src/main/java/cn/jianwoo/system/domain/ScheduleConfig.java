package cn.jianwoo.system.domain;

import cn.jianwoo.common.core.domain.BaseEntity;

import lombok.Data;
import lombok.ToString;
import lombok.EqualsAndHashCode;

/**
 * 调度配置对象 schedule_config
 * 
 * @author jianwoo
 * @date 2023-12-12
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ToString(callSuper = true)
public class ScheduleConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 键 */
    private String key;

    /** 值 */
    private String value;

}
