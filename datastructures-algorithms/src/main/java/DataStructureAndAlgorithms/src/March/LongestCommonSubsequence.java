package March;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/10 16:24
 */


public class LongestCommonSubsequence {

    /**
     * 一般都是要穷举,但是穷举 不容易,所以考虑dp
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        /**
         *
         * for (int i = 0; i < m; i++) {
         dp[m][0] = 0;
         }
         for (int i = 0; i < n; i++) {
         dp[0][n] = 0;
         }*/
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char a = text1.charAt(i);
                char b = text2.charAt(j);
                if (a == b) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
