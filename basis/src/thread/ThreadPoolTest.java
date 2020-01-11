package thread;

import java.util.concurrent.*;

/**
 * 线程池
 * 下面程序使用线程池来执行指定Runnable 对象所代表的任务。
 * @author JIE
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        // 创建一个具有固定线程数(6) 的线程池
        ExecutorService pool = Executors.newFixedThreadPool(6);
        // 使用Lambda 表达式创建Runnable 对象
        Runnable target = (() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });
        // 向线程池中提交三个线程
        pool.submit(target);
        pool.submit(target);
        pool.submit(target);
        // 关闭线程池
        pool.shutdown();
    }
}
