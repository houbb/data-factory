package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntionException;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Bean 对象的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 * @param <T> 泛型类型
 */
public class BeanData<T> implements IData<T> {

    @Override
    public T build(IContext context, Class<T> tClass) {
        try {
            List<Field> fieldList = ClassUtil.getAllFieldList(tClass);
            T instance = ClassUtil.newInstance(tClass);

            for(Field field : fieldList) {
                Class<?> fieldType = field.getType();
                Object value = DataUtil.build(context, fieldType);
                field.set(instance, value);
            }
            return instance;
        } catch (IllegalAccessException e) {
            throw new DataFactoryRuntionException(e);
        }
    }

}
