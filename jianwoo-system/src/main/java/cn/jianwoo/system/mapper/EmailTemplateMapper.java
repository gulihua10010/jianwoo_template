package cn.jianwoo.system.mapper;

import java.util.List;
import cn.jianwoo.system.domain.EmailTemplate;
import cn.jianwoo.system.domain.example.EmailTemplateExample;
import org.apache.ibatis.annotations.Param;

/**
 * 邮件模板Mapper接口
 * 
 * @author jianwoo
 * @date 2023-11-09
 */
public interface EmailTemplateMapper 
{

    /**
     * 根据条件统计邮件模板
     *
     * @param example example查询条件
     * @return count
     */
    long countByExample(EmailTemplateExample example);

    /**
     * 根据条件删除邮件模板
     *
     * @param example example查询条件
     * @return count
     */
    int deleteByExample(EmailTemplateExample example);

    /**
     * 新增邮件模板
     *
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    int insert(EmailTemplate emailTemplate);

    /**
     * 根据条件查询邮件模板列表
     *
     * @param example example查询条件
     * @return List<EmailTemplate>
     */
    List<EmailTemplate> selectByExample(EmailTemplateExample example);

    /**
     * 根据条件更新邮件模板列表, 忽略 null 字段
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExampleSelective(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    /**
     * 根据条件更新邮件模板列表
     *
     * @param record 记录
     * @param example example查询条件
     */
    int updateByExample(@Param("record") EmailTemplate record, @Param("example") EmailTemplateExample example);

    /**
     * 修改邮件模板
     *
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    int updateByPrimaryKey(EmailTemplate emailTemplate);

    /**
     * 查询邮件模板
     * 
     * @param emailTplCode 邮件模板主键
     * @return 邮件模板
     */
    EmailTemplate selectByPrimaryKey(String emailTplCode);

    /**
     * 查询邮件模板列表
     * 
     * @param emailTemplate 邮件模板
     * @return 邮件模板集合
     */
    List<EmailTemplate> selectList(EmailTemplate emailTemplate);

    /**
     * 新增邮件模板, 忽略 null 字段
     * 
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    int insertSelective(EmailTemplate emailTemplate);

    /**
     * 修改邮件模板, 忽略 null 字段
     * 
     * @param emailTemplate 邮件模板
     * @return 结果
     */
    int updateByPrimaryKeySelective(EmailTemplate emailTemplate);

    /**
     * 删除邮件模板
     * 
     * @param emailTplCode 邮件模板主键
     * @return 结果
     */
    int deleteByPrimaryKey(String emailTplCode);

    /**
     * 批量删除邮件模板
     * 
     * @param emailTplCodes 需要删除的数据主键集合
     * @return 结果
     */
    int deleteByPrimaryKeys(String[] emailTplCodes);
}
