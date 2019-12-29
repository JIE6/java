package library;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 使用Scanner 获取键盘输入
 * @author JIE
 *
 * 运行Java 程序时传入参数只能在程序开始运行之前就设定几个固定的参数。对于更复杂的情形，
 * 程序需要在运行过程中取得输入，例如，前面介绍的五子棋游戏、梭哈游戏都需要在程序运行过程中获得用户的键盘输入。
 *
 * 使用Scanner 类可以很方便地获取用户的键盘输入， Scanner 是一个基于正则表达式的文本扫描器，
 * 它可以从文件、输入流、宇符串中解析出基本类型值和字符串值。Scanner 类提供了多个构造器，不同
 * 的构造器可以接收文件、输入流、字符串作为数据源，用于从文件、输入流、字符串中解析数据。
 *
 * Scanner 主要提供了两个方法来扫描输入。
 * hasNextXxx(): 是否还有下一个输入项， 其中Xxx 可以是Int 、Long 等代表基本数据类型的字符串。如果只是判断是否包含下一个字符串，则直接使用hasNext() 。
 * nextXxx(): 获取下一个输入项。Xxx 的含义与前一个方法中的Xxx 相同。
 *
 * 在默认情况下， Scanner 使用空白(包括空格、Tab 空白、回车)作为多个输入项之间的分隔符。
 *
 * 下面程序使用Scanner 来获得用户的键盘输入。
 */
public class ScannerKeyBoardTest {

    public static void main(String[] args) throws FileNotFoundException {
//        // System.in 代表标准输入，就是键盘输入
//        Scanner scanner = new Scanner(System.in);
//        // 增加下面一行将只把回车作为分隔符
//        scanner.useDelimiter("\n");
//        // 判断是否还有下一个输入项
//        while(scanner.hasNext()) {
//            // 输出输入项
//            System.out.println("键盘输入的内容是:" + scanner.next());
//        }

        /**
         * 运行上面程序，程序通过Scanner 不断从键盘读取键盘输入，每次读到键盘输入后，直接将输入内容打印在控制台。
         *
         * 如果希望改变Scanner 的分隔符(不使用空白作为分隔符) ，例如， 程序需要每次读取一行，不管这一行中是否包含空格，
         * Scanner 都把它当成一个输入项。在这种需求下，可以把Scanner 的分隔符设置为回车符，不再使用默认的空白作为分隔符。
         *
         * Scanner 的读取操作可能被阻塞(当前执行顺序流暂停)来等待信息的输入。如果输入源没有结束，Scanner 又读不到更多输入项时(尤其在键盘输入时比较常见) ，
         * Scanner 的hasNext()和next()方法都有可能阻塞， hasNext()方法是否阻塞与和其相关的next()方法是否阻塞无关。
         *
         * 为Scanner 设置分隔符使用useDelimiter(String pattern)方法即可， 该方法的参数应该是一个正则表达式
         *
         * 事实上， Scanner 提供了两个简单的方法来逐行读取。
         * boolean hasNextLine(): 返回输入源中是否还有下一行。
         * String nextLine(): 返回输入源中下一行的字符串。
         *
         * Scanner 不仅可以获取字符串输入项，也可以获取任何基本类型的输入项，如下程序所示。
         */
//        Scanner sn = new Scanner(System.in);
//        // 判断是否还有下一个long 型整数
//        while (sn.hasNextLong()) {
//            System.out.println(sn.nextLong());
//        }

        /**
         * 上面程序中通过hasNextLong()和nextLong()两个方法， Scanner 可以直接从输入流中获得long 型整数输入项。
         * 与此类似的是，如果需要获取其他基本类型的输入项，则可以使用相应的方法。
         */

        /**
         * Scanner 不仅能读取用户的键盘输入，还可以读取文件输入。只要在创建Scanner 对象时传入一个File 对象作为参数，
         * 就可以让Scanner 读取该文件的内容。例如如下程序。
         */

        // 将一个File 对象作为Scanner 的构造器参数， Scanner 读取文件内容
        Scanner snf = new Scanner(new File("A:\\Projects\\java\\basis\\src\\library\\ScannerKeyBoardTest.java"));
        System.out.println("ScannerFileTest.java 文件内容如下: ");
        // 判断是否还有下一行
        while (snf.hasNextLine()) {
            // 输出文件中的下一行
            System.out.println(snf.nextLine());
        }
    }
}
