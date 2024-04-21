package cn.jianwoo.system.service.impl;

import cn.jianwoo.system.mapper.biz.SequenceBizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jianwoo.system.service.SequenceService;

/**
 * 索引 DAO 实现
 * 
 * @author gulihua
 * @Description
 * @date 2023-07-20 22:00
 */
@Service
public class SequenceServiceImpl implements SequenceService
{

    @Autowired
    SequenceBizMapper sequenceBizMapper;

    @Override
    public Long queryRoleKeyNextSeq()
    {
        return sequenceBizMapper.selectNextSeq("ROLE");
    }

    @Override
    public Long queryTaskNextSeq()
    {
        return sequenceBizMapper.selectNextSeq("TASK");
    }
}
