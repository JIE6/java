package thread;

/**
 * 控制线程 - 改变线程优先级
 *
 * 每个线程执行时都具有一定的优先级，优先级高的线程获得较多的执行机会，而优先级低的线程则获得较少的执行机会。
 *
 * 每个线程默认的优先级都与创建它的父线程的优先级相同， 在默认情况下， main 线程具有普通优先级，由 main 线程创建的子线程也具有普通优先级。
 *
 * Thread 类提供了setPriority(int newPriority) 、getPriority()方法来设置和返回指定线程的优先级，其中setPriority()方法的参数可以是一个整数，
 * 范围是1 ~ 10 之间，也可以使用Thread 类的如下三个静态常量。
 * MAX_PRIORITY: 其值是10
 * MIN_PRIORITY: 其值是1
 * NORM_PRIORITY: 其值是5
 *
 * 下面程序使用了setPriority()方法来改变主线和的优先级，并使用该方法改变了两个线程的优先级，从而可以看到高优先级的线程将会获得更多的执行机会。
 * @author JIE
 */
public class PriorityTest extends Thread{

    /**
     * 定义一个有参数的构造器，用于创建线程时指定name
     * @param name
     */
    public PriorityTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(getName() + ", 优先级：" + getPriority() + ", " + i);
        }
    }

    public static void main(String[] args) {
        // 改变主线程的优先级
        Thread.currentThread().setPriority(6);
        for (int i = 0; i < 30; i++) {
            if (i == 10) {
                PriorityTest low = new PriorityTest("低级");
                low.start();
                System.out.println(low.getName() + ", 创建之初的优先级：" + low.getPriority());
                // 设置该线程为最低优先级
                low.setPriority(Thread.MIN_PRIORITY);
            }
            if (i == 20) {
                PriorityTest high = new PriorityTest("高级");
                high.start();
                System.out.println(high.getName() + ", 创建之初的优先级：" + high.getPriority());
                // 设置该线程为最高优先级
                high.setPriority(Thread.MAX_PRIORITY);
            }
        }
    }
    /**
     * 上面程序中代码改变了主线程的优先级为 6，这样由 main 线程所创建的子线程的优先级默认都是 6 ，所以程序直接输出low 、high两个线程的优先级时应该看到 6
     *
     * 接着程序将low线程的优先级设为 1 ，将high线程的优先级设置为 10.
     *
     * 值得指出的是， 虽然Java 提供了10 个优先级级别， 但这些优先级级别需要操作系统的支持。遗憾的是，不同操作系统上的优先级并不相同，
     * 而且也不能很好地和Java 的10 个优先级对应，例如Windows 2000 仅提供了7 个优先级。因此应该尽量避免直接为线程指定优先级，
     * 而应该使用NORM_PRIORITY, MIN_PRIORITY, MAX_PRIORITY 三个静态常量来设置优先级，这样才可以保证程序具有最好的可移植性。
     */
}
