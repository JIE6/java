package collection.list;

import java.util.Arrays;
import java.util.List;

/**
 * ArrayList 和Vector 实现类介绍
 *
 * ArrayList 和Vector 作为List 类的两个典型实现， 完全支持前面介绍的List 接口的全部功能。
 *
 * ArrayList 和Vector 类都是基于数组实现的List 类，所以ArrayList 和Vector 类封装了一个动态的、允许再分配的Object[]数组。
 * ArrayList 或Vector 对象使用initialCapacity 参数来设置该数组的长度， 当向ArrayList 或Vector 中添加元素超出了该数组的长度时，
 * 它们的initialCapacity 会自动增加。
 *
 * 对于通常的编程场景，程序员无须关心ArrayList 或Vector 的initialCapacity 。但如果向ArrayList或Vector 集合中添加大量元素时，
 * 可使用ensureCapacity(int minCapacity) 方法一次性地增加initialCapacity。这可以减少重分配的次数，从而提高性能。
 *
 * 如果开始就知道ArrayList 或Vector 集合需要保存多少个元素，则可以在创建它们时就指定initialCapacity 大小。
 * 如果创建空的ArrayList 或Vector 集合时不指定initialCapacity 参数，则Object[]数组的长度默认为10 。
 *
 * 除此之外. ArrayList 和Vector 还提供了如下两个方法来重新分配Object[]数组。
 * void ensureCapacity(int minCapacity): 将ArrayList 或Vector 集合的Object[]数组长度增加大于或等于minCapacity 值。
 * void trimToSize(): 调整ArrayList 或Vector 集合的Object[]数组长度为当前元素的个数。调用该方法可减少ArrayList 或Vector 集合对象占用的存储空间。
 *
 * ArrayList 和Vector 在用法上几乎完全相同，但由于Vector 是一个古老的集合(从JDK 1 .0 就有了)，那时候Java 还没有提供系统的集合框架，所以Vector 里提供了一些方法名很长的方法，例如
 * addElement(Object obj) ， 实际上这个方法与add (Object obj)没有任何区别。从JDK 1.2 以后， Java 提供了系统的集合框架，就将Vector 改为实现List 接口，作为List 的实现之一，
 * 从而导致Vector 里有一些功能重复的方法。
 *
 * Vector 的系列方法中方法名更短的方法属于后来新增的方法，方法名更长的方法则是Vector 原有的方法。Java 改写了Vector 原有的方法，将其方法名缩短是为了简化编程。
 * 而ArrayList 开始就作为List的主要实现类，因此没有那些方法名很长的方法。实际上， Vector 具有很多缺点， 通常尽量少用Vector实现类。
 *
 * 除此之外， ArrayList 和Vector 的显著区别是:
 * ArrayList 是线程不安全的，当多个线程访问同一个ArrayList 集合时，如果有超过一个线程修改了ArrayList 集合，则程序必须于动保证该集合的同步性;
 * 但Vector 集合则是线程安全的，无须程序保证该集合的同步性。因为Vector 是线程安全的，所以Vector的性能比ArrayList 的性能要低。实际上，即使需要保证List 集合线程安全，
 * 也同样不推荐使用Vector实现类。后面会介绍一个Collections 工具类，它可以将一个ArrayList 变成线程安全的。
 *
 * Vector 还提供了一个Stack 子类，它用于模拟"栈"这种数据结构，"栈"通常是指"后进先出" ( LIFO )的容器。最后"push" 进栈的元素，将最先被"pop" 出棋。与Java 中的其他集合一样，
 * 进栈出栈的都是Object ， 因此从栈中取出元素后必须进行类型转换，除非你只是使用Object 具有的操作。所以Stack类里提供了如下几个方法。
 * Object peek(): 返回"栈"的第一个元素，但并不将该元素"pop" 出栈。
 * Object pop(): 返回"栈"的第一个元素，并将该元素"pop" 出拢。
 * void push(Object item): 将一个元素"push" 进栈， 最后一个进"栈"的元素总是位于"栈"顶。
 * 需要指出的是，由于Stack 继承了Vector，因此它也是一个非常古老的Java 集合类，它同样是线程安全的、性能较差的，因此应该尽量少用Stack 类。
 * 如果程序需要使用"校"这种数据结构，则可以考虑使用后面将要介绍的ArrayDeque
 *
 * ArrayDeque 也是List 的实现类， ArrayDeque 既实现了List 接口，也实现了Deque 接口， 由于实现了Deque 接口，因此可以作为找来使用;
 * 而且ArrayDeque 底层也是基于数组的实现，因此性能也很好。
 *
 *----------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * 固定长度的List
 *
 *----------------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * 前面讲数组时介绍了一个操作数组的工具类: Arrays ，该工具类里提供了asList(Object... a)方法，该方法可以把一个数组或指定个数的对象转换成一个List 集合，
 * 这个List 集合既不是ArrayList 实现类的实例，也不是Vector 实现类的实例，而是Arrays 的内部类ArrayList 的实例。
 *
 * Arrays.ArrayList 是一个固定长度的List 集合，程序只能遍历访问该集合里的元素，不可增加、删除该集合里的元素。如下程序所示。
 *
 * @author JIE
 */
public class ArrayListAndVector {

    public static void main(String[] args) {
        List fixedList = Arrays.asList("疯狂Java 讲义", "轻量级Java EE 企业应用实战");
        // 获取fixedList 的实现类，将输出Arrays$ArrayList
        System.out.println(fixedList.getClass());
        // 使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);
        // 试图增加、删除元素都会引发UnsupportedOperationException 异常
//        fixedList.add("aa");
        fixedList.remove("疯狂Java 讲义");
        /**
         * 上面程序中新增删除对应普通的List 集合完全正常，但如果试图通过这两个方法来增加、删除Arrays$ArrayList 集合里的元素，将会引发异常。
         * 所以上面程序在编译时完全正常，但会在运行时引发UnsupportedOperationException 异常。
         */
    }
}
