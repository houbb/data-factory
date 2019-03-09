package com.github.houbb.data.factory.core.api.data.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntionException;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.StringUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 数字相关处理
 * 1. short byte int long
 * 2. double float
 * 3. bigInteger bigDecimal
 * 4. atomicLong atomicInteger
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
public abstract class AbstractNumberData {

    /**
     * 获取最小值
     * @return 最小值
     */
    protected int getMin() {
        return Integer.MIN_VALUE;
    }

    /**
     * 获取最大值
     * @return 最大值
     */
    protected int getMax() {
        return Integer.MAX_VALUE;
    }

    /**
     * 构建整数部分字符串
     * @param context 上下文
     * @return 构建的结果
     */
    private String buildIntegerString(IContext context) {
        //2. 参数范围的处理
        int minResult = 0;
        int maxResult = 100;

        //1. 参数范围的校验
        DataFactory dataFactory = context.getDataFactory();
        if(ObjectUtil.isNotNull(dataFactory)) {
            // 具体的参数校验
            paramCheck(dataFactory);

            minResult = dataFactory.min();
            maxResult = dataFactory.max();
        }

        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomInt = random.nextInt(minResult, maxResult);
        return String.valueOf(randomInt);
    }

    /**
     * 参数校验
     * @param dataFactory 注解信息
     */
    private void paramCheck(final DataFactory dataFactory) {
        int min = dataFactory.min();
        int max = dataFactory.max();
        if(min > max) {
            throw new DataFactoryRuntionException("DataFactory.min() is not allow great than dataFactory.max().");
        }

        int minAllow = getMin();
        int maxAllow = getMax();
        if(min < minAllow) {
            throw new DataFactoryRuntionException("DataFactory.min() is not allow less than " + minAllow);
        }
        if(max > maxAllow) {
            throw new DataFactoryRuntionException("DataFactory.max() is not allow great than " + maxAllow);
        }
    }

    /**
     * 构建小数部分的字符串
     * @param context 上下文
     * @return 结果
     */
    private String buildDecimalString(IContext context) {
        int precisionResult = 2;

        //1. 参数范围的校验
        DataFactory dataFactory = context.getDataFactory();
        if(ObjectUtil.isNotNull(dataFactory)) {
            precisionResult = dataFactory.precision();
            if(precisionResult < 0) {
                throw new DataFactoryRuntionException("DataFactory.precision() is not allow less than 0.");
            }
        }


        StringBuilder stringBuilder = new StringBuilder();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for(int i = 0; i < precisionResult; i++) {
            int nextInt = random.nextInt(0, 9);
            stringBuilder.append(nextInt);
        }
        return stringBuilder.toString();
    }

    /**
     * 将整数部分和小数部分联合起来
     * @param context 上下文信息
     * @return 结果
     */
    protected String contactIntDecimal(final IContext context) {
        final String integerString = buildIntegerString(context);
        final String decimalString = buildDecimalString(context);
        if(StringUtil.isEmpty(decimalString)) {
            return integerString;
        }

        return integerString+"."+decimalString;
    }

    /**
     * 将整数部分和小数部分联合起来
     * @param context 上下文
     * @return 结果
     */
    protected String contactInt(final IContext context) {
        return buildIntegerString(context);
    }

}
