package study2024.dp;

/**
 * @author xiaotian
 * @description 最大子数组和
 * @date 2024-03-31 17:12
 */
public class MaxSubArray {

    /**
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = nums;
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }


    public int maxSubArray2(int[] nums) {
        //int[] dp = nums;
        int max = nums[0], submax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            submax = Math.max(nums[i] + submax, nums[i]);
            max = Math.max(submax, max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArray.maxSubArray(a);
        System.out.println(i);
    }
}
