package com.github.houbb.data.factory.core.model.regex;

import com.github.houbb.data.factory.api.annotation.DataFactory;

import java.math.BigDecimal;

/**
 * 正则表达式测试对象
 * @author binbin.hou
 * @date 2019/3/12
 * @since 0.0.3
 */
public class RegexBean {

    @DataFactory(regex = "[0-3]([a-c]|[e-g]{1,2})")
    private String name;

    @DataFactory(regex = "[0-9]{1,2}")
    private int age;

    @DataFactory(regex = "[0-9]{1,2}")
    private BigDecimal amount;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "RegexBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", amount=" + amount +
                '}';
    }

}
