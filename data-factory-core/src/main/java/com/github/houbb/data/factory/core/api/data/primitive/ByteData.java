package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class ByteData extends AbstractNumberData implements IData<Byte> {

    @Override
    public Byte build(IContext context, Class<Byte> booleanClass) {
        String string = super.contactInt(context);
        return Byte.valueOf(string);
    }

    @Override
    protected int getMin() {
        return Byte.MIN_VALUE;
    }

    @Override
    protected int getMax() {
        return Byte.MAX_VALUE;
    }
}
