package cn.jianwoo.system.mapper.biz;

import org.apache.ibatis.annotations.Param;

/**
 * 索引生成 Mapper
 * 
 * @author GuLihua
 * @date 2020-11-20 10:26
 */
public interface SequenceBizMapper
{
    /**
     * 获取索引
     *
     * @return Long
     * @author gulihua
     */
    Long selectNextSeq(@Param("name")
    String name);
}
