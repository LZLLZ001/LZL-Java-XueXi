/*
一个类内部包含另一个类。

分类：
    1. 成员内部类
    2. 局部内部类（包含匿名内部类）

成员内部类的定义格式：
    修饰符 class 外部类名称 {
        修饰符 class 内部类名称 {
            // ...
        }
        // ...
    }
    注意：内用外，随意访问；外用内，需要内部类对象。


成员内部类使用方式：
    1. 间接方式：在外部类的方法当中，使用内部类；然后main只是调用外部类的方法。
    2. 直接方式(外点内)：外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称(); //注意双new双括号



变量重名：就近原则
    1. 变量名：就近原则
    2. this.变量名: 看this代表哪个类(在哪个类里面)
    3. 外部类名称.this.外部类成员变量名
      （super用于继承关系中访问父类）

局部内部类：一个类定义在一个方法内部
    “局部”：只有当前所属的方法才能使用它，出了这个方法外面就不能用了。

    定义格式：
        修饰符 class 外部类名称 {
            修饰符 返回值类型 外部类方法名称(参数列表) {
                class 局部内部类名称 { //注意不能用任何权限修饰符
                    // ...
                }
            }
        }
    1. 局部内部类，如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】。


定义一个类的时候，权限修饰符规则：
    1. 外部类：public / (default)
    2. 成员内部类：public / protected / (default) / private
    3. 局部内部类：什么都不能写


匿名内部类：
    如果接口的实现类或者是父类(可以是抽象类)的子类只需要使用唯一的一次，
    那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。

    匿名内部类的定义格式：
        接口名称 对象名 = new 接口名称() {
            // 覆盖重写所有抽象方法
        };
        1. new代表创建对象的动作
        2. 接口名称就是匿名内部类需要实现哪个接口
        3. {...}这才是匿名内部类的内容


重点：匿名内部类+匿名对象
    1. 匿名内部类，在【创建对象】的时候，只能使用唯一一次。
        如果希望多次创建对象，而且类的内容一样的话，那么就需要使用单独定义的实现类了。
    2. 匿名对象，在【调用方法】的时候，只能调用唯一一次。
        如果希望同一个对象，调用多次方法，那么必须给对象起个名字。
    3. 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
        强调：匿名内部类和匿名对象不是一回事！！！


    匿名内部类：用于接口和抽象方法
        (这两者要使用都要创建实体类，但是用匿名内部类之后不用创建就可以使用)
        // 使用匿名内部类，但不是匿名对象，对象名称就叫objA
        MyInterface objA = new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-A");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-A");
            }
        };
        objA.method1();
        objA.method2();


    匿名对象：单纯匿名对象只能用于实体类
       public class MyInterfaceImpl implements MyInterface {
            @Override
            public void method1() {
                System.out.println("实现类覆盖重写了方法！111");
            }

            @Override
            public void method2() {
                System.out.println("实现类覆盖重写了方法！222");
            }
        }
        new MyInterfaceImpl().method1();
        new MyInterfaceImpl().method2();

    匿名内部类+匿名对象:两者一起使用时能极大简化代码
        // 使用了匿名内部类，而且省略了对象名称，也是匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }
        }.method1();

        // 因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类的匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-B");
            }
        }.method2();



看下面的例子(day11.demo05)

 */


public class 内部类 {
    /*

        // 使用匿名内部类，但不是匿名对象，对象名称就叫objA
        MyInterface objA = new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-A");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-A");
            }
        };
        objA.method1();
        objA.method2();
        System.out.println("=================");

        // 使用了匿名内部类，而且省略了对象名称，也是匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-B");
            }
        }.method1();
        // 因为匿名对象无法调用第二次方法，所以需要再创建一个匿名内部类的匿名对象
        new MyInterface() {
            @Override
            public void method1() {
                System.out.println("匿名内部类实现了方法！111-B");
            }

            @Override
            public void method2() {
                System.out.println("匿名内部类实现了方法！222-B");
            }
        }.method2();

    */
}
