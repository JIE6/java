package socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ServerSocket + Socket 网络通信程序
 * @author JIE
 */
public class Server {

    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket . 用于监昕客户端Socket 的连接请求
        ServerSocket serverSocket = new ServerSocket(30000);
        // 采用循环不断地接收来自客户端的请求
        while (true) {
            // 每当接收到客户端Socket 的请求时，服务器端也对应产生一个Socket
            Socket socket = serverSocket.accept();
            // 将Socket 对应的输出流包装成PrintStream
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            // 进行普通 IO 操作
            printStream.println("您好，您收到了服务器的新年祝福!");
            // 关闭输出流， 关闭Socket
            printStream.close();
            socket.close();

        }
    }
}
