package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Short 类型数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class ShortData extends AbstractNumberData implements IData<Short> {

    @Override
    public Short build(IContext context, Class<Short> booleanClass) {
        final String string = super.contactInt(context);
        return Short.valueOf(string);
    }

    @Override
    protected int getMin() {
        return Short.MIN_VALUE;
    }

    @Override
    protected int getMax() {
        return Short.MAX_VALUE;
    }
}
