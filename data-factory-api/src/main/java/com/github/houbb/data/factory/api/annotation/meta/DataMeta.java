package com.github.houbb.data.factory.api.annotation.meta;

import com.github.houbb.data.factory.api.core.meta.IAnnotationData;

import java.lang.annotation.*;

/**
 * 用于指定注解约束的元注解
 * @author binbin.hou
 * @since 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataMeta {

    /**
     * 数据条件实现类
     * @return 实现类 class
     */
    Class<? extends IAnnotationData> value();

}
