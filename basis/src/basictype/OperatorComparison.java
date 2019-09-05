package basictype;

/**
 * 重点
 * 运算符-比较运算符
 * 比较运算符用于判断两个变量或常量的大小，比较运算的结果是一个布尔值( true 或false ) Java支持的比较运算符如下。
 * > 大于，只支持左右两边操作数是数值类型。如果前面变量的值大于后面变量的值，则返回true
 * >= 大于等于， 只支持左右两边操作数是数值类型。如果前面变量的值大于等于后面变量的值，则返回true
 * < 小于，只支持左右两边操作数是数值类型。如果前面变量的值小于后面变量的值， 则返回true
 * <= 小于等于，只支持左右两边操作数是数值类型。如果前面变量的值小于等于后面变量的值，则返回true
 * == 等于，如果进行比较的两个操作数都是数值类型，即使它们的数据类型不相同，只要它们的值相等，也都将返回true。例如：
 * （97 == 'a'返回true. 5.0 == 5 也返回true。如果两个操作数都是引用类型，那么只有当两个引用变量的类型具有父子关系时才可以比较，
 * 而且这两个引用必须指向同一个对象才会返回true。Java 也支持两个boolean 类型的值进行比较，例如. true == false将返回false 。）
 * != 不等于，如果进行比较的两个操作数都是数值类型，无论它们的数据类型是否相同， 只要它们的值不相等，也都将返回true。
 * 如果两个操作数都是引用类型，只有当两个引用变量的类型具有父子关系时才可以比较，只要两个引用指向的不是同一个对象就会返回true 。
 * @author JIE
 */
public class OperatorComparison {

    public static void main(String[] args) {
        System.out.println(5 > 4.0);
        System.out.println(5 < 4.0);
        System.out.println(5 == 4.0);
        System.out.println(5 >= 5.0);
        System.out.println(5 <= 5.0);
        System.out.println(5 == 5.0);
        System.out.println(5 != 5.0);
        System.out.println(97 == 'a');
        OperatorComparison operatorComparison1 = new OperatorComparison();
        OperatorComparison operatorComparison2 = new OperatorComparison();
        // operatorComparison1 和operatorComparison2 是同一个类的两个实例的引用，所以可以比较
        // 但operatorComparison1 和operatorComparison2 引用不同的对象，所以返回false
        System.out.println(operatorComparison1 == operatorComparison2);
        //直接将operatorComparison1 的值赋给operatorComparison3 即让operatorComparison3 指向operatorComparison1的对象
        OperatorComparison operatorComparison3 = operatorComparison1;
        // operatorComparison1 和operatorComparison3 指向同一个对象，所以返回true
        System.out.println(operatorComparison1 == operatorComparison3);
    }
}
