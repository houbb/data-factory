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