package cn.jianwoo.common.utils.bean;

@FunctionalInterface
public interface BeanCopyUtilCallBack<S, T>
{

    /**
     * 回调函数
     * 
     * @param source 数据源类
     * @param target 目标类
     */
    void callBack(S source, T target);
}