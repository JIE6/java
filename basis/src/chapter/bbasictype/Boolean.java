package chapter.bbasictype;

/**
 * 布尔型只有一个boolean 类型，用于表示逻辑上的"真"或"假"。
 * 在Java 语言中， boolean 类型的数值只能是true 或false ，不能用。或者非0 来代表。其他基本数据类型的值也不能转换成boolean 类型。
 * boolean 类型的值或变量主要用做旗标来进行流程控制， Java 语言中使用boolean 类型的变量或值控制的流程主要有如下几种。
 * 1.if 条件控制语句
 * 2.while 循环控制语句
 * 3.do while 循环控制语句
 * 4.for 循环控制语句
 * 除此之外， boolean 类型的变量和值还可在三目运算符( ? : )中使用
 * @author JIE
 */
public class Boolean {

    public static void main(String[] args) {
        boolean bTrue = true;
        boolean bFalse = false;
        System.out.println(bTrue);
        System.out.println(bFalse);
    }
}
