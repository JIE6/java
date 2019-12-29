package library;

import java.time.*;

/**
 * Java 8 新增的日期、时间包
 * Java 8 开始专门新增了一个java.time 包， 该包下包含了如下常用的类。
 *
 * Clock: 该类用于获取指定时区的当前日期、时间。该类可取代System 类的currentTimeMillis()方法，而且提供了更多方法来获取当前日期、时间。
 * 该类提供了大量静态方法来获取Clock 对象。
 *
 * Duration: 该类代表持续时间。该类可以非常方便地获取一段时间。
 *
 * Instant: 代表一个具体的时刻，可以精确到纳秒。该类提供了静态的now()方法来获取当前时刻，也提供了静态的now(Clock clock)方法来获取clock 对应的时刻。除此之外，
 * 它还提供了一系列minusXxx()方法在当前时刻基础上减去一段时间， 也提供了plusXxx()方法在当前时刻基础上加上一段时间
 *
 * LocalDate : 该类代表不带时区的日期，例如2007-12-03 。该类提供了静态的now()方法来获取当前日期，也提供了静态的now(Clock clock)方法来获取clock 对应的日期。
 * 除此之外， 它还提了minusXxx()方法在当前年份基础上减去几年、几月、几周或几日等，也提供了plusXxx()方法在当前年份基础上加上几年、几月、几周或几日等。
 *
 * LocalTime: 该类代表不带时区的时间，例如10:15:30 。该类提供了静态的now()方法来获取当前时间，也提供了静态的now(Clock clock)方法来获取clock 对应的时间。除此之外，
 * 它还提供了minusXxxO方法在当前年份基础上减去几小时、几分、几秒等，也提供了plusXxx()方法在当前年份基础上加上几小时、几分、几秒等。
 *
 * LocalDateTime: 该类代表不带时区的日期、时间， 例如2007-12-03T10:15:30 。该类提供了静态的now()方法来获取当前日期、时间，也提供了静态的now(Clock clock)方法来获取clock
 * 对应的日期、时间。除此之外，它还提供了minusXxx()方法在当前年份基础上减去几年、几月、几日、几小时、几分、几秒等，
 * 也提供了plusXxx()方法在当前年份基础上加上几年、几月、几日、几小时、几分、几秒等。
 *
 * MonthDay: 该类仅代表月日，例如 --04-12 。该类提供了静态的now()方法来获取当前月日，也提供了静态的now(Clock clock)方法来获取clock 对应的月日。
 *
 * Year: 该类仅代表年，例如2014 。该类提供了静态的now()方法来获取当前年份，也提供了静态的now(Clock clock)方法来获取clock 对应的年份。除此之外，
 * 它还提供了minusYears()方法在当前年份基础上减去几年，也提供了plusYears()方法在当前年份基础上加上几年。
 *
 * YearMonth: 该类仅代表年月， 例如2014-04 。该类提供了静态的now()方法来获取当前年月，也提供了静态的now(Clock clock)方法来获取clock 对应的年月。
 * 除此之外，它还提供了minusXxx()方法在当前年月基础上减去几年、几月，也提供了plusXxx()方法在当前年月基础上加上几年、几月
 *
 * ZonedDateTime : 该类代表一个时区化的日期、时间。
 *
 * ZoneId: 该类代表一个时区。
 *
 * DayOfWeek: 这是一个枚举类， 定义了周日到周六的枚举值。
 *
 * Month: 这也是一个枚举类， 定义了一月到十二月的枚举值
 *
 * 下面通过一个简单的程序来示范这些类的用法。
 * @author JIE
 */
public class NewDatePackageTest {

    public static void main(String[] args) {
        // --------下面是关于Clock 的用法--------
        Clock clock = Clock.systemUTC();
        // 通过Clock 获取当前时刻
        System.out.println("当前时刻为：" + clock.instant());
        // 获取clock 对应的毫秒数，与System.currentTimeMillis () 输出相同
        System.out.println(clock.millis() + "----" + System.currentTimeMillis());
        // --------下而是关于Duration 的用法--------
        Duration d = Duration.ofSeconds(6000);
        System.out.println("6000 秒相当于" + d.toMinutes() + " 分");
        System.out.println("6000 秒相当于" + d.toHours() + " 小时");
        System.out.println("6000 秒相当于" + d.toDays() + " 天");
        // 在clock 基础上增加6000 秒，返回新的Clock
        Clock clock2 = Clock.offset(clock, d);
        // 可以看到clock2 与clock 相差1 小时40 分
        System.out.println("当前时刻加6000 秒为:" + clock2.instant());
        // --------下面是关于Instant 的用法--------
        // 获取当前时间
        Instant instant = Instant.now();
        System.out.println(instant);
        // instant 添加6000 秒(即100 分钟) . 返回新的Instant
        Instant instant2 = instant.plusSeconds(6000);
        System.out.println(instant2);
        // 根据字符串解析Instant 对象
        Instant instant3 = Instant.parse("2014-02-23T10:12:35.342Z");
        System.out.println(instant3);
        // 在instant3 的基础上添加5 小时4 分钟
        Instant instant4 = instant3.plus(Duration.ofHours(5).plusMinutes(4));
        System.out.println(instant4);
        // 获取instant4 的5 天以前的时刻
        Instant instant5 = instant4.minus(Duration.ofDays(5));
        System.out.println(instant5);
        // --------下面是关于LocalDate 的用法--------
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        // 获得2014 年的第146 天
        localDate = LocalDate.ofYearDay(2014, 146);
        System.out.println(localDate);
        // 设置为2014 年5 月21 日
        localDate = LocalDate.of(2014, 5, 21);
        System.out.println(localDate);
        // --------下面是关于LocalTime 的用法--------
        // 获取当前时间
        LocalTime localTime = LocalTime.now();
        // 设置为22 点33 分
        localTime = LocalTime.of(22, 33);
        System.out.println(localTime);
        // 返回一天中的第5503 秒
        localTime = LocalTime.ofSecondOfDay(5503);
        System.out.println(localTime);
        // --------下面是关于localDateTime 的用法--------
        // 获取当前日期、时间
        LocalDateTime localDateTime = LocalDateTime.now();
        // 当前日期、时间加上25 小时3 分钟
        localDateTime = localDateTime.plusHours(25).plusMinutes(3);
        System.out.println(localDateTime);
        // --------下面是关于Year 、YearMonth ， MonthDay 的用法示例--------
        // 获取当前的年份
        Year year = Year.now();
        System.out.println(year);
        // 当前年份再加5 年
        System.out.println(year.plusYears(5));
        // 根据指定月份获取YearMonth
        YearMonth yearMonth = year.atMonth(10);
        System.out.println(yearMonth);
        // 当前年月再加5 年、减3 个月
        System.out.println(yearMonth.plusYears(5).minusMonths(3));
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        // 设置为5 月23 日
        System.out.println(monthDay.with(Month.MAY).withDayOfMonth(23));
    }
}
