package servlet;

import model.Department;
import model.Employee;
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
import java.util.*;


@WebServlet("/toupdateemployee")
public class ToUpdateEmployeeServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        String id=req.getParameter("id");
        //根据employeeId找到这条员工记录
//        String sql="select * from employee where employeeId=?";
//        String sql_department ="select * from department";
//        String sql_status ="select * from employeestatus";
//        String sql_role ="select * from employeerole";
        List params=new ArrayList();
        List params_department=new ArrayList();
        List params_status=new ArrayList();
        List params_role=new ArrayList();
        params.add(id);
        ResultSet rs= JDBCUtil.execQuery("select * from employee where employeeId=?",params);
        ResultSet rs_department= JDBCUtil.execQuery("select * from department",params_department);
        ResultSet rs_status= JDBCUtil.execQuery("select * from employeestatus",params_status);
        ResultSet rs_role= JDBCUtil.execQuery("select * from employeerole",params_role);
        //将待修改的数值赋给employee
        Employee employee=new Employee();
        List<Department> departmentList=new ArrayList<Department>();
        List<EmployeeStatus> employeeStatusList=new ArrayList<EmployeeStatus>();
        List<EmployeeRole> employeeRoleList=new ArrayList<EmployeeRole>();
            try {
                if(rs.next()){
                    employee.setEmployeeId(rs.getInt("employeeId"));
                    employee.setEmployeeName(rs.getString("employeeName"));
                    employee.setUsername(rs.getString("username"));
                    employee.setEmail(rs.getString("email"));
                    employee.setPhone(rs.getString("phone"));
                    employee.setPassword(rs.getString("password"));
                    employee.setDepartmentId(rs.getInt("departmentId"));
                    employee.setStatus(rs.getString("status"));
                    employee.setRole(rs.getString("role"));

                }
                while (rs_department.next()){
                    Department department=new Department();
                    department.setDepartmentId(rs_department.getInt(1));
                    department.setDepartmentName(rs_department.getString(2));
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
            } catch (Exception e) {
                e.printStackTrace();
            }
            //跳转到updateEmployee.html页面
            TemplateEngine engine= TemplateEngineUtil.getTemplateEngine(req.getServletContext());
            WebContext context=new WebContext(req,resp,req.getServletContext());
            context.setVariable("employee",employee);
            context.setVariable("departmentList", departmentList);
            context.setVariable("employeeStatusList", employeeStatusList);
            context.setVariable("employeeRoleList", employeeRoleList);
            engine.process("updateEmployee.html",context,resp.getWriter());


    }
}
