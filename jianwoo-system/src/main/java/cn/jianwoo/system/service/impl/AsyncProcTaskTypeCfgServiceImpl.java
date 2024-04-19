package cn.jianwoo.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.alibaba.fastjson2.JSON;
import cn.jianwoo.common.constant.HttpStatus;
import cn.jianwoo.common.exception.E;
import cn.jianwoo.common.utils.MessageUtils;
import org.springframework.transaction.annotation.Transactional;
import cn.jianwoo.system.mapper.AsyncProcTaskTypeCfgMapper;
import cn.jianwoo.system.domain.AsyncProcTaskTypeCfg;
import cn.jianwoo.system.service.IAsyncProcTaskTypeCfgService;


/**
 * 异步任务配置Service业务层处理
 * 
 * @author jianwoo
 * @date 2023-11-03
 */
@Service
public class AsyncProcTaskTypeCfgServiceImpl implements IAsyncProcTaskTypeCfgService 
{
    @Autowired
    private AsyncProcTaskTypeCfgMapper asyncProcTaskTypeCfgMapper;

    /**
     * 查询异步任务配置
     * 
     * @param taskType 异步任务配置主键
     * @return 异步任务配置
     */
    @Override
    public AsyncProcTaskTypeCfg queryAsyncProcTaskTypeCfgByTaskType(String taskType)
    {
        AsyncProcTaskTypeCfg asyncProcTaskTypeCfg = asyncProcTaskTypeCfgMapper.selectByPrimaryKey(taskType);
        if (asyncProcTaskTypeCfg == null)
        {
            throw new E(HttpStatus.NOT_FOUND, MessageUtils.message("asyncProcTaskTypeCfg.not.exist", taskType));
        }
        return asyncProcTaskTypeCfg;
    }

    /**
     * 查询异步任务配置列表
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 异步任务配置
     */
    @Override
    public List<AsyncProcTaskTypeCfg> queryAsyncProcTaskTypeCfgList(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg)
    {
        return asyncProcTaskTypeCfgMapper.selectList(asyncProcTaskTypeCfg);
    }

    /**
     * 新增异步任务配置
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    @Override
    public void doInsertAsyncProcTaskTypeCfg(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg)
    {
        asyncProcTaskTypeCfg.fillInfoBeforeCreate();
        int rows = asyncProcTaskTypeCfgMapper.insertSelective(asyncProcTaskTypeCfg);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("asyncProcTaskTypeCfg.create.failed"));
        }
    }

    /**
     * 修改异步任务配置
     * 
     * @param asyncProcTaskTypeCfg 异步任务配置
     * @return 结果
     */
    @Override
    public void doUpdateAsyncProcTaskTypeCfg(AsyncProcTaskTypeCfg asyncProcTaskTypeCfg)
    {
        asyncProcTaskTypeCfg.fillInfoBeforeUpdate();
        int rows = asyncProcTaskTypeCfgMapper.updateByPrimaryKeySelective(asyncProcTaskTypeCfg);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("asyncProcTaskTypeCfg.update.failed", asyncProcTaskTypeCfg.getTaskType()));
        }
    }

    /**
     * 批量删除异步任务配置
     * 
     * @param taskTypes 需要删除的异步任务配置主键
     * @return 结果
     */
    @Override
    public void doDeleteAsyncProcTaskTypeCfgByTaskTypes(String[] taskTypes)
    {
        int rows = asyncProcTaskTypeCfgMapper.deleteByPrimaryKeys(taskTypes);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST,
                    MessageUtils.message("asyncProcTaskTypeCfgs.delete.failed", JSON.toJSONString(taskTypes)));
        }
    }

    /**
     * 删除异步任务配置信息
     * 
     * @param taskType 异步任务配置主键
     * @return 结果
     */
    @Override
    public void doDeleteAsyncProcTaskTypeCfgByTaskType(String taskType)
    {
        int rows = asyncProcTaskTypeCfgMapper.deleteByPrimaryKey(taskType);
        if (rows == 0)
        {
            throw new E(HttpStatus.BAD_REQUEST, MessageUtils.message("asyncProcTaskTypeCfg.delete.failed", taskType));
        }
    }
}
