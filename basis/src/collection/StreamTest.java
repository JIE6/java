package collection;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 使用Java 8 新增的Stream 操作集合
 *
 * Java 8 还新增了Stream 、IntStream 、LongStream 、DoubleStream 等流式API，这些API 代表多个支持串行和并行聚集操作的元素。
 * 上面4 个接口中， Stream 是一个通用的流接口，而IntStream 、LongStream 、DoubleStream 则代表元素类型为int 、long 、double 的流。
 *
 * Java 8 还为上面每个流式 API 提供了对应的 Builder，例如 Stream.Builder、IntStream.Builder、LongStream.Builder、DoubleStream.Builder
 * 开发者可以通过这些Builder 来创建对应的流。
 *
 * 独立使用Stream 的步骤如下:
 * 1.使用Stream 或XxxStream 的builder()类方法创建该Stream 对应的Builder
 * 2.重复调用Builder 的add()方法向该流中添加多个元素。
 * 3.调用Builder 的build()方法获取对应的Stream
 * 4.调用Stream 的聚集方法
 * 在上面4 个步骤中，第4 步可以根据具体需求来调用不同的方法， Stream 提供了大量的聚集方法供用户调用，具体可参考Stream 或XxxStream 的API 文档。
 * 对于大部分聚集方法而言，每个Stream 只能执行一次。例如如下程序。
 * @author JIE
 */
public class StreamTest {

    public static void main(String[] args) {
        IntStream is = IntStream.builder()
                                .add(20)
                                .add(13)
                                .add(-2)
                                .add(18)
                                .build();
        // 下面调用聚集方法的代码每次只能执行一行
//        System.out.println("is 所有元素的最大值: " + is.max().getAsInt());
//        System.out.println("is 所有元素的最小值: " + is.min().getAsInt());
//        System.out.println("is 所有元素的总和: " + is.sum());
//        System.out.println("is 所有元素的总数: " + is.count());
//        System.out.println("is 所有元素的平均值: " + is.average().getAsDouble());
//        System.out.println("is 所有元素的平方是否都大于20: " + is.allMatch(ele -> ele * ele > 20));
//        System.out.println("is 是否包含任何元素的平方大于20: " + is.anyMatch(ele -> ele * ele > 20));

        // 将is 映射成一个新Stream ，新Stream 的每个元素是原Stream 元素的2 倍+1
        IntStream newIs = is.map(ele -> ele * 2 + 1);
        // 使用方法引用的方式来遍历集合元素
        newIs.forEach(System.out::println);

        /**
         * 上面程序先创建了一个IntStream ，接下来分别多次调用IntStream 的聚集方法执行操作，这样即可获取该流的相关信息
         * 注意:上面粗体字代码每次只能执行一行，因此需要把其他代码注释掉。
         *
         * Stream 提供了大量的方法进行聚集操作，这些方法既可以是"中间的" ( intermediate ) ，也可以是"末端的" ( terminal) 。
         * 中间方法:中间操作允许流保持打开状态，并允许直接调用后续方法。上面程序中的map()方法就是中间方法。中间方法的返回值是另外一个流。
         * 末端方法:末端方法是对流的最终操作。当对某个Stream 执行末端方法后，该流将会被"消耗"且不再可用。上面程序中的sum 、count 、average等方法都是末端方法。
         *
         * 除此之外，关于流的方法还有如下两个特征。
         * 有状态的方法:这种方法会给流增加一些新的属性，比如元素的唯一性、元素的最大数量、保证元素以排序的方式被处理等。有状态的方法往往需要更大的性能开销。
         * 短路方法:短路方法可以尽早结束对流的操作，不必检查所有的元素。
         *
         * 下面简单介绍一下Stream 常用的中间方法。
         * filter(Predicate predicate): 过滤Stream 中所有不符合predicate 的元素。
         * mapToXxx(ToXxxFunction mapper): 使用ToXxxFunction 对流中的元素执行一对一的转换，该方法返回的新流中包含了ToXxxFunction 转换生成的所有元素。
         * peek(Consumer action): 依次对每个元素执行一些操作，该方法返回的流与原有流包含相同的元素。该方法主要用于调试。
         * distinct(): 该方法用于排序流中所有重复的元素(判断元素重复的标准是使用equals() 比较返回true) 。这是一个有状态的方法。
         * sorted(): 该方法用于保证流中的元素在后续的访问中处于有序状态。这是一个有状态的方法
         * limit(long maxSize): 该方法用于保证对该流的后续访问中最大允许访问的元素个数。这是一个有状态的、短路方法。
         *
         * 下面简单介绍一下Stream 常用的末端方法。
         * forEach(Consumer action): 遍历流中所有元素，对每个元素执行action
         * toArray(): 将流中所有元素转换为一个数组。
         * reduce(): 该方法有三个重载的版本，都用于通过某种操作来合并流中的元素。
         * min(): 返回流中所有元素的最小值。
         * max(): 返回流中所有元素的最大值。
         * count(): 返回流中所有元素的数量。
         * anyMatch(Predicate predicate): 判断流中是否至少包含一个元素符合Predicate 条件。
         * allMatch(Predicate predicate): 判断流中是否每个元素都符合Predicate 条件。
         * noneMatch(predicate predicate): 判断流中是否所有元素都不符合Predicate 条件。
         * findFirst(): 返回流中的第一个元素。
         * findAny(): 返回流中的任意一个元素。
         *
         *
         * 除此之外， Java 8 允许使用流式API 来操作集合， Collection 接口提供了一个stream()默认方法，该方法可返回该集合对应的流，
         * 接下来即可通过流式API 来操作集合元素。由于Stream 可以对集合元素进行整体的聚集操作，因此S位eam 极大地丰富了集合的功能。
         *
         * 例如，对于PredicateTest的示例程序, 该程序需要额外定义一个calAll方法来遍历集合元素，然后依次对每个集合元素进行判断,
         * 这太麻烦了。如果使用Stream，即可直接对集合中所有元素进行批量操作, 下面使用Stream 来改写这个程序。
         */
        Collection books2 = new HashSet();
        books2.add(new String("轻量级Java EE 企业应用实战"));
        books2.add(new String("疯狂Java 讲义"));
        books2.add(new String("疯狂iOS 讲义"));
        books2.add(new String("疯狂町ax 讲义"));
        books2.add(new String("疯狂Android 讲义"));
        Stream bookStream = books2.stream();
//        System.out.println(bookStream.filter(ele -> ((String) ele).contains("疯狂")).count());
//        System.out.println(bookStream.filter(ele -> ((String) ele).contains("Java")).count());
        System.out.println(bookStream.filter(ele -> ((String) ele).length() > 10).count());
        // 先调用Collection 对象的stream ()方法将集合转换为Stream, 再调用Stream 的mapToInt()方法获取原有的Stream 对应的IntStream
        books2.stream().mapToInt(ele -> ((String)ele).length()).forEach(System.out::println);

        /**
         * 从上面程序中可以看出， 程序只要调用Collection 的stream方法即可返回该集合对应的Stream ，接下来就可通过Stream 提供的方法对所有集合元素进行处理，
         * 这样大大地简化了集合编程的代码，这也是Stream 编程带来的优势。
         *
         * 上面程序中最后一段祖体字代码先调用Collection 对象的stream方法将集合转换为Stream 对象，然后调用Stream 对象的mapToInt()方法将其转换为IntStream
         * 这个mapToInt()方法就是一个中间方法，因此程序可继续调用IntStream 的forEach()方法来遍历流中的元素。
         */
    }
}
