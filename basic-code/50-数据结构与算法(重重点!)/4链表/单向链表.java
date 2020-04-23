/*
链表是有序的列表
    1. 链表是以节点的方式来存储,是链式存储
    2. 每个节点包含 data 域， next 域(指向下一个节点)
    3. 发现链表的各个节点不一定是连续存储.
    4. 链表分带头节点的链表和没有头节点的链表，根据实际的需求来确定



单向链表:
    定义节点:
        class Node {
            public 数据;
            public HeroNode next; //指向下一个节点,最后一个节点的next为null

	        public Node() //构造器
	        public String toString() //重写toString方便显示, 注意不要打印next

    定义链表：
        class SingleLinkedList {
        1.初始化一个头节点, 头节点不能动, 不存放具体的数据(可以不要头节点)
            因为头节点指针不能动，所以之后的操作都是定义一个临时节点变量进行操作Node temp = head；
                private Node head = new HeroNode(0, "", "");

            //返回头节点
                public Node getHead() {
                    return head;
                }

        2.添加节点到单向链表最后(即不考虑编号顺序)
            (1) 遍历找到当前链表的最后节点
            (2) 将最后这个节点的next 指向 新的节点
                public void add(Node node) {
                    //因为head节点不能动，因此我们需要一个辅助遍历 temp
                    Node temp = head;
                    //遍历链表，找到最后
                    while(true) {
                        if(temp.next == null) {
                            break;
                        }
                        temp = temp.next;
                    }
                    //将最后这个节点的next 指向 新的节点
                    temp.next = node;
                }

        3.添加节点到指定位置
            (1) 找到新添加的节点的位置(添加位置的前一个节点)：遍历
            (2) 将新节点尾接入链表(一定要先接尾，不然丢失后面的节点)：新的节点.next = temp.next
            (3) 将新节点头接入链表(逻辑头，并不是双向链表的头)：temp.next = 新的节点
                public void addByOrder(Node node) {
                    Node temp = head;
                    boolean flag = false; // flag标志添加的编号是否存在，默认为false
                    while(true) {
                        if(temp.next == null) {//说明temp已经在链表的最后
                            break; //
                        }
                        if(temp.next.no > node.no) { //位置找到，就在temp的后面插入
                            break;
                        } else if (temp.next.no == node.no) {//希望添加的Node的编号已然存在
                            flag = true; //说明编号存在
                            break;
                        }
                        temp = temp.next; //后移，遍历当前链表
                    }
                    if(flag) { //编号存在,不能添加
                        System.out.printf("编号 %d 已经存在\n", Node.no);
                    } else {
                        //插入到链表中, temp的后面
                        node.next = temp.next;
                        temp.next = node;
                    }
                }

       4.修改节点的信息: 根据no编号来修改
            根据no编号遍历找到节点来修改即可
                public void update(Node newNode) {
                    //判断是否空
                    if(head.next == null) {
                        System.out.println("链表为空~");
                        return;
                    }
                    Node temp = head.next;
                    boolean flag = false; //表示是否找到该节点
                    while(true) {
                        if (temp == null) {
                            break; //已经遍历完链表
                        }
                        if(temp.no == newNode.no) {
                            //找到
                            flag = true;
                            break;
                        }
                        temp = temp.next;
                    }
                    //根据flag 判断是否找到要修改的节点
                    if(flag) {
                        temp.数据 = newNode.数据;
                    } else { //没有找到
                        System.out.printf("没有找到 编号 %d 的节点\n", newNode.no);
                    }
                }

       5.删除节点
            (1) 遍历找到待删除节点的前一个节点(比较时，是temp.next.no 和 需要删除的节点的no比较)
            (2) 将删除节点的前一个节点与后一个节点连接：temp.next = temp.next.next;
                public void del(int no) {
                    Node temp = head;
                    boolean flag = false; // 标志是否找到待删除节点的
                    while(true) {
                        if(temp.next == null) { //已经到链表的最后
                            break;
                        }
                        if(temp.next.no == no) {
                            //找到的待删除节点的前一个节点temp
                            flag = true;
                            break;
                        }
                        temp = temp.next; //temp后移，遍历
                    }
                    if(flag) { //找到
                        //删除
                        temp.next = temp.next.next;
                    }else {
                        System.out.printf("要删除的 %d 节点不存在\n", no);
                    }
                }

      6.遍历链表
            原理：尾节点next为null
                public void list() {
                    //判断链表是否为空
                    if(head.next == null) {
                        return;
                    }
                    //因为头节点不能动，因此需要一个辅助变量来遍历
                    Node temp = head.next;
                    while(true) {
                        if(temp == null) {
                            break;
                        }
                        //输出节点的信息
                        System.out.println(temp);
                        //temp后移
                        temp = temp.next;
                    }
                }
            }



单链表的常见面试题有如下:
    1.求单链表中有效节点的个数
        遍历就行；
    2.查找单链表中的倒数第k个结点 【新浪面试题】
        遍历求个数size，再遍历到第 (size-index)个
    3.单链表的反转【腾讯面试题，有点难度】
        (1) 先定义一个链表节点 reverseHead = new HeroNode();
        (2) 从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并插在新的链表reverseHead 的最前端.
                while(cur != null) {
                    next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
                    cur.next = reverseHead.next;//将cur的下一个节点指向新的链表的最前端
                    reverseHead.next = cur; //将cur 连接到新的链表上
                    cur = next;//让cur后移
                }
        (3) 原来的链表的head.next = reverseHead.next
    4.从尾到头打印单链表 【百度】
        使用栈Stack，将各个节点压入到栈中，然后利用栈的先进后出的特点，就实现逆序打印
    5.合并两个有序的单链表，合并之后的链表依然有序【课后练习.】
        定义一个新链表，然后对比两个源链表头，小的加到新链表














*/


public class 单向链表 {
}
