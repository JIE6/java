package throwable;

import com.sun.source.tree.NewArrayTree;

import java.io.Closeable;
import java.io.IOException;

/**
 * Java9 增强的自动关闭资源的try 语句
 *
 * 在Java 7 以前，当程序使用finally 块关闭资源时，程序显得异常雕肿。
 * Java 7 的出现改变了这种局面。
 * Java 7 增强了try语句的功能, 它允许在try关键字后紧跟一对圆括号，圆括号可以声明、初始化一个或多个资源，
 * 此处的资源指的是那些必须在程序结束时显式关闭的资源(比如数据库连接、网络连接等)，try语句在该语句结束时自动关闭这些资源。
 *
 * 需要指出的是，为了保证try 语句可以正常关闭资源，这些资源实现类必须实现AutoCloseable 或Closeable 接口，实现这两个接口就必须实现close()方法。
 *
 * Closeable 是AutoCloseable 的子接口，可以被自动关闭的资源类要么实现AutoCloseable 接口，要么实现Closeable 接口。Closeable 接口里的close()方法声明抛出了
 * IOException ， 因此它的实现类在实现c1ose()方法时只能声明抛出IOException 或其子类，AutoCloseable 接口里的c1ose()方法声明抛出了Exception ，
 * 因此它的实现类在实现c1ose()方法时可以声明抛出任何异常。
 *
 * 下面程序示范了如何使用自动关闭资源的try 语句。
 * @author JIE
 */
public class AutoCloseTest implements Closeable {

    private int count;

    public AutoCloseTest(int count) {
        this.count = count;
    }

    public static void main(String[] args) throws IOException {
        try (
                // /声明、初始化一个可关闭的资源， try 语句会自动关闭这个资源
                AutoCloseTest autoCloseTest = new AutoCloseTest(15);
        ){
            System.out.println(autoCloseTest.count);
        }

        /**
         * 自动关闭资源的try语句相当于包含了隐式的finally 块(这个finally 块用于关闭资源) ，因此这个try 语句可以既没有catch 块，也没有finally 块。
         *
         * Java 7 几乎把所有的"资源类" ( 包括文件 IO 的各种类、JDBC 编程的Connection 、Statement 等接口)进行了改写，改写后资源类都实现了AutoCloseable 或Closeable 接口。
         *
         * 如果程序需要，自动关闭资源的try语句后也可以带多个catch 块和一个finally 块。
         */

        /**
         * Java 9 再次增强了这种try语句， Java 9 不要求在try 后的圆括号内声明并创建资源，只需要自动关闭的资源有final 修饰或者是有效的final (effectively final) ,
         * Java 9 允许将资源变量放在try 后的圆括号内。上面程序在Java 9 中可改写为如下形式。
         */
        // 有final 修饰的资源
        final AutoCloseTest act2 = new AutoCloseTest(6);
        // 没有显式使用 final 修饰，但只要不对该变量重新赋值，该变量就是有效的 final
        AutoCloseTest act3 = new AutoCloseTest(7);

        // 只要将两个资源放在try 后的圆括号内即可
        try (act2; act3){
            // 使用两个资源
            System.out.println(act2.count);
            System.out.println(act3.count);
        }

    }

    @Override
    public void close() throws IOException {
        System.out.println("自动....close..........count="+count);
    }
}
