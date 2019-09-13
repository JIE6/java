package processcontrol;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;
import java.util.function.IntUnaryOperator;

/**
 * 重点
 * 数组类型-Java8增强的工具类：Arrays
 * 由于计算机硬件的飞速发展， 目前几乎所有家用PC 都是4 核、8 核的 CPU， 而服务器的CPU 则具有更好的性能，
 * 因此Java 8 与时俱进地增加了并发支持，并发支持可以充分利用硬件设备来提高程序的运行性能。
 *----------------------------------------------------------------------------------------------------------------------------------
 * void parallelPrefix(xxx[] array, XxxBinaryOperator op): 该方法使用op 参数指定的计算公式计算得到的结果作为新的元素。
 * op 计算公式包括left right 两个形参，其中left代表数组中前一个索引处的元素， right 代表数组中当前索引处的元素，
 * 当计算第一个新数组元素时， left的值默认为1 。
 *
 * void parallelPrefix(xxx[] array， int fromIndex， int toIndex, XxxBinaryOperator op): 该方法与上一个方法相似，
 * 区别是该方法仅重新计算fromIndex 到toIndex 索引的元素。
 *
 * void setAll(xxx[] array, IntToXxxFunction generator): 该方法使用指定的生成器(generator) 为所
 * 有数组元素设置值，该生成器控制数组元素的值的生成算法。
 *
 * void parallelSetAll(xxx[] array, IntToXxxFunction generator): 该方法的功能与上一个方法相同，只
 * 是该方法增加了并行能力，可以利用多CPU 并行来提高性能。
 *
 * void parallelSort(xxx[] a): 该方法的功能与Arrays 类以前就有的sort()方法相似，只是该方法增加了并行能力，可以利用多CPU 并行来提高性能。
 *
 * Spliterator.OfXxx spliterator(xxx[] array): 将该数组的所有元素转换成对应的Spliterator 对象。
 *
 * Spliterator.OfXxx spliterator(xxx[] array, int startInclusive, int endExclusive): 该方法与上一个方法
 * 相似，区别是该方法仅转换startInclusive 到endExclusive 索引的元素。
 *
 * XxxStream stream(xxx[] array): 该方法将数组转换为Stream ， Stream 是Java 8 新增的流式编程的API。
 *
 * XxxStream stream(xxx[] array, int startInclusive, int endExclusive): 该方法与上一个方法相似，
 * 区别是该方法仅将fromIndex 到toIndex 索引的元素转换为Stream 。
 *----------------------------------------------------------------------------------------------------------------------------------
 * 上面方法列表中，所有以parallel 开头的方法都表示该方法可利用CPU 并行的能力来提高性能。上面方法中的xxx
 * 代表不同的数据类型，比如处理int[] 型数组时应将xxx 换成int ，处理long[] 型数组时应将xxx 换成long 。
 *
 * @author JIE
 */
public class ArrayType8Arrays {

    public static void main(String[] args) {
        int[] arr1 = {1, -2, 48, -5, 0, 545, -6};
        // parallelSort 对数组arr1 进行并发排序 fromIndex(包括)到索引toIndex(不包括)。
        Arrays.parallelSort(arr1, 0, arr1.length);
        System.out.println(Arrays.toString(arr1));

        /**
         * parallelPrefix
         * 计算之前的数组为 [-6, -5, -2, 0, 1, 48, 545]
         * 计算公式为 left * right
         * 计算新的数组元素的方式为:
         * 1*-6=-6， -6*-5=30， 30*-2=-60， -5*0=0， 0*1=0， 0*48=0， 0*545=0
         * 所以新的数组为 [-6, 30, -60, 0, 0, 0, 0]
         */

        Arrays.parallelPrefix(arr1, new IntBinaryOperator() {
            // 1eft 代表数组中前一个索引处的元素，计算第一个元素时， 1eft 为l
            // right 代表数组中当前索引处的元素
            @Override
            public int applyAsInt(int left, int right) {
                return left * right;
            }
        });
        System.out.println(Arrays.toString(arr1));

        int[] arr3 = new int[5];
        /**
         * parallelSetAll
         * 使用operand * 5 公式来设置数组元素，该公式中operand 代表正在计算的数组元
         * 素的索引。因此代码计算得到的数组为:
         * [0, 5, 10, 15, 20]
         *
         */
        Arrays.parallelSetAll(arr3, new IntUnaryOperator() {
            // operand 代表正在计算的元素索引
            @Override
            public int applyAsInt(int operand) {
                return operand * 5;
            }
        });
        System.out.println(Arrays.toString(arr3));

        /**
         * 上面的代码都可以使用Lambda 达式进行简化，关于Lambda 表达式后面会有
         */
    }
}
