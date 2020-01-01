package collection.map;

import java.util.HashMap;

/**
 * Java 8 为Map 新增的方法
 *
 * Java 8 除为Map 增加了remove(Object key , Object value)默认方法之外，还增加了如下方法。
 *
 * Object compute(Object key, BiFunction remappingFunction): 该方法使用remappingFunction 根据原key-value 对计算一个新value 。
 * 只要新value 不为null，就使用新value 覆盖原value; 如果原value 不为null，但新value 为null ，则删除原key-value 对;如果原value 、
 * 新value 同时为null ，那么该方法不改变任何key-value 对，直接返回null 。
 *
 * Object computeIfAbsent(Object key, Function mappingFunction): 如果传给该方法的key 参数在Map 中对应的value 为null ，
 * 则使用mappingFunction 根据key 计算一个新的结果，如果计算结果不为null ，则用计算结果覆盖原有的value 。如果原Map 原来不包括该key ，
 * 那么该方法可能会添加一组key-value 对。
 *
 * Object computeIfPresent(Object key, BiFunction remappingFunction): 如果传给该方法的key 参数在Map 中对应的value 不为null，
 * 该方法将使用remappingFunction 根据原key、value 计算一个新的结果，如果计算结果不为null，则使用该结果覆盖原来的value; 如果计算结果为null，
 * 则删除原key-value 对。
 *
 * void forEach(BiConsumer action): 该方法是Java 8 为Map 新增的一个遍历key-value 对的方法，通过该方法可以更简洁地遍历Map 的key-value 对。
 *
 * Object getOrDefault(Object key, V defaultValue): 获取指定key 对应的value 。如果该key 不存在，则返回defaultValue.
 *
 * Object merge(Object key, Object value, BiFunction remappingFunction): 该方法会先根据key 参数获取该Map 中对应的value 。如果获取的value 为null，
 * 则直接用传入的value 覆盖原有的value(在这种情况下，可能要添加一组key-value 对) ;如果获取的value 不为null ，则使用remappingFunction 函数根据原value 、
 * 新value 计算一个新的结果，并用得到的结果去覆盖原有的value 。
 *
 * Object putIfAbsent(Object key, Object value): 该方法会自动检测指定key 对应的value 是否为null，如果该key 对应的value 为null，该方法将会用新value 代替原来的null 值。
 *
 * Object replace(Object key, Object value): 将Map 中指定key 对应的value 替换成新value 。与传统put()方法不同的是，该方法不可能添加新的key-value 对。
 * 如果尝试替换的key 在原Map 中不存在，该方法不会添加key-value 对，而是返回null 。
 *
 * boolean replace(K key, V oldValue, V newValue): 将Map 中指定key-value 对的原value 替换成新value 。如果在Map 中找到指定的key-value 对，
 * 则执行替换并返回true ，否则返回false 。
 *
 * replaceAll(BiFunction function): 该方法使用BiFunction 别原key-value 对执行计算，并将计算结果作为该key-value 对的value 值
 *
 * 下面程序示范了Map 常用默认方法的功能和用法。
 *
 * @author JIE
 */
public class NewMapTest {

    public static void main(String[] args) {
        HashMap map = new HashMap();
        // 成对放入多个key-value 对
        map.put("疯狂Java 讲义", 109);
        map.put("疯狂iOS 讲义", 10);
        map.put("疯狂Ajax 讲义", 79);
        // 尝试替换key 为"疯狂XML 讲义"的value ，由于原Map 中没有对应的key因此Map 没有改变，不会添加新的key-value 对
        map.replace("疯狂XML 讲义", 66);
        System.out.println(map);
        // 使用原value 与传入参数计算出来的结果覆盖原有的value
        System.out.println(map.merge("疯狂iOS 讲义", 6, (oldVal, param) -> (Integer) oldVal + (Integer) param));
        System.out.println(map);
        // 当key 为"Java" 对应的value 为 null (或不存在)时，使用计算的结果作为新value
        System.out.println(map.computeIfAbsent("Java", (key) -> ((String)key).length()));
        System.out.println(map);
        // 当key 为"Java"对应的value 存在时，使用计算的结果作为新value
        System.out.println(map.computeIfPresent("Java", (key, value) -> ((Integer)value) * (Integer)value));
        System.out.println(map);


        /**
         * 上面程序中注释己经写得很清楚了，而且给出了每个方法的运行结果，可以结合这些方法的介绍文档来阅读该程序，从而掌握Map 中这些默认方法的功能与用法。
         */
    }
}
