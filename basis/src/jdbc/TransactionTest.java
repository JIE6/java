package jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * JDBC 的事务支持
 *
 * JDBC 连接也提供了事务支持， JDBC 连接的事务支持由Connection 提供， Connection 默认打开自动提交，即关闭事务，在这种情况下，
 * 每条SQL 语句一旦执行，便会立即提交到数据库，永久生效，无法对其进行回滚操作。
 *
 * 可以调用Connection 的setAutoCommit()方法来关闭自动提交，开启事务，如下代码所示:
 * conn.setAutoCommit(false);
 *
 * 程序中还可调用Connection 提供的getAutoCommit()方法来返回该连接的自动提交模式。一旦事务开始之后，程序可以像平常一样创建Statement 对象，
 * 创建了Statement 对象之后，可以执行任意多条DML 语句，如下代码所示:
 * stmt.executeUpdate(...);
 * stmt.executeUpdate(...);
 * stmt.executeUpdate(...);
 * ......
 * 上面这些SQL 语句虽然被执行了，但这些SQL 语句所做的修改不会生效，因为事务还没有结束。如果所有的SQL 语句都执行成功，
 * 程序可以调用Connection 的commit()方法来提交事务，如下代码所示:
 * conn.commit();
 *
 * 如果任意一条SQL 语句执行失败，则应该用Connection 的rollback()方法来回滚事务，如下代码所示:
 * conn.rollback();
 *
 * 实际上，当Connection 遇到一个未处理的SQLException 异常时，系统将会非正常退出， 事务也会自动回滚。但如果程序捕获了该异常，则需要在异常处理块中显式地回滚事务。
 *
 * 下面程序示范了当程序出现未处理的SQLException 异常时，系统将自动回滚事务。
 *
 * @author JIE
 */
public class TransactionTest {

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

    public void transaction(String... sqls) throws Exception {
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
        ){
            // 关闭自动提交，开启事务
            connection.setAutoCommit(false);
            try (
                    Statement stmt = connection.createStatement()
                    ){
                // 循环多次执行SQL 语句
                for (String sql : sqls) {
                    stmt.executeUpdate(sql);
                }
            }
            int i = 10 / 0;
            //提交事务
            connection.commit();
        }
    }

    public static void main(String[] args) throws Exception {
        TransactionTest transactionTest = new TransactionTest();
        transactionTest.initParam("jdbc/mysql");
        String[] sqls = {
                "insert into jdbc_user(username) values('事务-7')",
                "insert into jdbc_user(username) values('事务-8')",
                "insert into jdbc_user(username) values('事务-9')"
        };
        transactionTest.transaction(sqls);
        /**
         * 上面程序中的粗体字代码只是开启事务、提交事务的代码，并没有回滚事务的代码。但当程序执行到第 65 行代码时，将会引发 ArithmeticException: / by zero 异常，
         * 该异常没有得到处理，引起程序非正常结束，所以事务自动回滚。
         *
         * Connection 也提供了设置中间点的方法: setSavepoint(), Connection 提供了两个方法来设置中间点。
         * Savepoint setSavepoint(): 在当前事务中创建一个未命名的中间点，并返回代表该中间点的Savepoint 对象。
         * Savepoint setSavepoint(String name): 在当前事务中创建一个具有指定名称的中间点， 并返回代表该中间点的Savepoint 对象
         * 通常来说，设置中间点时没有太大的必要指定名称，因为Connection 回滚到指定中间点时，并不是根据名字回滚的， 而是根据中间点对象回滚的，
         * Connection 提供了rollback(Savepoint savepoint)方法回滚到指定中间点。
         */
    }
}
