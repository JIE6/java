package objecttwo.enums;

/**
 * 包含抽象方法的枚举类
 * 假设有一个Operation 枚举类，它的4 个枚举值PLUS ， MINUS, TIMES, DIVIDE 分别代表加、减、乘、除4 种运算，
 * 该枚举类需要定义一个eval()方法来完成计算
 *
 * 从上面描述可以看出， Operation 需要让PLUS 、MINUS 、TIMES 、DIVIDE 四个值对eval()方法各有不同的实现。
 * 此时可考虑为Operation 枚举类定义一个eval()抽象方法，然后让4 个枚举值分别为eval()提供不同的实现。例如如下代码。
 * @author JIE
 */
public enum Operation {

    PLUS{
        @Override
        public double eval(double x, double y) {
            return x + y;
        }
    },
    MINUS{
        @Override
        public double eval(double x, double y) {
            return x - y;
        }
    },
    TIMES{
        @Override
        public double eval(double x, double y) {
            return x * y;
        }
    },
    DIVIDE{
        @Override
        public double eval(double x, double y) {
            return x / y;
        }
    };

    /**
     * 为枚举类定义一个抽象方法
     * 这个抽象方法由不同的枚举值提供不同的实现
     */
    public abstract double eval(double x , double y);

    public static void main(String[] args) {
        System.out.println(PLUS.eval(3 , 4));
        System.out.println(MINUS.eval(3 , 4));
        System.out.println(TIMES.eval(3 , 4));
        System.out.println(DIVIDE.eval(3 , 4));
    }
    /**
     * 编译上面程序会生成5 个class 文件，其实Operation 对应一个class 文件，它的4 个匿名内部子类分别各对应一个class 文件。\
     *
     * 枚举类里定义抽象方法时不能使用abstract 关键宇将枚举类定义成抽象类(因为系统自动会为它添
     * 加abstract 关键宇)，但因为枚举类需要显式创建枚举值，而不是作为父类，所以定义每个枚举值时必
     * 须为抽象方法提供实现，否则将出现编译错误。
     */
}
