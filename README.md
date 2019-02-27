# 项目简介

本项目用于根据对象，随机自动生成初始化信息。便于测试。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/data-factory/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/data-factory)
[![Build Status](https://www.travis-ci.org/houbb/data-factory.svg?branch=master)](https://www.travis-ci.org/houbb/data-factory?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/houbb/data-factory/badge.svg?branch=master)](https://coveralls.io/github/houbb/data-factory?branch=master)


## 特性

- 8 大基本类型的支持

- String、Date、金额，日期等常见类型的支持

- java8 常见时间类的支持

# 变更日志

> [变更日志](doc/CHANGELOG.md)

# 核心类讲解

## DataUtil 工具类

提供线程安全的方法：

```java
/**
 * 构建结果
 * @param clazz 类型
 * @return 构建结果
 */
public static <T> T build(final Class<T> clazz) {
    IData data = getInstance();
    return (T) data.build(null, clazz);
}

/**
 * 构建结果
 * @param context 执行上下文
 * @param clazz 类型
 * @return 构建结果
 */
public static <T> T build(final IContext context, final Class<T> clazz) {
    IData data = getInstance();
    return (T) data.build(context, clazz);
}
```

# 快速开始

## 准备工作

JDK 1.8+

Maven 3.0+ 

如果是 idea，测试的时候 `Enable Annotation Processing`。

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>data-factory-core</artifactId>
    <version>0.0.1</version>
</dependency>
```

## 演示对象

一个用于演示的普通 java 对象。

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

## 使用工具类

```java
@Test
public void buildBeanBaseTest() throws Exception {
    User user = DataUtil.build(User.class);
    System.out.println(user);
}
```

输出信息如下：

```
User{name='wZ8CJZtK', age=-564106861, birthday=Wed Feb 27 22:14:34 CST 2019, stringList=[Du4iJkQj], statusEnum=S, map={yA5yDqM=Kdzi}}
```

内容每次都随机。便于基本的测试数据填充。