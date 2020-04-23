/*

Stream流是JDK1.8之后出现的，关注的是做什么,而不是怎么做(其实就是一个便利处理集合的工具)
    Stream流和I/O流不同，它更像具有Iterable的集合类，但行为和集合类又有所不同。
    Stream是对集合、数组对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作，或者打批量数据操作。

java.util.stream.Stream<T>是Java 8新加入的最常用的流接口。（这并不是一个函数式接口。）
    获取一个流有以下几种常用的方式：
        - 所有的Collection集合都可以通过stream默认方法获取流；
            default Stream<E> stream​()
                    List<String> list1 = new ArrayList<>();
                    Stream<String> stream1 = list1.stream();
        - Stream接口的静态方法of可以获取数组对应的流。
            static <T> Stream<T> of​(T... values)
            参数是一个可变参数,那么我们就可以传递一个数组
                    Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
                    Integer[] arr = {1,2,3,4,5};
                    Stream<Integer> stream7 = Stream.of(arr);



Stream流属于管道流,只能被消费(使用)一次
    第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
    而这时第一个Stream流已经使用完毕,就会关闭了
    所以第一个Stream流就不能再调用方法了
    IllegalStateException: stream has already been operated upon or closed



Stream流中的常用方法：
    延迟方法：返回的是一个新的流,所以可以继续调用Stream流中的其他方法(在后面继续.链式编程)
    终结方法：返回其他类型，之后就不能继续调用Stream流中的其他方法(只有forEach、count这两个是终结)

2终+5延
void forEach(Consumer<? super T> action);
    用于对Stream流中的数据进行遍历
        该方法接收一个Consumer接口函数，会将每一个流元素交给该函数进行处理。
        Consumer接口是一个消费型的函数式接口,可以传递Lambda表达式,消费数据
    stream.forEach(name->System.out.println(name));
        简单记:
            forEach方法,用来遍历流中的数据
            是一个终结方法,遍历之后就不能继续调用Stream流中的其他方法


long count();
    用于统计Stream流中元素的个数
        count方法是一个终结方法,返回值是一个long类型的整数
        所以不能再继续调用Stream流中的其他方法了
    long count = stream.count();



Stream<T> limit(long maxSize);
    对流进行截取，只取用前n个
        参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作
    Stream<String> stream2 = stream.limit(3);


Stream<T> skip(long n);
    跳过前几个元素，获取一个截取之后的新流：
        如果流的当前长度大于n，则跳过前n个；否则将会得到一个长度为0的空流。
    Stream<String> stream2 = stream.skip(3);


static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)
    把两个流合并成为一个流
    Stream<String> stream2 = Stream.concat(stream1, stream2);


Stream<T> filter(Predicate<? super T> predicate);       //filter过滤，Predicate断言
    用于对Stream流中的数据进行过滤
        filter方法的参数Predicate是一个函数式接口,所以可以传递Lambda表达式,对数据进行过滤
        Predicate中的抽象方法:
            boolean test(T t);
    Stream<String> stream2 = stream.filter((String name)->{return name.startsWith("张");});


<R> Stream<R> map(Function<? super T, ? extends R> mapper);
    将流中的元素映射到另一个流中
        该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
        Function中的抽象方法:
            R apply(T t);
    Stream<Integer> stream11 = stream10.map((String s)->{
        return Integer.parseInt(s);
    });



 */


import java.util.*;
import java.util.stream.Stream;

public class Stream流 {
    public static void main(String[] args) {
        //创建一个List集合,存储姓名
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");

        //对list集合中的元素进行过滤,只要以张开头的元素,存储到一个新的集合中
        //对listA集合进行过滤,只要姓名长度为3的人,存储到一个新集合中
        //遍历listB集合
        list.stream()
                .filter(name->name.startsWith("张"))
                .filter(name->name.length()==3)
                .forEach(name-> System.out.println(name));

        //把集合转换为Stream流
        List<String> list1 = new ArrayList<>();
        Stream<String> stream1 = list1.stream();

        Set<String> set = new HashSet<>();
        Stream<String> stream2 = set.stream();

        Map<String,String> map = new HashMap<>();
        //获取键,存储到一个Set集合中
        Set<String> keySet = map.keySet();
        Stream<String> stream3 = keySet.stream();

        //获取值,存储到一个Collection集合中
        Collection<String> values = map.values();
        Stream<String> stream4 = values.stream();

        //获取键值对(键与值的映射关系 entrySet)
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Stream<Map.Entry<String, String>> stream5 = entries.stream();

        //把数组转换为Stream流
        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5);
        //可变参数可以传递数组
        Integer[] arr = {1,2,3,4,5};
        Stream<Integer> stream7 = Stream.of(arr);
        String[] arr2 = {"a","bb","ccc"};
        Stream<String> stream8 = Stream.of(arr2);


        //获取一个Stream流
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        //使用Stream流中的方法forEach对Stream流中的数据进行遍历
        /*stream.forEach((String name)->{
            System.out.println(name);
        });*/
        //对Stream流中的元素进行过滤,只要姓张的人
        Stream<String> stream9 = stream.filter((String name)->{return name.startsWith("张");});
        stream9.forEach(name->System.out.println(name));


        //获取一个String类型的Stream流
        Stream<String> stream10 = Stream.of("1", "2", "3", "4");
        //使用map方法,把字符串类型的整数,转换(映射)为Integer类型的整数
        Stream<Integer> stream11 = stream10.map((String s)->{
            return Integer.parseInt(s);
        });
        //遍历Stream2流
        stream11.forEach(i-> System.out.println(i));

    }

}
