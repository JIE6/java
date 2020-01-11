package thread;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * 控制线程 - 线程睡眠: sleep
 *
 * 如果需要让当前正在执行的线程暂停一段时间，并进入阻塞状态，则可以通过调用Thread 类的静态sleep()方法来实现。
 * sleep()方法有两种重载形式。
 * static void sleep(long millis): 让当前正在执行的线程暂停millis 毫秒，并进入阻塞状态，该方法受到系统计时器和线程调度器的精度与准确度的影响。
 * static void sleep(long millis, int nanos): 让当前正在执行的线程暂停millis 毫秒加nanos 毫微秒，并进入阻塞状态，该方法受到系统计时器和线程调度器的精度与准确度的影响。
 * 与前面类似的是，程序很少调用第二种形式的sleep()方法。
 *
 * 当当前线程调用sleep()方法进入阻塞状态后，在其睡眠时间段内，该线程不会获得执行的机会，即使系统中没有其他可执行的线程，处于sleep() 中的线程也不会执行，
 * 因此sleep()方法常用来暂停程序的执行。
 *
 * 下面程序调用sleep()方法来暂停主线程的执行，因为该程序只有一个主线程，当主线程进入睡眠后，系统没有可执行的线程，所以可以看到程序在sleep()方法处暂停。
 * @author JIE
 */
public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            System.out.println("当前时间：" + LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
            // 调用sleep()方法让当前线程暂停 1s
            Thread.sleep(1000);
        }
    }
    /**
     * 上面程序中代码将当前执行的线程暂停 1 秒，运行上面程序，看到程序依次输出 10 条字符串，输出 2 条字符串之间的时间间隔为 1 秒
     *
     * 此外， Thread 还提供了一个与sleep()方法有点相似的yield()静态方法，它也可以让当前正在执行的线程暂停，但它不会阻塞该线程，
     * 它只是将该线程转入就绪状态。yield()只是让当前线程暂停一下，让系统的线程调度器重新调度一次， 完全可能的情况是:
     * 当某个线程调用了yield()方法暂停之后， 线程调度器又将其调度出来重新执行。
     *
     * 实际上， 当某个线程调用了yield()方法暂停之后，只有优先级与当前线程相同，或者优先级比当前线程更高的处于就绪状态的线程才会获得执行的机会。
     *
     * 关于sleep()方法和yield()方法的区别如下.
     * sleep()方法暂停当前线程后， 会给其他线程执行机会，不会理会其他线程的优先级:但yield()方法只会给优先级相同，或优先级更高的线程执行机会。
     * sleep()方法会将线程转入阻塞状态，直到经过阻塞时间才会转入就绪状态; 而yield()不会将线程转入阻塞状态，它只是强制当前线程进入就绪状态。
     * 因此完全有可能某个线程被yield()方法暂停之后， 立即再次获得处理器资源被执行。
     * sleep()方法声明抛出了InterruptedException 异常，所以调用sleep()方法时要么捕捉该异常， 要么显式声明抛出该异常; 而yield()方法则没有声明抛出任何异常。
     * sleep()方法比yield()方法有更好的可移植性，通常不建议使用yield()方法来控制并发线程的执行。
     */
}
