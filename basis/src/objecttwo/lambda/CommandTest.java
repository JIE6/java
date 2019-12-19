package objecttwo.lambda;

import objecttwo.Command;
import objecttwo.ProcessArray;

/**
 * Lambda 表达式入门
 * 下面先使用匿名内部类来改写前面介绍的command 表达式的例子，改写后的程序如下。
 * @author JIE
 */
public class CommandTest {

    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] target = {3, -4 , 6, 4};
        // 处理数组，具体处理行为取决于匿名内部类
        pa.process(target, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int tmp : target) {
                    sum += tmp;
                }
                System.out.println("数组元素的总和是: " + sum);
            }
        });
        /**
         * 前面己经提到， ProcessArray 类的process()方法处理数组时，希望可以动态传入一段代码作为具体的处理行为，因此程序创建了一个匿名内部类实例来封装处理行为
         * 从上面代码可以看出，用于封装处理行为的关键就是实现程序中的粗体字方法。但为了向process()方法传入这段粗体字代码， 程序不得不使用匿名内部类的语法来创建对象。
         * Lambda 表达式完全可用于简化创建匿名内部类对象，因此可将上面代码改为如下形式。
         */
        ProcessArray pa3 = new ProcessArray();
        int[] array = {3, -4 , 6, 4};
        // 处理数组，具体处理行为取决于匿名内部类
        pa3.process(array, (int[] targets) -> {
            int sum = 0;
            for (int tmp : targets) {
                sum += tmp;
            }
            System.out.println("数组元素的总和是: " + sum);
        });
        /**
         * 从上面程序中的粗体字代码可以看出使用lambda与创建匿名内部类时需要实现的process(int[]target)方法完全相同
         * 只是不需要new Xxx(){} 这种烦琐的代码，不需要指出重写的方法名字，也不需要给出重写的方法的返回值类型
         * 只要给出重写的方法括号以及括号里的形参列表即可。
         *
         * 从上面介绍可以看出，当使用Lambda 表达式代替匿名内部类创建对象时， Lambda 表达式的代码块将会代替实现抽象方法的方法体， Lambda 表达式就相当一个匿名方法。
         * 从上面语法格式可以看出， Lambda 表达式的主要作用就是代替匿名内部类的烦琐语法。它由三部分组成。
         *
         * 1.形参列表。形参列表允许省略形参类型。如果形参列表中只有一个参数，甚至连形参列表的圆括号也可以省略。
         * 2.箭头(-> )。必须通过英文中画线和大于符号组成。
         * 3.代码块。如果代码块只包含一条语句， Lambda 表达式允许省略代码块的花括号，那么这条语句就不要用花括号表示语句结束
         * Lambda 代码块只有一条return语句，甚至可以省略return关键字。Lambda 表达式需要返回值，而它的代码块中仅有一条省略了return 的语句， Lambda 表达式会自动返回这条语句的值。
         */


        /**
         * 下面程序示范了Lambda 表达式的几种简化写法。
         */
        CommandTest ct1 = new CommandTest();
        // Lambda 表达式的代码块只有一条语句，可以省略花括号
        ct1.eat(() -> System.out.println("苹果味的不错"));
        // Lambda 表达式的形参列表只有一个形参，可以省略圆括号
        ct1.drive(weather -> {
            System.out.println("今天天气是："+weather);
            System.out.println("直升机飞行平稳") ;
        });
        // Lambda 表达式的代码块只有一条语句，可以省略花括号
        // 代码块中只有一条语句，即使该表达式需要返回值，也可以省略return 关键字
        ct1.test((a , b)-> a + b);
    }

    interface Eatable {
        void taste();
    }

    interface Flyable {
        void fly(String weather);
    }

    interface Addable {
        int add(int a , int b);
    }

    public void eat(Eatable e) {
        System.out.println(e);
        e.taste();
    }

    public void drive(Flyable f) {
        System.out.println( "我正在驾驶: " + f);
        f.fly(" 【碧空如洗的晴日】");
    }

    public void test(Addable add) {
        System.out . println("5 与3 的和为: " + add.add (5 , 3));
    }
}
