package com.github.houbb.data.factory.api.core.meta;

import com.github.houbb.data.factory.api.core.IData;

import java.lang.annotation.Annotation;

/**
 * 注解约束规则接口
 * 注意：所有的实现类都需要提供无参构造函数。
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IAnnotationData<A extends Annotation> extends IData {

    /**
     * 初始化映射关系
     * @param annotation 注解信息
     * @since 0.0.9
     */
    void initialize(A annotation);

}
