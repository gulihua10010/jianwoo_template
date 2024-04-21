package cn.jianwoo.system.domain.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2021-07-01 14:32
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigGroupBO implements Serializable {
    private static final long serialVersionUID = -4417069949877654161L;
    private String tabNameDsp;

    private String tabCode;

    private Integer index;

    private List<SystemConfigBO> list;

}
