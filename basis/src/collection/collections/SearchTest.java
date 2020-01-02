package collection.collections;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 查找、替换操作
 *
 * Collections 还提供了如下常用的用于查找、替换集合元素的类方法。
 *
 * int binarySearch(List list, Object key): 使用二分搜索法搜索指定的List 集合，以获得指定对象在List集合中的索引。
 * 如果要使该方法可以正常工作，则必须保证List 中的元素己经处于有序状态。
 * Object max(Collection coll): 根据元素的自然顺序，返回给定集合中的最大元素。
 * Object max(Collection coll, Comparator comp): 根据Comparator 指定的顺序，返回给定集合中的最大元素。
 * Object min(Collection coll) : 根据元素的自然顺序，返回给定集合中的最小元素。
 * Object min(Collection coll, Comparator comp): 根据Comparator 指定的顺序，返回给定集合中的最小元素。
 * void fill(List list, Object obj): 使用指定元素obj 替换指定List 集合中的所有元素。
 * int frequency(Collection c, Object o): 返回指定集合中指定元素的出现次数。
 * int indexOfSubList(List source, List target) : 返回子List 对象在父List 对象中第一次出现的位置索引:如果父List 中没有出现这样的子List ，则返回-1
 * int lastIndexOfSubList(List source, List target): 返回子List 对象在父List 对象中最后一次出现的位置索引;如果父List 中没有出现这样的子List ，则返回-1 。
 * boolean replaceAll(List list, Object o ldVal, Object newVal) : 使用一个新值newVal 替换List 对象的所有旧值。oIdVal.
 *
 * 下面程序简单示范了Collections 工具类的用法。
 * @author JIE
 */
public class SearchTest {

    public static void main(String[] args) {
        ArrayList nums = new ArrayList<>();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        // 输出最大元素， 将输出3
        System.out.println(Collections.max(nums));
        // 输出最小元素，将输出-5
        System.out.println(Collections.min(nums));
        // 将nums 中的0 使用1 来代替
        System.out.println(Collections.replaceAll(nums, 0, 1));
        System.out.println(nums);
        // 判断- 5 在List 集合中出现的次数，返回l
        System.out.println(Collections.frequency(nums, -5));
        // 对nums集合排序, 只有排序后的List 集合才可用二分法查询，输出3
        Collections.sort(nums);
        System.out.println(nums);
        System.out.println(Collections.binarySearch(nums, 3));
    }
}
