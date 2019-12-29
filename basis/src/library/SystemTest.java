package library;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * System 类
 * System 类代表当前Java 程序的运行平台，程序不能创建System 类的对象， System 类提供了一些类变量和类方法，
 * 允许直接通过System 类来调用这些类变量和类方法。
 *
 * System 类提供了代表标准输入、标准输出和错误输出的类变量，并提供了一些静态方法用于访问环境变量、系统属性的方法，
 * 还提供了加载文件和动态链接库的方法。下面程序通过System 类来访问操作的环境变量和系统属性。
 *
 * 加载文件和动态链接库主要对native 方法有用，对于一些特殊的功能(如访问操作系统底层硬件设备等) Java 程序无法实现，
 * 必须借助C 语言来完成，此时需要使用C 语言为Java 方法提供实现。其实现步骤如下:
 * 1.Java 程序中声明native 修饰的方法，类似于abstract 方法，只有方法签名，没有实现。编译该Java 程序，生成一个class 文件。
 * 2.用javah 编译第1 步生成的class 文件，将产生一个.h 文件。
 * 3.写一个.cpp 文件实现native 方法，这一步需要包含第2 步产生的.h 文件(这个.h文件中又包含了JDK 带的jni.h 文件)
 * 4.将第3 步的.cpp 文件编译成动态链接库文件。
 * 5.在Java 中用System 类的loadLibrary..()方法或Runtime 类的loadLibraryO方法加载第4 步产生的动态链接库文件，
 * Java 程序中就可以调用这个native 方法了。
 * @author JIE
 */
public class SystemTest {

    public static void main(String[] args) throws IOException {
        // 获取系统所有的环境变量
        Map<String, String> env = System.getenv();
        for (String name : env.keySet()) {
            System.out.println(name + "--->" + env.get(name));
        }
        // 获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        // 获取所有的系统属性
        Properties properties = System.getProperties();
        //将所有的系统属性保存到props.txt 文件中
        properties.store(new FileOutputStream( "C:\\Users\\JIE\\Desktop\\props.txt"), "System Properties");
        // 输出特定的系统属性
        System.out.println(System.getProperty("os.name"));

        /**
         * System 类还有两个获取系统当前时间的方法: currentTimeMillis()和nanoTime() ，它们都返回一个long 型整数
         * 实际上它们都返回当前时间与UTC 1970 年1 月1 日午夜的时间差，前者以毫秒作为单位，后者以纳秒作为单位。
         * 必须指出的是，这两个方法返回的时间粒度取决于底层操作系统，可能所在的操作系统根本不支持以毫秒、纳秒作为计时单位。
         * 例如，许多操作系统以几十毫秒为单位测量时间，currentTimeMillis()方法不可能返回精确的毫秒数;而nanoTime()方法很少用，
         * 因为大部分操作系统都不支持使用纳秒作为计时单位。
         *
         * 除此之外， System 类的in 、out 和err 分别代表系统的标准输入(通常是键盘)、标准输出(通常是显示器)和错误输出流，
         * 并提供了setIn() 、setOut()和setErr()方法来改变系统的标准输入、标准输出和标准错误输出流。
         *
         * System 类还提供了一个identityHashCode(Object x)方法， 该方法返回指定对象的精确hashCode 值，
         * 也就是根据该对象的地址计算得到的hashCode 值。当某个类的hashCode()方法被重写后，该类实例的hashCode()方法就不能唯一地标识该对象:
         * 但通过identityHashCode()方法返回的hashCode 值，依然是根据该对象的地址计算得到的hashCode 值
         * 所以，如果两个对象的identityHashCode 值相同，则两个对象绝对是同一个对象。如下程序所示。
         */

        // 下面程序中s1 和s2 是两个不同的对象
        String s1 = new String("hello");
        String s2 = new String("hello");
        // String 重写了hashCode ()方法, 改为根据字符序列计算hashCode 值, 因为s1 和s2 的字符序列相同，所以它们的hashCode ()方法返回值相同
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        // s1 和s2 是不向的字符串对象， 所以它们的identityHashCode 值不同
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
        String s3 = "Java";
        String s4 = "Java";
        // s3 和s4 是相同的字符串对象，所以它们的identityHashCode 值相同
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
        /**
         * 通过identityHashCode(Object x) 方法可以获得对象的identityHashCode 值，这个特殊的identityHashCode 值可以唯一地标识该对象。
         * 因为identityHashCode 值是根据对象的地址计算得到的，所以任何两个对象的identityHashCode 值总是不相等。
         */
    }
}
