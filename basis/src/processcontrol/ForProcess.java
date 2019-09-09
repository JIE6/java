package processcontrol;

/**
 * 重点
 * for 循环结构
 * for 循环是更加简洁的循环语句，大部分情况下. for 循环可以代替while 循环、do while 循环。for循环的基本语法格式如下:
 *
 * for ([iteration statement] ; [test_expression) ; [iteration statement]) {
 *     statement
 * }
 *
 * 程序执行for 循环时，先执行循环的初始化语句init statement. 初始化语句只在循环开始前执行一次。
 * 每次执行循环体之前，先计算test_expression 循环条件的值，如果循环条件返回true. 则执行循环体，
 * 循环体执行结束后执行循环迭代语句。因此，对于for 循环而言，循环条件总比循环体要多执行一次，
 * 因为最后一次执行循环条件返回false. 将不再执行循环体。
 * 值得指出的是. for 循环的循环迭代语句并没有与循环体放在一起，因此即使在执行循环体时遇到continue 语句结束本次循环，循环法代语句也一样会得到执行。
 *
 * 注意：
 * for 循环和while 、do while 循环不一样:由于while 、do while 循环的循环选代语句紧
 * 跟着循环休，因此如果循环体不能完全执行，如使用continue 语句来结束本次循环，则循
 * 环迭代语句不会被执行。但for 循环的循环迭代语句并没有与循环体放在一起，因此不管
 * 是否使用continue 语句来结束本次循环，循环迭代语句一样会获得执行。
 * @author JIE
 */
public class ForProcess {

    public static void main(String[] args) {
        // 循环的初始化条件、循环条件、循环迭代语句都在下面一行
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        System.out.println("循环结束");

        /**
         * 在上面的循环语句中， for 循环的初始化语句只有一个，循环条件也只是一个简单的boolean 表达式。
         * 实际上， for 循环允许同时指定多个初始化语句，循环条件也可以是一个包含逻辑运算符的表达式。
         * 例如如下程序:
         */
        for (
                int b = 0 , s = 0 , p = 0;
                b < 10 && s < 4 && p < 10;
                p++
        ) {
            System.out.println(b++);
            System.out.println(++s+p);
            System.out.println("--------------------------------------");
        }
        /**
         * 上面代码中初始化变量有三个，但是只能有一个声明语句，因此如果需要在初始化表达式中声明多
         * 个变量， 那么这些变量应该具有相同的数据类型。
         */

        /**
         * 死循环
         * for 循环圆括号中只有两个分号是必需的， 初始化语句、循环条件、迭代语句部分都是可以省略的，
         * 如果省略了循环条件，则这个循环条件默认为true ，将会产生一个死循环。例如下面程序。
         *         for (; ;) {
         *             System.out.println("死循环")
         *         }
         */

        /**
         * 嵌套循环
         */
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                System.out.println(i);
                System.out.println(i1);
                System.out.println("=============================================");
            }
        }

        /**
         * 使用break 结束循环
         * break 语句默认结束其所在的循环
         */
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (i1 == 0) {
                    System.out.println(i);
                    System.out.println("***********************************************");
                    break;
                }
                System.out.println(i1);

            }
        }

        /**
         * break 语句不仅可以结束其所在的循环， 还可以直接结束其外层循环。此时需要在break 后紧跟一
         * 个标签，这个标签用于标识一个外层循环。
         */
        outerBreak:
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (i1 == 0) {
                    System.out.println(i);
                    System.out.println("******------------------------------*********");
                    break outerBreak;
                }
                System.out.println(i1);

            }
        }
        /**
         * 使用continue 忽略本次循环剩下语句
         * continue 的功能和break 有点类似，区别是continue 只是忽略本次循环剩下语句，接着开始下一次
         * 循环，并不会终止循环:而break 则是完全终止循环本身。
         */
        for (int i = 0; i < 2; i++) {
            for (int i1 = 0; i1 < 3; i1++) {
                if (i1 == 0) {
                    System.out.println(i);
                    System.out.println("******================================*****");

                    // 忽略本次循环的剩下语句
                    continue;
                }
                System.out.println("i1 == 0 时被忽略i1=" + i1);
            }
        }
        System.out.println("...........................................................");
        /**
         *与break 类似的是， continue 后也可以紧跟一个标签，用于直接跳过标签所标识循环的当次循环的
         * 剩下语句，重新开始下一次循环。例如下面代码。
         */
        outerContinue:
        for (int in = 0; in < 3; in++) {
            for (int i = 0; i < 5; i++) {
                for (int i1 = 0; i1 < 3; i1++) {
                    System.out.println(in + " " + i + " " + i1);
                    if (i1 == 1) {
                        continue outerContinue;
                    }
                    System.out.println(in + " " + i + " " + i1);
                }
            }
        }

        /**
         * 使用return 结束方法
         * return 关键宇并不是专门用于结束循环的， return 的功能是结束一个方法。当一个方法执行到一个
         * return语句时(return 关键宇后还可以跟变量、常量和表达式，这将在方法介绍中有更详细的解释)，这
         * 个方法将被结束。
         */
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            if (i == 1) {
                return;
            }
        }


    }
}
