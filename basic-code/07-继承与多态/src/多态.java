/*
多态好处：提高了代码的维护性(继承保证)、提高了代码的扩展性(由多态保证)

多态：同一操作作用于不同的对象，可以有不同的解释，产生不同的执行结果。
        在运行时，可以通过指向基类的指针，来调用实现派生类中的方法。(通过基类指针调用子类方法)
        因为是用基类指针，所以不能调用实现派生类的新方法

一个对象拥有多种形态，代码当中体现多态性：父类引用指向子类对象。
    格式：
        父类名称 对象名 = new 子类名称();
    或者：
        接口名称 对象名 = new 实现类名称();


访问成员变量的两种方式：
    1. 直接通过对象名称访问成员变量(对象名称.变量)：看等号左边是谁(谁点用谁。点指的是左边)，优先用谁，没有则向上找
        Fu A=new Zi(); A.a; //a用的是Fu的a
        注意：无法直接使用子类成员变量，成员变量无法覆盖，可通过方法间接使用
    2. 间接通过成员方法访问成员变量(对象名称.方法)：看该方法属于谁(new谁用谁。new指的是右边)，优先用谁，没有则向上找。
        Fu A=new Zi(); A.fun; //a优先用的是Zi覆盖后的fun
        注意：无法使用子类新定义的方法，只能使用覆盖的方法


多态的成员方法的访问规则是：
    new谁用谁，没有则向上找。
    注意：无法使用子类新定义的方法，只能使用覆盖的方法


对比一下：
    成员变量：编译看左边，运行还看左边。
    成员方法：编译看左边，运行看右边。


多态好处：无论右边new的时候换成哪个子类对象，等号左边的调用方法(变量不符合此规则)写法都不会改变(只是写法统一，实际方法不同)
    例如：Cat one = new Cat();      Animal one = new Cat();
         one.eat();                one.eat();
         Dog two = new Dog();      Animal two = new Dog();
         two.eat();                two.eat();
         左边就整齐易读很多，而右侧的方法实际看右边new谁


向上转型
    对象向上转型其实就是多态：
    格式：父类名称 对象名 = new 子类名称(); //还有接口     Animal one = new Cat();
    含义：右侧创建一个子类对象，把它当做父类来看待。        创建了一只猫，当做动物看待

    向上转型一定是安全的，但对象一旦向上转型为父类，就无法调用子类原本特有的内容。
    解决方案：用对象的向下转型【还原】。

向下转型【还原】
    格式：子类名称 对象名 = (子类名称)父类名称;             Cat one = (Cat)Animal;
    含义：将父类对象【还原】成为本来的子类对象。            本来是猫，被当做动物了，还原成为本来的猫

    必须保证对象向下转型的必须是本来创建是的类型(必须原路返回):使用instanceof, 分类判断调用。
        格式：
        对象 instanceof 类名称   //得到一个boolean值结果
            public static void fun(Animal animal){
                if (animal instanceof Cat) {
                    Cat cat = (Cat) animal;
                    cat.catchMouse();
                }
                if (animal instanceof Dog) {
                .........
            }



 */


import cn.itcast.day10.demo05.Fu;
import cn.itcast.day10.demo05.Zi;
import cn.itcast.day10.demo06.Animal;
import cn.itcast.day10.demo06.Cat;
import cn.itcast.day10.demo06.Dog;

public class 多态 {

    public static void main(String[] args) {
        // 使用多态的写法，父类引用指向子类对象
        Fu obj = new Zi();
        System.out.println(obj.num); // 父：10
//        System.out.println(obj.age); // 错误写法！
        System.out.println("=============");

        // 子类没有覆盖重写，就是父：10
        // 子类如果覆盖重写，就是子：20
        obj.showNum();

        obj.method(); // 父子都有，优先用子
        obj.methodFu(); // 子类没有，父类有，向上找到父类

        // 编译看左边，左边是Fu，Fu当中没有methodZi方法，所以编译报错。
//        obj.methodZi(); // 错误写法！

//*************************************************************************************************************
        // 对象的向上转型，就是：父类引用指向之类对象。
        Animal animalone = new Cat(); // 本来创建的时候是一只猫
        animalone.eat(); // 猫吃鱼

//        animal.catchMouse(); // 错误写法！

        // 向下转型，进行“还原”动作
        Cat cat = (Cat) animalone;
        cat.catchMouse(); // 猫抓老鼠

        // 下面是错误的向下转型
        // 本来new的时候是一只猫，现在非要当做狗
        // 错误写法！编译不会报错，但是运行会出现异常：
        // java.lang.ClassCastException，类转换异常
        Dog dog = (Dog) animalone;

//*************************************************************************************************************
        Animal animal = new Dog(); // 本来是一只狗
        animal.eat(); // 狗吃SHIT

        // 如果希望掉用子类特有方法，需要向下转型
        // 判断一下父类引用animal本来是不是Dog
        if (animal instanceof Dog) {
            Dog dog1 = (Dog) animal;
            dog1.watchHouse();
        }
        // 判断一下animal本来是不是Cat
        if (animal instanceof Cat) {
            Cat cat1 = (Cat) animal;
            cat1.catchMouse();
        }

        giveMeAPet(new Dog());
    }

    public static void giveMeAPet(Animal animal) {
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMouse();
        }
    }
}
