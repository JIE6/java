package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * ServerSocket + Socket 网络通信程序
 * @author JIE
 */
public class Client {

    public static void main(String[] args) throws IOException {
        // 创建连接到本机、30000 端口的Socket
        Socket socket = new Socket("127.0.0.1", 30000);
        // 在实际应用中，程序可能不想让执行网络连接、读取服务器数据的进程一直阻塞， 而是希望当网络连接、读取操作超过合理时间之后，
        // 系统自动认为该操作失败, 这个合理时间就是超时时长. Socket对象提供了一个setSoTimeout(int timeout)方法来设置超时时长。
        // 设置10 秒之后即认为超时
        socket.setSoTimeout(10000);

        // 将Socket 对应的输入流包装成BufferedReader
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 进行普通 IO 操作
        String line = bufferedReader.readLine();
        System.out.println("来自服务器的数据: "+ line);
        // 关闭输入流， 关闭Socket
        bufferedReader.close();
        socket.close();


        String host = "127.0.0.1";
        int port = 30000;
        // 创建一个无连接的Socket
        Socket s = new Socket();
        // 让该Socket 连接到远程服务器，如果经过10 秒还没有连接上，则认为连接超时
        s.connect(new InetSocketAddress(host , port) , 10000);
    }

}
