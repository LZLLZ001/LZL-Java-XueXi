/*
java.lang.String类代表字符串。
    程序当中所有的双引号字符串，都是String类的对象。（就算没有new，也照样是。）

字符串的特点：
    1. 字符串是常量，值在创建之后不能更改。【重点】
    2. 字符串是可以共享使用的。
    3. 字符串效果上相当于是char[]字符数组，但是底层原理是byte[]字节数组。

创建字符串的常见3+1种方式。
    三种构造方法：
        public String()：创建一个空白字符串，不含有任何内容。
            String str1 = new String();

        public String(char[] array)：根据字符数组的内容，来创建对应的字符串。
            char[] charArray = { 'A', 'B', 'C' };
            String str2 = new String(charArray);

        public String(byte[] array)：根据字节数组的内容，来创建对应的字符串。
            byte[] byteArray = { 97, 98, 99 };
            String str3 = new String(byteArray);

    一种直接创建：
        String str = "Hello"; // 直接写上双引号，就是字符串对象(系统会自动new)。
                              // 使用String的方法时，strA.方法 与 "  ".方法 两种形式都行


字符串常量池：程序当中（只有）直接写上的双引号字符串，就（才）在字符串常量池中。(自己手动new的不在池中)

2+4+2+3+1
字符串内容比较：
    ==是进行对象的地址值比较，字符串的内容比较使用两个方法：
    public boolean equals(Object obj)：区分大小写。参数可以是任何对象，只有参数是一个字符串并且内容相同的才会给true；否则返回false。
    public boolean equalsIgnoreCase(String str)：忽略大小写，进行内容比较。
        strA.equals(strB);
        strA.equals("Hello");
        "Hello".equals(strA);
                注意事项：
                    1. 任何对象都能用Object进行接收。
                    2. equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样。
                    3. 如果比较双方一个常量一个变量，推荐把常量字符串写在前面。
                        推荐："abc".equals(str)    不推荐：str.equals("abc")

    public boolean matches(regex): 匹配正则表达式则返回true
        正则表达式：定义字符串的组成规则。
            <1> 单个字符:[]  这个字符为[]内出现的其中一个字符
                如： [a](字符a)   [ab](字符a或b)  [a-zA-Z](任意一个a-z的字符 或 任意一个A-Z的字符)
                特殊符号代表特殊含义的单个字符:
                    \d: 单个数字字符 [0-9]
                    \w: 单个单词字符[a-zA-Z0-9_]
            <2> 量词符号：跟在需要限量元素后
                ?：表示出现0次或1次
                *：表示出现0次或多次
                +：出现1次或多次
                {m,n}:表示 m<= 数量 <= n
                      m如果缺省：a{,n}:a最多n次
                      n如果缺省：{m,} 最少m次
            <3> 开始结束符号（可省略）
                 ^:开始
                 $:结束

String获取相关方法：
    public int length()：获取字符串当中含有的字符个数，拿到字符串长度。
        int length = strA.length();

    public String concat(String str)：将当前字符串和参数字符串拼接成为返回值新的字符串。
        String str3 = str2.concat(str1); //str3=str2str1

    public char charAt(int index)：获取指定索引位置的单个字符。（索引从0开始。）
        char ch = "Hello".charAt(0);

    public int indexOf(String str)：查找参数字符串在本字符串当中首次出现的索引位置，如果没有返回-1值。
        int index = strA.indexOf("llo");


字符串的截取方法：
    public String substring(int index)：截取从参数位置一直到字符串末尾，返回新字符串。
    public String substring(int begin, int end)：截取从begin开始，一直到end结束，中间的字符串。[begin,end)
          String str18 = str16.substring(5);
          String str18 = str16.substring(4, 7);


String转换相关方法：
    public char[] toCharArray()：将当前字符串拆分成为字符数组作为返回值。
        char[] chars = "Hello".toCharArray();

    public byte[] getBytes()：获得当前字符串底层的字节数组。
        byte[] bytes = "abc".getBytes();

    public String replace(CharSequence oldString, CharSequence newString)：
        将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串。
        备注：CharSequence意思就是说可以接受字符串类型。
            String strA = strB.replace("aaa", "bbb");   //将所有aaa替换成bbb

分割字符串的方法：
    public String[] split(String regex)：以参数字符串为分割线，将字符串切分成为若干部分保存在字符串数组中。
        String[] array1 = str22.split(",");     //注意使用字符串数组接收，分割后分割字符串消失

        注意事项：
            split方法的参数其实是一个“正则表达式”。如果按照英文句点“.”进行切分，必须写"\\."（两个反斜杠）


数字转字符串：""+数字； //利用字符串+号为拼接的原理
字符串转数字：Integer valueOf(String s):返回保存指定的 String 的值的 Integer 对象。


*/


public class String字符串类 {
    public static void main(String[] args) {
        // 使用空参构造
        String str1 = new String(); // 小括号留空，说明字符串什么内容都没有。
        System.out.println("第1个字符串：" + str1);

        // 根据字符数组创建字符串
        char[] charArray = { 'A', 'B', 'C' };
        String str2 = new String(charArray);
        System.out.println("第2个字符串：" + str2);

        // 根据字节数组创建字符串
        byte[] byteArray = { 97, 98, 99 };
        String str3 = new String(byteArray);
        System.out.println("第3个字符串：" + str3);

        // 直接创建
        String str4 = "Hello";
        System.out.println("第4个字符串：" + str4);

//**********************************************************************************************************************

        String str5 = "abc";
        String str6 = "abc";

        char[] charArray2 = {'a', 'b', 'c'};
        String str7 = new String(charArray2);

        //   对于基本类型来说，==是进行数值的比较。
        //   对于引用类型来说，==是进行【地址值】的比较。
        System.out.println(str5 == str6); // true
        System.out.println(str5 == str7); // false
        System.out.println(str6 == str7); // false

//**********************************************************************************************************************
        String str8 = "Hello";
        String str9 = "Hello";
        char[] charArray3 = {'H', 'e', 'l', 'l', 'o'};
        String str10 = new String(charArray3);

        System.out.println(str8.equals(str9)); // true
        System.out.println(str9.equals(str10)); // true
        System.out.println(str10.equals("Hello")); // true
        System.out.println("Hello".equals(str8)); // true

        String str11 = "hello";
        System.out.println(str8.equals(str11)); // false
        System.out.println("=================");

        String str12 = null;
        System.out.println("abc".equals(str12)); // 推荐：false
//        System.out.println(str5.equals("abc")); // 不推荐：报错，空指针异常NullPointerException
        System.out.println("=================");

        String strA = "Java";
        String strB = "java";
        System.out.println(strA.equals(strB)); // false，严格区分大小写
        System.out.println(strA.equalsIgnoreCase(strB)); // true，忽略大小写

        // 注意，只有英文字母区分大小写，其他都不区分大小写
        System.out.println("abc一123".equalsIgnoreCase("abc壹123")); // false

//**********************************************************************************************************************

        // 获取字符串的长度
        int length = "asdasfeutrvauevbueyvb".length();
        System.out.println("字符串的长度是：" + length);

        // 拼接字符串
        String str13 = "Hello";
        String str14 = "World";
        String str15 = str13.concat(str14);
        System.out.println(str13); // Hello，原封不动
        System.out.println(str14); // World，原封不动
        System.out.println(str15); // HelloWorld，新的字符串
        System.out.println("==============");

        // 获取指定索引位置的单个字符
        char ch = "Hello".charAt(1);
        System.out.println("在1号索引位置的字符是：" + ch);
        System.out.println("==============");

        // 查找参数字符串在本来字符串当中出现的第一次索引位置
        // 如果根本没有，返回-1值
        String original = "HelloWorldHelloWorld";
        int index = original.indexOf("llo");
        System.out.println("第一次索引值是：" + index); // 2

        System.out.println("HelloWorld".indexOf("abc")); // -1

//**********************************************************************************************************************

        String str16 = "HelloWorld";
        String str17 = str16.substring(5);
        System.out.println(str16); // HelloWorld，原封不动
        System.out.println(str17); // World，新字符串
        System.out.println("================");

        String str18 = str16.substring(4, 7);
        System.out.println(str18); // oWo
        System.out.println("================");

        // 下面这种写法，字符串的内容仍然是没有改变的
        // 下面有两个字符串："Hello"，"Java"
        // strA当中保存的是地址值。
        // 本来地址值是Hello的0x666，
        // 后来地址值变成了Java的0x999
        String str19 = "Hello";
        System.out.println(str19); // Hello
        str19 = "Java";
        System.out.println(str19); // Java

//**********************************************************************************************************************

        // 转换成为字符数组
        char[] chars = "Hello".toCharArray();
        System.out.println(chars[0]); // H
        System.out.println(chars.length); // 5
        System.out.println("==============");

        // 转换成为字节数组
        byte[] bytes = "abc".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println("==============");

        // 字符串的内容替换
        String str20 = "How do you do?";
        String str21 = str20.replace("o", "*");
        System.out.println(str20); // How do you do?
        System.out.println(str21); // H*w d* y*u d*?
        System.out.println("==============");

        String lang1 = "会不会玩儿呀！你大爷的！你大爷的！你大爷的！！！";
        String lang2 = lang1.replace("你大爷的", "****");
        System.out.println(lang2); // 会不会玩儿呀！****！****！****！！！

//**********************************************************************************************************************
        String str22 = "aaa,bbb,ccc";
        String[] array1 = str22.split(",");
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
        System.out.println("===============");

        String str23 = "aaa bbb ccc";
        String[] array2 = str23.split(" ");
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }
        System.out.println("===============");

        String str24 = "XXX.YYY.ZZZ";
        String[] array3 = str24.split("\\.");
        System.out.println(array3.length); // 0
        for (int i = 0; i < array3.length; i++) {
            System.out.println(array3[i]);
        }
    }
}
