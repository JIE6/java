package chapter.bbasictype;

/**
 * 重点
 * 1.整数类型默认是int
 * 2.如果直接将一个较小的整数值(在byte 或short 类型的表数范围内〉赋给一个byte 或short 变量，系统会自动把这个整数值当成byte 或者short 类型来处理
 * 3.如果使用一个巨大的整数值(超出了int 类型的表数范围)时， Java 不会自动把这个整数值当成long 类型来处理。
 * 如果希望系统把一个整数值当成long 类型来处理，应在这个整数值后增加l或者L 作为后缀。通常推荐使用L ，因为英文字母l 很容易跟数字l 搞混。
 * @author JIE
 */

public class Int {

    public static void main(String[] args) {
        int iMin = -2147483648;
        int iMax = 2147483647;
        System.out.println(java.lang.Integer.MIN_VALUE == iMin);
        System.out.println(java.lang.Integer.MAX_VALUE == iMax);
        // 十进制数字17 分别在2 8 10 16 进制下的表示
        int iBinaryLowercase = 0b10001;
        int iBinaryUppercase = 0B10001;
        int iOctal = 021;
        // 二进制结果 0b10001 转10进制方法 0*2^0 + 0*2^1 + 0*2^2 + 0*2^3 + 1*2^4
        int iDecimal = 17;
        int iHexLowercase = 0x11;
        int iHexUppercase = 0X11;
        System.out.println(iBinaryLowercase);
        System.out.println(iBinaryUppercase);
        System.out.println(iOctal);
        System.out.println(iDecimal);
        System.out.println(iHexLowercase);
        System.out.println(iHexUppercase);
    }
}
