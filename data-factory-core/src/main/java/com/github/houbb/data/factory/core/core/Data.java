package com.github.houbb.data.factory.core.core;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.context.DefaultDataContext;
import com.github.houbb.data.factory.core.support.factory.DataFactoryMapping;
import com.github.houbb.heaven.util.lang.ObjectUtil;

/**
 * 数据的默认实现类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class Data<T> implements IData<T> {

    @Override
    @SuppressWarnings("all")
    public T build(IContext context, Class<T> tClass) {
        if(ObjectUtil.isNull(context)) {
            context = new DefaultDataContext();
        }
        IData data = DataFactoryMapping.getData(tClass);
        return (T) data.build(context, tClass);
    }

}
