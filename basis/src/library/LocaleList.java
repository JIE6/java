package library;

import java.util.Locale;

/**
 * Java 9 改进的国际化与格式化
 *
 * 全球化的Internet 需要全球化的软件。全球化软件，意味着同一种版本的产品能够容易地适用于不同地区的市场， 软件的全球化意味着国际化和本地化。
 * 当一个应用需要在全球范围使用时，就必须考虑在不同的地域和语言环境下的使用情况，最简单的要求就是用户界面上的信息可以用本地化语言来显示.
 *
 * 国际化是指应用程序运行时，可根据客户端请求来自的国家/地区、语言的不同而显示不同的界面。例如，如果请求来自于中文操作系统的客户端，
 * 则应用程序中的各种提示信息错误和帮助等都使用中文文字: 如果客户端使用英文操作系统， 则应用程序能自动识别，并做出英文的响应。
 *
 * 引入国际化的目的是为了提供自适应、更友好的用户界面，并不需要改变程序的逻辑功能。国际化的英文单词是Internationalization ， 因为这个单词太长了，
 * 有时也简称I18N ，其中I 是这个单词的第一个字母， 18 表示中间省略的字母个数，而N 代表这个单词的最后一个字母。
 *
 * 一个国际化支持很好的应用， 在不同的区域使用时， 会呈现出本地语言的提示。这个过程也被称为Localization ， 即本地化。类似于国际化可以称为I18N ，本地化也可以称为L10N 。
 *
 * Java 9 国际化支持升级到了Unicode 8.0 字符集，因此提供了对不同国家、不同语言的支持，它已经具有了国际化和本地化的特征及API， 因此Java 程序的国际化相对比较简单。
 * 尽管Java 开发工具为国际化和本地化的工作提供了一些基本的类， 但还是有一些对于Java 应用程序的本地化和国际化来说较困难的工作，例如: 消息获取，编码转换，显示布局和数字、日期、货币的格式等。
 *
 * Java 国际化的思路
 *
 * Java 程序的国际化思路是将程序中的标签、提示等信息放在资源文件中， 程序需要支持哪些国家、语言环境，就对应提供相应的资源文件。资源文件是key-value 对，每个资源文件中的key 是不变的，
 * 但value 则随不同的国家、语言而改变
 *
 * Java 程序的国际化主要通过如下三个类完成。
 *
 * java.util.ResourceBundle: 用于加载国家、语言资源包。
 * java.util.Locale: 用于封装特定的国家/区域、语言环境。
 * java.text.MessageFormat: 用于格式化带占位符的字符串
 *
 * 为了实现程序的国际化，必须先提供程序所需要的资源文件。资源文件的内容是很多key-value 对，其中key 是程序使用的部分，而value 则是程序界面的显示字符串。
 * 资源文件的命名可以有如下三种形式。
 *
 * baseName_language_country.properties
 * baseName_language.properties
 * baseName.properties
 *
 * 其中baseName 是资源文件的基本名， 用户可随意指定:而language 和country都不可随意变化，必须是Java 所支持的语言和国家。
 *
 * Java 支持的国家和语言
 *
 * 事实上， Java 不可能支持所有的国家和语言，如果需要获取Java 所支持的国家和语言，则可调用Locale 类的getAvailableLocalesO方法，
 * 该方法返回一个Locale 数组，该数组里包含了Java 所支持的国家和语言
 * 下面的程序简单地示范了如何获取Java 所支持的国家和语言。
 * @author JIE
 */
public class LocaleList {

    public static void main(String[] args) {
        // 返回Java 所支持的全部国家和语言的数组
        Locale[] locales = Locale.getAvailableLocales();
        // 遍历数组的每个元素，依次获取所支持的国家和语言
        for (Locale locale : locales) {
            System.out.println(locale.getDisplayCountry() + "=" + locale.getCountry() + ", " + locale.getDisplayLanguage() + "=" + locale.getLanguage());
        }

    }
}
