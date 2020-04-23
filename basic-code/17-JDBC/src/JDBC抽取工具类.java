/*

什么时候自己创建工具类？
    如果一个功能经常要用到，则把这个功能做成一个工具类，可以在不同的地方重用。
    做法：抽取公共代码，写成多个静态方法


目的：简化书写
* 分析：
	1. 注册驱动抽取
	2. 抽取一个方法获取连接对象
    3. 抽取一个方法释放资源


1. 注册驱动抽取
    不想传递参数（麻烦），还得保证工具类的通用性。
    * 解决：配置文件，只需要读取一次即可拿到这些值。使用静态代码块
    实际上新版本已经不需要注册，这里学习读配置文件的写法
    public class JDBCUtils {
        private static String url;
        private static String user;
        private static String password;
        private static String driver;

        static{
            //读取资源文件，获取值。

            try {
                //1. 创建Properties集合类。
                Properties pro = new Properties();

                //2. 获取src路径下的文件的方式--->ClassLoader 类加载器
                ClassLoader classLoader = JDBCUtils.class.getClassLoader();
                URL res  = classLoader.getResource("jdbc.properties");
                String path = res.getPath();
                pro.load(new FileReader(path));
                //3. 获取数据，赋值
                url = pro.getProperty("url");
                user = pro.getProperty("user");
                password = pro.getProperty("password");
                driver = pro.getProperty("driver");
                //4. 注册驱动
                Class.forName(driver);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


2. 抽取一个方法获取连接对象
       public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
       }

3. 释放资源
    public static void close(Statement stmt,Connection conn){
        closs(null,stmt,conn);
    }

    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }



*/


public class JDBC抽取工具类 {
}
