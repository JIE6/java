package objecttwo.internal;

/**
 * Java 8 改进的匿名内部类
 * 匿名内部类适合创建那种只需要一次使用的类，例如前面介绍命令模式时所需要的Command 对象。
 * 医名内部类的语法有点奇怪，创建匿名内部类时会立即创建一个该类的实例， 这个类定义立即消失， 匿名内部类不能重复使用。
 * 定义匿名内部类的格式如下:
 * new 实现接口() | 父类构造器(实参列表) {
 *     //匿名内部类的类体部分
 * }
 * 从上面定义可以看出， 匿名内部类必须继承一个父类，或实现一个接口， 但最多只能继承一个父类，或实现一个接口。
 * 关于医名内部类还有如下两条规则。
 * 匿名内部类不能是抽象类，因为系统在创建匿名内部类时，会立即创建匿名内部类的对象。因此不允许将匿名内部类定义成抽象类。
 * 匿名内部类不能定义构造器。由于匿名内部类没有类名，所以无法定义构造器，但匿名内部类可以定义初始化块， 可以通过实例初始化块来完成构造器需要完成的事情。
 * @author JIE
 */
public interface Product {


    /**
     * 获取金额
     * @return
     */
    double getPrice();

    /**
     * 获取姓名
     * @return
     */
    String getName();
}
