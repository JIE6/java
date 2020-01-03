package generic;

/**
 * 深入泛型、
 *
 * 所谓泛型，就是允许在定义类、接口、方法时使用类型形参，这个类型形参(或叫泛型)将在声明变量、创建对象、调用方法时动态地指定(即传入实际的类型参数，也可称为类型实参)。
 * Java 5 改写了集合框架中的全部接口和类，为这些接口、类增加了泛型支持，从而可以在声明集合变量、创建集合对象时传入类型实参，
 * 这就是在前面程序中看到的List<String>和ArrayList<String>两种类型。
 *
 * 包含泛型声明的类型可以在定义变量、创建对象时传入一个类型实参，从而可以动态地生成无数多个逻辑上的子类，但这种子类在物理上并不存在。
 *
 * 定义泛型接口、类
 *
 */

/**
 * 定义DiveIntoGenerics 类时使用了泛型声明
 *
 * @author JIE
 */
public class DiveIntoGenerics<T> {

    /**
     * 使用T 类型定义实例变量
     */
    private T info;
    public DiveIntoGenerics() {}

    /**
     * 下面方法中使用T 类型来定义构造器
     */
    public DiveIntoGenerics(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public static void main(String[] args) {
        // 由于传给T 形参的是String ，所以构造器参数只能是String
        DiveIntoGenerics<String> d = new DiveIntoGenerics<>("苹果");
        System.out.println(d.getInfo());
        // 由于传给T 形参的是Double ，所以构造器参数只能是Double 或double
        DiveIntoGenerics<Double> dd = new DiveIntoGenerics<>(3.14);
        System.out.println(dd.getInfo());

        /**
         * 上面程序定义了一个带泛型声明的DiveIntoGenerics<T>类(不要理会这个泛型形参是否具有实际意义) ，使用DiveIntoGenerics<T>类时就可为T 形参传入实际类型，
         * 这样就可以生成如DiveIntoGenerics<String> 、DiveIntoGenerics<Double> … 形式的多个逻辑子类(物理上并不存在) 。
         *
         * JDK 在定义List 、ArrayList 等接口、类时使用了泛型声明，所以在使用这些类时为之传入了实际的类型参数。
         *
         * 当创建带泛型声明的自定义类，为该类定义构造器时，构造器名还是原来的类名，不要增加泛型声明。例如，为DiveIntoGenerics<T>类定义构造器，其构造器名依然是DiveIntoGenerics ，
         * 而不是DiveIntoGenerics<T> ! 调用该构造器时却可以使用DiveIntoGenerics<T>的形式，当然应该为T 形参传入实际的类型参数。Java 7 提供了菱形语法，允许省略<>中的类型实参。
         */
    }
}
