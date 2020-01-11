package thread;

/**
 * 线程组和
 *
 * Java 使用ThreadGroup 来表示线程组，它可以对一批线程进行分类管理， Java 允许程序直接对线程组进行控制。对线程组的控制相当于同时控制这批线程。
 * 用户创建的所有线程都属于指定线程组，如果程序没有显式指定线程属于哪个线程组，则该线程属于默认线程组。在默认情况下，子线程和创建它的父线程处于同一个线程组内，
 * 例如A 线程创建了B 线程，并且没有指定B 线程的线程组，则B 线程属于A 线程所在的线程组。
 *
 * 一旦某个线程加入了指定线程组之后，该线程将一直属于该线程组，直到该线程死亡，线程运行中途不能改变它所属的线程组。
 *
 * Thread 类提供了如下几个构造器来设置新创建的线程属于哪个线程组。
 * Thread(ThreadGroup group, Runnable target): 以target 的run()方法作为线程执行体创建新线程，属于group 线程组。
 * Thread(ThreadGroup group, Runnable target, String name): 以target 的run()方法作为线程执行体创建新线程， 该线程属于group 线程组， 且线程名为name 。
 * Thread(ThreadGroup group, String name): 创建新线程， 新线程名为name ，属于group 线程组。
 *
 * 因为中途不可改变线程所属的线程组，所以Thread 类没有提供setThreadGroup()方法来改变线程所属的线程组，但提供了一个getThreadGroup()方法来返回该线程所属的线程组，
 * getThreadGroup()方法的返回值是ThreadGroup 对象，表示一个线程组。ThreadGroup 类提供了如下两个简单的构造器来创建实例。
 * ThreadGroup(String name): 以指定的线程组名字来创建新的线程组。
 * ThreadGroup(ThreadGroup parent, String name) : 以指定的名字、指定的父线程组创建一个新线程组。
 * 上面两个构造器在创建线程组实例时都必须为其指定一个名字，也就是说，线程组总会具有一个字符串类型的名字，
 * 该名字可通过调用ThreadGroup 的getName()方法来获取，但不允许改变线程组的名字。
 *
 * ThreadGroup 类提供了如下几个常用的方法来操作整个线程组里的所有线程。
 * int activeCount(): 返回此线程组中活动线程的数目。
 * interrupt(): 中断此线程组中的所有线程。
 * isDaemon() : 判断该线程组是否是后台线程组。
 * setDaemon(boolean daemon) : 把该线程组设置成后台线程组。后台线程组具有一个特征, 当后台线程组的最后一个线程执行结束或最后一个线程被销毁后，后台线程组将自动销毁。
 * setMaxPriority(int pri): 设置线程组的最高优先级。
 *
 * 下面程序创建了几个线程，它们分别属于不同的线程组，程序还将一个线程组设置成后台线程组。
 * @author JIE
 */
public class MyThread extends Thread{

    /**
     * 提供指定线程名的构造器
     * @param name
     */
    public MyThread(String name) {
        super(name);
    }

    /**
     * 提供指定线程名、线程组的构造器
     * @param group
     * @param name
     */
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String[] args) {
        // 获取主线程所在的线程组，这是所有线程默认的线程组
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        System.out.println("主线程组的名字：" + mainGroup.getName());
        System.out.println("主线程组是否是后台线程组：" + mainGroup.isDaemon());

        new MyThread("主线程组的线程").start();

        ThreadGroup tg = new ThreadGroup("新线程组");
        tg.setDaemon(true);
        System.out.println("tg线程组是否是后台线程组：" + tg.isDaemon());

        new MyThread(tg, "tg组的甲线程").start();
        new MyThread(tg, "tg组的已线程").start();
    }
}
