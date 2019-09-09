package processcontrol;

/**
 * 重点
 * Java 7 增强后的switch 分支语旬
 * switch 语句由一个控制表达式和多个case 标签组成，和if 语句句不同的是， switch 语句后面的控制
 * 表达式的数据类型只能是byte 、short 、char 、int 四种整数类型，
 * 枚举类型和java.lang.String 类型(从Java7 才允许) ，不能是boolean 类型。
 * switch 语句往往需要在case 标签后紧跟一个代码块， case 标签作为这个代码块的标识。switch 语句的语法格式如下:
 *------------------------------------------------------------------------
 * switch(expression) {
 *  case condition1: {
 *      statement(s);
 *      break;
 *  }case condition2: {
 *      statement(s);
 *      break;
 *  }case conditionN: {
 *      statement(s);
 *      break;
 *  }default {
 *      statement(s);
 *  }
 * }
 * ------------------------------------------------------------------------
 * 这种分支语句的执行是先对expression 求值，然后依次匹配condition1 、condition2 ， … 、conditionN
 * 等值，遇到匹配的值即执行对应的执行体;如果所有case 标签后的值都不与expression 表达式的值相等，
 * 则执行default 标签后的代码块。
 *
 * 和if语句不同的是， switch 语句中各case 标签后代码块的开始点和结束点非常清晰，因此完全可
 * 以省略case 后代码块的花括号。与if 语句中的else 类似， switch 语句中的default 标签看似没有条件，
 * 其实是有条件的，条件就是expression 表达式的值不能与前面任何一个case 标签后的值相等。
 * ------------------------------------------------------------------------
 * 使用switch 语句时，有两个值得注意的地方:第一个地方是switch 语句后的expression
 * 表达式的数据类型只能是byte 、short 、char 、int 四种整数类型， String (Java 7 才支持)
 * 和枚举类型;第二个地方是如果省咯了case 后代码块的break ; ，将引入一个陷阱。
 *
 * @author JIE
 */
public class SwitchProcess {

    public static void main(String[] args) {
        char b = 'b';
        switch (b) {
            case 'a': {
                System.out.println("A等");
                break;
            } case 98: {
                System.out.println("B等");
                break;
            } case 'c': {
                System.out.println("C等");
                break;
            } default:{
                System.out.println("unknown");
            }
        }
        /**
         * 运行上面程序，看到输出"B等"，这个结果完全正常，字符表达式score 的值为'b' ，对应结果为"B等"。
         * 在case 标签后的每个代码块后都有一条break;语句，这个break;语句有极其重要的意义， Java 的
         * switch 语句允许case 后代码块没有break:语句， 但这种做法可能引入一个陷阱。如果把上面程序中的
         * break;语句都注释掉，将看到如下运行结果:
         * B等
         * C等
         * unknown
         *
         * 这个运行结果看起来比较奇怪，但这正是由switch 语句的运行流程决定的: switch 语句会先求出
         * express lOn 表达式的值，然后拿这个表达式和case 标签后的值进行比较， 一旦遇到相等的值，程序就开
         * 始执行这个case 标签后的代码，不再判断与后面case 、default 标签的条件是否匹配，除非遇到break;
         * 才会结束。
         */
        // Java 7 才支持 string
        String season = "春天";
        switch (season) {
            case "春天": {
                System.out.println("春天");
                break;
            } case "冬天": {
                System.out.println("冬天");
                break;
            } default:{

            }
        }



    }
}
