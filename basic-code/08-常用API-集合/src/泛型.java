/*
泛型：一种未知的数据类型
    E e

创建集合对象,使用泛型
    好处:
        1.避免了类型转换的麻烦,存储的是什么类型,取出的就是什么类型
        2.把运行期异常(代码运行之后会抛出的异常),提升到了编译期(写代码的时候会报错)
     弊端:
        泛型是什么类型,只能存储什么类型的数据


创建集合对象,不使用泛型
    好处:
        集合不使用泛型,默认的类型就是Object类型,可以存储任意类型的数据
    弊端:
        不安全,会引发异常


含有泛型的类,模拟ArrayList集合
    泛型是一个未知的数据类型,当我们不确定什么什么数据类型的时候,可以使用泛型
    泛型可以接收任意的数据类型,可以使用Integer,String,Student...
    创建对象的时候确定泛型的数据类型
        public class GenericClass<E> {
            private E name;

            public E getName() {
                return name;
            }

            public void setName(E name) {
                this.name = name;
            }
        }

        GenericClass<Integer> gcI = new GenericClass<>();


定义含有泛型的方法:泛型定义在方法的修饰符和返回值类型之间

    格式:
        修饰符 <泛型> 返回值类型 方法名(参数列表(使用泛型)){
            方法体;
        }

    含有泛型的方法,在调用方法的时候确定泛型的数据类型
    传递什么类型的参数,泛型就是什么类型
    < >就代表泛型，可以用任意字母，不一定用E(但一般用E)
        //定义一个含有泛型的方法
        public <M> void method01(M m){
            System.out.println(m);
        }

        //定义一个含有泛型的静态方法
        public static <S> void method02(S s){
            System.out.println(s);
        }


定义含有泛型的接口：
    第一种使用方式:定义接口的实现类,实现接口,指定接口的泛型
        public interface Iterator<E> {
            E next();
        }
        Scanner类实现了Iterator接口,并指定接口的泛型为String,所以重写的next方法泛型默认就是String
        public final class Scanner implements Iterator<String>{
            public String next() {}
        }

    第二种使用方式:接口使用什么泛型,实现类就使用什么泛型,类跟着接口走
    就相当于定义了一个含有泛型的类,创建对象的时候确定泛型的类型
        public interface List<E>{
            boolean add(E e);
            E get(int index);
        }
        public class ArrayList<E> implements List<E>{
            public boolean add(E e) {}
            public E get(int index) {}
        }


泛型的通配符:
    ?:代表任意的数据类型
        使用方式:
            不能创建对象使用
            只能作为方法的参数使用

        例如：定义一个方法,能遍历所有类型的ArrayList集合
            这时候我们不知道ArrayList集合使用什么数据类型,可以泛型的通配符?来接收数据类型
            注意:泛型没有继承概念的
        public static void printArray(ArrayList<?> list){
                //使用迭代器遍历集合
                Iterator<?> it = list.iterator();
                while(it.hasNext()){
                    //it.next()方法,取出的元素是Object,可以接收任意的数据类型
                    Object o = it.next();
                    System.out.println(o);
                }
        }

    泛型的上限限定: ? extends E  代表使用的泛型只能是E类型的子类/本身
    泛型的下限限定: ? super E    代表使用的泛型只能是E类型的父类/本身
            类与类之间的继承关系
                Integer extends Number extends Object
                String extends Object
            // 泛型的上限：此时的泛型?，必须是Number类型或者Number类型的子类
            public static void getElement1(Collection<? extends Number> coll){}
            // 泛型的下限：此时的泛型?，必须是Number类型或者Number类型的父类
            public static void getElement2(Collection<? super Number> coll){}

 */


import java.util.ArrayList;
import java.util.Iterator;

public class 泛型 {
    public static void main(String[] args) {
        show02();
    }

    private static void show02() {
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        //list.add(1);//add(java.lang.String)in ArrayList cannot be applied to (int)

        //使用迭代器遍历list集合
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String s = it.next();
            System.out.println(s+"->"+s.length());
        }
    }

    private static void show01() {
        ArrayList list = new ArrayList();
        list.add("abc");
        list.add(1);

        //使用迭代器遍历list集合
        //获取迭代器
        Iterator it = list.iterator();
        //使用迭代器中的方法hasNext和next遍历集合
        while(it.hasNext()){
            //取出元素也是Object类型
            Object obj = it.next();
            System.out.println(obj);

            //想要使用String类特有的方法,length获取字符串的长度;不能使用  多态 Object obj = "abc";
            //需要向下转型
            //会抛出ClassCastException类型转换异常,不能把Integer类型转换为String类型
            String s = (String)obj;
            System.out.println(s.length());
        }
    }
}
