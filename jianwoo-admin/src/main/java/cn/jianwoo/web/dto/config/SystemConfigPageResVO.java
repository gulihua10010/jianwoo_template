package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-26 14:53
 */
@Data
@NoArgsConstructor
public class SystemConfigPageResVO
{
    private static final long serialVersionUID = 1970975993765800810L;
    private WebPageConfigVO data;

    public static SystemConfigPageResVO getInstance()
    {
        return new SystemConfigPageResVO();
    }
}