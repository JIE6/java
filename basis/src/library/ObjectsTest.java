package library;

import java.util.Objects;

/**
 * Java 7 新增的Objects 类
 * Java 7 新增了一个Objects 工具类， 它提供了一些工具方法来操作对象，这些工具方法大多是"空指针"安全的。
 * 比如你不能确定一个引用变量是否为null，如果贸然地调用该变量的toString()方法，则可能引发NullPointerException 异常;
 * 但如果使用Objects 类提供的toString(Object o)方法， 就不会引发空指针异常，当。为null 时，程序将返回一个"null"字符串。
 *
 * Java 为工具类的命名习惯是添加一个字母 s 比如操作数组的工具类是Arrays ， 操作集合的工具类是Collections 。
 * @author JIE
 */
public class ObjectsTest {

    /**
     * 定义一个obj 变量， 它的默认值是null
     */
    static ObjectsTest objectsTest;

    public static void main(String[] args) {
        // 输出一个null 对象的hashCode 值， 输出O
        System.out.println(Objects.hashCode(objectsTest));
        // 输出一个null 对象的toString ， 输出null
        System.out.println(Objects.toString(objectsTest));
        // 要求objectsTest 不能为null ，如果objectsTest 为null 则引发异常
        System.out.println(Objects.requireNonNull(objectsTest, "objectsTest 参数不能是null"));

        /**
         * 上面程序还示范了Objects 提供的requireNonNull()方法，当传入的参数不为null 时，该方法返回参数本身:否则将会引发NullPointerException 异常。
         * 该方法主要用来对方法形参进行输入校验，例如test()
         */
    }

    public ObjectsTest test(ObjectsTest objectsTest) {
        // 校验objectsTest 参数，如果objectsTest 参数为null 将引发异常;否则this.objectsTest 被赋值为objectsTest 参数
        ObjectsTest.objectsTest = Objects.requireNonNull(objectsTest);
        return ObjectsTest.objectsTest;
    }
}
