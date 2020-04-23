/*
类的方法一般通常都必须创建对象来调用其方法，
但是如果这个类含有的是静态方法，也就是具有static修饰的方法，
可以不需要创建对象，直接可以调用。

Arrays这个类是个工具类，Java 为工具类命名规则是加添以个 s
比如：
    Collections 是操作 Collection 的工具类
    Objects 是操作 Object 的工具类【Java 7 新增】
    Paths 是操作 Path 的工具类 【Java 7 新增】，
    工具类里包含的都是 static 方法，就是直接通过 类名 就可以调用的，而不需要创建实例去调用
    这些工具类的构造器都被 private 修饰了（重点！！！），是不能被调用的。
    而且使用它们的静态方法也不需要为它们创建实例


java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。


public static String toString(数组)：将参数数组变成字符串（按照默认格式：[元素1, 元素2, 元素3...]）
    String Str = Arrays.toString(数组名)； //返回到一个新的String中

public static void sort(数组)：按照默认升序（从小到大）对数组的元素进行排序。
    Arrays.sort(数组名);
        备注：
        1. 如果是数值，sort默认按照升序从小到大
        2. 如果是字符串，sort默认按照字母升序
        3. 如果是自定义的类型，那么这个自定义的类需要有Comparable或者Comparator接口的支持。（今后学习）

public static int[] copyOf(int[] 原数组, int 复制长度)
    返回一个复制后的新数组，如果复制长度大于原数组长度会补0


public static void fill(int[] a, [form, to,] int var) ：替换数组的值
    a--数组
    form--替换开始位置（包括）
    to--替换结束位置（不包括）,不填这两个则为全数组替换
    var--要替换的值




*/

import java.util.Arrays;

public class Arrays数组工具类 {

    public static void main(String[] args) {
        int[] intArray = {10, 20, 30};
        // 将int[]数组按照默认格式变成字符串
        String intStr = Arrays.toString(intArray);
        System.out.println(intStr); // [10, 20, 30]

        int[] array1 = {2, 1, 3, 10, 6};
        Arrays.sort(array1);
        System.out.println(Arrays.toString(array1)); // [1, 2, 3, 6, 10]

        String[] array2 = {"bbb", "aaa", "ccc"};
        Arrays.sort(array2);
        System.out.println(Arrays.toString(array2)); // [aaa, bbb, ccc]
    }
}
