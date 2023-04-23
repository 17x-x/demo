package servlet;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import util.TemplateEngineUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hi")
public class HelloWorldServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getOutputStream().print("Hello World!");
//    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //创建模板引擎
        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        //创建web上下文环境：请求，响应
        WebContext context = new WebContext(req, res, req.getServletContext());
        //设置字符集
        res.setCharacterEncoding("utf-8");
        //设置变量
        context.setVariable("recipient", "Yiibai");
        //设置attibute变量
        //req.setAttribute("name","apolo");
        //转向
        engine.process("index.html", context, res.getWriter());

    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
//    }
}
