/*
递归：方法自己调用自己，每次调用时传入不同的变量


递归调用规则：
    1. 执行一个方法时，就创建一个新的受保护的独立空间(栈空间)
    2. 方法的局部变量是独立的，不会相互影响
    3. 如果方法中使用的是引用类型变量(比如数组)，就会共享该引用类型的数据.
    4. 递归必须向退出递归的条件逼近，否则就是无限递归,出现StackOverflowError，死归了
    5. 当一个方法执行完毕，或者遇到return，就会返回，遵守谁调用，就将结果返回给谁，
        同时当方法执行完毕或者返回时，该方法也就执行完毕。


递归用于解决什么样的问题(不用背)
    1. 各种数学问题如: 8皇后问题 , 汉诺塔, 阶乘问题, 迷宫问题, 球和篮子的问题(google编程大赛)
    2. 各种算法中也会使用到递归，比如快排，归并排序，二分查找，分治算法等.
    3. 将用栈解决的问题-->第归代码比较简洁





*/



public class 递归 {
}
