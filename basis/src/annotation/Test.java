package annotation;

/**
 * 定义新的注解类型使用@interface 关键宇(在原有的interface 关键宇前增加@符号)定义一个新的注解类型与定义一个接口非常像，
 * 如下代码可定义一个简单的注解类型。
 * @author JIE
 */

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 使用@Retention 指定注解的保留到运行时
@Retention(RetentionPolicy.RUNTIME)
// Java 8 新增的重复注解
@Repeatable(Tests.class)
public @interface Test {

    /**
     * 注解还可以带成员变量，成员变量在注解定义中以无形参的方法形式来声明， 其方法名和返回值定义了该成员变量的名字和类型。
     */
    String name();
    int age();

    /**
     * 也可以在定义注解的成员变量时为其指定初始值(默认值) ，指定成员变量的初始值可使用default关键字。
     * 如果为注解的成员变量指定了默认值，使用该注解时则可以不为这些成员变量指定值，而是直接使用默认值。
     *
     * 当然也可以在使用注解时为成员变量指定值，如果指定了值，则默认值不会起作用。
     *
     * 根据注解是否可以包含成员变量，可以把注解分为如下两类。
     * 标记注解:没有定义成员变量的注解类型被称为标记。这种注解仅利用自身的存在与否来提供信息，如前面介绍的@Override  等注解。
     * 元数据注解:包含成员变量的注解，因为它们可以接受更多的元数据，所以也被称为元数据注解。
     */
    int sex() default 0;
}
