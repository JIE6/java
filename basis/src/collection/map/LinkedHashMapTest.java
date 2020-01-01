package collection.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap 实现类
 *
 * HashSet 有一个LinkedHashSet 子类， HashMap 也有一个LinkedHashMap 子类; LinkedHashMap 也使用双向链表来维护key-value 对的次序(其实只需要考虑、key 的次序) ，
 * 该链表负责维护Map 的迭代顺序，迭代顺序与key-value 对的插入顺序保持一致。
 *
 * LinkedHashMap 可以避免对HashMap 、Hashtable 里的key-value 对进行排序(只要插入key-value对时保持顺序即可)，同时又可避免使用TreeMap 所增加的成本。
 *
 * LinkedHashMap 需要维护元素的插入顺序，因此性能略低于HashMap 的性能;但因为它以链表来维护内部顺序，所以在迭代访问Map 里的全部元素时将有较好的性能。
 * 下面程序示范了LinkedHashMap的功能:迭代输出LinkedHashMap 的元素时，将会按添加key-value 对的顺序输出。
 * @author JIE
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        LinkedHashMap scores = new LinkedHashMap();
        scores.put("语文", 80);
        scores.put("英语", 82);
        scores.put("数学", 76);
        // 调用forEach ()方法遍历scores 里的所有key-value 对
        scores.forEach((k, v) -> System.out.println(k + "->" + v ));
        // 上面程序中最后一行代码使用Java 8 为Map 新增的forEach()方法来遍历Map 集合。编译、运行上面程序，
        // 即可看到LinkedHashMap 的功能: LinkedHashMap 可以记住key-value 对的添加顺序。
    }
}
