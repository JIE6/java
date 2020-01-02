package collection.collections;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/**
 * 烦琐的接口: Enumeration
 *
 * Enumeration 接口是Iterator 法代器的"古老版本"，从JDK 1.0 开始， Enumeration 接口就己经存在了
 * (Iterator 从JDK 1.2 才出现) 0 Enumeration 接口只有两个名字很长的方法。
 *
 * boolean hasMoreElements():如果此法代器还有剩下的元素， 则返回true 。
 * Object nextElement():返回该迭代器的下一个元素， 如果还有的话(否则抛出异常)。
 *
 * 通过这两个方法不难发现， Enumeration 接口中的方法名称冗长，难以记忆，而且没有提供Iterator的remove()方法。
 * 如果现在编写Java 程序，应该尽量采用Iterator 迭代器，而不是用Enumeration 法代器。
 *
 * Java 之所以保留Enumeration 接口， 主要是为了照顾以前那些"古老"的程序，那些程序里大量使用了Enumeration 接口，
 * 如果新版本的Java 里直接删除Enumeration 接口，将会导致那些程序全部出错。
 *
 * 在计算机行业有一条规则:加入任何规则都必须慎之又慎，因为以后无法删除规则。
 *
 * 实际上， 前面介绍的Vector (包括其子类Stack) 、Hashtable 两个集合类，以及另一个极少使用的BitSet ，
 * 都是从JDK 1.0 遗留下来的集合类，而Enumeration 接口可用于遍历这些"古老"的集合类。对于ArrayList 、HashMap 等集合类，
 * 不再支持使用Enumeration 迭代器。
 *
 * 下面程序示范了如何通过Enumeration 接口来法代Vector 和Hashtable 。
 *
 * @author JIE
 */
public class EnumerationTest {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add("疯狂Java 讲义");
        v.add("轻量级Java EE 企业应用实战");

        Hashtable scores = new Hashtable();
        scores.put("语文", 78);
        scores.put("数学", 88);

        Enumeration em = v.elements();
        while (em.hasMoreElements()) {
            System.out.println(em.nextElement());
        }

        Enumeration keyEm = scores.keys();
        while (keyEm.hasMoreElements()) {
            Object key = keyEm.nextElement();
            System.out.println(key + "->" + scores.get(key));
        }

        /**
         * 上面程序使用Enumeration 迭代器来遍历Vector 和Hashtable 集合里的元素，其工作方式与Iterator迭代器的工作方式基本相似。
         * 但使用Enumeration 迭代器时方法名更加冗长，而且Enumeration 迭代器只能遍历Vector 、Hashtable 这种古老的集合，
         * 因此通常不要使用它。除非在某些极端情况下， 不得不使用Enumeration ，否则都应该选择Iterator 迭代器。
         * ‘
         */
    }
}
