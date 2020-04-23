/*
java.io.ObjectOutputStream extends OutputStream
    ObjectOutputStream:对象的序列化流
    作用:把对象以流的方式写入到文件中保存(使用流的技术将对象直接保存到文件中的过程则称为对象的序列化)
            以字节方式写入，看不懂，但是能反序列化
    构造方法:
        ObjectOutputStream(OutputStream out) 创建写入指定 OutputStream 的 ObjectOutputStream。
        参数:
            OutputStream out:字节输出流
    特有的成员方法:
        void writeObject(Object obj) 将指定的对象写入 ObjectOutputStream。

    使用步骤:
        1.创建ObjectOutputStream对象,构造方法中传递字节输出流
        2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
        3.释放资源
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("10_IO\\person.txt"));
            //2.使用ObjectOutputStream对象中的方法writeObject,把对象写入到文件中
            oos.writeObject(new Person("小美女",18));
            oos.close();



 java.io.ObjectInputStream extends InputStream
    ObjectInputStream:对象的反序列化流
    作用:把文件中保存的对象,以流的方式读取出来使用

    构造方法:
        ObjectInputStream(InputStream in) 创建从指定 InputStream 读取的 ObjectInputStream。
        参数:
            InputStream in:字节输入流
    特有的成员方法:
        Object readObject() 从 ObjectInputStream 读取对象。

    使用步骤:
        1.创建ObjectInputStream对象,构造方法中传递字节输入流
        2.使用ObjectInputStream对象中的方法readObject读取保存对象的文件
        3.释放资源
        4.使用读取出来的对象(打印)
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("10_IO\\person.txt"));
            Object o = ois.readObject();
            ois.close();
            System.out.println(o);
            Person p = (Person)o;
            System.out.println(p.getName()+p.getAge());

     readObject方法声明抛出了ClassNotFoundException(class文件找不到异常)
     当不存在对象的class文件时抛出此异常
     反序列化的前提:
        1.类必须实现Serializable
        2.必须存在类对应的class文件



序列化和反序列化的时候,会抛出NotSerializableException没有序列化异常
    类通过实现 java.io.Serializable 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。
    Serializable接口也叫标记型接口
        要进行序列化和反序列化的类必须实现Serializable接口,就会给类添加一个标记
        当我们进行序列化和反序列化的时候,就会检测类上是否有这个标记
            有:就可以序列化和反序列化
            没有:就会抛出 NotSerializableException异常


satic关键字:静态关键字
    静态优先于非静态加载到内存中(静态优先于对象进入到内存中)
    被static修饰的成员变量不能被序列化的,序列化的都是对象
    private static int age;
    oos.writeObject(new Person("小美女",18));
    Object o = ois.readObject();
    Person{name='小美女', age=0}

transient关键字:瞬态关键字
    被transient修饰成员变量,不能被序列化
    private transient int age;
    oos.writeObject(new Person("小美女",18));
    Object o = ois.readObject();
    Person{name='小美女', age=0}

 */



public class 序列化流 {
}
