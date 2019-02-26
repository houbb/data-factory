package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * boolean 数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class BoolData implements IData<Boolean> {

    @Override
    public Boolean build(IContext context, Class<Boolean> booleanClass) {
        ThreadLocalRandom random =  ThreadLocalRandom.current();
        return random.nextBoolean();
    }

}
