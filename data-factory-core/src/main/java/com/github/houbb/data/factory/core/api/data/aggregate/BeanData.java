package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;
import com.github.houbb.data.factory.core.api.context.DefaultDataContext;
import com.github.houbb.data.factory.core.api.data.annotation.DefaultDataFactoryAnnotationData;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntimeException;
import com.github.houbb.data.factory.core.util.InnerDataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Bean 对象的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 * @param <T> 泛型类型
 */
public class BeanData<T> implements IData<T> {

    @Override
    @SuppressWarnings("all")
    public T build(IContext context, Class<T> tClass) {
        try {
            List<Field> fieldList = ClassUtil.getAllFieldList(tClass);
            T instance = ClassUtil.newInstance(tClass);

            for(Field field : fieldList) {
                if(Modifier.isFinal(field.getModifiers())) {
                    continue;
                }
                // 初始化上下文
                buildContext(context, field);

                // 字段的类型
                Class<?> fieldClass = field.getType();
                
                // 是否为对应的信息
                Object value = null;
                DataFactory dataFactory = field.getAnnotation(DataFactory.class);
                if(dataFactory != null && dataFactory.data() != IData.class) {
                    value = ClassUtil.newInstance(dataFactory.data()).build(context, fieldClass);
                } else if(dataFactory != null) {
                    // 默认的实现
                    DefaultDataFactoryAnnotationData annotationData = new DefaultDataFactoryAnnotationData();
                    value = annotationData.build(context, fieldClass);
                }

                // 是否为自定义注解
                IAnnotationData annotationData = InnerDataUtil.getDefineDataAnnotation(field);
                if(annotationData != null) {
                    value = annotationData.build(context, fieldClass);
                }

                // 设置对应的值
                field.set(instance, value);
            }
            return instance;
        } catch (IllegalAccessException e) {
            throw new DataFactoryRuntimeException(e);
        }
    }

    /**
     * 构建执行的上下文
     * @param context 执行的上下文
     * @param field 字段信息
     * @return 执行的上下问
     */
    @SuppressWarnings("all")
    private IContext buildContext(IContext context, Field field) {
        final Class fieldType = field.getType();
        Type type = field.getGenericType();

        if(context instanceof DefaultDataContext) {
            DefaultDataContext defaultDataContext = (DefaultDataContext)context;
            defaultDataContext.setCurrentField(field);
            if(type instanceof ParameterizedType) {
                List<Class> genericTypeList = new ArrayList<>();
                // 可遍历的集合
                if(ClassTypeUtil.isIterable(fieldType)) {
                    Class genericType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                    genericTypeList.add(genericType);
                    defaultDataContext.setGenericList(genericTypeList);
                }

                // map
                if(Map.class.isAssignableFrom(fieldType)) {
                    Class genericKeyType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                    Class genericValueType = (Class) ((ParameterizedType) type).getActualTypeArguments()[0];
                    genericTypeList.add(genericKeyType);
                    genericTypeList.add(genericValueType);
                    defaultDataContext.setGenericList(genericTypeList);
                }
            }
        }

        return context;
    }

}
