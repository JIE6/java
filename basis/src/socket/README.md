# 网络编程
<pre>
    本章将主要介绍Java 网络通信的支持，通过这些网络支持类， Java 程序可以非常方便地访问互联网上的HTTP 服务、FTP 服务等，
并可以直接取得互联网上的远程资源，还可以向远程资源发送GET 、POST 请求。
    本章先简要介绍计算机网络的基础知识，包括 IP 地址和端口等概念，这些知识是网络编程的基础。
    本章会详细介绍InetAddress 、URLDecoder 、URLEncoder 、URL 和URLConnection 等网络工具类，并会深入介绍通过URLConnection 发送请求、访问远程资源等操作。
    本章将重点介绍Java 提供的TCP 网络通信支持，包括如何利用ServerSocket 建立TCP 服务器，利用Socket 建立TCP 客户端。
实际上Java 的网络通信非常简单，服务器端通过ServerSocket 建立监听，客户端通过Socket 连接到指定服务器后，通信双方就可以通过 IO 流进行通信。
本章将以采用逐步迭代的方式开发一个C/S 结构多人网络聊天工具为例，介绍基于TCP 协议的网络编程。
    本章还将重点介绍Java 提供的UDP 网络通信支持，主要介绍如何使用DatagramSocket 来发送、接收数据报( DatagrarnPacket ) ，并讲解如何使用MulticastSocket 来实现多点广播通信。
本章也将以开发局域网通信程序为例来介绍MulticastSocket 和DatagramSocket 的实际用法。
    本章最后还会介绍利用Proxy 和ProxySelector 在Java 程序中通过代理服务器访问远程资源。
</pre>

## 当前包下需重点掌握的知识点
| 位置 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| 当前位置下第21行 | 5 | 网络编程的基础知识 |
| 当前位置下第75行 | 5 | IP地址和端口号 |
| 当前位置下第101行 | 5 | Java的基本网络支持 |
| InetAddressTest | 5 | 使用InetAddress |
| URLDecoderTest | 5 | 使用URLDecoder 和URLEncoder |
| 当前位置下第111行 | 5 | URL |
| DownUtil,MultiThreadDown | 5 | 多线程下载工具 |
| GetPostTest | 5 | URL-GET-POST |
| 当前位置下第139行 | 5 | 基于TCP 协议的网络编程 |
| ServerSocketTest | 5 | 使用ServerSocket 创建TCP 服务器端 |
| SocketTest | 5 | 使用Socket 进行通信 |
| Server,Client | 5 | ServerSocket + Socket 网络通信程序 |
| MyServer,ServerThread,MyClient,ClientThread | 5 | Socket加入多线程 |


### 网络编程的基础知识
<pre>
    时至今日，计算机网络缩短了人们之间的距离，把"地球村"变成现实，网络应用己经成为计算机领域最广泛的应用。
    网络基础知识
    所谓计算机网络，就是把分布在不同地理区域的计算机与专门的外部设备用通信线路互连成一个规模大、功能强的网络系统，从而使众多的计算机可以方便地互相传递信息，
共享硬件、软件、数据信息等资源。
    计算机网络是现代通信技术与计算机技术相结合的产物，计算机网络可以提供以下一些主要功能。
    资源共享。
    信息传输与集中处理。
    均衡负荷与分布处理。
    综合信息服务。
    通过计算机网络可以向全社会提供各种经济信息、科研情报和咨询服务。其中，国际互联网Internet上的全球信息网(WWW, World Wide Web)服务就是一个最典型也是最成功的例子。
实际上，今天的网络承载绝大部分大型企业的运转， 一个大型的、全球性的企业或组织的日常工作流程都是建立在互联网基础之上的。
    计算机网络的品种很多，根据各种不同的分类原则，可以得到各种不同类型的计算机网络。
    计算机网络通常是按照规模大小和延伸范围来分类的， 常见的划分为: 局域网(LAN) 、城域网( MAN ) 、广域网(WAN). Internet 可以视为世界上最大的广域网。
    如果按照网络的拓扑结构来划分，可以分为星型网络、总线型网络、环型网络、树型网络、星型环型网络等
    如果按照网络的传输介质来划分，可以分为双绞线网、同轴电缆网、光纤网和卫星网等。
    计算机网络中实现通信必须有一些约定，这些约定被称为通信协议。通信协议负责对传输速率、传输代码、代码结构、传输控制步骤、出错控制等制定处理标准。
为了让两个节点之间能进行对话，必须在它们之间建立通信工具，使彼此之间能进行信息交换。
    通信协议通常由三部分组成: 一是语义部分，用于决定双方对话的类型; 二是语法部分，用于决定双方对话的格式; 三是变换规则，用于决定通信双方的应答关系。
    国际标准化组织ISO 于1978 年提出"开放系统互连参考模型" ，即著名的OSI ( Open System Interconnection )。
    开放系统互连参考模型力求将网络简化， 并以模块化的方式来设计网络。
    开放系统互连参考模型把计算机网络分成物理层、数据链路层、网络层、传输层、会话层、表示层、应用层七层，受到计算机界和通信业的极大关注。通过十多年的发展和推进， 
OSI 模式己成为各种计算机网络结构的参考标准。
    下面显示了OSI 参考模型的推荐分层。
---------------------------------------------------------------------------------------------------------------------------------------------------------
    应用层
    表示层
    会话层
    传输层
    网络层
    数据链路层
    物理层
---------------------------------------------------------------------------------------------------------------------------------------------------------
    前面介绍过通信协议是网络通信的基础， IP 协议则是一种非常重要的通信协议。IP ( Internet Protocol )协议又称互联网协议， 是支持网间互联的数据报协议。
它提供网问连接的完善功能，包括 IP 数据报规定互联网络范围内的地址格式。
    经常与IP 协议放在一起的还有TCP ( Transmission Control Protocol) 协议，即传输控制协议，它规定一种可靠的数据信息传递服务。虽然IP 和TCP 这两个协议功能不尽相同，
也可以分开单独使用，但它们是在同一个时期作为一个协议来设计的，并且在功能上也是互补的。因此实际使用中常常把这两个协议统称为TCP/IP 协议， TCP/IP 协议最早出现在UNIX 操作系统中，
现在几乎所有的操作系统都支持TCP/IP 协议，因此TCP/IP 协议也是Internet 中最常用的基础协议。
    按TCP/IP 协议模型，网络通常被分为一个四层模型，这个四层模型和前面的OSI 七层模型有大致的对应关系，下面显示了TCP/IP 分层模型和OSI 分层模型之间的对应关系。
---------------------------------------------------------------------------------------------------------------------------------------------------------
    应用层
    表示层             应用层
    会话层
    ----------------------------------
    传输层             传输层
    ----------------------------------
    网络层             网络层
    ----------------------------------
    数据链路层
    物理层             物理 + 数据链路
---------------------------------------------------------------------------------------------------------------------------------------------------------
</pre>

### IP地址和端口号
<pre>
    IP 地址用于唯一地标识网络中的一个通信实体，这个通信实体既可以是一台主机，也可以是一台打印机，或者是路由器的某一个端口。
而在基于IP 协议网络中传输的数据包，都必须使用 IP 地址来进行标识。
    就像写一封信，要标明收信人的通信地址和发信人的地址，而邮政工作人员则通过该地址来决定邮件的去向。
类似的过程也发生在计算机网络里，每个被传输的数据包也要包括一个源IP地址和一个目的IP 地址，当该数据包在网络中进行传输时，这两个地址要保持不变，
以确保网络设备总能根据确定的IP 地址，将数据包从源通信实体送往指定的目的通信实体。
    IP 地址是数字型的， IP 地址是一个32 位( 32bit ) 整数，但通常为了便于记忆，通常把它分成4 个8 位的二进制数，每8 位之间用圆点隔开， 
每个8 位整数可以转换成一个0~255 的十进制整数，因此日常看到的IP 地址常常是这种形式: 202.9.128.88 。
    NIC ( Internet Network Information Center ) 统一负责全球Internet IP 地址的规划、管理，而Inter NIC 、APNIC 、RIPE
三大网络信息中心具体负责美国及其他地区的 IP 地址分配。其中APNIC 负责亚太地区的IP 管理，我国申请IP 地址也要通过APNIC ， APNIC 的总部设在日本东京大学。
    IP 地址被分成了A 、B 、C 、D 、E 五类，每个类别的网络标识和主机标识各有规则。
    A 类：10.0.0.0 ~ 10.255.255.255
    B 类：172.16.0.0 ~ 172.31.255.255
    C 类：192.168.0.0 ~ 192.168.255.255
    IP 地址用于唯一地标识网络上的一个通信实体，但一个通信实体可以有多个通信程序同时提供网络服务，此时还需要使用端口.
    端口是一个16 位的整数，用于表示数据交给哪个通信程序处理。因此，端口就是应用程序与外界交流的出入口，它是一种抽象的软件结构，包括一些数据结构和I/O ( 基本输入/输出)缓冲区。
    不同的应用程序处理不同端口上的数据，同一台机器上不能有两个程序使用同一个端口，端口号可以从0 到65535 ，通常将它分为如下三类。
    公认端口(Well Known Ports): 从0 到1023 ，它们紧密绑定(Binding ) 一些特定的服务。
    注册端口( Registered Ports ) : 从1024 到49151 ， 它们松散地绑定一些服务。应用程序通常应该使用这个范围内的端口。
    动态和/或私有端口(Dynamic and/or Private Ports ) : 从49152 到65535 ，这些端口是应用程序使用的动态端口，应用程序一般不会主动使用这些端口。
    如果把IP 地址理解为某个人所在地方的地址(包括街道和门牌号)，但仅有地址还是找不到这个人，还需要知道他所在的房号才可以找到这个人。因此如果把应用程序当作人，
把计算机网络当作类似邮递员的角色，当一个程序需要发送数据时，需要指定目的地的IP 地址和端口，如果指定了正确的IP 地址和端口号，计算机网络就可以将数据送给该IP 地址和端口所对应的程序。
</pre>

### Java的基本网络支持
<pre>
    Java 为网络支持提供了java.net 包，该包下的URL 和URLConnection 等类提供了以编程方式访问Web 服务的功能，而URLDecoder 和URLEncoder 则提供了普通字符串和
application/x-www-form-urlencoded MIME 字符串相互转换的静态方法。
</pre>

### URL
<pre>
    URL (Uniform Resource Locator ) 对象代表统一资源定位器，它是指向互联网"资源"的指针。资源可以是简单的文件或目录，
也可以是对更为复杂对象的引用，例如对数据库或搜索引擎的查询。在通常情况下， URL 可以由协议名、主机、端口和资源组成，
    即满足如下格式:
    protocol://host:port/resourceName
    例如如下的URL 地址:
    http://www.crazyit.org/index.php
    
    JDK 中还提供了一个URI ( Uniform Resource Identifiers )类，其实例代表一个统一资标识符， 
    Java 的URI 不能用于定位任何资源， 它的唯一作用就是解析。与此对应的是，URL 则包含一个可打开到达该资源的输入流，可以将URL理解成URI的特例
    
    URL 类提供了多个构造器用于创建URL 对象， 一旦获得了URL 对象之后，就可以调用如下方法来访问该URL 对应的资源。
    String getFile(): 获取该URL 的资源名。
    String getHost(): 获取该URL 的主机名。
    String getPath()) : 获取该URL 的路径部分。
    int getPort() : 获取该URL 的端口号。
    String getProtocol() : 获取该URL 的协议名称。
    String getQuery(): 获取该URL 的查询宇符串部分。
    URLConnection openConnection(): 返回一个URLConnection 对象，它代表了与URL 所引用的远程对象的连接。
    InputStream openStream(): 打开与此URL 的连接，并返回一个用于读取该URL 资源的InputStream.
    URL 对象中的前面几个方法都非常容易理解，而该对象提供的openStream()方法可以读取该URL资源的InputStream ，
通过该方法可以非常方便地读取远程资源甚至实现多线程下载。如 DownUtil 程序实现了一个多线程下载工具类。
</pre>

### 基于TCP 协议的网络编程
<pre>
    TCP/IP 通信协议是一种可靠的网络协议，它在通信的两端各建立一个Socket ，从而在通信的两端之间形成网络虚拟链路。
一旦建立了虚拟的网络链路，两端的程序就可以通过虚拟链路进行通信。Java对基于TCP 协议的网络通信提供了良好的封装， 
Java 使用Socket 对象来代表两端的通信端口，并通过Socket 产生 IO 流来进行网络通信。

    TCP 协议基础
    IP 协议是Internet 上使用的一个关键协议，它的全称是Internet Protocol 即Internet 协议，通常简称IP 协议。通过使用IP 协议，
从而使Internet 成为一个允许连接不同类型的计算机和不同操作系统的网络。
    要使两台计算机彼此能进行通信， 必须使两台计算机使用同一种"语言"， IP 协议只保证计算机能发送和接收分组数据。IP 协议负责将消息从一个主机传送到另一个主机，消
息在传送的过程中被分割成一个个的小包。
    尽管计算机通过安装IP 软件，保证了计算机之间可以发送和接收数据，但IP 协议还不能解决数据分组在传输过程中可能出现的问题, 因此，若要解决可能出现的问题，
连上Internet 的计算机还需要安装TCP 协议来提供可靠并且无差错的通信服务。
    TCP 协议被称作一种端对端协议。这是因为它对两台计算机之间的连接起了重要作用, 当一台计算机需要与另一台远程计算机连接时， TCP 协议会让它们建立一个连接:
用于发送和接收数据的虚拟链路。
    TCP 协议负责收集这些信息包， 并将其按适当的次序放好传送，接收端收到后再将其正确地还原。TCP 协议保证了数据包在传送中准确无误。TCP 协议使用重发机制
当一个通信实体发送一个消息给另一个通信实体后，需要收到另一个通信实体的确认信息，如果没有收到另一个通信实体的确认信息，则会再次重发刚才发送的信息。
    通过这种重发机制， TCP 协议向应用程序提供了可靠的通信连接，使它能够自动适应网上的各种变化。即使在Internet 暂时出现堵塞的情况下， TCP 也能够保证通信的可靠性。
    综上所述，虽然IP 和TCP 这两个协议的功能不尽相同，也可以分开单独使用，但它们是在同一时期作为一个协议来设计的， 并且在功能上也是互补的。只有两者结合起来，
才能保证Internet 在复杂的环境下正常运行。凡是要连接到Internet 的计算机，都必须同时安装和使用这两个协议， 因此在实际中常把这两个协议统称为TCP/IP 协议。
</pre>