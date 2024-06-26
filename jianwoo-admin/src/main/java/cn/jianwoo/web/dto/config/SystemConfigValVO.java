package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-26 14:57
 */

@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigValVO implements Serializable {
    private static final long serialVersionUID = -173120689091202491L;
    ;

    /**
     * 值
     */
    private String value;

}