# Regex 表达式支持

Regex 可以为我们提供灵活强大的字符串生成。

v0.0.3 版本引入正则表达式的支持。

## 注解属性

`@DataFactory` 新增了如下的一个属性方法。

```java
    /**
     * 正则表达式
     * 1. 当前版本为了简单方便，如果 regex 存在，则直接忽略长度，精度等其他注解配置。
     * 2. 建议直接使用在 String 类型
     * 3. 如果使用其他类型，则必须保证提供了对应的 String 构造器。如{@link Long#Long(String)}
     * 4. 基本类型会直接使用对应的包装类型。
     * @since 0.0.3
     * @return 表达式信息
     */
    String regex() default "";
```

# 使用案例

## 测试对象

- 定义对象

```java
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

    //Getter & Setter
    
}
```

## 测试代码

```java
@Test
public void regexTest() {
    RegexBean regexBean = DataUtil.build(RegexBean.class);
    System.out.println(regexBean);
}
```

- 日志信息

```
RegexBean{name='2c', age=61, amount=39}
```

# 一些不足

Regex 的生成使用的是已有的框架 [Generex](https://github.com/mifmif/Generex)。

但是单个测试时，发现及时是生成一个最简单的 String，正则的解析时间可能都比较长。

后期有时间完成一下自己写的 [regex-gen](https://github.com/houbb/regex-gen)，然后将现有的方式替换掉。