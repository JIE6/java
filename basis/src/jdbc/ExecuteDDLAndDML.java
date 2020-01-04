package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * 使用Java 8 新增的executeLargeUpdate 方法执行DDL和DML 语句
 *
 * 前面介绍了JDBC 执行查询的示例程序，实际上， JDBC 不仅可以执行查询，也可以执行DDL DML 等SQL 语句，从而允许通过JDBC 最大限度地控制数据库。
 *
 * Statement 提供了三个方法来执行SQL 语句，前面己经介绍了使用executeQuery()来执行查询语句，下面将介绍使用executeLargeUpdate() (或executeUpdate())
 * 来执行DDL 和DML 语句。使用Statement执行DDL 和DML 语句的步骤与执行普通查询语句的步骤基本相似，区别在于执行了DDL 语句后返回值为0 ，执行了DML 语句后返回值为受影响的记录条数。
 *
 * 下面程序示范了使用executeUpdate()方法(此处暂未使用executeLargeUpdate()方法是因为MySQL驱动暂不支持)创建数据表
 * @author JIE
 */
public class ExecuteDDLAndDML {

    private String driver;
    private String url;
    private String user;
    private String pass;

    public void initParam(String paramFile) {
        // 使用Properties 类来加载属性文件
        ResourceBundle mysqlResourceBundle = ResourceBundle.getBundle(paramFile);
        driver = mysqlResourceBundle.getString("driver");
        url = mysqlResourceBundle.getString("url");
        user = mysqlResourceBundle.getString("user");
        pass = mysqlResourceBundle.getString("pass");
    }

    public void createTable(String sql) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
        ){
            // 执行DDL 语句，创建数据表
            statement.executeUpdate(sql);

        }
    }

    public static void main(String[] args) throws Exception {
        ExecuteDDLAndDML edd = new ExecuteDDLAndDML();
        edd.initParam("jdbc/mysql");
        String creatJdbcUserTableSql = "CREATE TABLE jdbc_user (\n" +
                "id INT(11) NOT NULL AUTO_INCREMENT COMMENT 'id',\n" +
                "username VARCHAR(250) NOT NULL  COMMENT 'username',\n" +
                "PRIMARY KEY (`id`) USING BTREE\n" +
                ");";
        edd.createTable(creatJdbcUserTableSql);
        System.out.println("--------建表成功--------");
        /**
         * 使用executeUpdate()执行DML 语句与执行DDL 语句基本相似，区别是executeUpdate()执行DDL语句后返回0 ，
         * 而执行DML 语句后返回受影响的记录条数。下面程序将会执行一条insert 语句，
         * 这条insert 语句会向刚刚建立的jdbcUser 数据表中插入几条记录。因为使用了带子查询的insert 语句，
         * 所以可以一次插入多条语句。
         */
        String insertJdbcUserDataSql = "INSERT INTO jdbc_user(username) VALUES('MySQL'),('ORACLE'),('SqlServer');";
        int i = edd.insertData(insertJdbcUserDataSql);
        System.out.println("--------系统中共有 " + i + " 条记录受影响--------");
    }

    public int insertData(String sql) throws Exception {
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
        ){
            // 执行 DML 语句，返回受影响的记录条数
            return statement.executeUpdate(sql);
        }
    }
}
