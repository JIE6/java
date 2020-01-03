package generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型方法
 *
 * 前面介绍了在定义类、接口时可以使用泛型形参，在该类的方法定义和成员变量定义、接口的方法定义中， 这些泛型形参可被当成普通类型来用。
 * 在另外一些情况下，定义类、接口时没有使用泛型形参，但定义方法时想自己定义泛型形参，这也是可以的，
 * Java 5 还提供了对泛型方法的支持。
 *
 * 定义泛型方法
 *
 * 假设需要实现这样一个方法该方法负责将一个Object 数组的所有元素添加到一个Collection 集合中。考虑采用如下代码来实现该方法。
 * static void fromArrayToCollection(Object[] a , Collection<Object> c) {
 *     for (Object o : a) {
 *         c.add (o);
 *     }
 * }
 * 上面定义的方法没有任何问题，关键在于方法中的c 形参，它的数据类型是Collection<Object>。正如前面所介绍的， Collection< String>不是Collection< Object>的子类型
 * 所以这个方法的功能非常有限，它只能将Object[]数组的元素复制到元素为Object ( Object 的子类不行)的Collection 集合中，即下面代码将引起编译错误。
 * String[] strArr = {"a" , "b " };
 * List<String> strList = new ArrayList<>() ;
 * // Collection<String>对象不能当成Collection<Object>使用，下面代码出现编译错误
 * fromArrayToCollection(strArr , strList);
 *
 * 可见上面方法的参数类型不可以使用Collection<String> ，那使用通配符Collection<?>是否可行呢?显然也不行，因为Java 不允许把对象放进一个未知类型的集合中。
 *
 * 为了解决这个问题，可以使用Java 5 提供的泛型方法(Generic Method ) 。所谓泛型方法，就是在声明方法时定义一个或多个泛型形参。泛型方法的语法格式如下:
 * 修饰符<T , S> 返回值类型 方法名(形参列表) {
 *
 * }
 * 把上面方法的格式和普通方法的格式进行对比，不难发现泛型方法的方法签名比普通方法的方法签名多了泛型形参声明， 泛型形参声明以尖括号括起来，多个泛型形参之间以逗号(，)隔开，所有的泛
 * 型形参声明放在方法修饰符和方法返回值类型之间。
 *
 * 采用支持泛型的方法，就可以将上面的fromArrayToCollection 方法改为如下形式:
 * static <T> void fromArrayToCollection(T[] a , Collection<T> c) {
 *     ......
 * }
 *
 * 下面程序示范了完整的用法。
 * @author JIE
 */
public class GenericFunction {

    /**
     * 声明一个泛型方法，该泛型方法中带一个T 泛型形参
     */
    static <T> void fromArrayToCollection(T[] a , Collection<T> c) {
        for (T t : a) {
            c.add(t);
        }
    }

    public static void main(String[] args) {
        String[] sa = new String[100] ;
        Object[] oa = new Object[100] ;
        Collection<Object> co = new ArrayList<>() ;
        Collection<Integer> ci = new ArrayList<>() ;
        // 下面代码中T 代表Object 类型
        fromArrayToCollection(oa, co);
        // 下面代码中T 代表String 类型
        fromArrayToCollection(sa, co);
        // 下面代码中T 代表String 类型，但ci的泛型是 是一个Integer
//        fromArrayToCollection(sa, ci);
        /**
         * 上面程序定义了一个泛型方法，该泛型方法中定义了一个T 泛型形参，这个T 类型就可以在该方法内当成普通类型使用。
         * 与接口、类声明中定义的泛型不同的是，方法声明中定义的泛型只能在该方法里使用，而接口、类声明中定义的泛型则可以在整个接口、类中使用。
         *
         * 与类、接口中使用泛型参数不同的是，方法中的泛型参数无须显式传入实际类型参数，如上面程序所示，当程序调用fromArrayToCollection方法时，
         * 无须在调用该方法前传入String 、Object 等类型， 但系统依然可以知道为泛型实际传入的类型，因为编译器根据实参推断出泛型所代表的类型，它通常推断出最直接的类型。
         */
    }

}
