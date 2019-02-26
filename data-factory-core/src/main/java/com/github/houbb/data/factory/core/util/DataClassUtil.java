package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.core.core.Data;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;

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
        Set<Type> typeSet = new HashSet<>();

        // 添加当前类的泛型接口信息
        Set<Type> currentTypeSet = getGenericInterfaces(clazz);
        typeSet.addAll(currentTypeSet);

        // 所有父类的泛型接口信息
        Class superClass = clazz.getSuperclass();
        // 所有的接口对应的泛型接口信息
        while (!Object.class.equals(superClass)) {
            // 获取父类的所有接口和泛型父类
            Set<Type> superTypeSet = getGenericInterfaces(superClass);
            typeSet.addAll(superTypeSet);

            // 替换到下一个
            superClass = superClass.getSuperclass();
        }

        // 再次获取接口的父类和接口
        //避免并发修改集合异常
//        List<Type> typeList = new ArrayList<>(typeSet);
//        for(Type type : typeList) {
//            Set<Type> moreSuperTypeSet = getGenericInterfaces(type.getClass());
//            typeSet.addAll(moreSuperTypeSet);
//        }
//        typeList = null;

        return new ArrayList<>(typeSet);
    }

    /**
     * 获取当前类的泛型接口信息
     * @param clazz 类
     * @return 泛型接口信息
     */
    private static Set<Type> getGenericInterfaces(final Class clazz) {
        Set<Type> typeSet = new HashSet<>();

        // 添加当前类的泛型接口信息
        Type[] types = clazz.getGenericInterfaces();
        if(ArrayUtil.isNotEmpty(types)) {
            typeSet.addAll(Arrays.asList(types));
        }

        // 当前类的泛型父类信息
        Type superType = clazz.getGenericSuperclass();
        if(ObjectUtil.isNotNull(superType)
                && superType.getClass().isInterface()) {
            typeSet.add(superType);
        }

        //3. 遍历获取接口的父类和接口
        final List<Type> typeList = new ArrayList<>(typeSet);
        for(Type type : typeList) {
            //TODO: 异常
            typeSet.addAll(getGenericInterfaces(type.getClass()));
        }
        //4. 遍历获取父级别接口
        return typeSet;
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

        //TODO: 这里不应该返回 data...
        return Object.class;
    }

}
