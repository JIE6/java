package library;

/**
 * Math 类
 * Java 提供了基本的+、一、*、/、%等基本算术运算的运算符，但对于更复杂的数学运算，例如，三角函数、对数运算、指数运算等则无能为力。
 * Java 提供了Math 工具类来完成这些复杂的运算， Math类是一个工具类，它的构造器被定义成private 的，因此无法创建Math 类的对象;
 * Math 类中的所有方法都是类方法，可以直接通过类名来调用它们。Math 类除提供了大量静态方法之外，
 * 还提供了两个类变量: PI 和E ， 正如它们名字所暗示的，它们的值分别等于π和e 。
 * @author JIE
 */
public class MathTest {

    public static void main(String[] args) {
        // 下面是取整运算
        // 取整，返回小于目标数的最大整数
        System.out.println("Math.floor(1.57)" + ": " + Math.floor(1.57));
        // 取整，返回大于目标数的最小整数
        System.out.println("Math.ceil(1.57)" + ": " + Math.ceil(1.57));
        // 四舍五入取整
        System.out.println("Math.round(1.57)" + ": " + Math.round(1.57));
        // /计算平方根
        System.out.println("Math.sqrt(1.57)" + ": " + Math.sqrt(1.57));
        // /计算立方根
        System.out.println("Math.cbrt(1.57)" + ": " + Math.cbrt(1.57));
        // 返回欧拉数e 的n 次幕
        System.out.println("Math.exp(1.57)" + ": " + Math.exp(1.57));
        // 计算乘方
        System.out.println("Math.pow(3, 2)" + ": " + Math.pow(3, 3));
        //返回参数与1 之和的自然对数
        System.out.println("Math.log1p(9)" + ": " + Math.log1p(9));
        // 计算绝对值
        System.out.println("Math.abs(-9)" + ": " + Math.abs(-9));
        // 找出最大值
        System.out.println("Math.max(-9, 9)" + ": " + Math.max(-9, 9));
        // 找出最小值
        System.out.println("Math.min(-9, 9)" + ": " + Math.min(-9, 9));
        // 返回一个伪随机数，该值大子等于0.0 且小于1. 0
        System.out.println("Math.random()" + ": " + Math.random());
        // ......

    }
}
