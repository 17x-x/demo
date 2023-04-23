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

@WebServlet("/updatemeetingroom")
public class UpdateMeetingroomServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int roomid=Integer.parseInt(req.getParameter("roomid"));
        int roomnum=Integer.parseInt(req.getParameter("roomnum"));
        String roomname=req.getParameter("roomname");
        String capacity=req.getParameter("capacity");
        String status=req.getParameter("status");
        String description=req.getParameter("description");
        List params=new ArrayList();
        String sql="update meetingroom set roomnum=?,roomname=?,capacity=?,status=?,description=? where roomid=?";

        params.add(roomnum);
        params.add(roomname);
        params.add(capacity);
        params.add(status);
        params.add(description);
        params.add(roomid);
        //执行更新
        JDBCUtil.execStatement(sql,params);
        //跳转
        resp.sendRedirect("listmeetingroom");
    }
}
