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
    <version>0.0.8</version>
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

# 拓展阅读

[DataFactory-01-注解支持](doc/blog/DataFactory-01-注解支持.md)

[DataFactory-02-正则表达式支持](doc/blog/DataFactory-02-正则表达式支持.md)

# Road-MAP

- [ ] 支持多维数组

- [ ] 支持全局配置

# 他山之石

[jmockdata](https://github.com/jsonzou/jmockdata)

[podam](https://github.com/mtedone/podam)