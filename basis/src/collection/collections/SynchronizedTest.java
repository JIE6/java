package collection.collections;

import java.util.*;

/**
 * 同步控制
 *
 * Collections 类中提供了多个synchronizedXxx()方法，该方法可以将指定集合包装成线程同步的集合，从而可以解决多线程并发访问集合时的线程安全问题。
 *
 * Java 中常用的集合框架中的实现类HashSet 、TreeSet 、ArrayList 、ArrayDeque 、LinkedList 、HashMap和TreeMap 都是线程不安全的。
 * 如果有多个线程访问它们，而且有超过一个的线程试图修改它们，则存在线程安全的问题。Collections 提供了多个类方法可以把它们包装成线程同步的集合。
 *
 * 下面的示例程序创建了4 个线程安全的集合对象。
 * @author JIE
 */
public class SynchronizedTest {

    public static void main(String[] args) {
        // 下面程序创建了4 个线程安全的集合对象
        Collection<Object> collection = Collections.synchronizedCollection(new ArrayList<>());
        List<Object> list = Collections.synchronizedList(new ArrayList<>());
        Set<Object> set = Collections.synchronizedSet(new HashSet<>());
        Map<Object, Object> map = Collections.synchronizedMap(new HashMap<>());
        /**
         * 在上面示例程序中，直接将新创建的集合对象传给了Collections 的synchronizedXxx 方法， 这样就可以直接获取List 、Set 和Map 的线程安全实现版本。
         */
    }
}
