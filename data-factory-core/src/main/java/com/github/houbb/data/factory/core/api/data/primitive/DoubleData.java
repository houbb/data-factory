package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Double 数据初始化
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class DoubleData extends AbstractNumberData implements IData<Double> {

    @Override
    public Double build(IContext context, Class<Double> booleanClass) {
        final String string = super.contactIntDecimal(context);
        return Double.valueOf(string);
    }

}
