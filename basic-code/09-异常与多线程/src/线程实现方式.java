/*

主线程:执行主(main)方法的线程
    单线程程序:java程序中只有一个线程，执行从main方法开始,从上到下依次执行
        JVM执行main方法,main方法会进入到栈内存
        JVM会找操作系统开辟一条main方法通向cpu的执行路径
        cpu就可以通过这个路径来执行main方法
        而这个路径有一个名字,叫main(主)线程


创建多线程程序的第一种方式:创建Thread类的子类
    java.lang.Thread类:是描述线程的类,我们想要实现多线程程序,就必须继承Thread类

    实现步骤:
        1.创建一个Thread类的子类
        2.在Thread类的子类中重写Thread类中的run方法,设置线程任务(开启线程要做什么?)
        3.创建Thread类的子类对象
        4.调用Thread类中的方法start方法,开启新的线程(会开辟新的栈空间),执行run方法
             void start() 使该线程开始执行；Java 虚拟机调用该线程的 run 方法。
             结果是两个线程并发地运行；当前线程（main线程）和另一个线程（创建的新线程,执行其 run 方法）。
             多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。
    java程序属于抢占式调度,那个线程的优先级高,那个线程优先执行;同一个优先级,随机选择一个执行

    public class MyThread extends Thread{
        @Override
        public void run() {XXX}
    }
    MyThread mt = new MyThread();
    mt.start();



获取线程的名称:
    1.使用Thread类中的方法getName()
        String getName() 返回该线程的名称。
    2.可以先获取到当前正在执行的线程,使用线程中的方法getName()获取线程的名称
        static Thread currentThread() 返回对当前正在执行的线程对象的引用。
            Thread.currentThread().getName()



设置线程的名称:(了解)
    1.使用Thread类中的方法setName(名字)
        void setName(String name) 改变线程名称，使之与参数 name 相同。
    2.创建一个带参数的构造方法,参数传递线程的名称;调用父类的带参构造方法,把线程名称传递给父类,让父类(Thread)给子线程起一个名字
        Thread(String name) 分配新的 Thread 对象。


public static void sleep(long millis):使当前正在执行的线程以指定的毫秒数暂停（暂时执行,会释放CPU的执行权）。
    毫秒数结束之后,线程继续执行。
    是一个静态方法，直接调用：Thread.sleep(1000);//会有异常，直接快捷键try处理




创建多线程程序的第二种方式:实现Runnable接口
    java.lang.Runnable
        Runnable 接口应该由那些打算通过某一线程执行其实例的类来实现。类必须定义一个称为 run 的无参数方法。
    java.lang.Thread类的构造方法
        Thread(Runnable target) 分配新的 Thread 对象。
        Thread(Runnable target, String name) 分配新的 Thread 对象。

    实现步骤:
        1.创建一个Runnable接口的实现类
        2.在实现类中重写Runnable接口的run方法,设置线程任务
        3.创建一个Runnable接口的实现类对象
        4.创建Thread类对象,构造方法中传递Runnable接口的实现类对象
        5.调用Thread类中的start方法,开启新的线程执行run方法
            public class RunnableImpl implements Runnable{
                public void run() {}
            }
            RunnableImpl run = new RunnableImpl();
            Thread t = new Thread(new RunnableImpl2())
            t.start();

    实现Runnable接口创建多线程程序的好处:
        1.避免了单继承的局限性
            一个类只能继承一个类(一个人只能有一个亲爹),类继承了Thread类就不能继承其他的类
            实现了Runnable接口,还可以继承其他的类,实现其他的接口
        2.增强了程序的扩展性,降低了程序的耦合性(解耦)
            实现Runnable接口的方式,把设置线程任务和开启新线程进行了分离(解耦)
            实现类中,重写了run方法:用来设置线程任务
            创建Thread类对象,调用start方法:用来开启新线程


匿名内部类方式实现线程的创建:简化代码
    把子类继承父类,重写父类的方法,创建子类对象合一步完成
    把实现类实现类接口,重写接口中的方法,创建实现类对象合成一步完成
    匿名内部类的最终产物:子类/实现类对象,而这个类没有名字
        格式:new 父类/接口(){
                重复父类/接口中的方法
            };




 */






public class 线程实现方式 {
}
