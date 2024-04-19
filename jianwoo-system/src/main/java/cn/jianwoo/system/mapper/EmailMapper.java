package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.Email;
import cn.jianwoo.system.domain.example.EmailExample;
import org.apache.ibatis.annotations.Param;

/**
 * 邮箱Mapper接口
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
public interface EmailMapper 
{

    /**
     * 根据条件统计邮箱
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(EmailExample example);

    /**
     * 根据条件删除邮箱
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(EmailExample example);

    /**
     * 新增邮箱
     *
     * @param email 邮箱
     * @return 结果
     */
    int insert(Email email);

    /**
     * 根据条件查询邮箱列表
     *
     * @param example example查询条件
     * @return List<Email>
     */
    List<Email> selectByExample(EmailExample example);

    /**
     * 根据条件更新邮箱列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") Email record, @Param("example") EmailExample example);

    /**
     * 根据条件更新邮箱列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") Email record, @Param("example") EmailExample example);

    /**
     * 修改邮箱
     *
     * @param email 邮箱
     * @return 结果
     */
    int updateByPrimaryKey(Email email);

    /**
     * 查询邮箱
     * 
     * @param oid 邮箱主键
     * @return 邮箱
     */
    Email selectByPrimaryKey(Long oid);

    /**
     * 查询邮箱列表
     * 
     * @param email 邮箱
     * @return 邮箱集合
     */
    List<Email> selectList(Email email);

    /**
     * 新增邮箱, 忽略 null 字段
     * 
     * @param email 邮箱
     * @return 结果
     */
    int insertSelective(Email email);

    /**
     * 修改邮箱, 忽略 null 字段
     * 
     * @param email 邮箱
     * @return 结果
     */
    int updateByPrimaryKeySelective(Email email);

    /**
     * 删除邮箱
     * 
     * @param oid 邮箱主键
     * @return 结果
     */
    int deleteByPrimaryKey(Long oid);

    /**
     * 批量删除邮箱
     * 
     * @param oids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(Long[] oids);
}
