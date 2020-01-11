package socket;

/**
 * 多线程下载工具
 * @author JIE
 */
public class MultiThreadDown {

    public static void main(String[] args) throws Exception {
        // 初始化DownUtil 对象
        DownUtil downUtil = new DownUtil(
                "http://downsc.chinaz.net/Files/DownLoad/pic9/202001/hpic1944.rar",
                "download.rar",
                5);
        // 开始下载
        downUtil.download();
        new Thread(() -> {
            while (downUtil.getCompleteRate() < 1) {
                // 每隔1 秒查询一次任务的完成进度
                System.out.println("已完成：" + downUtil.getCompleteRate());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    /**
     * 运行上面程序，即可看到程序从 http://downsc.chinaz.net/Files/DownLoad/pic9/202001/hpic1944.rar 下载得到一份名为 download.rar 的资源文件。
     *
     * DownUtil 还用到URLConnection 和HttpURLConnection 对象，其中前者表示应用程序和URL 之间的通信连接，后者表示与URL 之间的HTTP 连接。
     * 程序可以通过URLConnection 实例向该 URL 发送请求、读取URL 引用的资源。
     */
}
