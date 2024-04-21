package cn.jianwoo.system.mapper.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.jianwoo.system.domain.SystemConfig;
import cn.jianwoo.system.domain.extend.SystemConfigExt;

/**
 * 系统配置业务 Mapper
 * 
 * @author GuLihua
 * @date 2020-11-20 10:26
 */
public interface SystemConfBizMapper
{
    /**
     * 获取所有网站配置
     *
     * @return List<SystemConfig>
     * @author gulihua
     */
    List<SystemConfig> selectAllSystemConf();


    /**
     * 获取所有有效的配置
     *
     * @return
     * @author gulihua
     */
    List<SystemConfigExt> selectEffectiveSystemConf();


    /**
     * 通過key更新value
     *
     * @param systemConf 只包含value的对象
     * @param key KEY
     * @return
     * @author gulihua
     */
    int updateSystemConfByKey(@Param("systemConf")
    SystemConfig systemConf, @Param("key")
    String key);
}
