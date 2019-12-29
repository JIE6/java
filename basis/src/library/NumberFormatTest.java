package library;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * 使用NumberFormat 格式化数字
 *
 * MessageFormat 是抽象类Format 的子类， Format 抽象类还有两个子类: NumberFormat 和DateFormat ，
 * 它们分别用以实现数值、日期的格式化。NumberFormat 、DateFormat 可以将数值、日期转换成宇符串，也可以将字符串转换成数值、日期
 *
 * NumberFormat 和DateFormat 都包含了format 和parse方法，其中format用于将数值、日期格式化成字符串， parse用于将字符串解析成数值、日期。
 *
 * NumberFormat 也是一个抽象基类，所以无法通过它的构造器来创建NumberFormat 对象，它提供了如下几个类方法来得到NumberFormat 对象
 * getCurrencyInstance(): 返回默认Locale 的货币格式器。也可以在调用该方法时传入指定的Locale则获取指定Locale 的货币格式器。
 * getIntegerInstance(): 返回默认Locale 的整数格式器。也可以在调用该方法时传入指定的Locale ，则获取指定Locale 的整数格式器。
 * getNumberInstance(): 返回默认Locale 的通用数值格式器。也可以在调用该方法时传入指定的Locale ，则获取指定Locale 的通用数值格式器。
 * getPercentInstance(): 返回默认Locale 的百分数格式器。也可以在调用该方法时传入指定的Locale ，则获取指定Locale 的百分数格式器。
 *
 * 一旦取得了NumberFormat 对象后，就可以调用它的formatO方法来格式化数值，包括整数和浮点数。如下例子程序示范了NumberFormat 的三种数字格式化器的用法。
 * @author JIE
 */
public class NumberFormatTest {

    public static void main(String[] args) {
        // 需要被格式化的数字
        double db = 1234000.567;
        // 创建四个Locale ，分别代表中国、日本、德国、美国
        Locale[] locales = {Locale.CHINA, Locale.JAPAN, Locale.GERMAN, Locale.US};
        NumberFormat[] nf = new NumberFormat[12];
        // 为上面四个Locale 创建12 个NumberFormat 对象
        //每个Locale 分别有通用数值格式器、百分数格式器、货币格式器
        for (int i = 0; i < locales.length; i++) {
            nf[i * 3] = NumberFormat.getNumberInstance(locales[i]);
            nf[i * 3 + 1] = NumberFormat.getPercentInstance(locales[i]);
            nf[i * 3 + 2] = NumberFormat.getCurrencyInstance(locales[i]);
        }

        for (int i = 0; i < locales.length; i++) {
            String tip = i == 0 ? "----中国的格式----" : i == 1 ? "----日本的格式----" : i == 2 ? "----德国的格式----" : "----美国的格式----";
            System.out.println(tip);
            System.out.println("通用数值格式：" + nf[i * 3].format(db));
            System.out.println("百分比数值格式：" + nf[i * 3 + 1].format(db));
            System.out.println("货币数值格式：" + nf[i * 3 + 2].format(db));
        }

        /**
         * 从程序结果可以看出， 德国的小数点比较特殊， 它们采用逗号( , )作为小数点:中国、日本使用￥作为货币符号，而美国则采用$作为货币符号。
         * NumberFormat其实也有国际化的作用! 没错， 同样的数值在不同国家的写法是不同的， 而NumberFormat 的作用就是把数值转换成不同国家的本地写法。
         * 至于使用NumberFormat 类将字符串解析成数值的意义不大( 因为可以使用Integer 、Double等包装类完成这种解析) ，
         */
    }
}
