package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * Socket加入多线程
 *
 * 每个客户端应该包含两个线程， 一个负责读取用户的键盘输入， 并将用户输入的数据写入Socket对应的输出流中: 一个负责读取Socket 对应输入流中的数据(从服务器端发送过来的数据) ，
 * 并将这些数据打印输出。其中负责读取用户键盘输入的线程由MyClient 负责，也就是由程序的主线程负责。
 *
 * 客户端主程序代码如下
 * @author JIE
 */
public class MyClient {

    public static void main(String[] args) throws IOException {
        Socket s = new Socket("127.0.0.1", 30000);
    }
}
