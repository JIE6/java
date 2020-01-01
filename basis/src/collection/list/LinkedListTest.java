package collection.list;

import java.util.LinkedList;

/**
 * LinkedList 实现类
 *
 * LinkedList 类是List 接口的实现类, 这意味着它是一个List 集合，可以根据索引来随机访问集合中的元素。除此之外， LinkedList 还实现了Deque 接口，
 * 可以被当成双端队列来使用，因此既可以被当成"栈"来使用，也可以当成队列使用。下面程序简单示范了LinkedList 集合的用法。
 *
 * @author JIE
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList books = new LinkedList();
        // 将字符串元素加入队列的尾部
        books.offer("疯狂Java 讲义");
        // 将一个字符串元素加入栈的顶部
        books.push("轻量级Java EE 企业应用实战");
        // 将字符串元素添加到队列的头部(相当于栈的顶部〉
        books.offerFirst("疯狂Android 讲义");
        // 以List 的方式(按索引访问的方式〉来遍历集合元素
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        // 访问并不删除栈的元素
        System.out.println(books.peekFirst());
        // 访问并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        // 将栈顶的元素弹出"栈"
        System.out.println(books.pop());
        System.out.println(books);
        // 访问并删除队列的最后一个元素
        System.out.println(books.pollLast());
        System.out.println(books);

        /**
         * 面程序中粗体字代码分别示范了LinkedList 作为List 集合、双端队列、栈的用法。由此可见，LinkedList 是一个功能非常强大的集合类。
         *
         * LinkedList 与ArrayList 、ArrayDeque 的实现机制完全不同， ArrayList 、ArrayDeque 内部以数组的形式来保存集合中的元素， 因此随机访问集合元素时有较好的性能:
         * 而LinkedList 内部以链表的形式来保存集合中的元素，因此随机访问集合元素时性能较差，但在插入、删除元素时性能比较出色(只需改变指针所指的地址即可)。需要指出的是，
         * 虽然Vector 也是以数组的形式来存储集合元素的，但因为它实现了线程同步功能(而且实现机制也不好) ，所以各方面性能都比较差。
         *
         * 对于所有的内部基于数组的集合实现，例如ArrayList 、ArrayDeque 等，使用随机访问的性能比使用Iterator 迭代访问的性能要好，因为随机访问会被映射成对数组元素的访问。
         */
    }
}
