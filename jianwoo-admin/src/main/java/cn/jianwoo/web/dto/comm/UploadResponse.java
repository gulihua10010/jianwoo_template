package cn.jianwoo.web.dto.comm;

import java.io.Serializable;

import cn.jianwoo.common.core.domain.R;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;
import org.apache.poi.ss.formula.functions.T;

/**
 * 上传文件响应对象
 * 
 * @author jianwoo
 * @date 2023-09-05
 */
@Data
@ToString
@Schema(description = "上传文件响应对象")
public class UploadResponse extends R implements Serializable
{
    private static final long serialVersionUID = 1L;

    /** url */
    @Schema(description = "url")
    private String url;

    /** 文件相对路径 */
    @Schema(description = "文件相对路径")
    private String filePath;

    /** 新文件名 */
    @Schema(description = "新文件名")
    private String newFileName;

    /** 原始文件名 */
    @Schema(description = "原始文件名")
    private String originalFilename;

    public static UploadResponse fail(String msg)
    {
        UploadResponse apiResult = new UploadResponse();
        apiResult.setCode(FAIL);
        apiResult.setMsg(msg);
        return apiResult;
    }
}
