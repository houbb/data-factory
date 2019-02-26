package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class CharData implements IData<Character> {

    /**
     * 限制
     */
    private static final int LIMIT = 65535;

    @Override
    public Character build(IContext context, Class<Character> booleanClass) {
        ThreadLocalRandom random =  ThreadLocalRandom.current();
        final int index = random.nextInt(LIMIT);
        return (char) index;
    }

}
