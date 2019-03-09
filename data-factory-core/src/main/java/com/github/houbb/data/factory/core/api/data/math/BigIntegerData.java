package com.github.houbb.data.factory.core.api.data.math;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

import java.math.BigInteger;

/**
 * BigInteger 的实现处理
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class BigIntegerData extends AbstractNumberData implements IData<BigInteger> {

    @Override
    public BigInteger build(IContext context, Class<BigInteger> bigIntegerClass) {
        final String string = super.contactInt(context);
        return new BigInteger(string);
    }

}
