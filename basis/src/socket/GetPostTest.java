package socket;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * URL-GET-POST
 *
 * Java 8 新增了一个URLPermission 工具类，用于管理HttpURLConnection 的权限问题，如果在HttpURLConnection 安装了安全管理器，
 * 通过该对象打开连接时就需要先获得权限。
 *
 * 通常创建一个和URL 的连接，井发送请求、读取此URL 引用的资源需要如下几个步骤。
 * 1.通过调用URL 对象的openConnection()方法来创建URLConnection 对象。
 * 2.设置URLConnection 的参数和普通请求属性。
 * 3.如果只是发送GET 方式请求，则使用connect()方法建立和远程资源之间的实际连接即可;如果需要发送POST 方式的请求，则需要获取URLConnection 实例对应的输出流来发送请求参数。
 * 4.远程资源变为可用， 程序可以访问远程资源的头字段或通过输入流读取远程资源的数据。
 *
 * 在建立和远程资源的实际连接之前， 程序可以通过如下方法来设置请求头宇段。
 * setAllowUserInteraction() : 设置该URLConnection 的allowUserInteraction 请求头字段的值。
 * setDoInput(): 设置该URLConnection 的doInput 请求头宇段的值。
 * setDoOutput(): 设置该URLConnection 的doOutput 请求头字段的值。
 * setIfModifiedSince(): 设置该URLConnection 的ifModifiedSince 请求头宇段的值。
 * setUseCaches(): 设置该URLConnection 的useCaches 请求头宇段的值。
 * 除此之外，还可以使用如下方法来设置或增加通用头宇段。
 * setRequestProperty(String key, String value): 设置该URLConnection 的key 请求头字段的值为value 。如下代码所示:
 * conn.setRequestProperty ("accept" , "*")
 * addRequestProperty(String key, String value): 为该URLConnection 的key 请求头宇段增加value值，该方法并不会覆盖原请求头宇段的值，而是将新值追加到原请求头字段中。
 *
 * 当远程资源可用之后， 程序可以使用以下方法来访问头字段和内容。
 * Object getContent(): 获取该URLConnection 的内容。
 * String getHeaderField(String name): 获取指定响应头宇段的值。
 * getInputStream(): 返回该URLConnection 对应的输入流，用于获取URLConnection 响应的内容。
 * getOutputStream(): 返回该URLConnection 对应的输出流，用于向URLConnection 发送请求参数。
 * getHeaderField(): 方法用于根据响应头字段来返回对应的值。而某些头宇段由于经常需要访问，所以Java 提供了以下方法来访问特定响应头字段的值。
 * getContentEncoding(): 获取content-encoding 响应头宇段的值。
 * getContentLength(): 获取content-length 响应头宇段的值。
 * getContentType(): 获取content-type 响应头宇段的值。
 * getDate(): 获取date 响应头宇段的值。
 * getExpiration(): 获取expires 响应头宇段的值。
 * getLastModified(): 获取last-modified 响应头宇段的值。
 *
 * 如果既要使用输入流读取URLConnection 响应的内容，又要使用输出流友送请求参数，则一定要先使用输出流，再使用输入流。
 *
 * 下面程序示范了如何向Web 站点发送GET 请求、POST 请求，并从Web 站点取得响应.
 * @author JIE
 */
public class GetPostTest {

    /**
     * 向指定URL 发送GET 方式的请求
     * @param url 发送请求的URL
     * @param param 请求参数，格式满足name1=value1&name2=value2 的形式
     * @return URL 代表远程资源的响应
     */
    public static String sendGet(String url, String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            // 打开和URL 之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent"
                    , "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            // 建立实际的连接
            conn.connect();
            // 获取所有响应头字段
            Map<String, List<String>> headerFields = conn.getHeaderFields();
            // 遍历所有的响应头字段
            headerFields.forEach((key, value) -> System.out.println(key + "--->" + value));
            // 定义BufferedReader输入流来读取URL的响应
            InputStream inputStream = conn.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += "\n" + line;
            }
        }catch (Exception e) {
            System.out.println("发送GET请求异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 向指定URL发送POST方法的请求
     * @param url 发送请求的URL
     * @param param 请求参数，格式应该满足name1=value1&name2=value2的形式。
     * @return URL所代表远程资源的响应
     */
    public static String sendPost(String url, String param) {
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");

            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);

            // 获取URLConnection对象对应的输出流
            OutputStream outputStream = conn.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            // 发送请求参数
            printWriter.print(param);
            // flush输出流的缓冲
            printWriter.flush();

            // 定义BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream() , "utf-8"));
            String line;
            while ((line = in.readLine())!= null) {
                result += "\n" + line;
            }
        }catch (Exception e) {
            System.out.println("发送POST请求异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(sendGet("http://www.baidu.com", ""));
    }

}
