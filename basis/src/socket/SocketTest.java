package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 使用Socket 进行通信
 *
 * 客户端通常可以使用Socket 的构造器来连接到指定服务器， Socket 通常可以使用如下两个构造器。
 *
 * Socket(InetAddress/String remoteAddress, int port): 创建连接到指定远程主机、远程端口的Socket ，
 * 该构造器没有指定本地地址、本地端口， 默认使用本地主机的默认E 地址，默认使用系统动态分配的端口。
 *
 * Socket(InetAddress/String remoteAddress, int port， InetAddress localAddr, int localPort): 创建连接到指定远程主机、远程端口的Socket ，
 * 并指定本地 IP 地址和本地端口，适用于本地主机有多个 IP地址的情形。
 *
 * 上面两个构造器中指定远程主机时既可使用InetAddress 来指定，也可直接使用String 对象来指定，但程序通常使用String 对象(如192.168.2.23 )来指定远程 IP 地址。
 * 当本地主机只有一个 IP 地址时，使用第一个方法更为简单。
 *
 * 如下代码所示。
 * @author JIE
 */
public class SocketTest {

    public static void main(String[] args) throws IOException {
        // 创建连接到本机、30000 端口的Socket
        Socket socket = new Socket("127.0.0.1", 30000);
        // 下面就可以使用Socket 进行通信了
        // ......
    }
    /**
     * 当程序执行上面代码时， 该代码将会连接到指定服务器，让服务器端的ServerSocket的accept()方法向下执行，于是服务器端和客户端就产生一对互相连接的Socket 。
     *
     * 当客户端、服务器端产生了对应的Socket 之后，程序无须再区分服务器端、客户端，而是通过各自的Socket 进行通信。Socket 提供了如下两个方法来获取输入流和输出流。
     *
     * InputStream getInputStream(): 返回该Socket 对象对应的输入流，让程序通过该输入流从Socket中取出数据。
     * OutputStream getOutputStream(): 返回该Socket 对象对应的输出流，让程序通过该输出流向Socket中输出数据.
     *
     * 看到这两个方法返回的InputStream 和OutputStream ， 则应该可以明白Java 在设计 IP 体系上的苦心了， 不管底层的 IO 流是怎样的节点流: 文件流也好，网络Socket 产生的流也好，
     * 程序都可以将其包装成处理流，从而提供更多方便的处理。 (ServerSocketTest2, SocketTest2)以一个最简单的网络通信程序为例来介绍基于TCP 协议的网络通信。
     */
}
