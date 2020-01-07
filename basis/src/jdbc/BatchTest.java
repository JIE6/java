package jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * Java8 增强的批量更新
 * JDBC 还提供了一个批量更新的功能， 使用批量更新时， 多条SQL 语句将被作为一批操作被同时收集，并同时提交。
 * 批量更新必须得到底层数据库的支持，可以通过调用 DatabaseMetaData 的 supportsBatchUpdates()方法来查看底层数据库是否支持批量更新。
 *
 * 使用批量更新也需要先创建一个Statement 对象， 然后利用该对象的addBatch()方法将多条SQL 语句同时收集起来，最后调用Java 8 为Statement 对象新增的
 * executeLargeBatch() (或原有的executeBatch() )方法同时执行这些SQL 语句。只要批量操作中任何一条SQL 语句影响的记录条数可能超过
 * Integer.MAX_VALUE ，就应该使用executeLargeBatch()方法，而不是executeBatch()方法。
 *
 * 如下代码片段示范了如何执行批量更新。
 * Statement stmt = conn.createStatement();
 * // 使用Statement 同时收集多条SQL 语句
 * stmt.addBatch(sql1);
 * stmt.addBatch(sql2);
 * stmt.addBatch(sql3);
 * ......
 * // 同时执行所有的SQL 语句
 * stmt.executeLargeBatch();
 *
 * 执行executeLargeBatch()方法将返回一个long[]数组，因为使用Statement 执行DDL 、DML 语句都将返回一个long 值，而执行多条DDL 、DML 语句将会返回多个long 值，
 * 多个long 值就组成了这个long[]数组。如果在批量更新的addBatch()方法中添加了select 查询语句，程序将直接出现错误。
 *
 * 为了让批量操作可以正确地处理错误，必须把批量执行的操作视为单个事务，如果批量更新在执行过程中失败，则让事务回滚到批量操作开始之前的状态。
 * 为了达到这种效果，程序应该在开始批量操作之前先关闭自动提交，然后开始收集更新语句，当批量操作执行结束后，提交事务，并恢复之前的自动提交模式。
 * 如下代码示范了如何使用JDBC 的批量更新。
 *
 * @author JIE
 */
public class BatchTest {

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

    public void batch(String... sqls) throws Exception {
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
                    stmt.addBatch(sql);
                }
                // 同时提交所有的SQL 语句
                stmt.executeLargeBatch();
            }
            //提交事务
            connection.commit();
        }
    }

    public static void main(String[] args) throws Exception {
        BatchTest batchTest = new BatchTest();
        batchTest.initParam("jdbc/mysql");
        String[] sqls = {
                "insert into jdbc_user(username) values('batch-事务-1')",
                "insert into jdbc_user(username) values('batch-事务-2')",
                "insert into jdbc_user(username) values('batch-事务-3')"
        };

        batchTest.batch(sqls);
    }
}
