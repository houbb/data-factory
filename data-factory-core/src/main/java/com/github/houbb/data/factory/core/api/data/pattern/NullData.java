package com.github.houbb.data.factory.core.api.data.pattern;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

/**
 * null 对象数据实现
 * 1. 使用空对象模式。
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class NullData implements IData {
    @Override
    public Object build(IContext context, Class aClass) {
        return null;
    }
}
