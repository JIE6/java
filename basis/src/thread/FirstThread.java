package thread;

/**
 * 线程的创建和启动 - 继承Thread 类创建线程类
 *
 * Java 使用Thread 类代表线程，所有的线程对象都必须是Thread 类或其子类的实例。每个线程的作用是完成一定的任务，
 * 实际上就是执行一段程序流( 一段顺序执行的代码) . Java 使用线程执行体来代表这段程序流。
 *
 * 通过继承Thread 类来创建井启动多线程的步骤如下。
 * 1.定义Thread 类的子类，并重写该类的run()方法，该run()方法的方法体就代表了线程需要完成的任务。因此把run()方法称为线程执行体。
 * 2.创建Thread 子类的实例，即创建了线程对象。
 * 3.调用线程对象的start()方法来启动该线程。
 *
 * 下面程序示范了通过继承Thread 类来创建并启动多线程。
 *
 * 通过继承Thread 类来创建线程类
 * @author JIE
 */
public class FirstThread extends Thread{

    private int i;

    /**
     * 重写run()方法， run()方法的方法体就是线程执行体
     */
    @Override
    public void run() {
       for (; i < 100; i++) {
           /*
            * 当线程类继承Thread 类时，直接使用this 即可获取当前线程
            * Thread 对象的qetName() 返回当前线程的名字
            * 因此可以直接调用qetName() 方法返回当前线程的名字
            */
           System.out.println(getName() + " " + i);
       }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // 调用Thread 的 currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName() + " " + i);
            if (i == 20) {
                // 创建并启动第一个线程
                new FirstThread().start();
                // 创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }

    /**
     * 上面程序中的FirstThread 类继承了Thread 类，并实现了run()方法，该run()方法里的代码执行流就是该线程所需要完成的任务。程序的主方法中也包含了一个循环，
     * 当循环变量 i 等于20 时创建并启动两个新线程。
     *
     * 虽然上面程序只显式地创建并启动了2 个线程，但实际上程序有3 个线程，即程序显式创建的2 个子线程和主线程。前面己经提到，当Java 程序开始运行后，程序至少会创建一个主线程，
     * 主线程的线程执行体不是由run()方法确定的，而是由main()方法确定的. main()方法的方法体代表主线程的线程执行体。
     *
     * 进行多线程编程时不要忘记了Java 程序运行时，默认的主线程， main()方法的方法体就是主线程的线程执行休。
     *
     * 除此之外，上面程序还用到了线程的如下两个方法。
     * Thread.currentThread(): currentThread()是Thread 类的静态方法，该方法总是返回当前正在执行的线程对象。
     * getName(): 该方法是Thread 类的实例方法，该方法返回调用该方法的线程名字。
     *
     * 程序可以通过setName(String name)方法为线程设直名字， 也可以通过getName()方法返回指定线程的名字。
     * 在默认情况下，主线程的名字为main, 用户启动的多个线程的名字依次为Thread-0 、Thread-1 、Thread-2 、...Thread-n 等。
     *
     * Thread-0 和Thread-1 两个线程输出的 i 变量不连续;
     * 注意: i 变量是FirstThread 的实例变量，而不是局部变量，但因为程序每次创建线程对象时都需要创建一个FirstThread 对象，
     * 所以Thread-0 和Thread-1 不能共享该实例变量。
     *
     * 使用继承Thread 类的方法来创建线程类时，多个线程之间无法共享线程类的实例变量。
     */
}
