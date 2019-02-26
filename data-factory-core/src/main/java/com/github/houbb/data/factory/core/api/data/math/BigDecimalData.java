package com.github.houbb.data.factory.core.api.data.math;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

/**
 * BigInteger 的实现处理
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class BigDecimalData implements IData<BigDecimal> {
    @Override
    public BigDecimal build(IContext context, Class<BigDecimal> bigIntegerClass) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return new BigDecimal(random.nextLong());
    }
}
