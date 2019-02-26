package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class ByteData implements IData<Byte> {

    @Override
    public Byte build(IContext context, Class<Byte> booleanClass) {
        ThreadLocalRandom random =  ThreadLocalRandom.current();
        String indexString = String.valueOf(random.nextInt(127)-128);
        return Byte.valueOf(indexString);
    }

}
