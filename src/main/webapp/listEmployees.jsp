<%@ page import="model.Employee" %>
<%@ page import="java.util.List" %>
<%@page pageEncoding="GBK" %>
<%--<%@include file="login.html"%>--%>
<%!int a=99;%>
<html >
<meta charset="GBK">
<body>
<h2>欢迎你</h2>

<%--<%=request.getAttribute("employeeList")%>--%>
<table border="2" align="center">
    <thead>
    <tr>
        <th>员工编号</th>
        <th>员工姓名</th>
        <th>用户名</th>
        <th>手机</th>
        <th>邮箱</th>
        <th>地位</th>
        <th>部门标识</th>
        <th>密码</th>
        <th>角色</th>
    </tr>
    </thead>
    <tbody th:remove="all-but-first">


<%
    List<Employee> employeeList=(List) request.getAttribute("employeeList");
    for (Employee employee:employeeList){%>
        <tr align="center">
            <td><%=employee.getEmployeeId()%></td>
            <td><%=employee.getEmployeeName()%></td>
            <td><%=employee.getUsername()%></td>
            <td><%=employee.getPhone()%></td>
            <td><%=employee.getEmail()%></td>
            <td><%=employee.getStatus()%></td>
            <td><%=employee.getDepartmentId()%></td>
            <td><%=employee.getPassword()%></td>
            <td><%=employee.getRole()%></td>
        </tr>
    <%}%>

</table>

<%--<h2>你的密码是</h2>--%>
<%--<%=request.getParameter("pwd")%>--%>
<%--ctrl+shift+/--%>
<%--
<%
    for (int i=0;i<10;i++)
        out.println(i+1+"<br>");
%>
--%>
<%--<table border="1">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <td>number</td>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody>--%>
<%--    <tr>--%>
<%--        <td>1</td>--%>
<%--          </tr>--%>
<%--    <tr>--%>
<%--        <td>2</td>--%>
<%--    </tr>--%>
<%--    <tr>--%>
<%--        <td>3</td>--%>
<%--    </tr>--%>
<%--    </tbody>--%>
<%--</table>--%>

<%--<table border="2">--%>
<%--    <thead>--%>
<%--    <tr>--%>
<%--        <th>name</th>--%>
<%--        <th>email</th>--%>
<%--        <th>电话</th>--%>
<%--    </tr>--%>
<%--    </thead>--%>
<%--    <tbody th:remove="all-but-first">--%>
<%--        <%for (Employee employee:employeeList){%>--%>
<%--    <tr>--%>
<%--        <td><%=employee.getEmployeeName()%></td>--%>
<%--        <td><%=employee.getEmail()%></td>--%>
<%--        <td><%=employee.getPhone()%></td>--%>
<%--    </tr>--%>
<%--        <%}%>--%>

<%--</table>--%>

</body>
</html>
