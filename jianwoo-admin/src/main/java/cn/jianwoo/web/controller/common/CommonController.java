package cn.jianwoo.web.controller.common;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.web.dto.comm.UploadListResponse;
import cn.jianwoo.web.dto.comm.UploadResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.jianwoo.common.config.JianwooConfig;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.utils.StringUtils;
import cn.jianwoo.common.utils.file.FileUploadUtils;
import cn.jianwoo.common.utils.file.FileUtils;
import cn.jianwoo.framework.config.ServerConfig;

/**
 * 通用请求处理
 * 
 * @author jianwoo
 */
@RestController
@RequestMapping("/common")
@Tag(name = "公共模块")
public class CommonController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    private static final String FILE_DELIMETER = ",";

    /**
     * 通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("/download")
    @Operation(summary = "通用下载请求", description = "通用下载请求")
    @Parameters({ @Parameter(name = "fileName", description = "文件名", required = true, in = ParameterIn.QUERY),
            @Parameter(name = "delete", description = "是否删除", required = true, in = ParameterIn.QUERY) })
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response)
    {
        try
        {
            if (!FileUtils.checkAllowDownload(fileName))
            {
                throw new Exception(MessageUtils.message("file.name.illegal", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = JianwooConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }


    /**
     * 通用上传请求（单个）
     */
    @PostMapping("/upload")
    @Operation(summary = "通用上传请求（单个）", description = "通用上传请求（单个）")
    @Parameter(name = "file", description = "文件对象", in = ParameterIn.QUERY, required = true)
    public UploadResponse uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = JianwooConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            UploadResponse response = new UploadResponse();
            response.setUrl(url);
            response.setFilePath(fileName);
            response.setNewFileName(FileUtils.getName(fileName));
            response.setOriginalFilename(file.getOriginalFilename());
            return response;
        }
        catch (Exception e)
        {
            return UploadResponse.fail(e.getMessage());
        }
    }


    /**
     * 通用上传请求（多个）
     */
    @PostMapping("/uploads")
    @Operation(summary = "通用上传请求（多个）", description = "通用上传请求（多个）")
    @Parameter(name = "files", description = "文件对象列表", in = ParameterIn.QUERY, required = true)
    public UploadListResponse uploadFiles(List<MultipartFile> files) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = JianwooConfig.getUploadPath();
            List<String> urls = new ArrayList<String>();
            List<String> fileNames = new ArrayList<String>();
            List<String> newFileNames = new ArrayList<String>();
            List<String> originalFilenames = new ArrayList<String>();
            for (MultipartFile file : files)
            {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                urls.add(url);
                fileNames.add(fileName);
                newFileNames.add(FileUtils.getName(fileName));
                originalFilenames.add(file.getOriginalFilename());
            }
            UploadListResponse response = new UploadListResponse();
            response.setUrls(StringUtils.join(urls, FILE_DELIMETER));
            response.setFilePaths(StringUtils.join(fileNames, FILE_DELIMETER));
            response.setNewFileNames(StringUtils.join(newFileNames, FILE_DELIMETER));
            response.setOriginalFilenames(StringUtils.join(originalFilenames, FILE_DELIMETER));

            return response;
        }
        catch (Exception e)
        {
            return UploadListResponse.fail(e.getMessage());
        }
    }


    /**
     * 本地资源通用下载
     */
    @GetMapping("/download/resource")
    @Operation(summary = "本地资源通用下载", description = "本地资源通用下载")
    @Parameter(name = "resource", description = "资源名称", in = ParameterIn.QUERY, required = true)
    public void resourceDownload(String resource, HttpServletResponse response)
    {
        try
        {
            if (!FileUtils.checkAllowDownload(resource))
            {
                throw new Exception(MessageUtils.message("resource.name.illegal", resource));
            }
            // 本地资源路径
            String localPath = JianwooConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error(">>>>download resource failed, e: ", e);
        }
    }
}
