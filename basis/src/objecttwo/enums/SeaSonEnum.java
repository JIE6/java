package objecttwo.enums;

/**
 * 枚举类入门
 * Java 5 新增了一个enum 关键宇(它与class 、interface 关键字的地位相同)，用以定义枚举类。
 * 正如前面看到的，枚举类是一种特殊的类，它一样可以有自己的成员变量、方法，可以实现一个或者多个接口
 * 也可以定义自己的构造器。一个Java 源文件中最多只能定义一个public 访问权限的枚举类，且该Java 源文件也必须和该枚举类的类名相同。
 *
 * 但枚举类终究不是普通类，它与普通类有如下简单区别。
 * 1.枚举类可以实现一个或多个接口，使用enum 定义的枚举类默认继承了java.lang.Enum 类，而不是默认继承Object 类
 * 因此枚举类不能显式继承其他父类。其中java.lang.Enum 类实现了java.1ang.Serializable 和java.lang.Comparable 两个接口。
 * 2.使用enum 定义、非抽象的枚举类默认会使用final 修饰， 因此枚举类不能派生子类。
 * 3.枚举类的构造器只能使用private 访问控制符，如果省略了构造器的访问控制符，则默认使用private 修饰;
 * 如果强制指定访问控制符，则只能指定private 修饰符。
 * 4.枚举类的所有实例必须在枚举类的第一行显式列出，否则这个枚举类永远都不能产生实例。列出这些实例时，
 * 系统会自动添加public static final 修饰，无须程序员显式添加
 * 5.枚举类默认提供了一个values()方法，该方法可以很方便地遍历所有的枚举值。
 * @author JIE
 */
public enum  SeaSonEnum {
    /**
     * 在第一行列出4 个枚举实例
     */
    SPRING, SUMMER, FALL, WINTER;

    /**
     * 定义枚举类时，需要显式列出所有的枚举值，如上面的SPRING，SUMMER，FALL，WINTER;所示，
     * 所有的枚举值之间以英文逗号( ，)隔开，枚举值列举结束后以英文分号作为结束。这些枚举值代表了
     * 该枚举类的所有可能的实例。
     *
     * 如果需要使用该枚举类的某个实例，则可使用EnumClass.variable 的形式，如SeasonEnum.SPRING
     */

}
