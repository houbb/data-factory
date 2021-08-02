package com.github.houbb.data.factory.core.model.annotation;

import com.github.houbb.data.factory.core.annotation.ConstStringData;

/**
 * 自定义 data 注解
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.6
 */
public class UserDefineAnnotationData {

    @ConstStringData("echo")
    private String name;

    @ConstStringData("game")
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
        return "UserDefineAnnotationData{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

}
