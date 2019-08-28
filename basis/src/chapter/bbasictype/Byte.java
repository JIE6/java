package chapter.bbasictype;

/**
 * 整数类型默认是int
 * @author JIE
 */

public class Byte {

    public static void main(String[] args) {
        byte bMin = -128;
        byte bMax = 127;
        System.out.println(java.lang.Byte.MIN_VALUE == bMin);
        System.out.println(java.lang.Byte.MAX_VALUE == bMax);
    }
}
