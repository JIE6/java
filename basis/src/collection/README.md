# java 集合

<pre>
    Java 集合类是一种特别有用的工具类，可用于存储数量不等的对象，并可以实现常用的数据结构，
如栈、队列等。除此之外， Java 集合还可用于保存具有映射关系的关联数组。Java 集合大致可分为Set、
List 、Queue 和Map 四种体系，其中Set 代表无序、不可重复的集合; List 代表有序、重复的集合;而
Map 则代表具有映射关系的集合， Java 5 又增加了Queue 体系集合，代表一种队列集合实现。
    Java 集合就像一种容器， 可以把多个对象(实际上是对象的引用，但习惯上都称对象) "丢进"该
容器中。在Java 5 之前， Java 集合会丢失容器中所有对象的数据类型，把所有对象都当成Object 类型
处理;从Java 5 增加了泛型以后， Java 集合可以记住容器中对象的数据类型，从而可以编写出更简洁、
健壮的代码。本章不会介绍泛型的知识，本章重点介绍Java 的4 种集合体系的功能和用法。本章将详
细介绍Java 的4 种集合体系的常规功能，深入介绍各集合实现类所提供的独特功能，深入分析各实现
类的实现机制，以及用法上的细微差别，并给出不同应用场景选择哪种集合实现类的建议。

    Java 的集合类主要由两个接口派生而出: Collection 和Map ， Collection 和Map 是Java 集合框架的
根接口，这两个接口又包含了一些子接口或实现类。如下图 所示是Collection 接口、子接口及其实现类的继承树。
----------------------------------------------------------------------------------------------
                                            Collection
                        ↗                         ↑                          ↖
           Set(无序集合，元素不可重复)          Queue(队列)              List(有序集合，元素可重复)
           ↑           ↑           ↑          ↑        ↑              ↑      ↑         ↑
        (EnumSet,  SortedSet,   HashSet)  (Deque,  PriorityQueue)     ↑(ArrayList, Vector)
                        ↑           ↑           ↑↖←←←←←←←←←←←←←←←←←   ↑                ↑
                    (TreeSet, LinkedHashSet) (ArrayDeque, )    (LinkedList)         (Stack)
----------------------------------------------------------------------------------------------
    上图显示了Collection 体系里的集合，其中Set 和List 接口是Collection 接口派生的两个子接口，它们分别代表了无序集合和有序集合;
Queue 是Java 提供的队列实现，有点类似于List ， 后面章节还会有更详细的介绍，此处不再赘述。

    下图所示是Map 体系的继承树，所有的Map 实现类用于保存具有映射关系的数据( 也就是前面介绍的关联数组)。
----------------------------------------------------------------------------------------------
                                            Map
       ↗              ↗               ↗         ↖           ↖           ↖
    (Enum,    IdentityHashMap,    HashMap,    HashTable,  SortedMap,  WeakHashMap)
                                   ↑                  ↑         ↑
                                   ↑                  ↑     (TreeMap)
                                   ↑                  ↑
        (线程不安全，key、value允许为null)   (线程安全，key、value不能为null)
                                   ↑                  ↑
                                (LinkedHashMap)  (Properties)
----------------------------------------------------------------------------------------------
    对于Set、List 、Queue 和Map 四种集合，最常用的实现类分别是HashSet、TreeSet 、ArrayList 、ArrayDeque 、LinkedList 
和HashMap 、TreeMap 等实现类。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| CollectionTest | 5 | Collection 介绍 |
| CollectionTraversalTest | 5 | 遍历 Collection 集合 |
| PredicateTest | 5 | 使用Java 8 新增的Predicate 操作集合 |
| StreamTest | 5 | 使用Java 8 新增的Stream 操作集合 |
| set | 5 | Set 集合 |