package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

/**
 * @author binbin.hou
 * date 2019/2/27
 * @since 0.0.1
 */
public class EnumData implements IData<Enum> {

    @Override
    public Enum build(IContext context, Class<Enum> enumClass) {
        // 枚举类型对应的实现。
        return null;
    }

}
