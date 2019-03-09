# @DataFactory 注解

有时候我们生成的属性需要更加确切的属性指定，此处我们引入了注解 `@DataFactory`。

## 注解属性

```java
/**
 * 数据生成注解
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
@Inherited
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataFactory {

    /**
     * 是否忽略此字段
     *
     * @return 默认不忽略
     */
    boolean ignore() default false;

    /**
     * 数字整数部分最大值。
     * 只作用于数字类型的字段
     *
     * @return 返回最大值
     */
    int max() default 100;

    /**
     * 数字整数部分最小值。
     * 只作用于数字类型的字段
     *
     * @return 返回最小值
     */
    int min() default 0;

    /**
     * 精度。
     * 作用于Float、Double、BigDecimal 小数部分长度
     *
     * @return 返回精度
     */
    int precision() default 2;

    /**
     * 最大长度。只作用于String类型的字段
     *
     * @return 返回最大长度
     */
    int maxLen() default 30;

    /**
     * 最小长度。只作用于String类型的字段
     *
     * @return 返回最小长度
     */
    int minLen() default 1;

}
```

# 使用案例

## String 类

- 定义对象

```java
/**
 * 字符串类注解测试
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
public class UserAnnotationString {

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

    //Getter & Setter

}
```

- 测试代码

```java
/**
*
* Method: build(clazz)
*/
@Test
public void stringAnnotationTest() throws Exception {
    for(int i = 0; i < 100; i++) {
        UserAnnotationString userAnnotationString = DataUtil.build(UserAnnotationString.class);

        Assertions.assertNull(userAnnotationString.getHobby());
        Assertions.assertTrue(userAnnotationString.getName().length() >= 2);
        Assertions.assertTrue(userAnnotationString.getName().length() <= 10);
    }
}
```

## Number 类

- 对象定义

```java
/**
 * 数字类注解测试
 * @author binbin.hou
 * @date 2019/3/9
 * @since 0.0.2
 */
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

    //Getter & Setter

}
```

- 测试代码

```java
/**
 * Method: build(clazz)
 */
@Test
public void stringAnnotationTest() throws Exception {
    UserAnnotationNumber number = DataUtil.build(UserAnnotationNumber.class);

    Assertions.assertTrue(number.getaByte() >= 10);
    Assertions.assertTrue(number.getaByte() <= 20);

    Assertions.assertTrue(number.getaShort() >= 10);
    Assertions.assertTrue(number.getaShort() <= 20);

    Assertions.assertTrue(number.getInteger() >= 10);
    Assertions.assertTrue(number.getInteger() <= 20);

    Assertions.assertTrue(number.getaLong() >= 10);
    Assertions.assertTrue(number.getaLong() <= 20);

    Assertions.assertTrue(number.getaFloat() >= 10);
    Assertions.assertTrue(number.getaFloat() <= 21);

    Assertions.assertTrue(number.getaDouble() >= 10);
    Assertions.assertTrue(number.getaDouble() <= 21);

    Assertions.assertTrue(number.getBigInteger().compareTo(new BigInteger("10")) >= 0);
    Assertions.assertTrue(number.getBigInteger().compareTo(new BigInteger("20")) <= 0);

    Assertions.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("10")) >= 0);
    Assertions.assertTrue(number.getBigDecimal().compareTo(new BigDecimal("21")) <= 0);

    System.out.println(number.getaFloat());
    System.out.println(number.getaDouble());
    System.out.println(number.getBigDecimal());
}
```

日志信息(每次都随机)

```
16.527
10.452
15.577
```