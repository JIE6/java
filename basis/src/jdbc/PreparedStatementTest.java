package jdbc;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 使用PreparedStatement 执行SQL 语句
 *
 * 如果经常需要反复执行一条结构相似的SQL 语句，例如如下两条SQL 语句:
 * insert into student table values (null , '张三'， 1) ;
 * insert into student table values (null , '张三'， 2) ;
 * 对于这两条SQL 语句而言，它们的结构基本相似，只是执行插入时插入的值不同而己。对于这种情况，可以使用带占位符(?)参数的SQL 语句来代替它:
 * insert into student table values (null , ?， ?);
 * 但Statement 执行SQL 语句时不允许使用问号占位符参数，而且这个问号占位符参数必须获得值后才可以执行。为了满足这种功能， JDBC 提供了PreparedStatement 接口，
 * 它是Statement 接口的子接口，它可以预编译SQL 语句，预编译后的SQL 语句被存储在PreparedStatement 对象中，然后可以使用该对象多次高效地执行该语句。简而言之，
 * 使用PreparedStatement 比使用Statement 的效率要高。
 *
 * 创建PreparedStatement 对象使用Connection 的prepareStatement()方法，该方法需要传入一个SQL字符串，该SQL 字符串可以包含占位符参数。如下代码所示:
 * pstmt = conn.prepareStatement("insert into student table values (null , ?， ?)");
 * PreparedStatement 也提供了execute() 、executeUpdate() 、executeQuery()三个方法来执行SQL 语句，
 * 不过这三个方法无须参数， 因为PreparedStatement 己存储了预编译的SQL 语句。
 * 使用PreparedStatement 预编译SQL 语句时， 该SQL 语句可以带占位符参数， 因此在执行SQL 语句之前必须为这些参数传入参数值，
 * PreparedStatement 提供了一系列的setXxx(int index , Xxx value)方法来传入参数值。
 *
 * 下面程序示范了使用Statement 和PreparedStatement 分别插入100 条记录的对比。使用Statement需要传入100 条SQL 语句，
 * 但使用PreparedStatement 则只需要传入 100条预编译的SQL 语句，然后100次为该PreparedStatement 的参数设值即可。
 *
 * @author JIE
 */
public class PreparedStatementTest {

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

    public void insertDataByStatement(String... sqls) throws Exception {
        long startMillis = System.currentTimeMillis();
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
                Statement statement = connection.createStatement();
        ){
            for (String sql : sqls) {
                statement.executeUpdate(sql);
            }
        }
        long endMillis = System.currentTimeMillis();
        System.out.println("statement共耗时：" + (endMillis - startMillis));
    }

    public void insertDataByPreparedStatement(String... names) throws Exception {
        long startMillis = System.currentTimeMillis();
        Class.forName(driver);
        try (
                Connection connection = DriverManager.getConnection(url, user, pass);
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jdbc_user(username) VALUES(?)")
        ){
            for (String name : names) {
                preparedStatement.setString(1, name);
                preparedStatement.executeUpdate();
            }
        }
        long endMillis = System.currentTimeMillis();
        System.out.println("preparedStatement共耗时：" + (endMillis - startMillis));
    }

    public static void main(String[] args) throws Exception {
        PreparedStatementTest preparedStatementTest = new PreparedStatementTest();
        preparedStatementTest.initParam("jdbc/mysql");
        // insertDataByStatement
        String[] statement = new String[100];
        for (int i = 0; i < 100; i++) {
            statement[i] = "INSERT INTO jdbc_user(username) VALUES('statement-"+i+"');";
        }
        preparedStatementTest.insertDataByStatement(statement);
        // insertDataByPreparedStatement
        String[] PreparedStatement = new String[100];
        for (int i = 0; i < 100; i++) {
            PreparedStatement[i] = "PreparedStatement-"+i;
        }
        preparedStatementTest.insertDataByPreparedStatement(PreparedStatement);

        /**
         * statement共耗时：1729
         * PreparedStatement共耗时：993
         *
         * 多次运行上面程序，可以发现使用PreparedStatement 插入100 条记录所用的时间比使用Statement插入100 条记录所用的时间少，
         * 这表明PreparedStatement 的执行效率比Statement 的执行效率高。
         *
         * 除此之外，使用PreparedStatement 还有一个优势当SQL 语句中要使用参数时，无须"拼接"SQL 字符串。而使用Statement 则要"拼接" SQL 字符串，
         * 如上程序中代码所示，这是相当容易出现错误的. 注意代码中的单引号，这是因为SQL 语句中的字符串必须用单引号引起来。尤其是当SQL 语句中有多个字符串参数时，
         * "拼接"这条SQL 语句时就更容易出错了。使用PreparedStatement 则只需要使用问号占位符来代替这些参数即可，降低了编程复杂度。
         * 使用PreparedStatement 还有一个很好的作用. 用于防止SQL 注入。
         */
    }
}
