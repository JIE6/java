package thread;

/**
 * 控制线程 - 后台线程
 *
 * 有一种线程. 它是在后台运行的，它的任务是为其他的线程提供服务， 这种线程被称为"后台线程( Daemon Thread )" ，
 * 又称为"守护线程"或"精灵线程"。 JVM 的垃圾回收线程就是典型的后台线程。
 *
 * 后台线程有个特征: 如果所有的前台线程都死亡， 后台线程会自动死亡。
 *
 * 调用Thread 对象的setDaemon(true)方法可将指定线程设置成后台线程。下面程序将执行线程设置成后台线程，
 * 可以看到当所有的前台线程死亡时，后台线程随之死亡。
 *
 * 当整个虚拟机中只剩下后台线程时， 程序就没有继续运行的必要了，所以虚拟机也就退出了。
 *
 * @author JIE
 */
public class DaemonThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        DaemonThread t = new DaemonThread();
        // 将此线程设置成后台线程
        t.setDaemon(true);
        // 启动后台线程
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        // 程序执行到此处，前台线程 (main 线程)结束, 后台线程也应该随之结束
    }
    /**
     * 上面程序中代码先将 t 线程设置成后台线程，然后启动该线程，本来该线程应该执行到 i 等于999 时才会结束，
     * 但运行程序时不难发现该后台线程无法运行到999 ，因为当主线程也就是程序中唯一的前台线程运行结束后，
     * JVM 会主动退出，因而后台线程也就被结束了。
     *
     * Thread 类还提供了一个isDaemon()方法，用于判断指定线程是否为后台线程。
     *
     * 从上面程序可以看出，主线程默认是前台线程， t 线程默认也是前台线程。并不是所有的线程默认都是前台线程，有些线程默认就是后台线程,
     * 前台线程创建的子线程默认是前台线程，
     * 后台线程创建的子线程默认是后台线程。
     */
}
