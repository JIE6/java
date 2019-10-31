package objecttwo;

/**
 * ==和equals方法
 * Java 程序中测试两个变量是否相等有两种方式:
 * 1.利用==运算符
 * 2.利用equals()方法
 * 当使用==来判断两个变量是否相等时，如果两个变量是基本类型变量，且都是数值类型(不一定要求数据类型严格相同) ，则只要两个变量的值相等，就将返回true 。
 * 但对于两个引用类型变量，只有它们指向同一个对象时，==判断才会返回true.
 * ==不可用于比较类型上没有父子关系的两个对象。
 * @author JIE
 */
public class EqualsFunction {

    public static void main(String[] args) {
        int it = 65;
        float fl = 65.0F;
        // true
        System.out.println("65和65.0F是否相等？"+(it == fl));
        char ch = 'A';
        // true
        System.out.println("65和'A'是否相等？"+(it == ch));

        String str1 = new String("hello");
        String str2 = new String("hello");
        // false
        System.out.println("str1和str2是否相等？"+(str1 == str2));
        // true
        System.out.println("str1是否equals str2？"+(str1.equals(str2)));
        // 由于java.lang.String 与EqualsFunction 类没有继承关系
        // 所以下面语句导致编译错误
        // System.out.println("hello" == new EqualsFunction());
        /**
         * 运行上面程序， 可以看到65 、65.0f 和'A相等。但对于str1 和str2 ，因为它们都是引用类型变量，
         * 它们分别指向两个通过new 关键字创建的String 对象，因此str1 和str2 两个变量不相等。
         *
         * String 还有一个非常容易迷惑的地方:
         * "hello"直接量和new String("hello")有什么区别呢?
         * 当程序直接使用形如"hello" 的字符串直接量(包括可以在编译时就计算出来的字符串值)时，JVM 将会使用常量池来管理这些字符串;
         * 当使用new String("hello")时， JVM 会先使用常量池来管理"hello"直接量，再调用String 类的构造器来创建一个新的String 对象，
         * 新创建的String 对象被保存在堆内存中。换句话说， new String("hello")一共产生了两个字符串对象
         *
         * 常量池 (constant pool) 专门用于管理在编译时被确定并被保存在已编译的 .class 文件中的一些数据。
         * 它包括了关于类、方法、接口中的常量， 还王包括字符串常量
         *
         * 下面程序示范了JVM使用常量池管理字符串直接量的情形：
         */

        // 直接引用常量池中的"疯狂Java"
        String s1 = "疯狂Java";
        String s2 = "疯狂";
        String s3 = "Java";
        // s4 后面的字符串值可以在编译时就确定下来
        // s4 直接引用常量池中的"疯狂Java"
        String s4 = "疯狂"+"Java";
        // s5 后面的字符息值可以在编译时就确定下来
        // s5 直接引用常量池中的"疯狂Java"
        String s5 = "疯"+"狂"+"Java";
        // s6 后面的字符串值不能在编译时就确定下来
        // 不能引用常量池中的字符串
        String s6 = s2+s3;
        // 使用口new 调用构造器将会创建一个新的String 对象
        // s7 引用堆内存中新创建的String 对象
        String s7 = new String("疯狂Java");
        // true
        System.out.println(s1 == s4);
        // true
        System.out.println(s1 == s5);
        // false
        System.out.println(s1 == s6);
        // false
        System.out.println(s1 == s7);
        /**
         * JVM 常量池保证相同的字符串直接量只有一个，不会产生多个副本。例子中的s1 、s4 、s5 所引用的字符串可以在编译期就确定下来，因此它们都将引用常量池中的同一个字符串对象。
         * 使用new String()创建的字符串对象是运行时创建出来的，它被保存在运行时内存区(即堆内存)内，不会放入常量池中。
         *
         * 但在很多时候，程序判断两个引用变量是否相等时，也希望有一种类似于"值相等"的判断规则，
         * 并不严格要求两个引用变量指向同一个对象。例如对于两个字符串变量，可能只是要求它们引用字符串
         * 对象里包含的字符序列相同即可认为相等。此时就可以利用String 对象的equals()方法来进行判断，例如上面程序中的str1 .equals(str2)将返回true 。
         *
         * equals()方法是Object 类提供的一个实例方法，因此所有引用变量都可调用该方法来判断是否与其他引用变量相等.
         * 但使用这个方法判断两个对象相等的标准与使用==运算符没有区别，同样要求两个引用变量指向同一个对象才会返回true。
         * 因此这个Object 类提供的equals()方法没有太大的实际意义，如果希望采用自定义的相等标准，则可采用重写equals 方法来实现。
         *
         * String 已经重写了Object 的equals()方法， String 的equals()方法判断两个字符串相等的标准是:
         * 只要两个字符串所包含的字符序列相同，通过equals() 比较将返回true ， 否则将返回false ，
         */

        /**
         * 很多书上经常说equals()方法是判断两个对象的值相等。这个说法并不完全准确，什么叫对象的值呢? 对象的值如何相等?
         * 实际上，重写equals()方法就是提供自定义的相等标准，
         * 你认为怎样是相等，那就怎样是相等， 一切都是你做主!在极端的情况下，你可以让Person对象和Dog 对象相等。
         *
         * 下面程序示范了重写equals 方法产生Person 对象和Dog 对象相等的情形。
         */
        Person p = new Person();
        System.out.println("Person 对象是否equals Dog 对象?"+ (p.equals(new Dog())));
        System.out.println("Person 对象是否equals String 对象?"+ (p.equals(new String())));
    }

    /**
     * 定义一个Person 类
     */
    static class Person {

        /**
         * 重写equals()方法，提供自定义的相等标准
         */
        @Override
        public boolean equals(Object obj) {
            // 不加判断，总是返回true ， 即 Person 对象与任何对象都相等
            return true;
        }
    }

    /**
     * 定义一个Dog 空类
     */
    static class Dog {

    }
}
