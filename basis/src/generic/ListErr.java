package generic;

import java.util.ArrayList;

/**
 * 编译时不检查类型的异常 与 使用泛型
 *
 * 下面程序将会看到编译时不检查类型所导致的异常。
 *
 * @author JIE
 */
public class ListErr {

    public static void main(String[] args) {
        // 创建一个只想保存字符串的List 集合
        ArrayList strList = new ArrayList();
        strList.add("a");
        strList.add("b");
        // "不小心"把一个Integer 对象"丢进"了集合
        strList.add(1);
        // ClassCastException 异常
//        strList.forEach(str -> System.out.println((String) str));
        /**
         * 上面程序创建了一个List 集合，而且只希望该List 集合保存字符串对象, 但程序不能进行任何限制，如果程序"不小心"把一个Integer 对象"丢进"了List 集合中，
         * 这将导致程序在试图把一个Integer 对象转换为String 类型时引发ClassCastException 异常
         */


        /**
         * 使用泛型
         *
         * 从Java 5 以后， Java 引入了"参数化类型(parameterized type ) " 的概念，允许程序在创建集合时指定集合元素的类型.Java 的参数化类型被称为泛型(Generic ) 。
         *
         * 对于前面的strList 程序，可以使用泛型改进这个程序。
         */
        // 创建一个只想保存字符串的List 集合
        ArrayList<String> strLists = new ArrayList<String>();
        strLists.add("a");
        strLists.add("bb");
        // 下面代码将引起编译错误
//        strLists.add(1);
        strLists.forEach(str -> System.out.println(str.length()));
        /**
         * 上面程序成功创建了一个特殊的List 集合: strLists ，这个List 集合只能保存字符串对象，不能保存其他类型的对象。创建这种特殊集合的方法是:在集合接口、类后增加尖括号，
         * 尖括号里放一个数据类型，即表明这个集合接口、集合类只能保存特定类型的对象。
         *
         * 上面代码不仅更加健壮，程序再也不能"不小心"地把其他对象"丢进"由List 集合中;而且程序更加简沽，集合自动记住所有集合元素的数据类型，
         * 从而无须对集合元素进行强制类型转换。这一切，都是因为Java 5 提供的泛型支持。
         */
    }
}
