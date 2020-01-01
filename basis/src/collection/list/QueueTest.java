package collection.list;

import java.util.PriorityQueue;

/**
 * Queue 集合
 *
 * Queue 用于模拟队列这种数据结构，队列通常是指"先进先出" (FIFO) 的容器。队列的头部保存在队列中存放时间最长的元素， 队列的尾部保存在队列中存放时间最短的元素。
 * 新元素插入( offer ) 到队列的尾部，访问元素( poll ) 操作会返回队列头部的元素。通常， 队列不允许随机访问队列中的元素。
 *
 * Queue 接口中定义了如下几个方法。
 * void add(Object e): 将指定元素加入此队列的尾部。
 * Object element(): 获取队列头部的元素， 但是不删除该元素。
 * boolean offer(Object e) : 将指定元素加入此队列的尾部。当使用有容量限制的队列时，此方法通常比add(Object e)方法更好。
 * Object peek() : 获取队列头部的元素， 但是不删除该元素。如果此队列为空，则返回null 。
 * Object poll(): 获取队列头部的元素， 并删除该元素。如果此队列为空， 则返回null 。
 * Object remove() : 获取队列头部的元素， 并删除该元素。
 *
 * Queue 接口有一个PriorityQueue 实现类。除此之外， Queue 还有一个Deque 接口， Deque 代表一个"双端队列"，双端队列可以同时从两端来添加、删除元素，
 * 因此Deque 的实现类既可当成队列使用，也可当成栈使用。Java 为Deque 提供了ArrayDeque 和LinkedList 两个实现类。
 *
 *
 * PriorityQueue 实现类
 *
 * PriorityQueue 是一个比较标准的队列实现类。之所以说它是比较标准的队列实现， 而不是绝对标准的队列实现， 是因为PriorityQueue 保存队列元素的顺序并不是按加入队列的顺序，
 * 而是按队列元素的大小进行重新排序。因此当调用peek()方法或者poll()方法取出队列中的元素时，并不是取出最先进入队列的元素， 而是取出队列中最小的元素。从这个意义上来看，
 * PriorityQueue 己经违反了队列的最基本规则: 先进先出C FIFO ) 。
 * 下面程序示范了PriorityQueue 队列的用法。
 *
 * @author JIE
 */
public class QueueTest {

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        // 下面代码依次向pq 中加入四个元素
        pq.offer(6);
        pq.offer(-3);
        pq.offer(20);
        pq.offer(18);
        // 输出pq 队列，并不是按元素的加入顺序排列
        System.out.println(pq);
        // 访问队列的第一个元素， 其实就是队列中最小的元素: -3
        System.out.println(pq.poll());

        /**
         * 运行上面程序直接输出PriorityQueue 集合时， 可能看到该队列里的元素并没有很好地按大小进行排序，但这只是受到PriorityQueue 的toString()方法的返回值的影响。
         * 实际上， 程序多次调用PriorityQueue集合对象的poll()方法，即可看到元素按从小到人的顺序"移出队列"。
         *
         * PriorityQueue 不允许插入null 元素，它还需要对队列元素进行排序， PriorityQueue 的元素有两种排序方式。
         * 1.自然排序: 采用自然顺序的PriorityQueue 集合中的元素必须实现了Comparable 接口，而且应该是同一个类的多个实例， 否则可能导致ClassCastException 异常。
         * 2.定制排序: 创建PriorityQueue 队列时， 传入一个Comparator 对象， 该对象负责对队列中的所有元素进行排序。采用定制排序时不要求队列元素实现Comparable 接口。
         *
         * PriorityQueue 队列对元素的要求与TreeSet 对元素的要求基本一致，因此关于使用自然排序和定制排序的详细介绍请参考TreeSetTest
         *
         */
    }

}
