package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.data.factory.core.util.InnerDataUtil;
import com.google.auto.service.AutoService;

/**
 * int 数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.7
 */
@AutoService(IData.class)
public class IntegerArrayData implements IData<int[]> {

    @Override
    public int[] build(IContext context, Class<int[]> aClass) {
        int size = InnerDataUtil.randomSize(1, 10);
        int[] array = new int[size];
        for(int i = 0; i < size; i++) {
            array[i] = DataUtil.build(int.class);
        }
        return array;
    }

}
