package throwable;

import java.sql.SQLException;

/**
 * 在JDK 1.4以前， 程序员必须自己编写代码来保持原始异常信息。从JDK 1 .4以后，所有Throwable的子类在构造器中都可以接收一个cause 对象作为参数。
 * 这个cause 就用来表示原始异常，这样可以把原始异常传递给新的异常，使得即使在当前位置创建并抛出了新的异常，你也能通过这个异常链追踪到异常最初发生的位置。
 * @author JIE
 */
public class SalException extends Exception {

    public SalException() {}

    public SalException(String msg) {
        super(msg);
    }

    /**
     * 创建一个可以接收Throwable 参数的构造器
     */
    public SalException(Throwable throwable) {
        super(throwable);
    }

    public void calSal() throws SalException {
        try {
            throw new SQLException("");
        }catch (Exception e) {
            throw new SalException(e);
        }
    }

    public static void main(String[] args) throws SalException {
        new SalException().calSal();

        /**
         * 上面程序中代码创建SalException 对象时，传入了一个Exception对象，而不是传入了一个String 对象，这就需要SalException 类有相应的构造器。
         * 从JDK 1 .4以后， Throwable 基类已有了一个可以接收Exception 参数的方法，所以可以采用如下代码来定义SalException 类。
         */
    }
}
