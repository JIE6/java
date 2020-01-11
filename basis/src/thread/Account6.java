package thread;

/**
 * ThreadLocal 类
 * 早在JDK 1. 2 推出之时， Java 就为多线程编程提供了一个ThreadLocal 类:从Java 5.0 以后， Java引入了泛型支持， Ja va 为该ThreadLocal 类增加了泛型支持，
 * 即: ThreadLocal<T> 。通过使用ThreadLocal类可以简化多线程编程时的并发访问，使用这个工具类可以很简捷地隔离多线程程序的竞争资源。
 *
 * ThreadLocal ， 是Thread Local Variable (线程局部变量) 的意思， 也许将它命名为ThreadLocalVar更加合适。线程局部变量( ThreadLocal )的功用其实非常简单，
 * 就是为每一个使用该变量的线程都提供一个变量值的副本，使每一个线程都可以独立地改变自己的副本，而不会和其他线程的副本冲突。
 * 从线程的角度看， 就好像每一个线程都完全拥有该变量一样。
 *
 * ThreadLocal 类的用法非常简单，它只提供了如下三个public 方法。
 * T get() : 返回此线程局部变量中当前线程副本中的值。
 * void remove(): 删除此线程局部变量中当前线程的值。
 * void set(T value): 设置此线程局部变量中当前线程副本中的值。
 *
 * 下面程序将证明ThreadLocal 的作用。
 *
 * @author JIE
 */
public class Account6 {

    /**
     * 定义一个ThreadLocal 类型的变量， 该变量将是一个线程局部变量, 每个线程都会保留该变量的一个副本
     */
    private ThreadLocal<String> name = new ThreadLocal<>();

    /**
     * 定义一个初始化name 成员变量的构造器
     * @param name
     */
    public Account6(String name) {
        this.name.set(name);
        // 下面代码用于访问当前线程的name 副本的值
        System.out.println(this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
