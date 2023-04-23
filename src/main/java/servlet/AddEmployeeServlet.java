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

@WebServlet("/addemployee")
public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //获取新增页面addEmployee.html传过来的值；
        String employeeName=req.getParameter("employeeName");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        int departmentId= Integer.parseInt(req.getParameter("departmentId"));
        String status=req.getParameter("status");
        String role=req.getParameter("role");
        //把传过来的值加到参数变量列表
        List params=new ArrayList();
        params.add(employeeName);
        params.add(username);
        params.add(password);
        params.add(email);
        params.add(phone);
        params.add(departmentId);
        params.add(status);
        params.add(role);
        //定义insert的sql
        String sql="insert into employee(employeeName,username,PASSWORD,email,phone,departmentId,status,role) values(?,?,?,?,?,?,?,?)";
        //调用JDBCUtil.execStatement，执行sql语句
        JDBCUtil.execStatement(sql,params);
        //跳转查看
        resp.sendRedirect("toaddemployee");
    }
}
