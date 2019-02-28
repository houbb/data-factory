/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.core.annotation;

import com.github.houbb.data.factory.api.core.IData;

import java.lang.annotation.Annotation;

/**
 * <p> 自定义注解接口信息 </p>
 *
 * <pre> Created: 2019/2/28 10:55 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.2
 * @param <T> 泛型信息
 */
public interface IDataStrategy<A extends Annotation, T> extends IData<T> {

    /**
     * 初始化注解相关信息
     * @param constraintAnnotation 自定义注解
     */
    default void init(A constraintAnnotation) {
    }

}
