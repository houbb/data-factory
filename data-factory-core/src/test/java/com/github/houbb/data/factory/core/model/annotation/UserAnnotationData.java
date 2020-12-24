package com.github.houbb.data.factory.core.model.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;
import com.github.houbb.data.factory.core.support.data.MyStringData;

/**
 * 自定义 data
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.6
 */
public class UserAnnotationData {

    @DataFactory(data = MyStringData.class)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
