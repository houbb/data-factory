package com.github.houbb.data.factory.core.api.data.math;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.annotation.AbstractNumberData;
import com.google.auto.service.AutoService;

import java.math.BigDecimal;

/**
 * BigInteger 的实现处理
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class BigDecimalData extends AbstractNumberData implements IData<BigDecimal> {

    @Override
    public BigDecimal build(IContext context, Class<BigDecimal> bigIntegerClass) {
        final String string = super.contactIntDecimal(context);
        return new BigDecimal(string);
    }

}
