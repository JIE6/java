package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Java 9 增强的"菱形"语法
 *
 * 在Java 7 以前，如果使用带泛型的接口、类定义变量，那么调用构造器创建对象时构造器的后面也必须带泛型，这显得有些多余了。例如如下两条语句:
 * List<String> strList = new ArrayList<String> ();
 * Map<String , Integer> scores = new HashMap<String ，Integer>();
 *
 * 上面两条语句中的后面尖括号内的代码部分完全是多余的，在Java 7 以前这是必需的，不能省略。从Java 7开始， Java 允许在构造器后不需要带完整的泛型信息，
 * 只要给出一对尖括号(<>)即可， Java 可以推断尖括号里应该是什么泛型信息。即上面两条语句可以改写为如下形式:
 * List<String> strList = new ArrayList<> ();
 * Map<String , Integer> scores = new HashMap<>();
 *
 * 把两个尖括号并排放在一起非常像一个菱形，这种语法也就被称为"菱形"语法。下面程序示范了Java 7 的菱形语法。
 * @author JIE
 */
public class DiamondTest {

    public static void main(String[] args) {
        // Java 自动推断出ArrayList 的。里应该是String
        List<String> books = new ArrayList<>();
        books.add("aa");
        books.add("bb");
        // 遍历books 集合，集合元素就是String 类型
        books.forEach(book -> System.out.println(book.length()));


        // Java 自动推断出HashMap 的<>里应该是String , List<String>
        Map<String , List<String>> schoolsInfo = new HashMap<>() ;
        // Java 自动推断出ArrayList 的。里应该是String
        List<String> schools = new ArrayList<>() ;
        schools.add("斜月三星洞");
        schools.add("西天取经路");
        schoolsInfo.put("孙悟空", schools) ;
        // 遍历Map 时， Map 的key 是String 类型， value 是List<String>类型
        schoolsInfo.forEach((key, value) -> System.out.println(key + "->" + value));

        /**
         * 上面程序的代码就是"菱形"语法的示例。从该程序不难看出，"菱形"语法对原有的泛型并没有改变，只是更好地简化了泛型编程。
         *
         * Java 9 再次增强了"菱形"语法，它甚至允许在创建匿名内部类时使用菱形语法， Java 可根据上下文来推断匿名内部类中泛型的类型。
         * 下面程序示范了在匿名内部类中使用菱形语法。
         */
        // 指定Foo 类中泛型为String
        Foo<String> f = new Foo<>(){
            /**
             * test() 方法的参数类型为String
             * @param t
             */
            @Override
            public void test(String t) {
                System.out.println("test 方法的t 参数为:" + t);
            }
        };
        // 使用泛型通配符，此时相当于通配符的上限为Object
        Foo<?> fo = new Foo<>() {

            /**
             * test() 方法的参数类型为Object
             * @param t
             */
            @Override
            public void test(Object t) {
                System.out.println("test 方法的t 参数为:" + t);
            }
        };
        // 使用泛型通配符，通配符的上限为Number
        Foo<? extends Number> fn = new Foo<>() {

            /**
             * 此时test ()方法的参数类型为Number
             * @param t
             */
            @Override
            public void test(Number t) {
                System.out.println("test 方法的t 参数为:" + t);
            }
        };


        /**
         * 上面程序先定义了一个带泛型声明的接口，接下来来分别示范了在匿名内部类中使用菱形语法。
         *
         * 第一个：声明变量时明确地将泛型指定为String 类型，因此在该匿名内部类中T类型就代表了String 类型;
         * 第二个：码声明变量时使用通配符来代表泛型(相当于通配符的上限为Object) ，因此系统只能推断出T 代表Object，所以在该医名内部类中T 类型就代表了Object 类型;
         * 第三个：声明变量时使用了带上限(上限是Number ) 的通配符， 因此系统可以推断出T 代表Number 类。
         *
         * 无论哪种方式， Java 9 都允许在使用匿名内部类时使用菱形语法。
         */
    }

    interface Foo<T> {

        /**
         * 测试
         * @param t
         */
        void test(T t) ;
    }
}
