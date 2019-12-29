package library;

/**
 * StringBuilder 提供了一系列插入、追加、改变该字符串里包含的字符序列的方法。而StringBuffer与其用法完全相同，只是StringBuffer 是线程安全的。
 *
 * StringBuilder 、StringBuffer 有两个属性: length 和capacity ，其中length 属性表示其包含的字符序列的长度。
 * 与String 对象的length 不同的是， StringBuilder 、StringBuffer 的length 是可以改变的， 可以通过length() 、setLength(int len)方法来访问和修改其字符序列的长度。
 * capacity属性表示StringBuilder的容量， capacity 通常比length 大，程序通常无须关心capacity 属性。
 * @author JIE
 */
public class StringBuilderTest {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        // 追加字符串    java
        sb.append("java");
        // 插入   hello java
        sb.insert(0, "hello ");
        // 删除   hellojava
        sb.delete(5, 6);
        // 反转   avajolleh
        sb.reverse();
        System.out.println(sb);
        System.out.println(sb.length());
        System.out.println(sb.capacity());
        // 改变StringBuilder 的长度，将只保留前面部分 avajo
        sb.setLength(5);
        System.out.println(sb);

        /**
         * 上面程序中粗体字部分示范了StringBuilder 类的追加、插入、替换、删除等操作，
         * 这些操作改变了StringBuilder 里的字符序列，这就是StringBuilder 与String 之间最大的区别:
         * StringBuilder 的字符序列是可变的。从程序看到StringBuilder 的length()方法返回其宇符序列的长度，
         * 而capacity()返回值则比length ()返回值大。
         */
    }
}
