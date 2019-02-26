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
public class BigIntegerData implements IData<BigInteger> {
    @Override
    public BigInteger build(IContext context, Class<BigInteger> bigIntegerClass) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        final String longStr = String.valueOf(random.nextLong());
        return new BigInteger(longStr);
    }
}
