/*
快速排序（Quicksort）
    冒泡排序的一种改进。
    先任意找一个数据中的数字(如第一个或者中间一个)作为参考，
    通过一趟快速排序将要排序的数据分割成独立的两部分，
    其中一部分的所有数据都比另外一部分的所有数据都要小，
    然后再按此方法对这两部分数据分别进行快速排序，
    整个排序过程可以递归进行，以此达到整个数据变成有序序列

    例如：把中间的数字作为参考，从左右两边分别向中间扫描，对比左右扫描到的数字与参考数字的大小，
         若左边的大于参考数字，右边的小于参考数字，则将这两个数字交换位置。
         扫描完一轮后左边的数字都小于参考数字，右边的都大于。
         然后左边和右边使用同样的方法递归。最后完成排序。



优势：速度很快


*/

public class 快速排序 {
}
