package objecttwo.internal;

/**
 * 非静态内部类
 *
 * 下面程序在Cow 类里定义了一个CowLeg 非静态内部类，并在CowLeg 类的实例方法中直接访问Cow 的private 访问权限的实例变量。
 * @author JIE
 */
public class Cow {

    private String a = "Cow.a";

    private double weight;

    public Cow() {
    }

    public Cow(double weight) {
        this.weight = weight;
    }

    /**
     * 定义一个非静态内部类
     */
    class CowLeg{
        private String a = "Cow.CowLeg.a";
        /**
         * 非静态内部类的两个实例变量
         */
        private double length;
        private String color;

        /**
         * 非静态内部类的两个重载的构造器
         */
        public CowLeg() {}
        public CowLeg(double length, String color) {
            this.length = length ;
            this.color = color ;
        }

        /**
         * 非静态内部类的实例方法
         */
        public void info() {
            System.out.println("当前牛腿颜色是：" + color + ", 高是：" + length);
            // 直接访问外部类的private 修饰的成员变量
            System.out.println("牛腿所在de奶牛重：" + weight);
            String a = "Cow.CowLeg.info.a";

            // 局部变量a
            System.out.println(a);
            // 内部类a
            System.out.println(this.a);
            // 外部类a
            System.out.println(Cow.this.a);
        }

//        static {
//            System.out.println("");
//        }
//        private static int i;
//        private static void setI() {}

    }
    public void test() {
        CowLeg cl = new CowLeg(1.12 , "黑白相间" ) ;
        cl.info();
        System.out.println(cl.color);
    }

    public static void main(String[] args) {
        Cow cow = new Cow(978.9);
        cow.test();
        /**
         * 编译上面程序，看到在文件所在路径生成了两个class 文件
         * 一个是Cow.class ，另一个是Cow$CowLeg.class ，前者是外部类Cow 的class 文件后者是内部类CowLeg 的class 文件，
         * 即成员内部类(包括静态内部类、非静态内部类)的class 文件总是这种形式: OuterClass$InnerClass.class
         *
         * 前面提到过， 在非静态内部类里可以直接访问外部类的private 成员，上面程序中System.out.println("牛腿所在de奶牛重：" + weight);
         * 就是在CowLeg 类的方法内直接访问其外部类的private 实例变量. 这是因为在非静态内部类对象里，保存了一个它所寄生的外部类对象的引用
         * 当调用非静态内部类的实例方法时，必须有一个非静态内部类实例，非静态内部类实例必须寄生在外部类实例里.
         * 下面显示了上面程序运行时的内存示意图。
         * test栈区：      ->      (length:1.12, color:黑白相间, Cow.this)
         *                                                      ↓↓↓↓↓↓↓
         * main栈区：      ->                              (weight:978.9)
         * 当在非静态内部类的方法内访问某个变量时，系统优先在该方法内查找是否存在该名字的局部变量，
         * 如果存在就使用该变量;如果不存在，则到该方法所在的内部类中查找是否存在该名字的成员变量，
         * 如果存在则使用该成员变量: 如果不存在，则到该内部类所在的外部类中查找是否存在该名字的成员变量，
         * 如果存在则使用该成员变量: 如果依然不存在， 系统将出现编译错误: 提示找不到该变量。
         * 因此，如果外部类成员变量、内部类成员变量与内部类里方法的局部变量同名，则可通过使用this 、外部类类名.this作为限定来区分。参考变量a
         *
         * 非静态内部类的成员可以访问外部类的private 成员，但反过来就不成立了。
         * 非静态内部类的成员只在非静态内部类范围内是可知的， 并不能被外部类直接使用。
         * 如果外部类需要访问非静态内部类的成员，则必须显式创建非静态内部类对象来调用访问其实例成员。参考第62行代码对color的调用
         * 如果将第62行代码改为：System.out.println(color);这将引起编译错误。
         *
         * 非静态内部类和外部类对象的关系是怎样的？
         * 非静态内部类对象必须寄生在外部类对象里，而外部类对象则不一定有非静态内部类对象寄生其中，
         *
         * 根据静态成员不能访问非静态成员的规则， 外部类的静态方法、静态代码块不能访问非静态内部类，
         * 包括不能使用非静态内部类定义变量、创建实例等。总之， 不允许在外部类的静态成员中直接使用非静态内部类。
         * 下面代码引发编译异常，因为静态成员(main ()方法)
         * new CowLeg();
         * 无法访问非静态成员(CowLeg 类)
         *
         * Java 不允许在非静态内部类里定义静态成员,参考代码59~63行
         * 代码59~63行静态声明都将引发如下编译错误:非静态内部类不能有静态声明
         * 非静态内部类里不能有静态方法、静态成员变量、静态初始化块，所以上面三个静态声明都会引发错误。
         *
         * 非静态内部类里不可以有静态初始化块，但可以包含普通初始化块。非静态内部类普通初始化块的作用与外部类初始化块的作用完全相同。
         */
        CowLeg cowLeg = new Cow().new CowLeg();
        System.out.println(cowLeg);
    }
}
