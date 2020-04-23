/*

KMP算法：
    解决模式串匹配题：返回在文本串中最早出现的位置；
    思想：
        利用部分匹配表，不要把”搜索位置”移回已经比较过的位置，继续把它向后移到指定位置，提高了效率
        参考资料：https://www.cnblogs.com/ZuoAndFutureGirl/p/9028287.html


部分匹配表：
    部分匹配值：前缀和后缀的最长的共有元素的长度，即后面与前面重合元素的个数。以”ABCDABD”为例，
            －“A”的前缀和后缀都为空集，共有元素的长度为0；
            －“AB”的前缀为[A]，后缀为[B]，共有元素的长度为0；
            －“ABC”的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
            －“ABCD”的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
            －“ABCDA”的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为”A”，长度为1；后面与前面重合1个元素
            －“ABCDAB”的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为”AB”，长度为2；后面与前面重合2个元素
            －“ABCDABD”的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD, D]，共有元素的长度为0。
    则对应的部分匹配表为：
              ABCDABD
              0000120
        //获取到一个字符串(子串) 的部分匹配值表
        public static  int[] kmpNext(String dest) {
            //创建一个next 数组保存部分匹配值
            int[] next = new int[dest.length()];
            next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
            for(int i = 1, j = 0; i < dest.length(); i++) {
                //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
                //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
                //这是kmp算法的核心点
                while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                    j = next[j-1];
                }
                //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
                if(dest.charAt(i) == dest.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }

移动位数 = 已匹配的字符数 - 对应的部分匹配值




*/


public class KMP算法 {
}
