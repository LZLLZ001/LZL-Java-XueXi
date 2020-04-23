/*
如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。多个对象共享同一份数据。

一旦使用static修饰成员方法，那么这就成为了静态方法。静态方法不属于对象，而是属于类的。

如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用它。
如果有了static关键字，那么不需要创建对象，直接就能通过类名称来使用它。

无论是成员变量，还是成员方法。如果有了static，都推荐使用类名称进行调用。
    静态变量：类名称.静态变量
    静态方法：类名称.静态方法()

    注意事项：
        1. 静态不能直接访问非静态。(成员方法可以访问静态变量,静态方法不能直接访问非静态变量)
            原因：因为在内存当中是【先】有的静态内容，【后】有的非静态内容。
            “先人不知道后人，但是后人知道先人。”
        2. 静态方法当中不能用this。
            原因：this代表当前对象，通过谁调用的方法，谁就是当前对象。
        3. 静态方法可在定义时直接初始化，或者在静态代码块中一起初始化，
            不过在构造方法中不用写入静态变量
            get/set方法需要写


静态代码块：
    public class 类名称 {
        private static int yy=1;
        static {
            // 内容:一般为一次性对静态成员变量进行赋值
            yy=2;
        }
    }
    特点：当第一次用到本类时，静态代码块执行唯一的一次。
    静态内容总是优先于非静态，所以静态代码块比构造方法先执行。

    静态代码块的典型用途：
    用来一次性地对静态成员变量进行赋值。
 */

import cn.itcast.day08.demo03.Demo02StaticMethod;
import cn.itcast.day08.demo03.MyClass;

public class static静态变量关键字 {
    public static void main(String[] args) {
        MyClass obj = new MyClass(); // 首先创建对象
        // 然后才能使用没有static关键字的内容
        obj.method();

        // 对于静态方法来说，可以通过对象名进行调用，也可以直接通过类名称来调用。
        obj.methodStatic(); // 正确，不推荐，这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
        MyClass.methodStatic(); // 正确，推荐

        // 对于本类当中的静态方法，可以省略类名称
        myMethod();
        Demo02StaticMethod.myMethod(); // 完全等效
    }

    public static void myMethod() {
        System.out.println("自己的方法！");
    }
}

/*
//位置于cn.itcast.day08.demo03.MyClass;已去掉public
 class MyClass1 {

    int num; // 成员变量
    static int numStatic; // 静态变量

    // 成员方法
    public void method() {
        System.out.println("这是一个成员方法。");
        // 成员方法可以访问成员变量
        System.out.println(num);
        // 成员方法可以访问静态变量
        System.out.println(numStatic);
    }

    // 静态方法
    public static void methodStatic() {
        System.out.println("这是一个静态方法。");
        // 静态方法可以访问静态变量
        System.out.println(numStatic);
        // 静态不能直接访问非静态【重点】
//        System.out.println(num); // 错误写法！

        // 静态方法中不能使用this关键字。
//        System.out.println(this); // 错误写法！
    }

}

 */