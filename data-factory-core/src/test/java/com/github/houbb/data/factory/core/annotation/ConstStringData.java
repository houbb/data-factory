package com.github.houbb.data.factory.core.annotation;

import com.github.houbb.data.factory.api.annotation.meta.DataMeta;

import java.lang.annotation.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@DataMeta(value = AtMyStringAnnotationData.class)
public @interface ConstStringData {

    String value() default "";

}
