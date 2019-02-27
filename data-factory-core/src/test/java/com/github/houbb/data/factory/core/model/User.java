/*
 * Copyright (c)  2019. houbinbin Inc.
 * data-factory All rights reserved.
 */

package com.github.houbb.data.factory.core.model;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p> 用户信息 </p>
 *
 * <pre> Created: 2019/2/27 8:41 PM  </pre>
 * <pre> Project: data-factory  </pre>
 *
 * @author houbinbin
 */
public class User {

    private String name;

    private int age;

    private Date birthday;

    private List<String> stringList;

    private StatusEnum statusEnum;

    private Map<String, String> map;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }

    public Map<String, String> getMap() {
        return map;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                ", stringList=" + stringList +
                ", statusEnum=" + statusEnum +
                ", map=" + map +
                '}';
    }
}
