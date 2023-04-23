package servlet;

import model.Department;
import model.EmployeeRole;
import model.EmployeeStatus;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/toaddemployee")

public class ToAddEmployeeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          //取模板引擎
        TemplateEngine engine=TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        //构建应用上下文环境
        resp.setCharacterEncoding("UTF-8");
        WebContext context=new WebContext(req,resp,req.getServletContext());
        List params=new ArrayList();
        List params_status=new ArrayList();
        List params_role=new ArrayList();
        List<Department> departmentList=new ArrayList<Department>();
        List<EmployeeStatus> employeeStatusList=new ArrayList<EmployeeStatus>();
        List<EmployeeRole> employeeRoleList=new ArrayList<EmployeeRole>();
        ResultSet rs=JDBCUtil.execQuery("select * from department",params);
        ResultSet rs_status= JDBCUtil.execQuery("select * from employeestatus",params_status);
        ResultSet rs_role= JDBCUtil.execQuery("select * from employeerole",params_role);
                    try {
                       while (rs.next()){
                           Department department=new Department();
                           department.setDepartmentId(rs.getInt(1));
                           department.setDepartmentName(rs.getString(2));
                           departmentList.add(department);
                       }
                        while (rs_status.next()){
                            EmployeeStatus employeeStatus=new EmployeeStatus();
                            employeeStatus.setStatus(rs_status.getInt(1));
                            employeeStatus.setStatusname(rs_status.getString(2));
                            employeeStatusList.add(employeeStatus);
                        }
                        while (rs_role.next()){
                            EmployeeRole employeeRole=new EmployeeRole();
                            employeeRole.setRole(rs_role.getInt(1));
                            employeeRole.setRolename(rs_role.getString(2));
                            employeeRoleList.add(employeeRole);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
        context.setVariable("departmentList",departmentList);
        context.setVariable("employeeStatusList", employeeStatusList);
        context.setVariable("employeeRoleList", employeeRoleList);
        //带着环境信息，重定向到addEmployee.html
        engine.process("addEmployee.html",context,resp.getWriter());

    }
}
