package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 * Socket加入多线程
 * @author JIE
 */
public class ServerThread implements Runnable{

    /**
     * 定义当前线程所处理的Socket
     */
    Socket s = null;
    /**
     * 该线程所处理的Socket 对应的输入流
     */
    BufferedReader br = null;

    public ServerThread(Socket s) throws IOException {
        this.s = s;
        // 初始化该Socket 对应的输入流
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {

        String content = null;
        // 采用循环不断地从Socket 中读取客户端发送过来的数据
        while ((content = readFromClient()) != null) {
            // 遍历socketList 中的每个Socket, 将读到的内容向每个Socket 发送一次
            try {
                for (Socket s : MyServer.socketList) {
                    PrintStream ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 定义读取客户端数据的方法
     */
    private String readFromClient() {
        try {
            return br.readLine();
            // 如果捕获到异常，则表明该Socket 对应的客户端己经关闭
        } catch (IOException e) {
            MyServer.socketList.remove(s);
        }
        return null;
    }

    /**
     *
     */
}
