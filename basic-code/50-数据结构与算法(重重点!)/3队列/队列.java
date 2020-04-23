/*
队列是一个有序列表，可以用数组或是链表来实现。
遵循先进先出的原则。即：先存进队列的数据，要先取出。后存进的要后取出


数组队列：
    变量：
        maxSize 是该队列的最大容量。
        front 队列头的前一个位置的指针，初始化为-1
                队列头第一个数据的再前一个位置的下标(注意：头指针是没有数据的！！)，
        rear 队列尾指针，队列最后一个数据指针，初始化为-1

    判断：
        队列空: front == rear；
        队列满: rear  == maxSize - 1；

    存入队列addQueue：
        判断队列是否满：rear < maxSize - 1
        尾指针往后移：rear++
        存入数据: arr[rear] = n;

    获取数据getQueue：
        判断队列是否空；
        头指针后移：front++  (注意：头指针是没有数据的)
        取出数据：return arr[front] (一定要先加再取！)



数组环形队列:
    环形原因：单向数组队列无法重复利用空间
    变量：
        maxSize 是该队列的最大容量。
        front 队列头指针，队列第一个数据(注意和非环形的区别！！)，初始化为0
        rear 队列尾的后一个位置的指针(注意和非环形的区别！！)，初始化为0
            队列尾最后一个元素数据的再后一个位置的
        (指针位置都是自己定的，有很多种约定方法，对应的算法有一些区别，但是整体思路都一样，理解就行)
    判断：
        队列空: front == rear；
        队列满: (rear + 1) % maxSize == front ；
        队列中有效的数据的个数: (rear + maxSize - front) % maxSize   // rear = 1 front = 0

    存入队列addQueue：
        判断队列是否满
        存入数据: arr[rear] = n;
        尾指针往后移：rear = (rear + 1) % maxSize;


    获取数据getQueue：
        判断队列是否空
        取出数据：int value = arr[front]
        头指针后移：front = (front + 1) % maxSize;

    遍历showQueue：
        for (int i = front; i < front + (rear + maxSize - front) % maxSize ; i++) {
                System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }





*/



public class 队列 {
}
