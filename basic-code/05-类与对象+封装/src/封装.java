/*
面向对象三大特征：封装、继承、多态。

封装就是将一些细节信息隐藏起来，对于外界不可见。
封装性在Java当中的体现：
    1. 方法就是一种封装
    2. 关键字private也是一种封装


private关键字:
    能将修饰的东西私有化，本类当中仍然可以随意访问，本类范围之外不能再直接访问。

    间接访问private成员变量：定义一对儿Getter/Setter方法
        必须叫setXxx或者是getXxx命名规则(只有boolean类型的getXxx改为isXxx)。
            对于Getter来说，不能有参数，返回值类型和成员变量对应；
            对于Setter来说，不能有返回值，参数类型和成员变量对应。

    即只有自己有权限定义访问和修改规则，其他人只有符合规定的才能间接访问和修改。


this关键字：
    当方法的局部变量和类的成员变量重名的时候，根据“就近原则”，优先使用局部变量。
    如果需要访问本类当中的成员变量，需要使用格式：
        this.成员变量名    //“通过谁调用的方法，谁就是this。”,System.out.println(this)会打印出调用类的地址值


构造方法：专门用来创建对象的方法，当我们通过关键字new来创建对象时，其实就是在调用构造方法。
    格式：
    public 类名称(参数类型 参数名称) {
        方法体
    }

    注意事项：
        1. 构造方法的名称必须和所在的类名称完全一样，就连大小写也要一样
        2. 构造方法不要写返回值类型，连void都不写
        3. 构造方法不能return一个具体的返回值
        4. 如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数、方法体什么事情都不做。public Student() {}
        5. 一旦编写了至少一个构造方法，那么编译器将不再赠送(所以自己编写构造方法后，要自己补充一个无参构造方法)。
        6. 构造方法也可以进行重载(重载：方法名称相同，参数列表不同)。


标准类的定义(类的封装定义)：
    一个常要拥有下面四个组成部分：
        1. 所有的成员变量都要使用private关键字修饰
        2. 为每一个成员变量编写一对儿Getter/Setter方法
        3. 编写一个无参数的构造方法
        4. 编写一个全参数的构造方法

    这样标准的类也叫做Java Bean
    //类编写使用快捷键Alt+Ins自动生成对应代码
        public class ClassName {
            成员变量(属性)：
                private int ...
                ...

            构造方法：
                无参构造...
                有参构造...

            Getter与Setter：
                setXxx
                getXxx

            成员方法(行为)：
                public void ...
                ...
        }

*/

public class 封装 {
    String name; // 姓名
    private int age; // 年龄
    private boolean male; // 是不是男的


    public void show() {
        System.out.println("我叫：" + name + "，年龄：" + age);
    }

    // 这个成员方法，专门用于向age设置数据
    public void setAge(int num) {
        if (num < 100 && num >= 9) { // 如果是合理情况
            age = num;
        } else {
            System.out.println("数据不合理！");
        }
    }

    // 这个成员方法，专门私语获取age的数据
    public int getAge() {
        return age;
    }


    public void setMale(boolean b) {
        male = b;
    }
    //只有boolean类型的getXxx改为isXxx
    public boolean isMale() {
        return male;
    }

    // 无参数的构造方法，编写构造方法后，要自己补充一个无参构造方法
    public 封装() {
        System.out.println("无参构造方法执行啦！");
    }

    // 全参数的构造方法
    public 封装(String name, int age) {
        System.out.println("全参构造方法执行啦！");
        this.name = name;
        this.age = age;
    }

    // 参数name是对方的名字
    // 成员变量name是自己的名字
    public void sayHello(String name) {
        System.out.println(name + "，你好。我是" + this.name);   //前者name为局部变量，后者this.name为类的成员变量
        System.out.println(this);   //打印出的地址值就是此类的地址值
    }
}
