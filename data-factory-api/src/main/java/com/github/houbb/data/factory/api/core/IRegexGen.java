/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.core;

/**
 * <p> 正则表达式生成 </p>
 *
 * <pre> Created: 2019/3/11 11:12 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.3
 */
public interface IRegexGen {

    /**
     * 根据正则表达式生成随机的字符串
     * TODO:// 直接使用成熟框架，后期替换成为自己的实现。
     * @param regex 正则表达式
     * @return 结果
     */
    String generate(final String regex);

}
