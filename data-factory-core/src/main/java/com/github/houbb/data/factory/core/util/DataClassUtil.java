package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.core.Data;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class DataClassUtil {

    /**
     * 获取所有带有泛型的接口信息
     * @param clazz 类信息
     * @return Type 列表
     */
    public static List<Type> getAllGenericInterfaces(final Class clazz) {
        List<Type> typeList = new ArrayList<>();

        // 当前类的泛型接口信息
        Type[] types = clazz.getGenericInterfaces();
        if(ArrayUtil.isNotEmpty(types)) {
            typeList.addAll(Arrays.asList(types));
        }

        // 所有父类的泛型接口信息
        Class superClass = clazz.getSuperclass();
        while (!Object.class.equals(superClass)) {
            Type[] superTypes = superClass.getGenericInterfaces();
            if(ArrayUtil.isNotEmpty(superTypes)) {
                typeList.addAll(Arrays.asList(superTypes));
            }
            superClass = superClass.getSuperclass();
        }

        return typeList;
    }

    /**
     * 获取泛型类型
     * @param clazz 数据类型
     * @param interfaceClass 接口对应的 class 信息
     * @param index 泛型的下标志位置
     * @return 对应的泛型类型
     */
    public static Class getGenericType(final Class clazz,
                                        final Class interfaceClass,
                                        final int index) {
        List<Type> typeList = DataClassUtil.getAllGenericInterfaces(clazz);
        for(Type type : typeList) {
            if(type instanceof ParameterizedType
                    && interfaceClass.equals(((ParameterizedType) type).getRawType())) {
                ParameterizedType p = (ParameterizedType)type;
                return (Class) p.getActualTypeArguments()[index];
            }
        }

        return Data.class;
    }

}
