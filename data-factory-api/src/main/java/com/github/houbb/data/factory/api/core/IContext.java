package com.github.houbb.data.factory.api.core;

import com.github.houbb.data.factory.api.annotation.DataFactory;

import java.lang.reflect.Field;
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

    /**
     * 获取当前字段信息
     * @since 0.0.2
     * @return 当前字段信息
     */
    Field getCurrentField();

    /**
     * 获取注解信息
     * @since 0.0.2
     * @return 注解信息
     */
    DataFactory getDataFactory();

}
