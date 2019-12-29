package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 遍历 Collection 集合
 *
 * 1.使用Lambda 表达式遍历集合
 * 2.使用Java 8 增强的Iterator 遍历集合元素
 * 3.使用Lambda 表达式遍历Iterator
 * 4.使用foreach 循环遍历集合元素
 *
 * @author JIE
 */
public class CollectionTraversalTest {

    public static void main(String[] args) {
        // 创建一个集合
        Collection books = new HashSet();
        books.add("轻量级Java EE 企业应用实战");
        books.add("疯狂Java 讲义");
        books.add("疯狂Android 讲义");




        /**
         * 使用Lambda 表达式遍历集合
         *
         * Java 8 为Iterable 接口新增了一个forEach(Consumer action)默认方法， 该方法所需参数的类型是一个函数式接口，
         * 而Iterable 接口是Collection 接口的父接口，因此Collection 集合也可直接调用该方法。
         *
         * 当程序调用Iterable 的forEach(Consumer action)遍历集合元素时， 程序会依次将集合元素传给Consumer 的accept(T t)方法(该接口中唯一的抽象方法)。
         * 正因为Consumer 是函数式接口，因此可以使用Lambda 表达式来遍历集合元素。
         * 下程序示范了使用Lambda 表达式来遍历集合元素
         */
        System.out.println("使用Lambda 表达式遍历集合");
        System.out.println("-----------------------------------------");
        books.forEach(obj -> System.out.println("迭代集合元素:" + obj));
        System.out.println("-----------------------------------------");
        System.out.println();
        /**
         * 上面程序调用了Iterable 的forEach()默认方法来遍历集合元素，传给该方法的参数是一个Lambda 表达式， 该Lambda 表达式的目标类型是Consumer 。
         * forEach()方法会自动将集合元素逐个地传给Lambda 表达式的形参， 这样Lambda 表达式的代码体即可遍历到集合元素了。
         */





        /**
         * 使用Java 8 增强的Iterator 遍历集合元素
         *
         * Iterator 接口也是Java 集合框架的成员， 但它与Collection 系列、Map 系列的集合不一样: Collection系列集合、Map 系列集合主要用于盛装其他对象，
         * 而Iterator 则主要用于遍历( 即迭代访问) Collection集合中的元素， Iterator 对象也被称为迭代器。
         *
         * Iterator 接口隐藏了各种Collection 实现类的底层细节，向应用程序提供了遍历Collection 集合元素的统一编程接口。Iterator 接口里定义了如下4 个方法。
         * boolean hasNext(): 如果被迭代的集合元素还没有被遍历完，则返回true 。
         * Object next(): 返回集合里的下一个元素。
         * void remove(): 删除集合里上一次next 方法返回的元素。
         * void forEachRemaining(Consumer action) ，这是Java 8 为Iterator 新增的默认方法， 该方法可使用Lambda 表达式来遍历集合元素。
         */
        System.out.println("使用Java 8 增强的Iterator 遍历集合元素");
        System.out.println("-----------------------------------------");
        Iterator it = books.iterator();
        while (it.hasNext()) {
            // it.next() 方法返回的数据类型是Object 类型，因此需要强制类型转换
            String book = (String) it.next();
            System.out.println(book);
            if ("疯狂Java 讲义".equals(book)) {
                // 从集合中删除上一次next () 方法返回的元素
                // books.remove("疯狂Java 讲义");
                it.remove();
            }
            // 对book 变量赋值， 不会改变集合元素本身
            book = "测试字符串";
        }
        System.out.println(books);
        System.out.println("-----------------------------------------");
        System.out.println();
        /**
         * 从上面代码中可以看出， Iterator 仅用于遍历集合， Iterator 本身并不提供盛装对象的能力。如果需
         * 要创建Iterator 对象， 则必须有一个被迭代的集合。没有集合的Iterator 仿佛无本之木， 没有存在的价值
         *
         * Iterator 必须依附于Collection 对象， 若有一个Iterator 对象， 则必然有一个与之关联的Collection 对象。
         * Iterator 提供了两个方法来迭代访问Collection 集合里的元素， 并可通过remove()方法来删除集合中上一次next()方法返回的集合元素。
         *
         * 上面程序中代码对迭代变量book 进行赋值， 但当再次输出books 集合时，会看到集合里的元素没有任何改变。这就可以得到一个结论: 当使用Iterator 对集合元素进行迭代时，
         * Iterator 并不是把集合元素本身传给了迭代变量，而是把集合元素的值传给了迭代变量， 所以修改迭代变量的值对集合元素本身没有任何影响。
         *
         * 当使用Iterator 迭代访问Collection 集合元素时， Collection 集合里的元素不能被改变，只有通过Iterator 的remove()方法删除上一次next()方法返回的集合元素才可以;
         * 否则将会引发java.util.ConcurrentModificationException 异常, 被注释的 books.remove("疯狂Java 讲义");程序示范了这一点。
         *
         * 上面程序中books.remove("疯狂Java 讲义");代码位于Iterator 迭代块内，也就是在Iterator 迭代Collection 集合过程中修改了Collection 集合，所以程序将在运行时引发异常。
         *
         * Iterator 迭代器采用的是快速失败(fail-fast ) 机制， 一旦在迭代过程中检测到该集合己经被修改(通常是程序中的其他线程修改)，
         * 程序立即引发ConcurrentModificationException 异常，而不是显示修改后的结果，这样可以避免共享资源而引发的潜在问题。
         */

        /**
         * 使用Lambda 表达式遍历Iterator
         *
         * Java 8 起为Iterator 新增了一个forEachRemaining(Consumer action)方法，该方法所需的Consumer参数同样也是函数式接口。
         * 当程序调用Iterator 的forEachRemaining(Consumer action)遍历集合元素时，程序会依次将集合元素传给Consumer 的accept(T t)方法(该接口中唯一的抽象方法) 。
         *
         * 如下程序示范了使用Lambda 表达式来遍历集合元素。
         */
        System.out.println("使用Lambda 表达式遍历Iterator");
        System.out.println("-----------------------------------------");
        // 获取books 集合对应的迭代器
        Iterator it1 = books.iterator();
        // 使用Lambda 表达式(目标类型是Consumer) 来遍历集合元素
        it1.forEachRemaining(object -> System.out.println("法代集合元素: " + object));
        System.out.println("-----------------------------------------");
        System.out.println();
        /**
         * 上面程序中调用了Iterator 的forEachRemainingO方法来遍历集合元素，传给该方法的参数是一个Lambda 表达式，该Lambda 表达式的目标类型是Consumer ，
         * 因此上面代码也可用于遍历集合元素。
         */

        /**
         * 使用foreach 循环遍历集合元素
         * 除可以使用Iterator 接口法代访问Collection 集合里的元素之外，使用Java 5 提供的foreach 循环迭代访问集合元素更加便捷。
         * 如下程序示范了使用foreach 循环来迭代访问集合元素。
         */
        System.out.println("使用foreach 循环遍历集合元素");
        System.out.println("-----------------------------------------");
        for (Object obj : books) {
            // 此处的book 变量也不是集合元素本身
            String book = (String)obj;
            System.out.println(book);
        }
        System.out.println(books);
        System.out.println("-----------------------------------------");
        System.out.println();

    }
}
