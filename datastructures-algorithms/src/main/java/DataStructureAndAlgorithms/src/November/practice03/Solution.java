package November.practice03;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr= {1,2,5};
        int amount = 11;
        int i = solution.coinChange(arr, amount);
        System.out.println(i);


    }
    public int coinChange(int[] coins, int amount) {
        //数学方法/bfs/DP
        //如果问你总共的兑换方法数,
        //其实就是爬楼梯问题dp[i] = dp[i-1] + dp[i-2] + dp[i-5]
        int[] dp = new int[amount + 1];
        //初始化
        Arrays.fill(dp,amount + 1);
        dp[0] = 0;
        //此步的目的在于 我们依赖的dp[i-coins[j]]必须有效
        //递推
        for (int i = 1; i <= amount; i++) {
            for(int j = 0; j < coins.length;j++) {
                if (i >= coins[j] && dp[i-coins[j]] != amount + 1){
                    dp[i] = Math.min(dp[i] , 1 + dp[i-coins[j]]);//就是递推
                }
            }

        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
/**
 1.暴力法 递归树 0(2^n)
 2.dp:
 a: 分治
 b: dp[i] 存放的是兑换i所需要的最小硬币数
 c: 递推 dp[i] = min(dp[i-1] , dp[i-2] , dp[i-5] ) + 1;
 */