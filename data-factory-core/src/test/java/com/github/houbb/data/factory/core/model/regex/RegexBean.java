package com.github.houbb.data.factory.core.model.regex;

import com.github.houbb.data.factory.api.annotation.DataFactory;

/**
 * @author binbin.hou
 * @date 2019/3/12
 * @since 0.0.3
 */
public class RegexBean {

    @DataFactory(regex = "[0-3]([a-c]|[e-g]{1,2})")
    private String name;

    @DataFactory(regex = "[0-9]{1,2}")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
