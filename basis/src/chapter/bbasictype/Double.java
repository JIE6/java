package chapter.bbasictype;

/**
 * 重点
 * 浮点类型默认是double类型，当然，也可以在一个浮点数后添加d或D后缀， 强制指定是double 类型，但通常没必要。
 *
 * 因为Java 浮点数使用二进制数据的科学计数法来表示浮点数，因此可能不能精确表示一个浮点数。
 * 例如把5.2345556f 值赋给一个float 类型变量，接着输出这个变量时看到这个变量的值已经发生了改变。
 * 使用double 类型的浮点数比float 类型的浮，是数更精确，但如果浮点数的精度足够高(小数点后的数字很多时) ，依然可能发生这种情况。
 * 如果开发者需要精确保存一个浮点数，则可以考虑使用BigDecimal 类
 *
 * 浮点数有两种表示形式。
 * 1.十进制数形式:这种形式就是简单的浮点数，例如5.12 、512.0 、.512 。浮点数必须包含一个小数点，否则会被当成int 类型处理。
 * 2.科学计数法形式:例如5.12e2 (即5.12*10^2， 5.12E2 (也是5.12*10^2)。
 * 必须指出的是，只有浮点类型的数值才可以使用科学计数法形式表示。例如， 51200 是一个int 类型的值， 但512E2 则是浮点类型的值。
 *
 * Java 还提供了三个特殊的浮点数值:正无穷大、负无穷大和非数，用于表示溢出和出错。
 * 例如，使用一个正数除以0 将得到正无穷大，使用一个负数除以0 将得到负无穷大， 0.0 除以0.0 或对一个负数开方将得到一个非数。
 * 正无穷大通过Double 或Float 类的POSITIVE_INFINITY 表示:负无穷大通过Double 或Float 类的NEGATIVE_INFINITY表示，
 * 非数通过Double 或Float 类的NaN 表示。
 *
 * 必须指出的是，所有的正无穷大数值都是相等的，所有的负无穷大数值都是相等的: 而NaN 不与任何数值相等， 甚至和NaN 都不相等。
 *
 * 只有浮点数除以0 才可以得到正无穷大或负无穷大，因为Java 语言会自动把和浮，或数运算的O(整数)当成0.0 (浮点数)处理。如果一个整数值除以0 ，则会抛出一个异常:
 * ArithmeticException: / by zero (除以0 异常)。
 * @author JIE
 */

public class Double {

    public static void main(String[] args) {
        double dLowercase = 0.0d;
        double dUppercase = 0.0D;
        double dNegativeInfinity = java.lang.Double.NEGATIVE_INFINITY;
        float fNegativeInfinity = java.lang.Float.NEGATIVE_INFINITY;
        // 看到float 和double 的负无穷大是相等的
        System.out.println(dNegativeInfinity == fNegativeInfinity);
        // 0.0 除以0.0 将出现非数
        System.out.println(dLowercase == dUppercase);
        // 两个非数之间是不相等的
        System.out.println(dUppercase == java.lang.Double.NaN);
        // 所有正无穷大都是相等的
        System.out.println(1.0 / 0 == 2.0 / 0);
        // 负数除以0.0 得到负无穷大
        System.out.println(-1.0 / 0);
        // 下面代码将抛出除以0 的异常
       // System.out .println(0 / 0);
    }
}
