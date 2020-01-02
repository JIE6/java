package collection.map;

import java.util.WeakHashMap;

/**
 * WeakHashMap 实现类
 *
 * WeakHashMap 与HashMap 的用法基本相似。与HashMap 的区别在于， HashMap 的key 保留了对实际对象的强引用，这意味着只要该HashMap 对象不被销毁，
 * 该HashMap 的所有key 所引用的对象就不会被垃圾回收， HashMap 也不会自动删除这些key 所对应的key-value 对: 但WeakHashMap 的key只保留了对实际对象的弱引用，
 * 这意味着如果WeakHashMap 对象的key 所引用的对象没有被其他强引用变量所引用，则这些key 所引用的对象可能被垃圾回收， WeakHashMap 也可能自动删除这些key 所
 * 对应的key-value 对。
 *
 * WeakHashMap 中的每个key 对象只持有对实际对象的弱引用，因此，当垃圾回收了该key 所对应的实际对象之后， WeakHashMap 会自动删除该key 对应的key-value 对。
 * 看如下程序。
 *
 * @author JIE
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        WeakHashMap whm = new WeakHashMap();
        // 向WeakHashMap 中添加三个key - value 对, 三个key 都是匿名字符串对象(没有其他引用〉
        whm.put(new String("语文"), new String("良好"));
        whm.put(new String("数学"), new String("及格"));
        whm.put(new String("英语"), new String("中等"));
        // 向WeakHashMap 中添加一个key - value 对, 该key 是一个系统缓存的字符串对象
        whm.put("java", new String("中等"));
        System.out.println(whm);
        // /通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        // 在通常情况下，将只看到一个key - value 对
        System.out.println(whm);
        /**
         * 从上面运行结果可以看出， 当系统进行垃圾回收时，删除了WeakHashMap 对象的前三个key-value对。这是因为添加前三个key-value 对时, 这三个key 都是匿名的字符串对象，
         * WeakHashMap 只保留了对它们的弱引用，这样垃圾回收时会自动删除这三个key-value 对。
         *
         * WeakHashMap 对象中第4 个组key-value 对的key 是一个字符串直接量， (系统会自动保留对该字符串对象的强引用)，所以垃圾回收时不会回收它。
         *
         * 如果需要使用WeakHashMap 的key 来保留对象的弱引用，则不要让该key 所引用的对象具有任何强引用， 否则将失去使用WeakHashMap 的意义。
         */
    }
}
