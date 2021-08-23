# 创作目的

我们平时在写测试用例的时候，免不了要写一大堆 set 方法为对象设置属性。

有时候为了补全测试用例，这件事就会变得非常枯燥。

于是就在想，能不能写一个可以自动生成测试对象的工具呢？

于是就有了这一个没啥用的测试框架：

> [https://github.com/houbb/data-factory](https://github.com/houbb/data-factory)

# 项目简介

[data-factory](https://github.com/houbb/data-factory) 项目用于根据对象，随机自动生成初始化信息。便于测试。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/data-factory/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/data-factory)
[![Build Status](https://www.travis-ci.org/houbb/data-factory.svg?branch=master)](https://www.travis-ci.org/houbb/data-factory?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/data-factory/badge.svg?branch=master)](https://coveralls.io/github/houbb/data-factory?branch=master)

## 特性

- 8 大基本类型的支持

- 数组、对象、枚举、Map、链表、Set 等支持

- String、BigDecimal、BigInteger、Currency 等常见类型的支持

- Date、LocalDate、LocalDateTime、LocalTime、Year 等常见日期类型支持

- 支持 Regex 正则表达式

- `@DataFactory` 注解支持灵活配置 

# 变更日志

> [变更日志](doc/CHANGELOG.md)

# 快速开始

## 准备工作

JDK 1.8+

Maven 3.0+ 

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>data-factory-core</artifactId>
    <version>1.1.0</version>
</dependency>
```

## 基本类型

我们通过 `DataUtil.build(class)` 就可以生成对应类的随机值。

比如 `DataUtil.build(String.class);`，就可以生成随机的字符串：

```
0s5Z8foS1
```

## 对象

当然，最常用的还是初始化一个 java 对象。

```java
public class User {

    private String name;

    private int age;

    private Date birthday;

    private List<String> stringList;

    //S/F 的枚举
    private StatusEnum statusEnum;

    private Map<String, String> map;
    
    //Getter & Setter
}
```

构建方法 `User user = DataUtil.build(User.class);`

构建对象如下：

```
User{name='wZ8CJZtK', age=-564106861, birthday=Wed Feb 27 22:14:34 CST 2019, stringList=[Du4iJkQj], statusEnum=S, map={yA5yDqM=Kdzi}}
```

内容每次都随机，便于基本的测试数据填充。

## `@DataFactory` 注解

当然，有时候我们希望生成的数据符合一定的规则，这个时候可以通过 `@DataFactory` 注解去进行限制。

详情见 [DataFactory 注解支持](doc/blog/DataFactory-01-注解支持.md)

### 对象定义

```java
public class UserAnnotationNumber {

    @DataFactory(min = 10, max = 20)
    private Byte aByte;

    @DataFactory(min = 10, max = 20)
    private Short aShort;

    @DataFactory(min = 10, max = 20)
    private Integer integer;

    @DataFactory(min = 10, max = 20)
    private Long aLong;

    @DataFactory(min = 10, max = 20, precision = 3)
    private Double aDouble;

    @DataFactory(min = 10, max = 20, precision = 3)
    private Float aFloat;

    @DataFactory(min = 10, max = 20, precision = 3)
    private BigDecimal bigDecimal;

    @DataFactory(min = 10, max = 20)
    private BigInteger bigInteger;
    
    //getter & setter

}
```

### 效果

通过 `DataUtil.build(UserAnnotationNumber.class)` 生成的对象如下：

```
UserAnnotationNumber{aByte=10, aShort=17, integer=19, aLong=11, aDouble=19.888, aFloat=10.067, bigDecimal=18.035, bigInteger=13}
```

# 自定义注解支持

为了更加灵活的指定生成，最大程度的重用自定义策略。

v1.0.0 支持用户自定义注解。

## 自定义实现

### 注解定义

比如指定一个返回固定值的注解。

```java
package com.github.houbb.data.factory.core.annotation;

import com.github.houbb.data.factory.api.annotation.meta.DataMeta;

import java.lang.annotation.*;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@DataMeta(value = AtMyStringAnnotationData.class)
public @interface ConstStringData {

    String value() default "";

}
```

最重要的一点就是 `@DataMeta(value = AtMyStringAnnotationData.class)`;

`@DataMeta` 是一个最核心的元注解，value 对应的是具体实现。

### 具体实现

AtMyStringAnnotationData 就是具体的注解实现，如下：

```java
import com.github.houbb.data.factory.api.core.IContext;
import com.github.houbb.data.factory.api.core.meta.IAnnotationData;

public class AtMyStringAnnotationData implements IAnnotationData<ConstStringData> {

    private ConstStringData constStringData;

    @Override
    public void initialize(ConstStringData annotation) {
        constStringData = annotation;
    }

    @Override
    public Object build(IContext context, Class aClass) {
        return constStringData.value();
    }

}
```

实现对应的 IAnnotationData 接口，initialize 初始化对应的注解信息。

build 构建对应的值。

### 注解使用

定义好了注解，`@ConstStringData` 就可以如下使用了：

```java
public class UserDefineAnnotationData {

    @ConstStringData("echo")
    private String name;

    @ConstStringData("game")
    private String hobby;

    // getter & setter

}
```

### 测试验证

```java
UserDefineAnnotationData data = DataUtil.build(UserDefineAnnotationData.class);
assert  data.getName().equals("echo");
assert  data.getHobby().equals("game");
```

可以验证数据被初始化为对应的注解指定值。

# 拓展阅读

[DataFactory-01-注解支持](doc/blog/DataFactory-01-注解支持.md)

[DataFactory-02-正则表达式支持](doc/blog/DataFactory-02-正则表达式支持.md)

[DataFactory-03-自定义注解](doc/blog/DataFactory-03-自定义注解.md)

# Road-MAP

- [ ] 支持多维数组

- [ ] 支持全局配置