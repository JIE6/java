package throwable;

import java.io.IOException;

/**
 * 方法重写时声明抛出异常的限制
 *
 * 使用throws 声明抛出异常时有一个限制，就是方法重写时"两小"中的一条规则: 子类方法声明抛出的异常类型应该是父类方法声明抛出的异常类型的子类或相同，
 * 子类方法声明抛出的异常不允许比父类方法声明抛出的异常多。
 * 看如下程序。
 * @author JIE
 */
public class OverrideThrows {

    public void test() throws IOException {

    }

    class Sub extends OverrideThrows {

        /**
         * 子类方法声明抛出了比父类方法更大的异常所以下面方法出错
         */
//        @Override
//        public void test() throws Exception { }
    }

    /**
     * 上面程序中Sub 子类中的test()方法声明抛出Exception ，该Exception 是其父类声明抛出异常IOException 类的父类，这将导致程序无法通过编译。
     *
     * 由此可见，使用Checked 异常至少存在如下两大不便之处。
     * 1.对于程序中的Checked 异常， Java 要求必须显式捕获并处理该异常，或者显式声明抛出该异常。这样就增加了编程复杂度。
     * 2.如果在方法中显式声明抛出Checked 异常，将会导致方法签名与异常藕合，如果该方法是重写父类的方法， 则该方法抛出的异常还会受到被重写方法所抛出异常的限制。
     *
     * 在大部分时候推荐使用Runtime 异常， 而不使用Checked 异常。尤其当程序需要自行抛出异常时(如何自行抛出异常请看下一节) ，使用Runtime 异常将更加简洁。
     *
     * 但Checked 异常也有其优势Checked 异常能在编译时提醒程序员代码可能存在的问题，提醒程序员必须注意处理该异常，或者声明该异常由该方法调用者来处理，
     * 从而可以避免程序员因为粗心而忘记处理该异常的错误。
     */
}
