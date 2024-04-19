package cn.jianwoo.web.dto.comm;

import java.io.Serializable;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

/**
 * @author GuLihua
 * @Description
 * @date 2020-09-15 16:15
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Schema(description = "实体id集合请求对象")
public class EntityOidListRequest implements Serializable
{
    private static final long serialVersionUID = -7682284534958110646L;
    /** 实体id集合 */
    @NotEmpty(message = "id集合不能为空")
    @Schema(description = "实体id集合")
    private List<Long> entityOidList;

}
