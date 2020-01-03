package throwable;

/**
 * 使用throw 抛出异常
 *
 * 如果需要在程序中自行抛出异常，则应使用throw 语句， throw 语句可以单独使用， throw 语句抛出的不是异常类，
 * 而是一个异常实例，而且每次只能抛出一个异常实例。throw 语句的语法格式如下:
 *
 * throw ExceptionInstance;
 *
 * 如果throw 语句抛出的异常是Checked 异常，则该throw 语句要么处于try 块里， 显式捕获该异常，要么放在一个带throws 声明抛出的方法中，
 * 即把该异常交给该方法的调用者处理: 如果throw 语句抛出的异常是Runtime 异常， 则该语句无须放在try块里，也无须放在带throws 声明抛出的方法中: 程序
 * 既可以显式使用try...catch 来捕获并处理该异常，也可以完全不理会该异常， 把该异常交给该方法调用者处理。
 * 例如下面例子程序。
 * @author JIE
 */
public class ThrowTest {

    public static void main(String[] args) {
        try {
            // 调用声明抛出Checked 异常的方法，要么显式捕获该异常, 要么在main 方法中再次声明抛出
            throwChecked();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // 调用声明抛出Runtime 异常的方法既可以显式捕获该异常, 也可不理会该异常
        throwRuntime();

        /**
         * 通过上面程序也可以看出，自行抛出Runtime 异常比自行抛出Checked 异常的灵活性更好。同样，抛出Checked 异常则可以让编译器提醒程序员必须处理该异常。
         */
    }

    public static void throwChecked()throws Exception {
        throw new Exception("throwChecked");
    }

    public static void throwRuntime() {
        throw new RuntimeException("throwRuntime");
    }
}
