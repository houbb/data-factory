package com.github.houbb.data.factory.core.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class DataPrimitiveUtil {

    public static final Map<Class, Class> PRIMITIVE_REFERENCE_MAP = new HashMap<>();

    static {
        PRIMITIVE_REFERENCE_MAP.put(int.class, Integer.class);
        PRIMITIVE_REFERENCE_MAP.put(boolean.class, Boolean.class);
        PRIMITIVE_REFERENCE_MAP.put(byte.class, Byte.class);
        PRIMITIVE_REFERENCE_MAP.put(char.class, Character.class);
        PRIMITIVE_REFERENCE_MAP.put(short.class, Short.class);
        PRIMITIVE_REFERENCE_MAP.put(long.class, Long.class);
        PRIMITIVE_REFERENCE_MAP.put(float.class, Float.class);
        PRIMITIVE_REFERENCE_MAP.put(double.class, Double.class);
    }

    /**
     * 获取基础类型的引用类型
     * @param clazz 基础类型
     * @return 引用类型
     */
    public static Class getReferenceType(final Class clazz) {
        if(clazz.isPrimitive()) {
            return PRIMITIVE_REFERENCE_MAP.get(clazz);
        }
        if(void.class.equals(clazz)) {
            return Void.class;
        }
        return clazz;
    }

}
