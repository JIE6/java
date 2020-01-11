package socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 使用InetAddress
 *
 * Java 提供了InetAddress 类来代表IP 地址， InetAddress 下还有两个子类: Inet4Address 、Inet6Address ，
 * 它们分别代表Internet Protocol version 4 ( IPv4) 地址和Internet Protocol version 6 ( IPv6) 地址。
 *
 * InetAddress 类没有提供构造器，而是提供了如下两个静态方法来获取InetAddress 实例。
 * getByName(String host): 根据主机获取对应的InetAddress 对象。
 * getByAddress(byte[] addr): 根据原始IP 地址来获取对应的InetAddress 对象。
 *
 * InetAddress 还提供了如下三个方法来获取InetAddress 实例对应的IP 地址和主机名。
 * String getCanonicalHostName(): 获取此IP 地址的全限定域名。
 * String getHostAddress(): 返回该InetAddress 实例对应的IP 地址字符串(以字符串形式) 。
 * String getHostName(): 获取此E 地址的主机名。
 *
 * 除此之外， InetAddress 类还提供了一个getLocalHost()方法来获取本机IP 地址对应的InetAddress实例。
 *
 * InetAddress 类还提供了一个isReachable()方法，用于测试是否可以到达该地址。该方法将尽最大努力试图到达主机，
 * 但防火墙和服务器配置可能阻塞请求，使得它在访问某些特定的端口时处于不可达状态。如果可以获得权限，
 * 典型的实现将使用ICMP ECHO REQUEST; 否则它将试图在目标主机的端口 7 (Echo ) 上建立TCP 连接。
 *
 * 下面程序测试了InetAddress 类的简单用法。
 * @author JIE
 */
public class InetAddressTest {

    public static void main(String[] args) throws IOException {
        // 根据主机名来获取对应的InetAddress 实例
        InetAddress ip = InetAddress.getByName("www.crazyit.org");
        // 判断是否可达
        System.out.println("crazyit 是否可达：" + ip.isReachable(2000));
        // 获取该InetAddress 实例的IP 字符串
        System.out.println(ip.getHostAddress());
        // 根据原始IP 地址来获取对应的InetAddress 实例
        InetAddress local = InetAddress.getByAddress(new byte[]{127, 0, 0, 1});
        System.out.println("local 是否可达：" + local);
        // 获取该InetAddress 实例对应的全限定域名
        System.out.println(local.getCanonicalHostName());
    }
    /**
     * 上面程序简单地示范了InetAddress 类的几个方法的用法， InetAddress 类本身并没有提供太多功能，
     * 它代表一个 IP 地址对象，是网络通信的基础，在后面介绍中将大量使用该类。
     */
}
