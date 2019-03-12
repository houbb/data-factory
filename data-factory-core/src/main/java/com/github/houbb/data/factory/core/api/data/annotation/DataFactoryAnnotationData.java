package com.github.houbb.data.factory.core.api.data.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.api.core.IRegexGen;
import com.github.houbb.data.factory.core.api.context.DefaultDataContext;
import com.github.houbb.data.factory.core.api.regex.DefaultRegexGen;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntimeException;
import com.github.houbb.data.factory.core.util.DataPrimitiveUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 注解相关信息处理
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
public class DataFactoryAnnotationData implements IData<Object> {

    /**
     * 获取示例对象
     * ps: 当前类属于 stateless 类，是线程安全的
     */
    private static final IData INSTANCE = new DataFactoryAnnotationData();

    /**
     * 获取实例对象
     * @return 对象实例
     */
    public static IData getInstance() {
        return INSTANCE;
    }

    @Override
    public Object build(IContext context, Class<Object> objectClass) {
        Field field = context.getCurrentField();
        Class<?> fieldType = field.getType();

        if(field.isAnnotationPresent(DataFactory.class)) {
            DataFactory dataFactory = field.getAnnotation(DataFactory.class);

            // 忽略字段，直接返回 null
            if (dataFactory.ignore()) {
                return null;
            }
            // 如果 regex 不为空，直接返回 regex 信息
            IRegexGen regexGen = new DefaultRegexGen();
            final String regex = dataFactory.regex();
            if(StringUtil.isNotEmpty(regex)) {
                if(fieldType.isPrimitive()) {
                    fieldType = DataPrimitiveUtil.getReferenceType(fieldType);
                }
                final String regexResult = regexGen.generate(regex);
                return newInstance(fieldType, regexResult);
            }

            // 设置 DataFactory 注解信息，便于获得。
            if(context instanceof DefaultDataContext) {
                DefaultDataContext defaultDataContext = (DefaultDataContext)context;
                defaultDataContext.setDataFactory(dataFactory);
            }
        }

        // 其他保持不变，依然调用原来的各类对象。
        return DataUtil.build(context, fieldType);
    }

    /**
     * 创建对应的实例
     * 1. 根据类的 class 直接创建。
     * @param fieldType 字段类型
     * @param string 字符串
     * @return 结果
     */
    private Object newInstance(Class<?> fieldType, final String string) {
        // 如果为字符串，考虑到性能开销，直接返回本身
        if(String.class.equals(fieldType)) {
            return string;
        }

        // 其他类型，当为空时，则视为 null
        if(StringUtil.isEmpty(string)) {
            return null;
        }

        try {
            // 获取所有的构造器，直接反射调用 constructor(string)
            Constructor constructor = fieldType.getConstructor(String.class);
            return constructor.newInstance(string);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            //TODO: 这里应该考虑到有些没有提供 String 构造器的类。
            throw new DataFactoryRuntimeException(e);
        }
    }

}
