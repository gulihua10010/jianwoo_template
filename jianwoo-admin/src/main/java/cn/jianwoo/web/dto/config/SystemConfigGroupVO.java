package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuLihua
 * @Description
 * @date 2021-07-01 14:32
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigGroupVO implements Serializable {

    private static final long serialVersionUID = 7217525969848055174L;

    private String tabNameDsp;

    private String tabCode;

    private List<SystemConfigVO> list;


}
