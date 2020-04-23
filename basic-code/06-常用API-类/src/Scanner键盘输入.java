/*
API(Application Programming Interface)：
    应用程序编程接口。Java API是一本程序员的字典，是JDK中提供给我们使用的类的说明文档。
    这些类将底层的代码实现封装了起来，我们不需要关心这些类是如何实现的，只需要学习这些类如何使用即可。
    JDK1.6CN是官方翻译的中文版，之后的都为民间翻译。

API使用步骤：
    1. 导包： import 包路径.类名称;
                如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句不写。
                只有java.lang包下的内容不需要导包，其他的包都需要import语句。
    2. 创建： 类名称 对象名 = new 类名称();
    3. 使用： 对象名.成员方法名();     //方法在API文档中查找


Scanner:
    import java.util.Scanner;  // 导包
    Scanner sc = new Scanner(System.in);  // 备注：System.in代表从键盘进行输入

    String str = sc.next();  // 获取键盘输入的字符串
    int num = sc.nextInt();  // 获取键盘输入的int数字(实际上是输入的是字符串，Int的这个方法将其转换成了数字)

    1. 输入次数很少时可以使用匿名对象：
              int num = new Scanner(System.in).nextInt();
              fun1(new Scanner(System.in));   //传参
              public static Scanner fun2() {return new Scanner(System.in);}   //返回值
*/

import java.util.Scanner;

public class Scanner键盘输入 {
    public static void main(String[] args) {
        // 2. 创建
        // 备注：System.in代表从键盘进行输入
        Scanner sc1 = new Scanner(System.in);

        // 3. 获取键盘输入的int数字
        int num = sc1.nextInt();
        System.out.println("输入的int数字是：" + num);

        // 4. 获取键盘输入的字符串
        String str = sc1.next();
        System.out.println("输入的字符串是：" + str);


        // 普通使用方式
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();

        // 匿名对象的方式
//        int num = new Scanner(System.in).nextInt();
//        System.out.println("输入的是：" + num);

        // 使用一般写法传入参数
//        Scanner sc = new Scanner(System.in);
//        methodParam(sc);

        // 使用匿名对象来进行传参
//        methodParam(new Scanner(System.in));

        Scanner sc2 = methodReturn();
        int num2 = sc2.nextInt();
        System.out.println("输入的是：" + num2);
    }

    public static void methodParam(Scanner sc) {
        int num = sc.nextInt();
        System.out.println("输入的是：" + num);
    }

    public static Scanner methodReturn() {
//        Scanner sc = new Scanner(System.in);
//        return sc;
        return new Scanner(System.in);
    }
}
