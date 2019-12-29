package library;

import java.util.Calendar;
import java.util.Date;

/**
 * Calendar 类
 *
 * 因为Date 类在设计上存在一些缺陷， 所以Java 提供了Calendar 类来更好地处理日期和时间。Calendar 是一个抽象类， 它用于表示日历。
 *
 * Calendar 类本身是一个抽象类， 它是所有日历类的模板，并提供了一些所有日历通用的方法; 但它本身不能直接实例化，程序只能创建Calendar 子类的实例，
 * Java 本身提供了一个GregorianCalendar 类，一个代表格里高利日历的子类，它代表了通常所说的公历。
 *
 * 当然，也可以创建自己的Calendar 子类，然后将它作为Calendar 对象使用(这就是多态)。
 *
 * Calendar 类是一个抽象类，所以不能使用构造器来创建Calendar 对象。但它提供了几个静态getInstanceO方法来获取Calendar 对象，
 * 这些方法根据TimeZone ， Locale 类来获取特定的Calendar ，如果不指定TimeZone 、Locale ， 则使用默认的TimeZone 、Locale 来创建Calendar 。
 *
 * Calendar 与Date 都是表示日期的工具类， 它们直接可以自由转换
 * @author JIE
 */
public class CalendarTest {

    public static void main(String[] args) {
        // 创建一个默认的Calendar 对象
        Calendar calendar = Calendar.getInstance();
        // 从Calendar 对象中取出Date 对象
        Date date = calendar.getTime();
        // 通过Date 对象获得对应的Calendar 对象, 因为Calendar / GregorianCalendar 没有构造函数可以接收Date 对象, 所以必须先获得一个Calendar 实例，然后调用其setTime ()方法
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);

        /**
         * Calendar 类提供了大量访问、修改日期时间的方法，常用方法如下。
         *
         * void add(int field, int amount) : 根据日历的规则， 为给定的日历宇段添加或减去指定的时间量。
         *
         * int get(int field): 返回指定日历宇段的值。
         *
         * int getActualMaximum(int field): 返回指定日历字段可能拥有的最大值。例如月， 最大值为11 。
         *
         * int getActualMinimum(int field): 返回指定日历字段可能拥有的最小值。例如月，最小值为0 。
         *
         * void roll(int field, int amount): 与add()方法类似，区别在于加上amount 后超过了该字段所能表示的最大范围时，也不会向上一个宇段进位。
         *
         * void set(int field, int value): 将给定的日历字段设置为给定值。
         *
         * void set(int year, int month, int date): 设置Calendar 对象的年、月、日三个字段的值。
         *
         * void set(int year, int month, int date, int hourOfDa弘int minute, int second) : 设置Calendar 对象的年、月、日、时、分、秒6 个字段的值。
         *
         * 上面的很多方法都需要一个int 类型的field 参数， field 是Calendar 类的类变量， 如Calendar.YEAR 、
         * Calendar.MONTH 等分别代表了年、月、日、小时、分钟、秒等时间宇段。需要指出的是， Calendar.MONTH宇段代表月份，
         * 月份的起始值不是1，而是0 ，所以要设置8 月时，用7 而不是8 。如下程序示范了Calendar类的常规用法。
         */
        Calendar c = Calendar.getInstance();
        // 取出年
        System.out.println(c.get(Calendar.YEAR));
        // 取出月份
        System.out.println(c.get(Calendar.MONTH) + 1);
        // 取出日
        System.out.println(c.get(Calendar.DATE));
        // 分别设置年、月、日、小时、分钟、秒    2003-11-23 12:32:23
        c.set(2003, 10, 23, 12, 32, 23);
        // 将Calendar 的年前推l 年    2002-11-23 12:32:23
        c.add(Calendar.YEAR, -1);
        // 将Calendar 的月前推8 个月   2002-03-23 12 : 32:23
        c.roll(Calendar.MONTH, -8);
        System.out.println(c.getTime());
        /**
         * Calendar 类还有如下几个注意点。
         * add 与roll 的区别
         * add(int field, int amount) 的功能非常强大， add 主要用于改变Calendar 的特定宇段的值。如果需要增加某宇段的值，则让amount 为正数;如果需要减少某宇段的值，则让amount 为负数即可。
         * add(int field, int amount)有如下两条规则。
         * 当被修改的宇段超出它允许的范围时，会发生进位，即上一级宇段也会增大。例如:
         * Calendar cal1 = Calendar.getInstance();
         *  // 2003 - 8 - 23
         * cal1.set(2003 , 7, 23 , 0， 0， 0);
         * // 2003 - 8- 23 => 2004 - 2 - 23
         * cal1.add(MONTH , 6);
         * 如果下一级宇段也需要改变，那么该字段会修正到变化最小的值。例如:
         * Calendar cal2 = Calendar.getInstance();
         * // 2003 - 8 - 31
         * ca12.set(2003 , 7, 31 , 0, 0 , 0);
         * // 因为进位后月份改为2 月， 2 月没有31 日，自动变成29 日
         * // 2003-8-31 => 2004 - 2 - 29
         * ca12.add(MONTH , 6);
         *
         * 对于上面的例子， 8 -31 就会变成2 -29 。因为MONTH 的下一级字段是DATE ，从31 到29 改变最小。所以上面2003-08-31 的MONTH 字段增加6 后，不是变成2 004-3 -2 ，
         * 而是变成2004-2 -29 。
         * roll()的规则与add() 的处理规则不同: 当被修改的宇段超出它允许的范围时，上一级字段不会增大。
         * Calendar cal3 = Calendar.getInstance();
         * // 2003-8-23
         * ca13.set (2003 , 7 , 23 , 0 , 0 , 0) ;
         * // MONTH 字段"进位' ，但YEAR 字段并不增加
         * // 2003 - 8 - 23 => 2003-2- 23
         * ca13.roll(MONTH, 6);
         * 下一级字段的处理规则与add()相似:
         * Calendar ca14 = Calendar.getInstance() ;
         * // 2003 - 8 - 31
         * ca14.set(2003 , 7, 31 , 0, 0 , 0);
         * // MONTH 字段"进位"后变成2 ， 2 月没有31 日, YEAR 字段不会改变， 2003 年2 月只有28 天
         * // 2003-8-31 => 2003-2-28
         * ca14.roll(MONTH, 6);
         */

        /**
         * 设置Calendar 的容错性
         *
         * Calendar 有两种解释日历宇段的模式: lenient 模式和non-lenient。当Calendar 处于lenient 模
         * 式时，每个时间宇段可接受超出它允许范围的值: 当Calendar 处于non-lenient 模式时， 如果为某个时
         * 间宇段设置的值超出了它允许的取值范围， 程序将会抛出异常。
         */
        Calendar cal = Calendar.getInstance();
        // 结果是YEAR 字段加1 ， MONTH 字段为1 (2 月)      1
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());
        // 关闭容错性
        cal.setLenient(false);
        // 导致运行时异常
        cal.set(Calendar.MONTH, 13);
        System.out.println(cal.getTime());

        /**
         * set()方法延迟修改
         *
         * set(f, value)方法将日历宇段f 更改为value ， 此外它还设置了一个内部成员变量，以指示日历宇段f己经被更改。
         * 尽管日历宇段f 是立即更改的， 但该Calendar 所代表的时间却不会立即修改，直到下次调用get() 、getTime() 、getTimeInMi11is()、
         * add() 或roll()时才会重新计算日历的时间。这被称为set()方法的延迟修改， 采用延迟修改的优势是多次调用set()不会触发多次不必要的计算
         * (需要计算出一个代表实际时间的long 型整数) 。
         */
        Calendar cale = Calendar.getInstance();
        // 2003- 8- 31
        cale.set (2003 , 7 , 31);
        // 将月份设为9 ，但9 月31 日不存在, 如果立即修改，系统将会把cale 自动调整到10 月1 日
        cale.set (Calendar.MONTH , 8);
        // 下面代码输出10 月1 日        1-代码
        System.out.println(cale.getTime());
        // 设置DATE 字段为5      2-代码
        cale.set (Calendar.DATE , 5);
        // 3-代码
        System.out.println(cale.getTime());
        /**
         * 上面程序中创建了代表2003-8-31 的Calendar 对象，当把这个对象的MONTH 字段加l 后应该得到2003-10-1 (因为9 月没有31 日)，如果程序在 1-号代码处输出当前Calendar 里的日期，
         * 也会看到输出2003-10-1 ， 3-号代码处将输出2003-10-5 。
         *
         * 如果程序将1-处代码注释起来， 因为Calendar 的set()方法具有延迟修改的特性，即调用set()方法后Calendar 实际上并未计算真实的日期， 它只是使用内部成员变量表记录MONTH 字段被修改为8 ，
         * 接着程序设置DATE 宇段值为5 ，程序内部再次记录DATE 宇段为5, 就是9 月5 日， 因此看到3-代码处输出2003-9-5 0
         */

    }
}
