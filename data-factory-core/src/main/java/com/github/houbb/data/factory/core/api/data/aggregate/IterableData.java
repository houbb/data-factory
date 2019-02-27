package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntionException;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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
        Iterable<T> result = newInstance(iterableClass);
        if(CollectionUtil.isEmpty(context.getGenericList())) {
            return result;
        }

        // 获取元素类型
        final Class<T> itemClass = context.getGenericList().get(0);
        final T object = DataUtil.build(context, itemClass);

        // 新增元素
        ((Collection<T>) result).add(object);

        return result;
    }

    /**
     * 创建对应的实例
     * @param iterableClass 类
     * @return 结果
     */
    private Iterable<T> newInstance(final Class<Iterable<T>> iterableClass) {
        try {
            return ClassUtil.newInstance(iterableClass);
        } catch (Exception e) {
            if(List.class.isAssignableFrom(iterableClass)) {
                return new ArrayList<>();
            }
            if(Set.class.isAssignableFrom(iterableClass)) {
                return new HashSet<>();
            }
            if(Queue.class.isAssignableFrom(iterableClass)) {
                return new ArrayDeque<>();
            }
            throw new DataFactoryRuntionException(e);
        }
    }

}
