package cn.jianwoo.system.task.domain;

import java.io.Serializable;

import cn.jianwoo.common.constant.TaskConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @blog https://jianwoo.cn
 * @author gulihua
 * @github https://github.com/gulihua10010/
 * @bilibili 顾咕咕了
 * @date 2021-07-18 0:56
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResultBO implements Serializable
{
    private static final long serialVersionUID = -7982293393643864925L;

    /** 结果代码 */
    private String code;
    /** 结果消息 */
    private String msg;

    public static TaskResultBO SUCCESS()
    {
        return new TaskResultBO(TaskConstants.SUCCESS_CODE, TaskConstants.SUCCESS_MSG);
    }


    public static TaskResultBO SUCCESS(String desc)
    {
        return new TaskResultBO(TaskConstants.SUCCESS_CODE, desc);
    }


    public static TaskResultBO FAILED(String reason)
    {
        return new TaskResultBO(TaskConstants.FAILED_CODE, reason);
    }


    public boolean isSuccess()
    {
        return this.code.equals(TaskConstants.SUCCESS_CODE);
    }

}
