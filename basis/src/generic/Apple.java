package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 从泛型类派生子类
 *
 * 当创建了带泛型声明的接口、父类之后， 可以为该接口创建实现类，或从该父类派生子类，需要指出的是，
 * 当使用这些接口、父类时不能再包含泛型形参。例如，下面代码就是错误的。
 *
 * // 定义类A 继承Apple 类， Apple 类不能跟泛型形参
 * public class A extends Apple<T>{ }
 *
 * 方法中的形参代表变量、常量、表达式等数据，本书把它们直接称为形参，或者称为数据形参。定义方法时可以声明数据形参，
 * 调用方法(使用方法)时必须为这些数据形参传入实际的数据:与此类似的是，定义类、接口、方法时可以声明泛型形参，使用类、接口、
 * 方法时应该为泛型形参传入实际的类型。
 *
 * 如果想从Apple 类派生一个子类，则可以改为如下代码:
 * // 使用Apple 类时为T 形参传入String 类型
 * public class A extends Apple<String>{}
 *
 * 调用方法时必须为所有的数据形参传入参数值，与调用方法不同的是，使用类、接口时也可以不为泛型形参传入实际的类型参数，即下面代码也是正确的。
 * // 使用Apple 类时，没有为T 形参传入实际的类型参数
 * public class A extends Apple{}
 *
 * 像这种使用Apple 类时省略泛型的形式被称为原始类型(raw type) 。
 * 如果从Apple<String>类派生子类，则在Apple 类中所有使用T 类型的地方都将被替换成String 类型，如果子类需要重写父类的方法，就必须注意这一点。
 * 下面程序示范了这一点。
 * @author JIE
 */
public class Apple<T> extends DiveIntoGenerics<String> {

    /**
     * 正确重写了父类的方法，返回值与父类DiveIntoGenerics<String> 的返回值完全相同
     * @return
     */
    @Override
    public String getInfo() {
        return super.getInfo();
    }

    /**
     * 下面方法是错误的， 重写父类方法时返回值类型不一致
     * @return
     */
//    @Override
//    public Object getInfo() {
//        return super.getInfo();
//    }

    /**
     * 如果使用DiveIntoGenerics 类时没有传入实际的类型(即使用原始类型)， Java 编译器可能发出警告:使用了未经检查或不安全的操作, 这就是泛型检查的警告.
     * 如果希望看到该警告提示的更详细信息，则可以通过为Javac 命令增加-Xlint:unchecked 选项来实现。此时，系统会把Apple<T>类里的T 形参当成Object 类型处理。
     * 如下程序所示。
     */
    class A2 extends DiveIntoGenerics {
        @Override
        public String getInfo() {
            /**
             * super.getlnfo() 方法返回值是Object 类型所以加toString ()才返回String 类型
             */
            return super.getInfo().toString();
        }
    }

    /**
     * 上面程序都是从带泛型声明的父类来派生子类，创建带泛型声明的接口的实现类与此几乎完全一样，此处不再赘述。
     */

    /**
     * ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 并不存在泛型类
     *
     * 前面提到可以把ArrayList<String>类当成ArrayList 的子类， 事实上， ArrayList<String>类也确实像一种特殊的ArrayList 类:该ArrayList<String>对象只能添加String 对象作为集合元素。
     * 但实际上， 系统并没有为ArrayList<String>生成新的class 文件，而且也不会把ArrayList<string> 当成新类来处理。
     * 看下面代码的打印结果是什么?
     */
    public static void main(String[] args) {
        // 分别创建List<String〉对象和List<Integer>对象
        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 调用getC1ass ()方法来比较l1和12 的类是否相等
        System.out.println(l1.getClass() == l2.getClass());
        /**
         * 运行上面的代码片段，可能有读者认为应该输出false ，但实际输出true 。因为不管泛型的实际类型参数是什么，它们在运行时总有同样的类( class ) 。
         *
         * 不管为泛型形参传入哪一种类型实参， 对于Java 来说， 它们依然被当成同一个类处理，在内存中也只占用一块内存空间，
         * 因此在静态方法、静态初始化块或者静态变量的声明和初始化中不允许使用泛型形参。
         * 下面程序演示了这种错误。
         */
    }
    /**
     * 下面代码错误，不能在静态变量声明中使用泛型形参
     */
//    static T info;
    public void foo(T msg) {}
    /**
     * /下面代码错误，不能在静态方法声明中使用泛型形参
     */
//    public static void foo(T msg) {}

    /**
     * 由于系统中并不会真正生成泛型类， 所以instanceof 运算符后不能使用泛型类。例如， 下面代码是错误的。
     *
     * Object instanceof ArrayList<String>
     */

}
