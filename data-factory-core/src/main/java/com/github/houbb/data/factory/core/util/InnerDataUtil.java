package com.github.houbb.data.factory.core.util;

import com.github.houbb.data.factory.api.annotation.meta.DataMeta;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;
import com.github.houbb.heaven.util.common.ArgUtil;
import com.github.houbb.heaven.util.lang.ObjectUtil;
import com.github.houbb.heaven.util.lang.reflect.ClassUtil;
import com.github.houbb.heaven.util.util.ArrayUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 内部工具类
 * @author binbin.hou
 * @since 0.0.7
 */
public final class InnerDataUtil {

    private InnerDataUtil(){}

    /**
     * 随机生成大小
     * @param min 最小值
     * @param max 最大值
     * @return 结果
     * @since 0.0.7
     */
    public static int randomSize(final int min, final int max) {
        ArgUtil.notNegative(min, "最小值");
        ArgUtil.assertTrue(max >= min, "最大值必须大于等于最小值");

        ThreadLocalRandom random = ThreadLocalRandom.current();
        return random.nextInt(min, max);
    }

    /**
     * 随机的大小
     * @return 大小
     * @since 0.0.8
     */
    public static int randomSize() {
        return randomSize(1, 10);
    }

    /**
     * 获取用户自定义的注解信息
     *
     * 说明：属性的生成，只会返回第一个符合条件的属性。
     *
     * @param field 字段注解
     * @return 结果
     * @since 1.0.0
     */
    @SuppressWarnings("all")
    public static IAnnotationData getDefineDataAnnotation(final Field field) {
        // 注解列表为空
        Annotation[] annotations = field.getAnnotations();

        if(ArrayUtil.isEmpty(annotations)) {
            return null;
        }

        for(Annotation annotation : annotations) {
            DataMeta dataMeta = annotation.annotationType().getAnnotation(DataMeta.class);
            if (ObjectUtil.isNotNull(dataMeta)) {
                Class<? extends IAnnotationData> clazz = dataMeta.value();

                // 如果不是默认的注解，则返回对应的实现
                if(!IAnnotationData.class.equals(clazz)) {
                    IAnnotationData annotationData = ClassUtil.newInstance(clazz);
                    // 初始化注解信息
                    annotationData.initialize(annotation);
                    return annotationData;
                }
            }
        }

        // 没有匹配的信息
        return null;
    }

}
