package library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 使用SimpleDateFormat 格式化日期
 *
 * 前面介绍的DateFormat 的parse方法可以把字符串解析成Date 对象，但实际上DateFormat 的parse方法不够灵活, 它要求被解析的字符串必须满足特定的格式!为了更好地格式化日期、
 * 解析日期字符串， Java 提供了SimpleDateFormat 类。
 *
 * SimpleDateFormat 是DateFormat 的子类，正如它的名字所暗示的，它是"简单"的日期格式器。
 *
 * SimpleDateFormat 可以非常灵活地格式化Date ，也可以用于解析各种格式的日期字符串。创建SimpleDateFormat 对象时需要传入一个阴阳m 字符串，
 * 这个pattern 不是正则表达式，而是一个日期模板宇符串
 * @author JIE
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        // 创建一个SimpleDateFormat 对象
        SimpleDateFormat sdf1 = new SimpleDateFormat("Gyyyy年中第D天");
        // 将d 格式化成日期，输出: 公元2019年中第363天
        String dataStr = sdf1.format(date);
        System.out.println(dataStr);
        // 一个非常特殊的日期字符串
        String str = "14###3月##21";
        SimpleDateFormat sdf2 = new SimpleDateFormat("y###MMM##dd");
        // 将日期字符串解析成日期， 输出: Fri Mar 21 00:00:00 CST 2014
        System.out.println(sdf2.parse(str));

        /**
         * 从上面程序中可以看出，使用SimpleDateFormat 可以将日期格式化成形如"公元2019年中第363天"这样的字符串，也可以把形如"14###3月##21"这样的字符串解析成日期，
         * 功能非常强大。SimpleDateFormat 把日期格式化成怎样的字符串， 以及能把怎样的字符串解析成Date ， 完全取决于创建该对象时指定的pattern 参数，
         * pattern 是一个使用日期字段占位符的日期模板
         *
         * 如果想知道SimpleDateFormat 支持哪些日期、时间占位符，可以查阅API 文档中SimpleDateFormat 类的说明
         * https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
         */
    }
}
