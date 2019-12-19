package objecttwo.lambda;

import javax.swing.*;

/**
 * 方法引用与构造器引用
 *
 * 前面己经介绍过，如果Lambda 表达式的代码块只有一条代码，程序就可以省略Lambda 表达式中代码块的花括号。
 * 不仅如此，如果Lambda 表达式的代码块只有一条代码，还可以在代码块中使用方法引用和构造器引用。
 * 方法引用和构造器引用可以让Lambda 表达式的代码块更加简洁。方法引用和构造器引用都需要使用两个英文冒号
 * Lambda 表达式支持如下表 所示的几种引用方式
 * --------------------------------------------------------------------------------------------------------------
 * 种类               示例                说明                                  对应的lambda表达式
 * --------------------------------------------------------------------------------------------------------------
 * 引用类方法         类名::方法名         函数式接口中被实现方法的                (a,b,...)->类名.方法名(a,b,...)
 *                                      全部参数传给该类方法作为参数
 * --------------------------------------------------------------------------------------------------------------
 * 引用特定对象       特定对象::实例方法    函数式接口中被实现方法的                (a,b,...)->特定对象.实例方法(a,b,...)
 * 的实例方法                             全部参数传给该方法作为参数
 * --------------------------------------------------------------------------------------------------------------
 * 引用某对象的       类名::实例方法        函数式接口中被实现方法的第一个参数作     (a,b,...)->a.实例方法(b,...)
 * 实例方法                               为调用者，后面的参数全部传给该方法作为参数
 * --------------------------------------------------------------------------------------------------------------
 * 引用构造器         类名::new            函数式接口中被实现方法的全部参数传给     (a,b,...)->new.类名(a,b,...)
 *                                       该构造器作为参数
 * --------------------------------------------------------------------------------------------------------------
 * @author JIE
 */
public class LambdaQuote {

    @FunctionalInterface
    interface Converter{
        /**
         * converter
         * @param from
         * @return
         */
        Integer converter(String from);
    }

    @FunctionalInterface
    interface MyTest{
        /**
         * test
         * @param a
         * @param b
         * @param c
         * @return
         */
        String test(String a, int b, int c);
    }

    @FunctionalInterface
    interface YouTest{

        /**
         * win
         * @param title
         * @return
         */
        JFrame win(String title);
    }

    public static void main(String[] args) {
        /**
         * 引用类方法
         * 下面代码使用lambda 表达式创建Converter 对象
         */
        Converter converter = from -> Integer.parseInt(from);
        /**
         * 上面Lambda 表达式的代码块只有一条语句，因此程序省略了该代码块的花括号;而且由于表达式所实现的convertO方法需要返回值，
         * 因此Lambda 表达式将会把这条代码的值作为返回值。
         * 接下来程序就可以调用converter 对象的convert()方法将字符串转换为整数了
         * 例如如下代码
         */
        System.out.println(converter.converter("11"));
        /**
         * 上面代码调用converter 对象的converter()方法时,由于converter 对象是Lambda 表达式创建的，
         * converter()方法执行体就是Lambda 表达式的代码块部分，因此上面程序输出11 。
         *
         * 上面Lambda 表达式的代码块只有一行调用类方法的代码，因此可以使用如下方法引用进行替换
         */
        /**
         * 方法引用代替Lambda 表达式:引用类方法
         * 函数式接口中被实现方法的全部参数传给该类方法作为参数
         */
        Converter converter1 = Integer::valueOf;
        System.out.println(converter1.converter("11"));
        /**
         * 对于上面的类方法引用，也就是调用Integer 类的valueOf()类方法来实现Converter 函数式接口中唯一的抽象方法
         * 当调用Converter 接口中的唯一的抽象方法时,调用参数将会传给Integer 类的valueOf()类方法。
         */


        /**
         * 引用特定对象的实例方法
         * 先使用Lambda 表达式来创建一个Converter对象
         */
        Converter converter2 = from -> "fkit.org".indexOf(from);
        System.out.println(converter2.converter("it."));

        Converter converter3 = "fkit.org"::indexOf;
        System.out.println(converter3.converter("it."));


        /**
         * 引用某类对象的实例方法
         * 下面代码使用Lambda 表达式创建MyTest 对象
         */
        MyTest myTest = (a, b, c) -> a.substring(b, c);
        System.out.println(myTest.test("Java I Love you", 2, 9));
        /**
         * 上面Lambda 表达式的代码块只有一行a.substring(b , c); ，因此可以使用如下方法引用进行替换
         * 方法引用代替Lambda 表达式: 引用某类对象的实例方法
         * 函数式接口中被实现方法的第一个参数作为调用者
         * 后面的参数全部传给该方法作为参数
         */
        MyTest myTest1 = String::substring;
        System.out.println(myTest1.test("Java I Love you", 2, 9));


        /**
         * 引用构造器
         * 下面代码使用Lambda 表达式创建YourTest 对象
         */
        YouTest youTest = a -> new JFrame(a);
        JFrame win = youTest.win("我的窗口");
        System.out.println(win);
        /**
         * 上面Lambda 表达式的代码块只有一行new JFrame(a)，因此可以使用如下构造器引用进行替换
         */
        YouTest youTest1 = JFrame::new;
        JFrame win1 = youTest1.win("我的窗口");
        System.out.println(win1);
    }
}
