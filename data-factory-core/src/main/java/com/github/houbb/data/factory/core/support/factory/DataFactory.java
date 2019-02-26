package com.github.houbb.data.factory.core.support.factory;

import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.pattern.NullData;
import com.github.houbb.data.factory.core.core.Data;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataPrimitiveUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
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
     * 2. 是否需要对原始的包信息进行保护校验。
     */
    private static final Map<Class, Class<? extends IData>> DATA_CLASS_MAP = new ConcurrentHashMap<>();

    /**
     * 空对象模式实现
     */
    private static final IData NULL_DATA = new NullData();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<IData> dataLoader = ServiceLoader.load(IData.class, classLoader);

        for (IData data : dataLoader) {
            final Class<? extends IData> clazz = data.getClass();
            final Class genericType = getGenericType(clazz);
            DATA_CLASS_MAP.put(genericType, clazz);
        }
    }


    /**
     * 获取对应的 data 实现
     * @param clazz 字段类型
     * @return 结果
     */
    public static IData getData(final Class clazz) {
        // 快速返回
        if(ObjectUtil.isNull(clazz)) {
            return NULL_DATA;
        }

        // 数组/map/集合/bean对象


        // 其他已有类型的处理
        Class realClazz = DataPrimitiveUtil.getReferenceType(clazz);
        final Class<? extends IData> dataClass = DATA_CLASS_MAP.get(realClazz);
        IData data = ClassUtil.newInstance(dataClass);
        if(ObjectUtil.isNull(data)) {
            return NULL_DATA;
        }
        return data;
    }

    /**
     * 获取泛型类型
     * @param dataClass 数据类型
     * @return 对应的泛型类型
     */
    private static Class getGenericType(final Class<? extends IData> dataClass) {
        List<Type> typeList = DataClassUtil.getAllGenericInterfaces(dataClass);
        for(Type type : typeList) {
            if(type instanceof ParameterizedType
                && IData.class.equals(((ParameterizedType) type).getRawType())) {
                ParameterizedType p = (ParameterizedType)type;
                return (Class) p.getActualTypeArguments()[0];
            }
        }

        return Data.class;
    }

    /**
     * 是否为空对象模式
     * @param data 类型
     * @return 是否
     */
    public static boolean isNullData(final IData data) {
        if(ObjectUtil.isNull(data)) {
            return false;
        }
        return NULL_DATA.getClass().equals(data.getClass());
    }

}
