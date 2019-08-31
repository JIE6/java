package basictype;

/**
 * 重点
 * 运算符-算术运算符
 * Java 支持所有的基本算术运算符，这些算术运算符用于执行基本的数学运算:加、减、乘、除和求余等。下面程序是7个基本的算术运算符。
 * ------------------------------------------------------------------------------------------------
 * 运算符是一种特殊的符号，用以表示数据的运算、赋值和比较等
 * Java 语言使用运算符将一个或多个操作数连缀成执行性语句，用以实现特定功能。
 * Java 语言中的运算符可分为如下几种。
 * 1.算术运算符
 * 2.赋值运算符
 * 3.比较运算符
 * 4.逻辑运算符
 * 5.位运算符
 * 6.类型相关运算符
 * ------------------------------------------------------------------------------------------------
 * @author JIE
 */
public class OperatorArithmetic {

    public static void main(String[] args) {
        // 加 +
        double da = 3.1;
        double db = 6.5;
        double sum1 = da + db;
        double sum2 = da + 4.2;
        double sum3 = 6 + 5.1;
        System.out.println(sum1);
        System.out.println(sum2);
        System.out.println(sum3);
        // 减 -
        double sub1 = da - db;
        double sub2 = da - 4.2;
        double sub3 = 6 - 5.1;
        System.out.println(sub1);
        System.out.println(sub2);
        System.out.println(sub3);
        // 乘 *
        double multiply1 = da * db;
        double multiply2 = da * 4.2;
        double multiply3 = 6 * 5.1;
        System.out.println(multiply1);
        System.out.println(multiply2);
        System.out.println(multiply3);
        /*
         * 除 /
         * 除法运算符有些特殊，如果除法运算符的两个操作数都是整数类型，则计算结果也是整数， 就是将自然除法的结果截断取整，例如19/4的结果是4 ， 而不是5 。
         * 如果除法运算符的两个操作数都是整数类型，则除数不可以是0 ， 否则将引发除以零异常。
         * 但如果除法运算符的两个操作数有一个是浮点数，或者两个都是浮点数，则计算结果也是浮点数，这个结果就是自然除法的结果。、
         * 而且此时允许除数是0 ， 或者0 .0 ，得到结果是正无穷大或负无穷大。看下面代码。
         */
        double a = 5.2;
        double b = 3.1 ;
        double div = a / b;
        // div 的值将是1.6774193548387097
        System.out.println(div);
        // 输出正无穷大: Infinity
        System.out.println( "5除以0.0的结果是: " + 5/0.0) ;
        // 输出负无穷大: -Infinity
        System.out.println( "-5除以0.0的结果是: " + -5 / 0.0) ;
        // 下面代码将出现异常
        // java.1ang.ArithmeticException : / by zero
        // System.out.println( "-5除以0的结果是:" + -5 / 0)
        /*
         * 求余 %
         * 求余运算的结果不一定总是整数， 它的计算结果是使用第一个操作数除以第二个操作数， 得到一个整除的结果后剩下的值就是余数。
         * 由于求余运算也需要进行除法运算，因此如果求余运算的两个操作数都是整数类型，则求余运算的第二个操作数不能是0 ，否则将引发除以零异常。
         * 如果求余运算的两个操作数中有一个或者两个都是浮点数，则允许第二个操作数是0 或0.0 ，只是求余运算的结果是非数: NaNo 0 或0.0
         * 对零以外的任何数求余都将得到0 或0.0 。看如下程序。
         */
        double mod = a % b;
        // mod 的值为2.1
        System.out.println(mod) ;
        // 输出非数: NaN
        System.out.println( " 5 对0.0 求余的结果是:" + 5 % 0.0) ;
        // 输出非数: NaN
        System.out.println( " -5.0 对0 求余的结果是:" + -5.0 % 0) ;
        //  输出0.0
        System.out.println( " 。对5 . 0 求余的结果是:" + 0 % 5.0) ;
        // 输出非数: NaN
        System.out.println( " 。对0.0 求余的结果是:" + 0 % 0.0) ;
        // 下面代码将出现异常: java.1ang . ArithmeticException : / by zero
        // System.out.println( "- 5 对0 求余的结果是:" + -5 % 0)
        /*
         * 自加 ++
         * 该运算符有两个要点:
         * 1.自加是单目运算符，只能操作一个操作数:
         * 2.自加运算符只能操作单个数值型( 整型、浮点型都行)的变量， 不能操作常量或表达式。
         * 运算符既可以出现在操作数的左边，也可以出现在操作数的右边。但出现在左边和右边的效果是不一样的。
         * 如果把++放在左边，则先把操作数加1，然后才把操作数放入表达式中运算:
         * 如果把++放在右边，则先把操作数放入表达式中运算，然后才把操作数加1。
         * 看如下代码:
         */
        int i1 = 5 ;
        // 让i1先执行算术运算，然后自加
        int i2 = i1++ + 6;
        //输出i1 的值为6 ， i2 的值为11
        System.out.println(i1 + " - " + i2);
        int i3 = 5;
        // 让i3 先自加，然后执行算术运算
        int i4 = ++i3 + 6;
        // 输出i3 的值为6 ， i4 的值为12
        System.out.println(i3 + " - " + i4);
        /*
         * 自减 --
         * 也是单目运算符，用法与++基本相似，只是将操作数的值减1，（故此处就不给出示例了与++基本相似）
         * 自加和自减只能用于操作变量，
         * 不能用于操作数值直接量、常量或表达式。例如， 5++ 、6一等写法都是错误的。
         * ------------------------------------------------------------------------------------------------
         * 扩展
         * Java 并没有提供其他更复杂的运算符，如果需要完成乘方、开方等运算，则可借助于java.lang .Math类的工具方法完成复杂的数学运算，见如下代码。
         */
        double d = 3.2;
        //求d 的5 次方，并将计算结果赋给 dm1
        double dm1 = Math.pow(d , 5);
        System.out.println(dm1);
        //求d 的平方根，并将结果赋给dm2
        double dm2 = Math.sqrt(d);
        System.out.println(dm2);
        //计算随机数，返回一个0 寸之间的伪随机数
        double dou = Math.random();
        System.out.println(dou);
        //求1.57 的sin 函数值: 1.57 被当成弧度数
        double e = Math.sin(1.57);
        System.out.println(e);
        // +除可以作为数学的加法运算符之外，还可以作为字符串的连接运算符。一除可以作为减法运算符之外，还可以作为求负的运算符。
        //定义double 变量X ，其值为-5.0
        double x = -5.0;
        //将x 求负，其值变成5.0
        x = -x;
        System.out.println(x);

    }

}
