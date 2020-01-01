package collection.map;

import java.util.TreeMap;

/**
 * SortedMap 接口和TreeMap 实现类
 *
 * 正如Set 接口派生出SortedSet 子接口， SortedSet 接口有一个TreeSet 实现类一样， Map 接口也派生出一个SortedMap 子接口， SortedMap 接口也有一个TreeMap 实现类。
 *
 * TreeMap 就是一个红黑树数据结构， 每个key-value 对即作为红黑树的一个节点。TreeMap 存储key-value 对(节点)时， 需要根据key 对节点进行排序。
 * TreeMap 可以保证所有的key-value 对处于有序状态。TreeMap 也有两种排序方式。
 * 1.自然排序: TreeMap 的所有key 必须实现Comparable 接口，而且所有的key 应该是同一个类的对象，否则将会抛出C lassCastException 异常。
 * 2.定制排序:创建TreeMap 时，传入一个Comparator 对象， 该对象负责对TreeMap 中的所有key进行排序。采用定制排序时不要求M叩的key 实现Comparable 接口。
 *
 * 类似于TreeSet 中判断两个元素相等的标准. TreeMap 中判断两个key 相等的标准是:两个key 通过compareToO方法返回O. TreeMap 即认为这两个key 是相等的。
 *
 * 如果使用自定义类作为TreeMap 的key. 且想让TreeMap 良好地工作，则重写该类的equals()方法和compareTo()方法时应保持一致的返回结果:两个key 通过equalsO方法比较返回true 时，
 * 它们通过compareTo()方法比较应该返回0 。如果equals()方法与compareTo()方法的返回结果不一致. TreeMap与Map 接口的规则就会冲突。
 *
 * 再次强调: Set 和Map 的关系十分密切， Java 源码就是先实现了HashMap 、TreeMap等集合，然后通过包装一个所有的value 都为null 的Map 集合实现了Set 集合类。
 *
 * 与TreeSet 类似的是. TreeMap 中也提供了一系列根据key 顺序访问key-value 对的方法。
 *
 * Map.Entry firstEntry(): 返回该Map 中最小key 所对应的key-value 对，如果该Map 为空， 则返回null 。
 * Object firstKey(): 返回该Map 中的最小key 值， 如果该Map 为空， 则返回null 。
 * Map.Entry lastEntry(): 返回该Map 中最大key 所对应的key-value 对，如果该Map 为空或不存在这样的ke叮y-v刊ah回对，则都返回null 。
 * Object lastKey(): 返回该Map 中的最大key 值，如果该Map 为空或不存在这样的key. 则都返回null.
 * Map.Entry higherEntry(Object key): 返回该Map 中位于key 后一位的key-value 对( 即大于指定key 的最小key 所对应的key-value 对)。如果该Map 为空，则返回null 。
 * Object higherKey(Object key): 返回该Map 中位于key 后一位的key 值(即大于指定key 的最小key 值) 。如果该Map 为空或不存在这样的key-value 对， 则都返回null 。
 * Map.Entry lowerEntry(Object key): 返回该Map 中位于key 前一位的key-value 对(即小于指定key 的最大key 所对应的key-value 对) 。如果该Map 为空或不存在这样的key-value 对，则都返回null 。
 * Object lowerKey(Object key): 返回该Map 中位于key 前一位的key 值(即小于指定key 的最大key 值) 。如果该Map 为空或不存在这样的key. 则都返回null 。
 * NavigableMap subMap(Object fromKey， boolean fromInclusive, Object toKey, boolean toInclusive):返回该Map 的子Map. 其key 的范围是从fromKey (C) 是否包括取决于第二个参数)
 * 到toKey ( 是否包括取决于第四个参数) 。
 * SortedMap subMap(Object fromKey， Object toKey): 返回该Map 的子Map. 其key 的范围是从台omKey (包括〉到toKey (不包括) 。
 * SortedMap tailMap(Object fromKey): 返回该Map 的子Map. 其key 的范围是大于fromKey ( 包括〉的所有key 。
 * NavigableMap tailMap(Object fromKey, boolean inclusive): 返回该Map 的子Map. 其key 的范围是大于fromKey ( 是否包括取决于第二个参数〉的所有key 。
 * SortedMap headMap(Object toKey): 返回该Map 的子Map. 其key 的范围是小于toKey ( 不包括)的所有key 。
 * NavigableMap headMap(Object toKey, boolean inclusive): 返回该Map 的子Map. 其key 的范围是小于toKey (是否包括取决于第二个参数) 的所有key 。
 *
 * 表面上看起来这些方法很复杂，其实它们很简单。因为TreeMap 中的key-value 对是序的，所以增加了访问第一个、前一个、后一个、最后一个key-value 对的方法，
 * 并提供了几个从TreeMap 中截取子TreeMap 的方法。
 *
 * 下面以自然排序为例，介绍TreeMap 的基本用法。
 * @author JIE
 */
public class TreeMapTest {

    class R implements Comparable {

        int count;

        public R(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == R.class) {
                return ((R)obj).count == this.count;
            }
            return false;
        }

        @Override
        public String toString() {
            return "R[count: "+count+"]";
        }

        @Override
        public int compareTo(Object o) {
            R r = (R)o;
            return this.count > r.count ? 1 : this.count < r.count ? -1 : 0;
        }
    }

    public static void main(String[] args) {
        TreeMap tm = new TreeMap();
        tm.put(new TreeMapTest().new R(3), "轻量级Java EE 企业应用实战");
        tm.put(new TreeMapTest().new R(-5), "疯狂Java 讲义");
        tm.put(new TreeMapTest().new R(9), "疯狂Android 讲义");
        System.out.println(tm);
        // 返回该TreeMap 的第一个Entry 对象
        System.out.println(tm.firstEntry());
        // 返回该T reeMap 的最后一个key 值
        System.out.println(tm.lastKey());
        // 返回该TreeMap 的比new R(2) 大的最小key 值
        System.out.println(tm.higherKey(new TreeMapTest().new R(2)));
        // 返回该TreeMap 的比new R(2) 小的最大的key-value 对
        System.out.println(tm.lowerEntry(new TreeMapTest().new R(2)));
        // 返回该TreeMap 的子TreeMap
        System.out.println(tm.subMap(new TreeMapTest().new R(-5), new TreeMapTest().new R(3)));
        /**
         * 面程序中定义了一个R 类， 该类重写了equals()方法，并实现了Comparable 接口，所以可以使用该R 对象作为TreeMap 的key，该TreeMap 使用自然排序。
         */
    }
}
