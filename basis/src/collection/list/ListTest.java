package collection.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

/**
 * Java8 改进的List 接口和ListIterator 接口
 *
 * List 作为Collection 接口的子接口，当然可以使用Collection 接口里的全部方法。而且由于List 是有序集合，因此List 集合里增加了一些根据索引来操作集合元素的方法。
 * void add(int index, Object element): 将元素element 插入到List 集合的index 处。
 * boolean addAll(int index, Collection c): 将集合c 所包含的所有元素都插入到List 集合的index处。
 * Object get(int index): 返回集合index 索引处的元素。
 * int indexOf(Object 0): 返回对象。在List 集合中第一次出现的位置索引。
 * int lastIndexOf(Object 0): 返回对象。在List 集合中最后一次出现的位置索引。
 * Object remove(int index) : 删除并返回index 索引处的元素。
 * Object set(int index, Object element): 将index 索引处的元素替换成element 对象，返回被替换的旧元素。
 * List subList(int fromIndex, int toIndex): 返回从索引fromIndex (包含)到索引toIndex (不包含)处所有集合元素组成的子集合。
 *
 * 所有的List 实现类都可以调用这些方法来操作集合元素。与Set 集合相比， List 增加了根据索引来插入、替换和删除集合元素的方法。除此之外， Java 8 还为List 接口添加了如下两个默认方法。
 * void replaceAll(UnaryOperator operator): 根据operator 指定的计算规则重新设置List 集合的所有元素。
 * void sort(Comparator c): 根据Comparator 参数对List 集合的元素排序。
 * 下面程序示范了List 集合的常规用法。
 * @author JIE
 */
public class ListTest {

    public static void main(String[] args) {
        List books = new ArrayList();
        // 向books 集合中添加三个元素
        books.add(new String("轻量级Java EE 企业应用实战"));
        books.add(new String("疯狂Java 讲义"));
        books.add(new String("疯狂Android 讲义"));
        System.out.println(books);
        // 将新字符串对象插入在第二个位置
        books.add(1, new String("疯狂Ajax 讲义"));
        for (int i = 0; i < books.size(); i++) {
            System.out.println(books.get(i));
        }
        // 删除第三个元素
        System.out.println(books.remove(2));
        System.out.println(books);
        // 判断指定元素在List 集合中的位置: 输出1 ，表明位于第二位         1
        System.out.println(books.indexOf(new String("疯狂Ajax 讲义")));
        // 将第二个元素替换成新的字符串对象
        System.out.println(books.set(1, new String("疯狂Java 讲义")));
        System.out.println(books);
        // 将books 集合的第二个元素(包括)到第三个元素(不包括)截取成子集合
        System.out.println(books.subList(1, 2));
        /**
         * 从上面运行结果清楚地看出List 集合的用法。注意 1 代码处，程序试图返回新字符串对象在List集合中的位置，实际上List 集合中并未包含该字符串对象。
         * 因为List 集合添加宇符串对象时，添加的是通过new 关键宇创建的新字符串对象, 1 代码处也是通过new 关键宇创建的新字符串对象，两个字符串显然不是
         * 同一个对象，但List 的indexOf 方法依然可以返回1  List 判断两个对象相等的标准是什么呢?
         *
         * List 判断两个对象相等只要通过equals()方法比较返回true 即可。看下面程序。
         */
        // 删除集合中的A 对象，将导致第一个元素被删除
        books.remove(new ListTest().new A());
        System.out.println(books);
        // 删除集合中的A 对象，再次删除集合中的第一个元素
        books.remove(new ListTest().new A());
        System.out.println(books);
        /**
         * 从上面运行结果可以看出程序试图删除一个A 对象， List 将会调用该A 对象的equals()方法依次与集合元素进行比较，如果该equals()方法以某个集合元素作为参数时返回true ，
         * List将会删除该元素. A 类重写了equals()方法，该方法总是返回true 。所以每次从List 集合中删除A 对象时，总是删除List 集合中的第一个元素。
         */

        /**
         * Java 8 为List 集合增加了sort()和replaceAll()两个常用的默认方法，其中sort()方法需要一个Comparator 对象来控制元素排序，程序可使用Lambda 表达式来作为参数:
         * 而replaceAll()方法则需要一个UnaryOperator 来替换所有集合元素， UnaryOperator 也是一个函数式接口，因此程序也可使用Lambda表达式作为参数。
         * 如下程序示范了List 集合的两个默认方法的功能。
         */
        books.add(new String("轻量级Java EE 企业应用实战"));
        books.add(new String("疯狂Java 讲义"));
        books.add(new String("疯狂IOS 讲义"));
        // 使用目标类型为Comparator 的Lambda 表达式对List 集合排序
        books.sort((Comparator.comparingInt(o -> ((String) o).length())));
        System.out.println(books);
        // 使用目标类型为UnaryOperator 的Lambda 表达式来替换集合中所有元素, 该Lambda 表达式控制使用每个字符串的长度作为新的集合元素
        books.replaceAll(ele -> ((String)ele).length());
        System.out.println(books);
        /**
         * 上面程序中代码控制对List 集合进行排序，传给sort()方法的Lambda 表达式指定的排序规则是:字符串长度越长，字符串越大，因此执行完第一行粗体字代码之后，
         * List 集合中的字符串会按由短到长的顺序排列。
         *
         * 程序中代码传给replaceAll()方法的Lambda 表达式指定了替换集合元素的规则:直接用集合元素(宇符串)的长度作为新的集合元素。执行该方法后，集合元素被替换为[8, 9, 12, 17] 。
         *
         * 与Set 只提供了一个iterator()方法不同， List 还额外提供了一个listIteratorO方法，该方法返回一个ListIterator 对象， ListIterator 接口继承了Iterator 接口，
         * 提供了专门操作List 的方法。ListIterator 接口在Iterator 接口基础上增加了如下方法。
         * boolean hasPrevious: 返回该迭代器关联的集合是否还有上一个元素。
         * Object previous(): 返回该迭代器的上一个元素。
         * void add(Object o): 在指定位置插入一个元素。
         *
         * 拿ListIterator 与普通的Iterator 进行对比，不难发现ListIterator 增加了向前迭代的功能( Iterator 只能向后法代) ，而且ListIterator 还可通过add()方法向List
         * 集合中添加元素( Iterator 只能删除元素) 。下面程序示范了ListIterator 的用法。
         */
        ListIterator lit = books.listIterator();
        while (lit.hasNext()) {
            System.out.println(lit.next());
            lit.add("-----------------------");
        }
        System.out.println("下面开始反向迭代");
        while (lit.hasPrevious()) {
            System.out.println(lit.previous());
        }

        /**
         * 从上面程序中可以看出，使用ListIterator 迭代List 集合时，开始也需要采用正向迭代，即先使用next()方法进行迭代，
         * 在迭代过程中可以使用add()方法向上一次迭代元素的后面添加一个新元素。
         */
    }

    class A{
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }
}
