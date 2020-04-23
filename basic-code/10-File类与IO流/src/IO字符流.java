/*
java.io.Writer:字符输出流,是所有字符输出流的最顶层的父类,是一个抽象类

    共性的成员方法:
        - void write(int c) 写入单个字符。
        - void write(char[] cbuf)写入字符数组。
        - abstract  void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        - void write(String str)写入字符串。
        - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        - void flush()刷新该流的缓冲。
        - void close() 关闭此流，但要先刷新它。

    java.io.FileWriter extends OutputStreamWriter extends Writer
    FileWriter:文件字符输出流
    作用:把内存中字符数据写入到文件中

    构造方法:
        FileWriter(File file)根据给定的 File 对象构造一个 FileWriter 对象。
        FileWriter(String fileName) 根据给定的文件名构造一个 FileWriter 对象。
        参数:写入数据的目的地
            String fileName:文件的路径
            File file:是一个文件
        构造方法的作用:
            1.会创建一个FileWriter对象
            2.会根据构造方法中传递的文件/文件的路径,创建文件
            3.会把FileWriter对象指向创建好的文件

    字符输出流的使用步骤(重点):
        1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
        3.使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中(可不写，下一步包含此功能)
        4.释放资源(会先把内存缓冲区中的数据刷新到文件中)
            FileWriter fw = new FileWriter("09_IOAndProperties\\d.txt");
            fw.write(XXX);
            fw.close();
        flush方法和close方法的区别：
            - flush ：刷新缓冲区，流对象可以继续使用。
            - close:  先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

续写和换行
    续写:使用两个参数的构造方法
        FileWriter(String fileName, boolean append)
        FileWriter(File file, boolean append)
        参数:
            String fileName,File file:写入数据的目的地
            boolean append:续写开关 true:不会创建新的文件覆盖源文件,可以续写; false:创建新的文件覆盖源文件
    换行:换行符号
        windows:\r\n
        linux:/n
        mac:/r



java.io.Reader:字符输入流,是字符输入流的最顶层的父类,定义了一些共性的成员方法,是一个抽象类

    共性的成员方法:
        int read() 读取单个字符并返回。
        int read(char[] cbuf)一次读取多个字符,将字符读入数组。
        void close() 关闭该流并释放与之关联的所有资源。

    java.io.FileReader extends InputStreamReader extends Reader
    子类:FileReader:文件字符输入流
    作用:把硬盘文件中的数据以字符的方式读取到内存中

    构造方法:
        FileReader(String fileName)
        FileReader(File file)
        参数:读取文件的数据源
            String fileName:文件的路径
            File file:一个文件
        FileReader构造方法的作用:
            1.创建一个FileReader对象
            2.会把FileReader对象指向要读取的文件
    字符输入流的使用步骤:
        1.创建FileReader对象,构造方法中绑定要读取的数据源
        2.使用FileReader对象中的方法read读取文件
        3.释放资源
            FileReader fr = new FileReader("09_IOAndProperties\\c.txt");
            char[] cs = new char[1024];//存储读取到的多个字符
            int len = 0;//记录的是每次读取的有效字符个数
            while((len = fr.read(cs))!=-1){
                System.out.println(new String(cs,0,len));
            }
            fr.close();


String类的构造方法
    String(char[] value) 把字符数组转换为字符串
    String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串 offset数组的开始索引 count转换的个数






JDK7的新特性
    在try的后边可以增加一个(),在括号中可以定义流对象
    那么这个流对象的作用域就在try中有效
    try中的代码执行完毕,会自动把流对象释放,不用写finally
    格式:
        try(定义流对象;定义流对象....){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }


JDK9新特性
    try的前边可以定义流对象
    在try后边的()中可以直接引入流对象的名称(变量名)
    在try代码执行完毕之后,流对象也可以释放掉,不用写finally
    格式:
        A a = new A();
        B b = new B();
        try(a,b){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }



 */


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO字符流 {
    public static void main(String[] args) throws IOException {
        //1.创建FileReader对象,构造方法中绑定要读取的数据源
        FileReader fr = new FileReader("09_IOAndProperties\\c.txt");
        //2.使用FileReader对象中的方法read读取文件
        //int read() 读取单个字符并返回。
        /*int len = 0;
        while((len = fr.read())!=-1){
            System.out.print((char)len);
        }*/

        //int read(char[] cbuf)一次读取多个字符,将字符读入数组。
        char[] cs = new char[1024];//存储读取到的多个字符
        int len = 0;//记录的是每次读取的有效字符个数
        while((len = fr.read(cs))!=-1){
            /*
                String类的构造方法
                String(char[] value) 把字符数组转换为字符串
                String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串 offset数组的开始索引 count转换的个数
             */
            System.out.println(new String(cs,0,len));
        }

        //3.释放资源
        fr.close();






        //1.创建FileWriter对象,构造方法中绑定要写入数据的目的地
        FileWriter fw = new FileWriter("09_IOAndProperties\\d.txt");
        //2.使用FileWriter中的方法write,把数据写入到内存缓冲区中(字符转换为字节的过程)
        //void write(int c) 写入单个字符。
        fw.write(97);
        char[] cs1 = {'a','b','c','d','e'};
        //void write(char[] cbuf)写入字符数组。
        fw.write(cs1);//abcde

        //void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
        fw.write(cs1,1,3);//bcd

        //void write(String str)写入字符串。
        fw.write("传智播客");//传智播客

        //void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        fw.write("黑马程序员",2,3);//程序员
        //3.使用FileWriter中的方法flush,把内存缓冲区中的数据,刷新到文件中
        //fw.flush();
        //4.释放资源(会先把内存缓冲区中的数据刷新到文件中)
        fw.close();
    }

}
