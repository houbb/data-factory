package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.data.factory.core.util.InnerDataUtil;

import java.lang.reflect.Array;

/**
 * 数组的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class ArrayData<T> implements IData<T[]> {

    @Override
    @SuppressWarnings("all")
    public T[] build(IContext context, Class<T[]> aClass) {
        final Class<T> itemClass = (Class<T>) aClass.getComponentType();
        final int size = InnerDataUtil.randomSize();
        T[] arrays = (T[]) Array.newInstance(itemClass, size);
        T item = DataUtil.build(itemClass);

        for(int i = 0; i < size; i++) {
            Array.set(arrays, i, item);
        }

        return arrays;
    }

}
