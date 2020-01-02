package collection.map;

import java.util.IdentityHashMap;

/**
 * IdentityHashMap 实现类
 *
 * 这个Map 实现类的实现机制与HashMap 基本相似，但它在处理两个key 相等时比较独特:在IdentityHashMap 中，当且仅当两个key 严格相等(key1 == key2) 时，
 * IdentityHashMap 才认为两个key相等:对于普通的HashMap 而言，只要key1 和key2 通过equals()方法比较返回true ，且它们的hashCode值相等即可。
 *
 * IdentityHashMap 是一个特殊的Map 实现! 此类实现Map 接口时，它有意违反Map的通常规范: IdentityHashMap 要求两个 key严格相等时才认为两个 key 相等。
 *
 * IdentityHashMap 提供了与HashMap 基本相似的方法，也允许使用null 作为key 和value 。与HashMap相似:
 * IdentityHashMap 也不保证key-value 对之间的顺序， 更不能保证它们的顺序随时间的推移保持不变。
 *
 * @author JIE
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        IdentityHashMap ihm = new IdentityHashMap();
        // 下面两行代码将会向IdentityHashMap 对象中添加两个key-val ue 对
        ihm.put(new String("语文"), 89);
        ihm.put(new String("语文"), 78);
        // 下面两行代码只会向IdentityHashMap 对象中添加一个key-value 对
        ihm.put("Java", 93);
        ihm.put("Java", 98);
        System.out.println(ihm);
        /**
         * 上面程序试图向IdentityHashMap 对象中添加4 个key-value 对，前2 个key-value 对中的key 是新创建的字符串对象，它们通过==比较不相等，
         * 所以IdentityHashMap 会把它们当成2 个key 来处理;后2 个key-value 对中的key 都是字符串直接量，而且它们的字符序列完全相同， Java 使用常量池来管理
         * 字符串直接量，所以它们通过==比较返回true ， IdentityHashMap 会认为它们是同一个key，因此只有一次可以添加成功。
         */
    }
}
