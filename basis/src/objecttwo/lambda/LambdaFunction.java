package objecttwo.lambda;

/**
 * Lambda 表达式与函数式接口
 *
 * Lambda 表达式的类型，也被称为"目标类型( target type) ",Lambda 表达式的目标类型必须是"函数式接口(functional interface) "
 * 函数式接口代表只包含一个抽象方法的接口函数式接口可以包含多个默认方法、类方法，但只能声明一个抽象方法。
 * 如果采用匿名内部类语法来创建函数式接口的实例，则只需要实现一个抽象方法，在这种情况下即可采用Lambda 表达式来创建对象，该表达式创建出来的对象的目标类型就是这个函数式接口。
 * 查询Java 8的API 文档，可以发现大量的函数式接口，例如: Runnable 、ActionListener 等接口都是函数式接口。
 *
 * Java 8 专门为函数式接口提供了@FunctionalInterface 注解，该注解通常放在接口定义面
 * ，该注解对程序功能没有任何作用，它用于告诉编译器执行更严格检查一一检查该接口必须是函数式接口，否则编译器就会报错。
 *
 * 由于Lambda 表达式的结果就是被当成对象， 因此程序中完全可以使用Lambda 表达式进行赋值，
 * @author JIE
 */
public class LambdaFunction {

    public static void main(String[] args) {
        /**
         * Runnable 接口中只包含一个无参数的方法
         * Lambda 表达式代表的匿名方法实现了Runnable 接口中唯一的、无参数的方法
         * 因此下面的Lambda 表达式创建了一个Runnable 对象
         */
        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        /**
         * 从上面的代码可以看出: Lambda 表达式实现的是匿名方法因此它只能实现特定函数式接口中的唯一方法。这意味着Lambda 表达式有如下两个限制。
         * 1.Lambda 表达式的目标类型必须是明确的函数式接口。
         * 2.Lambda 表达式只能为函数式接口创建对象。Lambda 表达式只能实现一个方法， 因此它只能为只有一个抽象方法的接口(函数式接口〉创建对象。
         */
        // 关于上面第一点限制，看下面代码是否正确(程序清单同上)
        /**
         *         Object obj = () -> {
         *             for (int i = 0; i < 100; i++) {
         *                 System.out.println(i);
         *             }
         *         };
         */

        /**
         * 上面代码与前一段代码几乎完全相同，只是此时程序将Lambda 表达式不再赋值给Runnable 变量，
         * 而是直接赋值给Object 变量。编译上面代码，会报如下错误:
         * 不兼容的类型: Object 不是函数接口
         *
         * 从该错误信息可以看出， Lambda 表达式的目标类型必须是明确的函数式接口。上面代码将Lambda表达式赋值给Object 变量，
         * 编译器只能确定该Lambda 表达式的类型为Object ， 而Object 井不是函数式接口， 因此上面代码报错。
         * 为了保证Lambda 表达式的目标类型是一个明确的函数式接口，可以有如下三种常见方式。
         * 1.将Lambda 表达式赋值给函数式接口类型的变量。
         * 2.将Lambda 表达式作为函数式接口类型的参数传给某个方法。
         * 使用函数式接口对Lambda 表达式进行强制类型转换。
         * 因此，只要将上面代码改为如下形式即可(程序清单同上) 。
         */
        Object obj = (Runnable)() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        /**
         * 上面代码中的粗体字代码对Lambda 表达式执行了强制类型转换，这样就可以确定该表达式的目标类型为Runnable 函数式接口。
         * 需要说明的是，同样的Lambda 表达式的目标类型完全可能是变化的, 唯一的要求是， Lambda表达式实现的匿名方法与目标类型(函数式接口)中唯一的抽象方法有相同的形参列表。
         * 例如: FkTest
         * FkTest的函数式接口中仅定义了一个不带参数的方法，因此前面强制转型为Runnable 的Lambda 表达式也可强转为FkTest 类型
         * 因为FkTest 接口中的唯一的抽象方法是不带参数的，而该Lambda 表达式也是不带参数的。因此，下面代码是正确的
         */
        Object fkTest = (FkTest)() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        };
        /**
         * Java 8 在java.util.function 包下预定义了大量函数式接口，典型地包含如下4 类接口
         * 1.XxxFunction: 这类接口中通常包含一个apply()抽象方法，该方法对参数进行处理、转换(apply())方法的处理逻辑由Lambda 表达式来实现)，
         * 然后返回一个新的值。该函数式接口通常用于对指定数据进行转换处理。
         * 2.XxxConsumer: 这类接口中通常包含一个accept()抽象方法，该方法与XxxFunction 接口中的apply()方法基本相似，也负责对参数进行处理，只是该方法不会返回处理结果。
         * 3.XxxPredicate: 这类接口中通常包含一个test()抽象方法，该方法通常用来对参数进行某种判断( test()方法的判断逻辑由Lambda 表达式来实现)，
         * 然后返回一个boolean 值。该接口通常用于判断参数是否满足特定条件，经常用于进行筛滤数据。
         * 4.XxxSupplier: 这类接口中通常包含一个getAsXxx()抽象方法，该力法不需要输入参数，该方法会按某种逻辑算法（getAsXxx()方法的逻辑算法由Lambda 表达式来实现)返回一个数据。
         *
         * 综上所述，不难发现Lambda 表达式的本质很简单，就是使用简洁的语法来创建函数式接口的实例，这种语法避免了匿名内部类的烦琐。
         */

    }

    @FunctionalInterface
    interface FkTest{
        void run();
    }
}
