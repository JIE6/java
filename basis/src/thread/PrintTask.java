package thread;

import java.util.concurrent.RecursiveAction;

/**
 * Java8 增强的ForkJoinPool - 无返回值
 *
 * 现在计算机大多己向多CPU 方向发展，即使普通PC ，甚至小型智能设备(如手机)、多核处理器也己被广泛应用。在未来的日子里，处理器的核心数将会发展到更多。
 * 虽然硬件上的多核CPU 己经十分成熟，但很多应用程序并未为这种多核CPU 做好准备，因此并不能很好地利用多核CPU 的性能优势。
 * 为了充分利用多CPU、多核CPU 的性能优势，计算机软件系统应该可以充分"挖掘"每个CPU的计算能力，绝不能让某个CPU 处于"空闲"状态。为了充分利用多CPU 、多核CPU 的优势，
 * 可以考虑把一个任务拆分成多个" 小任务"，把多个"小任务"放到多个处理器核心上并行执行;当多个"小任务"执行完成之后，再将这些执行结果合并起来即可。
 *
 * Java 7 提供了ForkJoinPool 来支持将一个任务拆分成多个"小任务"并行计算，再把多个"小任务"的结果合并成总的计算结果。ForkJoinPool 是ExecutorService 的实现类，
 * 因此是一种特殊的线程池。ForkJoinPool 提供了如下两个常用的构造器。
 * ForkJoinPool(int parallelism): 创建一个包含parallelism 个并行线程的ForkJoinPool 。
 * ForkJoinPool(): 以Runtime.availableProcessors()方法的返回值作为parallelism 参数来创建ForkJoinPool。
 *
 * Java 8 进一步扩展了ForkJoinPool 的功能， Java 8 为ForkJoinPool 增加了通用池功能。ForkJoinPool类通过如下两个静态方法提供通用池功能。
 * ForkJoinPool commonPool(): 该方法返回一个通用池，通用池的运行状态不会受shutdown()或shutdownNow()方法的影响。
 * 当然，如果程序直接执行System.exit(O);来终止虚拟机，通用池以及通用池中正在执行的任务都会被自动终止。
 * int getCommonPoolParallelism(): 该方法返回通用池的并行级别。
 *
 * 创建了ForkJoinPool 实例之后，就可调用ForkJoinPool 的submit(ForkJoinTask task) 或invoke(ForkJoinTask task) 方法来执行指定任务了。
 * 其中ForkJoinTask 代表一个可以并行、合并的任务。ForkJoinTask 是一个抽象类，它还有两个抽象子类: RecursiveAction 和RecursiveTask 。
 * 其中RecursiveTask代表有返回值的任务，而RecursiveAction 代表没有返回值的任务。
 *
 * 下面以执行没有返回值的"大任务" (简单地打印0~300 的数值)为例，程序将一个"大任务"拆分成多个"小任务"，并将任务交给ForkJoinPool 来执行。
 *
 *
 * 继承RecursiveAction来实现"可分解" 的任务
 * @author JIE
 */
public class PrintTask extends RecursiveAction {

    /**
     * 每个"小任务"最多只打印50 个数
     */
    public static final int THRESHOLD = 50;
    private int start;
    private int end;

    /**
     * 打印从start ~ end 的任务
     * @param start
     * @param end
     */
    public PrintTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        // 当end 与start 之间的差小于 THRESHOLD 时， 开始打印
        if ((end - start) < THRESHOLD) {
            for (int i = start; i < end; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        }else {
            // 当end 与start 之间的差大于THRESHOLD ，即要打印的数超过50 个时, 将大任务分解成两个"小任务"
            int middle = (start + end) / 2;
            PrintTask left = new PrintTask(start, middle);
            PrintTask right = new PrintTask(middle, end);
            // 并行执行两个"小任务"
            left.fork();
            right.fork();
        }
    }
}
