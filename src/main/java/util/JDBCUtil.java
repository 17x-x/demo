package util;

import java.sql.*;
import java.util.List;

//可复用
public class JDBCUtil {
    private static  Connection connection=null;
    private static PreparedStatement preparedStatement=null;
    private static String url="jdbc:mysql://localhost:3306/meeting?characterEncoding=utf-8&serverTimezone=UTC";
    //为了安全起见，最好换掉用户和密码；为了更安全，用户名和密码保存在某个加密文件中
    private static String  username="root";
    private static String password="";
    //获取数据库连接
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
        finally {
            return connection;
        }
    }
    //关闭连接
    public static void closeAll() {
        try {
            preparedStatement.close();
            connection.close();
            ;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //执行 insert,update,delete的sql语句
    public static int execStatement(String sql, List<Object> params){
        try {
            preparedStatement=getConnection().prepareStatement(sql);
            //为sql语句的？循环赋参
            for (int i=0;i<params.size();i++)
                preparedStatement.setObject(i+1,params.get(i));
            return  preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return -1;
        }
    }
    //执行select的sql语句,返回ResultSet
    public static ResultSet execQuery(String sql, List<Object> params){
        try {
            preparedStatement=getConnection().prepareStatement(sql);
            //为sql语句的？循环赋参
            for (int i=0;i<params.size();i++)
                preparedStatement.setObject(i+1,params.get(i));
            return  preparedStatement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
    }

}
