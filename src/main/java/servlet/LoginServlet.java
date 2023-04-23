package servlet;

import util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //功能1：用户交互
        String username=req.getParameter("username");
        String pwd=req.getParameter("pwd");
        System.out.println(req.getRemoteUser());
        //如何访问数据库
        String sql="select * from employee where username=? and password=?";
        List params=new ArrayList<>();
        params.add(username);
        params.add(pwd);
        ResultSet rs= JDBCUtil.execQuery(sql,params);
        //功能：控制流转，如果rs不为空，就说明在数据库里成功找到了一个人，用户名和密码都匹配
        try{
            if(rs.next()) {
                //登录成功
                //获取session对象
                HttpSession session =req.getSession();
                //设置session有效的对象
                session.setAttribute("username",username);
//                req.getRequestDispatcher("employeeindex.html").forward(req,resp);
                resp.sendRedirect("index");
//                resp.setCharacterEncoding("gbk");
//                resp.getWriter().write("<br>欢迎你:" +rs.getString(2)+
//                        "<br>你的密码为:" + rs.getString(8)+"<br>你的手机号码为:" +
//                        rs.getString(4)+"<br>你的邮箱为:" + rs.getString(5));
            }
            else
                //登陆失败
                req.getRequestDispatcher("fail.html").forward(req,resp);
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }


    }
}
