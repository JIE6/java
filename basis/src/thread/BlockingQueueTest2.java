package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 线程通信 - 使用阻塞队列(BlockingQueue) 控制线程通信
 * @author JIE
 */
public class BlockingQueueTest2 {

    public static void main(String[] args) {
        // 创建一个容量为 1 的BlockingQueue
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        // 启动3 个生产者线程
        new Producer(bq).start();
        new Producer(bq).start();
        new Producer(bq).start();
        // 启动一个消费者线程
        new Consumer(bq).start();
    }
    /**
     * 上面程序启动了3 个生产者线程向BlockingQueue 集合放入元素，启动了 1 个消费者线程从BlockingQueue 集合取出元素。
     * 本程序的BlockingQueue 集合容量为1，因此3 个生产者线程无法连续放入元素，必须等待消费者线程取出一个元素后， 3 个生产者线程的其中之一才能放入一个元素。
     * 运行该程序，会看到如下所示的结果。
     *
     * Thread-2生产完成：[Struts]
     * Thread-2生产者准备生产集合元素!
     * Thread-3消费者准备消费集合元素!
     * Thread-2生产完成：[Spring]
     * Thread-3消费完成:[Spring]
     * Thread-2生产者准备生产集合元素!
     * Thread-3消费者准备消费集合元素!
     * Thread-2生产完成：[Java]
     * Thread-3消费完成:[Java]
     * Thread-3消费者准备消费集合元素!
     * Thread-2生产者准备生产集合元素!
     * ......................
     */
}
