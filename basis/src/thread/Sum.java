package thread;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Java8 增强的ForkJoinPool - 有返回值
 * @author JIE
 */
public class Sum {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[100];
        int total = 0;
        Random rand = new Random();
        // 初始化100 个数字元素
        for (int i = 0; i < arr.length; i++) {
            int tmp = rand.nextInt(20) ;
            // 对数组元素赋值，并将数组元素的值添加到sum 总和中
            total += (arr[i] = tmp);
        }
        System.out.println(total);

        // 创建一个通用池
        ForkJoinPool pool = ForkJoinPool.commonPool();
        // 提交可分解的CalTask 任务
        ForkJoinTask<Integer> future = pool.submit(new CalTask(arr, 0, arr.length));
        System.out.println(future.get());
        // 关闭线程池
        pool.shutdown();
    }
    /**
     * 运行上面程序，将可以看到程序通过CalTask 计算出来的总和，与初始化数组元素时统计出来的总和总是相等，这表明程序一切正常。
     */
}
