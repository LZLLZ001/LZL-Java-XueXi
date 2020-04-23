/*

最小生成树：
    给定一个带权的无向连通图,如何选取一棵生成树,使树上所有边上权的总和为最小。
    包含全部N个顶点，且一定有N-1条边。
求最小生成树的算法主要是普里姆算法和克鲁斯卡尔算法。


普里姆算法：求最小生成树，也就是在包含n个顶点的连通图中，找出只有(n-1)条边包含所有n个顶点的连通子图，也就是所谓的极小连通子图
    思想：迭代查找当前已加入节点与未加入节点之间的最小边对应的节点。
    1）设G=(V,E)是连通网，T=(U,D)是最小生成树，V,U是顶点集合，E,D是边的集合； 
    2）若从顶点u开始构造最小生成树，则从集合V中取出顶点u放入集合U中，标记顶点v的visited[u]=1；
    3）若集合U中顶点ui与集合V-U中的顶点vj之间存在边，则寻找这些边中权值最小的边，但不能构成回路，
        将顶点vj加入集合U中，将边（ui,vj）加入集合D中，标记visited[vj]=1；
    4）重复步骤②，直到U与V相等，即所有顶点都被标记为访问过，此时D中有n-1条边；



克鲁斯卡尔算法：
    思想：按照权值从小到大的顺序选择n-1条边，并保证这n-1条边不构成回路。即迭代查找不构成回路的最小权值边。
    具体做法：
          首先构造一个只含n个顶点的森林，然后依权值从小到大从连通网中选择边加入到森林中，
          并使森林中不产生回路，直至森林变成一棵树为止。
    判断是否形成了回路：
          记录顶点在"最小生成树"中的终点，顶点的终点是"在最小生成树中与它连通的序号最大的顶点"。
          然后每次需要将一条边添加到最小生存树时，判断该边的两个顶点的终点是否重合，重合的话则会构成回路。

    终点：就是将所有顶点按照序号从小到大的顺序排列好之后；某个顶点的终点就是"与它连通的最大顶点"。
          我们加入的边的两个顶点不能都指向同一个终点，否则将构成回路。






*/

public class 普里姆算法and克鲁斯卡尔算法 {
}
