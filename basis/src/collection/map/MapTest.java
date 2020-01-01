package collection.map;

import java.util.HashMap;

/**
 * Map 集合介绍与使用
 *
 * Map 接口中定义了如下常用的方法。
 * void clear(): 删除该Map 对象中的所有key-value 对
 * boolean containsKey(Object key): 查询Map 中是否包含指定的key ，如果包含则返回true
 * boolean containsValue(Object value): 查询Map 中是否包含一个或多个value ，如果包含则返回true
 * Set entrySet(): 返回Map 中包含的key-value 对所组成的Set 集合，每个集合元素都是Map.Entry(Entry 是Map 的内部类)对象。
 * Object get(Object key): 返回指定key 所对应的value; 如果此Map 中不包含该key ，则返回null 。
 * boolean isEmpty(): 查询该Map 是否为空(即不包含任何key-value 对) ，如果为空则返回true 。
 * Set keySet(): 返回该Map 中所有key 组成的Set 集合。
 * Object put(Object key, Object value): 添加一个key-value 对，如果当前Map 中己有一个与该key相等的key-value 对，则新的key-value 对会覆盖原来的key-value 对。
 * void putAll(Map m): 将指定Map 中的key-value 对复制到本Map 中
 * Object remove(Object key): 删除指定key 所对应的key-value 对，返回被删除key 所关联的value如果该key 不存在，则返回null 。
 * boolean remove(Object key, Object value): 这是Java 8 新增的方法，删除指定key 、value 所对应的key-value 对。如果从该Map 中成功地删除该key-value 对，
 * 该方法返回true ，否则返回false 。
 * int size(): 返回该Map 里的key-value 对的个数。
 * Collection values(): 返回该Map 里所有value 组成的Collection 。
 *
 * Map 接口提供了大量的实现类，典型实现如HashMap 和Hashtable 等、HashMap 的子类LinkedHashMap ，还有SortedMap 子接口及该接口的实现类TreeM叩，以及WeakHashMap 、
 * IdentityHashMap 等。下面将详细介绍Map 接口实现类。
 *
 * Map 中包括一个内部类Entry，该类封装了一个key-value 对。Entry 包含如下三个方法。
 * Object getKey(): 返回该Entry里包含的key 值。
 * Object getValue(): 返回该Entry 里包含的value 值。
 * Object setValue(V value): 设置该Entry 里包含的value 值，并返回新设置的value 值。
 *
 * Map 集合最典型的用法就是成对地添加、删除key-value 对，接下来即可判断该Map 中是否包含指定key ，是否包含指定value ，也可以通过Map 提供的keySet()方法获取所有key 组成的集合，
 * 进而遍历Map 中所有的key-value 对。下面程序示范了Map 的基本功能。
 *
 * @author JIE
 */
public class MapTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        // 成对放入多个key-value 对
        map.put("疯狂Java 讲义", 109);
        map.put("疯狂iOS 讲义", 10);
        map.put("疯狂Ajax 讲义", 79);
        // 多次放入的key - value 对中value 可以重复
        map.put("轻量级Java EE 企业应用实战", 99);
        // 放入重复的key 时， 新的value 会覆盖原有的value, 如果新的value 覆盖了原有的value ，该方法返回被覆盖的value
        System.out.println(map.put("疯狂iOS 讲义", 99));
        System.out.println(map);
        // 判断是否包含指定key
        System.out.println(map.containsKey("疯狂iOS 讲义"));
        // 判断是否包含指定value
        System.out.println(map.containsValue(99));
        // 获取Map 集合的所有key 组成的集合，通过遍历key 来实现遍历所有的key - value 对
        /**
         * foreach 循环用于遍历Map 集合:程序先调用Map 集合的keySetO获取所有的key，然后使用foreach循环来遍历Map 的所有key，根据key 即可遍历所有的value 。
         */
        for (Object key : map.keySet()) {
            // map.get(key) 方法获取指定key 对应的value
            System.out.println(key + "->" + map.get(key));
        }
        // 根据key 来删除key-value 对
        System.out.println(map.remove("疯狂Ajax 讲义"));
        System.out.println(map);
        /**
         * HashMap 重写了toString()方法，实际上所有的Map 实现类都重写了toString()方法，调用Map 对象的toString()方法总是返回如下格式的字符串:
         * {key1=value1，key2=value2...} 。
         */
    }
}
