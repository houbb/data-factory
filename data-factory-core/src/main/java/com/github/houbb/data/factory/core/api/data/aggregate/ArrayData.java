package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataUtil;

import java.lang.reflect.Array;

/**
 * 数组的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class ArrayData implements IData<Object[]> {

    @Override
    public Object[] build(IContext context, Class<Object[]> aClass) {
        Object[] arrays = (Object[]) Array.newInstance(aClass, 1);
        Object object = DataUtil.build(aClass);
        Array.set(arrays, 0, object);
        return arrays;
    }

}
