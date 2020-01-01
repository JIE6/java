package collection.map;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

/**
 * Java 8 改进的HashMap 和Hashtable 实现类
 *
 * HashMap 和Hashtable 都是Map 接口的典型实现类，它们之间的关系完全类似于ArrayList 和Vector的关系: Hashtable 是一个古老的Map 实现类，
 * 它从JDK 1. 0 起就己经出现了，当它出现时， Java 还没有提供Map 接口，所以它包含了两个烦琐的方法，即elements() (类似于Map 接口定义的values()方法)
 * 和keys() (类似于Map 接口定义的keySet()方法) ，现在很少使用这两个方法(关于这两个方法的用法请参考后面)。
 *
 * Java 8 改进了HashMap 的实现，使用HashMap 存在key 冲突时依然具有较好的性能。
 * 除此之外， Hashtable 和HashMap 存在两点典型区别。
 *
 * Hashtable 是一个线程安全的Map 实现，但HashMap 是线程不安全的实现，所以HashMap 比Hashtable 的性能高一点;但如果有多个线程访问同一个Map 对象时，
 * 使用Hashtable 实现类会更好。
 *
 * Hashtable 不允许使用null 作为key 和value ， 如果试图把null 值放进Hashtable 中，将会引发NullPointerException 异常; 但HashMap 可以使用null 作为key 或value 。
 *
 * 由于HashMap 里的key 不能重复，所以HashMap 里最多只有一个key-value 对的key 为null ，但可以有无数多个key-value 对的value 为null 。
 * 下面程序示范了用null 值作为HashMap 的key 和value 的情形。
 *
 * @author JIE
 */
public class HashMapAndHashtableTest {

    public static void main(String[] args) {
        HashMap hm = new HashMap();
        // 试图将两个key 为null 值的key - value 对放入HashMap 中
        hm.put(null, null);
        hm.put(null, null);
        // 将一个value 为null 值的key-value 对放入HashMap 中
        hm.put("a", null);
        // 输出Map 对象
        System.out.println(hm);
        // 面程序试图向HashMap 中放入三个key-value 对，因为Map 中已经有一个key-value 对的key 为null 值，所以无法再放入key 为null 值的key-value 对

        /**
         * 从Hashtable 的类名上就可以看出它是一个古老的类，它的命名甚至没有遵守Java 的命名规范:每个单词的首字母都应该大写。也许当初开发Hashtable 的工程师也没有注意到这一点，
         * 后来大量Java 程序中使用了Hashtable 类，所以这个类名也就不能改为HashTable 了，否则将导致大量程序需要改写。与Vector 类似的是，尽量少用Hashtable实现类，
         * 即使需要创建线程安全的Map 实现类，也无须使用Hashtable 实现类，可以通过后面介绍的Collections 工具类把HashMap 变成线程安全的
         */

        /**
         * 为了成功地在HashMap 、Hashtable 中存储、获取对象，用作key 的对象必须实现hashCode()方法和equals()方法。
         *
         * 与HashSet 集合不能保证元素的顺序一样， HashMap 、Hashtable 也不能保证其中key-value 对的顺序。类似于HashSet ， HashMap 、Hashtable 判断两个key 相等的标准也是:
         * 两个key 通过equals()方法比较返回true ，两个key 的hashCode 值也相等。
         *
         * 除此之外， HashMap 、Hashtable 中还包含一个containsValueO方法，用于判断是否包含指定的value 。
         *
         * 那么HashMap 、Hashtable 如何判断两个value 相等呢?
         * HashMap 、Hashtable 判断两个value 相等的标准更简单: 只要两个对象通过equals()方法比较返回true 即可。
         *
         * 下面程序示范了Hashtable 判断两个key相等的标准和两个value 相等的标准。
         */
        Hashtable ht = new Hashtable();
        ht.put(new HashMapAndHashtableTest().new A(60000), "疯狂Java 讲义");
        ht.put(new HashMapAndHashtableTest().new A(87563), "轻量级Java EE 企业应用实战");
        ht.put(new HashMapAndHashtableTest().new A(1232), new HashMapAndHashtableTest().new B());
        System.out.println(ht);
        // 只要两个对象通过equals ()方法比较返回true, Hashtable 就认为它们是相等的value, 由于Hashtable 中有一个B 对象, 它与任何对象通过equals ()方法比较都相等，所以下面输出true
        System.out.println(ht.containsValue(""));
        // 只要两个A 对象的count 相等，它们通过equals ()方法比较返回true ，且hashCode 值相等Hashtable 即认为它们是相同的key ，所以下面输出true
        System.out.println(ht.containsKey(new HashMapAndHashtableTest().new A(87563)));
        // 下面语句可以删除最后一个key - value 对
        System.out.println(ht.remove(new HashMapAndHashtableTest().new A(1232)));
        System.out.println(ht);
        /**
         * 上面程序定义了A 类和B 类，其中A 类判断两个A 对象相等的标准是count 实例变量:只要两个A 对象的count 变量相等，则通过equalsO方法比较它们返回true ，
         * 它们的hashCode 值也相等;而B 对象则可以与任何对象相等。
         *
         * Hashtable 判断value 相等的标准是: value 与另外一个对象通过equals()方法比较返回true 即可。上面程序中的ht 对象中包含了一个B 对象，
         * 它与任何对象通过equals()方法比较总是返回true ，所以不管传给ht 对象的containsValue()方法参数是什么，程序总是返回true 。
         *
         * 根据Hashtable 判断两个key 相等的标准，，因为两个A 对象虽然不是同一个对象，但它们通过equals()方法比较返回true ，且hashCode 值相等，
         * Hashtable 即认为它们是同一个key 。
         *
         * 当使用自定义类作为HashMap 、Hashtable 的key 时，如果重写该类的equals(Object obj)和hashCode() 方法，应该保证两个方法的判断标准一致
         * 当两个key 通过equals()方法比较返回true 时，两个key 的hashCode()返回值也应该相同。因为HashMap 、Hashtable保存key 的方式与HashSet 保存集合元素的方式完全相同，
         * 所以HashMap 、Hashtable 对key 的要求与HashSet 对集合元素的要求完全相同。
         *
         * 与HashSet 类似的是，如果使用可变对象作为HashMap 、Hashtable 的key，并且程序修改了作为key 的可变对象，则也可能出现与HashSet 类似的情形:
         * 程序再也无法准确访问到Map 中被修改过的key 。
         *
         * 看下面程序
         */
        HashMap hMap = new HashMap();
        hMap.put(new HashMapAndHashtableTest().new A(60000), "疯狂Java 讲义");
        hMap.put(new HashMapAndHashtableTest().new A(87563), "轻量级Java EE 企业应用实战");
        // 获得HashMap 的keySet 集合对应的Iterator 迭代器
        Iterator it = hMap.keySet().iterator();
        // 取出Map 中第一个key，并修改它的count 值
        A a = (A)it.next();
        a.count = 87563;
        System.out.println(hMap);
        // 此时只能删除没有被修改过的key 所对应的key -value 对
        System.out.println(hMap.remove(new HashMapAndHashtableTest().new A(87563)));
        System.out.println(hMap.remove(new HashMapAndHashtableTest().new A(60000)));
        System.out.println(hMap);
        // 无法获取剩下的value ，下面两行代码都将输出null
        System.out.println(hMap.get(hMap.remove(new HashMapAndHashtableTest().new A(87563))));
        System.out.println(hMap.get(hMap.remove(new HashMapAndHashtableTest().new A(60000))));
        /**
         * 与HashSet 类似的是，尽量不要使用可变对象作为HashMap 、Hashtable 的key ，如果确实需要使用可变对象作为HashMap 、Hashtable 的key ，
         * 则尽量不要在程序中修改作为key 的可变对象。
         */

    }

    class A{

        int count;

        public A(int count) {
            this.count = count;
        }

        @Override
        public int hashCode() {
            return this.count;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == A.class) {
                return ((A)obj).count == this.count;
            }
            return false;
        }
    }

    class B{
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
}
