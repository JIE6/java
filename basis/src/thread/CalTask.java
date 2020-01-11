package thread;

import java.util.concurrent.RecursiveTask;

/**
 * Java8 增强的ForkJoinPool - 有返回值
 *
 * 下面程序示范了使用 Recursive Task 对一个长度为100 的数组的元素值进行累加。
 * 继承RecursiveTask 来实现"可分解"的任务
 * @author JIE
 */
public class CalTask extends RecursiveTask<Integer> {

    /**
     * 每个"小任务"最多只累加20 个数
     */
    private static final int THRESHOLD = 20 ;
    private int[] arr;
    private int start;
    private int end;

    /**
     * 累加从start 到end 的数组元素
     * @param arr
     * @param start
     * @param end
     */
    public CalTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0 ;
        // //当end 与start 之间的差小于THRESHOLD 时，开始进行实际累加
        if (end - start < THRESHOLD) {
            for (int i = start; i < end; i++) {
                sum += arr[i];
            }
            return sum;
        }else {
            // 当end 与start 之间的差大于THRESHOLD ，即要累加的数超过20 个时, 将大任务分解成两个"小任务"
            int middle = (start + end) / 2;
            CalTask left = new CalTask(arr, start, middle);
            CalTask right = new CalTask(arr, middle, end);
            // 并行执行两个"小任务"
            left.fork();
            right.fork();
            // 把两个"小任务"累加的结果合并起来
            return left.join() + right.join();
        }
    }
}
