package library;

/**
 * 运行Java 程序的参数
 *
 * 回忆Java 程序的入口, main()方法的方法签名:
 * public static void main(String[] args) {...}
 *
 * main()方法为什么采用这个方法签名?
 * public 修饰符: Java 类由JVM 调用， 为了让JVM 可以自由调用这个main()方法，所以使用public修饰符把这个方法暴露出来。
 * static 修饰符: JVM 调用这个主方法时， 不会先创建该主类的对象， 然后通过对象来调用该主方法。JVM 直接通过该类来调用主方法， 因此使用static 修饰该主方法。
 * void 返回值: 因为主方法被JVM 调用，该方法的返回值将返回给JVM ， 这没有任何意义， 因此main()方法没有返回值。
 *
 * 上面方法中还包括一个字符串数组形参， 根据方法调用的规则: 谁调用方法， 谁负责为形参赋值。
 * 也就是说， main()方法由JVM 调用，即args 形参应该由JVM 负责赋值。但JVM 怎么知道如何为args数组赋值呢? 先看下面程序。
 * @author JIE
 */
public class ArgsTest {

    public static void main(String[] args) {
        // 输出args 数组的长度
        System.out.println(args.length);
        // 遍历args 数组的每个元素
        for (String arg : args) {
            System.out.println(arg);
        }
    }

    /**
     * 使用java ArgsTest 命令运行上面程序， 看到程序仅仅输出一个0 ， 这表明args 数组是一个长度为0 的数组
     * 这是合理的。因为计算机是没有思考能力的，它只能忠实地执行用户交给它的任务，既然程序没有给args
     * 数组设定参数值，那么JVM 就不知道args 数组的元素，所以JVM 将args数组设置成一个长度为0 的数组。
     *
     * 改为如下命令来运行上面程序:
     * java ArgsTest Java Spring
     * 如果运行Java 程序时在类名后紧跟一个或多个字符串(多个字符串之间以空格隔开)， JVM 就会把这些字符串依次赋给args 数组元素。
     *
     * 如果某参数本身包含了空格，则应该将该参数用双引号( "" )括起来，否则JVM会把这个空格当成参数分隔符，而不是当成参数本身
     * 例如， 采用如下命令来运行上面程序:
     * java ArgsTest "Java Spring"
     * 看到args 数组的长度是1，只有一个数组元素，其值是Java Spring 。
     */
}
