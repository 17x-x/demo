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

@WebServlet("/delemployee")
public class DeleteEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取employeeid的值，连接数据库，传delete的sql语句和参数列表，执行，转向到显示员工信息页面
        int employeeId=Integer.parseInt(req.getParameter("id"));
        String sql="delete from employee where employeeId=?";
        List params=new ArrayList<>();
        params.add(employeeId);
        JDBCUtil.execStatement(sql,params);
        //3种重定向,req，resp，thymeleaf(1.页面;2.网页位于WEB-INF/templates;3.网页含有th:元素)
//        req.getRequestDispatcher("list").forward(req,resp);
        resp.sendRedirect("listemployee");
    }
}
