package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/26 18:25
 */


public class Cities {

    public static void main(String[] args) {

        Cities cities = new Cities();
        int[][] isConnected = {{1,1,1,0},{1,1,1,0},{1,1,1,0},{0,0,0,1}};
        int circleNum = cities.findCircleNum(isConnected);
        System.out.println(circleNum);
    }

    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int m = isConnected.length;
        //m:总共的集合数目
        UnionFind unionFind = new UnionFind(m);
//        int[][] directions = {{1,0}, {0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                if (isConnected[i][j] == 1) {
                    unionFind.union(i,j);
                }
            }
        }
        return unionFind.getCount();
    }

    class UnionFind {
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

        public int getCount(){
            return count;
        }

    }

}
