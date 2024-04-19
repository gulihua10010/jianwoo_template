package cn.jianwoo.system.service;

/**
 * 索引 DAO
 *
 * @author gulihua
 * @date 2023-07-20 22:00
 */
public interface ISequenceService
{

    /**
     * 获取索引
     *
     * @return Long
     * @author gulihua
     */
    Long queryRoleKeyNextSeq();


    /**
     * 获取索引
     *
     * @return Long
     * @author gulihua
     */
    Long queryTaskNextSeq();
}
