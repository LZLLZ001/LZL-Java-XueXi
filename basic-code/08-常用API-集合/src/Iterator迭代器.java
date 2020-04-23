/*

java.util.Iterator接口:迭代器(对集合进行遍历)

两个常用方法
    boolean hasNext() 如果仍有元素可以迭代，则返回 true。
        判断集合中还有没有下一个元素,有就返回true,没有就返回false
    E next() 返回迭代的下一个元素，并且索引+1。
        取出集合中的下一个元素

Iterator迭代器,是一个接口,我们无法直接使用,需要使用Iterator接口的实现类对象,获取实现类的方式比较特殊
Collection接口中有一个方法,叫iterator(),这个方法返回的就是迭代器的实现类对象
    Iterator<E> iterator() 返回在此 collection 的元素上进行迭代的迭代器。

迭代器的使用步骤(重点):
    1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
    2.使用Iterator接口中的方法hasNext判断还有没有下一个元素
    3.使用Iterator接口中的方法next取出集合中的下一个元素


增强for循环(用来遍历集合和数组)：
    底层使用的也是迭代器,使用for循环的格式,简化了迭代器的书写;
    Collection<E>extends Iterable<E>:所有的单列集合都可以使用增强for;
    public interface Iterable<T>实现这个接口允许对象成为 "foreach" 语句的目标。

    格式:
    for(集合/数组的数据类型 变量名: 集合名/数组名){
        System.out.println(变量名);
    }

 */


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Iterator迭代器 {
    public static void main(String[] args) {
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        //往集合中添加元素
        coll.add("姚明");
        coll.add("科比");
        coll.add("麦迪");
        coll.add("詹姆斯");
        coll.add("艾弗森");

        /*
            1.使用集合中的方法iterator()获取迭代器的实现类对象,使用Iterator接口接收(多态)
            注意:
                Iterator<E>接口也是有泛型的,迭代器的泛型跟着集合走,集合是什么泛型,迭代器就是什么泛型
         */
        //多态  接口            实现类对象
        Iterator<String> it = coll.iterator();//获取迭代器的实现类对象，并且会把指针(索引)指向集合的-1索引


        /*
            发现使用迭代器取出集合中元素的代码,是一个重复的过程
            所以我们可以使用循环优化
            不知道集合中有多少元素,使用while循环
            循环结束的条件,hasNext方法返回false
         */
        while(it.hasNext()){
            String e = it.next();
            System.out.println(e);
        }
        System.out.println("----------------------");
        for(Iterator<String> it2 = coll.iterator();it2.hasNext();){
            String e = it2.next();
            System.out.println(e);
        }

    }


    private static void demo02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        for(String s : list){
            System.out.println(s);
        }
    }

    //使用增强for循环遍历数组
    private static void demo01() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
