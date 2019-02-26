package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;

import java.util.Map;

/**
 * map 集合的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class IterableData implements IData<Iterable> {

    @Override
    public Iterable build(IContext context, Class<Iterable> iterableClass) {
        // 直接存放线性表
        return null;
    }

}
