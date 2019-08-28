package chapter.bbasictype;

/**
 * 重点
 * Char类型值有如下四种表示形式。
 * 1.直接通过单个字符来指定字符型值，例如'A' 、'9'和'0'等。
 * 2.通过转义字符表示特殊字符型值，例如'\n' 、'\t' 等。
 * 3.直接使用Unicode 值来表示字符型值，格式是'\u0000' ，其中0000代表一个十六进制的整数。
 *  其中前256 个('\u0000'~'\u00FF') 字符和ASCII 码中的字符完全重舍
 * 4.如果把0-65535 范围内的一个int 整数赋给char 类型变量，系统会自动把这个int 整数当成char 类型来处理
 * @author JIE
 */

public class Char {

    public static void main(String[] args) {
        char cString = 'A';
        char cEscape = '\n';
        char cUnicodeMin = '\u0000';
        char cUnicodeMax = '\uFFFF';
        char cIntMin = 0;
        char cIntAscllMax = 256;
        char cIntMax = 65535;
        System.out.println(cString);
        System.out.println(cEscape);
        System.out.println(cUnicodeMin);
        System.out.println(cUnicodeMax);
        System.out.println(cIntMin);
        System.out.println(cIntAscllMax);
        System.out.println(cIntMax);
    }
}
