/*
java.lang.StringBuilder类:字符串缓冲区,可以提高字符串的效率
    字符串是常量无法改变，但字符串缓冲区支持可变字符串(底层也是字符数组，但是没被final修饰，可以改变长度)

构造方法:
    StringBuilder() 构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符。
    StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
        当超出容量范围时会自动扩容

StringBuilder的常用方法:
     public StringBuilder append(...)：添加任意类型数据的字符串形式，并返回当前对象自身。
            链式编程:方法返回值是一个对象,可以继续调用方法
                    bu.append("abc").append(1).append(true).append(8.8).append('中');

StringBuilder和String可以相互转换:
    String->StringBuilder:可以使用StringBuilder的构造方法
        StringBuilder(String str) 构造一个字符串生成器，并初始化为指定的字符串内容。
    StringBuilder->String:可以使用StringBuilder中的toString方法
        public String toString()：将当前StringBuilder对象转换为String对象。

*/

public class StringBuilder类 {
}
