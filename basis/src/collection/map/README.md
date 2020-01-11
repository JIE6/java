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

## 当前包下需重点掌握的知识点
| 位置 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| MapTest | 5 | Map 集合介绍与使用 |
| NewMapTest | 5 | Java 8 为Map 新增的方法 |
| HashMapAndHashtableTest | 5 | Java 8 改进的HashMap 和Hashtable 实现类 |
| LinkedHashMapTest | 5 | LinkedHashMap 实现类 |
| PropertiesTest | 5 | 使用Properties 读写属性文件 |
| TreeMapTest | 5 | SortedMap 接口和TreeMap 实现类 |
| WeakHashMapTest | 5 | WeakHashMap 实现类 |
| IdentityHashMapTest | 5 | IdentityHashMap 实现类 |
| EnumMapTest | 5 | EnumMap 实现类 |


## 各Map 实现类的性能分析
<pre>
    对于Map 的常用实现类而言，虽然HashMap 和Hashtable 的实现机制几乎一样，但由于Hashtable
是一个古老的、线程安全的集合，因此HashMap 通常比Hashtable 要快。
    TreeMap 通常比HashMap 、Hashtable 要慢( 尤其在插入、删除key-value 对时更慢)，因为TreeMap
底层采用红黑树来管理key-value 对(红黑树的每个节点就是一个key-value 对) 。
    使用TreeMap有一个好处: TreeMap 中的key-value 对总是处于有序状态，无须专门进行排序操作。当TreeMap 
被填充之后，就可以调用keySet() ，取得由key 组成的Set，然后使用toArray()方法生成key的数组，接下来使用Arrays 
的binarySearch()方法在己排序的数组中快速地查询对象。
    对于一般的应用场景， 程序应该多考虑使用HashMap ，因为HashMap 正是为快速查询设计的(HashMap 底层其实也是
采用数组来存储key-value 对〉。但如果程序需要一个总是排好序的Map 时，则可以考虑使用TreeMap 。
    LinkedHashMap 比HashMap 慢一点，因为它需要维护链表来保持Map 中key-value 时的添加顺序。IdentityHashMap 
性能没有特别出色之处，因为它采用与HashMap 基本相似的实现， 只是它使用==而不是equals()方法来判断元素相等。
EnumMap 的性能最好，但它只能使用同一个枚举类的枚举值作为key 。
</pre>


## HashSet 和HashMap 的性能选项
<pre>
    对于HashSet 及其子类而言， 它们采用hash 算法来决定集合中元素的存储位置， 并通过hash 算法
来控制集合的大小; 对于HashMap 、Hashtable 及其子类而言，它们采用hash 算法来决定Map 中key的存储，
并通过hash 算法来增加key 集合的大小。
    hash 表里可以存储元素的位置被称为"桶(bucket ) ",在通常情况下，单个"桶"里存储一个元素，此时有最
好的性能: hash 算法可以根据hashCode 值计算出"桶"的存储位置，接着从"桶"中取出元素。但hash 表的状态
是open 的: 在发生" hash 冲突"的情况下，单个桶会存储多个元素，这些元素以链表形式存储， 必须按顺序搜索.
    因为HashSet 和HashMap 、Hashtable 都使用hash 算法来决定其元素(HashMap 则只考虑key ) 的存储，
因此HashSet 、HashMap 的hash 表包含如下属性.
    1.容量( capacity ) : hash 表中桶的数量。
    2.初始化容量(initial capacity): 创建hash 表时桶的数量。HashMap 和HashSet 都允许在构造器中指定初始化容量。
    3.尺寸(size) :当前hash 表中记录的数量。
    4.负载因子(load factor): 负载因子等于" size/capacity "。负载因子为0 ，表示空的hash 表， 0.5表示半满的hash 表，
依此类推。轻负载的hash 表具有冲突少、适直插入与查询的特点(但是使用Iterator 迭代元素时比较慢) 。
    除此之外， hash 表里还有一个"负载极限"，"负载极限"是一个0~1 的数值，"负载极限"决定了hash 表的最大填满程度。当hash 
表中的负载因子达到指定的"负载极限"时， hash 表会自动成倍地增加容量(桶的数量)，并将原有的对象重新分配，放入新的桶内，这称为rehashing 。
    HashSet 和HHashMap 、Hashtable 的构造器允许指定一个负载极限， HashSet 和HashMap 、Hashtable默认的"负载极限"为0.75 ，
这表明当该hash 表的3 /4 已经被填满时， hash 表会发生rehashing 。
    "负载极限"的默认值(0.75) 是时间和空间成本上的一种折中: 较高的"负载极限"可以降低hash表所占用的内存空间，但会增加查询数据的时间开销，
而查询是最频繁的操作( HashMap 的get()与put()方法都要用到查询);较低的"负载极限"会提高查询数据的性能，但会增加hash 表所占用的内存开销。
程序员可以根据实际情况来调整HashSet 和HashMap 的"负载极限"值。
    如果开始就知道HashSet 和HashMap 、Hashtable 会保存很多记录，则可以在创建时就使用较大的初始化容量，如果初始化容量始终大于HashSet 
和HashMap 、Hashtable 所包含的最大记录数除以"负载极限"，就不会发生rehashing 。使用足够大的初始化容量创建HashSet 和HashMap 、Hashtable
时，可以更高效地增加记录，但将初始化容量设置太高可能会浪费空间，因此通常不要将初始化容量设置得过高。
</pre>