package thread;

/**
 * 控制线程 - join 线程
 *
 * Java 的线程支持提供了一些便捷的工具方法， 通过这些便捷的工具方法可以很好地控制线程的执行。
 *
 * join 线程
 * Thread 提供了让一个线程等待另一个线程完成的方法， join()方法。当在某个程序执行流中调用其他线程的join()方法时，
 * 调用线程将被阻塞， 直到被join()方法加入的Join 线程执行完为止。
 * join()方法通常由使用线程的程序调用，以将大问题划分成许多小问题，每个小问题分配一个线程。当所有的小问题都得到处理后，再调用主线程来进一步操作。
 *
 * @author JIE
 */
public class JoinThread extends Thread{

    /**
     * 提供一个有参数的构造器，用于设置该线程的名字
     * @param name
     */
    public JoinThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动子线程
        new JoinThread("新线程").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("被Join 的线程");
                jt.start();
                // main 线程调用了jt 线程的join ()方法, main 线程必须等 jt 执行结束才会向下执行
                jt.join();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    /**
     * 上面程序中一共有 3 个线程，主方法开始时就启动了名为"新线程" 的子线程， 该子线程将会和main 线程并发执行。
     * 当主线程的循环变量 i 等于20 时， 启动了名为"被Join 的线程"的线程， 该线程不会和 main 线程并发执行.
     * main 线程必须等该线程执行结束后才可以向下执行。在名为"被Join 的线程" 的线程执行时，实际上只有2 个子线程并发执行，
     * 而主线程处于等待状态。
     *
     * join()方法有如下三种重载形式。
     * join(): 等待被Join 的线程执行完成。
     * join(long millis): 等待被Jom 的线程的时间最长为millis 毫秒。如果在millis 毫秒内被Join 的线程还没有执行结束，则不再等待。
     * join(long millis, int nanos): 等待被Join 的线程的时间最长为millis 毫秒加nanos 毫微秒。
     *
     * 通常很少使用第三种形式，原因有两个:程序对时间的精度无需精确到毫微秒；计算机硬件，操作系统本身也无法精确到毫微秒
     */
}
