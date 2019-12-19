package objecttwo.enums;

/**
 * 实现接口的枚举类
 * 不同的枚举值对info()方法的实现各不相同
 * @author JIE
 */

public enum GenderDescImpl implements GenderDesc{

    /**
     * 此处的枚举值必须调用对应的构造器来创建
     */
    MALE("男"){
        @Override
        public void info() {
            System.out.println("这个枚举值代表男性");
        }
    },
    FEMALE("女") {
        @Override
        public void info() {
            System.out.println("这个枚举代表女性");
        }
    };
    GenderDescImpl(String name) {
    }

    /**
     * 上面代码看起来有些奇怪: 当创建MALE 和FEMALE 两个枚举值时， 后面又紧跟了一对花括号， 这对花括号里包含了一个info()方法定义。
     * 如果还记得匿名内部类语法的话，则可能对这样的语法有点印象了，花括号部分实际上就是一个类体部分，在这种情况下，当创建MALE 、FEMALE 枚举值时，
     * 并不是直接创建GenderDescImpl 枚举类的实例， 而是相当于创建GenderDescImpl 的匿名子类的实例
     *
     * 枚举类不是用final修饰的嘛，为什么还能派生子类？
     * 并不是所有的枚举类都使用了final修饰，非抽象类的枚举才默认使用final修饰。对于一个抽象类的枚举而已，只要他包含了抽象方法，她就是抽象枚举类
     * 系统会默认使用abstract修饰而不是使用final修饰
     *
     * 编译上面的程序， 可以看到生成了GenderDescImpl.class 、GenderDescImpl$1.class 和GenderDescImpl$2. class 三个文件， 这样的三个class 文件正好证明了上面的结论:
     * MALE 和FEMALE 实际上是GenderDescImpl 医名子类的实例，而不是Gender 类的实例
     * 当调用MALE 和FEMALE 两个枚举值的方法时，就会看到两个枚举值的方法表现不同的行为方式。
     */

    public static void main(String[] args) {
        GenderDescImpl.MALE.info();
        GenderDescImpl.FEMALE.info();
    }
}
