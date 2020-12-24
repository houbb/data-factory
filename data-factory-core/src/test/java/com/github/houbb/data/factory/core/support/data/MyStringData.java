package com.github.houbb.data.factory.core.support.data;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

/**
 * @author binbin.hou
 * @since 0.0.6
 */
public class MyStringData implements IData<String>  {

    @Override
    public String build(IContext context, Class<String> stringClass) {
        return "123";
    }

}
