package objecttwo;

import java.util.Arrays;

/**
 * final修饰符
 *
 * final 关键字可用于修饰类、变量和方法， final 关键字有点类似C#里的sealed 关键字，用于表示它修饰的类、方法和变量不可改变。
 * final 修饰变量时，表示该变量一旦获得了初始值就不可被改变， final 既可以修饰成员变量( 包括类变量和实例变量)， 也可以修饰局部变量、形参。
 * 有的书上介绍说final 修饰的变量不能被赋值，这种说法是错误的!严格的说法是， final 修饰的变量不可被改变，一旦获得了初始值， 该final 变量的值就不能被重新赋值。
 * 由于final 变量获得初始值之后不能被重新赋值， 因此final 修饰成员变量和修饰局部变量时有一定的不同。
 *
 * final 修饰的成员变量必须由程序员显式地指定初始值。
 *
 * 归纳起来， final 修饰的类变量、实例变量能指定初始值的地方如下。
 * 类变量: 必须在静态初始化块中指定初始值或声明该类变量时指定初始值，而且只能在两个地方的其中之一指定。
 * 实例变量:必须在非静态初始化块、声明该实例变量或构造器中指定初始值， 而且只能在三个地方的其中之一指定。
 *
 * final 修饰的实例变量，要么在定义该实例变量时指定初始值，要么在普通初始化块或构造器中为该实例变量指定初始值。
 * 但需要注意的是， 如果普通初始化块己经为某个实例变量指定了初始值，则不能再在构造器中为该实例变量指定初始值;
 * final 修饰的类变量，要么在定义该类变量时指定初始值，要么在静态初始化块中为该类变量指定初始值。
 *
 * 实例变量不能在静态初始化块中指定初始值，因为静态初始化块是静态成员，不可访问实例变量 - 非静态成员
 * 类变量不能在普通初始化块中指定初始值因为类变量在类初始化阶段己经被初始化了，普通初始化块不能对其重新赋值。
 *
 * 与普通成员变量不同的是， final 成员变量(包括实例变量和类变量)必须由程序员显式初始化。
 * @author JIE
 */
public class FinalCharacter {
    /**
     * 定义成员变量时指定默认值，合法
     */
    final int a = 6;

    /**
     * 下面变量将在构造器或初始化块中分配初始值
     */
    final String str;
    final int c;
    final static double d;

    /**
     * /既没有指定默认值，又没有在初始化块、构造器中指定初始值
     * 下面定义的ch 实例变量是不合法的
     * final char ch;
     */

    /**
     * 初始化块，可对没有指定默认值的实例变量指定初始值
     */
    {
        /**
         * 在初始化块中为实例变量指定初始值，合法
         */
        str = "Hello";

        /**
         * 定义a 实例变量时已经指定了默认值
         * 不能为a 重新赋值，因此下面赋值语句非法
         * a = 9;
         */
    }

    /**
     * 静态初始化块，可对没有指定默认值的类变量指定初始值
     */
    static {
        /**
         * 在静态初始化块中为类变量指定初始值，合法
         */
        d = 5.6;
    }

    /**
     * 构造器，可对既没有指定默认值， 又没有在初始化块中指定初始值的实例变量指定初始值
     */
    public FinalCharacter() {
        /**
         * 如果在初始化块中已经对str 指定了初始值
         * 那么在构造器中不能对final 变量重新赋值，下面赋值语句非法
         * str = "java";
         */
        c = 5;
    }

    /**
     * final 局部变量
     */
    public void localVariableTest(final int a) {
        // 不能对final 修饰的形参赋值，下面语句非法
        // a = 4;

        // 定义final 局部变量时指定默认值，则 str 变量无法重新赋值
        final String str = "hello" ;
        // 下面赋值语句非法
        // str = "Java";


        // 定义final 局部变量时没有指定默认值，则d 变量可被赋值一次
        final double d;
        // 第一次赋初始值，成功
        d = 5.6;
        // 对final 变量重复赋值， 下面语句非法
        // d = 3.4;
    }

    public static void main(String[] args) {
        /**
         * 当使用final 修饰基本类型变量时，不能对基本类型变量重新赋值，因此基本类型变量不能被改变。
         * 但对于引用类型变量而言，它保存的仅仅是一个引用， final 只保证这个引用类型变量所引用的地址不会改变，
         * 即一直引用同一个对象，但这个对象完全可以发生改变。
         */
        // final 修饰数组变量， iArr 是一个引用变量
        final int[] iArr = {5 , 6, 12, 9} ;
        System.out.println(Arrays.toString(iArr)) ;
        // 对数组元素进行排序，合法
        Arrays.sort(iArr);
        System.out.println(Arrays.toString(iArr)) ;
        // 对数组元素赋值，合法
        iArr[2] = - 8;
        System.out.println(Arrays.toString(iArr)) ;
        // 下面语句对iArr 重新赋值，非法
        // iArr = null;

        /**
         * 可执行"宏替换"的final 变量
         * 对一个final 变量来说，不管它是类变量、实例变量，还是局部变量，只要该变量满足三个条件，这个final 变量就不再是一个变量，而是相当于一个直接量。
         * 1.使用final 修饰符修饰。
         * 2.在定义该final 变量时指定了初始值。
         * 3.该初始值可以在编译时就被确定下来。
         */
        // 定义一个普通局部变量
        final int a = 5;
        System.out.println(a);
        /**
         * 上面程序中的粗体字代码定义了一个final 局部变量，并在定义该final 变量时指定初始值为5 。对于这个程序来说，变量a 其实根本不存在，
         * 当程序执行System.out.println( a);代码时，实际转换为执行System.out.println(5) 。
         */
        String s1 = "hello";
        String s2 = "World";
        String s3 = "hello" + "World";
        String s4 = "helloWorld";
        // true
        System.out.println(s3 == s4);
        // false
        System.out.println(s1+s2 == s3);
        // false
        System.out.println(s1+s2 == s4);

        final String s1f = "hello";
        final String s2f = "World";
        // true
        System.out.println(s1f+s2f == s3);
        // true
        System.out.println(s1f+s2f == s4);

        /**
         * final 方法
         *
         * final 修饰的方法不可被重写，如果出于某些原因，不希望子类重写父类的某个方法，则可以使用final 修饰该方法。
         * Java 提供的Object 类里就有一个final 方法: getClass() ，因为Java 不希望任何类重写这个方法，所以使用final 把这个方法密封起来。
         * 但对于该类提供的toString()和equals()方法，都允许子类重写， 因此没有使用final 修饰它们。
         *
         * 对于一个private 方法，因为它仅在当前类中可见，其子类无法访问该方法，所以子类无法重写该方法
         * 如果子类中定义一个与父类private 方法有相同方法名、相同形参列表、相同返回值类型的方法，也不是方法重写，只是重新定义了一个新方法。
         * 因此，即使使用final 修饰一个private 访问权限的方法，依然可以在其子类中定义与该方法具有相同方法名、相同形参列表、相同返回值类型的方法。
         *
         * final 修饰的方法仅仅是不能被重写，并不是不能被重载
         */

        /**
         * final 类
         *
         * final 修饰的类不可以有子类， 例如java.1ang.Math 类就是一个final 类，它不可以有子类。
         * 当子类继承父类时，将可以访问到父类内部数据，并可通过重写父类方法来改变父类方法的实现细节，这可能导致一些不安全的因素。为了保证某个类不可被继承，则可以使用final 修饰这个类。
         */

        /**
         * 缓存实例的不可变类
         */
        CacheArray cacheArray1 = CacheArray.valueOf("c1");
        CacheArray cacheArray3 = CacheArray.valueOf("c3");
        CacheArray cacheArray5 = CacheArray.valueOf("c5");
        CacheArray cacheArray7 = CacheArray.valueOf("c7");
        // false
        System.out.println(cacheArray1 == CacheArray.valueOf("c1"));
        // true
        System.out.println(cacheArray5 == CacheArray.valueOf("c5"));
        // false
        System.out.println(cacheArray3 == CacheArray.valueOf("c3"));
        // true
        System.out.println(cacheArray7 == CacheArray.valueOf("c7"));
        /**
         * 上面CacheArray 类使用一个数组来缓存该类的对象，这个数组长度为MAX SIZE ，即该类共可以缓存MAX SIZE 个CacheArray 对象
         *当缓存池己满时，缓存池采用"先进先出"规则来决定哪个对象将被移出缓存池。
         * 当使用valueOf()方法来生成对象时，系统是否重新生成新的对象，取决于数组内是否已经存在该对象。如果该数组中己经缓存了该类的对象，系统将不会重新生成对象。
         * 需要程序使用该类的valueOf()方法来得到其对象，而且程序使用private 修饰符隐藏该类的构造器，因此程序只能通过该类提供的valueOf()方法来获取实例。
         *
         * 是否需要隐藏CacheArray 类的构造器完全取决于系统需求。盲目乱用缓存也可能导致系统性能下降，缓存的对象会占用系统内存，
         * 如果某个对象只使用一次，重复使用的概率不大，缓存该实例就弊大于利;
         * 反之，如果某个对象需要频繁地重复使用，缓存该实例就利大于弊
         */
    }

    /**
     * 不可变类
     *
     * 不可变( immutable ) 类的意思是创建该类的实例后， 该实例的实例变量是不可改变的。Java 提供的8 个包装类和java.lang.String 类都是不可变类，
     * 当创建它们的实例后， 其实例的实例变量不可改变。
     *
     * 如果需要创建自定义的不可变类，可遵守如下规则。
     * 1.使用private 和final 修饰符来修饰该类的成员变量。
     * 2.提供带参数构造器，用于根据传入参数来初始化类里的成员变量。
     * 3.仅为该类的成员变量提供getter 方法，不要为该类的成员变量提供setter 方法，因为普通方法无法修改final 修饰的成员变量。
     * 4.如果有必要，重写Object 类的hashCode()和equals()方法
     */
    class Name {
        private final String firstName;
        private final String lastName;

        public Name (String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

    class Person {

        private final Name name;

        public Person (Name name) {
            // 设置name 实例变量为临时创建的Name 对象，该对象的firstName 和lastName, 与传入的name 参数的firstName 和lastName 相同
            this.name = new Name(name.getFirstName(), name.getLastName());
        }

        public Name getName() {
            // 返回一个匿名对象，该对象的firstName 和lastName, 与该对象垦的name 的firstName 和lastName 相同
            return new Name(name.getFirstName(), name.getLastName());
        }
    }

    /**
     * 缓存实例的不可变类
     * 不可变类的实例状态不可改变，可以很方便地被多个对象所共享。如果程序经常需要使用相同的不可变类实例，则应该考虑缓存这种不可变类的实例。
     * 毕竟重复创建相同的对象没有太大的意义，而且加大系统开销。如果可能，应该将已经创建的不可变类的实例进行缓存。
     * 缓存是软件设计中一个非常有用的模式，缓存的实现方式有很多种，不同的实现方式可能存在较大的性能差别
     *
     * 此处将使用一个数组来作为缓存池，从而实现一个缓存实例的不可变类。
     */

    static class CacheArray {

        private static int MAX_SIZE = 3;
        /**
         * 使用数组来缓存已有的实例
         */
        private static CacheArray[] cache = new CacheArray[MAX_SIZE];
        /**
         * 记录缓存实例在缓存中的位置， cache[pos - 1] 是最新缓存的实例
         */
        private static int pos = 0;
        private final String name;

        private CacheArray(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static CacheArray valueOf(String name) {
            // 遍历己缓存的对象，
            for (int i = 0; i < MAX_SIZE; i++) {
                // 如果己有相同实例，则直接返回该缓存的实例
                if (cache[i] != null && cache[i].getName().equals(name)) {
                    return cache[i];
                }
            }
            // 如果缓存池已满
            if (pos == MAX_SIZE) {
                // 把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓存池的最开始位置
                cache[0] =new CacheArray(name);
                // 把pos 设为1
                pos = 1;
            }else {
                // 把新创建的对象缓存起来， pos 加l
                cache[pos++] = new CacheArray(name);
            }
            return cache[pos - 1];
        }
    }
}
