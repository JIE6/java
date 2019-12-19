package objecttwo.internal;

/**
 * 静态内部类-介绍与使用
 *
 * 如果使用static 来修饰一个内部类，则这个内部类就属于外部类本身，而不属于外部类的某个对象。
 * 因此使用static 修饰的内部类被称为类内部类，有的地方也称为静态内部类。
 *
 * 静态内部类可以包含静态成员， 也可以包含非静态成员。根据静态成员不能访问非静态成员的规则，
 * 静态内部类不能访问外部类的实例成员，只能访问外部类的类成员。
 * 即使是静态内部类的实例方法也不能访问外部类的实例成员，只能访问外部类的静态成员。
 *
 * 为什么静态内部类的实例方法也不能访问外部，类的实例属性呢?
 * 因为静态内部类是外部类的类相关的，而不是外部类的对象相关的。
 *
 * 静态内部类是外部类的一个静态成员，因此外部类的所有方法、所有初始化块中可以使用静态内部类来定义变量、创建对象等。
 *
 * Java 还允许在接口里定义内部类，接口里定义的内部类默认使用public static 修饰，也就是说， 接口内部类只能是静态内部类。
 * @author JIE
 */
public class StaticInnerClassTest {

    private int prop1 = 5;
    private static int prop2 = 9;

    static class StaticInnerClass {
        //静态内部类里可以包含静态成员
        private static int age1;
        private int age2;

        public void accessOuterProp () {
            // 下面代码出现错误, 静态内部类无法访问外部类的实例变量
            // System.out.println(prop1);

            // 下面代码正常
            System.out.println(prop2);
        }
    }

    /**
     * 外部类依然不能直接访问静态内部类的成员，但可以使用静态内部类的类名作为调用者来访问静态内部类的类成员，
     * 也可以使用静态内部类对象作为调用者来访问静态内部类的实例成员。
     */
    public void accessInnerProp () {
        // 下面代码出现错误，
        // System.out.println(age);

        // 应改为如下形式, 通过类名访问静态内部类的类成员
        System.out.println(StaticInnerClass.age1);

        // 下面代码出现错误，
        // System.out.println(age2);

        // 应改为如下形式, 通过实例访问静态内部类的实例成员
        System.out.println(new StaticInnerClass().age2);


        StaticInnerClass staticInnerClass = new StaticInnerClassTest.StaticInnerClass();
        staticInnerClass.accessOuterProp();
    }
}
