package DataStructureAndAlgorithms.src.gogogo.dp;

import com.mysql.jdbc.MysqlIO;

/**
 * @author xiaotian
 * @description 动态规划：
 *                  1、递归、分治：自顶向下；动态规划：自下至上
 *                  2、动态规划的关键点：（1）中间状态的存储（2）初始值（3）动态转移方程（dp方程）
 *                  3、动态规划和分治的区别：问题是否具有最优子结构
 *              最优子结构：
 *                  对于一个给定的问题，当该问题可以由其子问题的最优解获得时，则该问题具有“最优子结构”性质。eg：每一个dp问题
 *                  能用动态规划解决的求最优解问题，必须满足最优解的每个局部解也都是最优的。
 *
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
                middleStatus[i][j] = middleStatus[i - 1][j] + middleStatus[i][j-1];
            }
        }
        return middleStatus[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int res = solution.uniquePaths(3, 3);
        System.out.println(res);
    }
}
