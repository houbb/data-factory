package com.github.houbb.data.factory.core.api.data.primitive;

import com.github.houbb.data.factory.api.core.IData;
import com.google.auto.service.AutoService;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
@AutoService(IData.class)
public class BoolData implements IData<Boolean> {

    @Override
    public Boolean build(Class<Boolean> booleanClass) {
        return null;
    }

}
