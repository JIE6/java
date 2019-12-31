package collection.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet 类
 *
 * HashSet 还有一个子类LinkedHashSet ， LinkedHashSet集合也是根据元素的hashCode 值来决定元素的存储位置，但它同时使用链表维护元素的次序，
 * 这样使得元素看起来是以插入的顺序保存的。也就是说，当遍历LinkedHashSet 集合里的元素时，LinkedHashSet 将会按元素的添加顺序来访问集合里的元素。
 *
 * LinkedHashSet 需要维护元素的插入顺序，因此性能略低于HashSet 的性能，但在迭代访问Set 里的全部元素时将有很好的性能，因为它以链表来维护内部顺序。
 * @author JIE
 */
public class LinkedHashSetTest {

    public static void main(String[] args) {
        LinkedHashSet books = new LinkedHashSet();
        books.add("疯狂Java 讲义");
        books.add("轻量级Java EE 企业应用实战");
        System.out.println(books);
        // 疯狂Java 讲义
        books.remove("疯狂Java 讲义");
        // 重新添加 疯狂Java 讲义
        books.add("疯狂Java 讲义");
        System.out.println(books);

        /**
         * 输出LinkedHashSet 集合的元素时， 元素的顺序总是与添加顺序一致
         *
         * 虽然LinkedHashSet 使用了链表记录集合元素的添加顺序，但LinkedHashSet 依然是HashSet ，因此它依然不九许集合元素重复
         */
    }
}
