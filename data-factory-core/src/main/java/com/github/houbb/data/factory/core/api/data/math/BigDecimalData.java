package com.github.houbb.data.factory.core.api.data.math;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

/**
 * BigInteger 的实现处理
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class BigDecimalData implements IData<BigDecimal> {
    @Override
    public BigDecimal build(IContext context, Class<BigDecimal> bigIntegerClass) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        final String string = String.valueOf(random.nextInt());
        return new BigDecimal(string);
    }
}
