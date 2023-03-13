package DataStructureAndAlgorithms.src.gogogo.dp;

import com.mysql.jdbc.MysqlIO;

import java.util.List;

/**
 * @author xiaotian
 * @description 动态规划：
 * 1、递归、分治：自顶向下；动态规划：自下至上
 * 2、动态规划的关键点：（1）中间状态的存储（2）初始值（3）动态转移方程（dp方程）
 * 3、动态规划和分治的区别：问题是否具有最优子结构
 * 最优子结构：
 * 对于一个给定的问题，当该问题可以由其子问题的最优解获得时，则该问题具有“最优子结构”性质。eg：每一个dp问题
 * 能用动态规划解决的求最优解问题，必须满足最优解的每个局部解也都是最优的。
 * @date 2023-02-17 15:10
 */
public class Solution {

    //todo:空间复杂度的优化
    public int uniquePaths(int m, int n) {
        int[][] middleStatus = new int[m][n];
        for (int i = 0; i < m; i++) {
            middleStatus[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            middleStatus[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                middleStatus[i][j] = middleStatus[i - 1][j] + middleStatus[i][j - 1];
            }
        }
        return middleStatus[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.uniquePaths(3, 3);
        System.out.println(res);
    }

    //todo:空间复杂度的优化
    //存在最优子结构，可用动态规划
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //中间状态存储
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        //初始化
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                //障碍物
                while (i < m) {
                    dp[i][0] = 0;
                    i++;
                }
            } else {
                dp[i][0] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                //障碍物
                while (i < n) {
                    dp[0][i] = 0;
                    i++;
                }
            } else {
                dp[0][i] = 1;
            }
        }
        //dp方程
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public int minimumTotal(List<List<Integer>> triangle) {

        //中间状态存储
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}
