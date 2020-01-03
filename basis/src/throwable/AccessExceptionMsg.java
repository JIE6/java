package throwable;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 访问异常信息
 *
 * 如果程序需要在catch 块中访问异常对象的相关信息，则可以通过访问catch 块的后异常形参来获得。当Java 运行时决定调用某个catch 块来处理该异常对象时，
 * 会将异常对象赋给catch 块后的异常参数，程序即可通过该参数来获得异常的相关信息。
 * 所有的异常对象都包含了如下几个常用方法。
 * getMessage(): 返回该异常的详细描述字符串。
 * printStackTrace(): 将该异常的跟踪栈信息输出到标准错误输出。
 * printStackTrace(PrintSteam s): 将该异常的跟踪栈信息输出到指定输出流。
 * getStackTrace(): 返回该异常的跟踪栈信息。
 * 下面例子程序演示了程序如何访问异常信息。
 * @author JIE
 */
public class AccessExceptionMsg {

    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("a.txt" );
        }catch (IOException ioe) {
            System.out.println(ioe.getMessage());
            ioe.printStackTrace();
        }
        /**
         * 上面程序调用了Exception 对象的getMessage() 方法来得到异常对象的详细信息， 也使用了printStackTrace()方法来打印该异常的跟踪信息。
         */
    }
}
