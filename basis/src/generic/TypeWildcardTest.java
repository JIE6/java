package generic;

import java.io.Serializable;
import java.util.*;

/**
 * 类型通配符与上下限
 *
 * 正如前面讲的， 当使用一个泛型类时(包括声明变量和创建对象两种情况) ， 都应该为这个泛型类传入一个类型实参。如果没有传入类型实际参数， 编译器就会提出泛型警告。
 * 假设现在需要定义一个方法， 该方法里有一个集合形参，集合形参的元素类型是不确定的， 那应该怎样定义呢?
 *
 * 为了表示各种泛型List 的父类，可以使用类型通配符，类型通配符是一个问号(?) ，将一个问号作为类型实参传给List 集合，写作: List<?> (意思是元素类型未知的List ) 。
 * 这个问号(?)被称为通配符，它的元素类型可以匹配任何类型。
 *
 * @author JIE
 */
public class TypeWildcardTest<T extends Number & Serializable> {

    public void test(List<?> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }
    /**
     * 任何类型的List 来调用它，程序依然可以访问集合c 中的元素，其类型是Object ，这永远是安全的，因为不管List 的真实类型是什么，
     * 它包含的都是Object 。
     *
     * 上面程序中使用的List<?> ，其实这种写法可以适应于任何支持泛型声明的接口和类，比如写成Set<?> 、Collection<?> 、Map<? ， ?>等。
     *
     * 但这种带通配符的List 仅表示它是各种泛型List 的父类，并不能把元素加入到其中。例如，如下代码将会引起编译错误。
     */
    public static void main(String[] args) {
        List<?> c = new ArrayList<>();
        // 下代码将会引起编译错误。
//        c.add(1)
//        c.add("");
//        c.add(new Object());
        /**
         * 因为程序无法确定c 集合中元素的类型，所以不能向其中添加对象。根据前面的List<E>接口定义的代码可以发现: addO方法有类型参数E 作为集合的元素类型，
         * 所以传给add 的参数必须是E 类的对象或者其子类的对象。但因为在该例中不知道E 是什么类型，所以程序无法将任何对象"丢进"该集合。唯一的例外是nulL 它是所有引用类型的实例。
         *
         * 另一方面，程序可以调用get()方法来返回List<?>集合指定索引处的元素，其返回值是一个未知类型，但可以肯定的是，它总是一个Object。
         * 因此，把getO的返回值赋值给一个Object 类型的变量，或者放在任何希望是Object 类型的地方都可以。
         */
    }

    /**
     * 设定类型通配符的上限
     *
     * List<? extends Object>是受限制通配符的例子，此处的问号(?) 代表一个未知的类型，就像前面看到的通配符一样。但是此处的这个未知类型一定是Object 的子类型(也可以是Object 本身)，
     * 因此可以把Object 称为这个通配符的上限( upper bound) 。
     */
    public void test2(List<? extends  Collection> c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
    }

    /**
     * 设定类型通配符的下限
     *
     * 除可以指定通配符的上限之外， Java 也允许指定通配符的下限，通配符的下限用<? super 类型>的方式来指定，通配符下限的作用与通配符上限的作用恰好相反。
     *
     * 指定通配符的下限就是为了支持类型型变。
     *
     * 对于逆变的泛型集合来说，编译器只知道集合元素是下限的父类型，但具体是哪种父类型则不确定。因此，这种逆变的泛型集合能向其中添加元素(因为实际赋值的集合元素总是逆变声明的父类) ，
     * 从集合中取元素时只能被当成Object 类型处理(编译器无法确定取出的到底是哪个父类的对象) 。
     *
     * 假设自己实现一个工具方法:实现将src 集合中的元素复制到dest 集合的功能，因为dest 集合可以保存src 集合中的所有元素，所以dest 集合元素的类型应该是src 集合元素类型的父类。
     *
     * 下面dest 集合元素的类型必须与src 集合元素的类型相同，或者是其父类
     */
    public static <T> T test3(LinkedList<? super T> dest, LinkedList<T> src) {
        T last = null;
        for (T ele : src) {
            last = ele;
            // 逆变的泛型集合添加元素是安全的
            dest.add(ele);
        }
        return last;
    }
    /**
     * 上面方法用到了泛型方法的语法， 就是在方法修饰符和返回值类型之间用。定义泛型形参。关于泛型方法更详细介绍可参考后面内容。
     *
     * Java 泛型不仅允许在使用通配符形参时设定上限，而且可以在定义泛型形参时设定上限，用于表示传给该泛型形参的实际类型要么是该上限类型，要么是该上限类型的子类。
     * 参考类名。
     *
     * 在一种更极端的情况下，程序需要为泛型形参设定多个上限(至多有一个父类上限，可以有多个接口上限)，表明该泛型形参必须是其父类的子类(是父类本身也行)，并且实现多个上限接口。
     * 参考类名。
     *
     * 表明T 类型必须是Number 类或其子类，并必须实现java.io.Serializable 接口
     */
}
