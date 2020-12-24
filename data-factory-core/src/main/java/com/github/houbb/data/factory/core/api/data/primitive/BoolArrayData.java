package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.data.factory.core.util.InnerDataUtil;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * boolean 数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.7
 */
@AutoService(IData.class)
public class BoolArrayData implements IData<boolean[]> {

    @Override
    public boolean[] build(IContext context, Class<boolean[]> aClass) {
        int size = InnerDataUtil.randomSize();
        boolean[] array = new boolean[size];
        for(int i = 0; i < size; i++) {
            array[i] = DataUtil.build(boolean.class);
        }
        return array;
    }

}
