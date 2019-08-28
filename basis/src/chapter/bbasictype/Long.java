package chapter.bbasictype;

/**
 * 整数类型默认是int
 * @author JIE
 */

public class Long {

    public static void main(String[] args) {
        long lMin = -9223372036854775808L;
        long lMax = 9223372036854775807L;
        System.out.println(java.lang.Long.MIN_VALUE == lMin);
        System.out.println(java.lang.Long.MAX_VALUE == lMax);
    }
}
