package cn.jianwoo.system.util;


import cn.jianwoo.common.constant.CfgType;
import cn.jianwoo.common.constant.ConfigConstants;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.service.SysConfigService;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author GuLihua
 * @Description
 * @date 2021-10-16 2:24
 */
@Component
@Slf4j
public class QiniuUploadUtil {

    /**
     * 访问key
     */
    private String accessKey;
    /**
     * 访问secret
     */
    private String secretKey;
    /**
     * 存储空间名称
     */
    private String bucketname;
    /**
     * 绑定域名
     */
    private String domain;
    private Auth auth;
    private UploadManager uploadManager;
    private BucketManager bucketManager;

    @Autowired
    private SysConfigService sysConfigService;

    @Bean
    @ConditionalOnMissingBean
    public UploadManager init() {
        Map<String, Object> cfgMap = null;
        cfgMap = sysConfigService.querySystemConfByType(CfgType.QINIUYUN.getValue());

        accessKey = (String) cfgMap.get(ConfigConstants.QINIUYUN_ACCESS_KEY);
        secretKey = (String) cfgMap.get(ConfigConstants.QINIUYUN_SECRET_KEY);
        bucketname = (String) cfgMap.get(ConfigConstants.QINIUYUN_BUCKET_NAME);
        domain = (String) cfgMap.get(ConfigConstants.QINIUYUN_DOMAIN);

        auth = Auth.create(accessKey, secretKey);
        Zone z = Zone.autoZone();
        Configuration c = new Configuration(z);

        bucketManager = new BucketManager(auth, c);

        // 创建上传对象
        uploadManager = new UploadManager(c);
        return uploadManager;
    }


    private String getUpToken() {
        return auth.uploadToken(bucketname);
    }


    /**
     * 七牛云上传文件
     *
     * @param filepath 本地文件全路径
     * @param context  CDN上下文
     * @param name     文件名
     * @return 七牛云cdn源路径
     * @author gulihua
     */
    public String upload(String filepath, String context, String name) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(filepath, context + "/" + name, getUpToken());
            // 打印返回的信息
            log.info(">>>>Qiniuyun upload successfully, response: [{}]", res.bodyString());
            JSONObject object = (JSONObject) JSON.parse(res.bodyString());
            return domain.concat("/").concat((String) object.get("key"));
        } catch (QiniuException e) {
            Response response = e.response;
            // 请求失败时打印的异常的信息
            log.error(">>Qiniuyun upload failed, response = [{}]", response);
            log.error(">>Qiniuyun upload failed, e:\r\n", e);
            throw new E(MessageUtils.message("qiniuyun.upload.failed"), filepath);

        }

    }


    /**
     * 七牛云删除文件
     *
     * @param filepath 本地文件全路径
     * @param context  CDN上下文
     * @param name     文件名
     * @return 七牛云cdn源路径
     * @author gulihua
     */
    public void delete(String filepath, String context, String name) {
        try {
            // 调用put方法上传
            Response res = bucketManager.delete(bucketname, context + "/" + name);
            // 打印返回的信息
            log.info(">>>>Qiniuyun upload successfully, response: [{}]", res.bodyString());
        } catch (QiniuException e) {
            Response response = e.response;
            // 请求失败时打印的异常的信息
            log.error(">>Qiniuyun upload failed, response = [{}]", response);
            log.error(">>Qiniuyun upload failed, e:\r\n", e);
            throw new E(MessageUtils.message("qiniuyun.delete.failed"), filepath);


        }

    }


    /**
     * 七牛云上传文件字节数组
     *
     * @param bytes   文件字节数组
     * @param context CDN上下文
     * @param name    文件名
     * @return
     * @author gulihua
     */
    public String upload(byte[] bytes, String context, String name) {
        try {
            // 调用put方法上传
            Response res = uploadManager.put(bytes, context + "/" + name, getUpToken());
            // 打印返回的信息
            log.info(">>>>Qiniuyun upload successfully, response: [{}]", res.bodyString());
            JSONObject object = (JSONObject) JSON.parse(res.bodyString());
            return domain.concat("/").concat((String) object.get("key"));
        } catch (QiniuException e) {
            e.printStackTrace();
            Response response = e.response;
            // 请求失败时打印的异常的信息
            log.error(">>Qiniuyun upload failed, response = [{}]", response);
            log.error(">>Qiniuyun upload failed, e:\r\n", e);
            throw new E(MessageUtils.message("qiniuyun.upload.failed"), name);
        }
    }

}
