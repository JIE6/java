package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 线程通信 - 使用阻塞队列(BlockingQueue) 控制线程通信
 *
 * Java 5 提供了一个BlockingQueue 接口，虽然BlockingQueue 也是Queue 的子接口，但它的主要用途并不是作为容器，
 * 而是作为线程同步的工具。BlockingQueue 具有一个特征: 当生产者线程试图向BlockingQueue 中放入元素时，
 * 如果该队列己满，则该线程被阻塞;当消费者线程试图从BlockingQueue中取出元素时，如果该队列己空， 则该线程被阻塞。
 *
 * 程序的两个线程通过交替向BlockingQueue 中放入元素、取出元素，即可很好地控制线程的通信。
 *
 * BlockingQueue 提供如下两个支持阻塞的方法。
 * put(E e): 尝试把E 元素放入BlockingQueue 中，如果该队列的元素己满，则阻塞该线程。
 * take(): 尝试从BlockingQueue 的头部取出元素，如果该队列的元素己空， 则阻塞该线程。
 *
 * BlockingQueue 继承了Queue 接口，当然也可使用Queue 接口中的方法。这些方法归纳起来可分为如下三组。
 * 在队列尾部插入元素。包括add(E e) 、offer(E e)和put(E e)方法，当该队列己满时，这三个方法分别会抛出异常、返回false 、阻塞队列。
 * 在队列头部删除并返回删除的元素。包括remove() 、poll()和take()方法。当该队列己空时，这三个方法分别会抛出异常、返回false、阻塞队列。
 * 在队列头部取出但不删除元素。包括element()和peek()方法，当队列己空时，这两个方法分别抛出异常、返回false.
 *
 * BlockingQueue包含如下5 个实现类。
 * ArrayBlockingQueue: 基于数组实现的BlockingQueue 队列。
 * LinkedBlockingQueue: 基于链表实现的BlockingQueue 队列。
 * PriorityBlockingQueue: 它并不是标准的阻塞队列。与前面介绍的PriorityQueue 类似，该队列调用remove() 、poll() 、take()等方法取出元素时，
 * 并不是取出队列中存在时间最长的元素，而是队列中最小的元素。PriorityBlockingQueue 判断元素的大小即可根据元素(实现Comparable 接口)的本身大小来自然排序，
 * 也可使用Comparator 进行定制排序。
 * SynchronousQueue: 同步队列。对该队列的存、取操作必须交替进行。
 * DelayQueue: 它是一个特殊的BlockingQueue ，底层基于PriorityBlockingQueue 实现。不过，DelayQueue 要求集合元素都实现Delay 接口(该接口里只有一个long getDelay() 方法) ,
 * DelayQueue 根据集合元素的getDalay()方法的返回值进行排序。
 *
 * 下面以ArrayBlockingQueue 为例介绍阻塞队列的功能和用法。下面先用一个最简单的程序来测试BlockingQueue 的put()方法。
 *
 * @author JIE
 */
public class BlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
        // 定义一个长度为2 的阻塞队列
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(2);
        // 与bq.add("java"); 、bq.offer("java"); 相同
        bq.put("java");
        System.out.println(bq);
        bq.put("java");
        System.out.println(bq);
        // 阻塞线程
        bq.put("java");
        System.out.println(bq);
    }
    /**
     * 上面程序先定义一个大小为2 的B lockingQueue ， 程序先向该队列中放入两个元素，此时队列还没有满，两个元素都可以放入，
     * 因此使用put() 、add() 和 offer()方法效果完全一样。当程序试图放入第三个元素时，如果使用put()方法尝试放入元素将会阻塞线程，
     * 如果使用add()方法尝试放入元素将会引发异常;如果使用offer()方法尝试放入元素则会返回false ，元素不会被放入
     *
     * 与此类似的是，在BlockingQueue 己空的情况下， 程序使用take()方法尝试取出元素将会阻塞线程:使用remove()方法尝试取出元素将引发异常:
     * 使用poll()方法尝试取出元素将返回false ，元素不会被删除。
     *
     * 掌握了BlockingQueue 阻塞队列的特性之后，程序就可以利用BlockingQueue 来实现线程通信了，详情见 Producer
     */
}
