package objecttwo.enums;

/**
 * 枚举类的成员变量、方法和构造器
 * @author JIE
 */
public class GenderTest {
    public static void main(String[] args) {
        /**
         * 通过Enum 的valueOf ()方法来获取指定枚举类的枚举值
         */
        Gender gender = Enum.valueOf(Gender.class, "FEMALE");
        /**
         * 直接为枚举值的name 实例变量赋傻
         */
        gender.name = "女";
        /**
         * 直接访问枚举值的name 实例变量
         */
        System.out.println(gender + "代表：" + gender.name);

        /**
         * 上面程序使用Gender 枚举类时与使用一个普通类没有太大的差别， 差别只是产生Gender 对象的方
         * 式不同， 枚举类的实例只能是枚举值，而不是随意地通过new 来创建枚举类对象。
         *
         * 正如前面提到的， Java 应该把所有类设计成良好封装的类， 所以不应该允许直接访问Gender 类的name 成员变量，
         * 而是应该通过方法来控制对name 的访问。否则可能出现很混乱的情形，例如上面程序恰好设置了g.name =" 女"， 要是采用g.name = " 男" ，
         * 那程序就会非常混乱了， 可能出现FEMALE 代表男的局面。可以按GenderPlus来改进Gender 类的设计
         */
    }
}
