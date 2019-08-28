package chapter.bbasictype;

/**
 * 当程序中用到的数值位数特别多时，眼睛"看花"了都看不清到底有多少位数。
 * 为了解决这种问题， Java 7 引入了一个新功能:程序员可以在数值中使用下画线，
 * 不管是整型数值，还是浮点型数值，都可以自由地使用下画线。通过使用下画线分隔，可以更直观地分辨数值中到底包含多少位
 * @author JIE
 */

public class Underline {

    public static void main(String[] args) {
        int i = 11_22_33;
        int iBinary = 0b1000_1;
        double da = 11_22.33;
        double db = 11.22_33;
    }
}
