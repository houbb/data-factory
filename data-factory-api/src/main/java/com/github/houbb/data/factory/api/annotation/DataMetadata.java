/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.annotation;

import com.github.houbb.data.factory.api.core.annotation.IDataStrategy;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p> 数据相关处理注解 </p>
 *
 * <pre> Created: 2019/2/28 10:43 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.2
 */
@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataMetadata {

    /**
     * 指定约束类的规则
     * @return 约束类
     */
    Class<? extends IDataStrategy<? extends Annotation, ?>> value();

}
