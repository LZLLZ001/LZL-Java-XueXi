/*


只有锁对象才能调用wait和notify方法， 且同步使用的锁对象必须保证唯一
    Obejct类中的方法
        void wait();    //在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
        void notify();  //唤醒在此对象监视器上等待的单个线程。会继续执行wait方法之后的代码

    Object obj = new Object();

    synchronized (obj){ //需等待线程
        XXX;    //执行后进入等待代码块
        try {obj.wait();}catch{}
        AAA;    //等待完成后代码块
    }

    CCC; //等待间执行的线程,等待间执行代码块
    synchronized (obj){
        XXX;    //结束等待前执行代码块
        obj.notify();
    }


进入到TimeWaiting(计时等待)有两种方式
    1.使用sleep(long m)方法,在毫秒值结束之后,线程睡醒进入到Runnable/Blocked状态
    2.使用wait(long m)方法,wait方法如果在毫秒值结束之后,还没有被notify唤醒,就会自动醒来,线程睡醒进入到Runnable/Blocked状态

    唤醒的方法:
         void notify() 唤醒在此对象监视器上等待的单个线程。
         void notifyAll() 唤醒在此对象监视器上等待的所有线程。

*/


public class 等待唤醒机制 {
}
