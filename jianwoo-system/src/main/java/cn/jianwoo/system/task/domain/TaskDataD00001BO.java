package cn.jianwoo.system.task.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson2.JSONObject;

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
public class TaskDataD00001BO implements Serializable
{

    /** 邮箱主键 */
    private Long emailOid;
}
