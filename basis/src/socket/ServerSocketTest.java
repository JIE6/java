package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 使用ServerSocket 创建TCP 服务器端
 *
 * Java 中能接收其他通信实体连接请求的类是ServerSocket ， ServerSocket 对象用于监听来自客户端的Socket 连接，如果没有连接，
 * 它将一直处于等待状态。ServerSocket 包含一个监昕来自客户端连接请求的方法。
 *
 * Socket accept(): 如果接收到一个客户端Socket 的连接请求，该方法将返回一个与客户端Socket对应的Socket否则该方法将一直处于等待状态，线程也被阻塞。
 *
 * 为了创建ServerSocket 对象， ServerSocket 类提供了如下几个构造器。
 * ServerSocket(int port): 用指定的端口port 来创建一个ServerSocket 。该端口应该有一个有效的端口整数值， 即0-65535.
 * ServerSocket(int port,int backlog): 增加一个用来改变连接队列长度的参数backlog 。
 * ServerSocket(int port, int backlog, InetAddress localAddr): 在机器存在多个 IP 地址的情况下，允许通过localAddr 参数来指定将ServerSocket 绑定到指定的IP地址。
 *
 * 当ServerSocket 使用完毕后，应使用ServerSocket 的close()方法来关闭该ServerSocket 。在通常情况下，服务器不应该只接收一个客户端请求，而应该不断地接收来自客户端的所有请求，
 * 所以Java 程序通常会通过循环不断地调用ServerSocket 的accept()方法。
 *
 * 如下代码片段所示。
 * @author JIE
 */
public class ServerSocketTest {

    public static void main(String[] args) throws IOException {
        // 创建一个ServerSocket . 用于监昕客户端Socket 的连接请求
        ServerSocket serverSocket = new ServerSocket(30000);
        // 采用循环不断地接收来自客户端的请求
        while (true) {
            // 每当接收到客户端Socket 的请求时，服务器端也对应产生一个Socket
            Socket socket = serverSocket.accept();
            // 下面就可以使用Socket 进行通信了
            // .......
        }
        /**
         * 上面程序中创建ServerSocket 没有指定IP 地址，则该ServerSocket 将会绑定到本机默认的IP 地址。
         * 程序中使用30000 作为该ServerSocket 的端口号，通常推荐使用1024 以上的端口，
         * 主要是为了避免与其他应用程序的通用端口冲突。
         */
    }
}
