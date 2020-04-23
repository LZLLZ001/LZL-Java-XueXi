/*
包装类：
    基本数据类型使用起来很方便，但是没有对应的方法来操作这些基本类型的数据，
    可以使用一个类，把基本类型的数据包装起来，在类中定义一些方法，这个类就
    叫做包装类，我们可以使用类中的方法来操作这些基本类型的数据。

            基本类型    对应包装类
            byte       Byte
            short      Short
            int        Integer
            long       Long
            float      Float
            double     Double
            char       Character
            boolean    Boolean
       记法：除了Integer、Character其他都只是首字母变大写


装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
    构造方法:
        Integer(int value) 构造一个新分配的 Integer 对象，它表示指定的 int 值。
        Integer(String s) 构造一个新分配的 Integer 对象，它表示 String 参数所指示的 int 值。
            传递的字符串,必须是基本类型(数字类型)的字符串,否则会抛出异常 "100" 正确  "a" 抛异常
    静态方法:
        static Integer valueOf(int i) 返回一个表示指定的 int 值的 Integer 实例。
        static Integer valueOf(String s) 返回保存指定的 String 的值的 Integer 对象。
拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
    成员方法:
        int intValue() 以 int 类型返回该 Integer 的值。


自动装箱与自动拆箱:基本类型的数据和包装类之间可以自动的相互转换
     自动装箱:直接把int类型的整数赋值包装类
            Integer in = 1; 就相当于 Integer in = new Integer(1);

     自动拆箱:in是包装类,无法直接参与运算,可以自动转换为基本数据类型,在进行计算
            in+2;就相当于 in.intVale() + 2 = 3
            in = in.intVale() + 2 = 3 又是一个自动装箱

         再例如：
            ArrayList<Integer> list = new ArrayList<>();
            ist.add(1); //-->自动装箱 list.add(new Integer(1));
            int a = list.get(0); //-->自动拆箱  list.get(0).intValue();


基本类型与字符串类型之间的相互转换
    基本类型->字符串(String)
        1.基本类型的值+""  最简单的方法(工作中常用)
        2.包装类的静态方法toString(参数),不是Object类的toString() 重载
            static String toString(int i) 返回一个表示指定整数的 String 对象。
        3.String类的静态方法valueOf(参数)
            static String valueOf(int i) 返回 int 参数的字符串表示形式。
    字符串(String)->基本类型
        使用包装类的静态方法parseXXX("字符串");
            Integer类: static int parseInt(String s)
            Double类: static double parseDouble(String s)


 */




public class 包装类 {
    public static void main(String[] args) {
        //装箱:把基本类型的数据,包装到包装类中(基本类型的数据->包装类)
        //构造方法
        Integer in1 = new Integer(1);//方法上有横线,说明方法过时了
        System.out.println(in1);//1 重写了toString方法

        Integer in2 = new Integer("1");
        System.out.println(in2);//1

        //静态方法
        Integer in3 = Integer.valueOf(1);
        System.out.println(in3);

        //Integer in4 = Integer.valueOf("a");//NumberFormatException数字格式化异常
        Integer in4 = Integer.valueOf("1");
        System.out.println(in4);

        //拆箱:在包装类中取出基本类型的数据(包装类->基本类型的数据)
        int i = in1.intValue();
        System.out.println(i);



        //基本类型->字符串(String)
        int i1 = 100;
        String s1 = i1+"";
        System.out.println(s1+200);//100200

        String s2 = Integer.toString(100);
        System.out.println(s2+200);//100200

        String s3 = String.valueOf(100);
        System.out.println(s3+200);//100200

        //字符串(String)->基本类型
        int i2 = Integer.parseInt(s1);
        System.out.println(i2-10);

        int a = Integer.parseInt("a");//NumberFormatException
        System.out.println(a);

    }

}
