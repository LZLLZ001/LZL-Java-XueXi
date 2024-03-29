/*
java.util.Set接口 extends Collection接口

Set接口的特点:
    1.不允许存储重复的元素
    2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历


java.util.HashSet集合 implements Set接口
HashSet特点:
     1.不允许存储重复的元素(看图)
     2.没有索引,没有带索引的方法,也不能使用普通的for循环遍历,能用迭代器或者增强for
     3.是一个无序的集合,存储元素和取出元素的顺序有可能不一致
     4.底层是一个哈希表结构(数组+链表/红黑树)(查询的速度非常的快)(看图)
     5.HashSet存储自定义类型元素(String,Integer,...Student,Person...),必须重写hashCode方法和equals方法(直接用快捷添加)


哈希值:是一个十进制的整数,由系统随机给出(就是对象的地址值,是一个逻辑地址,是模拟出来得到地址,不是数据实际存储的物理地址)
    在Object类有一个方法,可以获取对象的哈希值
    int hashCode() 返回该对象的哈希码值。
    hashCode方法的源码:
        public native int hashCode();
        native:代表该方法调用的是本地操作系统的方法


java.util.LinkedHashSet集合 extends HashSet集合
LinkedHashSet集合特点:
    底层是一个哈希表(数组+链表/红黑树)+链表:多了一条链表(记录元素的存储顺序),保证元素有序


 */


import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Set接口 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        //使用add方法往集合中添加元素
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);
        //使用迭代器遍历set集合
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            Integer n = it.next();
            System.out.println(n);//1,2,3
        }
        //使用增强for遍历set集合
        System.out.println("-----------------");
        for (Integer i : set) {
            System.out.println(i);
        }
    }

}
