package cn.jianwoo.web.dto.user.vo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonInclude;
import cn.jianwoo.common.core.domain.entity.SysDept;
import cn.jianwoo.common.core.domain.entity.SysMenu;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Treeselect树结构实体类
 * 
 * @author jianwoo
 */
@EqualsAndHashCode
@Data
@ToString
@Schema(description = "树结构实体类")
public class TreeSelectVO implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 节点ID */
    @Schema(description = "节点ID")
    private Long id;

    /** 节点名称 */
    @Schema(description = "节点名称")
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Schema(description = "子节点")
    private List<TreeSelectVO> children;

    public TreeSelectVO()
    {

    }

    public TreeSelectVO(SysDept dept)
    {
        this.id = dept.getDeptId();
        this.label = dept.getDeptName();
        this.children = dept.getChildren().stream().map(TreeSelectVO::new).collect(Collectors.toList());
    }

    public TreeSelectVO(SysMenu menu)
    {
        this.id = menu.getMenuId();
        this.label = menu.getMenuName();
        this.children = menu.getChildren().stream().map(TreeSelectVO::new).collect(Collectors.toList());
    }

}
