/*
插入排序：
    把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，
    排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，
    将它插入到有序表中的适当位置，使之成为新的有序表。重复n-1次


存在的问题：当需要插入的数是较小的数时，后移的次数明显增多，对效率有影响.
    所以采用希尔排序



*/


public class 插入排序 {
}
