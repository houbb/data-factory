package com.github.houbb.data.factory.core.core;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.support.factory.DataFactory;

import java.lang.reflect.Array;

/**
 * 数据的默认实现类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class Data<T> implements IData<T> {

    @Override
    public T build(IContext context, Class<T> tClass) {
        // 映射关系的获取，直接根据 SPI 获取，然后反射映射为 map。
        // 集合
        // 数组
        // map
        // 对象
        // 其他已有的基本类型
        IData data = DataFactory.getData(tClass);
        return (T) data.build(context, tClass);
    }

//    public static void main(String[] args) {
//        String[] strings = new String[]{"a"};
//        System.out.println(strings.getClass().);
//    }
}
