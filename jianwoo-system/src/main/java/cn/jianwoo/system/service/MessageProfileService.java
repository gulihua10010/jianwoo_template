package cn.jianwoo.system.service;

import java.util.List;

import com.alibaba.fastjson2.JSONObject;
import cn.jianwoo.system.domain.MessageProfile;

/**
 * 消息Service接口
 * 
 * @author jianwoo
 * @date 2023-10-17
 */
public interface MessageProfileService
{
    /**
     * 查询消息
     * 
     * @param id 消息主键
     * @return 消息
     */
     MessageProfile queryMessageProfileById(Long id);

    /**
     * 查询消息列表
     * 
     * @param messageProfile 消息
     * @return 消息集合
     */
    List<MessageProfile> queryMessageProfileList(MessageProfile messageProfile);

    /**
     * 新增消息
     * 
     * @param messageProfile 消息
     */
    void doInsertMessageProfile(MessageProfile messageProfile);

    /**
     * 修改消息
     * 
     * @param messageProfile 消息
     */
    void doUpdateMessageProfile(MessageProfile messageProfile);

    /**
     * 批量删除消息
     * 
     * @param ids 需要删除的消息主键集合
     */
    void doDeleteMessageProfileByIds(Long[] ids);

    /**
     * 删除消息信息
     * 
     * @param id 消息主键
     */
    void doDeleteMessageProfileById(Long id);

    /**
     * 创建消息
     *
     * @param busiSceneCode 业务场景编码
     * @param userName 用户名称
     * @param msgData 消息数据
     * @param bizId 业务ID主键
     * @return
     * @author gulihua
     */
    void doCreateMsg(String busiSceneCode, String userName, JSONObject msgData, String bizId);

}
