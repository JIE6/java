package objecttwo.enums;

/**
 * 手动实现枚举类
 *
 * 在某些情况下， 一个类的对象是有限而且固定的，比如季节类，它只有4 个对象:
 * 再比如行星类目前只有8 个对象。这种实例有限而且固定的类，在Java 里被称为枚举类。
 *
 * @author JIE
 */
public class FalseEnum {
    /**
     * 在早期代码中，可能会直接使用简单的静态常量来表示枚举，例如如下代码:
     */
    public static final int SEASON_SPRING = 1;
    public static final int SEASON_SUMMER = 2;
    public static final int SEASON_FALL = 3;
    public static final int SEASON_WINTER = 4;

    /**
     * 这种定义方法简单明了，但存在如下几个问题。
     *
     * 1.类型不安全: 因为上面的每个季节实际上是一个int 整数，因此完全可以把一个季节当成一个int整数使用，
     * 例如进行加法运算SEASON SPRING + SEASON SUMMER ，这样的代码完全正常。
     * 2.没有命名空间:当需要使用季节时，必须在SPRING 前使用SEASON 前缀，否则程序可能与其他类中的静态常量混淆
     * 3.打印输出的意义不明确: 当输出某个季节时，例如输出SEASON SPRING ，实际上输出的是1，这个1 很难猜测它代表了春天。
     *
     * 但枚举又确实有存在的意义，因此早期也可采用通过定义类的方式来实现，可以采用如下设计方式。
     * 1.通过private 将构造器隐藏起来。
     * 2.把这个类的所有可能实例都使用public static final 修饰的类变量来保存。
     * 3.如果有必要，可以提供一些静态方法，允许其他程序根据特定参数来获取与之匹配的实例。
     * 4.使用枚举类可以使程序更加健壮，避免创建对象的随意性。
     *
     * 但通过定义类来实现枚举的代码量比较大，实现起来也比较麻烦
     * Java 从JDK 1.5 后就增加了对枚举类的支持。
     */
}
