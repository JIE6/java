package jdbc;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ResourceBundle;

/**
 * 分析数据库信息
 *
 * JDBC 提供了DatabaseMetaData 来封装数据库连接对应数据库的信息，通过Connection 提供的getMetaDataO方法就可以获取数据库对应的DatabaseMetaData 对象。
 * DatabaseMetaData 接口通常由驱动程序供应商提供实现， 其目的是让用户了解底层数据库的相关信息。使用该接口的目的是发现如何处理底层数据库，尤其是对于试图与多个数据库一起使用的应用程序
 * 因为应用程序需要在多个数据库之间切换，所以必须利用该接口来找出底层数据库的功能，例如，调用supportsCorrelatedSubqueries()方法查看是否可以使用关联子查询，
 * 或者调用supportsBatchUpdates()方法查看是否可以使用批量更新。
 *
 * 许多DatabaseMetaData 方法以ResultSet 对象的形式返回查询信息，然后使用ResultSet 的常规方法(如getString()和getInt() ) 即可从这些ResultSet 对象中获取数据。
 * 如果查询的信息不可用， 则将返回一个空ResultSet 对象。
 *
 * DatabaseMetaData 的很多方法都需要传入一个xxxPattern 模式字符串，这里的xxxPattern 不是正则表达式，而是SQL 里的模式字符串，即用百分号 % 代表任意多个字符，使用下画线 _ 代表一个
 * 字符。在通常情况下， 如果把该模式宇符串的参数值设置为null ，即表明该参数不作为过滤条件。
 *
 * 下面程序通过DatabaseMetaData 分析了当前Connection 连接对应数据库的一些基本信息，
 * 包括当前数据库包含多少数据表，存储过程， jdbc_user 表的数据列、主键、外键等信息。
 *
 * @author JIE
 */
public class DatabaseMetaDataTest {

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

    public void info() throws Exception {
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
        ){
            // //获取DatabaseMetaData 对象
            DatabaseMetaData metaData = connection.getMetaData();
            // 获取MySQL 支持的所有表类型
            ResultSet tableTypes = metaData.getTableTypes();
            System.out.println("--MySQL 支持的表类型信息--"); ;
            printResultSet(tableTypes);
            // 获取当前数据库的全部数据表
            ResultSet tables = metaData.getTables(null ,null , "%" , new String[] {"TABLE"}) ;
            System.out.println ("--当前数据库里的数据表信息--" ) ;
            printResultSet(tables);
            //获取 jdbc_user 表的主键
            ResultSet jdbcUserPrimaryKey = metaData.getPrimaryKeys(null, null, "jdbc_user");
            System.out.println( "--jdbc_user表的主键信息--" );
            printResultSet(jdbcUserPrimaryKey);
            //获取当前数据库的全部存储过程
            ResultSet procedures = metaData.getProcedures(null, null, "%");
            System.out.println( "--当前数据库里的存储过程信息--" );
            printResultSet(procedures);
            // 获取 jdbc_user 表的全部数据列
            ResultSet jdbcUserTable = metaData.getColumns(null, null, "jdbc_user", "%");
            System.out.println( "--jdbc_user表的全部数据列--" );
            printResultSet(jdbcUserTable);
        }
    }

    public void printResultSet(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        // 打印ResultSet 的所有列标题
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            System.out.print(metaData.getColumnName(i + 1) + "\t");
        }
        System.out.print("\n");
        // 打印ResultSet 里的全部数据
        while (resultSet.next()) {
            for (int i = 0; i < metaData.getColumnCount(); i++) {
                System.out.print(resultSet.getString(i + 1) + "\t");
            }
            System.out.print("\n");
        }
        resultSet.close();
    }

    public static void main(String[] args) throws Exception {
        DatabaseMetaDataTest databaseMetaDataTest = new DatabaseMetaDataTest();
        databaseMetaDataTest.initParam("jdbc/mysql");
        databaseMetaDataTest.info();
    }
}
