package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * 线程的创建和启动 - 使用Callable 和Future 创建线程
 *
 * 前面己经指出，通过实现Runnable 接口创建多线程时， Thread 类的作用就是把run()方法包装成线程执行体。那么是否可以直接把任意方法都包装成线程执行体呢?
 * Java 目前不行! 但Java 的模仿者C#可以( C#可以把任意方法包装成线程执行体，包括有返回值的方法) 。
 *
 * 也许受此启发， 从Java 5 开始， Java 提供了Callable 接口， 该接口怎么看都像是Runnable 接口的增强版，
 * Callable 接口提供了一个call()方法可以作为线程执行体，但call()方法比run()方法功能更强大。
 *
 * call()方法可以有返回值。
 * call()方法可以声明抛出异常。
 *
 * 因此完全可以提供一个Callable 对象作为Thread 的target ，而该线程的线程执行体就是该Callable对象的call()方法。
 * 问题是: Callable 接口是Java 5 新增的接口，而且它不是Runnable 接口的子接口，所以Callable 对象不能直接作为Thread 的target 。
 * 而且call()方法还有一个返回值, call()方法并不是直接调用，它是作为线程执行体被调用的。那么如何获取call()方法的返回值呢?
 *
 * Java 5 提供了Future 接口来代表Callable 接口里call()方法的返回值，并为Future 接口提供了一个FutureTask 实现类，
 * 该实现类实现了Future 接口，并实现了Runnable 接口, 可以作为Thread 类的target 。
 *
 * 在Future 接口里定义了如下几个公共方法来控制它关联的Callable 任务。
 * boolean cancel(boolean mayInterruptIfRunning): 试图取消该Future 里关联的Callable 任务。
 * V get(): 返回Callable 任务里call()方法的返回值。调用该方法将导致程序阻塞，必须等到子线程结束后才会得到返回值。
 * V get(long timeout，TimeUnit unit): 返回Callable 任务里call()方法的返回值。该方法让程序最多阻塞timeout 和unit 指定的时间，
 * 如果经过指定时间后Callable 任务依然没有返回值，将会抛出TimeoutException 异常。
 * boolean isCancelled(): 如果在Callable 任务正常完成前被取消，则返回true 。
 * boolean isDone(): 如果Callable 任务己完成，则返回true 。
 *
 * Callable 接口有泛型限制， Callable 接口里的泛型形参类型与call()方法返回值类型相同。而且Callable 接口是函数式接口，因此可使用Lambda 表达式创建Callable 对象。
 *
 * 创建并启动有返回值的线程的步骤如下。
 * 1.创建Callable 接口的实现类，并实现call()方法，该call()方法将作为线程执行体，且该call()方法有返回值，
 * 再创建Callable 实现类的实例。从Java 8 开始，可以直接使用Lambda 表达式创建Callable对象。
 * 2.使用FutureTask 类来包装Callable 对象，该FutureTask 对象封装了该Callable 对象的call()方法的返回值。
 * 3.使用FutureTask 对象作为Thread 对象的target 创建并启动新线程。
 * 4.调用FutureTask 对象的get()方法来获得子线程执行结束后的返回值。
 *
 * 下面程序通过实现Callable 接口来实现线程类，并启动该线程。
 * @author JIE
 */
public class ThirdThread {

    public static void main(String[] args) {
        // 创建Callable 对象
        ThirdThread tt = new ThirdThread();
        // 先使用Lambda 表达式创建Callable<Integer>对象, 使用FutureTask 来包装Callable 对象
        FutureTask<Integer> task = new FutureTask<>((Callable<Integer>)() -> {
            int i = 0;
            for (; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
            // call()方法可以有返回值
            return i;
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                // 实质还是以Callable 对象来创建并启动线程的
                new Thread(task, "有返回值的线程").start();
            }
        }
        try {
            // 获取线程返回值
            System.out.println("子线程的返回值：" + task.get());
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    /**
     * 上面程序中使用Lambda 表达式直接创建了Callable 对象，这样就无须先创建Callable 实现类，再方法允许声明抛出异常，而且允许带返回值。
     *
     * 上面程序中的代码是以Callable 对象来启动线程的关键代码。程序先使用Lambda 表达式创建一个Callable 对象，然后将该实例包装成一个FutureTask 对象。
     * 主线程中当循环变量i 等于20 时，程序启动以FutureTask 对象为target 的线程。程序最后调用FutureTask 对象的get()方法来返回call()方法的返回值.
     * 该方法将导致主线程被阻塞，直到call()方法结束并返回为止。
     *
     * 运行上面程序，将看到主线程和call()方法所代表的线程交替执行的情形，程序最后还会输出call()方法的返回值。
     */
}
