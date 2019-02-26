package com.github.houbb.data.factory.core.api.data.reference;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
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
        int randomLength = getRandomLength(random);
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
     * @param random 随机
     * @return 长度
     */
    private int getRandomLength(ThreadLocalRandom random) {
        return 1+random.nextInt(9);
    }

}
