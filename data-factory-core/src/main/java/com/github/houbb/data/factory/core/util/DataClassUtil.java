package com.github.houbb.data.factory.core.util;

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

        // 当前类的父类
        Class superClass = clazz.getSuperclass();
        // 所有的接口对应的泛型接口信息
        while (!Object.class.equals(superClass)) {
            // 获取父类的所有接口和泛型父类
            Set<Type> superTypeSet = getGenericInterfaces(superClass);
            typeSet.addAll(superTypeSet);

            // 替换到下一个
            superClass = superClass.getSuperclass();
        }

        // 最后处理一下接口信息相关的父类信息+父类接口信息
//        final List<Type> typeList = new ArrayList<>(typeSet);
//        for(Type type : typeList) {
//            if(type instanceof ParameterizedType
//                    && Collection.class.equals(((ParameterizedType) type).getRawType())) {
//                final Class rawClass = (Class) ((ParameterizedType) type).getRawType();
//                final Set<Type> parentInterfaces = getGenericParentInterfaces(rawClass);
//                System.out.println("-----" + parentInterfaces);
//                typeSet.addAll(parentInterfaces);
//            }
//        }

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

        return typeSet;
    }

    /**
     * 获取当前类的父类泛型接口信息
     * @param clazz 类
     * @return 泛型接口信息
     */
    private static Set<Type> getGenericParentInterfaces(final Class clazz) {
        Set<Type> typeSet = new HashSet<>();

        // 添加当前泛型父类信息
        Type supperClass = clazz.getGenericSuperclass();
        if(ObjectUtil.isNotNull(supperClass)
            && supperClass.getClass().isInterface()) {
            typeSet.add(supperClass);
        }

        // 当前类的泛型父类接口信息
        Type[] superInterfaces = clazz.getGenericInterfaces();
        if(ArrayUtil.isNotEmpty(superInterfaces)) {
            typeSet.addAll(Arrays.asList(superInterfaces));
        }

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
                    && interfaceClass.equals(((ParameterizedType) type).getRawType())
                     ) {
                ParameterizedType p = (ParameterizedType)type;
                return (Class) p.getActualTypeArguments()[index];
            }
        }

        return Object.class;
    }

//    /**
//     * 获取当前类的泛型类型
//     * @param clazz 数据类型
//     * @param index 泛型的下标志位置
//     * @return 对应的泛型类型
//     */
//    public static Class getGenericType(final Class clazz,
//                                       final int index) {
//        List<Type> typeList = clazz.getG;
//        for(Type type : typeList) {
//            if(type instanceof ParameterizedType) {
//                ParameterizedType p = (ParameterizedType)type;
//                return (Class) p.getActualTypeArguments()[index];
//            }
//        }
//
//        return Object.class;
//    }

}
