/*
java.util.Map<k,v>集合

Map集合的特点:
    1.Map集合是一个双列集合,一个元素包含两个值(一个key,一个value)
    2.Map集合中的元素,key和value的数据类型可以相同,也可以不同
    3.Map集合中的元素,key是不允许重复的,value是可以重复的
    4.Map集合中的元素,key和value是一一对应


Map集合中的方法:
public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
    返回值:v
        存储键值对的时候,key不重复,返回值V是null
        存储键值对的时候,key重复,会使用新的value替换map中重复的value,返回被替换的value值


public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
    返回值:V
        key存在,v返回被删除的值
        key不存在,v返回null


public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
    返回值:V
        key存在,返回对应的value值
        key不存在,返回null

boolean containsKey(Object key) 判断集合中是否包含指定的键。
    包含返回true,不包含返回false


Map集合的第一种遍历方式:通过键找值的方式
    Map集合中的方法:
         Set<K> keySet() 返回此映射中包含的键的 Set 视图。
    实现步骤:
        1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
        2.遍历set集合,获取Map集合中的每一个key
        3.通过Map集合中的方法get(key),通过key找到value

Map集合遍历的第二种方式:使用Entry对象遍历
    Map集合中的方法:
        Set<Map.Entry<K,V>> entrySet() 返回此映射中包含的映射关系的 Set 视图。
    实现步骤:
        1.使用Map集合中的方法entrySet(),把Map集合中多个Entry对象取出来,存储到一个Set集合中
        2.遍历Set集合,获取每一个Entry对象
        3.使用Entry对象中的方法getKey()和getValue()获取键与值





java.util.HashMap<k,v>集合 implements Map<k,v>接口
HashMap集合的特点:
    1.HashMap集合底层是哈希表:查询的速度特别的快
        JDK1.8之前:数组+单向链表
        JDK1.8之后:数组+单向链表|红黑树(链表的长度超过8):提高查询的速度
    2.hashMap集合是一个无序的集合,存储元素和取出元素的顺序有可能不一致

HashMap存储自定义类型键值
    Map集合保证key是唯一的:
        作为key的元素,必须重写hashCode方法和equals方法,以保证key唯一



java.util.LinkedHashMap<k,v>集合 extends HashMap<k,v>集合
LinkedHashMap的特点:
    1.LinkedHashMap集合底层是哈希表+链表(保证迭代的顺序)
    2.LinkedHashMap集合是一个有序的集合,存储元素和取出元素的顺序是一致的








 */

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Map接口 {
    public static void main(String[] args) {
        show04();
    }

    /*
        boolean containsKey(Object key) 判断集合中是否包含指定的键。
        包含返回true,不包含返回false
     */
    private static void show04() {
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        boolean b1 = map.containsKey("赵丽颖");
        System.out.println("b1:"+b1);//b1:true

        boolean b2 = map.containsKey("赵颖");
        System.out.println("b2:"+b2);//b2:false

        //1.使用Map集合中的方法keySet(),把Map集合所有的key取出来,存储到一个Set集合中
        Set<String> set = map.keySet();

        //2.遍历set集合,获取Map集合中的每一个key
        //使用迭代器遍历Set集合
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String key = it.next();
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("-------------------");
        //使用增强for遍历Set集合
        for(String key : set){
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        System.out.println("-------------------");
        //使用增强for遍历Set集合
        for(String key : map.keySet()){
            //3.通过Map集合中的方法get(key),通过key找到value
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }


        Set<Map.Entry<String, Integer>> set1 = map.entrySet();

        //2.遍历Set集合,获取每一个Entry对象
        //使用迭代器遍历Set集合
        Iterator<Map.Entry<String, Integer>> it1 = set1.iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it1.next();
            //3.使用Entry对象中的方法getKey()和getValue()获取键与值
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key+"="+value);
        }
    }

    /*
        public V get(Object key) 根据指定的键，在Map集合中获取对应的值。
            返回值:
                key存在,返回对应的value值
                key不存在,返回null
     */
    private static void show03() {
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);

        Integer v1 = map.get("杨颖");
        System.out.println("v1:"+v1);//v1:165

        Integer v2 = map.get("迪丽热巴");
        System.out.println("v2:"+v2);//v2:null
    }

    /*
        public V remove(Object key): 把指定的键 所对应的键值对元素 在Map集合中删除，返回被删除元素的值。
            返回值:V
                key存在,v返回被删除的值
                key不存在,v返回null
     */
    private static void show02() {
        //创建Map集合对象
        Map<String,Integer> map = new HashMap<>();
        map.put("赵丽颖",168);
        map.put("杨颖",165);
        map.put("林志玲",178);
        System.out.println(map);//{林志玲=178, 赵丽颖=168, 杨颖=165}

        Integer v1 = map.remove("林志玲");
        System.out.println("v1:"+v1);//v1:178

        System.out.println(map);//{赵丽颖=168, 杨颖=165}

        //int v2 = map.remove("林志颖");//自动拆箱  NullPointerException
        Integer v2 = map.remove("林志颖");
        System.out.println("v2:"+v2);//v2:null

        System.out.println(map);//{赵丽颖=168, 杨颖=165}
    }

    /*
        public V put(K key, V value):  把指定的键与指定的值添加到Map集合中。
            返回值:v
                存储键值对的时候,key不重复,返回值V是null
                存储键值对的时候,key重复,会使用新的value替换map中重复的value,返回被替换的value值
     */
    private static void show01() {
        //创建Map集合对象,多态
        Map<String,String> map = new HashMap<>();

        String v1 = map.put("李晨", "范冰冰1");
        System.out.println("v1:"+v1);//v1:null

        String v2 = map.put("李晨", "范冰冰2");
        System.out.println("v2:"+v2);//v2:范冰冰1

        System.out.println(map);//{李晨=范冰冰2}

        map.put("冷锋","龙小云");
        map.put("杨过","小龙女");
        map.put("尹志平","小龙女");
        System.out.println(map);//{杨过=小龙女, 尹志平=小龙女, 李晨=范冰冰2, 冷锋=龙小云}
    }
}
