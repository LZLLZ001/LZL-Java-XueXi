/*
3点
*/


package cn.itcast.day06.test;




public class Student {
    private int num;
    private String name;
    private boolean isman;

/*
    1.
    类作为成员变量时并不是在类中定义类
    类的定义在另一个文件中，这里直接调用
      private 类名 对象名
*/
    private Room room;

    public Student(int num, String name, boolean isman, Room room) {
        this.num = num;
        this.name = name;
        this.isman = isman;
/*
    2.
    构造时直接
    this.类对象名=传入类对象名;
    就可以了
*/
        this.room = room;
        System.out.println("daicangouzhao");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

/*
    3.
    get方法直接
    return room;
 */
    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIsman() {
        return isman;
    }

    public void setIsman(boolean isman) {
        this.isman = isman;
    }

    public Student(){
        System.out.println("wucan");
    }

    public void fun1(){
        System.out.println("fun1");
    }

    public int fun2(int a){
        return 2*a;
    }

    public Room fun3(){
        Room room =new Room();
        room.setRoomname(1);
        room.setRoomnum(50);
        return room;
    }



}
