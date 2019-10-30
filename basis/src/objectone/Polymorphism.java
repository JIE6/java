package objectone;

/**
 * 多态
 * @author JIE
 */
public class Polymorphism {

    public static void main(String[] args) {
        // 下面编译时类型和运行时类型不一样，多态发生
        Parent parent = new Child();
        /**
         * 引用变量在编译阶段只能调用其编译时类型所具有的方法，但运行时则执行它运行时类型所具有的方法。
         * 因此，编写Java 代码时，引用变量只能调用声明该变量时所用类里包含的方法。
         * 例如，通过Object p = new Person()代码定义一个变量p ，则这个p 只能调用Object 类的方法，而不能调用Person 类里定义的方法。
         */
        System.out.println(parent.a);
        parent.info();
        // Parent 类没有提供polymorphismTest()方法，所以下面代码编译时会出现错误
        // parent.polymorphismTest();
    }
}
