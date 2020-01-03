package throwable;

/**
 * 使用throws 声明抛出异常
 *
 * 使用throws 声明抛出异常的思路是，当前方法不知道如何处理这种类型的异常，该异常应该由上一级调用者处理;
 * 如果main 方法也不知道如何处理这种类型的异常，也可以使用throws 声明抛出异常，该异常将交给jvm 处理。
 * jvm 对异常的处理方法是，打印异常的跟踪战信息，井中止程序运行，这就是前面程序在遇到异常后自动结束的原因。
 *
 * 前面有些程序己经用到了throws 声明抛出， throws 声明抛出只能在方法签名中使用， throws可以声明抛出多个异常类，
 * 多个异常类之间以逗号隔开。throws 声明抛出的语法格式如下:
 * throws ExceptionClass1 , ExceptionClass2 .. .
 * 上面throws 声明抛出的语法格式仅跟在方法签名之后, 一旦使用throws 语句声明抛出该异常，程序就无须使用try...catch 块来捕获该异常了。
 * 程序声明不处理xxxException 异常， 将该异常交给JVM 处理，所以程序一旦遇到该异常， JVM就会打印该异常的跟踪技信息， 并结束程序
 * @author JIE
 */
public class ThrowsTest {

    public static void main(String[] args) throws IndexOutOfBoundsException, ArithmeticException, NullPointerException {

    }
}
