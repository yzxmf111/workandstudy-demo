package test;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/25 20:01
 */



public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param num int整型一维数组 输入的数组
     * @return int整型
     */
    public int maxValue (int[] num) {
        // write code here
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return num[0];
        int len = num.length;
        int[] dp = num;
        for (int i = 1; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i-2]+ num[i]) ;
        }
        return dp[len - 1];
    }


}