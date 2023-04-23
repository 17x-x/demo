package model;

//定义员工表，对应meeting数据库的employee表
public class Meetingroom{
    //定义员工属性，对应表中的9个列名
    private int roomid;
    private int roomnum;
    private String roomname;
    private String roomcapcity;
    private String status;
    private String description;

    public int getRoomid() {
        return roomid;
    }
    public void setRoomid(int roomid) {
        this.roomid = roomid;
    }
    public int getRoomnum() {
        return roomnum;
    }
    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }
    public String getRoomname() {
        return roomname;
    }
    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }
    public String getRoomcapcity() {
        return roomcapcity;
    }
    public void setRoomcapcity(String roomcapcity) {
        this.roomcapcity = roomcapcity;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    //按alt+insert键，生成构造函数，get set方法，toString()方法
    @Override
    public String toString() {
        return "会议室：" +
                "会议室号=" + roomid +
                ", 房间数='" + roomnum + '\'' +
                ", 房间名='" + roomname + '\'' +
                ", 容量'" + roomcapcity + '\'' +
                ", 状态='" + status + '\'' +
                ", description='" + description + '\''
                ;
    }
}

