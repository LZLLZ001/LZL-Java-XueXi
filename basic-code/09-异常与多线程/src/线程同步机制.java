/*
解决线程安全问题的一种方案:使用同步代码块
    格式:
        synchronized(锁对象){可能会出现线程安全问题的代码(访问了共享数据的代码)}
            Object obj = new Object();
            synchronized (obj){XXX}
    注意:
        1.通过代码块中的锁对象,可以使用任意的对象
        2.但是必须保证多个线程使用的锁对象是同一个
        3.锁对象作用:把同步代码块锁住,只让一个线程在同步代码块中执行



解决线程安全问题的二种方案:使用同步方法
    使用步骤:
        1.把访问了共享数据的代码抽取出来,放到一个方法中
        2.在方法上添加synchronized修饰符
    格式:定义方法的格式
        修饰符 synchronized 返回值类型 方法名(参数列表){可能会出现线程安全问题的代码(访问了共享数据的代码)}



解决线程安全问题的三种方案:使用Lock锁
    java.util.concurrent.locks.Lock接口
    Lock 实现提供了比使用 synchronized 方法和语句可获得的更广泛的锁定操作。
    Lock接口中的方法:
        void lock()获取锁。
        void unlock()  释放锁。
    java.util.concurrent.locks.ReentrantLock implements Lock接口 //reentrant可重入的

    使用步骤:
        1.在成员位置创建一个ReentrantLock对象
        2.在可能会出现安全问题的代码前调用Lock接口中的方法lock获取锁
        3.在可能会出现安全问题的代码后调用Lock接口中的方法unlock释放锁
     Lock l = new ReentrantLock();//成员位置
     l.lock();
     XXX;
     l.unlock();//可放在finally里面，这样保证锁一定能释放


*/

public class 线程同步机制 {
}
