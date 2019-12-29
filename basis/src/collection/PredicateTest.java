package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;

/**
 * 使用Java 8 新增的Predicate 操作集合
 *
 * Java 8 起为Collection 集合新增了一个removeIf(Predicate filter)方法，该方法将会批量删除符合filter条件的所有元素。
 * 该方法需要一个Predicate (谓词)对象作为参数， Predicate 也是函数式接口，因此可使用Lambda 表达式作为参数。
 *
 * 如下程序示范了使用Predicate 来过滤集合。
 * @author JIE
 */
public class PredicateTest {

    public static void main(String[] args) {
        Collection books = new HashSet();
        books.add(new String("轻量级Java EE 企业应用实战"));
        books.add(new String("疯狂Java 讲义"));
        books.add(new String("疯狂iOS 讲义"));
        books.add(new String("疯狂町ax 讲义"));
        books.add(new String("疯狂Android 讲义"));
        // 使用Lambda 表达式(目标类型是Predicate) 过滤集合
        books.removeIf(ele -> ((String)ele).length() < 10);
        System.out.println(books);
        /**
         * 使用Predicate 可以充分简化集合的运算，假设依然有上面程序所示的books 集合，如果程序有如下三个统计需求:
         * 1.统计书名中出现"疯狂" 字符串的图书数量。
         * 2.统计书名中出现"Java" 宇符串的图书数量
         * 3.统计书名长度大于10 的图书数量。
         *
         * 此处只是一个假设，实际上还可能有更多的统计需求。如果采用传统的编程方式来完成这些需求，则需要执行三次循环， 但采用Predicate 只需要一个方法即可。如下程示范了这种用法。
         */
        Collection books2 = new HashSet();
        books2.add(new String("轻量级Java EE 企业应用实战"));
        books2.add(new String("疯狂Java 讲义"));
        books2.add(new String("疯狂iOS 讲义"));
        books2.add(new String("疯狂町ax 讲义"));
        books2.add(new String("疯狂Android 讲义"));
        // 统计书名包含"疯狂"子串的图书数量
        System.out.println(calAll(books2, ele -> ((String) ele).contains("疯狂")));
        // 统计书名包含"Java" 子串的图书数量
        System.out.println(calAll(books2, ele -> ((String) ele).contains("Java")));
        // 统计书名字符串长度大于10 的图书数量
        System.out.println(calAll(books2, ele -> ((String) ele).length() > 10));

        /**
         * 上面程序先定义了一个calAll()方法，该方法将会使用Predicate 判断每个集合元素是否符合特定条件
         * 该条件将通过Predicate 参数动态传入。从上面程序中三行粗体字代码可以看到，程序传入了三个Lambda
         * 表达式(其目标类型都是Predicate) ，这样calAll()方法就只会统计满足Predicate 条件的图书。
         */
    }

    public static int calAll(Collection collections, Predicate predicate) {
        int total = 0;
        for (Object collection : collections) {
            // 使用Predicate 的test()方法判断该对象是否满足Predicate 指定的条件
            if (predicate.test(collection)) {
                total ++;
            }
        }
        return total;
    }
}
