package library;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Java 8 新增的日期、时间格式器
 *
 * Java 8 新增的日期、时间API 里不仅包括了Instant、LocalDate 、LocalDateTime 、LocalTime 等代表日期、时间的类，
 * 而且在java.time.format 包下提供了一个DateTimeFormatter 格式器类，该类相当于前面介绍的DateFormat 和SimpleDateFormat 的合体，功能非常强大。
 *
 * 与DateFormat 、SimpleDateFormat 类似， DateTimeFormatter 不仅可以将日期、时间对象格式化成字符串，也可以将特定格式的字符串解析成日期、时间对象。
 *
 * 为了使用DateTimeFormatter 进行格式化或解析，必须先获取DateTimeFormatter 对象，获取DateTimeFormatter 对象有如下三种常见的方式。
 *
 * 直接使用静态常量创建DateTimeFormatter 格式器。DateTimeFormatter 类中包含了大量形如ISO LOCAL DATE 、ISO LOCAL TIME 、ISO LOCAL DATE TIME 等静态常量，
 * 这些静态常量本身就是DateTimeFormatter 实例。
 *
 * 使用代表不同风格的枚举值来创建DateTimeFormatter 格式器。在FormatStyle 枚举类中定义了FULL 、LONG 、MEDIUM 、SHORT 四个枚举值，它们代表日期、时间的不同风格。
 *
 * 根据模式字符串来创建DateTimeFormatter 格式器。类似于SimpleDateFormat ， 可以采用模式字符串来创建DateTimeFormatter，
 * 如果需要了解DateTimeFormatter 支持哪些模式宇符串，则需要参辛苦该类的API 文档。
 * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
 *
 *
 * 使用DateTimeFormatter 完成格式化
 *
 * 使用DateTimeFormatter 将日期、时间(LocalDate 、LocalDateTime 、LocalTime 等实例)格式化为字符串， 可通过如下两种方式。
 * 调用DateTimeFormatter 的format(TemporalAccessor temporal)方法执行格式化， 其中LocalDate 、LocalDateTime 、LocalTime 等类都是TemporalAccessor 接口的实现类。
 * 调用LocalDate 、LocalDateTime 、LocalTime 等日期、时间对象的format(DateTimeFormatter formatter)方法执行格式化。
 *
 * 上面两种方式的功能相同，用法也基本相似，如下程序示范了使用DateTimeFormatter 来格式化日期、时间。
 * @author JIE
 */
public class NewFormatterTest {

    public static void main(String[] args) {
        DateTimeFormatter[] formatters = {
                // 直接使用常量创建DateTimeFormatter 格式器
                DateTimeFormatter.ISO_LOCAL_DATE,
                DateTimeFormatter.ISO_LOCAL_TIME,
                DateTimeFormatter.ISO_LOCAL_DATE_TIME,
                // 使用本地化的不同风格来创建DateTimeFormatter 格式器
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.MEDIUM),
                DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG),
                // 根据模式字符串来创建DateTimeFormatter 格式器
                DateTimeFormatter.ofPattern("Gyyyy-MMM-dd HH:mm:ss"),
        };
        LocalDateTime date = LocalDateTime.now();
        // 依次使用不同的格式器对LocalDateTime 进行格式化
        for (int i = 0; i < formatters.length; i++) {
            // 下面两行代码的作用相同
            System.out.println(date.format(formatters[i]));
            System.out.println(formatters[i].format(date));
        }

        /**
         * 使用DateTimeFormatter 解析字符串
         *
         * 为了使用DateTimeFormatter 将指定格式的字符串解析成日期、时间对象( LocalDate 、LocalDateTimeLocalTime 等实例) ，
         * 可通过日期、时间对象提供的parse(CharSequence text, DateTimeFormatter formatter)方法进行解析。
         */
        // 定义一个任意格式的日期‘时间字符串
        String str1 = "2014==04==12 01 时 06 分 09 秒";
        // 根据需要解析的日期、时间字符串定义解析所用的格式器
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy==MM==dd HH 时 mm 分 ss 秒");
        // 执行解析
        LocalDateTime dt1 = LocalDateTime.parse(str1, formatter1);
        System.out.println(dt1);
        /**
         * 上面程序中定义了对应格式的日期、时间字符串，为了解析它们，程序使用对应的格式字符串创建了DateTimeFormatter 对象，
         * 这样DateTimeFormatter 即可按该格式字符串将日期、时间字符串解析成LocalD ateTime 对象。
         */
    }
}
