package jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 使用CallableStatement 调用存储过程
 *
 * 下面的SQL 语句可以在MySQL 数据库中创建一个简单的存储过程。
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 * delimiter //
 * create procedure add_pro(a int , b int, out sum int)
 * begin
 * set sum = a + b;
 * end;
 * //
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 * 上面的SQL 语句将MySQL 的语句结束符改为双斜线(//， 这样就可以在创建存储过程中使用分号作为分隔符(MySQL 默认使用分号作为语句结束符) 。
 * 上面程序创建了名为add_pro 的存储过程，该存储过程包含三个参数: a 、b 是传入参数，而sum 使用out 修饰，是传出参数。
 *
 * 调用存储过程使用CallableStatement ，可以通过Connection 的prepareCall() 方法来创建CallableStatement 对象，创建该对象时需要传入调用存储过程的SQL 语句。
 * 调用存储过程的SQL 语句总是这种格式: {call 过程名(?,?,?...)} ，其中的问号作为存储过程参数的占位符。例如，如下代码就创建了调用上面存储过程的CallableStatement 对象。
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 * // 使用Connection 来创建一个CallableStatement 对象
 * cstmt = conn.prepareCall ("{call add_pro(?, ?, ?)}");
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * 存储过程的参数既有传入参数，也有传出参数。所谓传入参数就是Java 程序必须为这些参数传入值，可以通过CallableStatement 的setXxx()方法为传入参数设置值:
 * 所谓传出参数就是Java 程序可以通过该参数获取存储过程里的值， CallableStatement 需要调用registerOutParameter()方法来注册该参数。
 * 如下代码所示:
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 * // 注册CallableStatement  的第三个参数是int 类型
 * cstmt.registerOutParameter(3, Types.INTEGER);
 * --------------------------------------------------------------------------------------------------------------------------------------------------------
 *
 * 经过上面步骤之后，就可以调用CallableStatement 的execute()方法来执行存储过程了，执行结束后通过CallableStatement 对象的getXxx(int index)方法来获取指定传出参数的值。
 * 下面程序示范了如何来调用该存储过程。
 * @author JIE
 */
public class CallableStatementTest {

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

    public void callProcedure() throws Exception {
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
                // 使用Connection 来创建一个CallableStatement 对象
                CallableStatement callableStatement = connection.prepareCall("{call add_pro(?, ?, ?)}")
        ){
            callableStatement.setInt(1, 4);
            callableStatement.setInt(2, 5);
            // 注册CallableStatement 的第三个参数是int 类型
            callableStatement.registerOutParameter(3, Types.INTEGER);
            // 执行存储过程
            callableStatement.execute();
            // 获取并输出存储过程传出参数的值
            System.out.println("执行结果是：" + callableStatement.getInt(3));
        }
    }

    public static void main(String[] args) throws Exception {
        CallableStatementTest callableStatementTest = new CallableStatementTest();
        callableStatementTest.initParam("jdbc/mysql");
        callableStatementTest.callProcedure();
    }
}
