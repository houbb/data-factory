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
     * 最大值。只作用于数字类型的字段
     *
     * @return 返回最大值
     */
    int max() default 100;

    /**
     * 最小值。只作用于数字类型的字段
     *
     * @return 返回最小值
     */
    int min() default 0;

    /**
     * 精度。只作用于Float类型和和Double类型。
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

}
