package library;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.text.DateFormat.*;

/**
 * 使用 DateFormat 格式化日期、时间
 *
 * 与NumberFormat 相似的是， DateFormat 也是一个抽象类它也提供了如下几个类方法用于获取DateFormat 对象。
 * getDateInstance(): 返回一个日期格式器， 它格式化后的字符串只有日期， 没有时间。该方法可以传入多个参数， 用于指定日期样式和Locale 等参数:如果不指定这些参数，则使用默认参数。
 * getTimeInstance(): 返回一个时间格式器， 它格式化后的字符串只有时间，没有日期。该方法可以传入多个参数，用于指定时间样式和Locale 等参数: 如果不指定这些参数，则使用默认参数.
 * getDateTimeInstance(): 返回一个日期、时间格式器， 它格式化后的字符串既有日期，也有时间。店方法可以传入多个参数， 用于指定日期样式、时间样式和Locale 等参数;如果不指定这些参数，则使用默认参数。
 *
 * 上面三个方法可以指定日期样式、时间样式参数，它们是DateFormat 的4 个静态常量: FULL 、LONG 、MEDIUM 和SHORT ， 通过这4 个样式参数可以控制生成的格式化宇符串。看如下例子程序。
 *
 * @author JIE
 */
public class DateFormatTest {

    public static void main(String[] args) {
        // 需要被格式化的时间
        Date dt = Calendar.getInstance().getTime();
        // 创建两个Locale ，分别代表中国、美国
        Locale[] locales = {Locale.CHINA, Locale.US} ;
        DateFormat[] df = new DateFormat [16];
        // 为上面两个Locale 创建16 个DateFormat 对象
        for (int i = 0; i < locales.length; i++) {
            df[i * 8] = DateFormat.getDateInstance(SHORT , locales[i]);
            df[i * 8 + 1] = DateFormat.getDateInstance(MEDIUM , locales[i]);
            df[i * 8 + 2] = DateFormat.getDateInstance(LONG , locales[i]);
            df[i * 8 + 3] = DateFormat.getDateInstance(FULL , locales[i]);

            df[i * 8 + 4] = DateFormat.getTimeInstance(SHORT , locales[i]);
            df[i * 8 + 5] = DateFormat.getTimeInstance(MEDIUM , locales[i]);
            df[i * 8 + 6] = DateFormat.getTimeInstance(LONG , locales[i]);
            df[i * 8 + 7] = DateFormat.getTimeInstance(FULL , locales[i]);
        }

        for (int i = 0; i < locales.length; i++) {
            String tip = i == 0 ? "一一中国日期格式一一"  : "一一美国日期格式一一";
            System.out.println(tip);

            System . out . println("SHORT 格式的日期格式: " + df[i * 8].format(dt));
            System . out . println("MEDIUM 格式的日期格式: " + df[i * 8 + 1].format(dt));
            System . out . println("LONG 格式的日期格式: " + df[i * 8 + 2].format(dt));
            System . out . println("FULL 格式的日期格式: " + df[i * 8 + 3].format(dt));

            System . out . println("SHORT 格式的时间格式: " + df[i * 8 + 4].format(dt));
            System . out . println("MEDIUM 格式的时间格式: " + df[i * 8 + 5].format(dt));
            System . out . println("LONG 格式的时间格式: " + df[i * 8 + 6].format(dt));
            System . out . println("FULL 格式的时间格式: " + df[i * 8 + 7].format(dt));
        }
    }
}
