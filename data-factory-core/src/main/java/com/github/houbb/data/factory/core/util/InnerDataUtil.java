package com.github.houbb.data.factory.core.util;

import com.github.houbb.heaven.util.common.ArgUtil;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 内部工具类
 * @author binbin.hou
 * @since 0.0.7
 */
public final class InnerDataUtil {

    private InnerDataUtil(){}

    /**
     * 随机生成大小
     * @param min 最小值
     * @param max 最大值
     * @return 结果
     * @since 0.0.7
     */
    public static int randomSize(final int min, final int max) {
        ArgUtil.notNegative(min, "最小值");
        ArgUtil.assertTrue(max >= min, "最大值必须大于等于最小值");

        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(min, max);
    }

}
