package com.github.houbb.data.factory.api.core;

import java.util.List;

/**
 * 运行上下文
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public interface IContext {

    /**
     * 获取泛型列表
     * 1. 用于指定集合的泛型信息
     * 2. Map 的 K/V 按照顺序存储
     * 3. Iterable 的泛型，指定存储。
     * @return 泛型列表
     */
    List<Class> getGenericList();

}
