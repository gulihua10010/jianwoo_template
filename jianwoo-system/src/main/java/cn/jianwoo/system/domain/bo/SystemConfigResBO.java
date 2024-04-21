package cn.jianwoo.system.domain.bo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2021-07-01 15:39
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigResBO implements Serializable {

    private static final long serialVersionUID = -2440070252258836670L;
    /**
     * 配置数据集
     */
    private List<SystemConfigGroupBO> data;
    /**
     * tab标签集合（用于前端展示）
     */
    private List<String> tabList;
}
