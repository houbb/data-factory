package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class IntegerData extends AbstractNumberData implements IData<Integer> {

    @Override
    public Integer build(IContext context, Class<Integer> booleanClass) {
        final String string = super.contactInt(context);
        return Integer.valueOf(string);
    }

}
