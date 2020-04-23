/*
3点
*/


package cn.itcast.day06.test;

import org.junit.Test;

public class TestLei {
    @Test
    public void testLei(){
        Student stu1 = new Student();
        System.out.println(stu1);
        System.out.println(stu1.getName());
        System.out.println(stu1.getNum());
        System.out.println(stu1.isIsman());
        System.out.println(stu1.getRoom());
        stu1.setName("KZK");
        stu1.setNum(2);
        stu1.setIsman(true);
        stu1.setRoom(new Room(2,100));
        System.out.println(stu1);
        System.out.println(stu1.getName());
        System.out.println(stu1.getNum());
        System.out.println(stu1.isIsman());
/*
    1.
    这里get到的是成员类，打印的是地址值
*/
        System.out.println(stu1.getRoom());
/*
    2.
    先get成员类，再次get才能得到成员类中的变量
*/
        System.out.println(stu1.getRoom().getRoomname());
        System.out.println(stu1.getRoom().getRoomnum());

        stu1.fun1();
        int a=stu1.fun2(5);
        System.out.println(a);
        Room room2=stu1.fun3();
        System.out.println(room2.getRoomname());
        System.out.println(room2.getRoomnum());
/*
    3.
    Test也能调用其他地方的函数
*/
        int b=fun4(stu1.getRoom());
        System.out.println(b);

    }

    public int fun4(Room room){
        return room.getRoomnum();
    }


}
