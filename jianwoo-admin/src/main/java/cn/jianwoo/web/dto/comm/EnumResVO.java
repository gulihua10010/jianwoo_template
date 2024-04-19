package cn.jianwoo.web.dto.comm;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author gulihua
 * @Description
 * @date 2023-09-21 13:19
 */
@Data
@ToString
public class EnumResVO implements Serializable
{
    private static final long serialVersionUID = 4109443717241253364L;

    private String name;
    private String desc;
    private List<ElementVO> list;

    @Data
    @ToString
    public static class ElementVO
    {
        private String value;
        private String desc;
    }
}
