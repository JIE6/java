package library;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Java 9 新增的日志API
 *
 * Java 9 强化了原有的日志API.这套日志API 只是定义了记录消息的最小API.开发者可将这些日志消息路由到各种主流的日志框架(如SLF4J 、Log4J 等) ，
 * 否则默认使用Java 传统的java.util.logging日在、API 。
 *
 * 这套日志API 的用法非常简单，只要两步即可。
 * 1.调用System 类的getLogger(String name)方法获取System.Logger 对象
 * 2.调用System.Logger 对象的log()方法输出日志。该方法的第一个参数用于指定日志级别。
 *
 * 为了与传统java.util.logging 日志级别、主流日志框架的级别兼容， Java 9 定义了如 下表 所示的日志级别。
 * ------------------------------------------------------------------------------------------------------------------------------------
 * java9的日志级别                       传统日志级别                          说明
 * ------------------------------------------------------------------------------------------------------------------------------------
 * ALL                                  ALL                     最低级别， 系统将会输出所有日志信息。因此将会生成非常多、非常冗余的日志信息
 * TRACE                                FINER                   输出系统的各种跟踪信息. 也会生成很多、很冗余的日志信息
 * DEBUG                                FINE                    输出系统的各种调试信息，会生成较多的日志信息
 * INFO                                 INFO                    输出系统内需要提示用户的提示信息， 生成中等冗余的日志信息
 * WARNING                              WARNING                 只输出系统内警告用户的警告信息， 生成较少的日志信息
 * ERROR                                SEVERE                  只输出系统发生错误的错误信息， 生成很少的日志信息
 * OFF                                  OFF                     关闭日志输出
 * ------------------------------------------------------------------------------------------------------------------------------------
 * 该日志级别是一个非常有用的东西: 在开发阶段调试程序时，可能需要大量输出调试信息: 在发布软件时，又希望关掉这些调试信息。此时就可通过日志来实现，只要将系统日志级别调高，
 * 所有低于该级别的日志信息就都会被自动关闭，如果将日志级别设为OFF ，那么所有日志信息都会被关闭。
 *
 * 例如，如下程序示范了Java 9 新增的日志API 。
 * @author JIE
 */
public class LoggerTest {
    public static final String LOGGER_NAME = "LoggerTest";
    /**
     * 获取System.Logger 对象
     */
    private static final System.Logger LOGGER = System.getLogger(LOGGER_NAME);

    static {
        // 设置系统日志级别(FINE 对应 DEBUG)
        Logger.getLogger(LOGGER_NAME).setLevel(Level.FINE);
        // 设直使用logTest.xml 保存日志记录
        try {
            Logger.getLogger(LOGGER_NAME).addHandler(new FileHandler("logTest.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LOGGER.log(System.Logger.Level.DEBUG, "DEBUG, ......");
        LOGGER.log(System.Logger.Level.INFO, "INFO, ......");
        LOGGER.log(System.Logger.Level.ERROR, "ERROR, ......");
    }

    /**
     * 上面程序中第一行代码获取Java 9 提供的日志API.由于此处并未使用第三方日志框架，因此系统默认使用java.util.logging 日志作为实现，
     * 因此第二行代码使用java.util.logging.Logger 来设置日志级别。程序将系统日志级别设为(FINE 等同于DEBUG) ，
     * 这意味着高于或等于DEBUG 级别的日志信息都会被输出到logTest.xml文件。运行上面程序，将可以看到在项目根目录下生成了一个logTest.xml 文件，
     * 该文件中包含三条日志记录，分别对应于上面三行代码调用log()方法输出的日志记录。
     */
}
