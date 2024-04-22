package cn.jianwoo.system.service;

import java.util.List;
import java.util.Map;

import cn.jianwoo.system.domain.SystemConfig;
import cn.jianwoo.system.domain.bo.SystemConfigBO;
import cn.jianwoo.system.domain.bo.SystemConfigResBO;
import cn.jianwoo.system.domain.extend.SystemConfigExt;

/**
 * 参数配置 服务层
 * 
 * @author jianwoo
 */
public interface SysConfigService
{

    /**
     * 获取验证码开关
     * 
     * @return true开启，false关闭
     */
    public boolean selectCaptchaEnabled();


    /**
     * 加载参数缓存数据
     */
    public void loadingConfigCache();


    /**
     * 清空参数缓存数据
     */
    public void clearConfigCache();


    /**
     * 重置参数缓存数据
     */
    public void resetConfigCache();

    //


    /**
     * 获取所有网站配置
     *
     * @return List<Webconf>
     * @author gulihua
     */
    List<SystemConfig> queryAllSystemConf();


    /**
     * 获取所有有效的配置
     *
     * @return
     * @author gulihua
     */
    List<SystemConfigExt> queryEffectiveSystemConf();


    /**
     * 通過key更新value
     *
     * @param webconf 只包含value的对象
     * @param key KEY
     * @return
     * @author gulihua
     */
    void doUpdateSystemConfByKey(SystemConfig webconf, String key);


    /**
     * 获取网站配置map
     *
     * @return List<SystemConfigBO>
     * @author gulihua
     */
    SystemConfigResBO queryConfig();


    /**
     * 更新网站配置
     *
     * @param configList 网站配置
     * @param actor 操作人
     * @return
     * @author gulihua
     */
    void doUpdateConfig(List<SystemConfigBO> configList, String actor);


    /**
     * 通过key获取网站配置<br>
     * (优化)先从缓存拿，没有再从数据库拿<br>
     *
     * @param key 键
     * @return
     * @author gulihua
     */
    String querySystemConfByKey(String key);


    /**
     * 通过key获取网站配置<br>
     * (优化)先从缓存拿，没有再从数据库拿<br>
     * 不抛出编译异常<br>
     *
     * @param key 键
     * @return
     * @author gulihua
     */
    String selectConfigByKey(String key);


    /**
     * 通过type获取网站配置<br>
     * (优化)先从缓存拿，没有再从数据库拿<br>
     *
     * @param cfgType 配置类型
     * @return
     * @author gulihua
     */
    Map<String, String> querySystemConfByType(String cfgType);


    /**
     * 通过type获取网站配置<br>
     * (优化)先从缓存拿，没有再从数据库拿<br>
     *
     * @param cfgType 配置类型
     * @return
     * @author gulihua
     */
    Map<String, String> queryByType(String cfgType);

}
