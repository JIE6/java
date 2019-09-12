package processcontrol;

/**
 * 重点
 * 数组类型-使用
 * 数组最常用的用法就是访问数组元素，包括对数组元素进行赋值和取出数组元素的值。访问数组元
 * 素都是通过在数组引用变量后紧跟一个方括号( [] ) ， 方括号里是数组元素的索引值， 这样就可以访问
 * 数组元素了。访问到数组元素后，就可以把一个数组元素当成一个普通变量使用了， 包括为该变量赋值
 * 和取出该变量的值， 这个变量的类型就是定义数组时使用的类型。
 * Java 语言的数组索引是从0 开始的， 也就是说， 第一个数组元素的索引值为0 ， 最后一个数组元素
 * 的索引值为数组长度减1 。下面代码示范了输出数组元素的值， 以及为指定数组元素赋值
 * @author JIE
 */
public class ArrayType {

    public static void main(String[] args) {
        /**
         * 静态数组的两种定义与初始化
         */
        int[] ia1;
        ia1 = new int[] {1, 2, 3, 4, 5};
        int[] in2 = {6, 7, 8, 9, 10};

        /**
         * 动态数组的两种定义与初始化
         */
        boolean[] ba1;
        ba1 = new boolean[4];
        boolean[] ba2 = new boolean[4];
        /**
         * 使用数组
         */
        String[] strA = {"JA", "V", "A", "牛", "逼啊！"};
        // 输出strA 数组的第一个元素，将输出字符串" JA"
        System.out.println(strA[0]);
        // 为strA 的第一个数组元素重新赋值
        strA[0] = "J2";
        /**
         * 如果访问数组元素时指定的索引值小于0 ， 或者大于等于数组的长度，编译程序不会出现任何错误，
         * 但运行时出现异常: java.lang.ArrayIndexOutOtBoundsException: N ( 数组索引越界异常) ， 异常信息后的
         * N 就是程序员试图访问的数组索引。
         * System.out.println(strA[5])
         */

        /**
         * 所有的数组都提供了一个length 属性，通过这个属性可以访问到数组的长度， 一旦获得了数组的长
         * 度，就可以通过循环来遍历该数组的每个数组元素。
         */
        // 使用循环输出strA 数组的每个数组元素的值
        for (int i = 0; i < strA.length; i++) {
            System.out.print(strA[i]);
        }
        System.out.println();
        /**
         * foreach 循环
         * 从Java 5 之后， Java 提供了一种更简单的循环: foreach 循环，这种循环遍历数组和集合更加简洁。
         * 使用foreach 循环遍历数组和集合元素时，无须获得数组和集合长度，无须根据索引来访问数组元素和集合元素，
         * foreach 循环自动遍历数组和集合的每个元素。
         * foreach 循环的语法格式如下:
         * for(type variableName : array | collection) {
         *    variableName 自动态代访问每个元素.. .
         * }
         */
        for (String str : strA) {
            System.out.print(str);
        }
        System.out.println();

    }
}
