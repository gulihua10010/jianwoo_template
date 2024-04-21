package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author GuLihua
 * @Description
 * @date 2021-01-25 15:44
 */
@Data
@NoArgsConstructor
public class SystemConfigCommRequest implements Serializable
{

    private static final long serialVersionUID = -9159381492520980551L;

    private String key;

}
