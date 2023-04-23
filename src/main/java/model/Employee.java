package model;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
//定义员工表，对应meeting数据库的employee表
public class Employee{
    //定义员工属性，对应表中的9个列名
    private int employeeId;
    private String employeeName;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String status;
    private int departmentId;
    private String role;
    //按alt+insert键，生成构造函数，get set方法，toString()方法


   /* public Employee(int employeeId, String employeeName, String username, String password, String phone, String email, String status, int departmentId, String role) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.departmentId = departmentId;
        this.role = role;
    }*/

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "员工：" +
                "员工号=" + employeeId +
                ", 姓名='" + employeeName + '\'' +
                ", 登录名='" + username + '\'' +
                ", 密码='" + password + '\'' +
                ", 电话='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", 状态='" + status + '\'' +
                ", 部门号=" + departmentId +
                ", 角色='" + role + '\''
                ;
    }
}
