package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

/**
 * 数组的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 * @param <T> 泛型类型
 */
public class ArrayData<T> implements IData<T[]> {

    @Override
    public T[] build(IContext context, Class<T[]> aClass) {
        return null;
    }

}
