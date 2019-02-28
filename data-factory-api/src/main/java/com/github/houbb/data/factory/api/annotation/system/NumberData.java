/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.annotation.system;

import com.github.houbb.data.factory.api.annotation.DataMetadata;
import com.github.houbb.data.factory.api.core.annotation.system.NumberDataStrategy;

/**
 * <p> 数字注解 </p>
 *
 * <pre> Created: 2019/2/28 10:58 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.2
 */
@DataMetadata(NumberDataStrategy.class)
public @interface NumberData {

    /**
     * 是否忽略此字段
     *
     * @return 默认不忽略
     */
    boolean ignore() default false;

    /**
     * 最大值。只作用于数字类型的字段
     *
     * @return 返回最大值
     */
    int max() default 1000;

    /**
     * 最小值。只作用于数字类型的字段
     *
     * @return 返回最小值
     */
    int min() default 0;

    /**
     * 精度。只作用于Float类型和和Double类型。
     *
     * @return 返回精度
     */
    int precision() default 2;

}
