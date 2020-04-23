/*
java.utils.Collections是集合工具类，用来对集合进行操作。部分方法如下：
    public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加一些元素。
            Collections.addAll(list,"a","b","c","d","e");
    public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序。
            Collections.shuffle(list);
    public static <T> void sort(List<T> list):将集合中元素按照默认规则排序。
            自定义类需要实现comparable<类名>接口
            并重写接口中的方法compareTo定义排序的规则（自己(this)-参数:升序），加个负号就是降序
                    public int compareTo(Person o) {
                        //return 0;//认为元素都是相同的
                        //自定义比较的规则,比较两个人的年龄(this,参数Person)
                        return this.getAge() - o.getAge(); //年龄升序排序
                        return -(this.getAge() - o.getAge()); //年龄降序排序


JDK9的新特性:
    List接口,Set接口,Map接口:里边增加了一个静态的方法of,可以给集合一次性添加多个元素
    static <E> List<E> of​(E... elements)
    使用前提:
        当集合中存储的元素的个数已经确定了,不在改变时使用
     注意:
        1.of方法只适用于List接口,Set接口,Map接口,不适用于接接口的实现类
        2.of方法的返回值是一个不能改变的集合,集合不能再使用add,put方法添加元素,会抛出异常
        3.Set接口和Map接口在调用of方法的时候,不能有重复的元素,否则会抛出异常

 */


import java.util.ArrayList;
import java.util.Collections;

public class Collections工具类 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        //往集合中添加多个元素
        /*list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");*/

        //public static <T> boolean addAll(Collection<T> c, T... elements):往集合中添加一些元素。
        Collections.addAll(list,"a","b","c","d","e");

        System.out.println(list);//[a, b, c, d, e]

        //public static void shuffle(List<?> list) 打乱顺序:打乱集合顺序。
        Collections.shuffle(list);
        System.out.println(list);//[b, d, c, a, e], [b, d, c, a, e]
    }
}
