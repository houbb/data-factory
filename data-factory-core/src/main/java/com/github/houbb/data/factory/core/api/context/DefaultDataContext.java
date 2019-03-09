/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.core.api.context;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.api.core.IContext;

import java.lang.reflect.Field;
import java.util.List;

/**
 * <p> 默认的数据上下文 </p>
 *
 * <pre> Created: 2019/2/27 9:31 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.1
 */
public class DefaultDataContext implements IContext {

    /**
     * 泛型列表
     */
    private List<Class> genericList;

    /**
     * 当前字段
     * @since 0.0.2
     */
    private Field currentField;

    /**
     * 注解信息
     * @since 0.0.1
     */
    private DataFactory dataFactory;

    @Override
    public List<Class> getGenericList() {
        return genericList;
    }

    @Override
    public Field getCurrentField() {
        return this.currentField;
    }

    @Override
    public DataFactory getDataFactory() {
        return this.dataFactory;
    }

    public void setGenericList(List<Class> genericList) {
        this.genericList = genericList;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public void setDataFactory(DataFactory dataFactory) {
        this.dataFactory = dataFactory;
    }
}
