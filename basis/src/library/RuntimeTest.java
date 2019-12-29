package library;

import java.io.IOException;

/**
 * Runtime 类与Java 9 的ProcessHandle
 *
 * Runtime 类代表Java 程序的运行时环境，每个Java 程序都有一个与之对应的Runtime 实例，
 * 应用程序通过该对象与其运行时环境相连。应用程序不能创建自己的Runtime 实例，但可以通过getRuntime()
 * 方法获取与之关联的Runtime 对象。
 *
 * 与System 类似的是， Runtime 类也提供了gc()方法和runFinalization()方法来通知系统进行垃圾回收、
 * 清理系统资源，并提供了load(String filename)和loadLibrary(String libname)方法来加载文件和动态链接库。
 *
 * Runtime 类代表Java 程序的运行时环境，可以访问JVM 的相关信息，如处理器数量、内存信息等。如下程序所示。
 * @author JIE
 */
public class RuntimeTest {

    public static void main(String[] args) throws IOException {
        // 获取Java 程序关联的运行时对象
        Runtime runtime = Runtime.getRuntime();
        System.out.println("处理器数量:" + runtime.availableProcessors());
        System.out.println("空闲内存数:" + runtime.freeMemory());
        System.out.println("总内存数:" + runtime.totalMemory());
        System.out.println("可用最大内存数:" + runtime.maxMemory());
        /**
         * 除此之外， Runtime 类还有一个功能它可以直接单独启动一个进程来运行操作系统的命令，如下程序所示。
         * 运行记事本程序
         */
        runtime.exec("notepad.exe");

        /**
         * 通过exec 启动平台上的命令之后，它就变成了一个进程， Java 使用Process 来代表进程。
         * Java 9 还新增了一个ProcessHandle 接口，通过该接口可获取进程的ID 、父进程和后代进程;
         * 通过该接口的onExit()方法可在进程结束时完成某些行为。
         */
    }
}
