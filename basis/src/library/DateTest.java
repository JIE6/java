package library;

import java.util.Date;

/**
 * Java 提供了Date 类来处理日期、时间(此处的Date 是指java.util 包下的Date 类，而不是java.sql包下的Date 类)，
 * Date 对象既包含日期，也包含时间。Date 类从JDK 1. 0 起就开始存在了，但正因为它历史悠久，所以它的大部分构造器、方法都己经过时，
 * 不再推荐使用了。
 *
 * Date 类提供了6 个构造器， 其中4 个己经Deprecated (Java 不再推荐使用，使用不再推荐的构造器时编译器会提出警告信息，
 * 并导致程序性能、安全性等方面的问题) ，剩下的两个构造器如下。
 * Date(): 生成一个代表当前日期时间的Date 对象。该构造器在底层调用System.currentTimeMillis()获得long 整数作为日期参数。
 * Date(long date): 根据指定的long 型整数来生成一个Date 对象。该构造器的参数表示创建的Date对象和GMT 1970 年1 月1 日00:00:00 之间的时间差，以毫秒作为计时单位。
 *
 * 与Date 构造器相同的是， Date 对象的大部分方法也Deprecated 了，剩下为数不多的几个方法。
 * boolean after(Date when): 测试该日期是否在指定日期when 之后。
 * boolean before(Date when): 测试该日期是否在指定日期when 之前。
 * long getTime(): 返回该时间对应的long 型整数，即从GMT 1970-01-0100 : 00:00 到该Date 对象之间的时间差，以毫秒作为计时单位。
 * void setTime(long time): 设置该Date 对象的时间。
 * @author JIE
 */
public class DateTest {

    public static void main(String[] args) {
        Date d1 = new Date();
        // 获取当前时间之后100ms 的时间
        Date d2 = new Date(System.currentTimeMillis() + 100);
        System.out.println(d2);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.before(d2));
        /**
         * 总体来说， Date 是一个设计相当糟糕的类，因此Java 官方推荐尽量少用Date 的构造器和方法。如
         * 果需要对日期、时间进行加减运算， 或获取指定时间的年、月、日、时、分、秒信息， 可使用Calendar
         * 工具类。
         */
    }
}