package 创建型模式;/*

单例模式：
    采取一定的方法保证在整个的软件系统中，对某个类只能存在一个对象实例，
    并且该类只提供一个取得其对象实例的方法(静态方法)

    1) 单例模式保证了 系统内存中该类只存在一个对象，节省了系统资源，对于一些需要频繁创建销毁的对象，
        使用单例模式可以提高系统性能
    2) 当想实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是使用new
    3) 单例模式使用的场景：
        需要频繁的进行创建和销毁的对象、
        创建对象时耗时过多或耗费资源过多(即：重量级对象)，但又经常用到的对象、
        工具类对象、频繁访问数据库或文件的对象(比如数据源、session工厂等).



懒加载：只有在需要时才加载

单例模式八种方式：
    1) 饿汉式(静态常量)
    2) 饿汉式（静态代码块）
    3) 懒汉式(线程不安全)
    4) 懒汉式(线程安全，同步方法)
    5) 懒汉式(线程安全，同步代码块)
    6) 双重检查
    7) 静态内部类
    8) 枚举


饿汉式：
    饿汉式（静态常量）
        1) 构造器私有化(防止外部new);
        2) 本类内部创建对象实例;
        3) 提供一个公有的静态方法getInstance返回实例对象;
            class A{
                private A() {}
                private final static A instance = new A();
                public static Singleton getInstance() {return instance;}
            }

    饿汉式（静态代码块）
           class A{
                private static A instance;
                static { // 在静态代码块中，创建单例对象,其他与上面的没区别
                    instance = new A();
                }
                private A() {}
                public static Singleton getInstance() {return instance;}
            }

    优点：写法简单，在类装载的时候就完成实例化。避免了线程同步问题。
    缺点：在类装载的时候就完成实例化，但是导致类装载的原因有很多种，
         因此不能确定有其他的方式（或者其他的静态方法）导致类装载，此时没有达到懒加载的效果。
         如果从始至终从未使用过这个实例，则会造成内存的浪费。


懒汉式：了解，不用
    懒汉式(线程不安全):了解
        class A {
            private static A instance;
            private A() {}
            public static A getInstance() {//提供一个静态的公有方法，当使用到该方法时，才去创建 instance
                if(instance == null) {
                    instance = new A();
                }
                return instance;
            }
        }
        1) 起到了Lazy Loading的效果，但是只能在单线程下使用。
        2) 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
            另一个线程也通过了这个判断语句，这时便会产生多个实例。所以在多线程环境下不可使用这种方式
        3) 结论：在实际开发中，不要使用这种方式.

    懒汉式(线程安全，同步方法)：了解
        class A {
            private static A instance;
            private A() {}
            //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
            public static synchronized A getInstance() {
                if(instance == null) {
                    instance = new Singleton();
                }
                return instance;
            }
        }
        1) 解决了线程不安全问题
        2) 效率太低了，每个线程在想获得类的实例时候，执行getInstance()方法都要进行同步。
            而其实这个方法只执行一次实例化代码就够了，后面的想获得该类实例，直接return就行了。方法进行同步效率太低.
        3) 结论： 在实际开发中，不推荐使用这种方式

    懒汉式(线程安全，同步代码块)：是一种错误写法


双重检查：
    class A {
        private static volatile A instance;  //volatile确保本条指令不会因编译器的优化而省略，且要求每次直接读值。
        private A() {}
        //提供一个静态的公有方法，加入同步处理，加入双重检查，解决线程安全问题, 解决懒加载问题，同时保证了效率, 推荐使用
        public static synchronized A getInstance() {
            if(instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }
    1) Double-Check概念是多线程开发中常使用到的。
    2) 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
       直接return实例化对象，也避免的反复进行方法同步.
    3) 线程安全；延迟加载；效率较高
    4) 结论：在实际开发中，推荐使用这种单例设计模式


静态内部类：
    class A {
        private static volatile A instance;
        private Singleton() {}
        private static class AInstance {//写一个静态内部类,该类中有一个静态属性A
            private static final A INSTANCE = new A();
        }
        public static synchronized Singleton getInstance() {//提供一个静态的公有方法，直接返回AInstance.INSTANCE
            return SingletonInstance.INSTANCE;
        }
    }
    1) 采用了类装载的机制来保证初始化实例时只有一个线程。
    2) 静态内部类方式在A类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，才
        会装载AInstance类，从而完成A的实例化。
    3) 类的静态属性只会在第一次加载类的时候初始化，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。
    4) 优点：避免了线程不安全，利用静态内部类特点实现延迟加载，效率高.
    5) 结论：推荐使用.


枚举：
    enum A {
        INSTANCE; //属性
        public void fun() {System.out.println("ok~");}
    }
    1) 这借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
    2) 结论：推荐使用


JDK中java.lang.Runtime就是经典的单例模式(饿汉式)




*/


public class 单例模式 {
}
