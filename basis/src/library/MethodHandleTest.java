package library;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

/**
 * Java 9 增强的MethodHandle
 *
 * Java 9 引入了一个新的VarHandle 类，井增强了原有的MethodHandle 类。通过这两个类，允许Java像动态语言一样引用变量、引用方法，并调用它们。
 * MethodHandle 为Java 增加了方法引用的功能， 方法引用的概念有点类似于C 的"函数指针"。这种方法引用是一种轻量级的引用方式，
 * 它不会检查方法的访问权限，也不管方法所属的类、实例方法或静态方法， MethodHandle 就是简单代表特定的方法，井可通过MethodHandle 来调用方法。\
 * 为了使用MethodHandle ，还涉及如下几个类。
 * 1.MethodHandles: MethodHandle 的工厂类， 它提供了一系列静态方法用于获取MethodHandle 。
 * 2.MethodHandles.Lookup: Lookup 静态内部类也是MethodHandle 、VarHandle 的工厂类，专门用于获取MethodHandle 和VarHandle 。
 * 3.MethodType: 代表一个方法类型。MethodType 根据方法的形参、返回值类型来确定方法类型
 * 下面程序示范了MethodHandle 的用法。
 * @author JIE
 */
public class MethodHandleTest {

    /**
     * 定义一个private 类方法
     */
    private static void hello() {
        System.out.println("Hello World!");
    }

    /**
     * 定义一个private 实例方法
     */
    private String hello(String name) {
        System.out.println("name: " + name);
        return name + "你好！";
    }


    public static void main(String[] args) throws Throwable {
        // 定义一个返回值为void、不带形参的方法类型
        MethodType type = MethodType.methodType(void.class);
        // 使用MethodHandles.Lookup 的findStatic 获取类方法
        MethodHandle methodHandle = MethodHandles.lookup().findStatic(MethodHandleTest.class, "hello", type);
        // 通过MethodHand1e 执行方法
        methodHandle.invoke();

        // 使用MethodHand1es.Lookup 的findVirtual 获取实例方法
        MethodHandle hello = MethodHandles.lookup().findVirtual(MethodHandleTest.class, "hello",
                // 指定获取返回值为String、形参为String 的方法类型
                MethodType.methodType(String.class, String.class));
        // 通过MethodHandle 执行方法，传入主调对象和参数
        System.out.println(hello.invoke(new MethodHandleTest(), "孙悟空"));

        /**
         * 从上面代码可以看出，程序使用MethodHandles.Lookup 对象根据类、方法名、方法类型来获取MethodHandle 对象。
         * 由于此处的方法名只是一个字符串，而该字符串可以来自于变量、配置文件等，这意味着通过MethodHandle 可以让Java 动态调用某个方法。
         */
    }
}
