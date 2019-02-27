/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.core.api.context;

import com.github.houbb.data.factory.api.core.IContext;

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


    @Override
    public List<Class> getGenericList() {
        return genericList;
    }

    public void setGenericList(List<Class> genericList) {
        this.genericList = genericList;
    }

}
