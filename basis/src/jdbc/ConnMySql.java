package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * JDBC 编程步骤
 *
 * 大致了解了JDBC API 的相关接口和类之后，下面就可以进行JDBC 编程了， JDBC 编程大致按如下步骤进行。
 *
 * 1.加载数据库驱动。通常使用Class 类的forName()静态方法来加载驱动。例如如下代码:
 * Class.forName(driverClass)
 * 最新的JDBC 驱动已经可以通过SPI 自动注册驱动类了，在JDBC 驱动皿包的META-INF\services 路径下会包含一个java.sql.Driver 文件，
 * 该文件指定了JDBC 驱动类。因此，如果使用这种最新的驱动JAR 包，第1 步其实可以省略。
 * 上面代码中的driverClass 就是数据库驱动类所对应的宇符串。例如，加载MySQL 的驱动采用如下代码:
 * Class.forName ("com.mysql.jdbc.Driver");
 * 而加载Oracle 的驱动则采用如下代码:
 * Class.forName("oracle.jdbc.driver.OracleDriver");
 * 从上面代码中可以看出，加载驱动时并不是真正使用数据库的驱动类， 只是使用数据库驱动类名的宇符串而己。
 *
 * 2.通过DriverManager 获取数据库连接。DriverManager 提供了如下方法:
 * DriverManager.getConnection(String url , String user, String pass);
 * 当使用DriverManager 获取数据库连接时，通常需要传入三个参数: 数据库URL 、登录数据库的用户名和密码。这三个参数中用户名和密码通常由DBA (数据库管理员)分配，
 * 而且该用户还应该具有相应的权限，才可以执行相应的SQL 语句。
 * 数据库URL 通常遵循如下写法:
 * jdbc:subprotocol:other stuff
 * 上面URL 写法中的jdbc 是固定的，而subprotocol 指定连接到特定数据库的驱动，而后面的other和stuff 也是不固定的也没有较强的规律，不同数据库的URL 写法可能存在较大差异。
 * 例如， MySQL数据库的URL 写法如下:
 * jdbc:mysql://hostname:port/databasename
 * Oracle 数据库的URL 写法如下:
 * jdbc:oracle:thin:@hostname:port:databasename
 * 如果想了解特定数据库的URL 写法，请查阅该数据库JDBC 驱动的文档
 *
 * 3.通过Connection 对象创建Statement 对象。Connection 创建Statement 的方法有如下三个。
 * createStatement(): 创建基本的Statement 对象。
 * prepareStatement(String sql): 根据传入的SQL 语句创建预编译的Statement 对象。
 * prepareCall(String sql): 根据传入的SQL 语句创建CallableStatement 对象。
 *
 * 4.使用Statement 执行SQL 语句。所有的Statement 都有如下三个方法来执行SQL 语句。
 * execute(): 可以执行任何SQL 语句，但比较麻烦。
 * executeUpdate(): 主要用于执行DML 和DDL 语句。执行DML语句返回受SQL 语句影响的行数，执行DDL语句返回0。
 * executeQuery(): 只能执行查询语句，执行后返回代表查询结果的ResultSet 对象。
 *
 * 5.操作结果集。如果执行的SQL 语句是查询语句，则执行结果将返回一个ResultSet 对象，该对象里保存了SQL 语句查询的结果。
 * 程序可以通过操作该ResultSet 对象来取出查询结果。ResultSet 对象主要提供了如下两类方法。
 * next() 、previous() 、first() 、last() 、beforeFirst() 、afterLast() 、absolute()等移动记录指针的方法。
 * getXxx()方法获取记录指针指向行、特定列的值。该方法既可使用列索引作为参数，也可使用列名作为参数。使用列索引作为参数性能更好，使用列名作为参数可读性更好。
 * ResultSet 实质是一个查询结果集，在逻辑结构上非常类似于一个表。
 *
 * 6.回收数据库资源，包括关闭ResultSet、Statement 和Connection 等资源。
 *
 * 下面程序简单示范了JDBC 编程， 并通过ResultSet 获得结果集的过程。
 * @author JIE
 */
public class ConnMySql {

    public static void main(String[] args) throws Exception {
        // 1.加载驱动，使用反射知识，现在记住这么写
        Class.forName("com.mysql.jdbc.Driver");
        String querySql = "SELECT host, user FROM user;";
        try (
                // 2.使用DriverManager 获取数据库连接, 其中返回的Connection 就代表了Java 程序和数据库的连接, 不同数据库的URL 写法需要查驱动文档，用户名、密码由DBA 分配
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?useSSL=false", "root", "root");
                // 3.使用Connection 来创建一个Statement 对象
                Statement statement = connection.createStatement();
                // 4.执行SQL语句；Statement 有三种执行SQL 语句的方法:
                // 1. execute() 可执行任何SQL 语句，返回一个boolean 值
                // 2. executeQuery() 执行select 语句一返回查询到的结果集
                // 3.executeUpdate() 用于执行DML 语句一返回一个整数代表被SQL 语句影响的记录条数
                ResultSet resultSet = statement.executeQuery(querySql)
        ){
            // ResultSet 有一系列的getXxx( 列索引 | 列名)方法，用于获取记录指针指向行、特定列的值，不断地使用next ()将记录指针下移一行
            // 如果移动之后记录指针依然指向有效行，则next ()方法返回true
            while (resultSet.next()) {
                System.out.println("---------------------------------------");
                System.out.println(resultSet.getString(1) + " | " + resultSet.getString(2));
            }
        }
        /**
         * 与前面介绍的步骤略有区别的是，本程序采用了自动关闭资源的try语句来关闭各种数据库资源，
         * Java 7 改写了Connection 、Statement 、ResultSet 等接口，它们都继承了AutoCloseable 接口，
         * 因此它们都可以由try语句来关闭。
         */
    }
}
