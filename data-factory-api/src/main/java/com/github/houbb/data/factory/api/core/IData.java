package com.github.houbb.data.factory.api.core;

/**
 * 数据构建接口
 * 1. 为了后期的拓展性，考虑并行的可能性
 * 2. 如果为基本类型，则直接返回对应的随机值。
 * 3. 后期指定 @DataFactory/@DataFactoryEntry，考虑拓展性。
 * 4. 正则表达式的相关实现。
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public interface IData<T> {

    /**
     * 构建数据
     *
     * @param tClass 对象类型
     */
    T build(final Class<T> tClass);

}
