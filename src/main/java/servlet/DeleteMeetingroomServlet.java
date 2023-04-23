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

@WebServlet("/delmeetingroom")
public class DeleteMeetingroomServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取employeeid的值，连接数据库，传delete的sql语句和参数列表，执行，转向到显示员工信息页面
        int meetingroomId= Integer.parseInt(req.getParameter("id"));
        String sql="delete from meetingroom where roomId=?";
        List params=new ArrayList<>();
        params.add(meetingroomId);
        JDBCUtil.execStatement(sql,params);
        //此处选择servlet
        //3种重定向，req，resp，thymeleaf（1.网页；2.网页位于WEB-INF/templates;3.网页含有th:元素）
        //req.getRequestDispatcher("ListEmpoyeeServlet.html").forward(req,resp);
        resp.sendRedirect("listmeetingroom");
    }

}

