# 数据库与JDBC编程

<pre>
    通过使用JDBC ， Java 程序可以非常方便地操作各种主流数据库，这是Java 语言的巨大魅力所在。
由于Java 语言的跨平台特性，所以使用JDBC 编写的程序不仅可以实现跨数据库，还可以跨平台， 具有
非常优秀的可移植性。
    程序使用JDBC API 以统一的方式来连接不同的数据库， 然后通过Statement 对象来执行标准的SQL
语句，并可以获得SQL 语句访问数据库的结果， 因此掌握标准的SQL 语句是学习JDBC 编程的基础。
    本章将会简要介绍关系数据库理论基础，并以MySQL 数据库为例来讲解标准的SQL 语句的语法细节，
包括基本查询语句、多表连接查询和子查询等。
    本章将重点介绍JDBC 连接数据库的详细步骤， 并讲解使用JDBC 执行SQL 语句的各种方式，包括
使用CallableStatement 调用存储过程等。本章还会介绍ResultSetMetaData 、DatabaseMetaData 两个接
口的用法。事务也是数据库编程中的重要概念，本章不仅会介绍标准SQL 语句中的事务控制语句，而且会讲解如何
利用JDBC API 进行事务控制。
</pre>

## 当前包下需重点掌握的知识点
| 位置 | 重要等级(1 ~ 5)<small>数字越大等级越高</small> | 简述 |
|:----:|:----:|:----:|
| ConnMySql | 5 | JDBC 编程步骤 |
| ExecuteDDLAndDML | 5 | 使用Java 8 新增的executeLargeUpdate 方法执行DDL和DML 语句 |
| PreparedStatementTest | 5 | 使用PreparedStatement 执行SQL 语句 |
| CallableStatementTest | 5 | 使用CallableStatement 调用存储过程 |
| 当前位置下第206行 | 5 | 事务的概念和MySQL 事务支持 |
| TransactionTest | 5 | JDBC 的事务支持 |
| BatchTest | 5 | Java8 增强的批量更新 |
| DatabaseMetaDataTest | 5 | 分析数据库信息 |
| 当前位置下第264行 | 5 | 使用连接池管理连接 |


### JDBC 基础
<pre>
    JDBC 的全称是Java Database Connectivity, 即 Java 数据库连接，它是一种可以执行SQL 语句的
Java API 。程序可通过JDBC API 连接到关系数据库， 并使用结构化查询语言( SQL. 数据库标准的查询语
言)来完成对数据库的查询、更新。
    与其他数据库编程环境相比， JDBC 为数据库开发提供了标准的API，所以使用JDBC 开发的数据库应用可
以跨平台运行，而且可以跨数据库(如果全部使用标准的SQL) 。也就是说，如果使用JDBC开发一个数据库应用，
则该应用既可以在Windows 平台上运行，也可以在UNIX 等其他平台上运行;既可以使用MySQL 数据库，也可以
使用Oracle 等数据库，而程序无须进行任何修改。

    最早的时候， Sun 公司希望自己开发一组Java API，程序员通过这组Java API 即可操所有的数据库系统，
但后来Sun 发现这个目标具有不可实现性因为数据库系统太多了， 而且各数据库系统的内部特性又各不相同。后来
Sun 就制定了一组标准的API，它们只是接口，没有提供实现这些实现类由各数据库厂商提供实现，这些实现类就是
驱动程序。而程序员使用JDBC 时只要面向标准的JDBC API 编程即可，当需要在数据库之间切换时，只要更换不同
的实现类(即更换数据库驱动程序)就行，这是面向接口编程的典型应用。
    Sun 提供的JDBC 可以完成以下三个基本工作。
    1.建立与数据库的连接。
    2.执行SQL 语句。
    3.获得SQL 语句的执行结果。
    通过JDBC 的这三个功能，应用程序即可访问、操作数据库系统。    
</pre>

### JDBC 驱动程序
<pre>
    数据库驱动程序是JDBC 程序和数据库之间的转换层，数据库驱动程序负责将JDBC 调用映射成特定的数据库调用。
    大部分数据库系统，例如Oracle 和Sybase 等，都有相应的JDBC 驱动程序， 当需要连接某个特定的数据库时，
必须有相应的数据库驱动程序。
    
    JDBC 驱动通常有如下4 种类型。
    第 l 种 JDBC 驱动：称为JDBC-ODBC 桥，这种驱动是最早实现的JDBC 驱动程序，主要目的是为了'快速推广JDBC 。
这种驱动将JDBC API 映射到ODBC API 。这种方式在Java 8 中己经被删除了。
    第 2 种 JDBC 驱动：直接将JDBC API 映射成数据库特定的客户端API 。这种驱动包含特定数据库的本地代码，用于
访问特定数据库的客户端。
    第 3 种 JDBC 驱动：支持三层结构的JDBC 访问方式， 主要用于Applet 阶段，通过Applet 访问数据库。
    第 4 种 JDBC 驱动：是纯Java 的， 直接与数据库实例交互。这种驱动是智能的， 它知道数据库使用的底层协议。
这种驱动是目前最流行的JDBC 驱动。

    早期为了让Java 程序操作Access 这种伪数据库， 可能需要使用JDBC-ODBC 桥， 但JDBC-ODBC 桥不适合在并发访问数据库
的情况下使用，其固有的性能和扩展能力也非常有限，因此Java 8 删除了JDBC-ODBC 桥驱动。基本上Java 应用也很少使用Access 这
种伪数据库。

    通常建议选择第 4 种JDBC 驱动，这种驱动避开了本地代码，减少了应用开发的复杂性，也减少了产生冲突和出错的可能。如果对性能有严格的要求，
则可以考虑使用第 2 种JDBC 驱动，但使用这种驱动，则势必增加编码和维护的困难。

    相对于ODBC 而言， JDBC 更加简单。总结起来， JDBC 比ODBC 多了如下几个优势。
    ODBC 更复杂， ODBC 中有几个命令需要配置很多复杂的选项，而JDBC 则采用简单、直观的方式来管理数据库连接。
    JDBC 比ODBC 安全性更高，更易部署。
</pre>

### 关系数据库基本概念和MySQL基本命令
<pre>
    严格来说，数据库(Database) 仅仅是存放用户数据的地方。当用户访问、操作数据库中的数据时，就需要数据库管理系统的帮助。数据库管理系统的全称是
Database Management System . 简称DBMS 。
    DBMS 是所有数据的知识库，它负责管理数据的存储、安全、一致性、并发、恢复和访问等操作。DBMS 有一个数据字典(有时也被称为系统表) .
用于存储它拥有的每个事务的相关信息，例如名字、结构、位置和类型，这种关于数据的数据也被称为元数据(metadata ) 。

    在数据库发展历史中，按时间顺序主要出现了如下几种类型的数据库系统。
    网状型数据库
    层次型数据库
    关系数据库
    面向对象数据库
    在上面4 种数据库系统中，关系数据库是理论最成熟、应用最广泛的数据库。从20 世纪70 年代末开始，关系数据库理论逐渐成熟，随之涌现出大量商用的关系数据库。
关系数据库理论经过30 多年的发展已经相当完善，在大量数据的查找、排序操作上非常成熟且快速，并对数据库系统的并发、隔离有非常完善的解决方案。

    对于关系数据库而言，最基本的数据存储单元就是数据表，因此可以简单地把数据库想象成大量数据表的集合( 当然，数据库绝不仅由数据表组成) 。
    数据表是存储数据的逻辑单元，可以把数据表想象成由行和列组成的表格，其中每一行也被称为一条记录，每一列也被称为一个字段。为数据库建表时，通常需要指定该表包含多少列，
每列的数据类型信息， 无须指定该数据表包含多少行一一因为数据库表的行是动态改变的，每行用于保存一条用户数据。除此之外，还应该为每个数据表指定一个特殊列， 该特殊列的值
可以唯一地标识此行的记录，则该特殊列被称为主键列。

    MySQL 数据库的一个实例(Server Instance ) 可以同时包含多个数据库， MySQL 使用如下命令来查看当前实例下包含多少个数据库:
    show databases;
    如果用户需要创建新的数据库，则可以使用如下命令:
    create database [IF NOT EXISTS] 数据库名;
    如果用户需要删除指定数据库，则可以使用如下命令:
    drop database 数据库名;
    建立了数据库之后，如果想操作该数据库(例如为该数据库建表，在该数据库中执行查询等操作) ,则需要进入该数据库。进入指定数据库可以使用如下命令:
    use 数据库名;
    进入指定数据库后，如果需要查询该数据库下包含多少个数据表，则可以使用如下命令:
    show tables;
    如果想查看指定数据表的表结构(查看该表有多少列，每列的数据类型等信息) ，则可以使用如下命令:
    desc 表名;
    MySQL 数据库安装成功后，在其安装目录下有一个bin 路径，该路径下包含一个mysql 命令，该命令用于启动MySQL 命令行客户端。执行mysql 命令的语法如下:
    mysql - p 密码- u 用户名 -h 主机名 --default-character-set=utf8
    执行上面命令可以连接远程主机的MySQL 服务。为了保证有较好的安全性，执行上面命令时可以省略-p 后面的密码， 执行该命令后系统会提示输入密码。
    
    MySQL 数据库通常支持如下两种存储机制。
    MyISAM: 这是MySQL 早期默认的存储机制， 对事务支持不够好。
    InnoDB: InnoDB 提供事务安全的存储机制。InnoDB 通过建立行级锁来保证事务完整性，并以Oracle 风格的共享锁来处理Select 语句。系统默认启动InnoDB 存储机制， 
如果不想使用InnoDB表，则可以使用skip-innodb 选项。
    对比两种存储机制， 不难发现InnoDB 比MyISAM 多了事务支持的功能， 而事务支持是Java EE 最重要的特性，因此通常推荐使用InnoDB 存储机制。如果使用5.0 以上版本的MySQL 数据库系统，
通常无须指定数据表的存储机制， 因为系统默认使用InnoDB 存储机制。如果需要在建表时显式指定存储机制，则可在标准建表语法的后面添加下面任意一句。
    ENGINE=MyISAM一一强制使用MyISAM 存储机制。
    ENGINE=InnoDB一一强制使用InnoDB 存储机制。
</pre>

### SQL 语旬基础
<pre>
    SQL 的全称是Structured Query Language ， 也就是结构化查询语言。SQL 是操作和检索关系数据库的标准语言，标准的SQL 语句可用于操作任何关系数据库。
    使用SQL 语句， 程序员和数据库管理员( DBA ) 可以完成如下任务。
    在数据库中检索信息。
    对数据库的信息进行更新。
    改变数据库的结构。
    更改系统的安全设置。
    增加或回收用户对数据库、表的许可权限。
    在上面5 个任务中，一般程序员可以管理前3 个任务， 后面2 个任务通常由DBA 来完成。
    
    标准的SQL 语句通常可分为如下几种类型。
    查询语句: 主要由select 关键宇完成， 查询语句是SQL 语句中最复杂、功能最丰富的语句。
    DML (Data Manipulation Language ， 数据操作语言)语句: 主要由insert 、update 和delete 三个关键宇完成。
    DDL (Data Definition Language ，数据定义语言)语句: 主要由create 、alter 、drop 和truncate 四个关键字完成。
    DCL (Data Control Language ， 数据控制语言)语句: 主要由grant 和revoke 两个关键字完成。
    事务控制语句:主要由commit 、rollback 和savepoint 三个关键宇完成。
    
    SQL 语句的关键字不区分大小写，也就是说， create 和CREATE 的作用完全一样。在上面5 种SQL语句中， DCL 语句用于为数据库用户授权，或者回收指定用户的权限，
通常无须程序员操作，所以本节不打算介绍任何关于DCL 的知识。
    在SQL 命令中也可能需要使用标识符， 标识符可用于定义表名、列名，也可用于定义变量等。这些标识符的命名规则如下。
    标识符通常必须以字母开头。
    标识符包括字母、数字和三个特殊宇符#_$。
    不要使用当前数据库系统的关键字、保留宇，通常建议使用多个单词连缀而成，单词之间以_分隔。
    同一个模式下的对象不应该同名，这里的模式指的是外模式。    
</pre>

### JDBC 的典型用法
<pre>
    JDBC 4.2 常用接口和类简介
    Java 8 支持JDBC 4.2 标准，JDBC 4.2 在原有JDBC 标准上增加了一些新特性。下面介绍这些JDBC API时会提到Java 8 新增的功能。
    
    DriverManager: 用于管理JDBC 驱动的服务类。程序中使用该类的主要功能是获取Connection对象，该类包含如下方法。
    public static synchronized Connection getConnection(String url, String user, String pass) throws SQLException: 该方法获得url 对应数据库的连接。
    
    Connection: 代表数据库连接对象， 每个Connection 代表一个物理连接会话。要想访问数据库，必须先获得数据库连接。该接口的常用方法如下。
    Statement createStatement() throws SQLException: 该方法返回一个Statement 对象。
    PreparedStatement prepareStatement(String sql) throws SQLException: 该方法返回预编译的Statement 对象，即将SQL 语句提交到数据库进行预编译。
    CallableStatement prepareCall(String sql) throws SQLException: 该方法返回CallableStatement对象， 该对象用于调用存储过程。
    上面三个方法都返回用于执行SQL 语句的Statement 对象， PreparedStatement 、CallableStatement是Statement 的子类，只有获得了Statement 之后才可执行SQL 语句。
    除此之外， Connection 还有如下几个用于控制事务的方法。
    Savepoint setSavepoint(): 创建一个保存点。
    Savepoint setSavepoint(String name): 以指定名字来创建一个保存点。
    void setTransactionIsolation(int level): 设置事务的隔离级别。
    void rollback(): 回滚事务。
    void rollback(Savepoint savepoint): 将事务回滚到指定的保存点。
    void setAutoCommit(boolean autoCommit): 关闭自动提交，打开事务。
    void commit(): 提交事务。
    Java 7 为Connection 新增了setSchema(String schema) 、getSchema()两个方法，这两个方法用于控制该Connection 访问的数据库Schema. Java 7 还为Connection 新增了
setNetworkTimeout(Executor executor, int milliseconds) 、getNetworkTimeout()两个方法来控制数据库连接的超时行为。

    Statement: 用于执行SQL 语句的工具接口。该对象既可用于执行DDL 、DCL 语句， 也可用于执行DML 语句，还可用于执行SQL 查询。当执行SQL 查询时， 返回查询到的结果集。它的常用方法如下。
    ResultSet executeQuery(String sql)throws SQLException: 该方法用于执行查询语句，并返回查询结果对应的ResultSet 对象。该方法只能用于执行查询语句。
    int executeUpdate(String sql)throws SQLException: 该方法用于执行DML 语句，并返回受影响的行数:该方法也可用于执行DDL 语句，执行DDL 语句将返回0 。
    boolean execute(String sql)throws SQLException: 该方法可执行任何SQL 语句。如果执行后第一个结果为ResultSet 对象，则返回true; 如果执行后第一个结果为受影响的行数或没有任何结果，则返回false 。
    Java 7 为Statement 新增了closeOnCompletion()方法，如果Statement 执行了该方法，则当所有依赖于该Statement 的ResultSet 关闭时，该Statement 会自动关闭。
Java 7 还为Statement 提供了一个isCloseOnCompletion()方法，该方法用于判断该Statement 是否打开了" closeOnCompletion" 。
    Java 8 为Statement 新增了多个重载的executeLargeUpdate()方法，这些方法相当于增强版的executeUpdate()方法， 返回值类型为long。也就是说， 当DML 语句影响的记录条数超过
Integer.MAX_VALUE时， 就应该使用executeLargeUpdate()方法。
    考虑到目前应用程序所处理的数据量越来越大，使用executeUpdate()方法具有更好的适应性。但遗憾的是， 目前最新的MySQL 驱动暂不支持该方法。
    
    PreparedStatement: 预编译的Statement 对象。PreparedStatement 是Statement 的子接口，它允许数据库预编译SQL语句(这些SQL 语句通常带有参数) ，以后每次只改变SQL 命令的参数，
避免数据库每次都需要编译SQL 语句，因此性能更好。相对于Statement 而言， 使用PreparedStatement 执行SQL 语句时，无须再传入SQL 语句， 只要为预编译的SQL 语句传入参数值即可。
所以它比Statement 多了如下方法。
    void setXxx(int parameterIndex,Xxx value): 该方法根据传入参数值的类型不同， 需要使用不同的方法。传入的值根据索引传给SQL 语句中指定位置的参数。
    
    ResultSet: 结果集对象。该对象包含访问查询结果的方法， ResultSet 可以通过列索引或列名获得列数据。它包含了如下常用方法来移动记录指针。
    void close(): 释放ResultSet 对象。
    boolean absolute(int row): 将结果集的记录指针移动到第row 行，如果row 是负数， 则移动到倒数第row 行。如果移动后的记录指针指向一条有效记录，则该方法返回true 。
    void beforeFirst(): 将ResultSet 的记录指针定位到首行之前，这是ResultSet 结果集记录指针的初始状态一一记录指针的起始位置位于第一行之前。
    boolean first(): 将ResultSet 的记录指针定位到首行。如果移动后的记录指针指向一条有效记录，则该方法返回true 。
    boolean previous(): 将ResultSet 的记录指针定位到上一行。如果移动后的记录指针指向一条有效记录，则该方法返回true 。
    boolean next(): 将ResultSet 的记录指针定位到下一行，如果移动后的记录指针指向一条有效记录，则该方法返回true 。
    boolean last(): 将ResultSet 的记录指针定位到最后一行，如果移动后的记录指针指向一条有效记录，则该方法返回true 。
    void afterLast(): 将ResultSet 的记录指针定位到最后一行之后。
    在JDK 1.4 以前，采用默认方法创建的Statement 所查询得到的ResultSet 不支持absolute() 、previous()等移动记录指针的方法，它只支持next()这个移动记录指针的方法，
即ResultSet 的记录指针只能向下移动，而且每次只能移动一格。从Java 5.0 以后就避免了这个问题，程序采用默认方法创建的Statement 所查询得到的ResultSet 
也支持absolute() 、previous()等方法。
    当把记录指针移动到指定行之后， ResultSet 可通过getXxx(int columnIndex) 或getXxx(String columnLabel)方法来获取当前行、指定列的值，前者根据列索引获取值， 
后者根据列名获取值。Java 7新增了<T> T getObject(int columnIndex, Class<T> type)和<T> T getObject(String columnLabel, Class<T>type)两个泛型方法，
它们可以获取任意类型的值。
</pre>

### 事务的概念和MySQL 事务支持
<pre>
    事务是由一步或几步数据库操作序列组成的逻辑执行单元，这系列操作要么全部执行，要么全部放弃执行。程序和事务是两个不同的概念。一般而言， 段程序中可能包含多个事务。
    事务具备4 个特性:
    原子性( Atomicity ) 、一致性( Consistency ) 、隔离性( Isolation ) 和持续性( Durability )。这4 个特性也简称为ACID 性。
    原子性( Atomicity ) : 事务是应用中最小的执行单位，就如原子是自然界的最小颗粒， 具有不可再分的特征一样， 事务是应用中不可再分的最小逻辑执行体。
    一致性( Consistency ) : 事务执行的结果， 必须使数据库从一个一致性状态， 变到另一个一致性状态。当数据库只包含事务成功提交的结果时，数据库处于一致性状态。
如果系统运行发生中断， 某个事务尚未完成而被迫中断，而该未完成的事务对数据库所做的修改己被写入数据库，此时， 数据库就处于一种不正确的状态。（比如银行在两个账户之间转账:
从A 账户向B 账户转入1000 元， 系统先减少A 账户的1000 元， 然后再为B 账户增加1000 元。如果全部执行成功，数据库处于一致性状态:如果仅执行完A 账户金额的修改，而没有增加B 账户的金额，
则数据库就处于不一致性状态; 因此， 一致性是通过原子性来保证的。）
    隔离性( Isolation ) : 各个事务的执行互不干扰，任意一个事务的内部操作对其他并发的事务都是隔离的。也就是说，并发执行的事务之间不能看到对方的中间状态， 并发执行的事务之间不能互相影响。
    持续性( Durability ) : 持续性也称为持久性( Persistence ) ，指事务一旦提交，对数据所做的任何改变都要记录到永久存储器中，通常就是保存进物理数据库。
    数据库的事务由下列语句组成。
    一组DML语句，经过这组DML 语句修改后的数据将保持较好的一致性。
    一条DDL 语句。
    一条DCL 语句。
    DDL 和DCL 语句最多只能有一条，因为DDL 和DCL 语句都会导致事务立即提交。
    当事务所包含的全部数据库操作都成功执行后， 应该提交( commit ) 事务， 使这些修改永久生效。
    事务提交有两种方式: 显式提交和自动提交。
    显式提交:使用commit 。
    自动提交: 执行DDL 或DCL 语句，或者程序正常退出。
    当事务所包含的任意一个数据库操作执行失败后，应该回滚(rollback) 事务，使该事务中所做的修改全部失效。事务回滚有两种方式:显式回滚和自动回滚。
    显式回滚: 使用rollback 。
    自动回滚: 系统错误或者强行退出。
    MySQL 默认关闭事务( 即打开自动提交) ，在默认情况下，用户在MySQL 控制台输入一条DML 语句，这条DML 语句将会立即保存到数据库里。为了开启MySQL 的事务支持，可以显式调用如下命令:
    SET AUTOCOMMIT = {0 | 1) 0 为关闭自动提交，即开启事务
    自动提交和开启事务恰好相反，如果开启自动提交就是关闭事务;关闭自动提交就是开启事务。
    一旦在MySQL 的命令行窗口中输入set autocommit=O 开启了事务，该命令行窗口里的所有DML语句都不会立即生效，上一个事务结束后第一条DML 语句将开始一个新的事务，
而后续执行的所有SQL语句都处于该事务中，除非显式使用commit 来提交事务，或者正常退出，或者运行DDL 、DCL 语句导致事务隐式提交。当然， 也可以使用rollback 回滚来结束事务，
使用rollback 结束事务将导致本次事务中DML 语句所做的修改全部失效。
    一个MySQL 命令行窗口代表一次连接Session ， 在该窗口里设直set autocommit=O, 相当于关闭了该连接Session 的自动提交，对其他连接不会有任何影响，也就是对其他MySQL 命令行窗口不会有任何影响
    除此之外，如果不想关闭整个命令行窗口的自动提交，而只是想临时性地开始事务，则可以使用MySQL 提供的start transaction 或begin 两个命令， 它们都表示临时性地开始一次事务， 
处于start transaction 或begin 后的DML 语句不会立即生效，除非使用commit 显式提交事务，或者执行DDL 、DCL 语者来隐式提交事务。如下SQL 代码将不会对数据库有任何影响。
    # 临时开始事务
    begin;
    # 向jdbc_user表插入三条记录
    insert into jdbc_user(username) values('事务-1');
    insert into jdbc_user(username) values('事务-2');
    insert into jdbc_user(username) values('事务-2');
    # 查询jdbc_user 表的记录          1
    select * from jdbc_user WHERE username like '事务-_';
    # 回滚事务
    rollback;
    # 再次查询                        2
    select * from jdbc_user WHERE username like '事务-_';
    执行上面SQL 语句中的第 1 条查询语句将会看到刚刚插入的3 条记录，如果打开MySQL 的其他命令行窗口将看不到这 3 条记录这正体现了事务的隔离性。接着程序rollback 了事务中的全部修改，
执行第 2 条查询语句时将看到数据库又恢复到事务开始前的状态。
    提交，不管是显式提交还是隐式提交，都会结束当前事务;回滚，不管是显式回滚还是隐式回滚，都会结束当前事务。
    除此之外， MySQL 还提供了savepoint 来设置事务的中间点，通过使用savepoint 设置事务的中间点可以让事务回滚到指定中间点，而不是回滚全部事务。如下SQL 语句设置了一个中间点:
    savepoint a;
    一旦设置了中间点后，就可以使用rollback 回滚到指定中间点，回滚到指定中间点的代码如下:
    rollback to a;
    普通的提交、回滚都会结束当前事务，但回滚到指定中间点因为依然处于事务之中，所以不会结束当前事务。
</pre>

### 使用连接池管理连接-介绍
<pre>
    数据库连接的建立及关闭是极耗费系统资源的操作，在多层结构的应用环境中，这种资源的耗费对系统性能影响尤为明显。通过前面介绍的方式(通过DriverManager 获取连接)获得的数据库连接，
一个数据库连接对象均对应一个物理数据库连接，每次操作都打开一个物理连接，使用完后立即关闭连接。频繁地打开、关闭连接将造成系统性能低下。
    数据库连接池的解决方案是: 当应用程序启动时，系统主动建立足够的数据库连接，并将这些连接组成一个连接池。每次应用程序请求数据库连接时，无须重新打开连接，而是从连接池中取出己有的连
接使用，使用完后不再关闭数据库连接，而是直接将连接归还给连接池。通过使用连接池，将大大提高程序的运行效率。
    对于共享资源的情况，有一个通用的设计模式:资源池(Resource Pool) ，用于解决资源的频繁请求、释放所造成的性能下降。为了解决数据库连接的频繁请求、释放， JDBC 2.0 规范引入了数据库连
接池技术。数据库连接池是Connection 对象的工厂。数据库连接池的常用参数如下。
    数据库的初始连接数。
    连接池的最大连接数。
    连接池的最小连接数。
    连接池每次增加的容量。
    JDBC 的数据库连接池使用javax.sql.DataSource 来表示， DataSource 只是一个接口，该接口通常由商用服务器(如WebLogic 、WebSphere) 等提供实现，
也有一些开源组织提供实现(如DBCP 和C3PO 等)。
</pre>