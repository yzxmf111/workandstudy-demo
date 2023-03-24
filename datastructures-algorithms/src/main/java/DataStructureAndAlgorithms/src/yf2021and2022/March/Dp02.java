package March;


import November.ZS.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/13 17:15
 */


public class Dp02 {

    /**
     * 我们可以使用递归,也可以使用记忆化递归,当然也可以使用dp
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Map<ListNode,Integer> map = new HashMap<>();
        int pos = 0;
        while (head != null) {
            if (map.containsKey(head)) return true;
            else map.put(head,pos++);
            head = head.next;
        }
        return false;
    }

    public int coinChange(int[] coins, int amount) {
        //dp[i]定义：这是最优子结构，存储的是越换i所需要的最小的硬币数
        int[] dp = new int[amount + 1];
        //先将dp数组中的值全部设置为不可能值,后便会慢慢更改
        //如果某一个无法更改,则会出现
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //coins[j] <= i
                if (coins[j] <= i && dp[i - coins[j]] != amount + 1) {
                    dp[i] = Math.min(dp[i],dp[i - coins[j]]+ 1) ;
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] ans = {-2,1,-3,4,-1,2,1,-5,4};
        Dp02 dp02 = new Dp02();
        int i = dp02.maxSubArray(ans);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0], subMax = nums[0];
        //dp[i] 存储的是连续子数组的和
        for (int i = 1; i < nums.length; i++) {
            if (subMax > 0) {
                subMax = subMax + nums[i];
            } else {
                subMax = nums[i];
            }
            max = Math.max(subMax,max);
        }
        return max;
    }


    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, subMax = nums[0], subMin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = subMin;
                subMin = subMax;
                subMax = temp;
            }
            subMin = Math.min(nums[i], subMin* nums[i]);
            subMax = Math.max(nums[i], subMax* nums[i]);
            max = Math.max(max,subMax);
        }
        return max;
    }
}
