package March;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/23 16:10
 */


public class About323 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
        About323 ans = new About323();
        int len = ans.lengthOfLIS(nums);
        System.out.println(len);
    }

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //int[] dp = new int[nums.length];
        //dp[0] = 1;
        int max = 1, subMax = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                subMax++;
            } else {
                subMax = 1;
            }
            max = Math.max(max, subMax);
        }
        return max;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);//初始化
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        Arrays.fill(dp, 1);//初始化
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    if (dp[j] + 1 > dp[i]) { //说明是第一次找到dp[j]+1长度且以nums[i]结尾的最长递增子序列
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[i] == dp[j] + 1) {
                        //不是第一次找到了
                        count[i] += count[j];
                    }
                }

            }
            max = Math.max(max,dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] == max) ans += count[i];
        }
        return ans;
    }
}
