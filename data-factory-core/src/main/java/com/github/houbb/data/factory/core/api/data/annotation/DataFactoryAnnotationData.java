package com.github.houbb.data.factory.core.api.data.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.context.DefaultDataContext;
import com.github.houbb.data.factory.core.util.DataUtil;

import java.lang.reflect.Field;

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

            // 设置 DataFactory 注解信息，便于获得。
            if(context instanceof DefaultDataContext) {
                DefaultDataContext defaultDataContext = (DefaultDataContext)context;
                defaultDataContext.setDataFactory(dataFactory);
            }
        }

        // 其他保持不变，依然调用原来的各类对象。
        return DataUtil.build(context, fieldType);
    }

}
