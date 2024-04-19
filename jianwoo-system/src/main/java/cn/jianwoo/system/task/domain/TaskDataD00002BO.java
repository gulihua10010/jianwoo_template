package cn.jianwoo.system.task.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author gulihua
 * @Description
 * @date 2022-05-07 14:21
 */
@Data
@EqualsAndHashCode()
@NoArgsConstructor
@AllArgsConstructor
public class TaskDataD00002BO implements Serializable
{
    /**
     * 邮件表主键
     */
    private Long oid;
}
