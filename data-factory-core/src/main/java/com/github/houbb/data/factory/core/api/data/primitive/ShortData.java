package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Short 类型数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class ShortData implements IData<Short> {

    @Override
    public Short build(IContext context, Class<Short> booleanClass) {
        ThreadLocalRandom random =  ThreadLocalRandom.current();
        return (short)random.nextInt(Short.MAX_VALUE);
    }

}
