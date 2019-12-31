package collection.set;

import objecttwo.enums.SeaSonEnum;

import java.util.*;

/**
 * EnumSet 类
 *
 * EnumSet 是一个专为枚举类设计的集合类， EnumSet 中的所有元素都必须是指定枚举类型的枚举值，该枚举类型在创建EnumSet 时显式或隐式地指定。EnumSet 的集合元素也是有序的，
 * EnumSet 以枚举值在Enum 类内的定义顺序来决定集合元素的顺序。
 *
 * EnumSet 在内部以位向量的形式存储，这种存储形式非常紧凑、高效，因此EnumSet 对象占用内存很小，而且运行效率很好。尤其是进行批量操作(如调用containsAll() 和retainAll()方法〉时，
 * 如果其参数也是EnumSet 集合，则该批量操作的执行速度也非常快。
 *
 * EnumSet 集合不允许加入null 元素，如果试图插入null 元素， EnumSet 将抛出NullPointerException异常。如果只是想判断EnumSet 是否包含null 元素或试图删除null 元素都不会抛出异常，
 * 只是删除操作将返回false ，因为没有任何null 元素被删除。
 *
 * EnumSet 类没有暴露任何构造器来创建该类的实例，程序应该通过它提供的类方法来创建EnumSet对象。EnumSet 类它提供了如下常用的类方法来创建EnumSet 对象。
 * EnumSet allOf(Class elementType): 创建一个包含指定枚举类里所有枚举值的EnumSet 集合。
 * EnumSet complementOf(EnumSet s): 创建一个其元素类型与指定EnumSet 里元素类型相同的EnumSet 集合，新EnumSet 集合包含原EnumSet 集合所不包含的、
 * 此枚举类剩下的枚举值(即新EnumSet 集合和原EnumSet 集合的集合元素加起来就是该枚举类的所有枚举值)。
 * EnumSet copyOf(Collection c): 使用一个普通集合来创建EnumSet 集合。
 * EnumSet copyOf(EnumSet s): 创建一个与指定EnumSet 具有相同元素类型、相同集合元素的EnumSet 集合。
 * EnumSet noneOf(Class elementType): 创建一个元素类型为指定枚举类型的空EnumSet 。
 * EnumSet of(E first, E... rest): 创建一个包含一个或多个枚举值的EnumSet 集合，传入的多个枚举值必须属于同一个枚举类。
 * EnumSet range(E from, E to): 创建一个包含从from 枚举值到to 枚举值范围内所有枚举值的EnumSet 集合。
 *
 * 下面程序示范了如何使用EnumSet 来保存枚举类的多个枚举值。
 * @author JIE
 */
public class EnumSetTest {

    public static void main(String[] args) {
        // 创建一个EnumSet 集合， 集合元素就是Season 枚举类的全部枚举值
        EnumSet<SeaSonEnum> es1 = EnumSet.allOf(SeaSonEnum.class);
        System.out.println(es1);
        // 创建一个EnumSet 空集合，指定其集合元素是Season 类的枚举值
        EnumSet<SeaSonEnum> es2 = EnumSet.noneOf(SeaSonEnum.class);
        System.out.println(es2);
        // 手动添加两个元素
        es2.add(SeaSonEnum.WINTER);
        es2.add(SeaSonEnum.SPRING);
        System.out.println(es2);
        // 以指定枚举值创建EnumSet 集合
        EnumSet<SeaSonEnum> es3 = EnumSet.of(SeaSonEnum.SUMMER, SeaSonEnum.WINTER);
        System.out.println(es3);
        // 创建从SUMMER 到 WINTER 范围类的所有枚举
        EnumSet<SeaSonEnum> es4 = EnumSet.range(SeaSonEnum.SUMMER, SeaSonEnum.WINTER);
        System.out.println(es4);
        // 创建 es4 之外的所有枚举， es5 集合元素+ es4 集合元素= Season 枚举类的全部枚举值
        EnumSet<SeaSonEnum> es5 = EnumSet.complementOf(es4);
        System.out.println(es5);

        /**
         * 上面程序中粗体字标识的代码示范了EnumSet 集合的常规用法。除此之外，还可以复制另一个EnumSet 集合中的所有元素来创建新的EnumSet 集合，
         * 或者复制另一个Collection 集合中的所有元素来创建新的EnumSet 集合。当复制Collection 集合中的所有元素来创建新的EnumSet集合时，要求Collection
         * 集合中的所有元素必须是同一个枚举类的枚举值。下面程序示范了这个用法。
         */
        Collection c = new HashSet();
        c.add(SeaSonEnum.FALL);
        c.add(SeaSonEnum.SPRING);
        // 复制Collection 集合中的所有元素来创建EnumSet 集合
        EnumSet enumSet = EnumSet.copyOf(c);
        System.out.println(enumSet);
        c.add("aaa");
        c.add("bbb");
        // 下面代码出现异常: 因为c 集合里的元素不是全部都为枚举值
        EnumSet.copyOf(c);
    }
}
