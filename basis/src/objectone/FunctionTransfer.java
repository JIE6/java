package objectone;

/**
 * 重点
 * 方法的参数传递机制
 *
 * Java 里的方法是不能独立存在的，调用方法也必须使用类或对象作为主调者。
 * 如果声明方法时包含了形参声明，则调用方法时必须给这些形参指定参数值， 调用方法时实际传给形参的参数值也被称为实参。
 *
 * 那么，Java 的实参值是如何传入方法的呢?
 * 这是由Java 方法的参数传递机制来控制的， Java 里方法的参数传递方式只有一种: 值传递。
 * 所谓值传递，就是将实际参数值的副本(复制品)传入方法内，而参数本身不会受到任何影响。
 * @author JIE
 */
public class FunctionTransfer {

    /**
     * 基本数据类型的参数传递
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        /*
         * 下面三行代码实现a 、b 变量的值交换
         * 定义一个临时变量来保存a 变量的值
         */
        int temp = a;
        // 把b 的值赋给a
        a = b;
        // 把临时变量tmp 的值赋给 b
        b = temp;
        System.out.println("swap(int a, int b)方法里，a="+a+"，b="+b);
    }

    static class DataWarp{
        int a;
        int b;
    }

    /**
     * 引用类型的参数传递
     * @param dw
     */
    public static void swap(DataWarp dw) {
        int temp = dw.a;
        dw.a = dw.b;
        dw.b = temp;
        System.out.println("swap(DataWarp dw)方法里，dw.a="+dw.a+"，dw.b="+dw.b);
    }

    public static void swapNull(DataWarp dw) {
        int temp = dw.a;
        dw.a = dw.b;
        dw.b = temp;
        System.out.println("swapNull(DataWarp dw)方法里，dw.a="+dw.a+"，dw.b="+dw.b);
        dw = null;
    }


        public static void main(String[] args) {
            int a = 1;
            int b = 2;
            System.out.println("a="+a+"，b="+b);
            // 基本数据类型的参数传递
            swap(a, b);
            System.out.println("交换结束后a="+a+"，b="+b);

            // 引用数据类型的参数传递
            DataWarp dw = new DataWarp();
            dw.a = a;
            dw.b = b;
            swap(dw);
            System.out.println("交换结束后dw.a="+dw.a+"，dw.b="+dw.b);
            /**
             * 从上面运行结果来看，在swap(DataWarp dw)方法里， a 、b 两个成员变量的值被交换成功。
             * 不仅如此，当swap(DataWarp dw)方法执行结束后， main()方法里dataWarp.a 、dataWarp.b 两个成员变量的值也被交换了。
             * 这很容易造成一种错觉:调用swap(DataWarp dw)方法时，传入swap(DataWarp dw)方法的就是dataWarp 对象本身，而不是它的复制品。
             * 但这只是一种错觉，下面还是结合示意图来说明程序的执行过程。
             *
             * 程序从main()方法开始执行， main()方法开始创建了一个DataWrap 对象，
             * 并定义了一个dw 引用变量来指向DataWrap 对象，这是一个与基本类型不同的地方
             * 创建一个对象时，系统内存中有两个东西:堆内存中保存了对象本身,校内存中保存了引用该对象的引用变量。
             * 接着程序通过引用来操作DataWrap对象，把该对象的a 、b 两个成员变量分别赋值为1 、2 。
             * 此时系统内存中的存储示意图如下所示。
             * 栈：dw     ->     堆：DataWrap对象（a:1, b:2）
             * 接下来， main()方法中开始调用swap(DataWarp dw)方法，
             * main()方法并未结束，系统会分别为main()和swap(DataWarp dw)开辟出两个栈区，用于存放main()和swap(DataWarp dw)方法的局部变量。
             * 调用swap(DataWarp dw)方法时， dw 变量作为实参传入swap(DataWarp dw)方法，
             * 同样采用值传递方式:把main（）方法里dw 变量的值赋给swap(DataWarp dw)方法里的dw 形参,从而完成swap(DataWarp dw)方法的dw 形参的初始化。
             * 值得指出的是， main()方法中的dw 是一个引用(也就是一个指针)，它保存了DataWrap 对象的地址值，
             * 当把dw 的值赋给swap(DataWarp dw)方法的dw 形参后，即让swap(DataWarp dw)方法的dw 形参也保存这个地址值，即也会引用到堆内存中的DataWrap 对象
             * 下示例显示了dw 传入swap(DataWarp dw)方法后的存储示意图。
             * main:栈：dw     ->     堆：DataWrap对象（a:1, b:2）
             *          ↓                 ↑
             * swap:栈：dw     ->     堆：→
             * 从上图来看， 这种参数传递方式就是不折不扣的值传递方式，系统复制了dw 的副本传入swap(DataWarp dw)方法，
             * 但关键在于dw只是一个引用变量，所以系统复制了dw 变量，但并未复制DataWrap 对象。
             * （重点）（可理解为：只复制了栈里的变量并未复制堆里的实际数据，所以导致了main里的dw和swap里的dw虽然是两个不同的地址但指向的都是堆内存里的同一地址）
             * 为了更好地证明main()方法中的dw 和swap(DataWarp dw)方法中的dw 是两个变量，在swap(DataWarp dw)方法的最后一行增加如下代码
             * 把dw 直接赋值为null ，让它不再指向任何有效地址
             * dw = null;
             */
            System.out.println("a="+a+"，b="+b);
            DataWarp dwNull = new DataWarp();
            dwNull.a = a;
            dwNull.b = b;
            swapNull(dwNull);
            System.out.println("交换结束后dwNull.a="+dwNull.a+"，dwNull.b="+dwNull.b);
            /**
             * 执行上面代码的结果是swapNull(DataWarp dw)方法中的dw 变量不再指向任何有效内存，程序其他地方不做任何修改。
             * main()方法调用了swapNull(DataWarp dw)方法后，再次访问dwNull 变量的a 、b 两个成员变量，依然可以输出2 、1 。
             * 可见main()方法中的dwNull 变量没有受到任何影响。实际上，当swapNull(DataWarp dw)方法中增加dw = null ;代码后，
             * 内存中的存储示意图如下所示。
             * main:栈：dwNull     ->     堆：DataWrap对象（a:1, b:2）
             * swap:栈：dw     ->     （null）未指向任何堆内存里的地址
             * 从上图来看，把swapNull(DataWarp dw)方法中的dw 赋值为null 后，
             * swapNull(DataWarp dw)方法中失去了DataWrap 的引用，不可再访问堆内存中的DataWrap 对象。
             * 但main()方法中的dw 变量不受任何影响， 依然引用DataWrap 对象，所以依然可以输出DataWrap 对象的a 、b 成员变量的值。
             */
            System.out.println();
            System.out.println("形参个数可变的方法parameterDynamic(String... strs)");
            parameterDynamic(a, "你", "好", "啊");
    }

    /**
     * 形参个数可变的方法
     * 从JDK 1. 5 之后， Java 允许定义形参个数可变的参数，从而允许为方法指定数量不确定的形参。
     * 如果在定义方法时， 在最后一个形参的类型后增加三点( .. . ) ，则表明该形参可以接受多个参数值，
     * 多个参数值被当成数组传入。下面程序定义了一个形参个数可变的方法。
     *
     * 注意：个数可变的形参只能处于形参列表的最后。一个方法中最多只能包含一个个数可变的形参。
     * 个数可变的形参本质就是一个数组类型的形参，
     * 因此调用包含个数可变形参的方法时，该个数可史的形参既可以传入多个参数， 也可以传入一个数组。
     */
    public static void parameterDynamic(int a, String... strs) {
        for(String str: strs) {
            System.out.println(str);
        }
        System.out.println(a);
    }
}
