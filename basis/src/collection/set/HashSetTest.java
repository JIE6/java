package collection.set;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet 类
 *
 * HashSet 是Set 接口的典型实现，大多数时候使用Set 集合时就是使用这个实现类。HashSet 按Hash算法来存储集合中的元素，因此具有很好的存取和查找性能。
 *
 * HashSet 具有以下特点。
 * 1.不能保证元素的排列顺序，顺序可能与添加顺序不同，顺序也有可能发生变化。
 * 2.HashSet 不是同步的，如果多个线程同时访问一个HashSet，假设有两个或者两个以上线程同时修改了HashSet 集合时，则必须通过代码来保证其同步。
 * 3.集合元素值可以是null 。
 *
 * 当向HashSet 集合中存入一个元素时， HashSet 会调用该对象的hashCodeO方法来得到该对象的hashCode 值，然后根据该hashCode 值决定该对象在HashSet 中的存储位置。
 * 如果有两个元素通过equals()方法比较返回true ，但它们的hashCode()方法返回值不相等， HashSet 将会把它们存储在不同的位置，依然可以添加成功。
 *
 * 也就是说， HashSet 集合判断两个元素相等的标准是两个对象通过equals()方法比较相等，并且两个对象的hashCode()方法返回值也相等。
 *
 * 下面程序分别提供了三个类A 、B 和C ，它们分别重写了equals() 、hashCode()两个方法的一个或全部，通过此程序可以看到HashSet 判断集合元素相同的标准。
 *
 * @author JIE
 */
public class HashSetTest {

    /**
     * 类A 的equals ()方法总是返回true ，但没有重写其hashCode()方法
     */
    class A{
        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    /**
     * 类B 的hashCode()方法总是返回1 ，但没有重写其equals ()方法
     */
    class B{
        @Override
        public int hashCode() {
            return 1;
        }
    }

    /**
     * 类C 的hashCode ()方法总是返回2 ，且重写其equals ()方法总是返回true
     */

    class C{
        @Override
        public int hashCode() {
            return 2;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }
    }

    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        // 分别向hashSet 集合中添加两个A 对象、两个B 对象、两个C 对象
        hashSet.add(new HashSetTest().new A());
        hashSet.add(new HashSetTest().new A());
        hashSet.add(new HashSetTest().new B());
        hashSet.add(new HashSetTest().new B());
        hashSet.add(new HashSetTest().new C());
        hashSet.add(new HashSetTest().new C());
        System.out.println(hashSet);

        /**
         * 上面程序中向hashSet 集合中分别添加了两个A 对象、两个B 对象和两个C 对象，其中C 类重写了equals()方法总是返回true ， hashCode()方法总是返回2 ，
         * 这将导致HashSet 把两个C 对象当成同一个对象
         *
         * 从上面程序结果可以看出，即使两个A 对象通过equals()方法比较返回true ，但HashSet 依然把它们当成两个对象:
         * 即使两个B 对象的hashCode()返回相同值〈都是1)， 但HashSet 依然把它们当成两个对象
         *
         * 这里有一个注意点: 当把一个对象放入HashSet 中时， 如果需要重写该对象对应类的equals()方法，则也应该重写其hashCode()方法。
         * 规则是:如果两个对象通过equals()方法比较返回true ，这两个对象的hashCode 值也应该相同。
         *
         * 如果两个对象通过equals()方法比较返回true ，但这两个对象的hashCode()方法返回不同的hashCode值时，
         * 这将导致HashSet 会把这两个对象保存在Hash 表的不同位置， 从而使两个对象都可以添加成功，这就与Set 集合的规则冲突了。
         *
         * 如果两个对象的hashCode()方法返回的hashCode 值相同， 但它们通过equals()方法比较返回false时将更麻烦:
         * 因为两个对象的hashCode 值相同， HashSet 将试图把它们保存在同一个位置， 但又不行(否则将只剩下一个对象) ，
         * 所以实际上会在这个位置用链式结构来保存多个对象; 而HashSet 访问集合元素时也是根据元素的hashCode 值来快速定位的，
         * 如果HashSet 中两个以上的元素具有相同的hashCode值，将会导致性能下降。
         *
         * HashSet 中每个能存储元素的"槽位" ( slot ) 通常称为"桶" ( bucket) ，如果有多个元素的hashCode值相同，
         * 但它们通过equals()方法比较返回false ，就需要在一个"桶"里放多个元素，这样会导致性能下降。
         *
         * 重写hashCode()方法的基本规则。
         * 1.在程序运行过程中，同一个对象多次调用hashCode()方法应该返回相同的值。
         * 2.当两个对象通过equals()方法比较返回true 时，这两个对象的hashCode()方法应返回相等的值。
         * 3.对象中用作equals()方法比较标准的实例变量，都应该用于计算hashCode 值。
         *
         * 下面给出重写hashCode()方法的一般步骤。
         * 1.把对象内每个有意义的实例变量( 即每个参与equals()方法比较标准的实例变量) 计算出一个int 类型的hashCode 值。计算方式如下表 所示。
         * -----------------------------------------------------------------------------------------------------------------------
         * 实例变量类型                                                计算方式
         * -----------------------------------------------------------------------------------------------------------------------
         * boolean                                                 hashCode = (f ? 0: 1);
         * 整数类型(byte, short, char, int)                         hashCode = (int)f;
         * long                                                    hashCode = (int)(f ^ (f >>> 32));
         * float                                                   hashCode = Float.floatToIntBits(f);
         * double                                                  long l = Double.DoubleToLongBits(f); hashCode = (int)(l ^ (l >>> 32))
         * 引用类型                                                 hashCode = f.hashCode();
         * -----------------------------------------------------------------------------------------------------------------------
         * 2.用第1 步计算出来的多个hashCode 值组合计算出一个hashCode 值返回。例如如下代码:
         * return f1.hashCode() + (int)f2;
         * 为了避免直接相加产生偶然相等(两个对象的f1 、f2实例变量并不相等，但它们的hashCode 的和恰好相等)，
         * 可以通过为各实例变量的hashCode 值乘以任意一个质数后再相加。例如如下代码:
         * return f1.hashCode() * 19 + (int)f2 * 31;
         * 如果向HashSet 中添加一个可变对象后，后面程序修改了该可变对象的实例变量，
         * 则可能导致它与集合中的其他元素相同(即两个对象通过equals()方法比较返回true ，两个对象的hashCode 值也相等) ,
         * 这就有可能导致HashSet 中包含两个相同的对象。下面程序演示了这种情况。
         */

        HashSet hs = new HashSet();
        hs.add(new HashSetTest().new R(5));
        hs.add(new HashSetTest().new R(-3));
        hs.add(new HashSetTest().new R(9));
        hs.add(new HashSetTest().new R(-2));
        // 打印HashSet 集合，集合元素没有重复
        System.out.println(hs);
        // 取出第一个元素
        Iterator it = hs.iterator();
        HashSetTest.R firstR = (R)it.next();
        // 为第一个元素的count 实例变量赋值      1
        firstR.count = -3;
        // 再次输出HashSet 集合，集合元素有重复元素
        System.out.println(hs);
        // 删除count 为-3 的R 对象
        System.out.println(hs.remove(new HashSetTest().new R(-3)));
        // 可以看到被删除了一个R 元素
        System.out.println(hs);
        System.out.println("hs 是否包含count 为-3 的R 对象?" + hs.contains(new HashSetTest().new R(-3)));
        System.out.println("hs 是否包含count 为-2 的R 对象?" + hs.contains(new HashSetTest().new R(-2)));

        /**
         * 上面程序中提供了R 类， R 类重写了equals(Object obj)方法和hashCode()方法，这两个方法都是根据R对象的count 实例变量来判断的。
         * 上面程序的 1 号代码处改变了Set 集合中第一个R 对象的count实例变量的值，这将导致该R 对象与集合中的其他对象相同。
         *
         * 正如上面程序结果中所见到的， HashSet 集合中的第1 个元素和第2 个元素完全相同，这表明两个元素已经重复。此时HashSet 会比较混乱:
         * 当试图删除count 为 -3 的R 对象时， HashSet 会计算出该对象的hashCode 值，从而找出该对象在集合中的保存位置，
         * 然后把此处的对象与count 为 -3 的R 对象通过equals()方法进行比较，如果相等则删除该对象, HashSet 只有第2 个元素才满足该条件
         * (第 1 个元素实际上保存在count 为-2 的R 对象对应的位置)所以第2 个元素被删除。至于第一个count 为-3 的R 对象，它保存在count 为-2 的R 对象对应的位置，
         * 但使用equals()方法拿它和count 为一2 的R 对象比较时又返回false, 这将导致HashSet 不可能准确访问该元素。
         *
         * 由此可见，当程序把可变对象添加到HashSet 中之后，尽量不要去修改该集合元素中参与计算hashCode() 、equals() 的实例变量，否则将会导致HashSet 无法正确操作这些集合元素。
         */
    }



    class R{
        int count;
        public R(int count) {
            this.count = count;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj != null && obj.getClass() == R.class) {
                R r = (R)obj;
                return this.count == r.count;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.count;
        }

        @Override
        public String toString() {
            return "R[count: "+count+"]";
        }
    }
}
