/*
作用：
    线性表局限于一个直接前驱和一个直接后继的关系，
    树也只能有一个直接前驱也就是父节点，
    当我们需要表示多对多的关系时，就用到了图。

图是一种数据结构，其中结点可以具有零个或多个相邻元素。两个结点之间的连接称为边。 结点也可以称为顶点。


图的表示方式有两种：二维数组表示（邻接矩阵）；链表表示（邻接表）。
    邻接矩阵：
        表示图形中顶点之间相邻关系的矩阵，对于n个顶点的图而言，矩阵是的行和列表示的是1....n个点。
        邻接矩阵需要为每个顶点都分配n个边的空间，其实有很多边都是不存在,会造成空间的一定损失.
    邻接表：
        邻接表的实现只关心存在的边，不关心不存在的边。因此没有空间浪费，邻接表由数组+链表组成


图遍历：对结点的遍历访问
    深度优先搜索(Depth First Search)：
        从初始访问结点出发，首先访问第一个邻接结点，
        然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点，
        即：每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。
        优先往纵向挖掘深入，而不是对一个结点的所有邻接结点进行横向访问。深度优先搜索是一个递归的过程。
            1）访问初始结点v，并标记结点v为已访问。
            2）查找结点v的第一个邻接结点w。
            3）若w存在，则继续执行4，如果w不存在，则回到第1步，将从v的下一个结点继续。
            4）若w未被访问，对w进行深度优先遍历递归（即把w当做另一个v，然后进行步骤123）。
            5）查找结点v的w邻接结点的下一个邻接结点，转到步骤3。

    广度优先搜索(Broad First Search):
        类似于一个分层搜索的过程，需要使用一个队列以保持访问过的结点的顺序，以便按这个顺序来访问这些结点的邻接结点
            1）访问初始结点v并标记结点v为已访问。
            2）结点v入队列
            3）当队列非空时，继续执行，否则算法结束。
            4）出队列，取得队头结点u。
            5）查找结点u的第一个邻接结点w。
            6）若结点u的邻接结点w不存在，则转到步骤3；否则循环执行以下三个步骤：
                6.1 若结点w尚未被访问，则访问结点w并标记为已访问。
                6.2 结点w入队列
                6.3 查找结点u的继w邻接结点后的下一个邻接结点w，转到步骤6。








*/

public class 图 {
}
