package com.github.houbb.data.factory.core.api.data.reference;

import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class StringData implements IData<String> {

    @Override
    public String build(Class<String> booleanClass) {
        return null;
    }

}
