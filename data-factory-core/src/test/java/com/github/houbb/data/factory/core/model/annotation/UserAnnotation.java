package com.github.houbb.data.factory.core.model.annotation;

import com.github.houbb.data.factory.api.annotation.DataFactory;

/**
 * 注解测试
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
public class UserAnnotation {

    /**
     * 指定最小长度，最大长度
     */
    @DataFactory(minLen = 2, maxLen = 10)
    private String name;

    /**
     * 忽略生成当前字段
     */
    @DataFactory(ignore = true)
    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "UserAnnotation{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}
