package November.XC;

import java.util.List;

class Solution {


    public int minimumTotal(List<List<Integer>> triangle) {
        //重复性已经找到了
        //dp数组,先定义一个
        //咱先来一个比较复杂的

        if (triangle == null || triangle.size() == 0) return 0;
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        //初始化
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (i == j) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j])+triangle.get(i).get(j);
                }
            }
        }
        //当然也可以找最小值
        int min = dp[m-1][0];
        for (int i = 1; i < dp[m - 1].length; i++) {
            if ( dp[m-1][i] <  dp[m-1][0]) min =dp[m-1][i];
        }
        return min;
    }
}