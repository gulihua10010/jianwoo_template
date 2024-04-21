package cn.jianwoo.web.controller.common;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.code.kaptcha.Producer;
import cn.jianwoo.common.config.JianwooConfig;
import cn.jianwoo.common.constant.CacheConstants;
import cn.jianwoo.common.constant.Constants;
import cn.jianwoo.common.core.domain.R;
import cn.jianwoo.common.core.redis.RedisCache;
import cn.jianwoo.common.utils.sign.Base64;
import cn.jianwoo.common.utils.uuid.IdUtils;
import cn.jianwoo.system.service.SysConfigService;
import cn.jianwoo.web.dto.comm.CaptchaResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 验证码操作处理
 * 
 * @author jianwoo
 */
@RestController
@Tag(name = "验证码模块")
public class CaptchaController
{
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private SysConfigService configService;

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    @Operation(summary = "生成验证码", description = "生成验证码")
    public R getCode() throws IOException
    {
        CaptchaResponse response = new CaptchaResponse();
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        response.setCaptchaEnabled(captchaEnabled);
        if (!captchaEnabled)
        {
            return response;
        }

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String captchaType = JianwooConfig.getCaptchaType();
        if ("math".equals(captchaType))
        {
            String capText = captchaProducerMath.createText();
            capStr = capText.substring(0, capText.lastIndexOf("@"));
            code = capText.substring(capText.lastIndexOf("@") + 1);
            image = captchaProducerMath.createImage(capStr);
        }
        else if ("char".equals(captchaType))
        {
            capStr = code = captchaProducer.createText();
            image = captchaProducer.createImage(capStr);
        }

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try
        {
            ImageIO.write(image, "jpg", os);
        }
        catch (IOException e)
        {
            return R.fail(e.getMessage());
        }

        response.setUuid(uuid);
        response.setImg(Base64.encode(os.toByteArray()));
        return response;
    }
}
