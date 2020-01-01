# Map 集合

<pre>
    Map 用于保存具有映射关系的数据，因此Map 集合里保存着两组值， 一组值用于保存Map 里的key ，
另外一组值用于保存Map 里的value ， key 和value 都可以是任何引用类型的数据。Map 的key 不允许重复，
即同一个Map 对象的任何两个key 通过equals 方法比较总是返回false 。
    key 和value 之间存在单向一对一关系，即通过指定的key ，总能找到唯一的、确定的value 。从Map 中
取出数据时，只要给出指定的key ，就可以取出对应的value 。
    如果把Map 里的所有key放在一起来看，它们就组成了一个Set 集合(所有的key 没有顺序， key 与key 之
间不能重复) ，实际上Map 确实包含了一个keySetO方法，用于返回Map 里所有key 组成的Set 集合。
    不仅如此， Map 里key 集和Set 集合里元素的存储形式也很像， Map 子类和Set 子类在名字上也惊人地相
似， 比如Set 接口下有HashSet 、LinkedHashSet、SortedSet (接口) 、TreeSet、EnumSet 等子接口和实
现类，而Map 接口下则有HashMap 、LinkedHashMap 、SortedMap (接口)、TreeMap 、EnumMap等子接口和
实现类。正如它们的名字所暗示的， Map 的这些实现类和子接口中key 集的存储形式和对应Set 集合中元素的存储
形式完全相同。

    Set 与Map 之间的关系非常密切。虽然Map 中放的元素是key-value 对， Set 集合中放的元素是单个对象，
但如果把key-value 对中的value 当成key 的附庸: key 在哪里， value就跟在哪里。这样就可以像对待Set
一样来对待Map 了。事实上， Map 提供了一个EnTry内部类来封装key-value对， 而计算Entry存储时则只考虑
Entry封装的key, 从java源码来看，Java则是先实现了Map ，然后通过包装一个所有value都为null的Map就实
现了Set 集合。

    如果把Map 里的所有value 放在一起来看，它们又非常类似于一个List: 元素与元素之间可以重复，
每个元素可以根据索引来查找， 只是Map 中的索引不再使用整数值，而是以另一个对象作为索引。如果需要从List
集合中取出元素， 则需要提供该元素的数字索引; 如果需要从Map 中取出元素， 则需要提供该元素的key 索引。
因此， Map 有时也被称为字典，或关联数组。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| MapTest | 5 | Map 集合介绍与使用 |
| NewMapTest | 5 | Java 8 为Map 新增的方法 |
| HashMapAndHashtableTest | 5 | Java 8 改进的HashMap 和Hashtable 实现类 |
| LinkedHashMapTest | 5 | LinkedHashMap 实现类 |
| PropertiesTest | 5 | 使用Properties 读写属性文件 |
| TreeMapTest | 5 | SortedMap 接口和TreeMap 实现类 |
| WeakHashMapTest | 5 | WeakHashMap 实现类 |