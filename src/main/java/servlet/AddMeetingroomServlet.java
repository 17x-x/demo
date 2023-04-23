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

@WebServlet("/addmeetingroom")
public class AddMeetingroomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
//        String roomid=req.getParameter("roomid");
        String roomnum=req.getParameter("roomnum");
        String roomname=req.getParameter("roomname");
        String capacity=req.getParameter("capacity");
        String status=req.getParameter("status");
        String description=req.getParameter("description");
        List params=new ArrayList();
//        params.add(roomid);
        params.add(roomnum);
        params.add(roomname);
        params.add(capacity);
        params.add(status);
        params.add(description);
        String sql="insert into meetingroom(roomnum,roomname,capacity,status,description) values(?,?,?,?,?)";
        //调用JDBCUtil.exeStatement,执行sql语句
        JDBCUtil.execStatement(sql,params);
        //跳转查看
        resp.sendRedirect("toaddmeetingroom");
    }
}
