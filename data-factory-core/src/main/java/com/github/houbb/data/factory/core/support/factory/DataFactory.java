package com.github.houbb.data.factory.core.support.factory;

import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.core.api.data.aggregate.ArrayData;
import com.github.houbb.data.factory.core.api.data.aggregate.BeanData;
import com.github.houbb.data.factory.core.api.data.aggregate.EnumData;
import com.github.houbb.data.factory.core.api.data.aggregate.IterableData;
import com.github.houbb.data.factory.core.api.data.aggregate.MapData;
import com.github.houbb.data.factory.core.api.data.aggregate.NullData;
import com.github.houbb.data.factory.core.api.data.lang.StringData;
import com.github.houbb.data.factory.core.api.data.math.BigDecimalData;
import com.github.houbb.data.factory.core.api.data.math.BigIntegerData;
import com.github.houbb.data.factory.core.api.data.primitive.*;
import com.github.houbb.data.factory.core.api.data.time.LocalDateData;
import com.github.houbb.data.factory.core.api.data.time.LocalDateTimeData;
import com.github.houbb.data.factory.core.api.data.time.LocalTimeData;
import com.github.houbb.data.factory.core.api.data.time.YearData;
import com.github.houbb.data.factory.core.api.data.util.CurrencyData;
import com.github.houbb.data.factory.core.api.data.util.DateData;
import com.github.houbb.data.factory.core.util.DataClassUtil;
import com.github.houbb.data.factory.core.util.DataPrimitiveUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassTypeUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.MapUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Year;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 数据工厂
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public final class DataFactory {

    private DataFactory(){}

    /**
     * 存放数据实现的 map
     */
    private static final Map<Class, IData> DATA_CLASS_MAP = new HashMap<>();

    static {
        DATA_CLASS_MAP.put(String.class, new StringData());
        DATA_CLASS_MAP.put(BigDecimal.class, new BigDecimalData());
        DATA_CLASS_MAP.put(BigInteger.class, new BigIntegerData());
        DATA_CLASS_MAP.put(Boolean.class, new BoolData());
        DATA_CLASS_MAP.put(Byte.class, new ByteData());
        DATA_CLASS_MAP.put(Character.class, new CharData());
        DATA_CLASS_MAP.put(Double.class, new DoubleData());
        DATA_CLASS_MAP.put(Float.class, new FloatData());
        DATA_CLASS_MAP.put(Integer.class, new IntegerData());
        DATA_CLASS_MAP.put(Long.class, new LongData());
        DATA_CLASS_MAP.put(Short.class, new ShortData());
        DATA_CLASS_MAP.put(Void.class, new VoidData());
        DATA_CLASS_MAP.put(LocalDate.class, new LocalDateData());
        DATA_CLASS_MAP.put(LocalDateTime.class, new LocalDateTimeData());
        DATA_CLASS_MAP.put(LocalTime.class, new LocalTimeData());
        DATA_CLASS_MAP.put(Year.class, new YearData());
        DATA_CLASS_MAP.put(Currency.class, new CurrencyData());
        DATA_CLASS_MAP.put(Date.class, new DateData());
        DATA_CLASS_MAP.put(int[].class, new IntegerArrayData());
        DATA_CLASS_MAP.put(short[].class, new ShortArrayData());
        DATA_CLASS_MAP.put(long[].class, new LongArrayData());
        DATA_CLASS_MAP.put(byte[].class, new ByteArrayData());
        DATA_CLASS_MAP.put(char[].class, new CharArrayData());
        DATA_CLASS_MAP.put(double[].class, new DoubleArrayData());
        DATA_CLASS_MAP.put(float[].class, new FloatArrayData());
        DATA_CLASS_MAP.put(boolean[].class, new BoolArrayData());
    }

    /**
     * 初始化数据工厂
     * 这种写法虽然优雅，但是总会有用户不开启运行时注解。
     * @since 0.0.5
     */
    @Deprecated
    private static void initDataFactory() {
        synchronized (DATA_CLASS_MAP) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            ServiceLoader<IData> dataLoader = ServiceLoader.load(IData.class, classLoader);

            for (IData data : dataLoader) {
                final Class<? extends IData> clazz = data.getClass();
                if(isDataFactoryClass(clazz)) {
                    final Class genericType = DataClassUtil.getGenericType(clazz, IData.class, 0);
                    System.out.println(String.format("DATA_CLASS_MAP.put(%s.class, new %s());", genericType.getSimpleName(),
                            data.getClass().getSimpleName()));
                    DATA_CLASS_MAP.put(genericType, data);
                }
            }
        }
    }

    /**
     * 判断是否为当前项目的实现，防止外部实现对现有的对象造成影响
     * @param clazz 对象类型
     * @return 是否
     */
    private static boolean isDataFactoryClass(final Class<? extends IData> clazz) {
        final String packageName = clazz.getPackage().getName();
        return packageName.startsWith("com.github.houbb.data.factory.core.api.data.");
    }

    /**
     * 获取对应的 data 实现
     * @param clazz 字段类型
     * @return 结果
     */
    @SuppressWarnings("all")
    public static IData getData(final Class clazz) {
        // 快速返回
        if(ObjectUtil.isNull(clazz)) {
            return NullData.INSTANCE;
        }

        // 数组/map/集合/bean对象
        if(clazz.isArray()) {
            final IData data = DATA_CLASS_MAP.get(clazz);
            if(ObjectUtil.isNull(data)) {
                return new ArrayData();
            }

            // 对应的基本类型数组
            return data;
        }
        if(ClassTypeUtil.isIterable(clazz)) {
            return new IterableData();
        }
        if(Map.class.isAssignableFrom(clazz)) {
            return new MapData();
        }
        if(clazz.isEnum()) {
            return new EnumData();
        }

        // JDK 相关类型
        if(ClassTypeUtil.isJdk(clazz)) {
            Class realClazz = DataPrimitiveUtil.getReferenceType(clazz);
            if(MapUtil.isEmpty(DATA_CLASS_MAP)) {
                initDataFactory();
            }
            final IData data = DATA_CLASS_MAP.get(realClazz);
            if(ObjectUtil.isNull(data)) {
                return NullData.INSTANCE;
            }
            return data;
        }

        // 用户自定义 java bean
        return new BeanData();
    }

}
