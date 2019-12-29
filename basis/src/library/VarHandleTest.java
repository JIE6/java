package library;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;
import java.util.Arrays;

/**
 * Java 9 增加的VarHandle
 *
 * VarHandle 主要用于动态操作数组的元素或对象的成员变量。VarHandle 与MethodHandle 非常相似，
 * 它也需要通过MethodHandles 来获取实例，接下来调用VarHandle 的方法即可动态操作指定数组的元素或指定对象的成员变量。
 * 下面程序示范了VarHandle 的用法。
 * @author JIE
 */
public class VarHandleTest {
    static int MAX_AGE;

    class User{
        String name;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String[] sa = new String[] {"Java" , "Kotlin" , "Go"};
        // 获取一个String []数组的VarHand1e 对象
        VarHandle avh = MethodHandles.arrayElementVarHandle(String[].class);
        // 比较并设直:如果第三个元素是Go . 则该元素被设为Lua
        boolean b = avh.compareAndSet(sa, 2, "Go", "Lua");
        System.out.println(b);
        System.out.println(Arrays.toString(sa));
        // 获取sa 数组的第二个元素
        System.out.println(avh.get(sa, 1));
        // 获取并设置:返回第三个元素，并将第三个元素设为Swift
        System.out.println(avh.getAndSet(sa, 2, "Swift"));
        System.out.println(Arrays.toString(sa));
        /**
         * 从上面代码可以看出，程序调用MethodHandles 类的静态方法可获取操作数组的VarHandle 对象，接下来程序可通过VarHandle 对象来操作数组的方法，
         * 包括比较并设置数组元素、获取并设置数组元素等， VarHandle 具体支持哪些方法则可参考API 文档。
         */

        // 用findVarHandle 方法获取User 类中名为name 类型为String 的实例变量
        VarHandle name = MethodHandles.lookup().findVarHandle(User.class, "name", String.class);
        // 通过VarHandle 获取实例变量的值，需要传入对象作为调用者
        User user = new VarHandleTest().new User();
        System.out.println(name.get(user));
        // 通过VarHandle 设置指定实例变量的值
        name.set(user, "孙悟空");
        System.out.println(user.name);
        /**
         * 上面程序代码则示范了使用VarHandle 操作实例变量的情形，由于实例变量需要使用对象来访问， 因此使用VarHandle 操作实例变量时需要传入一个User 对象。
         * VarHandle 既可设置实例变量的值，也可获取实例变量的值。当然VarHandle 也提供了更多的方法来操作实例变量，具体可参考API 文挡。
         */
        //用findVarHandle 方法获取VarHandleTest 类中名为MAX_AGE 、类型为Integer 的类变量
        VarHandle maxAge = MethodHandles.lookup().findStaticVarHandle(VarHandleTest.class, "MAX_AGE", int.class);
        System.out.println(maxAge.get());
        // 通过VarHandle 设置指定类变量的值
        maxAge.set(100);
        // 输出VarHandleTest 的MAX_AGE 类变量
        System.out.println(VarHandleTest.MAX_AGE);
        /**
         * 使用VarHandle 操作类变量与操作实例变量差别不大，区别只是类变量不需要对象，因此使用VarHandle 操作类变量时无须传入对象作为参数。
         */

        /**
         * VarHandle 与MethodHandle 一样，它也是一种动态调用机制，当程序通过MethodHandles.Lookup来获取成员变量时，
         * 可根据字符串名称来获取成员变量，这个字符串名称同样可以是动态改变的，因此非常灵活。
         */
    }
}
