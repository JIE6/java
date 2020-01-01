package collection.list;

import java.util.ArrayDeque;

/**
 * Deque 接口
 *
 * Deque 接口是Queue 接口的子接口， 它代表一个双端队列， Deque 接口里定义了一些双端队列的方法，这些方法允许从两端来操作队列的元素。
 * void addFirst(Object e): 将指定元素插入该双端队列的开头。
 * void addLast(Object e): 将指定元素插入该双端队列的末尾。
 * Iterator descendingIterator(): 返回该双端队列对应的迭代器，该法代器将以逆向顺序来迭代队列中的元素。
 * Object getFirst(): 获取但不删除双端队列的第一个元素。
 * Object getLast(): 获取但不删除双端队列的最后一个元素。
 * boolean offerFirst(Object e): 将指定元素插入该双端队列的开头。
 * boolean offerLast(Object e): 将指定元素插入该双端队列的末尾。
 * Object peekFirst(): 获取但不删除该双端队列的第一个元素:如果此双端队列为空， 则返回null 。
 * Object peekLast(): 获取但不删除该双端队列的最后一个元素:如果此双端队列为空，则返回null 。
 * Object pollFirst(): 获取并删除该双端队列的第一个元素;如果此双端队列为空，则返回null 。
 * Object pollLast(): 获取并删除该双端队列的最后一个元素;如果此双端队列为空， 则返回null 。
 * Object pop() (栈方法) : pop 出该双端队列所表示的栈的栈顶元素。相当于removeFirst() 。
 * void push(Object e) (栈方法) : 将一个元素push 进该双端队列所表示的栈的栈顶。相当于addFirst( e) 。
 * Object removeFirst(): 获取并删除该双端队列的第一个元素。
 * Object removeFirstOccurrence(Object o): 删除该双端队列的第一次出现的元素o。
 * Object removeLast(): 获取并删除该双端队列的最后一个元素。
 * boolean removeLastOccurrence(Object o): 删除该双端队列的最后一次出现的元素o。
 *
 * 从上面方法中可以看出， Deque 不仅可以当成双端队列使用，而且可以被当成栈来使用，因为该类里还包含了pop ( 出栈)、push (入栈)两个方法。
 *
 *
 *
 * ArrayDeque 实现类
 *
 * Deque 接口提供了一个典型的实现类: ArrayDeque ，从该名称就可以看出，它是一个基于数组实现的双端队列，创建Deque 时同样可指定一个numElements 参数，
 * 该参数用于指定Object[]数组的长度;如果不指定numElements 参数， Deque 底层数组的长度为16 。
 *
 * ArrayList 和ArrayDeque 两个集合类的实现机制基本相似，它们的底层都采用一个动的、可重分配的Object[]数纽来存储集合元素，当集合元素超出了该款组的容量时，
 * 系统会在底层重新分配一个Object[]数组来存储集合元素。
 *
 * 下面程序示范了把ArrayDeque 当成"找"来使用。
 * @author JIE
 */
public class DequeTest {

    public static void main(String[] args) {
        ArrayDeque stack = new ArrayDeque();
        // 依次将三个元素push 入"栈"
        stack.push("疯狂Java 讲义");
        stack.push("轻量级Java EE 企业应用实战");
        stack.push("疯狂Android 讲义");
        System.out.println(stack);
        // 访问第一个元素， 但并不将其pop 出"栈"，输出:疯狂Android 讲义
        System.out.println(stack.peek());
        System.out.println(stack);
        // pop 出第一个元素，输出: 疯狂Android 讲义
        System.out.println(stack.pop());
        System.out.println(stack);

        /**
         * 上面程序的运行结果显示了ArrayDeque 作为栈的行为， 因此当程序中需要使用"栈"这种数据结构时，推荐使用ArrayDeque， 尽量避免使用Stack,
         * 因为Stack 是古老的集合，性能较差。
         *
         * 当然ArrayDeque 也可以当成队列使用，此处ArrayDeque 将按"先进先出"的方式操作集合元素。
         * 例如如下程序。
         */
        ArrayDeque queue = new ArrayDeque();
        // 依次将三个元素加入队列
        queue.offer("疯狂Java 讲义");
        queue.offer("轻量级Java EE 企业应用实战");
        queue.offer("疯狂Android 讲义");
        System.out.println(queue);
        // 访问队列头部的元素，但并不将其poll 出队列"栈"， 输出:疯狂Java 讲义
        System.out.println(queue.peek());
        System.out.println(queue);
        // poll 出第一个元素，输出:疯狂Java 讲义
        System.out.println(queue.poll());
        System.out.println(queue);
        /**
         * 上面程序的运行结果显示了ArrayDeque 作为队列的行为。
         * 通过上面两个程序可以看出， ArrayDeque 不仅可以作为枝使用，也可以作为队列使用。
         *
         * 栈：后进先出
         * 队列: 先进先出
         */
    }
}
