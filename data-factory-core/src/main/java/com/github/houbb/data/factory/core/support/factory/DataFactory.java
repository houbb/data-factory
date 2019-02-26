package com.github.houbb.data.factory.core.support.factory;

import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.aggregate.ArrayData;
import com.github.houbb.data.factory.core.api.data.aggregate.BeanData;
import com.github.houbb.data.factory.core.api.data.aggregate.IterableData;
import com.github.houbb.data.factory.core.api.data.aggregate.MapData;
import com.github.houbb.data.factory.core.api.data.pattern.NullData;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataPrimitiveUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据工厂
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public final class DataFactory {

    /**
     * 存放数据实现的 map
     */
    private static final Map<Class, Class<? extends IData>> DATA_CLASS_MAP = new ConcurrentHashMap<>();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<IData> dataLoader = ServiceLoader.load(IData.class, classLoader);

        for (IData data : dataLoader) {
            final Class<? extends IData> clazz = data.getClass();
            if(isDataFactoryClass(clazz)) {
                final Class genericType = DataClassUtil.getGenericType(clazz, IData.class, 0);
                DATA_CLASS_MAP.put(genericType, clazz);
            }
        }
    }

    /**
     * 判断是否为当前项目的实现，防止外部实现对现有的对象造成影响
     * @param clazz 对象类型
     * @return 是否
     */
    private static boolean isDataFactoryClass(final Class<? extends IData> clazz) {
        final String packageName = clazz.getPackage().getName();
        return packageName.startsWith("com.github.houbb.data.factory.core.api.data.");
    }

    /**
     * 获取对应的 data 实现
     * @param clazz 字段类型
     * @return 结果
     */
    public static IData getData(final Class clazz) {
        // 快速返回
        if(ObjectUtil.isNull(clazz)) {
            return NullData.INSTANCE;
        }

        // 数组/map/集合/bean对象
        if(clazz.isArray()) {
            return new ArrayData();
        }
        if(ClassTypeUtil.isIterable(clazz)) {
            return new IterableData();
        }
        if(ClassTypeUtil.isMap(clazz)) {
            return new MapData();
        }

        // JDK 相关类型
        if(ClassTypeUtil.isJdk(clazz)) {
            Class realClazz = DataPrimitiveUtil.getReferenceType(clazz);
            final Class<? extends IData> dataClass = DATA_CLASS_MAP.get(realClazz);
            if(ObjectUtil.isNull(dataClass)) {
                return NullData.INSTANCE;
            }
            return ClassUtil.newInstance(dataClass);
        }

        // 用户自定义 java bean
        return new BeanData();
    }

}
