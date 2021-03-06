package objectone;

/**
 * 重点
 * 递归方法
 * 一个方法体内调用它自身，被称为方法递归。
 * 方法递归包含了一种隐式的循环，它会重复执行某段代码， 但这种重复执行无须循环控制。
 * 例如有如下数学题。己知有一个数列：f(0)=1, f(1)=4, f(n+2)=2*f(n+1)+f(n), 其中n是大于0的整数，求f(10)的值
 * 这个题可以使用递归来求得。下面程序将定义一个fn的方法，用于计算f(10)的值
 * @author JIE
 */
public class RecursiveFunction {

    public static int fn(int n) {
        if (n == 0) {
            return 1;
        }else if (n == 1) {
            return 4;
        }else {
            // 方法中调用它自身， 就是方法递归
            return 2 * fn(n - 1) + fn(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(fn(10));
        /**
         * --------------------------------------------------------------------------
         * 2        8        1       9
         * 3        18       4       22
         * 4        44       9       53
         * 5        106      22      128
         * --------------------------------------------------------------------------
         * 在上面的fn方法体中， 再次调用了fn 方法，这就是方法递归。注意fn方法里调用fn的形式:
         * return 2 * fn(n - 1) + fn(n - 2)
         * 对于fn(10) ，即等于2* fn(9) + fn(8) ， 其中fn(9)又等于2* fn(8) + fn(7) …… 依此类推，
         * 最终会计算到fn(2)等于2 * fn(1) + fn(O) ，即fn(2)是可计算的,，然后一路反算回去， 就可以最终得到fn(10) 的值。
         * 仔细看上面递归的过程，当一个方法不断地调用它本身时，必须在某个时刻方法的返回值是确定的，即不再调用它本身，否则这种递归就变成了无穷递归，类似于死循环。
         * 因此定义递归方法时有一条最重要的规定:递归一定要向己知方向递归。
         */
    }
}
