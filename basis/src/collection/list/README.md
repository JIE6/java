#  List 集合 与 Queue集合

<pre>
    List 集合代表一个元素有序、可重复的集合，集合中每个元素都有其对应的顺序索引。List 集合允
许使用重复元素，可以通过索引来访问指定位置的集合元素。List 集合默认按元素的添加顺序设置元素的
索引，例如第一次添加的元素索引为0 ， 第二次添加的元素索引为l ……
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| ListTest | 5 | Java8 改进的List 接口和ListIterator 接口 |
| ArrayListAndVector | 5 | ArrayList 和Vector 实现类介绍 与 固定长度的List |
| QueueTest | 5 | Queue 集合 与 PriorityQueue 实现类 |
| DequeTest | 5 | Deque 接口与ArrayDeque 实现类 |
| LinkedListTest | 5 | LinkedList 实现类 |

## 各种线性表的性能分析
<pre>
    Java 提供的List 就是一个线性表接口，而ArrayList 、LinkedList 又是线性表的两种典型实现: 基于
数组的线性表和基于链的线性表。Queue 代表了队列， Deque 代表了双端队列(既可作为队列使用， 也可作为栈
使用) ，接下来对各种实现类的性能进行分析。
    初学者可以无须理会ArrayList 和LinkedList 之间的性能差异，只需要知道LinkedList 集合不仅提
供了List 的功能，还提供了双端队列、栈的功能就行。但对于一个成熟的Java 程序员，在一些性能非常敏感
的地方，可能需要慎重选择哪个List 实现。
    一般来说，由于数组以一块连续内存区来保存所有的数组元素，所以数组在随机访问时性能最好，所有的内部以
数组作为底层实现的集合在随机访问时性能都比较好:而内部以链表作为底层实现的集合在执行插入、删除操作时有较
好的性能。但总体来说， ArrayList 的性能比LinkedList 的性能要好，因此大部分时候都应该考虑使用ArrayList 。
    关于使用List 集合有如下建议。
    1.如果需要遍历List 集合元素，对于ArrayList 、Vector 集合，应该使用随机访问方法(get) 来遍历集合
元素，这样性能更好;对于LinkedList 集合，则应该采用法代器( Iterator) 来遍历集合元素。
    2.如果需要经常执行插入、删除操作来改变包含大量数据的List 集合的大小，可考虑使用LinkedList 集合。
使用ArrayList 、Vector 集合可能需要经常重新分配内部数组的大小， 效果可能较差。
    3.如果有多个线程需要同时访问List 集合中的元素，开发者可考虑使用Collections 将集合包装成线程安全的集合。
</pre>