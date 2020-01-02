package collection.collections;

import java.util.*;

/**
 * 设置不可变集合
 *
 * Collections 提供了如下三类方法来返回一个不可变的集合。
 * emptyXxx(): 返回一个空的、不可变的集合对象，此处的集合既可以是List ， 也可以是SortedSet 、Set ， 还可以是Map 、SortedMap 等。
 * singletonXxx(): 返回一个只包含指定对象(只有一个或一项元素)的、不可变的集合对象，此处的集合既可以是List ， 还可以是Map 。
 * unmodifiableXxx(): 返回指定集合对象的不可变视图，此处的集合既可以是List ，也可以是SortedSet 、Set  ，还可以是Map 、SortedMap 等。
 *
 * 上面三类方法的参数是原有的集合对象，返回值是该集合的"只读"版本。通过Collections 提供的三类方法，可以生成"只读"的Collection 或Map 。
 * 看下面程序。
 * @author JIE
 */
public class UnmodifiableTest {

    public static void main(String[] args) {
        // 创建一个空的、不可改变的List 对象
        List<Object> unmodifiableList = Collections.emptyList();
        // 创建一个只有一个元素，且不可改变的Set 对象
        Set<String> unmodifiableSet = Collections.singleton("疯狂Java 讲义");
        // 创建一个普通的Map 对象
        Map scores = new HashMap() ;
        scores.put("语文", 80);
        scores.put("Java", 82);
        // 返回普通的Map 对象对应的不可变版本
        Map unmodifiableMap = Collections.unmodifiableMap(scores);
        // 下面任意一行代码都将引发UnsupportedOperationException 异常
        unmodifiableList.add("测试元素");
        unmodifiableSet.add("测试元素");
        unmodifiableMap.put("数学", 90);

        /**
         * 上面程序分别定义了一个空的、不可变的List 对象， 一个只包含一个元素的、不可变的Set 对象和一个不可变的Map 对象。
         * 不可变的集合对象只能访问集合元素，不可修改集合元素。所以上面程序中最后三行代码都将引发UnsupportedOperationException 异常。
         */
    }
}
