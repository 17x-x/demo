package servlet;

import model.Meetingroom;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import util.JDBCUtil;
import util.TemplateEngineUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//基于注解的servlet访问形式
//注解，标明解释，运行的时候被嵌入的代码
@WebServlet("/listmeetingroom")
public class ListMeetingroomServlet extends HttpServlet {
    //初始化，延迟加载delay load，lazy load,--即时加载,tomcat启动加载
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("my ListMeetingroomServlet is initialing");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql ="select * from meetingroom";
        List params=new ArrayList<>();
        ResultSet rs= JDBCUtil.execQuery(sql,params);
        List<Meetingroom> meetingroomList=new ArrayList<Meetingroom>();
        try {
            while (rs.next()){
                Meetingroom meetingroom=new Meetingroom();
                meetingroom.setRoomid(rs.getInt(1));
                meetingroom.setRoomnum(rs.getInt(2));
                meetingroom.setRoomname(rs.getString(3));
                meetingroom.setRoomcapcity(rs.getString(4));
                meetingroom.setStatus(rs.getString(5));
                meetingroom.setDescription(rs.getString(6));
                meetingroomList.add(meetingroom);
            }
            //创建模板引擎
            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
            //创建web上下文环境：请求，响应
            WebContext context = new WebContext(req, resp, req.getServletContext());
            //设置字符集
            resp.setCharacterEncoding("utf-8");
            //设置变量
            context.setVariable("meetingroomList", meetingroomList);
            //转向
            engine.process("listMeetingrooms.html", context, resp.getWriter());
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //销毁
    @Override
    public void destroy() {
        System.out.println("my ListMeetingroomServlet is destroyed");
    }

}
