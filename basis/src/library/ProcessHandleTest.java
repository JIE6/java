package library;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * Runtime 类与Java 9 的ProcessHandle
 *
 * ProcessHandle 还提供了一个ProcessHandle.Info 类，用于获取进程的命令、参数、启动时间、累计运行时间、用户等信息
 * @author JIE
 */
public class ProcessHandleTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime rt = Runtime.getRuntime();
        Process notepad = rt.exec("notepad.exe");
        ProcessHandle processHandle = notepad.toHandle();
        System.out.println("进程是否运行: " + processHandle.isAlive());
        System.out.println("进程ID: " + processHandle.pid());
        System.out.println("父进程: " + processHandle.parent());
        // 获取ProcessHandle.info 信息
        ProcessHandle.Info info = processHandle.info();
        // 通过ProcessHandle.info 信息获取进程相关信息
        System.out.println("进程命令:" + info.command());
        System.out.println("进程参数:" + info.arguments());
        System.out.println("进程启动时间:" + info.startInstant());
        System.out.println("进程累计运行时间:" + info.totalCpuDuration());
        // 通过CompletableFuture 在进程结束时运行某个任务
        CompletableFuture<ProcessHandle> CompletableFuture = processHandle.onExit();
        CompletableFuture.thenRunAsync(() -> System.out.println("程序退出"));
        Thread.sleep(3000);
    }
}
