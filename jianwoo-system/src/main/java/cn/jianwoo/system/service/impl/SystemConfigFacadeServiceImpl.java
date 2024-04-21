package cn.jianwoo.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSON;

import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import cn.jianwoo.system.domain.SystemConfigFacade;
import cn.jianwoo.system.mapper.SystemConfigFacadeMapper;
import cn.jianwoo.system.service.SystemConfigFacadeService;


/**
 * 系统配置Service业务层处理
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
@Service
public class SystemConfigFacadeServiceImpl implements SystemConfigFacadeService
{
    @Autowired
    private SystemConfigFacadeMapper systemConfigFacadeMapper;

    /**
     * 查询系统配置
     * 
     * @param cfgKey 系统配置主键
     * @return 系统配置
     */
    @Override
    public SystemConfigFacade querySystemConfigFacadeByCfgKey(String cfgKey)
    {
        SystemConfigFacade systemConfigFacade = systemConfigFacadeMapper.selectByPrimaryKey(cfgKey);
        if (systemConfigFacade == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("systemConfigFacade.not.exist", cfgKey));
        }
        return systemConfigFacade;
    }

    /**
     * 查询系统配置列表
     * 
     * @param systemConfigFacade 系统配置
     * @return 系统配置
     */
    @Override
    public List<SystemConfigFacade> querySystemConfigFacadeList(SystemConfigFacade systemConfigFacade)
    {
        return systemConfigFacadeMapper.selectList(systemConfigFacade);
    }

    /**
     * 新增系统配置
     * 
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    @Override
    public void doInsertSystemConfigFacade(SystemConfigFacade systemConfigFacade)
    {
        systemConfigFacade.fillInfoBeforeCreate();
        int rows = systemConfigFacadeMapper.insertSelective(systemConfigFacade);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("systemConfigFacade.create.failed"));
        }
    }

    /**
     * 修改系统配置
     * 
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    @Override
    public void doUpdateSystemConfigFacade(SystemConfigFacade systemConfigFacade)
    {
        systemConfigFacade.fillInfoBeforeUpdate();
        int rows = systemConfigFacadeMapper.updateByPrimaryKeySelective(systemConfigFacade);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("systemConfigFacade.update.failed", systemConfigFacade.getCfgKey()));
        }
    }

    /**
     * 批量删除系统配置
     * 
     * @param cfgKeys 需要删除的系统配置主键
     * @return 结果
     */
    @Override
    public void doDeleteSystemConfigFacadeByCfgKeys(String[] cfgKeys)
    {
        int rows = systemConfigFacadeMapper.deleteByPrimaryKeys(cfgKeys);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("systemConfigFacades.delete.failed", JSON.toJSONString(cfgKeys)));
        }
    }

    /**
     * 删除系统配置信息
     * 
     * @param cfgKey 系统配置主键
     * @return 结果
     */
    @Override
    public void doDeleteSystemConfigFacadeByCfgKey(String cfgKey)
    {
        int rows = systemConfigFacadeMapper.deleteByPrimaryKey(cfgKey);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("systemConfigFacade.delete.failed", cfgKey));
        }
    }
}
