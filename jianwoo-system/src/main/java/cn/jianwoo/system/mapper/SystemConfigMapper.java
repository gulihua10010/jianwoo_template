package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.SystemConfig;
import cn.jianwoo.system.domain.example.SystemConfigExample;
import org.apache.ibatis.annotations.Param;

/**
 * 系统配置Mapper接口
 * 
 * @author jianwoo
 * @date 2024-04-20
 */
public interface SystemConfigMapper 
{

    /**
     * 根据条件统计系统配置
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(SystemConfigExample example);

    /**
     * 根据条件删除系统配置
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(SystemConfigExample example);

    /**
     * 新增系统配置
     *
     * @param systemConfig 系统配置
     * @return 结果
     */
    int insert(SystemConfig systemConfig);

    /**
     * 根据条件查询系统配置列表
     *
     * @param example example查询条件
     * @return List<SystemConfig>
     */
    List<SystemConfig> selectByExample(SystemConfigExample example);

    /**
     * 根据条件更新系统配置列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    /**
     * 根据条件更新系统配置列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    /**
     * 修改系统配置
     *
     * @param systemConfig 系统配置
     * @return 结果
     */
    int updateByPrimaryKey(SystemConfig systemConfig);

    /**
     * 查询系统配置
     * 
     * @param key 系统配置主键
     * @return 系统配置
     */
    SystemConfig selectByPrimaryKey(String key);

    /**
     * 查询系统配置列表
     * 
     * @param systemConfig 系统配置
     * @return 系统配置集合
     */
    List<SystemConfig> selectList(SystemConfig systemConfig);

    /**
     * 新增系统配置, 忽略 null 字段
     * 
     * @param systemConfig 系统配置
     * @return 结果
     */
    int insertSelective(SystemConfig systemConfig);

    /**
     * 修改系统配置, 忽略 null 字段
     * 
     * @param systemConfig 系统配置
     * @return 结果
     */
    int updateByPrimaryKeySelective(SystemConfig systemConfig);

    /**
     * 删除系统配置
     * 
     * @param key 系统配置主键
     * @return 结果
     */
    int deleteByPrimaryKey(String key);

    /**
     * 批量删除系统配置
     * 
     * @param keys 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] keys);
}
