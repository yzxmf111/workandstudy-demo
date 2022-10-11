package January.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = sum.threeSum(arr);
        System.out.println(lists);
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，
     * 判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 解法:去重+双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //1
        if (nums == null || nums.length < 3) {
            return list;
        }
        //2
        Arrays.sort(nums);
        int len = nums.length;
        //3
        for (int i = 0; i < len - 2; i++) {
            //4
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //双指针
            int left = i + 1, right = nums.length - 1;
            int target;
            while (left < right) {
                target = nums[i] + nums[left] + nums[right];
                if (target == 0) {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(i);
                    tmp.add(left);
                    tmp.add(right);
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //以上方法可以简化
                    left++;
                    right--;
                    //5
                    while (left < right) if (nums[left] == nums[left - 1]) left++;
                    while (left < right) if (nums[right] == nums[right + 1]) right--;
                } else if (target < 0) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return list;
    }

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int[][][] dp = new int[len][3][2];//应该只到dp[][][]的含义
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -2 * prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][1] - prices[i]);
        }
        return dp[len - 1][1][0] > dp[len - 1][2][0] ? dp[len - 1][1][0] : dp[len - 1][2][0];
    }
}
