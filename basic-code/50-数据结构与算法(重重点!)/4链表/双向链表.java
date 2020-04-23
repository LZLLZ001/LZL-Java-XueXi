/*

单向链表的缺点:
    1.单向链表，查找的方向只能是一个方向，而双向链表可以向前或者向后查找。
    2.单向链表不能自我删除，需要靠辅助节点 ，而双向链表，则可以自我删除，
        单链表删除时节点，总是要找到待删除节点的前一个节点

每个节点包含
    pro：指向前一个节点
    data
    next：指向下一个节点


双向链表：
    定义节点：
        class Node {
            public Node pre; // 指向前一个节点, 默认为null
            public 数据;
            public Node next; // 指向下一个节点, 默认为null

    定义双向链表
        class DoubleLinkedList {
        1.始化一个头节点, 头节点不要动, 不存放具体的数据(可以不要头节点)，操作也需要定义一个临时节点变量
            private Node head = new Node(0, "", "");

        2.遍历双向链表
            public void list() {
                // 判断链表是否为空
                if (head.next == null) {
                    return;
                }
                Node temp = head.next;
                while (true) {
                    // 判断是否到链表最后
                    if (temp == null) {
                        break;
                    }
                    // 输出节点的信息
                    System.out.println(temp);
                    // temp后移
                    temp = temp.next;
                }
            }

	    3.添加节点到双向链表最后
	        遍历找到最后节点然后接上
	        temp.next = node;
            node.pre = temp;
                public void add(Node node) {
                    Node temp = head;
                    // 遍历链表，找到最后
                    while (true) {
                        if (temp.next == null) {
                            break;
                        }
                        temp = temp.next;
                    }
                    temp.next = node;
                    node.pre = temp;
                }

        4.修改一个节点内容(与单向链表一样)
            根据no编号遍历找到节点来修改即可

	    5.双向链表中删除一个节点
            对于双向链表，可以直接找到要删除的这个节点
            找到后，自我删除：
            temp.pre.next = temp.next;
            if (temp.next != null) { //注意：需要防止删除的是最后一个节点，造成空指针
                temp.next.pre = temp.pre;
            }
                public void del(int no) {
                    if (head.next == null) {// 空链表
                        return;
                    }
                    Node temp = head.next; // 辅助变量(指针)
                    boolean flag = false; // 标志是否找到待删除节点的
                    while (true) {
                        if (temp == null) { // 已经到链表的最后
                            break;
                        }
                        if (temp.no == no) {
                            // 找到的待删除节点的前一个节点temp
                            flag = true;
                            break;
                        }
                        temp = temp.next; // temp后移，遍历
                    }
                    if (flag) {
                        // temp.next = temp.next.next;[单向链表]
                        temp.pre.next = temp.next;
                        // 如果是最后一个节点，就不需要执行下面这句话，否则出现空指针
                        if (temp.next != null) {
                            temp.next.pre = temp.pre;
                        }
                    } else {
                        System.out.printf("要删除的 %d 节点不存在\n", no);
                    }
                }








*/




public class 双向链表 {
}
