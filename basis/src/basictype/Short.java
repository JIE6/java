package basictype;

/**
 * 整数类型默认是int
 * @author JIE
 */

public class Short {

    public static void main(String[] args) {
        short sMin = -32768;
        short sMax = 32767;
        System.out.println(java.lang.Short.MIN_VALUE == sMin);
        System.out.println(java.lang.Short.MAX_VALUE == sMax);
    }
}
