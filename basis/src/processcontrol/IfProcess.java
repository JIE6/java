package processcontrol;

/**
 * 重点
 * if 条件语旬
 * if 语句使用布尔表达式或布尔值作为分支条件来进行分支控制。if 语句有如下三种形式。
 * ------------------------------------------------------------------------
 * 1.   if ( logic expression ) {
 *              statement...
 *       }
 *------------------------------------------------------------------------
 * 2.   if ( logic expression ) {
 *              statement...
 *      }else {
 *              statement...
 *      }
 *------------------------------------------------------------------------
 * 3.   if ( logic expression ) {
 *              statement...
 *          // 可以有零个或多个else if 语句
 *      }else if( logic expression ) {
 *              statement...
 *          //  最后的else 语句也可以省略
 *      }else {
 *              statement...
 *      }
 *------------------------------------------------------------------------
 * 在上面if 语句的三种形式中，放在if 之后括号里的只能是一个逻辑表达式，即这个表达式的返回值只能是true 或false 。
 * 第二种形式和第三种形式是相通的，如果第三种形式中else if 块不出现，就变成了第二种形式。
 * 在上面的条件语句中， if (logic expression) 、else if (logic expression)和else 后花括号括起来的多行代码被称为代码块，
 * 一个代码块通常被当成一个整体来执行(除非运行过程中遇到return 、break 、continue等关键字，或者遇到了异常) ，因此这个代码块也被称为条件执行体
 * @author JIE
 */
public class IfProcess {

    public static void main(String[] args) {
        int age = 30;
        // 只有当age > 20 时，下面花括号括起来的代码块才会执行.花括号括起来的语句是一个整体，要么一起执行，要么一起不执行
        if (age > 20) {
            System.out.println( " 年龄已经大于20 岁了" ) ;
            System.out.println( " 20 岁以上的人应该学会承担责任... " );
        }

        /*
         * 如果if (logic expression) 、else if (logic expression)和else 后的代码块只有一行语句时，则可以省略花括号，
         * 因为单行语句本身就是一个整体，无须用花括号来把它们定义成一个整体。下面代码完全可以正常执行
         * 但强烈不推荐这种写法。影响可读性，且限制了statement里的代码块只能有一行
         * int a = 5;
            if (a > 4)
                System.out.println( " a 大于 4" ) ;
            else
                System.out.println( " a 不大于 4" ) ;
         */
        // 使用if... else 语句时， 一定要先处理包含范围史小的情况。


        }
}
