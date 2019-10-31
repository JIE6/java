package objecttwo;

/**
 * 打印对象和toString
 * @author JIE
 */

public class PrintObject {
    private String name;

    public PrintObject (String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        PrintObject printObject = new PrintObject("打印对象");
        // 打印printObject 所引用的PrintObject 对象
        System.out.println(printObject);
        /**
         * 运行上面程序时，可能看到不同的输出结果: @符号后的8 位十六进制数字可能发生改变。
         * 但这个输出结果是怎么来的呢?
         * System.out 的println()方法只能在控制台输出字符串，而Person 实例是一个内存中的对象，怎么能直接转换为宇符串输出呢?
         * 当使用该方法输出Person 对象时，实际上输出的是Person 对象的toStringO方法的返回值。也就是说，下面两行代码的效果完全一样。
         */
        System.out.println(printObject);
        System.out.println(printObject.toString());
        /**
         * toString()方法是Object 类里的一个实例方法，所有的Java 类都是Object 类的子类，因此所有的Java对象都具有toString()方法。
         * 不仅如此，所有的Java 对象都可以和字符串进行连接运算，当Java 对象和字符串进行连接运算时，
         * 系统自动调用Java 对象toString()方法的返回值和字符串进行连接运算，即下面两行代码的结果也完全相同。
         */
        String strPrintObject = printObject+"";
        String strPrintObjectToString = printObject.toString()+"";
        System.out.println(strPrintObject);
        System.out.println(strPrintObjectToString);
        /**
         * toString()方法是一个非常特殊的方法，它是一个"自我描述"方法,该方法通常用于实现这样一个功能:
         * 当程序员直接打印该对象时，系统将会输出该对象的"自我描述"信息，用以告诉外界该对象具有的状态信息。
         * Object 类提供的toString()方法总是返回该对象实现类的"类名+@+hashCode" 值，
         * 这个返回值并不能真正实现"自我描述"的功能,因此如果用户需要自定义类能实现"自我描述"的功能
         * 就必须重写Object 类的toString()方法。例如下面程序。
         */
        PrintObjectToString printObjectToString = new PrintObjectToString("打印对象和toString");
        /**
         * 编译、运行下面程序，看到如下运行结果:
         * name=打印对象和toString
         *
         * 从运行结果可以看出，通过重写PrintObjectToString 类的toString()方法，就可以让系统在打印PrintObjectToString 对象时
         * 打印出该对象的"自我描述"信息。
         *
         * 大部分时候，重写toString{}方法总是返回该对象的所有令人感兴趣的信息所组成的字符串。通常
         * 可返回如下格式的宇符串:
         * 类名[field1=值1, field2=值2，... ]
         */
        System.out.println(printObjectToString);
    }


    static class PrintObjectToString{
        private String name;

        public PrintObjectToString (String name) {
            this.name = name;
        }

        // 重写toString()方法，用于实现PrintObjectToString 对象的"自我描述"
        @Override
        public String toString() {
            return "name="+name;
        }
    }
}
