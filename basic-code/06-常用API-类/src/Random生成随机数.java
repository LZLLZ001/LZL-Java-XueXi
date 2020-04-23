/*
Random类用来生成随机数字：

    1. 导包
        import java.util.Random;
    2. 创建对象
        Random r = new Random(); // 小括号当中留空即可
    3. 使用
        获取一个随机的int数字（范围是int所有范围，有正负两种）：int num = r.nextInt();
        获取一个随机的int数字（参数代表了范围，左闭右开区间,只能填正数）：int num = r.nextInt(3);
                                                //实际上代表的含义是：[0,3)，也就是0~2


*/


import java.util.Random;

public class Random生成随机数 {
    public static void main(String[] args) {
        Random r = new Random();

        int num = r.nextInt();
        System.out.println("随机数是：" + num);

        int num2 = r.nextInt(10); // 范围实际上是0~9
        System.out.println("随机数是：" + num2);
    }

}
