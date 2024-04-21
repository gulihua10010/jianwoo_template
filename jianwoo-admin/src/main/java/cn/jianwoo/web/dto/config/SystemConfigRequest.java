package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author GuLihua
 * @Description
 * @date 2020-11-25 16:05
 */
@Data
@NoArgsConstructor
public class SystemConfigRequest
{
    private static final long serialVersionUID = -8260719513799536531L;
    private List<SystemConfigVO> list;

}