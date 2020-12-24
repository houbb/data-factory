package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.core.Data;

/**
 * 数据工具类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public final class DataUtil {

    private DataUtil(){}

    /**
     * 构建结果
     * @param clazz 类型
     * @return 构建结果
     * @param <T> 泛型
     */
    public static <T> T build(final Class<T> clazz) {
        return build(null, clazz);
    }

    /**
     * 构建结果
     * @param context 执行上下文
     * @param clazz 类型
     * @return 构建结果
     * @param <T> 泛型
     */
    @SuppressWarnings("all")
    public static <T> T build(final IContext context, final Class<T> clazz) {
        IData data = new Data();
        return (T) data.build(context, clazz);
    }

}
