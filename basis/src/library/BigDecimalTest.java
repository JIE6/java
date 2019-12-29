package library;

import java.math.BigDecimal;

/**
 * BigDecimal 类
 *
 * 前面在介绍float 、double 两种基本浮点类型时已经指出，这两个基本类型的浮点数容易引起精度丢失
 * 不仅是Java，很多编程语言也存在这样的问题。
 *
 * 为了能精确表示、计算浮点数， Java 提供了BigDecimal 类， 该类提供了大量的构造器用于创建BigDecimal 对象，
 * 包括把所有的基本数值型变量转换成一个BigDecimal 对象，也包括利用数字字符串、数字字符数组来创建BigDecimal 对象。
 *
 * 查看BigDecimal 类的BigDecimal(double val)构造器的详细说明时，可以看到不推荐使用该构造器的说明，
 * 主要是因为使用该构造器时有一定的不可预知性。当程序使用new BigDecimal(O.1)来创建一个BigDecimal 对象时，它的值并不是0.1，
 * 它实际上等于一个近似0.1 的数。这是因为0.1 无法准确地表示为double 浮点数， 所以传入BigDecimal 构造器的值不会正好等于0 .1 (虽然表面上等于该值)。
 *
 * 如果使用BigDecimal(String val)构造器的结果是可预知的, 写入new BigDecimal("O.1")将创建一个BigDecimal. 它正好等于预期的0.1 。
 * 因此通常建议优先使用基于String 的构造器
 *
 * 如果必须使用double 浮点数作为BigDecimal 构造器的参数时，不要直接将该double 浮点数作为构造器参数创建BigDecimal 对象，
 * 而是应该通过BigDecimal.valueOf(double value) 静态方法来创建BigDecimal 对象。
 *
 * BigDecimal 类提供了add()、subtract() 、multiply()、divide()、pow()等方法对精确浮点数进行常规算术运算
 * @author JIE
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal fl = new BigDecimal("0.05");
        BigDecimal f2 = BigDecimal.valueOf(0.01);
        BigDecimal f3 = new BigDecimal(0.05);
        System.out.println("使用String 作为BigDecimal 构造器参数:");
        System.out.println (" 0.05 + 0.01 = " + fl.add(f2));
        System.out.println (" 0.05 - 0.01 = " + fl.subtract(f2));
        System.out.println (" 0.05 * 0.01 = " + fl.multiply(f2));
        System.out.println (" 0.05 / 0.01 = " + fl.divide(f2));
        System.out.println("使用double 作为BigDecimal 构造器参数:");
        System.out.println (" 0.05 + 0.01 = " + f3.add(f2));
        System.out.println (" 0.05 - 0.01 = " + f3.subtract(f2));
        System.out.println (" 0.05 * 0.01 = " + f3.multiply(f2));
        System.out.println (" 0.05 / 0.01 = " + f3.divide(f2));

        /**
         * 从上面运行结果可以看出BigDecimal 进行算术运算的效果， 而且可以看出创建BigDecimal 对象时，
         * 一定要使用String 对象作为构造器参数，而不是直接使用double 数字。
         *
         * 创建BigDecimal 对象时，不要直接使用double 浮点数作为构造器参数来调用BigDecimal 构造器，否则同样会发生精度丢失的问题
         */
    }
}
