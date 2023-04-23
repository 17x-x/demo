package servlet;

import util.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;

@WebServlet("/updateemployee")
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取新增页面addEmployee.html传过来的值
        req.setCharacterEncoding("utf-8");
        int employeeId=Integer.parseInt(req.getParameter("employeeId"));
        String employeeName=req.getParameter("employeeName");
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        String phone=req.getParameter("phone");
        String password=req.getParameter("password");
        int departmentId= Integer.parseInt(req.getParameter("departmentId"));
        String status=req.getParameter("status");
        String role=req.getParameter("role");
        List params=new ArrayList();
        //定义sql语句和参数变量列表
        String sql="update employee set employeeName=?,username=?,email=?,phone=?,password=?,departmentId=?,status=?,role=? where employeeId=?";
        params.add(employeeName);
        params.add(username);
        params.add(email);
        params.add(phone);
        params.add(password);
        params.add(departmentId);
        params.add(status);
        params.add(role);
        params.add(employeeId);
        //执行更新
        JDBCUtil.execStatement(sql,params);
        //跳转到ListEmployeeServlet
        resp.sendRedirect("listemployee");

    }
}
