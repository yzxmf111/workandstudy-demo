package study2024.dp;

/**
 * @author xiaotian
 * @description 最长回文子串
 * @date 2024-03-31 17:24
 */
public class LongestPalindrome {
    /**
     * 示例 1：
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     *
     * 难点：1、中间状态存储 2、start，len的组合 3、特殊情况的考虑 len == 1 && len == 2
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        int max = 0;
        String res = "";
        //len <= length
        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    continue;
                }
                //dp[start + 1][end - 1]
                dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && s.charAt(start) == s.charAt(end);
                //end - start + 1 == len
                if (dp[start][end] && (end - start + 1) > max) {
                    max = end - start + 1;
                    res = s.substring(start, end + 1);
                }
            }
        }
        return res;
    }

}
