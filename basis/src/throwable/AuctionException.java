package throwable;

/**
 * 自定义异常类
 *
 * 在通常情况下， 程序很少会自行抛出系统异常，因为异常的类名通常也包含了该异常的有用信息。所以在选择抛出异常时，应该选择合适的异常类，从而可以明确地描述该异常情况。
 * 在这种情形下，应用程序常常需要抛出自定义异常。
 *
 * 用户自定义异常都应该继承Exception 基类，如果希望自定义Runtime 异常，则应该继承RuntimeException 基类。定义异常类时通常需要提供两个构造器:
 * 一个是无参数的构造器;另一个是带一个字符串参数的构造器，这个宇符串将作为该异常对象的描述信息( 也就是异常对象的getMessage()方法的返回值) 。
 *
 * 下面例子程序创建了一个自定义异常类。
 * @author JIE
 */
public class AuctionException extends Exception {

    /**
     * 无参构造器
     */
    public AuctionException() { }

    /**
     * 带一个字符串参数的构造器
     */
    public AuctionException(String msg) {
        super(msg);
    }

    /**
     * 上面程序创建了AuctionException 异常类，并为该异常类提供了两个构造器。尤其是创建的带一个字符串参数的构造器，其执行休也非常简单，仅通过super 来调用父类的构造器，
     * 正是这行super 调用可以将此字符串参数传给异常对象的message 属性， 该message 属性就是该异常对象的详细描述信息。
     *
     * 如果需要自定义 Runtime 异常，只需将 程序中的 Exception 基类改为 RuntimeException 基类， 其他地方无须修改。
     */
}
