# Set 集合

<pre>
    前面己经介绍过Set 集合，它类似于一个罐子， 程序可以依次把多个对象"丢进" Set 集合，而Set
集合通常不能记住元素的添加顺序。Set 集合与Collection 基本相同，没有提供任何额外的方法。实际
上Set 就是Collection ，只是行为略有不同( Set 不允许包含重复元素) 。

    Set 集合不允许包含相同的元素，如果试图把两个相同的元素加入同一个Set 集合中， 则添加操作
失败， add()方法返回false ，且新元素不会被加入。

    上面介绍的是Set 集合的通用知识，因此完全适合后面介绍的HashSet、TreeSet 和EnumSet 三个实现类，
只是三个实现类还各有特色。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| HashSetTest | 5 | HashSet 类 |
| LinkedHashSetTest | 5 | LinkedHashSet 类 |
| TreeSetTest | 5 | TreeSet 类 与 自然排序、定制排序 |
| EnumSetTest | 5 | EnumSet 类 |

## 各Set 实现类的性能分析
<pre>
    HashSet 和TreeSet 是Set 的两个典型实现， 到底如何选择HashSet 和TreeSet 呢? HashSet 的性能总
是比TreeSet 好(特别是最常用的添加、查询元素等操作) ， 因为TreeSet 需要额外的红黑树算法来维护集合元素
的次序。只有当需要一个保持排序的Set 时，才应该使用TreeSet ，否则都应该使用HashSet。
    HashSet 还有一个子类: LinkedHashSet ， 对于普通的插入、删除操作， LinkedHashSet 比HashSet
要略微慢一点， 这是由维护链表所带来的额外开销造成的， 但由于有了链表，遍历LinkedHashSet 会更快。
    EnumSet 是所有Set 实现类中性能最好的，但它只能保存同一个枚举类的枚举值作为集合元素。
    必须指出的是， Set 的三个实现类HashSet 、TreeSet 和EnumSet 都是线程不安全的。如果有多个线
程同时访问一个Set 集合，并且有超过一个线程修改了该Set 集合，则必须手动保证该Set 集合的同步性。通
常可以通过Collections 工具类的synchronizedSortedSet 方法来" 包装"该Set 集合。此操作最好在创建
时进行， 以防止对Set 集合的意外非同步访问。例如:
SortedSet sortedSet = Collections.synchronizedSortedSet(new TreeSet());
    关于Collections 工具类的更进一步用法，可以参考Collections
</pre>
