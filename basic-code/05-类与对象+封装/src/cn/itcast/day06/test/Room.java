package cn.itcast.day06.test;

public class Room {
    private int roomname;
    private int roomnum;

    public int getRoomname() {
        return roomname;
    }

    public void setRoomname(int roomname) {
        this.roomname = roomname;
    }

    public int getRoomnum() {
        return roomnum;
    }

    public void setRoomnum(int roomnum) {
        this.roomnum = roomnum;
    }

    public Room() {
    }

    public Room(int roomname, int roomnum) {
        this.roomname = roomname;
        this.roomnum = roomnum;
    }

    public void roomfun(){
        System.out.println("room");
    }

}
