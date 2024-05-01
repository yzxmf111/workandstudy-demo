package study2024.dp;

/**
 * @author xiaotian
 * @description 打家劫舍
 * @date 2024-04-06 17:56
 */
public class Rob {

    /**
     * 状态定义：偷窃的最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];

    }

    public static void main(String[] args) {
        int[] a = {1,2,3,1};
        int rob = new Rob().rob(a);
    }
}
