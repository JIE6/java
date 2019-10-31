package objecttwo;

/**
 * 单例
 * 大部分时候都把类的构造器定义成public 访问权限，允许任何类自由创建该类的对象。
 * 但在某些时候，允许其他类自由创建该类的对象没有任何意义，还可能造成系统性能下降(因为频繁地创建对象、回收对象带来的系统开销问题)。
 * 例如，系统可能只有一个窗口管理器、一个假脱机打印设备或一个数据库引擎访问点，此时如果在系统中为这些类创建多个对象就没有太大的实际意义。
 *
 * 如果一个类始终只能创建一个实例，则这个类被称为单例类。
 *
 * 总之，在一些特殊场景下，要求不允许自由创建该类的对象，而只允许为该类创建一个对象。
 * 为了避免其他类自由创建该类的实例，应该把该类的构造器使用private 修饰，从而把该类的所有构造器隐藏起来。
 *
 * 根据良好封装的原则: 一旦把该类的构造器隐藏起来，就需要提供一个public 方法作为该类的访问点，用于创建该类的对象，
 * 且该方法必须使用static 修饰(因为调用该方法之前还不存在对象，因此调用该方法的不可能是对象，只能是类) 。
 *
 * 除此之外，该类还必须缓存己经创建的对象， 否则该类无法知道是否曾经创建过对象，也就无法保证只创建一个对象。
 * 为此该类需要使用一个成员变量来保存曾经创建的对象，因为该成员变量需要被上面的静态方法访问，故该成员变量必须使用static 修饰。
 *
 * 基于上面的介绍，下面程序创建了一个单例类。
 * @author JIE
 */
public class Singleton {

    /**
     * 使用一个类变量来缓存曾经创建的实例
     */
    private static Singleton singleton;

    /**
     * 对构造器使用private 修饰， 隐藏该构造器
     */
    private Singleton() {

    }

    /**
     * 提供一个静态方法，用于返回Singleton 实例
     * 该方法可以加入自定义控制，保证只产生一个Singleton 对象
     */
    public static Singleton getInstance() {
        /**
         * 如果singleton 为null ，则表明还不曾创建Singleton 对象
         * 如果singleton 不为nu11 ，则表明已经创建了Singleton 对象
         * 将不会重新创建新的实例
         */
        if (singleton == null) {
            singleton = new Singleton();
            return singleton;
        }
        return singleton;
    }

    public static void main(String[] args) {
        // 创建singleton1 对象不能通过构造器, 只能通过getInstance 方法来得到实例
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        // true
        System.out.println(singleton1 == singleton2);
        /**
         * 正是通过上面getInstance 方法提供的自定义控制(这也是封装的优势: 不允许自由访问类的成员变量和实现细节，而是通过方法来控制合适暴露)
         * 保证Singleton 类只能产生一个实例。所以，在main()方法中， 看到两次产生的Singleton 对象实际上是同一个对象。
         */
    }
}
