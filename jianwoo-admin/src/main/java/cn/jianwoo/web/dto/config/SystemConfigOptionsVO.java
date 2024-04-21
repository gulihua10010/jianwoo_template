package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-25 14:53
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigOptionsVO implements Serializable {
    /**
     * 值
     */
    private String value;
    /**
     * 页面显示值
     */
    private String dsp;
}