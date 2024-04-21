package cn.jianwoo.system.service;

import java.util.List;

import cn.jianwoo.system.domain.SystemConfigFacade;

/**
 * 系统配置Service接口
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
public interface SystemConfigFacadeService
{
    /**
     * 查询系统配置
     * 
     * @param cfgKey 系统配置主键
     * @return 系统配置
     */
     SystemConfigFacade querySystemConfigFacadeByCfgKey(String cfgKey);

    /**
     * 查询系统配置列表
     * 
     * @param systemConfigFacade 系统配置
     * @return 系统配置集合
     */
    List<SystemConfigFacade> querySystemConfigFacadeList(SystemConfigFacade systemConfigFacade);

    /**
     * 新增系统配置
     * 
     * @param systemConfigFacade 系统配置
     */
    void doInsertSystemConfigFacade(SystemConfigFacade systemConfigFacade);

    /**
     * 修改系统配置
     * 
     * @param systemConfigFacade 系统配置
     */
    void doUpdateSystemConfigFacade(SystemConfigFacade systemConfigFacade);

    /**
     * 批量删除系统配置
     * 
     * @param cfgKeys 需要删除的系统配置主键集合
     */
    void doDeleteSystemConfigFacadeByCfgKeys(String[] cfgKeys);

    /**
     * 删除系统配置信息
     * 
     * @param cfgKey 系统配置主键
     */
    void doDeleteSystemConfigFacadeByCfgKey(String cfgKey);
}
