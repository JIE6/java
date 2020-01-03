package throwable;

/**
 * Java 7 新增的多异常捕获
 *
 * 在Java 7 以前，每个catch 块只能捕获一种类型的异常; 但从Java 7 开始， 一个catch 块可以捕获多种类型的异常。
 *
 * 使用一个catch 块捕获多种类型的异常时需要注意如下两个地方。
 * 1.捕获多种类型的异常时，多种异常类型之间用竖线(|) 隔开。
 * 2.捕获多种类型的异常时，异常变量有隐式的final 修饰，因此程序不能对异常变量重新赋值。
 *
 * @author JIE
 */
public class MultiExceptionTest {

    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            int c = a / b;
            System.out.println(c);
        }catch (IndexOutOfBoundsException | NumberFormatException | ArithmeticException e) {
            System.out.println( "程序发生了数组越界、数字格式异常、算术异常之一" );
            // 捕获多异常时，异常变量默认有final 修饰, 所以下面代码有错
            // e = new NumberFormatException("");
        }catch (Exception e) {
            System.out.println("未知异常");
            // 捕获一种类型的异常时，异常变量没有final 修饰, 所以下面代码完全正确
            e = new RuntimeException("test");
        }
    }
}
