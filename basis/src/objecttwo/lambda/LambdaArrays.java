package objecttwo.lambda;

import java.util.Arrays;

/**
 * 使用Lambda 表达式调用Arrays 的类方法
 * @author JIE
 */
public class LambdaArrays {

    public static void main(String[] args) {
        String[] arr1 = {" java" , " fkava" , "fkit " , " ios" , "android" };
        Arrays.parallelSort(arr1 , (o1,o2) -> o1.length() - o2.length());
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = new int[]{3 , - 4 , 25 , 16 , 30 , 18};
        // left 代表数组中前一个索引处的元素，计算第一个元素肘， left 为1
        // right 代表数组中当前索引处的元素
        Arrays.parallelPrefix(arr2 , (left , right)-> left * right) ;
        System. out.println(Arrays.toString(arr2)) ;

        long[] arr3 = new long[5];
        // operand 代表正在计算的元素索引
        Arrays .parallelSetAll(arr3 , operand -> operand * 5);
        System . out.println(Arrays . toString(arr3));
    }
}
