package com.github.houbb.data.factory.core.annotation;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class AtMyStringAnnotationData implements IAnnotationData<ConstStringData> {

    private ConstStringData constStringData;

    @Override
    public void initialize(ConstStringData annotation) {
        constStringData = annotation;
    }

    @Override
    public Object build(IContext context, Class aClass) {
        return constStringData.value();
    }

}
