package com.github.houbb.data.factory.api.annotation;

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
     * @since 0.0.3
     * @return 表达式信息
     */
    String regex() default "";

}
