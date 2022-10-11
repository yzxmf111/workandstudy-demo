package March;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/12 17:27
 */


public class Dp01 {

    public int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePaths(int m, int n) {
        //对空间复杂度进行优化, 画图出来则一目了然
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        //初始位置处有障碍物则后边的全部设置为0,中间有障碍物如何处理
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                while (i < m) {
                    dp[i][0] = 0;
                    //mark:1;
                    i++;
                }
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                while (i < n) {
                    //mark:2;
                    dp[0][i] = 0;
                    i++;
                }
                break;
            }
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n -1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //在遍历的时候只使用了每个位置左边的值和上边的值，其他的都用不到，
        // 所以我们可以考虑把二维数组转化为一位数组，来看下代码
        //空间复杂度的优化
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) dp[j] = 0;
                else {
                    //dp[j]代表上边的值, dp[j - 1] 代表左边的值
                        dp[j] = dp[j] + dp[j-1];
                }
            }
        }
        return dp[n - 1];
    }

}
