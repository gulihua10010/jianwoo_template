package cn.jianwoo.system.domain.bo;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-25 14:53
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigOptionsBO implements Serializable {
    /**
     * 值
     */
    private String value;
    /**
     * 页面显示值
     */
    private String dsp;
}