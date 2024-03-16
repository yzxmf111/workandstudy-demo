package study2024;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/13 18:51
 **/
public class D240313 {


	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				while (i < m) {
					dp[i][0] = 0;
					i++;
				}
			} else {
				dp[i][0] = 1;
			}
		}
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				while (j < n) {
					dp[0][j] = 0;
					j++;
				}
			} else {
				dp[0][j] = 1;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] == 1) {
					dp[i][j] = 0;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}


	public int uniquePathsWithObstaclesBest(int[][] obstacleGrid) {
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

	public static void main(String[] args) {
		int[][] a= {{1,0}};
		int i = new D240313().uniquePathsWithObstacles(a);
		System.out.println(i);
	}
}
