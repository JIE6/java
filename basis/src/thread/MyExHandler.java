package thread;

/**
 * ThreadGroup 内还定义了一个很有用的方法: void uncaughtException(Thread t, Throwable e) ，该方法可以处理该线程组内的任意线程所抛出的未处理异常。
 *
 * 从Java 5 开始， Java 加强了线程的异常处理，如果线程执行过程中抛出了一个未处理异常， JVM在结束该线程之前会自动查找是否有对应的Thread.UncaughtExceptionHandler 对象，
 * 如果找到该处理器对象，则会调用该对象的uncaughtException(Thread t, Throwable e)方法来处理该异常。
 *
 * Thread.UncaughtExceptionHandler 是Thread 类的一个静态内部接口，该接口内只有一个方法: void uncaughtException(Thread t, Throwable e) ，
 * 该方法中的t 代表出现异常的线程，而e 代表该线程抛出的异常。
 *
 * Thread 类提供了如下两个方法来设置异常处理器。
 * static setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler eh): 为该线程类的所有线程实例设置默认的异常处理器。
 * setUncaughtExceptionHandler(Thread. UncaughtExceptionHandler eh) : 为指定的线程实例设置异常处理器。
 *
 * ThreadGroup 类实现了Thread.UncaughtExceptionHandler 接口，所以每个线程所属的线程组将会作为默认的异常处理器。当一个线程抛出未处理异常肘，
 * JVM 会首先查找该异常对应的异常处理器( setUncaughtExceptionHandler()方法设置的异常处理器) ，如果找到该异常处理器，则将调用该异常处理器处理该异常:
 * 否则， JVM 将会调用该线程所属的线程组对象的uncaughtException()方法来处理该异常
 *
 * 线程组处理异常的默认流程如下
 * 1.如果该线程组有父线程组，则调用父线程组的uncaughtException()方法来处理该异常。
 * 2.如果该线程实例所属的线程类有默认的异常处理器(由setDefaultUncaughtExceptionHandler()方法设置的异常处理器)，那么就调用该异常处理器来处理该异常。
 * 3.如果该异常对象是ThreadDeath 的对象， 则不做任何处理: 否则，将异常跟踪枝的信息打印到System.err 错误输出流，并结束该线程。
 *
 * 下面程序为主线程设置了异常处理器， 当主线程运行抛出未处理异常时，该异常处理器将会起作用。
 *
 * @author JIE
 */
public class MyExHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println(t + ", 线程出现了异常:" + e);
    }

    public static void main(String[] args) {
        // 设置主线程的异常处理器
        Thread.currentThread().setUncaughtExceptionHandler(new MyExHandler());
        int i = 10 / 0;
        System.out.println("程序正常结束");
    }

    /**
     * 土面程序的主方法中粗体字代码为主线程设置了异常处理器，而 int i = 10 / 0;代码处将引发一个未处理异常，
     * 则该异常处理器会负责处理该异常。运行该程序，会看到如下输出:
     * Thread[main,5,main], 线程出现了异常:java.lang.ArithmeticException: / by zero
     *
     * 从上面程序的执行结果来看， 虽然程序指定了异常处理器对未捕获的异常进行处理，而且该异常处理器也确实起作用了，但程序依然不会正常结束。
     * 这说明异常处理器与通过catch 捕获异常是不同的. 当使用catch捕获异常时，异常不会向上传播给上一级调用者;但使用异常处理器对异常进行处理之后，
     * 异常依然会传播给上一级调用者。
     */
}
