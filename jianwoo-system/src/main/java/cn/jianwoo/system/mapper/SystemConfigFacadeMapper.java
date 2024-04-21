package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.SystemConfigFacade;
import cn.jianwoo.system.domain.example.SystemConfigFacadeExample;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置Mapper接口
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
public interface SystemConfigFacadeMapper 
{

    /**
     * 根据条件统计系统配置
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(SystemConfigFacadeExample example);

    /**
     * 根据条件删除系统配置
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(SystemConfigFacadeExample example);

    /**
     * 新增系统配置
     *
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    int insert(SystemConfigFacade systemConfigFacade);

    /**
     * 根据条件查询系统配置列表
     *
     * @param example example查询条件
     * @return List<SystemConfigFacade>
     */
    List<SystemConfigFacade> selectByExample(SystemConfigFacadeExample example);

    /**
     * 根据条件更新系统配置列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") SystemConfigFacade record, @Param("example") SystemConfigFacadeExample example);

    /**
     * 根据条件更新系统配置列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") SystemConfigFacade record, @Param("example") SystemConfigFacadeExample example);

    /**
     * 修改系统配置
     *
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    int updateByPrimaryKey(SystemConfigFacade systemConfigFacade);

    /**
     * 查询系统配置
     * 
     * @param cfgKey 系统配置主键
     * @return 系统配置
     */
    SystemConfigFacade selectByPrimaryKey(String cfgKey);

    /**
     * 查询系统配置列表
     * 
     * @param systemConfigFacade 系统配置
     * @return 系统配置集合
     */
    List<SystemConfigFacade> selectList(SystemConfigFacade systemConfigFacade);

    /**
     * 新增系统配置, 忽略 null 字段
     * 
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    int insertSelective(SystemConfigFacade systemConfigFacade);

    /**
     * 修改系统配置, 忽略 null 字段
     * 
     * @param systemConfigFacade 系统配置
     * @return 结果
     */
    int updateByPrimaryKeySelective(SystemConfigFacade systemConfigFacade);

    /**
     * 删除系统配置
     * 
     * @param cfgKey 系统配置主键
     * @return 结果
     */
    int deleteByPrimaryKey(String cfgKey);

    /**
     * 批量删除系统配置
     * 
     * @param cfgKeys 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] cfgKeys);
}
