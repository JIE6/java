package library;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Java 9 改进的国际化与格式化
 *
 * 使用MessageFormat 处理包含占位符的字符串
 *
 * 上面程序中输出的消息是一个简单消息，如果需要输出的消息中必须包含动态的内容， 例如，这些内容必须是从程序中取得的。比如如下字符串:
 * 你好， yeeku! 今天是2014-5-30 下午11:55
 *
 * 在上面的输出字符串中， yeeku 是浏览者的名字，必须动态改变，后面的时间也必须动态改变。在这种情况下，可以使用带占位符的消息。例如，
 * 提供一个myMess_en_US.properties 文件，
 * 该文件的内容如下:
 * msg=Hello , {0}!Today is {1}.
 * 提供一个myMess_zh_CN.properties 文件，
 * 该文件的内容如下:
 * msg=msg=Hello , {0}!Today is {1}.
 *
 * 当程序直接使用ResourceBundle 的getString()方法来取出msg 对应的字符串时， 在简体中文环境下得到"你好， {0}! 今天是{1} o " 字符串，这显然不是需要的结果，
 * 程序还需要为{0} 和{1} 两个占位符赋值。此时需要使用MessageFormat 类，该类包含一个有用的静态方法。
 *
 * format(String pattern ， Object... values) : 返回后面的多个参数值填充前面的pattern 字符串，其中pattern 字符串不是正则表达式，而是一个带占位符的字符串。
 *
 * 借助于上面的MessageFormat 类的帮助， 将国际化程序修改成如下形式。
 * @author JIE
 */
public class HelloArg {

    public static void main(String[] args) {
        // 定义一个Locale 变量
        Locale currentLocale = null;
        // 如果运行程序指定了两个参数
        if (args.length == 2) {
            // 使用运行程序的两个参数构造Locale 实例
            currentLocale = new Locale(args[0] , args[1]);
        }else {
            // 否则直接使用系统默认的Locale
            currentLocale = Locale.getDefault(Locale.Category.FORMAT) ;
        }
        // 根据Locale 加载语言资源
        ResourceBundle bundle = ResourceBundle.getBundle("library/myMess", currentLocale);
        // 取得己加载的语言资源文件中msg 对应消息
        String msg = bundle.getString("msg");
        // 使用MessageFormat 为带占位符的字符串传入参数
        System.out.println(MessageFormat.format(msg, "yeeku", LocalDate.now()));

        /**
         * 从上面的程序中可以看出，对于带占位符的消息字符串，只需要使用MessageFormat 类的format方法为消息中的占位符指定参数即可。
         */
    }
}
