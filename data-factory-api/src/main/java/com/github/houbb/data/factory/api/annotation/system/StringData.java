/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.annotation.system;

import com.github.houbb.data.factory.api.annotation.DataMetadata;
import com.github.houbb.data.factory.api.core.annotation.system.StringDataStrategy;

/**
 * <p> 字符串注解 </p>
 *
 * <pre> Created: 2019/2/28 10:58 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.2
 */
@DataMetadata(StringDataStrategy.class)
public @interface StringData {

    /**
     * 是否忽略此字段
     *
     * @return 默认不忽略
     */
    boolean ignore() default false;

    /**
     * 最大长度。只作用于String类型的字段
     *
     * @return 返回最大长度
     */
    int maxLength() default 30;

    /**
     * 最小长度。只作用于String类型的字段
     *
     * @return 返回最小长度
     */
    int minLength() default 3;

    /**
     * 正则表达式。只作用域String类型的字段，提供有常用正则的枚举，
     * 有正则表达式的情况下不再使用maxLength、minLength等其他规则。
     *
     * @return 返回正则表达式
     */
    String regex() default "";

}
