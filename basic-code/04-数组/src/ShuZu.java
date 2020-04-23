/*
数组的概念：是一种容器，可以同时存放多个数据值。

数组的特点：
    1. 数组是一种引用数据类型
    2. 数组中的数据类型必须统一
    3. 数组的长度在程序运行期间不可改变
            int[] arrayC = new int[3];
            arrayC = new int[5];
            这里实际上是两个数组，在堆中有两个，但是第一个int[3]数组没法使用了


数组的初始化：在内存当中创建一个数组，并且向其中赋予一些默认值。
        动态初始化（指定长度）：在创建数组的时候，直接指定数组当中的数据元素个数。
        静态初始化（指定内容）：在创建数组的时候，不直接指定数据个数多少，而是直接将具体的数据内容进行指定。


动态初始化数组的格式：
    数据类型[] 数组名称 = new 数据类型[数组长度];
    int[] arrayA = new int[300];
        1. 解析含义：
                左侧的中括号：代表我是一个数组
                右侧的new：代表创建数组的动作
                右侧数据类型：必须和左边的数据类型保持一致

        2. 使用动态初始化数组的时候，其中的元素将会自动拥有一个默认值。规则如下：
                如果是整数类型，那么默认为0；
                如果是浮点类型，那么默认为0.0；
                如果是字符类型，那么默认为'\u0000'；
                如果是布尔类型，那么默认为false；
                如果是引用类型，那么默认为null。
                    注意事项：
                    静态初始化其实也有默认值的过程，只不过系统自动马上将默认值替换成为了大括号当中的具体数值。



静态初始化基本格式：
    数据类型[] 数组名称 = new 数据类型[] { 元素1, 元素2, ... };
    String[] arrayB = new String[] { "Hello", "World", "Java" };
                        此时这里面不能填数字
    省略格式：
    数据类型[] 数组名称 = { 元素1, 元素2, ... };
    int[] arrayA = {10, 20, 30};
        注意事项：
        1. 静态初始化没有直接指定长度，但是仍然会自动推算得到长度。
        2. 静态初始化标准格式可以拆分成为两个步骤。
        3. 动态初始化也可以拆分成为两个步骤。
        4. 静态初始化一旦使用省略格式，就不能拆分成为两个步骤了。

使用建议：
    如果不确定数组当中的具体内容，用动态初始化；否则，已经确定了具体的内容，用静态初始化。


访问数组元素的格式：数组名称[索引值]
    索引值：就是一个int数字，代表数组当中元素的编号。
    【注意】索引值从0开始，一直到“数组的长度-1”为止。

    直接写数组名称则为此数组的地址：
        System.out.println(array); // 打印此数组的地址值
        int[] arrayB = arrayA; // 将arrayA数组的地址值，赋值给arrayB数组，此时AB为同一个数组

每个new都在堆中开辟一个独立的空间


数组方法：
    1. 数组名称.length   //这将会得到一个int数字，代表数组的长度。
    2. 数组名称.fori  //生成遍历数组快捷方式
    3. 作为参数的方法定义：public static void fun(int[] array) {}
                    调用：fun(array);   //传此数组的地址值
    4. 作为返回值的方法定义：public static int[] fun(int b) {return array;}    //返回的其实也是数组的地址值
                    调用：int[] result = fun(10);


任何数据类型都能作为方法的参数类型，或者返回值类型。


*/

public class ShuZu {
    public static void main(String[] args) {
        // 创建一个数组，里面可以存放300个int数据
        // 格式：数据类型[] 数组名称 = new 数据类型[数组长度];
        int[] array1 = new int[300];

        // 创建一个数组，用来装字符串："Hello"、"World"、"Java"
        String[] array2 = new String[]{"Hello", "World", "Java"};

        // 省略格式的静态初始化
        int[] arrayA = {10, 20, 30};

        // 静态初始化的标准格式，可以拆分成为两个步骤
        int[] arrayB;
        arrayB = new int[]{11, 21, 31};

        // 动态初始化也可以拆分成为两个步骤
        int[] arrayC;
        arrayC = new int[5];

        // 静态初始化的省略格式，不能拆分成为两个步骤。
//        int[] arrayD;
//        arrayD = { 10, 20, 30 };


        // 动态初始化一个数组
        int[] array = new int[3];

        System.out.println(array); // 内存地址值
        System.out.println(array[0]); // 0
        System.out.println(array[1]); // 0
        System.out.println(array[2]); // 0
        System.out.println("=================");

        // 将数据123赋值交给数组array当中的1号元素
        array[1] = 123;
        System.out.println(array[0]); // 0
        System.out.println(array[1]); // 123
        System.out.println(array[2]); // 0


        // 静态初始化的省略格式
        int[] array3 = { 10, 20, 30 };

        System.out.println(array3); // [I@75412c2f

        // 直接打印数组当中的元素
        System.out.println(array3[0]); // 10
        System.out.println(array3[1]); // 20
        System.out.println(array3[2]); // 30
        System.out.println("=============");

        // 也可以将数组当中的某一个单个元素，赋值交给变量
        int num = array3[1];
        System.out.println(num); // 20
    }
}
