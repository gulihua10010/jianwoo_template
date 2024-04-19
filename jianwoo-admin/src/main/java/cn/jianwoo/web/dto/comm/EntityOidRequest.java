package cn.jianwoo.web.dto.comm;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author GuLihua
 * @Description
 * @date 2020-09-15 16:15
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
@Schema(description = "实体id请求对象")
public class EntityOidRequest implements Serializable
{
    private static final long serialVersionUID = -7682284534958110646L;
    /** 实体 id */
    @NotNull(message = "id不能为空")
    @Schema(description = "实体id")
    private Long entityOid;

}
