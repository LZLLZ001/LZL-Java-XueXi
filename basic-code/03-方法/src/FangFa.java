/*

方法定义：

    修饰符 返回值类型 方法名称(参数类型 参数名称, ...) {
        方法体
        return 返回值;
    }

    修饰符：现阶段的固定写法，public static
    返回值类型：也就是方法最终产生的数据结果是什么类型
    方法名称：方法的名字，首字母小写，后面每个单词首字母大写（小驼峰式）。helloWorld
    参数类型：进入方法的数据是什么类型
    参数名称：进入方法的数据对应的变量名称，PS：参数如果有多个，使用逗号进行分隔
    方法体：方法需要做的事情，若干行代码
    return：两个作用，第一停止当前方法，第二将后面的返回值还给调用处
    返回值：也就是方法执行后最终产生的数据结果，return后面的“返回值”，必须和方法名称前面的“返回值类型”，保持对应。

	1) 方法的定义不能产生嵌套包含关系，不能在一个方法内部定义另一个方法（是定义不能嵌套，方法本身可以嵌套）。
            //public static void fun1() {
            //			public static void fun2() {
            //			}
            //}//报错


方法调用的三种格式：

    1. 单独调用：方法名称(参数);
    2. 打印调用：System.out.println(方法名称(参数));
    3. 赋值调用：数据类型 变量名称 = 方法名称(参数);

     注意：void方法只能够单独调用，不能进行打印调用或者赋值调用。

方法的重载（Overload）：多个方法的名称一样，但是参数列表不一样。
    好处：只需要记住唯一一个方法名称，就可以实现类似的多个功能。

    方法重载与下列因素相关：
        1. 参数个数不同
        2. 参数类型不同
        3. 参数的多类型顺序不同

    方法重载与下列因素无关：
        1. 与参数的名称无关
        2. 与方法的返回值类型无关

*/


public class FangFa {
    public static void main(String[] args) {
        // 单独调用
        sum(10, 20);
        System.out.println("===========");

        // 打印调用
        System.out.println(sum(10, 20)); // 30
        System.out.println("===========");

        // 赋值调用
        int number = sum(15, 25);
        number += 100;
        System.out.println("变量的值：" + number); // 140

        method1(10, 20);
        System.out.println("==============");
        method2();


        // 我是main方法，我来调用你。
        // 我调用你，你来帮我计算一下，算完了之后，把结果告诉我的num变量
        int num = getSum(10, 20);
        System.out.println("返回值是：" + num);
        System.out.println("==============");

        printSum(100, 200);
        System.out.println("==============");

        System.out.println(getSum(2, 3)); // 正确写法
        getSum(3, 5); // 正确写法，但是返回值没有用到
        System.out.println("==============");

        // 对于void没有返回值的方法，只能单独，不能打印或者赋值
//        System.out.println(printSum(2, 3)); // 错误写法！
//        System.out.println(void);

//        int num2 = printSum(10, 20); // 错误写法！
//        int num3 = void;
//        void num4 = void;



        System.out.println(sum(10, 20)); // 两个参数的方法
        System.out.println(sum(10, 20, 30)); // 三个参数的方法
        System.out.println(sum(10, 20, 30, 40)); // 四个参数的方法
//        System.out.println(sum(10, 20, 30, 40, 50)); // 找不到任何方法来匹配，所以错误！
    }

    public static int sum(int a, int b) {
        System.out.println("有2个参数的方法执行！");
        int result = a + b;
        return result;
    }

    // 两个数字相乘，做乘法，必须知道两个数字各自是多少，否则无法进行计算
    // 有参数
    public static void method1(int a, int b) {
        int result = a * b;
        System.out.println("结果是：" + result);
    }

    // 例如打印输出固定10次文本字符串
    public static void method2() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello, World!" + i);
        }
    }

    // 我是一个方法，我负责两个数字相加。
    // 我有返回值int，谁调用我，我就把计算结果告诉谁
    public static int getSum(int a, int b) {
        int result = a + b;
        return result;
    }

    // 我是一个方法，我负责两个数字相加。
    // 我没有返回值，不会把结果告诉任何人，而是我自己进行打印输出。
    public static void printSum(int a, int b) {
        int result = a + b;
        System.out.println("结果是：" + result);
    }



    public static int sum(int a, double b) {
        return (int) (a + b);
    }

    public static int sum(double a, int b) {
        return (int) (a + b);
    }


    // 错误写法！与方法的返回值类型无关
//    public static double sum(int a, int b) {
//        return a + b + 0.0;
//    }

    // 错误写法！与参数的名称无关
//    public static int sum(int x, int y) {
//        return x + y;
//    }

    public static int sum(double a, double b) {
        return (int) (a + b);
    }

    public static int sum(int a, int b, int c) {
        System.out.println("有3个参数的方法执行！");
        return a + b + c;
    }

    public static int sum(int a, int b, int c, int d) {
        System.out.println("有4个参数的方法执行！");
        return a + b + c + d;
    }


}
