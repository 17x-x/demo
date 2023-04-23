package servlet;

import util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取新增页面register.html传过来的值
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        //定义inser的sql
        String sql="insert into employee(username,password) values(?,?)";
        //吧传过来的值加到参数变量列表
        List params=new ArrayList();
        params.add(username);
        params.add(password);
        //调用JDBCUtil.exeStatement,执行sql语句
        JDBCUtil.execStatement(sql,params);
        //跳转查看
        resp.sendRedirect("success.html");
    }
}
