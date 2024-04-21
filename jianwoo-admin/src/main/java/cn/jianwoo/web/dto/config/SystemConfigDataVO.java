package cn.jianwoo.web.dto.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author GuLihua
 * @Description
 * @date 2021-07-11 23:47
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
public class SystemConfigDataVO implements Serializable
{
    private static final long serialVersionUID = 6420757992680680687L;

    /**
     * 配置数据集
     */
    private List<SystemConfigGroupVO> dataList;
    /**
     * tab标签集合（用于前端展示）
     */
    private List<String> tabList;

}
