package processcontrol;

/**
 * 重点
 * do while 循环结构
 * do while 循环与while 循环的区别在于: while 循环是先判断循环条件， 如果条件为真则执行循环体;
 * 而do while 循环则先执行循环体， 然后才判断循环条件，如果循环条件为真，则执行下一次循环，否则
 * 中止循环。do while 循环的语法格式如下:
 *
 * [init statement)
 * do {
 *  statement
 *  [iteration statement]
 * }while (test expression);
 * 与while 循环不同的是， do while 循环的循环条件后必须有一个分号，这个分号表明循环结束。
 * 下面程序示范了do while 循环的用法
 * @author JIE
 */
public class DoWhileProcess {

    public static void main(String[] args) {
        // 定义变量count
       int cont = 1;
        // 执行do while 循环
       do {
           System.out.println(cont);
           // 循环迭代语句
           cont++;
           // 循环条件紧跟while 关键字
       }while (cont < 10);

       // 即使test_expression循环条件的值开始就是假. do while 循环也会执行循环体。因此. do while 循环的循环体至少执行一次。下面的代码片段验证了这个结论
        cont = 20;
        do {
            System.out.println(cont);
            // 循环迭代语句
            // 循环条件紧跟while 关键字
        }while (cont == 10);
        // 从上面程序来看，虽然开始count 的值就是20. count == 10 表达式返回false. 但do while 循环还是会把循环体执行一次。
    }
}
