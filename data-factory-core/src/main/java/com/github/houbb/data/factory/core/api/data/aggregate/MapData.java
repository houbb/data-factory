package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;

import java.util.Map;

/**
 * map 集合的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class MapData implements IData<Map> {

    @Override
    public Map build(IContext context, Class<Map> mapClass) {
        Map map = ClassUtil.newInstance(mapClass);
        final Class<?> keyClass = DataClassUtil.getGenericType(mapClass, Map.class, 0);
        final Class<?> valueClass = DataClassUtil.getGenericType(mapClass, Map.class, 1);
        final Object key = DataUtil.build(context, keyClass);
        final Object value = DataUtil.build(context, valueClass);
        map.put(key, value);
        return map;
    }

}
