package com.github.houbb.data.factory.core.api.data.annotation;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;

import java.lang.annotation.Annotation;

/**
 * 抽象注解数据接口
 *
 * @author binbin.hou
 * @since 0.1.1
 */
public abstract class AbstractAnnotationData<A extends Annotation> implements IAnnotationData<A> {

    /**
     * 注解信息
     */
    private A annotation;

    /**
     * 构建数据实现值
     *
     * @param annotation 注解信息
     * @param context    上下文
     * @param tClass     类信息
     * @return 数据实现
     * @since 0.1.1
     */
    protected abstract Object buildDataValue(final A annotation,
                                                 IContext context, Class<?> tClass);

    /**
     * 构建注解提示名称
     *
     * @return 提示名称
     * @since 0.1.1
     */
    protected String annotationName() {
        return "annotation";
    }

    @Override
    public void initialize(A annotation) {
        ArgUtil.notNull(annotation, annotationName());
        this.annotation = annotation;
    }

    @Override
    public Object build(IContext context, Class tClass) {
        return buildDataValue(this.annotation, context, tClass);
    }

    /**
     * 设置注解
     * @param annotation 注解
     * @since 1.1.0
     * @return this
     */
    public AbstractAnnotationData setAnnotation(A annotation) {
        this.annotation = annotation;

        return this;
    }
}
