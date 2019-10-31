package objecttwo;

/**
 * 包装类及其用法
 *
 * Java为8 个基本类型提供了对应的包装类， 通过这些包装类可以把8 个基本类型的值包装成对象使用，
 * JDK1.5 提供了自动装箱和自动拆箱功能，允许把基本类型值直接赋给对应的包装类引用变量，也允许把包装类对象直接赋给对应的基本类型变量。
 *
 * 在JDK 1.5 以前，把基本数据类型变量变成包装类实例需要通过对应包装类的valueOf()静态方法来实现。
 * 在JDK 1.5 以前， 如果希望获得包装类对象中包装的基本类型变量，则可以使用包装类提供的xxxValueO实例方法。由于这种用法已经过时，故此处不再给出示例代码。
 *
 * Java 提供的基本类型变量和包装类对象之间的转换有点烦琐， 但从JDK 1.5之后这种烦琐就消除了，
 * JDK 1.5 提供了自动装箱（ Autoboxing ) 和自动拆箱（ AutoUnboxing ) 功能
 * 所谓自动装箱， 就是可以把一个基本类型变量直接赋给对应的包装类变量， 或者赋给Object 变量（ Object是所有类的父类， 子类对象可以直接赋给父类变量) ;
 * 自动拆箱则与之相反，允许直接把包装类对象直接赋给一个对应的基本类型变量。
 *
 * @author JIE
 */
public class WrapperClass {

    public static void main(String[] args) {
        // 直接把一个基本类型变量赋给Integer 对象
        Integer inObj = 5;
        // 直接把一个boolean 类型变量赋给一个Object 类型的变量
        Object boolObj = true;
        // 直接把一个Integer 对象赋给int 类型的变量
        int it = inObj;
        if (boolObj instanceof Boolean) {
            //先把Object 对象强制类型转换为Boolean 类型，再赋给boolean 变量
            boolean b = (Boolean)boolObj;
            System.out .println(b);
        }

        /**
         * 除此之外，包装类还可实现基本类型变量和字符串之间的转换。把字符串类型的值转换为基本类型的值有两种方式。
         * 1.利用包装类提供的parseXxx(String s)静态方法除Character之外的所有包装类都提供了该方法。
         * 2.利用包装类提供的valueOf(String s)静态方法。
         * String 类也提供了多个重载valueOf()方法，用于将基本类型变量转换成字符串，
         */
        String intStr = "123";
        // 把一个特定字符串转换成int 变量
        int it1 = Integer.valueOf(intStr);
        int it2 = Integer.parseInt(intStr);
        System.out.println(it2);
        String floatStr = "4.56";
        // 把一个特定字符串转换成float 变量
        float ftl = Float.parseFloat(floatStr);
        float ft2 = Float.valueOf(floatStr);
        System.out.println(ft2);
        // 把一个float 变量转换成String 变量a
        String ftStr = String.valueOf(2.345f) ;
        System.out.println(floatStr);
        // 把一个double 变量转换成String 变量
        String dbStr = String.valueOf(3.344);
        System.out.println(dbStr);
        // 把一个boolean 变量转换成String 变量
        String boolStr = String.valueOf(true);
        System.out.println(boolStr) ;
        // 如果希望把基本类型变量转换成字符串，还有一种更简单的方法: 将基本类型变量和""进行连接运算，系统会自动把基本类型变量转换成字符串。例如下面代码:
        // intStr 的值为" 5"
        String intStr1 = 5+"";
        /**
         * 要指出的是，虽然包装类型的变量是引用数据类型，但包装类的实例可以与数值类型的值进行比较，
         * 这种比较是直接取出包装类实例所包装的数值来进行比较的。
         */
        Integer a = Integer.valueOf(6);
        // 输出true
        System.out.println("6的包装类实例是否大于5.0 " + (a > 5.0));
        /**
         * 两个包装类的实例进行比较的情况就比较复杂， 因为包装类的实例实际上是引用类型，
         * 只有两个包装类引用指向同一个对象时才会返回true 。下面代码示范了这种效果
         */
        // 输出false
        System.out.println( " 比较2 个包装类的实例是否相等" + (Integer.valueOf(2) == Integer.valueOf(2)));
        /**
         * 但JDK 1.5 以后支持所谓的自动装箱，自动装箱就是可以直接把一个基本类型值赋给一个包装类实例，
         * 在这种情况下可能会出现一些特别的情形。看如下代码
         */
        // 通过自动装箱，允许把基本类型值赋值给包装类实例
        Integer ina = 2 ;
        Integer inb = 2 ;
        //输出true
        System.out.println( "两个2 自动装箱后是否相等: " + (ina == inb) );
        Integer biga = 128;
        Integer bigb = 128;
        //输出fa1se
        System.out.println( " 两个128 自动装箱后是否相等: " + (biga == bigb));
        /**
         * 上面程序让人比较费解:同样是两个int 类型的数值自动装箱成Integer 实例后，如果是两个2 自动装箱后就相等;但如果是两个1 28 自动装箱后就不相等，这是为什么呢?
         * 这与Java 的Integer 类的设计有关，查看Java 系统中j ava.lang . Integer 类的源代码，如下所示。
         * //定义一个长度为256 的Integer 数组
         * static final Integer[] cache =new Integer[-( - 128) + 127 + 1];
         * static {
         *     //执行初始化，创建-128 到127 的Integer 实例，并放入cache 数组中
         *     for(int i = 0; i < cache . length ; i++)
         *     cache[i] = new Integer(i - 128) ;
         * }
         * 从上面代码可以看出， 系统把一个 -128~127 之间的整数自动装箱成Integer 实例， 并放入了一个名为cache 的数组中缓存起来。
         * 如果以后把一个-128~127 之间的整数自动装箱成一个Integer 实例时， 实际上是直接指向对应的数组元素，
         * 因此-128~ 127 之间的同一个整数自动装箱成Integer 实例时，永远都是引用cache 数组的同一个数组元素，所以它们全部相等;
         * 但每次把一个不在一128~127 范围内的整数自动装箱成Integer 实例时，系统总是重新创建一个Integer 实例，所以出现程序中的运行结果。
         */

        /**
         * Java 7 增强了包装类的功能， Java 7 为所有的包装类都提供了一个静态的compare(xxx val1 , xxx val2)方法，
         * 这样开发者就可以通过包装类提供的compare(xxx val1, xxx val2)方法来比较两个基本类型值的大小，
         * 包括比较两个boolean 类型值，两个boolean 类型值进行比较时， true > false 。例如如下代码:
         */
        // 输出l
        System.out.println(Boolean.compare(true , false));
        // 输出0
        System.out.println(Boolean.compare(true , true));
        // 输出-1
        System.out.println(Boolean.compare(false , true));
        /**
         * Java 8 再次增强了这些包装类的功能，其中一个重要的增强就是支持无符号算术运算。
         * Java 8 为整型包装类增加了支持无符号运算的方法。
         * Java 8 为Integer、Long 增加了如下方法。
         *
         * static String toUnsignedString(int/long i): 该方法将指定int 或long 型整数转换为无符号整数对应的字符串。
         * static String toUnsignedString(int i/long,int radix): 该方法将指定int 或long 型整数转换为指定进制的无符号整数对应的宇符串。
         * static xxx parseUnsignedXxx(String s): 该方法将指定字符串解析成无符号整数。当调用类为Integer 时， xxx 代表int; 当调用类是Long 时， xxx 代表long 。
         * static xxx parseUnsignedXxx(String s, int radix): 该方法将指定字符串按指定进制解析成无符号整数。当调用类为Integer 时， xxx 代表int; 当调用类是Long 时， xxx 代表long 。
         * static int compareUnsigned(xxx x, xxx y): 该方法将x 、y 两个整数转换为无符号整数后比较大小。当调用类为Integer 时， xxx 代表int; 当调用类是Long 时， xxx 代表long 。
         * static long divideUnsigned(long divide时， long divisor): 该方法将x 、y 两个整数转换为无符号整数后计算它们相除的商。当调用类为Integer 肘， xxx 代表mt; 当调用类是Long 时， xxx 代表long 。
         * static long remainderUnsigned(long dividend, long divisor): 该方法将x 、y 两个整数转换为无符号整数后计算它们相除的余数。当调用类为Integer 时， xxx 代表mt; 当调用类是Long 时， xxx代表long 。
         *
         * Java 8 还为Byte、Short 增加了toUnsignedInt(xxx x) 、toUnsignedLong(yyy x)两个方法，
         * 这两个方法用于将指定byte 或short 类型的变量或值转换成无符号的int 或long 值。
         */
        byte b = -3 ;
        // 将byte 类型的- 3 转换为无符号整数
        // 输出253
        System.out.println("byte 类型的- 3 对应的无符号整数: "+ Byte.toUnsignedInt(b)) ;
        // 指定使用十六进制解析无符号整数
        int va1 = Integer.parseUnsignedInt( "ab" , 16) ;
        // 输出171
        System.out.println(va1);
        // 将-12 转换为无符号int 型，然后转换为十六进制的字符串
        // 输出fffffff4
        System.out.println( Integer.toUnsignedString(- 12 , 16) );
        // 将两个数转换为无符号整数后相除
        System.out.println( Integer.divideUnsigned(-2 , 3) );
        // 将两个数转换为无符号整数相除后求余
        System.out.println( Integer.remainderUnsigned(-2 , 7) );
        /**
         * 无符号整数最大的特点是最高位不再被当成符号位，因此无符号整数不支持负数，其最小值为0 。
         * 上面程序的运算结果可能不太直观。理解该程序的关键是先把操作数转换为无符号整数，然后再进行计算
         * 以byte 类型的3 为例，其原码为10000011 (最高位1 代表负数) ，其反码为11111100 ，补码为11111101.
         * 如果将该数当成无符号整数处理， 那么最高位的1 就不再是符号位，也是数值位，该数就对应为253即上面程序的输出结果
         * 只要先将上面表达式中的操作数转换为无符号整数，然后再进行运算，即可得到程序的输出结果。
         */
    }
}
