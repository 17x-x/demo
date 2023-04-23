package model;

public class EmployeeStatus {
    private int status;
    private String statusname;

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getStatusname() {
        return statusname;
    }
    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }
    @Override
    public String toString() {
        return "员工状态：" +
                "状态=" + status +
                ", 状态名=" + statusname +'\''
                ;
    }
}
