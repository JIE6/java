package objectone;

/**
 * 引用变量的强制类型转换
 * 1.基本类型之间的转换只能在数值类型之间进行，这里所说的数值类型包括整数型、字符型和浮点型。但数值类型和布尔类型之间不能进行类型转换。
 * 2.引用类型之间的转换只能在具有继承关系的两个类型之间进行，如果是两个没有任何继承关系的类型，则无法进行类型转换，否则编译时就会出现错误。
 * 如果试图把一个父类实例转换成子类类型，则这个对象必须实际上是子类实例才行(即编译时类型为父类类型，而运行时类型是子类类型)，否则将在运行时引发ClassCastException 异常。
 * @author JIE
 */
public class TypeConversion {

    public static void main(String[] args) {
        double d = 3.14;
        long l = (long) d;
        System.out.println(l);
        Object obj = "str";
        String str = (String) obj;
        System.out.println(str);
        // 下面代码运行时引发ClassCastException 异常
        // Integer i = (Integer) obj;

        // 在进行强制类型转换之前，先用instanceof 运算符判断是否可以成功转换，从而避免出现ClassCastException 异常，这样可以保证程序更加健壮。
        if (obj instanceof Integer) {
            System.out.println("能强制转换");
        }else {
            System.out.println("不能强制转换");
        }
        /**
         * instanceof 运算符的前一个操作数通常是一个引用类型变量，后一个操作数通常是一个类(也可以是接口，可以把接口理解成一种特殊的类)
         * 它用于判断前面的对象是否是后面的类，或者其子类、实现类的实例。如果是，则返回true ，否则返回false 。
         *
         * 在使用instanceof 运算符时需要注意: instanceof 运算符前面操作数的编译时类型要么与后面的类相同，要么与后面的类具有父子继承关系，否则会引起编译错误。'
         *
         * instanceof 和(type)是Java 提供的两个相关的运算符，通常先用instanceof 判断一个对象是否可以强
         * 制类型转换，然后再使用(type)运算符进行强制类型转换，从而保证程序不会出现错误。
         */
        // System.out.println("" instanceof Integer);

    }
}
