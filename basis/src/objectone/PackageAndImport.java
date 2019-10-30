/**
 * 包名
 * Java 允许将一组功能相关的类放在同一个package 下，从而组成逻辑上的类库单元。
 * 如果希望把一个类放在指定的包结构下，应该在Java 源程序的第一个非注释行放置如下格式的代码:
 */
package objectone;
/**
 * 一旦在Java 源文件中使用了这个package 语句，就意味着该源文件里定义的所有类都属于这个包。
 * 位于包中的每个类的完整类名都应该是包名和类名的组合， 如果其他人需要使用该包下的类，也应该使用包名加类名的组合。
 */

/**
 * package、import、和import static
 *
 *----------------------------------------------------------------------------------------------------------------------
 * 把生成的class 文件放在某个目录下，这个目录名就成了这个类的包名。这是一个错误的看法.
 * 不是有了目录结构，就等于有了包名。为Java 类添加包必须在Java 源文件中通过package 语句指定，
 * 单靠目录名是没法指定的。Java 的包机制需要两个方面保证:
 * 1.源文件里使用package 语句指定包名;
 * 2.class 文件必须放在对应的路径下
 *----------------------------------------------------------------------------------------------------------------------
 *
 * @author JIE
 */

import processcontrol.ArrayType;
import processcontrol.ArrayType8Arrays;
/**
 *  * Java 默认为所有源文件导入java.lang 包下的所有类
 *  因此前面在Java 程序中使用;String 、System 类时都无须使用import 语句来导入这些类
 *
 * 使用import 语句导入指定包下全部类的用法如下:*
 */
import processcontrol.*;

/**
 * JDK 1. 5 以后更是增加了一种静态导入的语法， 它用于导入指定类的某个静态成员变量、方法或全部的静态成员变量、方法
 * 静态导入使用import static 语句， 静态导入也有两种语法，分别用于导入指定类的单个静态成员变量、方法和全部静态成员变量、方法，
 * 其中导入指定类的单个静态成员变量、方法的语法格式如下:
 * import static package . subpackage.. .ClassName.fieldName|methodName ;
 * 上面语法导入package.subpackage...ClassName 类中名为fieldName 的静态成员变量或者名为methodName 的静态方法
 * 例如，可以使用import static java.lang.System.*;语句来导入java.lang.System类的out 静态成员变量。
 * 导入指定类的全部静态成员变量、方法的语法格式如下:
 * import static package.subpackage...ClassName.*;
 */
import static java.lang.System.*;
//import static java.lang.System.out;

/**
 * import 和import static 的功能非常相似，只是它们导入的对象不一样而己。
 * import 语句和import static 语句都是用于减少程序中代码编写量的。
 *
 */
public class PackageAndImport {

    public static void main(String[] args) {
        // 直接访问相同包下的另一个类， 无须使用包前缀
        ClassUse classUse = new ClassUse();
        // PackageAndImport和AutoConversion不再处于同一个包下,因此使用AutoConversion 类时就需要使用该类的全名( 即包名加类名)
        basictype.AutoConversion autoConversion = new basictype.AutoConversion();
        // 正如上面看到的， 如果需要使用不同包中的其他类时， 总是需要使用该类的全名， 这是一件很烦琐的事情。
        /**
         * 为了简化编程， Java 引入了import 关键字， import 可以向某个Java 文件中导入指定包层次下某个类或全部类，
         * import 语句应该出现在package 语句(如果有的话) 之后、类定义之前。一个Java 源文件只能包含一个package 语句，
         * 但可以包含多个import 语句， 多个import 语句用于导入多个包层次下的类。
         */
        ArrayType arrayType = new ArrayType();
        ArrayType8Arrays arrayType8Arrays = new ArrayType8Arrays();
        Board board = new Board();
        out.println("java.lang.System.out");

    }
}
