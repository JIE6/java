package objecttwo.enums;

/**
 * 枚举类入门
 * @author JIE
 */
public class EnumTest {

    public void judge(SeaSonEnum s) {
        /**
         * switch 语句里的表达式可以是枚举值
         */
        switch (s) {
            case SPRING:
                System.out.println("春暖花开， 正好踏青");
                break;
            case SUMMER:
                System.out.println("夏日炎炎，适合游泳");
                break;
            case FALL:
                System.out.println("秋高气爽，进补及时");
                break;
            case WINTER:
                System.out.println("冬日雪飘， 国炉赏雪");
                break;
        }
    }

    public static void main(String[] args) {
        //枚举类默认有一个values () 方法， 返回该枚举类的所有实例
        for(SeaSonEnum s: SeaSonEnum.values()) {
            System.out.println(s);
        }
        // 使用枚举实例时，可通过EnumClass.variable 形式来访问
        new EnumTest().judge(SeaSonEnum.SPRING) ;

        /**
         * 上面程序测试了SeasonEnum 枚举类的用法，该类通过values()方法返回了SeasonEnum 枚举类的所有实例，
         * 并通过循环迭代输出了SeasonEnum 枚举类的所有实例。
         *
         * 不仅如此，上面程序的switch 表达式中还使用了SeasonEnum 对象作为表达式，这是JDK 1. 5 增加枚举后对switch 的扩展:
         * switch 的控制表达式可以是任何枚举类型。不仅如此， 当switch 控制表达式使用枚举类型时，后面case 表达式中的值直接使用枚举值的名字，无须添加枚举类作为限定。
         *
         * 前面己经介绍过，所有的枚举类都继承了java.lang.Enum 类，所以枚举类可以直接使用java.lang.Enum 类中所包含的方法。java. lang.Enum 类中提供了如下几个方法。
         *
         * int compareTo(E o) : 该方法用于与指定枚举对象比较顺序，同一个枚举实例只能与相同类型的
         * 枚举实例进行比较。如果该枚举对象位于指定枚举对象之后， 则返回正整数; 如果该枚举对象
         * 位于指定枚举对象之前，则返回负整数，否则返回零。
         *
         * String name(): 返回此枚举实例的名称，这个名称就是定义枚举类时列出的所有枚举值之一。与此方法相比，
         * 大多数程序员应该优先考虑使用toString()方法， 因为toString()方法返回更加用户友好的名称。
         *
         * int ordinal(): 返回枚举值在枚举类中的索引值(就是枚举值在枚举声明中的位置， 第一个枚举
         * 值的索引值为零〉。
         *
         * String toStringO(): 返回枚举常量的名称，与name 方法相似，但toString()方法更常用。
         *
         * public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) : 这是一个静态方法，用于返回指定枚举类中指定名称的枚举值
         * 名称必须与在该枚举类中声明枚举值时所用的标识符完全匹配， 不允许使用额外的空白字符
         *
         * 正如前面看到的， 当程序使用System. out.println(s)语句来打印枚举值时，实际上输出的是该枚举值的toString()方法， 也就是输出该枚举值的名字。
         */
    }
}
