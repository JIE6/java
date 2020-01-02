package collection.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 排序操作
 *
 * Collections 提供了如下常用的类方法用于对List 集合元素进行排序。
 *
 * void reverse(List list): 反转指定List 集合中元素的顺序。
 * void shuffle(List list): 对List 集合元素进行随机排序(shuffle 方法模拟了"洗牌"动作) 。
 * void sort(List list): 根据元素的自然顺序对指定List 集合的元素按升序进行排序。
 * void sort(List list, Comparator c): 根据指定Comparator 产生的顺序对List 集合元素进行排序。
 * void swap(List list, int i, int j): 将指定List 集合中的i 处元素和j 处元素进行交换。
 * void rotate(List list , int distance): 当distance 为正数时，将list 集合的后distance 个元素"整体"移到前面:
 * 当distance 为负数时，将!ist 集合的前distance 个元素"整体"移到后面。该方法不会改变集合的长度。
 *
 * 下面程序简单示范了利用Collections 工具类来操作List 集合。
 * @author JIE
 */
public class SortTest {

    public static void main(String[] args) {
        ArrayList nums = new ArrayList();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        // 将List 集合元素的次序反转
        Collections.reverse(nums);
        System.out.println(nums);
        // 将List 集合元素按自然顺序排序
        Collections.sort(nums);
        System.out.println(nums);
        // 将List 集合元素按随机顺序排序
        Collections.shuffle(nums);
        System.out.println(nums);
    }
}
