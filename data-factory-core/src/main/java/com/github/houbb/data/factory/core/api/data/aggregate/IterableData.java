package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/**
 * map 集合的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class IterableData<T> implements IData<Iterable<T>> {

    @Override
    public Iterable<T> build(IContext context, Class<Iterable<T>> iterableClass) {
        // 直接存放线性表
        Iterable<T> list = new ArrayList<>();

        final Class<?> itemClass = DataClassUtil.getGenericType(iterableClass, Iterable.class, 0);
        final Object object = DataUtil.build(context, itemClass);
        ((ArrayList) list).add(object);
        return list;
    }

}
