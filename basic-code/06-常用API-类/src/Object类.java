/*
java.lang.Object
    类 Object 是类层次结构的根(父)类。
    每个类(Person,Student...)都使用 Object 作为超(父)类。
    所有对象（包括数组）都实现这个类的方法。

toString方法：
    直接打印对象的名字,其实就是调用对象的toString,
    看一个类是否重写了toString,直接打印这个类的对象即可,
    如果没有重写toString方法那么打印的是对象的地址值.

equals方法:
    boolean equals(Object obj) 指示其他某个对象是否与此对象“相等”。
            equals方法源码:
                public boolean equals(Object obj) {
                    return (this == obj);
                }
        参数:p1.equals(p2)
            Object obj:可以传递任意的对象
            == 比较运算符,返回的是一个布尔值 true false
            基本数据类型:比较的是值
            引用数据类型:比价的是两个对象的地址值,需要进行重写。
                        因为多态(无法使用子类特有内容)需要进行向下转型吧obj类型转换为需要类型。
       this是谁?那个对象调用的方法,方法中的this就是那个对象;p1调用的equals方法所以this就是p1
       obj是谁?传递过来的参数p2
       this==obj -->p1==p2

       @Override(写法1，理解用)
        public boolean equals(Object obj) {
            //增加一个判断,传递的参数obj如果是this本身,直接返回true,提高程序的效率
            if(obj==this){
                return true;
            }

            //增加一个判断,传递的参数obj如果是null,直接返回false,提高程序的效率
            if(obj==null){
                return false;
            }

            //增加一个判断,防止类型转换一次ClassCastException
            if(obj instanceof Person){
                //使用向下转型,把obj转换为Person类型
                Person p = (Person)obj;
                //比较两个对象的属性,一个对象是this(p1),一个对象是p(obj->p2)
                boolean b = this.name.equals(p.name) && this.age==p.age;
                return b;
            }
            //不是Person类型直接返回false
            return false;
        }

        @Override(写法2，记这个，可用快捷键自动重写)
        public boolean equals(Object o) {
            if (this == o) return true;
            //getClass() != o.getClass() 使用反射技术,判断o是否是Person类型  等效于 obj instanceof Person
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

 Objects类
    在JDK7添加了一个Objects工具类，它提供了一些方法来操作对象，它由一些静态的实用方法组成，
    这些方法是null-save（空指针安全的）或null-tolerant（容忍空指针的），
    用于计算对象的hashcode、返回对象的字符串表示形式、比较两个对象。


 */




import com.itheima.demo01.Object.Person;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;





public class Object类 {
    public static void main(String[] args) {
        /*
            Person类默认继承了Object类,所以可以使用Object类中的toString方法
            String toString() 返回该对象的字符串表示。
         */
        Person p = new Person("张三",18);
        String s = p.toString();
        System.out.println(s);//com.itheima.demo01.Object.Person@75412c2f | abc | Person{name=张三 ,age=18}

        //直接打印对象的名字,其实就是调用对象的toString  p=p.toString();
        System.out.println(p);//com.itheima.demo01.Object.Person@5f150435 | abc | Person{name=张三 ,age=18}

        //看一个类是否重写了toString,直接打印这个类的对象即可,如果没有重写toString方法那么打印的是对象的地址值
        Random r = new Random();
        System.out.println(r);//java.util.Random@3f3afe78  没有重写toString方法

        Scanner sc = new Scanner(System.in);
        System.out.println(sc);//java.util.Scanner[delimiters=\p{javaWhitespace}+..  重写toString方法

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);//[1, 2, 3]  重写toString方法
    }

}
