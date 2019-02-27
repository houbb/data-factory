package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

        // 获取元素类型
        final Class<?> itemClass = iterableClass.getComponentType();
        final Object object = DataUtil.build(context, itemClass);
        ((ArrayList) list).add(object);
        return list;
    }

    /**
     * TODO: 因为泛型擦除，无法获取到对应的泛型信息
     * @param args
     */
    public static void main(String[] args) {
        // 字段。
        List<String> stringList = new ArrayList<>();
        ObjectTest<String> objectTest = new ObjectTest<>();
        objectTest.setIterable(stringList);

        for(Field field : ClassUtil.getAllFieldList(objectTest.getClass())) {
            Type genericType = field.getGenericType();
            if(genericType == null) continue;
            // 如果是泛型参数的类型
            if(genericType instanceof ParameterizedType){
                ParameterizedType pt = (ParameterizedType) genericType;
                //得到泛型里的class类型对象
                if(pt.getActualTypeArguments()[0] instanceof Class) {
                    Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
                    System.out.println("result: " + genericClazz);
                }
            }
            System.out.println();
        }

//        System.out.println(stringList.getClass());
//        String[] strings = (String[]) ArrayUtil.toArray(stringList);
//        System.out.println(strings.getClass().getComponentType());
//        Type type = stringList.getClass();
//        if(type instanceof ParameterizedType){
//            ParameterizedType pt = (ParameterizedType) type;
//            //得到泛型里的class类型对象
//            Class<?> genericClazz = (Class<?>)pt.getActualTypeArguments()[0];
//            System.out.println(genericClazz);
//        }
    }

}
