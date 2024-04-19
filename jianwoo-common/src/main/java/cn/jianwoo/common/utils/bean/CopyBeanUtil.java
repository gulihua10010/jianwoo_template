package cn.jianwoo.common.utils.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.util.Assert;

import cn.hutool.core.bean.BeanUtil;

/**
 * @author GuLihua
 * @Description Bean 拷贝扩展
 * @date 2021-06-01 15:35
 */
public class CopyBeanUtil
{
    private static final Logger logger = LoggerFactory.getLogger(CopyBeanUtil.class);

    /**
     * copyProperties扩展;<br/>
     * 支持自定义类型的属性 (eg:从BO复制到VO,或者VO复制到BO);<br/>
     * 支持list复制(必须指定泛型类型);<br/>
     * 属性必须相同，get和set的方法名必须相同
     *
     * @param source source Bean
     * @param target target Bean
     * @return
     * @author gulihua
     */
    public static void copyProperties(Object source, Object target) throws BeansException
    {
        BeanUtil.copyProperties(source, target);

    }


    /**
     * 集合数据的拷贝
     *
     * @param sources: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @return 目标类集合
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target)
    {
        return copyListProperties(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param sources: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数(eg: (source, target) -> target.setField(source.getField);)
     * @return 目标类集合
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target,
            BeanCopyUtilCallBack<S, T> callBack)
    {
        Assert.notNull(sources, "Sources must not be null");
        Assert.notNull(target, "Target must not be null");

        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources)
        {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null)
            {
                // 回调
                callBack.callBack(source, t);
            }
        }
        return list;
    }


    /**
     * 集合数据的拷贝
     *
     * @param source: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @return 目标类集合
     */
    public static <S, T> T copyProperties(S source, Supplier<T> target)
    {
        return copyProperties(source, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     *
     * @param source: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数(eg: (source, target) -> target.setField(source.getField);)
     * @return 目标类集合
     */
    public static <S, T> T copyProperties(S source, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack)
    {
        Assert.notNull(source, "Sources must not be null");
        Assert.notNull(target, "Target must not be null");

        T t = target.get();
        copyProperties(source, t);
        if (callBack != null)
        {
            // 回调
            callBack.callBack(source, t);
        }
        return t;
    }

}
