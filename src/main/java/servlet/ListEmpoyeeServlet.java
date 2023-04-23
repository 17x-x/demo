package servlet;

import model.Employee;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import util.JDBCUtil;
import util.TemplateEngineUtil;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/listemployee")
public class ListEmpoyeeServlet extends HttpServlet {
    //初始化


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sql="select * from employee";
        List params=new ArrayList<>();
        ResultSet rs= JDBCUtil.execQuery(sql,params);
        List<Employee> employeeList=new ArrayList<Employee>();


        try {
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt(1));
                employee.setEmployeeName(rs.getString(2));
                employee.setUsername(rs.getString(3));
                employee.setPhone(rs.getString(4));
                employee.setEmail(rs.getString(5));
                employee.setStatus(rs.getString(6));
                employee.setDepartmentId(rs.getInt(7));
                employee.setPassword(rs.getString(8));
                employee.setRole(rs.getString(9));
                //将每一个员工加入到employee列表
                employeeList.add(employee);
            }
//            //添加一个attribute属性，键值对，<employeeList，员工对象列表>
//            req.setAttribute("employeeList",employeeList);
//            //转向到显示员工信息页面
//            resp.setCharacterEncoding("gbk");
////            resp.sendRedirect("listEmployees.jsp");
//            req.getRequestDispatcher("listEmployees.jsp").forward(req,resp);
            //创建模板引擎
            TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
            //创建web上下文环境:请求，响应
            WebContext context = new WebContext(req, resp, req.getServletContext());
            //设置字符集
            resp.setCharacterEncoding("utf-8");
            //设置变量
            context.setVariable("employeeList", employeeList);
            //转向
            engine.process("listEmployees.html", context, resp.getWriter());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }





    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("my listEmpoyeeServlet is initialing");
    }
    //服务
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        //打印在控制台上
//        System.out.println("my listEmpoyeeServlet is servicing");
//        //输出在浏览器上
//        resp.getWriter().println("my listEmpoyeeServlet is servicing");
//    }
    //销毁
    @Override
    public void destroy() {
        System.out.println("my listEmpoyeeServlet is destroyed");
    }
}
