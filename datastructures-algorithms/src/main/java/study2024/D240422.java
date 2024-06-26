package study2024;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description 动态规划。子和分治的区别：
 * （1）dp自底向上，分治自顶向下
 * （2）dp具有最有子结构，分治没有
 * （3）可以用dp的一定可以用分治，但是可以用分治的不一定可以用dp
 * 动态规划为甚麽快：存储了中间状态，空间换时间。
 * @Date 2024/4/22 13:55
 **/
public class D240422 {

	public static void main(String[] args) {
		D240422 d240422 = new D240422();
		// int i = d240422.climbStairsNotBest(3);
		// int[][] nums = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
		// int i = d240422.uniquePathsWithObstacles(nums);
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		int i = d240422.maxSubArray(nums);
		System.out.println(i);
	}

	public int climbStairs(int n) {
		int first = 0, second = 1, sum = 0;
		for (int i = 1; i <= n; i++) {
			sum = first + second;
			first = second;
			second = sum;
		}
		return sum;
	}

	public int climbStairsNotBest(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public int uniquePaths(int m, int n) {
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[j] = dp[j] + dp[j - 1];
			}
		}
		return dp[n - 1];
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[] dp = new int[n];
		if (obstacleGrid[0][0] == 1) {
			dp[0] = 0;
		} else {
			dp[0] = 1;
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[j] = 0;
				} else if (j - 1 >= 0) {
					dp[j] = dp[j] + dp[j - 1];
				}
			}
		}
		return dp[n - 1];
	}

	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];//dp[i][j]存储的就是sum
		//初始化
		dp[0][0] = grid[0][0];
		int min = 0;
		for (int i = 1; i < m; i++) {
			dp[i][0] = dp[i - 1][0] + grid[i][0];
		}
		for (int j = 1; j < n; j++) {
			dp[0][j] = dp[0][j - 1] + grid[j][0];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i] [j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m - 1).size();
		int[][] dp = new int[m+1][n+1];
		int sum = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j + 1]);
			}
		}
		return dp[0][0];
	}


	public int minimumTotalBest(List<List<Integer>> triangle) {
		int m = triangle.size();
		int n = triangle.get(m - 1).size();
		int[] dp = new int[n+1];
		int sum = 0;
		for (int i = m - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				dp[j] = triangle.get(i).get(j) + Math.min(dp[j], dp[j + 1]);
			}
		}
		return dp[0];
	}

	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			dp[i] = dp[i - 1] > 0 ? nums[i] + dp[i - 1] : nums[i];
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i - 1] > 0 ? nums[i] + nums[i - 1] : nums[i];
			max = Math.max(max, nums[i]);
		}
		return max;
	}


}
