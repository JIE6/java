package basictype;

/**
 * 重点
 * 运算符-赋值运算符 与 扩展后的赋值运算符
 * 赋值运算符用于为变量指定变量值，与C类似， Java 也使用=作为赋值运算符。通常，使用赋值运算符将一个直接量值赋给变量。例如如下代码。
 * @author JIE
 */
public class OperatorAssignment {

    public static void main(String[] args) {
        // 为变量str 赋值Java
        String str = " Java";
        //为变量pi赋值3.14
        double pi = 3.14;
        //为变量visited 赋值true
        boolean visited = true;
        // 除此之外，也可使用赋值运算符将一个变量的值赋给另一个变量
        // 将变量str 的值赋给str2
        String str2 = str;
        System.out.println(str);
        System.out.println(pi);
        System.out.println(visited);
        System.out.println(str2);
        /**
         * 按前面关于交量的介绍，可以把交量当成一个可盛装数据的容器。而赋值运算就是将;
         * 被赋的值"装入"变量的过程。赋值运算符是从右向左执行计算的，
         * 程序先计算得到=右边的值，然后将该值"装入" =左边的变量，因此赋值运算符(=)左边只能是变量
         * ------------------------------------------------------------------------------------------------
         * 值得指出的是，赋值表达式是有值的，赋值表达式的值就是右边被赋的值。例如String str2 = 附表达式的值就是str 。
         * 因此，赋值运算符支持连续赋值，通过使用多个赋值运算符，可以一次为多个变量赋值。如下代码
         */
        int a;
        int b;
        int c;
        // 通过为a ， b ， c 赋值， 三个变量的值都是7
        // 虽然Java 支持这种一次为多个变量赋值的写法，但这种写法导致程序的可读性降低，因此不推荐这样写。
        a=b=c=7;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        /**
         * 掌握OperatorBitOperator位运算符与OperatorArithmetic算术运算符后再学习扩展后的赋值运算符
         * 扩展后的赋值运算符
         * 赋值运算符可与算术运算符、位移运算符结合，扩展成功能更加强大的运算符。扩展后的赋值运算符如下。
         * +=: 对应 x += y, 即对应 x = x + y;
         * -=: 对应 x -= y, 即对应 x = x - y;
         * *=: 对应 x *= y, 即对应 x = x * y;
         * /=: 对应 x /= y, 即对应 x = x / y;
         * %=: 对应 x %= y, 即对应 x = x % y;
         * &=: 对应 x &= y, 即对应 x = x & y;
         * |=: 对应 x |= y, 即对应 x = x | y;
         * ^=: 对应 x ^= y, 即对应 x = x ^ y;
         * <<=: 对应 x <<= y, 即对应 x = x << y;
         * >>=: 对应 x >>= y, 即对应 x = x >> y;
         * >>>=: 对应 x >>>= y, 即对应 x = x >>> y;
         */

        /**
         * 三目运算符
         * 三目运算符只有一个 : ?  :  三日运算符的语法格式如下:
         * (expression) ? if-true-statement : if-false-statement;
         */
        int t1 = 5;
        int t2 = 10;
        int t3 = (5 < 10) ? t1++ : t2++;
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
    }
}
