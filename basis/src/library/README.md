# java 基础类库

<pre>
    Oracle 为Java 提供了丰富的基础类库， Java 8 提供了4000 多个基础类通过这些基础类库可以提高开发效率， 
降低开发难度。对于合格的Java 程序员而言， 至少要熟悉Java SE 中70% 以上的类
    Java 提供了String 、StringBuffer 和StringBuilder 来处理字符串， 它们之间存在少许差别， 本包会详
细介绍它们之间的差别，以及如何选择合适的字符串类。Java 还提供了Date 和Calendar 来处理日期、时间，其中Date 
是一个己经过时的API， 通常推荐使用Calendar 来处理日期、时间。
    正则表达式是一个强大的文本处理工具， 通过正则表达式可以对文本内容进行查找、替换、分割等操作。从JDK 1 .4以后，
Java 也增加了对正则表达式的支持，包括新增的Pattern 和Matcher 两个类，并改写了String 类， 让String 类增加了
正则表达式支持， 增加了正则表达式功能后的String 类更加强大
    Java 还提供了非常简单的国际化支持， Java 使用Locale 对象封装一个国家、语言环境， 再使用ResourceBundle 
根据Locale 加载语言资源包，当ResourceBundle 加载了指定Locale 对应的语言资源文件后， ResourceBundle 对象
就可调用getStringO方法来取出指定key 所对应的消息字符串。
</pre>

## 当前包下需重点掌握的类
| 类名 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| ArgsTest | 5 | 运行Java 程序的参数 |
| ScannerKeyBoardTest | 5 | 使用Scanner 获取键盘输入 |
| SystemTest | 5 | System 类 |
| RuntimeTest,ProcessHandleTest | 5 | Runtime 类与Java 9 的ProcessHandle |
| ObjectTest | 5 | Object类 |
| ObjectsTest | 5 | Java 7 新增的Objects 类 |
| StringTest,StringBuilderTest | 5 | Java 9 改进的String 、StringBuffer 和StringBuilder 类 |
| MathTest | 5 | Math 类 |
| RandomTest | 5 | Java 7 的ThreadLocalRandom 与Random |
| BigDecimalTest | 5 | BigDecimal 类 |
| DateTest | 5 | Date 类 |
| CalendarTest | 5 | Calendar 类 |
| NewDatePackageTest | 5 | Java 8 新增的日期、时间包 |
| RegexTest | 5 | 正则表达式 |
| MethodHandleTest | 5 | Java 9 增强的MethodHandle |
| VarHandleTest | 5 | Java 9 增加的VarHandle |
| LocaleList,RawHello,HelloArg | 5 | Java 9 改进的国际化与格式化 |
| LoggerTest | 5 | Java 9 新增的日志API |
| NumberFormatTest | 5 | 使用NumberFormat 格式化数字 |
| DateFormatTest | 5 | 使用 DateFormat 格式化日期、时间 |
| SimpleDateFormatTest | 5 | 使用SimpleDateFormat 格式化日期 |
| NewFormatterTest | 5 | Java 8 新增的日期、时间格式器 |