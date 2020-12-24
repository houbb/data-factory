package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.data.factory.core.util.InnerDataUtil;
import com.google.auto.service.AutoService;

/**
 * double 数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.7
 */
@AutoService(IData.class)
public class DoubleArrayData implements IData<double[]> {

    @Override
    public double[] build(IContext context, Class<double[]> aClass) {
        int size = InnerDataUtil.randomSize();
        double[] array = new double[size];
        for(int i = 0; i < size; i++) {
            array[i] = DataUtil.build(double.class);
        }
        return array;
    }

}
