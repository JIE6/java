package processcontrol;

/**
 * 重点
 * while 循环语句
 * 循环语句可以在满足循环条件的情况下，反复执行某一段代码，这段被重复执行的代码被称为循环体。
 * 当反复执行这个循环体时， 需要在合适的时候把循环条件改为假，从而结束循环， 否则循环将一直
 * 执行下去， 形成死循环。循环语句可能包含如下4 个部分。
 *
 * 1.初始化语句( init statement ) : 一条或多条语句，这些语句用于完成一些初始化工作， 初始化语
 * 句在循环开始之前执行。
 * 2.循环条件( test expression ) : 这是一个boolean 表达式，这个表达式能决定是否执行循环体。
 * 3.循环体( body_ statement ) : 这个部分是循环的主体，如果循环条件允许，这个代码块将被重复执行。
 * 如果这个代码块只有一行语句，则这个代码块的花括号是可以省略的（但不推荐去掉）。
 * 4.法代语句( iteration statement ) : 这个部分在一次循环体执行结束后， 对循环条件求值之前执行，
 * 通常用于控制循环条件中的变量， 使得循环在合适的时候结束。
 *
 * 上面4 个部分只是一般性的分类， 并不是每个循环中都非常清晰地分出了这4 个部分。
 *
 * while 循环的语法格式如下:
 * [init statement]
 * while(test expression) {
 *     statement;
 *     [iteration statement]
 * }
 *
 * while 循环每次执行循环体之前， 先对test express ion 循环条件求值， 如果循环条件为true ，则运
 * 行循环体部分。从上面的语法格式来看，迭代语句iteration statement 总是位于循环体的最后， 因此只
 * 有当循环体能成功执行完成时， while 循环才会执行iteration statement 迭代语句。
 * 从这个意义上来看， while 循环也可被当成条件语句一一如果test_expression 条件一开始就为false ，
 * 则循环体部分将永远不会获得执行
 * @author JIE
 */
public class WhileProcess {

    public static void main(String[] args) {
        // 循环的初始化条件
        int cont = 0;
        // 当count 小于10 时，执行循环体
        while (cont < 10) {
            System.out.println(cont);
            // 迭代语句
            cont++;
        }
        System.out.println("循环结束");

        /*
         * 使用while 循环时， 一定要保证循环条件有变成false 的时候，否则这个循环将成为一个死循环，
         * 永远无法结束这个循环。例如如下代码
         */
        cont = 0;
        while (cont < 10) {
            System.out.println("不停的执行死循环" + cont);
            // 迭代语句
            cont--;
        }
        System.out.println("永远不会结束的循环");



    }
}
