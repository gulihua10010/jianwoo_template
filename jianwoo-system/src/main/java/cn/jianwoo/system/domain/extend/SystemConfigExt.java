package cn.jianwoo.system.domain.extend;

import cn.jianwoo.system.domain.SystemConfig;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2021-07-11 0:54
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SystemConfigExt extends SystemConfig
{

    private static final long serialVersionUID = 7604153903727647441L;

    private String titleDsp;

    private String tipsDsp;

    private String formType;

    private String tabType;

    private String tabTypeDsp;

    private Boolean required;

    private String options;
    private String validateType;

    private String validateValue;

    private Integer index;
}
