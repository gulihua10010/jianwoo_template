package cn.jianwoo.system.service;

import java.util.List;
import cn.jianwoo.system.domain.SystemConfig;

/**
 * 系统配置Service接口
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
public interface SystemConfigService
{
    /**
     * 查询系统配置
     * 
     * @param key 系统配置主键
     * @return 系统配置
     */
     SystemConfig querySystemConfigByKey(String key);

    /**
     * 查询系统配置列表
     * 
     * @param systemConfig 系统配置
     * @return 系统配置集合
     */
    List<SystemConfig> querySystemConfigList(SystemConfig systemConfig);

    /**
     * 新增系统配置
     * 
     * @param systemConfig 系统配置
     */
    void doInsertSystemConfig(SystemConfig systemConfig);

    /**
     * 修改系统配置
     * 
     * @param systemConfig 系统配置
     */
    void doUpdateSystemConfig(SystemConfig systemConfig);

    /**
     * 批量删除系统配置
     * 
     * @param keys 需要删除的系统配置主键集合
     */
    void doDeleteSystemConfigByKeys(String[] keys);

    /**
     * 删除系统配置信息
     * 
     * @param key 系统配置主键
     */
    void doDeleteSystemConfigByKey(String key);

    /**
     * 通过key获取网站配置
     *
     * @param key 键
     * @return
     * @author gulihua
     */
    SystemConfig queryEffectiveSystemConfigByKey(String key);


    /**
     * 通过cfgType获取网站配置
     *
     * @param cfgType 配置类型
     * @return
     * @author gulihua
     */
    List<SystemConfig> querySystemConfigsByType(String cfgType);
}
