package servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import util.TemplateEngineUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        TemplateEngine engine= TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context=new WebContext(req,resp,req.getServletContext());
        engine.process("employeeindex.html",context,resp.getWriter());
    }
}
