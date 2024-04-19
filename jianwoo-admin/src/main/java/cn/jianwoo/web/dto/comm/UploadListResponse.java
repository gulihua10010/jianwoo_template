package cn.jianwoo.web.dto.comm;

import java.io.Serializable;

import cn.jianwoo.common.core.domain.R;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

/**
 * 上传文件响应对象（多个）
 * 
 * @author jianwoo
 * @date 2023-09-05
 */
@Data
@ToString
@Schema(description = "上传文件响应对象（多个）")
public class UploadListResponse extends R implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** 多个url，逗号分隔 */
    @Schema(description = "多个url，逗号分隔")
    private String urls;

    /** 多个文件相对路径 */
    @Schema(description = "多个文件相对路径")
    private String filePaths;

    /** 多个新文件名，逗号分隔 */
    @Schema(description = "多个新文件名，逗号分隔")
    private String newFileNames;

    /** 多个原始文件名，逗号分隔 */
    @Schema(description = "多个原始文件名，逗号分隔")
    private String originalFilenames;

    public static UploadListResponse fail(String msg)
    {
        UploadListResponse apiResult = new UploadListResponse();
        apiResult.setCode(FAIL);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
