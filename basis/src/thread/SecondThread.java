package thread;

/**
 * 线程的创建和启动 - 实现Runnable 接口创建线程类
 *
 * 实现Runnable 接口来创建并启动多线程的步骤如下。
 * 1.定义Runnable 接口的实现类， 并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
 * 2.创建Runnable 实现类的实例，并以此实例作为Thread 的target 来创建Thread 对象，该Thread对象才是真正的线程对象。代码如下所示。
 * // 创建Runnable 实现类的对象
 * SecondThread st = new SecondThread();
 * // 以Runnable 实现类的对象作为Thread 的target 来创建Thread 对象，即线程对象
 * new Thread(st);
 * 也可以在创建Thread 对象时为该Thread 对象指定一个名字，代码如下所示。
 * // 创建Thread 对象时指定target 和新线程的名字
 * new Thread(st, "新线程1");
 * Runnable 对象仅仅作为Thread 对象的target ， Runnable 实现类里包含的run()方法仅作为线程执行休。而实际的线程对象依然是Thread 实例，
 * 只是该Thread 线程负责执行其target 的run()方法。
 * 3.调用线程对象的start()方法来启动该线程。
 * 下面程序示范了通过实现Runnable 接口来创建井启动多线程。
 *
 * 通过实现Runnable 接口来创建线程类
 * @author JIE
 */
public class SecondThread implements Runnable{

    private int i;

    /**
     * run ()方法同样是线程执行体
     */
    @Override
    public void run() {
        /*
         * 当线程类实现Runnable 接口时
         * 如果想获取当前线程，只能用Thread.currentThread() 方法
         */
        for (; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // 调用Thread 的 currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                // 通过new Thread(target , name) 方法创建新线程
                SecondThread st = new SecondThread();
                new Thread(st, "SecondThread-1").start();
                new Thread(st, "SecondThread-b").start();
            }
        }
    }
    /**
     * 上面程序实现了run() 方法，也就是定义了该线程的线程执行体。对比FirstThread 中的run()方法体和SecondThread 中的run()方法体不难发现，
     * 通过继承Thread 类来获得当前线程对象比较简单， 直接使用this 就可以了;但通过实现Runnable 接口来获得当前线程对象， 则必须使用Thread.currentThread()方法。
     *
     * Runnable 接口中只包含一个抽象方法，从Java 8 开始， Runnable 接口使用了@FunctionalInterface 修饰。也就是说， Runnable 接口是函数式接口，可使用Lambda 表达
     * 式创建Runnable 对象。接下来介绍的Callable 接口也是函数式接口。
     *
     * 除此之外，上面程序中的粗体字代码创建了两个Thread对象，并调用start()方法来启动这两个线程。在FirstThread 和SecondThread 中创建线程对象的方式有所区别:
     * 前者直接创建的Thread 子类即可代表线程对象; 后者创建的Runnable 对象只能作为线程对象的target 。
     *
     * 两个子线程的 i 变量是连续的，也就是采用Runnable 接口的方式创建的多个线程可以共享线程类的实例变量。这是因为在这种方式下，程序所创建的Runnable 对象只是线程的target ，
     * 而多个线程可以共享同一个target ，所以多个线程可以共享同一个线程类(实际上应该是线程的target 类)的实例变量。
     */
}
