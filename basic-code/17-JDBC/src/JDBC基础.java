/*
JDBC概念：Java DataBase Connectivity  Java 数据库连接， Java语言操作数据库
    本质：其实是官方（sun公司）定义的一套操作所有关系型数据库的规则，即接口。
	        各个数据库厂商去实现这套接口，提供数据库驱动jar包(实现类)。
	        我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动jar包中的实现类。



2. 快速入门：
	* 步骤：
		1. 导入驱动jar包 mysql-connector-java-5.1.37-bin.jar
			1.复制mysql-connector-java-5.1.37-bin.jar到项目的libs目录下
			2.右键-->Add As Library

        2.注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            新版会自动注册，不需写这一句

        3.获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
                DriverManager：驱动管理对象
                    方法：static Connection getConnection(String url, String user, String password)
                          url：指定连接的路径：jdbc:mysql://ip地址(域名):端口号/数据库名称
                Connection：数据库连接对象
                    功能：
                        1. 获取执行sql 的对象
                            * Statement createStatement()
                            * PreparedStatement prepareStatement(String sql)
                        2. 管理事务：
                            * 开启事务：setAutoCommit(boolean autoCommit) ：调用该方法设置参数为false，即开启事务
                                        在执行sql之前开启事务
                            * 提交事务：commit() ：当所有sql都执行完提交事务
                            * 回滚事务：rollback() ：在catch中回滚事务

        4.定义sql语句
            String sql = "select * from user where username = ? and password = ?";

        5.获取执行sql的对象 PreparedStatement
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                PreparedStatement：执行sql的对象(一般用这个有预编译的)
                    预编译的SQL：参数使用?作为占位符，提高 SQL 的执行效率，能解决SQL注入问题
                Statement：执行sql的对象(了解)，PreparedStatement是 Statement 的子接口

        6.设置参数
            pstmt1.setDouble(1,500);
            pstmt1.setInt(2,1);
                PreparedStatement给？赋值方法：
                    setXxx(参数1,参数2)  //参数1：？的位置 编号从1开始，参数2：？的值

        6.执行sql，接受返回结果，不需要传递sql语句
            ResultSet rs = pstmt.executeQuery();
                PreparedStatement执行sql方法：
                    1. boolean execute() ：可以执行任意的sql
                    2. int executeUpdate() ：执行DML（insert、update、delete）语句、DDL(create，alter、drop)语句
                        返回值：影响的行数，返回值>0的则执行成功，反之，则失败。
                    3. ResultSet executeQuery()  ：执行DQL（select)语句

        7.处理结果
            while(rs.next()){...}
                ResultSet：结果集对象,封装查询结果
                    boolean next(): 游标向下移动一行，判断当前行是否是最后一行末尾(是否有数据)，是返回false，不是则返回true
                    getXxx(参数):获取数据
                        * Xxx：代表数据类型   如： int getInt() ,	String getString()
                        * 参数：
                            1. int：代表列的编号,从1开始   如： getString(1)
                            2. String：代表列名称。 如： getDouble("balance")


        8.释放资源
            释放原则：先开的后关，后开的先关。 ResultSet  PreparedStatement  Connection
            在finally中释放
                if(... != null)     //
                rs.close();
                pstmt1.close();
                conn.close();






SQL 注入问题：
    用户输入的内容作为了 SQL 语句语法的一部分， 改变了原有 SQL 真正的意义， 以上问题称为 SQL 注入。
    要解决 SQL 注入就不能让用户输入的密码和我们的 SQL 语句进行简单的字符串拼接


*/


public class JDBC基础 {
}
