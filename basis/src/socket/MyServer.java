package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Socket加入多线程
 *
 * 前面Server 和Client 只是进行了简单的通信操作: 服务器端接收到客户端连接之后，服务器端向客户端输出一个字符串，
 * 而客户端也只是读取服务器端的字符串后就退出了。实际应用中的客户端则可能需要和服务器端保持长时间通信，即服务器端需要不断地读取客户端数据，
 * 并向客户端写入数据; 客户端也需要不断地读取服务器端数据，并向服务器端写入数据。
 *
 * 在使用传统BufferedReader 的readLine()方法读取数据时， 在该方法成功返回之前，线程被阻塞，程序无法继续执行。考虑到这个原因，服务器端应该为每个Socket 单独启动一个线程，
 * 每个线程负责与一个客户端进行通信。
 *
 * 客户端读取服务器端数据的线程同样会被阻塞，所以系统应该单独启动一个线程，该线程专门负责读取服务器端数据。
 *
 * 现在考虑实现一个命令行界面的C/S 聊天室应用，服务器端应该包含多个线程，每个Socket 对应一个线程，该线程负责读取Socket 对应输入流的数据(从客户端发送过来的数据) ，
 * 并将读到的数据向每个Socket 输出流发送一次(将一个客户端发送的数据"广播"给其他客户端) ，因此需要在服务器端使用List 来保存所有的Socket 。
 *
 * 下面是服务器端的实现代码，程序为服务器端提供了两个类，一个是创建ServerSocket 监昕的主类，一个是负责处理每个Socket 通信的线程类。
 *
 * @author JIE
 */
public class MyServer {
    /**
     * 定义保存所有Socket 的ArrayList. 并将其包装为线程安全的
     */
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(30000);
        while (true) {
            // 此行代码会阻塞，将一直等待别人的连续
            Socket s = ss.accept();
            socketList.add(s);
            // 每当客户端连接后启动一个ServerThread 线程为该客户端服务
            new Thread(new ServerThread(s)).start();
        }
    }
    /**
     * 上面程序实现了服务器端只负责接收客户端Socket 的连接请求， 每当客户端Socket 连接到该ServerSocket 之后，
     * 程序将对应Socket 加入socketList 集合中保存， 井为该Socket 启动一个线程， 该线程负责处理该Socket 所有的通信任务，
     * 服务器端线程类的代码 ServerThread
     */
}
