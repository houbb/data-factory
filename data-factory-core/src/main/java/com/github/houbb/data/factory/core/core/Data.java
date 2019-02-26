package com.github.houbb.data.factory.core.core;

import com.github.houbb.data.factory.api.core.IData;

/**
 * 数据的默认实现类
 * @author binbin.hou
 * date 2019/2/26
 * @since 0.0.1
 */
public class Data implements IData {

    @Override
    public Object build(Class aClass) {
        // 映射关系的获取，直接根据 SPI 获取，然后反射映射为 map。
        // 集合
        // 数组
        // map
        // 对象
        // 其他已有的基本类型
        return null;
    }

}
