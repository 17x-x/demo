package servlet;

import model.Meetingroom;
import model.MeetingroomStatus;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import util.JDBCUtil;
import util.TemplateEngineUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toupdatemeetingroom")
public class ToUpdateMeetingroomServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String roomid = req.getParameter("roomid");
        String sql = "select * from meetingroom where roomid=?";
        List params = new ArrayList();
        List params_status=new ArrayList();
        ResultSet rs_status= JDBCUtil.execQuery("select * from meetingroomstatus",params_status);
        List<MeetingroomStatus> MeetingroomStatusList=new ArrayList<MeetingroomStatus>();
        params.add(roomid);
        ResultSet rs = JDBCUtil.execQuery(sql,params);
        Meetingroom meetingroom=new Meetingroom();
        try {
            if (rs.next()) {
                meetingroom.setRoomid(rs.getInt("roomid"));
                meetingroom.setRoomnum(rs.getInt("roomnum"));
                meetingroom.setRoomname(rs.getString("roomname"));
                meetingroom.setRoomcapcity(rs.getString("capacity"));
                meetingroom.setStatus(rs.getString("status"));
                meetingroom.setDescription(rs.getString("description"));
            }
            while (rs_status.next()){
                MeetingroomStatus meetingroomStatus=new MeetingroomStatus();
                meetingroomStatus.setStatus(rs_status.getInt(1));
                meetingroomStatus.setStatusname(rs_status.getString(2));
                MeetingroomStatusList.add(meetingroomStatus);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        //创建web上下文环境：请求，响应
        WebContext context = new WebContext(req, resp, req.getServletContext());
        context.setVariable("meetingroom", meetingroom);
        context.setVariable("MeetingroomStatusList", MeetingroomStatusList);
        //转向
        engine.process("updateMeetingroom.html", context, resp.getWriter());
    }
}
