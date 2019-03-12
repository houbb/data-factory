package com.github.houbb.data.factory.core.api.data.lang;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntimeException;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.google.auto.service.AutoService;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 字符串数据实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class StringData implements IData<String> {

    /**
     * 基础字符
     */
    private static final char[] CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    @Override
    public String build(IContext context, Class<String> booleanClass) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int randomLength = getRandomLength(context, random);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < randomLength; i++) {
            int charIndex = random.nextInt(CHARS.length);
            stringBuilder.append(CHARS[charIndex]);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取随机的长度
     * 1-10 随机长度
     * @param context 执行上下文
     * @param random 随机
     * @return 长度
     */
    private int getRandomLength(final IContext context, final ThreadLocalRandom random) {
        int minLenResult = 1;
        int maxLenResult = 10;

        DataFactory dataFactory = context.getDataFactory();
        if(ObjectUtil.isNotNull(dataFactory)) {
            paramCheck(dataFactory);

            minLenResult = dataFactory.minLen();
            maxLenResult = dataFactory.maxLen();
        }
        return minLenResult+random.nextInt(maxLenResult-1);
    }

    /**
     * 参数校验
     * @param dataFactory 注解
     */
    private void paramCheck(DataFactory dataFactory) {
        int minLen = dataFactory.minLen();
        int maxLen = dataFactory.maxLen();

        if(minLen < 0) {
            throw new DataFactoryRuntimeException("DataFactory.minLen() not allow less than 0.");
        }
        if(minLen > maxLen) {
            throw new DataFactoryRuntimeException("DataFactory.maxLen() not allow less than DataFactory.minLen().");
        }
    }

}
