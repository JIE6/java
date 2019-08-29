package basictype;

/**
 * 重点
 * ------------------------------------------------------------------------------------------------
 * 自动类型转换
 * Java 所有的数值型变量可以相互转换
 * 如果系统支持把某种基本类型的值直接赋给另一种基本类型的变量，则这种方式被称为自动类型转换
 * 当把一个表数范围小的数值或变量直接赋给另一个表数范围大的变量时，系统将可以进行自动类型转换:否则就需要强制转换。
 * 以下箭头左边的数值类型可以自动类型转换为箭头右边的数值类型
 *          char ↘
 *                 int → long → float → double
 * byte → short ↗
 * ------------------------------------------------------------------------------------------------
 * 强制类型转换
 * 把一个浮点数强制类型转换为整数时， Java 将直接截断浮点数的小数部分。
 * 除此之外，把233 强制类型转换为byte 类型的整数，从而变成了23 ， 这就是典型的溢出。下面程序变量bi有示范了这个转换过程。
 * ------------------------------------------------------------------------------------------------
 * 表达式类型的自动提升
 * 当一个算术表达式中包含多个基本类型的值时，整个算术表达式的数据类型将发生自动提升。Java定义了如下的自动提升规则。
 * 所有的byte 类型、short 类型和char 类型将被提升到int 类型。
 * 整个算术表达式的数据类型自动提升到与表达式中最高等级操作数同样的类型。操作数的等级排列如下所示，位于箭头右边类型的等级高于位于箭头左边类型的等级。
 *          char ↘
 *                 int → long → float → double
 * byte → short ↗
 * @author JIE
 */

public class AutoConversion {

    public static void main(String[] args) {
        char c = 'a';
        byte b = 122;
        short s = 2;
        int i = 128;
        long l = 65632L;
        float f = 5.0F;
        double d = 97.9;
        // 自动类型转换
        short sb = b;
        int ib = b;
        int ic = c;
        long li = i;
        float fc = c;
        double db = b;
        double df = f;
        System.out.println(sb);
        System.out.println(ib);
        System.out.println(ic);
        System.out.println(li);
        System.out.println(fc);
        System.out.println(db);
        System.out.println(df);
        // 下面代码将出错， byte 类型不能自动类型转换为char 类型
        // char cb = b;
        // 强制类型转换
        int id = (int) d;
        byte bi = (byte) i;
        char cb = (char)b;
        char cl = (char)l;
        char cd = (char)d;
        System.out.println(id);
        System.out.println(bi);
        System.out.println(cb);
        System.out.println(cl);
        System.out.println(cd);
        // 表达式类型的自动提升
        int bb = b - b;
        int ss = s / s;
        int bs = b * s;
        int bc = b + c;
        long il = i + l;
        float bf = b + f;
        double sc = s + c;
        System.out.println(bb);
        System.out.println(ss);
        System.out.println(bs);
        System.out.println(bc);
        System.out.println(il);
        System.out.println(bf);
        System.out.println(sc);
        // 表达式的类型将严格保持和表达式中最高等级操作数相同的类型。
        // 下面代码中两个int类型整数进行除法运算， 即使无法除尽， 也将得到一个int 类型结果
        // 当两个整数进行除法运算时， 如果不能整除， 得到的结果将是把小数部分截断取整后的整数。
        System.out.println(7 / 5);
        String str = null;
    }
}
