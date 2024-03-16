package study2024;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/12 15:16
 **/
public class D240312 {

	public static void main(String[] args) {
		D240312 d240312 = new D240312();
		int i = d240312.uniquePaths(3, 7);
		System.out.println(i);
	}

	public int lengthOfLongestSubstring(String s) {
		int i = 0, j = 0, max = 0;
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		while (i < chars.length) {
			if (map.containsKey(chars[i])) {
				//key: abba 会有取 j = j 的情况
				j = Math.max(j, map.get(chars[i]) + 1);
			}
			map.put(chars[i], i);
			max = Math.max(max, i - j + 1);
			i++;
		}
		return max;
	}

	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;//1个台阶的方法
		dp[1] = 1;//2个台阶的方法
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}

	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}

		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}
	//o(n^2) o(n)
	public int uniquePathsBest(int m, int n) {
		int[] cur = new int[n];
		Arrays.fill(cur, 1);
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				cur[j] = cur[j - 1] + cur[j];
			}
		}
		return cur[n - 1];
	}


	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int n = obstacleGrid.length, m = obstacleGrid[0].length;
		int[] f = new int[m];

		f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (obstacleGrid[i][j] == 1) {
					f[j] = 0;
					continue;
				}
				if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] += f[j - 1];
				}
			}
		}

		return f[m - 1];
	}
}
