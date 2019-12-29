package library;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Java 9 改进的国际化与格式化
 *
 * 完成程序国际化
 *
 * 对于如下最简单的程序:
 *
 * public static void main(String[] args) {
 *         System.out.println("Hello World");
 * }
 *
 * 这个程序的执行结果也很简单一一肯定是打印出简单的"Hello World" 字符串，不管在哪里执行都不会有任何改变!为了让该程序支持国际化， 肯定不能让程序直接输出"Hello World " 字符串，
 * 这种写法直接输出一个字符串常量， 永远不会有任何改变。为了让程序可以输出不同的字符串，此处绝不可使用该字符串常量。
 *
 * 为了让上面输出的宇符串常量可以改变，可以将需要输出的各种字符串( 不同的国家/语言环境对应不同的宇符串)定义在资源包中。
 * 为上面程序提供如下两个文件。
 * 第一个文件: mess_zh_CN.properties
 * 第二个文件: mess_en_US.properties
 *
 * Java 9 支持使用UTF-8 字符集来保存属性文件，这样在属性文件中就可以直接包含非西欧字符，因此属性文件也不再需要使用native2ascii 工具进行处理。
 * 唯一要注意的是，属性文件必须显式保存为UTF- 8 字符集。
 *
 * 看到这两份文件文件名的baseName 是相同的: mess 。前面己经介绍了资源文件的三种命名方式，其中baseName 后面的国家、语言必须是Java 所支持的国家、语言组合。
 * 将上面的Java 程序修改成如下形式。
 *
 * @author JIE
 */
public class RawHello {

    public static void main(String[] args) {
        // 取得系统默认的国家/ 语言环境
        Locale myLocale = Locale.getDefault(Locale.Category.FORMAT);
        // 根据指定的国家/ 语言环境加载资源文件
        ResourceBundle msee = ResourceBundle.getBundle("library/mess", myLocale);
        // 打印从资源文件中取得的消息
        System.out.println(msee.getString("hello"));

        /**
         * 上面程序中的打印语句不再是直接打印"Hello World" 字符串，而是打印从资源包中读取的信息如果在中文环境下运行该程序，将打印"你好";
         * 如果在"控制面板"中将机器的语言环境设置成美国，然后再次运行该程序，将打印"Welcome"字符串。
         *
         * 从上面程序可以看出，如果希望程序完成国际化，只需要将不同的国家/语言(Locale) 的提示信息分别以不同的文件存放即可。
         * 例如，简体中文的语言资源文件就是Xxx_zh_CN.properties 文件，而美国英语的语言资源文件就是Xxx_en_US.properties 文件。
         *
         * Java 程序国际化的关键类是ResourceBundle ，它有一个静态方法: getBundle(String baseName, Locale locale) ，该方法将根据Locale 加载资源文件，
         * 而Locale 封装了一个国家、语言，例如，简体中文环境可以用简体中文的Locale 代表，美国英语环境可以用美国英语的Locale 代表。
         *
         * 从上面资源文件的命名中可以看出，不同国家、语言环境的资源文件的baseName 是相同的，即baseName 为mess 的资源文件有很多个，不同的国家、语言环境对应不同的资源文件
         *
         *
         */
    }
}
