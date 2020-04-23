/*
java.util.Date:表示日期和时间的类，精确到毫秒
    可以对时间和日期进行计算(日期转换为毫秒进行计算,计算完毕,在把毫秒转换为日期)
        日期转换为毫秒:当前日期到时间原点(1970 年 1 月 1 日 00:00:00(英国格林威治))之间一共经历了多少毫秒


Date date = new Date();//获取当前系统的日期和时间
    System.out.println(date)
    Date类的空参数构造方法

Date date = new Date(0L);
    System.out.println(date);
    Date类的带参数构造方法
    Date(long date) :传递毫秒值,把毫秒值转换为Date日期

long getTime()
    把日期转换为毫秒值(相当于System.currentTimeMillis()方法)
    返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time);


java.text.DateFormat:是日期/时间格式化子类的抽象类
    作用:
        格式化（也就是日期 -> 文本）、解析（文本-> 日期）
    DateFormat类是一个抽象类,无法直接创建对象使用,可以使用DateFormat类的子类

    java.text.SimpleDateFormat extends DateFormat

    构造方法:
        SimpleDateFormat sdf = SimpleDateFormat(String pattern);
          用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
        参数:
             String pattern:传递指定的模式
        模式:区分大小写的
            y   年
            M   月
            d   日
            H   时
            m   分
            s   秒
        写对应的模式,会把模式替换为对应的日期和时间
            "yyyy-MM-dd HH:mm:ss"
        注意:
            模式中的字母不能更改,连接模式的符号可以改变
             "yyyy年MM月dd日 HH时mm分ss秒"
    成员方法:
        String format(Date date)  按照指定的模式,把Date日期,格式化为符合模式的字符串
            Date date = new Date();
            String d = sdf.format(date);
        Date parse(String source)  把符合模式的字符串,解析为Date日期  //parse：分析
            Date date = sdf.parse(String pattern);//pattern要与sdf一致,因为定义了异常处理，需要抛出异常

 */



public class Date类 {
}
