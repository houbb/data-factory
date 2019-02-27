package com.github.houbb.data.factory.core.api.data.aggregate;

import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.exception.DataFactoryRuntionException;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.CollectionUtil;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * map 集合的实现
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class MapData implements IData<Map> {

    @Override
    public Map build(IContext context, Class<Map> mapClass) {
        Map map = new HashMap(1);

        List<Class> genericTypeList = context.getGenericList();
        if(CollectionUtil.isEmpty(genericTypeList)) {
            return map;
        }


        final Object key = DataUtil.build(context, genericTypeList.get(0));
        final Object value = DataUtil.build(context, genericTypeList.get(1));
        map.put(key, value);
        return map;
    }

    /**
     * 创建对应的实例
     * @param mapClass 类
     * @return 结果
     */
    private Map newInstance(final Class<Map> mapClass) {
        try {
            return ClassUtil.newInstance(mapClass);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }

}
