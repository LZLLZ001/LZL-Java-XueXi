/*
java.io.File类
    文件和目录路径名的抽象表示形式。
    java把电脑中的文件和文件夹(目录)封装为了一个File类,我们可以使用File类对文件和文件夹进行操作
    我们可以使用File类的方法
        创建一个文件/文件夹
        删除文件/文件夹
        获取文件/文件夹
        判断文件/文件夹是否存在
        对文件夹进行遍历
        获取文件的大小
    File类是一个与系统无关的类,任何的操作系统都可以使用这个类中的方法

    重点:记住这三个单词
        file:文件
        directory:文件夹/目录
        path:路径


分隔符：
    static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
    static char pathSeparatorChar 与系统有关的路径分隔符。
    static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
    static char separatorChar 与系统有关的默认名称分隔符。

    操作路径:路径不能写死(为了能更好适应不同操作系统)
        C:\develop\a\a.txt  windows
        C:/develop/a/a.txt  linux
        "C:"+File.separator+"develop"+File.separator+"a"+File.separator+"a.txt"

        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//路径分隔符 windows:分号;  linux:冒号:

        String separator = File.separator;
        System.out.println(separator);// 文件名称分隔符 windows:反斜杠\  linux:正斜杠/


路径:
    绝对路径:是一个完整的路径
        以盘符(c:,D:)开始的路径
            c:\\a.txt
            C:\\Users\itcast\\IdeaProjects\\shungyuan\\123.txt
            D:\\demo\\b.txt
    相对路径:是一个简化的路径
        相对指的是相对于当前项目的根目录(C:\\Users\itcast\\IdeaProjects\\shungyuan)
        如果使用当前项目的根目录,路径可以简化书写
        C:\\Users\itcast\\IdeaProjects\\shungyuan\\123.txt-->简化为: 123.txt(可以省略项目的根目录)
    注意:
        1.路径是不区分大小写
        2.路径中的文件名称分隔符windows使用反斜杠,反斜杠是转义字符,两个反斜杠代表一个普通的反斜杠



File类的构造方法
    方法一：
         File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
            参数:
                String pathname:字符串的路径名称
                路径可以是以文件结尾,也可以是以文件夹结尾
                路径可以是相对路径,也可以是绝对路径
                路径可以是存在,也可以是不存在
                创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
         File f1 = new File("路径");
         System.out.println(f1);//打印路径，重写了Object类的toString方法

    方法二：
        File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            String parent:父路径
            String child:子路径
        好处:
            父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
        File file = new File(parent,child);
        System.out.println(file);   //parentchild


    方法二：
        File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            File parent:父路径
            String child:子路径
        好处:
             父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
             父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
        File parent = new File("c:\\");
        File file = new File(parent,"hello.java");
        System.out.println(file);//c:\hello.java


File类获取功能的方法
    - public String getAbsolutePath() ：返回此File的绝对路径名字符串。
    - public String getPath() ：将此File转换为路径名字符串。
    - public String getName()  ：返回由此File表示的文件或目录的名称。
    - public long length()  ：返回由此File表示的文件的长度。

File类判断功能的方法
    - public boolean exists() ：此File表示的文件或目录是否实际存在。
    - public boolean isDirectory() ：此File表示的是否为目录。
    - public boolean isFile() ：此File表示的是否为文件。

File类创建删除功能的方法
    - public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
            创建文件的路径和名称在构造方法中给出(构造方法的参数)
                true:文件不存在,创建文件,返回true
                false:文件存在,不会创建,返回false
            注意:
                1.此方法只能创建文件,不能创建文件夹
                2.创建文件的路径必须存在,否则会抛出异常
    - public boolean mkdir() ：创建由此File表示的目录。
    - public boolean mkdirs() ：创建由此File表示的目录，包括任何必需但不存在的父目录。
            创建文件的路径和名称在构造方法中给出(构造方法的参数)
                true:文件夹不存在,创建文件夹,返回true
                false:文件夹存在,不会创建,返回false;构造方法中给出的路径不存在返回false
            注意:此方法只能创建文件夹,不能创建文件
   - public boolean delete() ：删除由此File表示的文件或目录。
            删除构造方法路径中给出的文件/文件夹
                true:文件/文件夹删除成功,返回true
                false:文件夹中有内容,不会删除返回false;构造方法中路径不存在false
            注意:delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎

File类遍历(文件夹)目录功能
    - public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
            File file = new File("路径");
            String[] arr = file.list();
            for (String fileName : arr) {
                System.out.println(fileName);
            }
    - public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
            File file = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_FileAndRecursion");
            File[] files = file.listFiles();
            for (File f : files) {
                System.out.println(f);
            }
    注意:
        list方法和listFiles方法遍历的是构造方法中给出的目录
        如果构造方法中给出的目录的路径不存在,会抛出空指针异常
        如果构造方法中给出的路径不是一个目录,也会抛出空指针异常



 递归:方法自己调用自己
    - 递归的分类:
          - 递归分为两种，直接递归和间接递归。
          - 直接递归称为方法自身调用自己。
          - 间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
    - 注意事项：
          - 递归一定要有条件限定，保证递归能够停止下来，否则会发生栈内存溢出。
          - 在递归中虽然有限定条件，但是递归次数不能太多。否则也会发生栈内存溢出。
          - 构造方法,禁止递归
    - 递归的使用前提:
            当调用方法的时候,方法的主体不变,每次调用方法的参数不同,可以使用递归



过滤器：
    File[] listFiles(FileFilter filter)
    java.io.FileFilter接口:用于抽象路径名(File对象)的过滤器。
        作用:用来过滤文件(File对象)
        抽象方法:用来过滤文件的方法
            boolean accept(File pathname) 测试指定抽象路径名是否应该包含在某个路径名列表中。
            参数:
                File pathname:使用ListFiles方法遍历目录,得到的每一个文件对象

    File[] listFiles(FilenameFilter filter)
    java.io.FilenameFilter接口:实现此接口的类实例可用于过滤器文件名。
        作用:用于过滤文件名称
        抽象方法:用来过滤文件的方法
            boolean accept(File dir, String name) 测试指定文件是否应该包含在某一文件列表中。
            参数:
                File dir:构造方法中传递的被遍历的目录
                String name:使用ListFiles方法遍历目录,获取的每一个文件/文件夹的名称
    注意:
        两个过滤器接口是没有实现类的,需要我们自己写实现类,重写过滤的方法accept,在方法中自己定义过滤的规则


 */


import java.io.File;
import java.io.IOException;

public class File类 {
    public static void main(String[] args) {
        /*
            static String pathSeparator 与系统有关的路径分隔符，为了方便，它被表示为一个字符串。
            static char pathSeparatorChar 与系统有关的路径分隔符。

            static String separator 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
            static char separatorChar 与系统有关的默认名称分隔符。

            操作路径:路径不能写死了
            C:\develop\a\a.txt  windows
            C:/develop/a/a.txt  linux
            "C:"+File.separator+"develop"+File.separator+"a"+File.separator+"a.txt"
         */
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);//路径分隔符 windows:分号;  linux:冒号:

        String separator = File.separator;
        System.out.println(separator);// 文件名称分隔符 windows:反斜杠\  linux:正斜杠/
    }




    /*
        File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            File parent:父路径
            String child:子路径
        好处:
             父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
             父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
     */
    private static void show03() {
        File parent = new File("c:\\");
        File file = new File(parent,"hello.java");
        System.out.println(file);//c:\hello.java
    }

    /*
        File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            String parent:父路径
            String child:子路径
        好处:
            父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
     */
    private static void show02(String parent, String child) {
        File file = new File(parent,child);
        System.out.println(file);//c:\a.txt
    }

    /*
        File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
        参数:
            String pathname:字符串的路径名称
            路径可以是以文件结尾,也可以是以文件夹结尾
            路径可以是相对路径,也可以是绝对路径
            路径可以是存在,也可以是不存在
            创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
     */
    private static void show01() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
        System.out.println(f1);//重写了Object类的toString方法 C:\Users\itcast\IdeaProjects\shungyuan\a.txt

        File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
        System.out.println(f2);//C:\Users\itcast\IdeaProjects\shungyuan

        File f3 = new File("b.txt");
        System.out.println(f3);//b.txt
    }



    /*
        public long length()  ：返回由此File表示的文件的长度。
        获取的是构造方法指定的文件的大小,以字节为单位
        注意:
            文件夹是没有大小概念的,不能获取文件夹的大小
            如果构造方法中给出的路径不存在,那么length方法返回0
     */
    private static void show04() {
        File f1 = new File("C:\\develop\\a\\1.jpg");
        long l1 = f1.length();
        System.out.println(l1);//780831字节

        File f2 = new File("C:\\develop\\a\\2.jpg");
        System.out.println(f2.length());//0

        File f3 = new File("C:\\develop\\a");
        System.out.println(f3.length());//0 文件夹没有大小概念的
    }

    /*
        public String getName()  ：返回由此File表示的文件或目录的名称。
        获取的就是构造方法传递路径的结尾部分(文件/文件夹)
     */
    private static void show05() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
        String name1 = f1.getName();
        System.out.println(name1);//a.txt

        File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
        String name2 = f2.getName();
        System.out.println(name2);//shungyuan
    }

    /*
        public String getPath() ：将此File转换为路径名字符串。
        获取的构造方法中传递的路径

        toString方法调用的就是getPath方法
        源码:
            public String toString() {
                return getPath();
            }
     */
    private static void show06() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
        File f2 = new File("a.txt");
        String path1 = f1.getPath();
        System.out.println(path1);//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
        String path2 = f2.getPath();
        System.out.println(path2);//a.txt

        System.out.println(f1);//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
        System.out.println(f1.toString());//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
    }

    /*
        public String getAbsolutePath() ：返回此File的绝对路径名字符串。
        获取的构造方法中传递的路径
        无论路径是绝对的还是相对的,getAbsolutePath方法返回的都是绝对路径
     */
    private static void show07() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\a.txt");
        String absolutePath1 = f1.getAbsolutePath();
        System.out.println(absolutePath1);//C:\Users\itcast\IdeaProjects\shungyuan\a.txt

        File f2 = new File("a.txt");
        String absolutePath2 = f2.getAbsolutePath();
        System.out.println(absolutePath2);//C:\Users\itcast\IdeaProjects\shungyuan\a.txt
    }

    /*
     public boolean isDirectory() ：此File表示的是否为目录。
         用于判断构造方法中给定的路径是否以文件夹结尾
             是:true
             否:false
     public boolean isFile() ：此File表示的是否为文件。
         用于判断构造方法中给定的路径是否以文件结尾
             是:true
             否:false
     注意:
         电脑的硬盘中只有文件/文件夹,两个方法是互斥
         这两个方法使用前提,路径必须是存在的,否则都返回false
  */
    private static void show08() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shung");

        //不存在,就没有必要获取
        if(f1.exists()){
            System.out.println(f1.isDirectory());
            System.out.println(f1.isFile());
        }

        File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
        if(f2.exists()){
            System.out.println(f2.isDirectory());//true
            System.out.println(f2.isFile());//false
        }

        File f3 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\shungyuan.iml");
        if(f3.exists()){
            System.out.println(f3.isDirectory());//false
            System.out.println(f3.isFile());//true
        }
    }

    /*
        public boolean exists() ：此File表示的文件或目录是否实际存在。
        用于判断构造方法中的路径是否存在
            存在:true
            不存在:false
     */
    private static void show09() {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan");
        System.out.println(f1.exists());//true

        File f2 = new File("C:\\Users\\itcast\\IdeaProjects\\shung");
        System.out.println(f2.exists());//false

        File f3 = new File("shungyuan.iml");//相对路径 C:\Users\itcast\IdeaProjects\shungyuan\shungyuan.iml
        System.out.println(f3.exists());//true

        File f4 = new File("a.txt");
        System.out.println(f4.exists());//false
    }


    /*
    public boolean delete() ：删除由此File表示的文件或目录。
    此方法,可以删除构造方法路径中给出的文件/文件夹
    返回值:布尔值
        true:文件/文件夹删除成功,返回true
        false:文件夹中有内容,不会删除返回false;构造方法中路径不存在false
    注意:
        delete方法是直接在硬盘删除文件/文件夹,不走回收站,删除要谨慎
 */
    private static void show10() {
        File f1 = new File("08_FileAndRecursion\\新建文件夹");
        boolean b1 = f1.delete();
        System.out.println("b1:"+b1);

        File f2 = new File("08_FileAndRecursion\\abc.txt");
        System.out.println(f2.delete());
    }

    /*
       public boolean mkdir() ：创建单级空文件夹
       public boolean mkdirs() ：既可以创建单级空文件夹,也可以创建多级文件夹
       创建文件夹的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
            true:文件夹不存在,创建文件夹,返回true
            false:文件夹存在,不会创建,返回false;构造方法中给出的路径不存在返回false
        注意:
            1.此方法只能创建文件夹,不能创建文件
     */
    private static void show11() {
        File f1 = new File("08_FileAndRecursion\\aaa");
        boolean b1 = f1.mkdir();
        System.out.println("b1:"+b1);

        File f2 = new File("08_FileAndRecursion\\111\\222\\333\\444");
        boolean b2 = f2.mkdirs();
        System.out.println("b2:"+b2);

        File f3 = new File("08_FileAndRecursion\\abc.txt");
        boolean b3 = f3.mkdirs();//看类型,是一个文件
        System.out.println("b3:"+b3);

        File f4 = new File("08_F\\ccc");
        boolean b4 = f4.mkdirs();//不会抛出异常,路径不存在,不会创建
        System.out.println("b4:"+b4);
    }

    /*
        public boolean createNewFile() ：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        创建文件的路径和名称在构造方法中给出(构造方法的参数)
        返回值:布尔值
            true:文件不存在,创建文件,返回true
            false:文件存在,不会创建,返回false
        注意:
            1.此方法只能创建文件,不能创建文件夹
            2.创建文件的路径必须存在,否则会抛出异常

        public boolean createNewFile() throws IOException
        createNewFile声明抛出了IOException,我们调用这个方法,就必须的处理这个异常,要么throws,要么trycatch
     */
    private static void show12() throws IOException {
        File f1 = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_FileAndRecursion\\1.txt");
        boolean b1 = f1.createNewFile();
        System.out.println("b1:"+b1);

        File f2 = new File("08_FileAndRecursion\\2.txt");
        System.out.println(f2.createNewFile());

        File f3 = new File("08_FileAndRecursion\\新建文件夹");
        System.out.println(f3.createNewFile());//不要被名称迷糊,要看类型

        File f4 = new File("08_FileAndRecursi\\3.txt");
        System.out.println(f4.createNewFile());//路径不存在,抛出IOException
    }

    /*
        public File[] listFiles() ：返回一个File数组，表示该File目录中的所有的子文件或目录。
        遍历构造方法中给出的目录,会获取目录中所有的文件/文件夹,把文件/文件夹封装为File对象,多个File对象存储到File数组中
     */
    private static void show13() {
        File file = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_FileAndRecursion");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }
    }

    /*
        public String[] list() ：返回一个String数组，表示该File目录中的所有子文件或目录。
        遍历构造方法中给出的目录,会获取目录中所有文件/文件夹的名称,把获取到的多个名称存储到一个String类型的数组中
     */
    private static void show14() {
        //File file = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_FileAndRecursion\\1.txt");//NullPointerException
        //File file = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_Fi");//NullPointerException
        File file = new File("C:\\Users\\itcast\\IdeaProjects\\shungyuan\\08_FileAndRecursion");
        String[] arr = file.list();
        for (String fileName : arr) {
            System.out.println(fileName);
        }
    }
}
