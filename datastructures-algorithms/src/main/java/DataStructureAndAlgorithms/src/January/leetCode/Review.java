package January.leetCode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/25 17:13
 */


public class Review {

    class UnionFind {

        //初始化的集合数目
        private int count = 0;
        private int[] parent;

        /**
         * parent的初始化
         */
        public UnionFind(int n) {
            this.count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        /**
         * 组合
         *
         * @param m
         * @param n
         */
        public void union(int m, int n) {
            int unionM = find(m);
            int unionN = find(n);
            if (unionM == unionN) return;
            else {
                parent[unionM] = unionN;
                //独立的集合减少一个
                count--;
            }

        }

        /**
         * 查询元素所在集合的头元素,为合并做准备
         *
         * @param p
         * @return
         */
        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public int getCount() {
            return count;
        }
    }

    private int m;
    private int n;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        UnionFind unionFind = new UnionFind(m * n);
        int entries = 0;
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') entries++;
                else {
                    for (int[] direction : directions) {
                        int down = i + direction[0];
                        int right = j + direction[1];
                        if (down < m && right < n && grid[down][right] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(down, right));
                        }
                    }
                }

            }
        }
        return unionFind.getCount() - entries;
    }

    public int getIndex(int i, int j) {
        return n * i + j;
    }
}
