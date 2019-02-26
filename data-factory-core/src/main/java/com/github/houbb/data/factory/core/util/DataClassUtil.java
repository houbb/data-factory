package com.github.houbb.data.factory.core.util;

import com.github.houbb.heaven.util.util.ArrayUtil;

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

    public static void main(String[] args) {
        System.out.println(Arrays.asList(null));
    }

}
