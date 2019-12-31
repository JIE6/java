package collection.set;

import java.util.Date;
import java.util.TreeSet;

/**
 * TreeSet 类 与 自然排序、定制排序
 *
 * TreeSet 是SortedSet 接口的实现类，正如SortedSet 名字所暗示的， TreeSet 可以确保集合元素处于排序状态。
 * 与HashSet 集合相比， TreeSet 还提供了如下几个额外的方法。
 *
 * Comparator comparator(): 如果TreeSet 采用了定制排序，则该方法返回定制排序所使用的Comparator; 如果TreeSet 采用了自然排序，则返回null 。
 * Object first(): 返回集合中的第一个元素。
 * Object last(): 返回集合中的最后一个元素。
 * Object lower(Object e) : 返回集合中位于指定元素之前的元素(即小于指定元素的最大元素，参考元素不需要是TreeSet 集合里的元素) 。
 * Object higher(Object e): 返回集合中位于指定元素之后的元素(即大于指定元素的最小元素，参考元素不需要是TreeSet 集合里的元素) 。
 * SortedSet subSet(Object fromElement, Object toElement): 返回此Set 的子集合，范围从fromElement(包含〉到toElement (不包含) 。
 * SortedSet headSet(Object toElement): 返回此Set 的子集，由小于toElement 的元素组成。
 * SortedSet tailSet(Object 仕omElement): 返回此Set 的子集，由大于或等于企omElement 的元素组成。
 *
 * 表面上看起来这些方法很多，其实它们很简单:因为TreeSet 中的元素是有序的，所增加了访问第一个、前一个、后一个、最后一个元素的方法，
 * 并提供了三个从TreeSet中截取子TreeSet 的方法。
 *
 * 下面程序测试了TreeSet 的通用用法。
 * @author JIE
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet nums = new TreeSet();
        // 向TreeSet 中添加四个Integer 对象
        nums.add(5);
        nums.add(2);
        nums.add(10);
        nums.add(-9);
        // 输出集合元素， 看到集合元素已经处于排序状态
        System.out.println(nums);
        // 输出集合里的第一个元素
        System.out.println(nums.first());
        // 输出集合里的最后一个元素
        System.out.println(nums.last());
        // 返回小于5 的子集，不包含 5
        System.out.println(nums.headSet(5));
        // 返回大于5 的子集，如果Set 中包含5 ， 子集中还包含5
        System.out.println(nums.tailSet(5));
        // 返回大于等于-9 、小于 5 的子集
        System.out.println(nums.subSet(-3, 5));

        /**
         * 根据上面程序的运行结果即可看出， TreeSet 并不是根据元素的插入顺序进行排序的，而是根据元素实际值的大小来进仔排序的。
         *
         * 与HashSet 集合采用hash 算法来决定元素的存储位置不同， TreeSet 采用红黑树的数据结构来存储集合元素。
         * 那么TreeSet 进行排序的规则是怎样的呢? TreeSet 支持两种排序方法: 自然排序和定制排序。在默认情况下， TreeSet 采用自然排序。
         *
         * 1.自然排序
         * TreeSet 会调用集合元素的compareTo(Object obj)方法来比较元素之间的大小关系，然后将集合元素按升序排列， 这种方式就是自然排序。
         *
         * Java 提供了一个Comparable 接口， 该接口里定义了一个compareTo(Object obj )方法， 该方法返回一个整数值， 实现该接口的类必须实现该方法，
         * 实现了该接口的类的对象就可以比较大小。当一个对象调用该方法与另一个对象进行比较时，例如obj1.compareTo(obj2) ，如果该方法返回0 ，则表明这两个对象相等:
         * 如果该方法返回一个正整数，则表明obj1 大于obj2; 如果该方法返回一个负整数，则表明obj1小于obj2 。
         *
         * Java 的一些常用类已经实现了Comparable 接口，并提供了比较大小的标准。下面是实现了Comparable 接口的常用类。
         * BigDecimal 、BigInteger 以及所有的数值型对应的包装类: 按它们对应的数值大小进行比较。
         * Character: 按字符的UNICODE 值进行比较。
         * Boolean: true 对应的包装类实例大于false 对应的包装类实例。
         * String: 按字符串中字符的UNICODE  值进行比较。
         * Date 、Time: 后面的时间、日期比前面的时间、日期大。
         *
         * 如果试图把一个对象添加到TreeSet 时，则该对象的类必须实现Comparable 接口，否则程序将会抛
         * 出异常。如下程序示范了这个错误。
         */
        // collection.set.TreeSetTest cannot be cast to java.base/java.lang.Comparable
//        new TreeSet().add(new TreeSetTest());
        /**
         * 还有一点必须指出:大部分类在实现compareTo(Object obj)方法时，都需要将被比较对象obj 强制类型转换成相同类型，
         * 因为只有相同类的两个实例才会比较大小。当试图把一个对象添加到TreeSet 集合时，
         * TreeSet 会调用该对象的compareTo(Object obj)方法与集合中的其他元素进行比较,
         * 这就要求集合中的其他元素与该元素是同一个类的实例。也就是说，向TreeSet 中添加的应该是同一个类的对象，
         * 否则也会引发ClassCastException 异常。如下程序示范了这个错误。
         */
        TreeSet treeSet = new TreeSet();
//        treeSet.add("1");
//        treeSet.add(new Date());
        /**
         * 上面程序先向TreeSet 集合中添加了一个字符串对象，这个操作完全正常。当添加第二个Date 对象时， TreeSet 就会调用该对象的compareTo(Object obj)方法与集合中的其他元素进行比较
         * Date 对象的compareTo(Object obj)方法无法与字符串对象比较大小，所以上面程序将在①代码处引发异常。
         *
         * 如果向TreeSet 中添加的对象是程序员自定义类的对象，则可以向TreeSet 中添加多种类型的对象，前提是用户自定义类实现了Comparable 接口，
         * 且实现compareTo(Object obj)方法没有进行强制类型转换。但当试图取出TreeSet 里的集合元素时，不同类型的元素依然会发生ClassCastException 异常。
         *
         * 总结:如果希望TreeSet 能正常运作， TreeSet 只能添加同一种类型的对象。
         *
         * 当把一个对象加入TreeSet 集合中时， TreeSet 调用该对象的compareTo(Object obj)方法与容器中的其他对象比较大小，然后根据红黑树结构找到它的存储位置。
         * 如果两个对象通过compareTo(Object obj)方法比较相等，新对象将无法添加到TreeSet 集合中。
         *
         * 对于TreeSet 集合而言，它判断两个对象是否相等的唯一标准是:两个对象通过compareTo(Object obj)方法比较是否返回0, 如果通过compareTo(Object obj)方法比较返回0 ，
         * TreeSet 则会认为它们相等;否则就认为它们不相等。看下面程序
         */
        TreeSet ts = new TreeSet();
        Z z1 = new TreeSetTest().new Z(6);
        ts.add(z1);
        // 第二次添加同一个对象，输出true ，表明添加成功    1
        System.out.println(ts.add(z1));
        // 下面输出set 集合，将看到有两个元素
        System.out.println(ts);
        // 修改set 集合的第一个元素的age 变量
        ((Z)ts.first()).age = 9;
        // 输出set 集合的最后一个元素的age 变量，将看到也变成了9
        System.out.println(((Z)ts.last()).age);

        /**
         * 程序中 1 代码行把同一个对象再次添加到TreeSet 集合中， 因为z1 对象的compareTo(Object obj )方法总是返回1，
         * 虽然它的equals()方法总是返回true ， 但TreeSet会认为z1 对象和它自己也不相等，因此TreeSet 可以添加两个z1 对象
         *
         * TreeSet 对象保存的两个元素(集合里的元素总是引用，但习惯上把被引用的对象称为集合元素) ，实际上是同一个元素。
         * 所以当修改TreeSet 集合里第一个元素的age 变量后， 该TreeSet 集合里最后一个元素的age 变量也随之改变了。
         *
         * 由此应该注意一个问题: 当需要把一个对象放入TreeSet 中， 重写该对象对应类的equals()方法时，应保证该方法与compareTo(Object obj )方法有一致的结果，
         * 其规则是: 如果两个对象通过equals()方法比较返回true 时，这两个对象通过compareTo (Object obj)方法比较应返回0 。
         *
         * 如果两个对象通过compareTo(Object obj)方法比较返回0 时，但它们通过equalsO方法比较返回false将很麻烦， 因为两个对象通过compareTo(Object obj )方法比较相等，
         * TreeSet 不会让第二个元素添加进去，这就会与Set 集合的规则产生冲突。
         *
         * 如果向TreeSet 中添加一个可变对象后，并且后面程序修改了该可变对象的实例变量， 这将导致它与其他对象的大小顺序发生了改变， 但TreeSet 不会再次调整它们的顺序，
         * 甚至可能导致TreeSet 中保的这两个对象通过compareTo(Object obj)方法比较返回0 。下面程序演示了这种情况。
         */
        TreeSet ts3 = new TreeSet();
        ts3.add(new TreeSetTest().new R(5));
        ts3.add(new TreeSetTest().new R(-3));
        ts3.add(new TreeSetTest().new R(9));
        ts3.add(new TreeSetTest().new R(-2));
        // 打印TreeSet 集合，集合元素是有序排列的  1
        System.out.println(ts3);
        // 取出第一个元素
        R first = (R)ts3.first() ;
        // 对第一个元素的count 赋值
        first.count = 20;
        // 取出最后一个元素
        R last = (R)ts3.last() ;
        // 对最后一个元素的count 赋值，与第二个元素的count 相同
        last.count = -2;
        // 再次输出将看到TreeSet 里的元素处于无序状态，且有重复元素     2
        System.out.println(ts3);
        // 删除实例变量被改变的元素，删除失败
        System.out.println(ts3.remove(new TreeSetTest().new R(-2)));
        System.out.println(ts3);
        // 删除实例变量没有被改变的元素， 删除成功
        System.out.println(ts3.remove(new TreeSetTest().new R(5)));
        // 3
        System.out.println(ts3);
        // 在次删除被改变的元素
        System.out.println(ts3.remove(new TreeSetTest().new R(-2)));
        System.out.println(ts3);
        System.out.println(ts3.remove(new TreeSetTest().new R(-2)));
        System.out.println(ts3);
        System.out.println(ts3.remove(new TreeSetTest().new R(-2)));
        System.out.println(ts3);
        /**
         * 上面程序中的R 对象对应的类正常重写了equals()方法和compareTo ()方法， 这两个方法都以R 对象的count 实例变量作为判断的依据。当程序执行 1 代码时，
         * 看到程序输出的Set 集合元素处于有序状态: 因为R 类是一个可变类，因此可以改变R 对象的count 实例变量的值，程序通过代码行改变了该集合里第一个元素和
         * 最后一个元素的count 实例变量的值。当程序执行 2 代码输出时，将看到该集合处于无序状态，而且集合中包含了重复元素。
         *
         * 一旦改变了TreeSet 集合里可变元素的实例变量， 当再试图删除该对象时， TreeSet 也会删除失败(甚至集合中原有的、实例变量没被修改但与修改后元素相等的元素也无法删除) ，
         * 所以在上面程序，删除count 为-2 的R 对象时， 没有任何元素被删除;删除了count为5 的R 对象， 这表明TreeSet 可以删除没有被修改实例变量、且不与其他被修改实例变量的对象重复的对象
         *
         * 当执行了 3 代码后， TreeSet 会对集合中的元素重新索引(不是重新排序) ，接下来就可以删除TreeSet 中的所有元素了，包括那些被修改过实例变量的元素。与HashSet 类似的是
         * 如果TreeSet 中包含了可变对象，当可变对象的实例变量被修改时， TreeSet 在处理这些对象时将非常复杂，而且容易出错。为了让程序史加健壮，
         * 推荐不要修改放入HashSet和TreeSet 集合中元素的关键实例变量。
         */

        /**
         * 2.定制排序
         *
         * TreeSet 的自然排序是根据集合元素的大小， TreeSet 将它们以升序排列。如果需要实现定制排序，例如以降序排列，则可以通过Comparator 接口的帮助。
         * 该接口里包含一个int compare(T o1 , T o2)方法，该方法用于比较o1 和o2 的大小:如果该方法返回正整数，则表明o1 大于o2; 如果该方法返回0 ，则
         * 表明o1 等于o2; 如果该方法返回负整数， 则表明o1 小于o2 .
         *
         * 如果需要实现定制排序，则需要在创建TreeSet 集合对象时，提供一个Comparator 对象与该TreeSet集合关联， 由该Comparator 对象负责集合元素的排序逻辑。
         * 由于Comparator 是一个函数式接口，因此可使用Lambda 表达式来代替Comparator 对象。
         */
        // 此处Lambda 表达式的目标类型是Comparator
        TreeSet ts4 = new TreeSet(((o1, o2) -> {
            M m1 = (M) o1;
            M m2 = (M) o2;
            // 根据M 对象的aqe 属性来决定大小， aqe 越大， M 对象反而越小
            return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
        }));
        ts4.add(new TreeSetTest().new M(5));
        ts4.add(new TreeSetTest().new M(-3));
        ts4.add(new TreeSetTest().new M(9));
        System.out.println(ts4);
        /**
         * 上面程序中使用了目标类型为Comparator 的Lambda 表达式， 它负责ts 集合的排序。所以当把M 对象添加到ts 集合中时，无须M 类实现Comparable 接口，
         * 因为此时TreeSet 无须通过M对象本身来比较大小，而是由与TreeSet 关联的Lambda 表达式来负责集合元素的排序
         *
         * 当通过Comparator 对象(或Lambda 表达式)末实现TreeSet 的定制排序时，依然不可以向TreeSet 中添加类型不同的对象，否则会引发ClassCastException 异常。
         * 使用定制排序时， TreeSet 对集合元素排序不管集合元素本身的大小，而是由Comparator 对象(或Lambda 表达式)负责集合元素的排序规则。
         * TreeSet 判断两个集合元素相等的标准是:通过Comparator (或Lambda 表达式)比较两个元素返回了0 ，这样TreeSet 不会把第二个元素添加到集合中。
         */
    }

    class Z implements Comparable{

        int age;

        public Z(int age) {
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int compareTo(Object o) {
            return 1;
        }
    }

    class R implements Comparable{

        int count;

        public R (int count) {
            this.count = count;
        }

        /**
         * 重写compareTo ()方法，根据count 来比较大小
         * @param o
         * @return
         */
        @Override
        public int compareTo(Object o) {
            R r = (R)o;
            return this.count > r.count ? 1 : this.count < r.count ? -1 : 0;
        }

        /**
         * 重写equals ()方法，根据count 来判断是否相等
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == R.class) {
                return ((R)obj).count == this.count;
            }
            return false;
        }

        @Override
        public String toString() {
            return "R[count: "+count+"]";
        }
    }
    class M{

        int age;

        public M (int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "M[age: "+age+"]";
        }
    }
}
