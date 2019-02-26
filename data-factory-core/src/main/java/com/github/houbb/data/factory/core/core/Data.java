package com.github.houbb.data.factory.core.core;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.support.factory.DataFactory;

/**
 * 数据的默认实现类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class Data<T> implements IData<T> {

    @Override
    public T build(IContext context, Class<T> tClass) {
        IData data = DataFactory.getData(tClass);
        return (T) data.build(context, tClass);
    }

}
