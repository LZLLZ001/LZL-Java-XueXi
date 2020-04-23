/*

java.lang.Throwable:类是 Java 语言中所有错误或异常的超类。
    Exception:编译期异常,进行编译(写代码)java程序出现的问题
        RuntimeException:运行期异常,java程序运行过程中出现的问题
        异常就相当于程序得了一个小毛病(感冒,发烧),把异常处理掉,程序可以继续执行(吃点药,继续革命工作)
    Error:错误
        错误就相当于程序得了一个无法治愈的毛病(非典,艾滋).必须修改源代码,程序才能继续执行


throw关键字
    作用:
        可以使用throw关键字在指定的方法中抛出指定的异常
    使用格式:
        throw new xxxException("异常产生的原因");
    注意:
        1.throw关键字必须写在方法的内部
            if(arr == null){
            throw new NullPointerException("传递的数组的值是null");}
        2.throw关键字后边new的对象必须是Exception或者Exception的子类对象
        3.throw关键字抛出指定的异常对象,我们就必须处理这个异常对象
            throw关键字后边创建的是RuntimeException或者是 RuntimeException的子类对象,
                我们可以不处理,默认交给JVM处理(打印异常对象,中断程序)
            throw关键字后边创建的是编译异常(写代码的时候报错),我们就必须处理这个异常,要么throws,要么try...catch



 throws关键字:异常处理的第一种方式,交给别人处理
    作用:
        当方法内部抛出异常对象的时候,那么我们就必须处理这个异常对象
        可以使用throws关键字处理异常对象,会把异常对象声明抛出给方法的调用者处理(自己不处理,给别人处理),
            最终交给JVM处理-->中断处理
        缺点：因为会进入抛出的地方，所以程序就不会向下执行
    使用格式:在方法声明时使用
        修饰符 返回值类型 方法名(参数列表) throws AAAExcepiton,BBBExcepiton...{
            throw new AAAExcepiton("产生原因");
            throw new BBBExcepiton("产生原因");
            ...
        }
     注意:
        1.throws关键字必须写在方法声明处
        2.throws关键字后边声明的异常必须是Exception或者是Exception的子类
        3.方法内部如果抛出了多个异常对象,那么throws后边必须也声明多个异常
            如果抛出的多个异常对象有子父类关系,那么直接声明父类异常即可
        4.调用了一个声明抛出异常的方法,我们就必须的处理声明的异常
            要么继续使用throws声明抛出,交给方法的调用者处理,最终交给JVM
            要么try...catch自己处理异常


 try...catch:异常处理的第二种方式,自己处理异常
    格式:
        try{
            可能产生异常的代码
        }catch(定义一个异常的变量,用来接收try中抛出的异常对象){
            异常的处理逻辑,异常异常对象之后,怎么处理异常对象
            一般在工作中,会把异常的信息记录到一个日志中
        }
        ...
        catch(异常类名 变量名){

        }
    注意:
        1.try中可能会抛出多个异常对象,那么就可以使用多个catch来处理这些异常对象
        2.如果try中产生了异常,那么就会执行catch中的异常处理逻辑,执行完毕catch中的处理逻辑,继续执行try...catch之后的代码
                但是，try里面产生异常之后的代码不会执行
          如果try中没有产生异常,那么就不会执行catch中异常的处理逻辑,执行完try中的代码,继续执行try...catch之后的代码

    Throwable类中定义了3个异常处理的方法：异常变量名.XXX
                 String getMessage() 返回此 throwable 的简短描述。
                 String toString() 返回此 throwable 的详细消息字符串。
                 void printStackTrace()  JVM打印异常对象,默认此方法,打印的异常信息是最全面的，stack一堆、大量；trace查出、痕迹

    finally代码块
         格式:
            try{
                可能产生异常的代码
            }catch(定义一个异常的变量,用来接收try中抛出的异常对象){
                异常的处理逻辑,异常异常对象之后,怎么处理异常对象
                一般在工作中,会把异常的信息记录到一个日志中
            }
            ...
            catch(异常类名 变量名){

            }finally{
                无论是否出现异常都会执行
            }
         注意:
            1.finally不能单独使用,必须和try一起使用
            2.finally一般用于资源释放(资源回收),无论程序是否出现异常,最后都要资源释放(IO流中常用)
            3.如果finally有return语句,永远返回finally中的结果,避免该情况.


多个异常使用捕获如何处理：
    1. 多个异常分别处理：多个try...catch
    2. 多个异常一次捕获，多次处理：一个try多个catch
    3. 多个异常一次捕获一次处理。一个try...catch


子父类的异常:
    - 如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同的异常或者是父类异常的子类或者不抛出异常。
    - 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
    父类异常时什么样,子类异常就什么样


自定义异常类:
        java提供的异常类,不够我们使用,需要自己定义一些异常类
    格式:
        public class XXXExcepiton extends Exception | RuntimeException{
            添加一个空参数的构造方法
            添加一个带异常信息的构造方法
        }
     注意:
        1.自定义异常类一般都是以Exception结尾,说明该类是一个异常类
        2.自定义异常类,必须的继承Exception或者RuntimeException
            继承Exception:那么自定义的异常类就是一个编译期异常,如果方法内部抛出了编译期异常,就必须处理这个异常,要么throws,要么try...catch
            继承RuntimeException:那么自定义的异常类就是一个运行期异常,无需处理,交给虚拟机处理(中断处理)
 */


import java.io.FileNotFoundException;
import java.io.IOException;

public class Exception异常 {
    public static void main(String[] args) {
        //int[] arr = null;
        int[] arr = new int[3];
        int e = getElement(arr,3);
        System.out.println(e);

        try{
            //可能产生异常的代码
            readFile1("d:\\a.tx");
            System.out.println("资源释放");
        }catch (IOException e1){//try中抛出什么异常对象,catch就定义什么异常变量,用来接收这个异常对象
            //异常的处理逻辑,异常异常对象之后,怎么处理异常对象
            //System.out.println("catch - 传递的文件后缀不是.txt");

            /*
                Throwable类中定义了3个异常处理的方法
                 String getMessage() 返回此 throwable 的简短描述。
                 String toString() 返回此 throwable 的详细消息字符串。
                 void printStackTrace()  JVM打印异常对象,默认此方法,打印的异常信息是最全面的
             */
            //System.out.println(e.getMessage());//文件的后缀名不对
            //System.out.println(e.toString());//重写Object类的toString java.io.IOException: 文件的后缀名不对
            //System.out.println(e);//java.io.IOException: 文件的后缀名不对

            /*
                java.io.IOException: 文件的后缀名不对
                    at com.itheima.demo02.Exception.Demo01TryCatch.readFile(Demo01TryCatch.java:55)
                    at com.itheima.demo02.Exception.Demo01TryCatch.main(Demo01TryCatch.java:27)
             */
            e1.printStackTrace();
        }
        System.out.println("后续代码");
    }
    /*
        定义一个方法,获取数组指定索引处的元素
        参数:
            int[] arr
            int index
        以后(工作中)我们首先必须对方法传递过来的参数进行合法性校验
        如果参数不合法,那么我们就必须使用抛出异常的方式,告知方法的调用者,传递的参数有问题
        注意:
            NullPointerException是一个运行期异常,我们不用处理,默认交给JVM处理
            ArrayIndexOutOfBoundsException是一个运行期异常,我们不用处理,默认交给JVM处理
     */
    public static int getElement(int[] arr,int index){
        /*
            我们可以对传递过来的参数数组,进行合法性校验
            如果数组arr的值是null
            那么我们就抛出空指针异常,告知方法的调用者"传递的数组的值是null"
         */
        if(arr == null){
            throw new NullPointerException("传递的数组的值是null");
        }

        /*
            我们可以对传递过来的参数index进行合法性校验
            如果index的范围不在数组的索引范围内
            那么我们就抛出数组索引越界异常,告知方法的调用者"传递的索引超出了数组的使用范围"
         */
        if(index<0 || index>arr.length-1){
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }

        int ele = arr[index];
        return ele;
    }


    public static void readFile(String fileName) throws FileNotFoundException, IOException {
        if(!fileName.equals("c:\\a.txt")){
            throw new FileNotFoundException("传递的文件路径不是c:\\a.txt");
        }

        /*
            如果传递的路径,不是.txt结尾
            那么我们就抛出IO异常对象,告知方法的调用者,文件的后缀名不对

         */
        if(!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题,读取文件");
    }


    /*
       如果传递的路径,不是.txt结尾
       那么我们就抛出IO异常对象,告知方法的调用者,文件的后缀名不对

    */
    public static void readFile1(String fileName) throws IOException {

        if(!fileName.endsWith(".txt")){
            throw new IOException("文件的后缀名不对");
        }

        System.out.println("路径没有问题,读取文件");
    }
}
