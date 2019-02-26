package com.github.houbb.data.factory.core.support.factory;

import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.core.Data;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
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
     * TODO: 是否存在并发的问题
     */
    private static final Map<Class, IData> DATA_MAP = new ConcurrentHashMap<>();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ServiceLoader<IData> dataLoader = ServiceLoader.load(IData.class, classLoader);

        for (IData data : dataLoader) {
            final Class<? extends IData> clazz = data.getClass();
            final Class genericType = getGenericType(clazz);

            final IData dataInstance = ClassUtil.newInstance(clazz);
            DATA_MAP.put(genericType, dataInstance);
        }
    }


    /**
     * 获取对应的 data 实现
     * @param clazz 字段类型
     * @return 结果
     */
    public static IData getData(final Class clazz) {
        IData data = DATA_MAP.get(clazz);
        if(ObjectUtil.isNull(data)) {
            //TODO: 使用 new 的方式，是否造成了内存的浪费？
            data = new Data();
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

}
