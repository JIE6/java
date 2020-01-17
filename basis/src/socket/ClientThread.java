package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Socket加入多线程
 * @author JIE
 */
public class ClientThread implements Runnable{

    /**
     * 该线程负责处理的Socket
     */
    private Socket s;

    /**
     * 该线程所处理的Socket 对应的输入流
     */
    BufferedReader br = null;

    public ClientThread(Socket s) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    @Override
    public void run() {
        String content = null;
        // 不断地读取Socket 输入流中的内容， 并将这些内容打印输出
        while (true) {
            try {
                if ((content = br.readLine()) != null) {
                    System.out.println(content);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
