package library;

/**
 * String 类是不可变类，即一旦一个String 对象被创建以后，包含在这个对象中的字符序列是不可改变的， 直至这个对象被销毁。
 *
 *  StringBuffer 对象则代表一个字符序列可变的字符串，当一个StringBuffer 被创建以后，通过StringBuffer 提供的append() 、insert() 、
 *  reverse() 、setCharAt() 、setLength()等方法可以改变这个字符串对象的宇符序列。一旦通过StringBuffer 生成了最终想要的字符串，
 *  就可以调用它的toString()方法将其转换为一个String 对象
 *
 *  StringBuilder 类是JDK 1.5 新增的类， 它也代表可变字符串对象。实际上， StringBuilder 和StringBuffer基本相似，两个类的构造器和方法也基本相同。
 *  不同的是， StringBuffer 是线程安全的，而StringBuilder则没有实现线程安全功能，所以性能略高。因此在通常情况下，如果需要创建一个内容可变的字符串对
 *  象， 则应该优先考虑使用StringBuilder 类。
 *
 *  String, StringBuffer, StringBuilder都实现了CharSequence接口， 因此CharSequence可认为是一个字符串的协议接口
 *
 *  Java 9 改进了字符串( 包括String 、StringBuffer 、StringBuilder) 的实现。在Java 9 以前字符串采用char[]数组来保存字符，因此字符串的每个字符占2 字节:
 *  而Java 9 的字符串采用byte[]数组再加一个encoding-flag 宇段来保存字符，因此字符串的每个字符只占1 宇节。所以Java 9 的字符串更加节省空间，但字符串的功能方法没有受到任何影响。
 *
 *  String 类提供了大量构造器来创建String 对象，其中如下几个有特殊用途。
 *  String(): 创建一个包含0 个宇符串序列的String 对象(并不是返回null ) 。
 *  String(byte[] bytes, Charset charset): 使用指定的字符集将指定的byte[]数组解码成一个新的String对象。
 *  String(byte[] bytes, String charsetName): 使用指定的字符集将指定的byte[]数组解码成一个新的String 对象。
 *  String(byte[] bytes, int offset, int length): 使用平台的默认字符集将指定的byte[]数组从offset 开始、长度为length 的子数组解码成一个新的String 对象。
 *  String(byte[] bytes, int offset, int length, String charsetName): 使用指定的字符集将指定的byte[]数组从offset 开始、长度为length 的子数组解码成一个新的String 对象。
 *  String(char[] value, int offset, int count): 将指定的宇符数组从offset 开始、长度为count 的字符元素连缀成字符串。
 *  String(String original): 根据宇符串直接量来创建一个String 对象。也就是说，新创建的String对象是该参数字符串的副本。
 *  String(StringBuffer buffer): 根据StringBuffer 对象来创建对应的String 对象。
 *  String(StringBuilder builder): 根据StringBuilder 对象来创建对应的String 对象。
 *
 *  String 类也提供了大量方法来操作字符串对象， 下面详细介绍这些常用方法。
 * @author JIE
 */
public class StringTest {

    public static void main(String[] args) {
        String s = new String("fkit.org");
        // char charAt(int index): 获取字符串中指定位置的字符。其中， 参数index 指的是字符串的序数，字符串的序数从0 开始到length()-l 。如下代码所示
        System.out.println("s.charAt(5)" + ": " + s.charAt(5));
        /*
         * int compareTo(String anotherString): 比较两个宇符串的大小。如果两个字符串的字符序列相等，则返回0 ;
         * 不相等时，从两个字符串第0 个字符开始比较， 返回第一个不相等的字符差。另一种情况，较长字符串的前面部分恰巧是较短的字符串，
         * 则返回它们的长度差
         */
        String s1 = new String( "abcdefghijklmn");
        String s2 = new String( "abcdefghij");
        String s3 = new String( "abcdefghijalmn");
        // 返回长度差
        System.out.println("s1.compareTo(s2)" + ": " + s1.compareTo(s2));
        // 返回'k '-'a' 的差
        System.out.println("s1.compareTo(s3)" + ": " + s1.compareTo(s3));
        /*
         * String concat(String s):将该String 对象与s由连接在一起。与Java 提供的字符串连接运算符" +"的功能相同
         *
         * boolean contentEquals(StringBuffer sb): 将该String 对象与StringBuffer 对象sb 进行比较，当它们包含的字符序列相同时返回true 。
         *
         * static String copyValueOf(char[] data): 将字符数组连缀成字符串， 与String(char[] content)构造器的功能相同。
         *
         * static String copyValueOf(char[] data, int offset, int count): 将char 数组的子数组中的元素连缀成字符串，与String(char[] value, int offset, int count)构造器的功能相同。
         *
         * boolean endsWith(String suffix): 返回该String 对象是否以suffix 结尾。
         *
         * boolean equals(Object anObject): 将该字符串与指定对象比较，如果二者包含的字符序列相等，则返回true; 否则返回false 。
         *
         * boolean equalsIgnoreCase(String s):与前一个方法基本相似，只是忽略字符的大小写。
         *
         * byte[] getBytes(): 将该String 对象转换成byte 数组。
         *
         * void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin): 该方法将字符串中从srcBegin 开始，
         * 到srcEnd 结束的字符复制到dst 字符数组中，其中dstBegin 为目标字符数组的起始复制位置。
         *
         * int indexOf(int ch): 找出ch 字符在该字符串中第一次出现的位置。
         *
         * int indexOf(int ch, int fromIndex): 找出ch 字符在该字符串中从fromIndex 开始后第一次出现的位置。
         *
         * int indexOf(String str):找出str字符串在该宇符串中第一次出现的位置。
         *
         * int indexOf(String str， int fromIndex): 找出str子字符串在该字符串中从fromIndex 开始后第一次出现的位置。
         *
         * int lastIndexOf(int ch): 找出ch 字符在该字符串中最后一次出现的位置。
         *
         * int lastIndexOf(int ch, int fromIndex): 找出ch 字符在该字符串中从fromIndex 开始后最后一次出现的位置。
         *
         * int length(): 返回当前字符串长度。
         *
         * String replace(char oldChar, char newChar): 将字符串中的第一个oldChar 替换成newChar 。
         *
         * boolean startsWith(String prefix): 该String 对象是否以prefix 开始。
         *
         * boolean startsWith(String prefix， int toffset): 该String 对象从toffset 位置算起，是否以prefix 开始。
         *
         * String substring(int beginIndex): 获取从beginIndex 位置开始到结束的子字符串。
         *
         * String substring(int beginIndex, int endIndex): 获取从beginIndex 位置开始到endIndex 位置的子字符串。
         *
         * char[] toCharArray(): 将该String 对象转换成char 数组。
         *
         * String toLowerCase(): 将宇符串转换成小写。
         *
         * String toUpperCase(): 将字符串转换成大写。
         *
         * static String valueOf(X x): 一系列用于将基本类型值转换为String 对象的方法。
         */
    }
}
