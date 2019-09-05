package basictype;

/**
 * 重点
 * 运算符-逻辑运算符
 * 逻辑运算符用于操作两个布尔型的变量或常量。逻辑运算符主要有如下6 个。
 * &&: 与，前后两个操作数必须都是true 才返回true ， 否则返回false 。
 * &:不短路与，作用与&&相同，但不会短路。
 * || : 或，只要两个操作数中有一个是true ，就可以返回true ，否则返回false 。
 * |: 不短路或，作用与||相同，但不会短路。
 * !: 非，只需要一个操作数，如果操作数为true ，则返回false ; 如果操作数为false ，则返回true 。
 * ^ : 异或，当两个操作数不同时才返回true ，如果两个操作数相同则返回false 。
 * @author JIE
 */
public class OperatorLogic {

    public static void main(String[] args) {
        // 直接对false 求非运算，将返回true
        System.out.println(!false);
        // 5>3 返回true ， '6' 转换为整数54 ， '6'>10 返回true ，求与后返回true
        System.out.println(5 > 3 && '6' > 10) ;
        // 4>=5 返回false ， 'c' > 'a' 返回true 。求或后返回true
        System.out.println(4 >= 511 || 'c' > 'a');
        // 4>=5 返回false ， 'c' > 'a' 返回true 。两个不同的操作数求异或返回true
        System.out.println(4 >= 5 ^ 'c' > 'a' ) ;

        // 对于|与|| 的区别，参见如下代码
        //定义变量a ， b ，并为两个变量赋值
        int a = 5;
        int b = 10;
        //对a > 4 和b++ > 10 求或运算
        if (a > 4 | b++ > 10) {
            // 输出a 的值是5 ， b 的值是11
            System.out.println(a);
            System.out.println(b);
        }
        // 执行上面程序，看到输出a 的值为5 ， b 的值为11， 这表明b++ > 10 表达式得到了计算，但实际上没有计算的必要，
        // 因为a> 4 己经返回了true ，则整个表达式一定返回true 。
        // 再看如下代码，只是将上面示例的不短路逻辑或改成了短路逻辑或
        int c = 5;
        int d = 10;
        if (c > 4 || d++ > 10) {
            System.out.println(c);
            System.out.println(d);
        }
        // 上面代码执行的结果是: C 的值为5 ，而d 的值为10 。
        /*
         * 对比两段代码， 后面的代码仅仅将不短路或改成短路或， 程序最后输出的d 值不再是11，这表明表达式d++ > 10 没有获得执行的机会。
         * 因为对于短路逻辑或||而言，如果第一个操作数返回true ， || 将不再对第二个操作数求值，直接返回true 。不会计算d++> 1 这个逻辑表达式，
         * 因而d++没有获得执行的机会。因此，最后输出的d 值为10 。而不短路或|总是执行前后两个操作数。
         * &与&&的区别与此类似: &，总会计算前后两个操作数，而&&先计算左边的操作数，如果左边的操作数为false ，则直接返回false ，根本不会计算右边的操作数。
         */
    }
}
