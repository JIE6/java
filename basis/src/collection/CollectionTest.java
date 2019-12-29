package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Collection 介绍
 *
 * Collection 接口是List、Set 和Queue 接口的父接口， 该接口里定义的方法既可用于操作Set 集合，
 * 也可用于操作List 和Queue 集合。Collection 接口里定义了如下操作集合元素的方法。
 *
 * boolean add(Object o) : 该方法用于向集合里添加一个元素。如果集合对象被添加操作改变了，则返回true 。
 * boolean addAll(Collection c) : 该方法把集合c 里的所有元素添加到指定集合里。如果集合对象被添加操作改变了， 则返回true 。
 * void clear() : 清除集合里的所有元素，将集合长度变为0
 * boolean contains(Object o): 返回集合里是否包含指定元素。
 * boolean containsAll(Collection c): 返回集合里是否包含集合c 里的所有元素。
 * boolean isEmpty(): 返回集合是否为空。当集合长度为0 时返回true ，否则返回false 。
 * Iterator iterator(): 返回一个Iterator 对象，用于遍历集合里的元素。
 * boolean remove(Object o): 删除集合中的指定元素o，当集合中包含了一个或多个元素o时， 该方法只删除第一个符合条件的元素， 该方法将返回true 。
 * boolean removeAll(Collection c): 从集合中删除集合c 里包含的所有元素( 相当于用调用该方法的集合减集合c) ，如果删除了一个或一个以上的元素，则该方法返回true 。
 * boolean retainAll(Collection c): 从集合中删除集合c 里不包含的元素(相当于把调用该方法的集合变成该集合和集合c 的交集) ，如果该操作改变了调用该方法的集合，则该方法返回true 。
 * int size(): 该方法返回集合里元素的个数。
 * Object[] toArray(): 该方法把集合转换成一个数组，所有的集合元素变成对应的数组元素。
 * @author JIE
 */
public class CollectionTest {

    public static void main(String[] args) {
        Collection c = new ArrayList();
        // 添加元素
        c.add("孙悟空");
        // 虽然集合里不能放基本类型的值，但J ava 支持自动装箱
        c.add(6);
        System.out.println("c 集合的元素个数为: " + c.size());
        // 删除指定元素
        c.remove(6);
        System.out.println("c 集合的元素个数为: " + c.size());
        // 判断是否包含指定字符串
        System.out.println("c 集合是否包含 \"孙悟空\" 字符串：" + c.contains("孙悟空"));
        c.add("轻量级Java EE 企业应用实战");
        System.out.println("c 集合的元素: " + c) ;
        Collection books = new HashSet();
        books.add("轻量级Java EE 企业应用实战");
        books.add("疯狂Java 讲义");
        System.out.println("c 集合是否完全包含books 集合? " + c.containsAll(books));
        // 用c 集合减去books 集合里的元素
        c.removeAll(books);
        System.out.println("c 集合的元素: " + c) ;
        // 删除c 集合里的所有元素
        c.clear();
        System.out.println("c 集合的元素: " + c) ;
        // 控制books 集合里只剩下c 集合里也包含的元素
        books.retainAll(c);
        System.out.println("books 集合的元素: " + books) ;

        /**
         * 上面程序中创建了两个Collection 对象， 一个是c 集合， 一个是books 集合， 其中c 集合是ArrayList而books 集合是HashSet。
         * 虽然它们使用的实现类不同，但当把它们当成Collection 来使用时，使用add, remove 、clear 等方法来操作集合元素时没有任何区别。
         *
         * 把运行结果和代码结合在一起看，可以看出Collection 的用法有:添加元素、删除元素、返回Collection 集合的元素个数以及清空整个集合等
         *
         * 当使用System.out 的println()方法来输出集合对象时，将输出[ele1 ， e le2 ，... ] 的形式，这显然是因为所有的Collection 实现类都重写了toString()方法，
         * 该方法可以一次性地输出集合中的所有元素。
         *
         * 如果想依次访问集合里的每一个元素，则需要使用某种方式来遍历集合元素，CollectionTraversalTest 介绍遍历集合元素的多种方法。
         */
    }
}
