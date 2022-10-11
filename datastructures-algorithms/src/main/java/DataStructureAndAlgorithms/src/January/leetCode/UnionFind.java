package January.leetCode;

/**
 * @description: 关键在与模板的熟练书写 和 判断该题目是否使用并查集
 * @author: Tian
 * @time: 2021/2/20 16:45
 */


public class UnionFind {

  /*  //初始化的集合数目
    private int count = 0;
    private int[] parent;

    *//**
     * parent的初始化
     *//*
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    *//**
     * 组合
     * @param m
     * @param n
     *//*
    public void union(int m, int n){
        int unionM = find(m);
        int unionN = find(n);
        if (unionM == unionN) return;
        else {
            parent[unionM] = unionN;
            //独立的集合减少一个
            count--;
        }

    }
    */
    /**
     * 查询元素所在集合的头元素,为合并做准备
     *
     * @param p
     * @return
     *//*
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }

*/

    private int count;
    private int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public void union(int m, int n) {
        int unionM = find(m);
        int unionN = find(n);
        if (unionM == unionN) return;
        else {
            parent[unionM] = unionN;
            count--;
        }
    }

    public int find(int x) {
        //一种固定的写法
        while (parent[x] != x) {
            //向上找,一直到找到头元素为止
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    public int getCount() {
        return count;
    }

}
