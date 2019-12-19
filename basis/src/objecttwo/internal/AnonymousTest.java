package objecttwo.internal;

/**
 * Java 8 改进的匿名内部类
 * 当通过实现接口来创建匿名内部类时， 匿名内部类也不能显式创建构造器，
 * 因此医名内部类只有一个隐式的无参数构造器，故new 接口名后的括号里不能传入参数值。
 *
 * 当创建匿名内部类时，必须实现接口或抽象父类里的所有抽象方法
 * 如果有需要，也可以重写父类中的普通方法
 * 在Java 8 之前， Java 要求被局部内部类、匿名内部类访问的局部变量必须使用final 修饰
 * 从Java 8开始这个限制被取消了， Java 8 更加智能:
 * 如果局部变量被匿名内部类访问，那么该局部变量相当于自动使用了final 修饰
 * @author JIE
 */
public class AnonymousTest {

    public void test(Product p) {
        System.out.println("购买了一个" + p.getName() + ", 花费了" + p.getPrice());
    }

    public void test(Device d) {
        System.out.println("购买了一个" + d.getName() + ", 花费了" + d.getPrice());
    }

    public static void main(String[] args) {
        int age = 8;

        AnonymousTest anonymousTest = new AnonymousTest();
        // 调用test ()方法时，需要传入一个Product 参数
        // 此处传入其匿名实现类的实例
        anonymousTest.test(new Product() {
            {
                System.out.println("Product 初始化块");
            }
            @Override
            public double getPrice() {
                // 在java8以前下面的语句将提示报错，age必须使用final修饰。从java8开始匿名内部类，局部局部内部类允许访问非final的局部变量
                System.out.println("age=" + age);
                return 567.8;
            }

            @Override
            public String getName() {
                return "mac pro";
            }
        });


        AnonymousTest at = new AnonymousTest();
        at.test(new AnonymousTest().new Device("iphone") {
            @Override
            public double getPrice() {
                return 67.8;
            }
        });

        // 调用无参数的构造器创建Device 匿名实现类的对象
        Device device = new AnonymousTest().new Device() {
            // 初始化块
            {
                System.out.println("匿名内部类的初始化块");
            }

            /**
             * 实现抽象方法
             * @return
             */
            @Override
            public double getPrice() {
                return 56.2;
            }

            /**
             * 重写父类方法
             * @return
             */
            @Override
            public String getName() {
                return "apple";
            }
        };
        at.test(device);
    }

    abstract class Device{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * 获取金额
         * @return
         */
        public abstract double getPrice();
        public Device() {}
        public Device(String name) {
            this.name = name;
        }
    }
}
