package model;

public class EmployeeRole {
    private int role;
    private String rolename;

    public int getRole() {
        return role;
    }
    public void setRole(int role) {
        this.role = role;
    }
    public String getRolename() {
        return rolename;
    }
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
    @Override
    public String toString() {
        return "员工状态：" +
                "状态=" + role +
                ", 状态名=" + rolename +'\''
                ;
    }
}
