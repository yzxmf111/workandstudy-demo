package study2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/24 13:44
 **/
public class D240424 {

	public static void main(String[] args) {
		String s = "abccccdd";
		D240424 d2404224 = new D240424();
		int i = d2404224.longestPalindrome(s);
	}

	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int sum = 0;
		boolean flag = false;
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			Integer value = entry.getValue();
			if (value % 2 == 1) {
				sum += (value - 1);
				flag = true;
			} else {
				sum += value;
			}
		}
		return flag ? sum + 1 : sum;
	}

	public int longestPalindromeSubseq(String s) {
		boolean[][] dp = new boolean[s.length()][s.length()];
		int len = 0, max = 0;
		char[] chars = s.toCharArray();
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				len = j - i + 1;
				if (len > s.length()) {
					break;
				}
				dp[i][j] = (i == j || i + 1 == j || dp[i + 1][j - 1]) && chars[i] == chars[j];
				max = Math.max(len, max);
			}
		}
		return max;
	}

	public int longestPalindrome2(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		String res = "";
		char[] chars = s.toCharArray();
		int max = 0, end;
		for (int len = 1; len <= n; len++) {
			for (int start = 0; start < n; start++) {
				end = start + len - 1;
				if (end >= n) {
					break;
				}
				dp[start][end] = (len == 1 || len == 2 || dp[start + 1][end - 1]) && chars[start] == chars[end];
				if (dp[start][end] && len > max) {
					max = len;
					res = s.substring(start, end + 1);
				}
			}
		}
		return res.length();
	}

	public int rob(int[] nums) {
		// int subMax = 0, max = 0;
		// for (int i = 2; i < nums.length; i++) {
		// 	nums[i] = Math.max(nums[i] + nums[i - 2], nums[i-1]);
		// }
		// return nums[nums.length - 1];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[1], nums[0]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
		}
		return dp[nums.length - 1];
	}
}
