package servlet;

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

@WebServlet("/toaddmeetingroom")
public class ToAddMeetingroomServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        //创建web上下文环境：请求，响应
        WebContext context = new WebContext(req, resp, req.getServletContext());
        List params_status=new ArrayList();
        List<MeetingroomStatus> MeetingroomStatusList=new ArrayList<MeetingroomStatus>();
        ResultSet rs_status= JDBCUtil.execQuery("select * from meetingroomstatus",params_status);
        try {
            while (rs_status.next()){
                MeetingroomStatus meetingroomStatus=new MeetingroomStatus();
                meetingroomStatus.setStatus(rs_status.getInt(1));
                meetingroomStatus.setStatusname(rs_status.getString(2));
                MeetingroomStatusList.add(meetingroomStatus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.setCharacterEncoding("utf-8");
        context.setVariable("MeetingroomStatusList", MeetingroomStatusList);
        //转向
        engine.process("addMeetingroom.html", context, resp.getWriter());
    }
}
