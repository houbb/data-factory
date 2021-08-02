package com.github.houbb.data.factory.api.annotation;

import com.github.houbb.data.factory.api.annotation.meta.DataMeta;
import com.github.houbb.data.factory.api.core.IData;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;

import java.lang.annotation.*;

/**
 * 数据生成注解
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@DataMeta(value = IAnnotationData.class)
public @interface DataFactory {

    /**
     * 是否忽略此字段
     *
     * @return 默认不忽略
     */
    boolean ignore() default false;

    /**
     * 数字整数部分最大值。
     * 只作用于数字类型的字段
     *
     * @return 返回最大值
     */
    int max() default 100;

    /**
     * 数字整数部分最小值。
     * 只作用于数字类型的字段
     *
     * @return 返回最小值
     */
    int min() default 0;

    /**
     * 精度。
     * 作用于Float、Double、BigDecimal 小数部分长度
     *
     * @return 返回精度
     */
    int precision() default 2;

    /**
     * 最大长度。只作用于String类型的字段
     *
     * @return 返回最大长度
     */
    int maxLen() default 30;

    /**
     * 最小长度。只作用于String类型的字段
     *
     * @return 返回最小长度
     */
    int minLen() default 1;

    /**
     * 正则表达式
     * 1. 当前版本为了简单方便，如果 regex 存在，则直接忽略长度，精度等其他注解配置。
     * 2. 建议直接使用在 String 类型
     * 3. 如果使用其他类型，则必须保证提供了对应的 String 构造器。如{@link Long#Long(String)}
     * 4. 基本类型会直接使用对应的包装类型。
     * @since 0.0.3
     * @return 表达式信息
     */
    String regex() default "";

    /**
     * 指定当前字段的类实现策略
     * @return 实现类
     * @since 0.0.6
     */
    Class<? extends IData> data() default IData.class;

}
