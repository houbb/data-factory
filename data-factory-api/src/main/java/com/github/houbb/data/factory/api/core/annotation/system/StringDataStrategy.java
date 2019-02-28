/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.api.core.annotation.system;

import com.github.houbb.data.factory.api.annotation.system.StringData;
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.annotation.IDataStrategy;

/**
 * <p> 字符串数据生成策略 </p>
 *
 * <pre> Created: 2019/2/28 11:07 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 * @since 0.0.2
 */
public class StringDataStrategy implements IDataStrategy<StringData, String> {

    @Override
    public String build(IContext context, Class<String> stringClass) {
        return null;
    }

}
