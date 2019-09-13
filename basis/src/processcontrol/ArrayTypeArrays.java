package processcontrol;

import java.util.Arrays;

/**
 * 重点
 * 数组类型-Java的工具类：Arrays
 * Java 提供的Arrays 类里包含的一些static 修饰的方法可以直接操作数组，
 * 这个Arrays 类里包含了如下几个static 修饰的方法( static 修饰的方法可以直接通过类名调用〉。
 *----------------------------------------------------------------------------------------------------------------------------------
 * int binarySearch(type[]， type key): 使用二分法查询key 元素值在a 数组中出现的索引;
 * 如果a数组不包含key 元素值，则返回负数。调用该方法时要求数组中元素己经按升序排列， 这样才能得到正确结果。
 *
 * int binarySearch(type[] a, int fromIndex， int toIndex, type key) : 这个方法与前一个方法类似，
 * 但它只搜索a 数组中fromIndex 到toIndex 索引的元素。调用该方法时要求数组中元素己经按升序排列，这样才能得到正确结果。
 *
 * type[] copyOf(type[] original, int length): 这个方法将会把original 数组复制成一个新数组，
 * 其中length 是新数组的长度。如果length 小于original 数组的长度，则新数组就是原数组的前面length个元素;
 * 如果length 大于original 数组的长度，则新数组的前面元素就是原数组的所有元素，后面补充0 (数值类型)、false (布尔类型)或者null ( 引用类型).
 *
 * type[] copyOfRange(type[] original, int from, int to): 这个方法与前面方法相似，但这个方法只复制original 数组的from 索引到to 索引的元素。
 *
 * boolean equals(type[] a， type[] a2): 如果a 数组和a2 数组的长度相等，而且a 数组和a2 数组的数组元素也一一相同，该方法将返回true 。
 *
 * void fill(type[] a，type val): 该方法将会把a 数组的所有元素都赋值为val 。
 *
 * void fill(type[] a, int fromIndex ， int toIndex, type val): 该方法与前一个方法的作用相同，
 * 区别只是该方法仅仅将a 数组的fromIndex 到toIndex 索引的数组元素赋值为val.
 *
 * void sort(type[] a): 该方法对a 数组的数组元素进行排序。
 *
 * void sort(type[] a, int fromIndex ， int toIndex): 该方法与前一个方法相似， 区别是该方法仅仅对fromIndex 到toIndex 索引的元素进行排序。
 *
 * String toString(type[] a): 该方法将一个数组转换成一个字符串。该方法按顺序把多个数组元素连缀在一起，多个数组元素使用英文逗号(，)和空格隔开。
 *----------------------------------------------------------------------------------------------------------------------------------
 * @author JIE
 */
public class ArrayTypeArrays {

    public static void main(String[] args) {
        int[] iArray = {123, 2, 965, 32, 0, 7};
        // copyOf 通过复制iArray 数组，生成一个新的iArray2 数组
        int[] iArray2 = Arrays.copyOf(iArray, iArray.length);
        // equals iArray-iArray2数组的长度相等，每个元素依次相等， 将输出true
        System.out.println(Arrays.equals(iArray, iArray2));
        // toString 输出iArray2 数组的元素，将输出
        System.out.println(Arrays.toString(iArray2));
        // fill
        Arrays.fill(iArray2, 6);
        System.out.println(Arrays.toString(iArray2));
        // fill
        Arrays.fill(iArray2, 0, 3, 5);
        System.out.println(Arrays.toString(iArray2));
        // binarySearch
        System.out.println(Arrays.binarySearch(iArray2, 5));
        System.out.println(Arrays.binarySearch(iArray2, 6));
        System.out.println(Arrays.binarySearch(iArray2, 8));
        // sort
        Arrays.sort(iArray);
        System.out.println(Arrays.toString(iArray));
    }
}
