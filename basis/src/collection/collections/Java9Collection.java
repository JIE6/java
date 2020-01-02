package collection.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Java 9 新增的不可变集合
 *
 * Java 9 终于增加这个功能了， 以前假如要创建一个包含6 个元素的Set 集合， 程序需要先创建Set集合，然后调用6 次add()方法向Set 集合中添加元素
 * Java 9 对此进行了简化， 程序直接调用Set 、List、Map 的of()方法即可创建包含N 个元素的不可变集合，这样一行代码就可创建包含N 个元素的集合。
 * 不可变意味着程序不能向集合中添加元素，也不能从集合中删除元素。
 * 如下程序示范了如何创建不可变集合。
 *
 * @author JIE
 */
public class Java9Collection {

    public static void main(String[] args) {
        // 创建包含4 个元素的Set 集合
        Set<String> set = Set.of("Java", "python", "Go", "Swift");
        System.out.println(set);
        // 不可变集合，下面代码导致运行时错误
//        set.add("");
//        set.remove("Java");
        // 创建包含4 个元素的List 集合
        List<Integer> list = List.of(34, -25, 67, 231, 125, -25);
        System.out.println(list);
        // 不可变集合，下面代码导致运行时错误
//        list.add(1);
//        list.remove(0);
        // //创建包含3 个key-value 对的Map 集合
        Map<String, Integer> map = Map.of("语文", 89, "数学", 82, "英语", 92);
        System.out.println(map);
        // 不可变集合，下面代码导致运行时错误
//        map.remove("语文");
        // 使用Map.entry ()方法显式构建key- value 对
        Map map2 = Map.ofEntries(
                Map.entry("语文", 89),
                Map.entry("数学", 82),
                Map.entry("英语", 92)
        );
        System.out.println(map2);
        // 不可变集合，下面代码导致运行时错误
        map2.remove("语文");

        /**
         * 上面代码示范了如何使用集合元素创建不可变集合，其中Set 、List 比较简单，程序只要为它们的of()方法传入N 个集合元素即可创建Set 、List 集合。
         *
         * 创建不可变的Map 集合有两个方法:使用of()方法时只要依次传入多个key-value 对即可;
         * 还可使用ofEntries()方法，该方法可接受多个Entry 对象，因此程序显式使用Map.entry()方法来创建Map.Entry 对象。
         */
    }
}
