package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.core.Data;
import com.github.houbb.heaven.util.lang.ObjectUtil;

/**
 * 数据工具类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public final class DataUtil {

    /**
     * 用于保存当前线程的信息
     */
    private static final ThreadLocal<IData> THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 构建结果
     * @param clazz 类型
     * @return 构建结果
     */
    public static <T> T build(final Class<T> clazz) {
        IData data = getInstance();
        return (T) data.build(null, clazz);
    }

    /**
     * 获取对应的实现
     * 1. 线程安全
     * @return 结果
     */
    private static IData getInstance() {
        IData data = THREAD_LOCAL.get();
        if(ObjectUtil.isNull(data)) {
            data = new Data();
            THREAD_LOCAL.set(data);
        }
        return data;
    }


    /**
     * 清空
     * 1. 建议在每个线程执行结束，调用
     */
    public static void clear() {
        THREAD_LOCAL.remove();
    }


    public static void main(String[] args) {
        System.out.println(DataUtil.build(Boolean.class));
        System.out.println(DataUtil.build(boolean.class));
    }

}
