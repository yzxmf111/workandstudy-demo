package March;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/14 15:54
 */


public class Dp03 {

    public static void main(String[] args) {
    }

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //Arrays.copyOfRange(nums, 0, nums.length - 2)) 左闭又开
        return Math.max(helper(Arrays.copyOfRange(nums, 0, nums.length - 1)), helper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int helper(int[] arr) {

        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <= arr.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[arr.length];
    }

    public int maxProfit(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(prices[i] + dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = Math.max(-prices[i], dp[i-1][1]);
        }
        return dp[prices.length - 1][0];
    }
}
