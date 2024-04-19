package cn.jianwoo.common.utils;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.core.domain.model.LoginUser;
import cn.jianwoo.common.exception.E;

import java.nio.charset.StandardCharsets;

/**
 * 安全服务工具类
 * 
 * @author jianwoo
 */
@Slf4j
public class SecurityUtils
{
    /**
     * 用户ID
     **/
    public static Long getUserId()
    {
        try
        {
            return getLoginUser().getUserId();
        }
        catch (Exception e)
        {
            log.error(">>>>SecurityUtils.getUserId exec failed, e:", e);
            throw new E(HttpStatus.UNAUTHORIZED, MessageUtils.message("security.get.user.id.exception"));
        }
    }


    /**
     * 获取部门ID
     **/
    public static Long getDeptId()
    {
        try
        {
            return getLoginUser().getDeptId();
        }
        catch (Exception e)
        {
            log.error(">>>>SecurityUtils.getDeptId exec failed, e:", e);
            throw new E(HttpStatus.UNAUTHORIZED, MessageUtils.message("security.get.dept.id.exception"));
        }
    }


    /**
     * 获取用户账户
     **/
    public static String getUsername()
    {
        try
        {
            return getLoginUser().getUsername();
        }
        catch (Exception e)
        {
            log.error(">>>>SecurityUtils.getUsername exec failed, e:", e);
            throw new E(HttpStatus.UNAUTHORIZED, MessageUtils.message("security.get.account.exception"));
        }
    }


    /**
     * 获取用户
     **/
    public static LoginUser getLoginUser()
    {
        try
        {
            return (LoginUser) getAuthentication().getPrincipal();
        }
        catch (Exception e)
        {
            log.error(">>>>SecurityUtils.getLoginUser exec failed, e:", e);
            throw new E(HttpStatus.UNAUTHORIZED, MessageUtils.message("security.get.user.info.exception"));
        }
    }


    /**
     * 获取Authentication
     */
    public static Authentication getAuthentication()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }


    /**
     * 生成BCryptPasswordEncoder密码
     *
     * @param password 密码
     * @return 加密字符串
     */
    public static String encryptPassword(String password)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password);
    }


    /**
     * 判断密码是否相同
     *
     * @param rawPassword 真实密码
     * @param encodedPassword 加密后字符
     * @return 结果
     */
    public static boolean matchesPassword(String rawPassword, String encodedPassword)
    {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


    /**
     * 是否为管理员
     * 
     * @param userId 用户ID
     * @return 结果
     */
    public static boolean isAdmin(Long userId)
    {
        return userId != null && 1L == userId;
    }


    /**
     * 加密字符串<br>
     * 1.对密钥key解密 2.aes加密<br>
     * 3.base加密<br>
     *
     * @param content 要加密的字符串
     * @return
     * @author gulihua
     */
    public static String encrypt(String content, String key)
    {

        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,
                Base64.encode(key).getBytes(StandardCharsets.UTF_8));
        // 加密
        byte[] encryptHex = aes.encrypt(content);

        return Base64.encode(encryptHex);

    }


    /**
     * 解密字符串<br>
     * 1.对密钥key解密 2.base解密<br>
     * 3.aes解密<br>
     *
     * @param encryptHex 要解密的字符串
     * @return
     * @author gulihua
     */
    public static String decrypt(String encryptHex, String key)
    {
        // 构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES,
                Base64.encode(key).getBytes(StandardCharsets.UTF_8));
        // 解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        return decryptStr;

    }


    /**
     * 公钥加密<br>
     *
     * @param text 要解密的字符串
     * @param publicKey 公钥
     * @return
     * @author gulihua
     */
    public static String encryptRsa(String text, String publicKey)
    {
        return SecureUtil.rsa(null, publicKey).encryptBase64(text, KeyType.PrivateKey);
    }


    /**
     * 私钥解密<br>
     *
     * @param text 要解密的字符串
     * @param privateKey 私钥
     * @return
     * @author gulihua
     */
    public static String decryptRsa(String text, String privateKey)
    {
        return SecureUtil.rsa(privateKey, null).decryptStr(text, KeyType.PrivateKey);
    }

}
