package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class CharData implements IData<Character> {

    @Override
    public Character build(Class<Character> booleanClass) {
        return null;
    }

}
