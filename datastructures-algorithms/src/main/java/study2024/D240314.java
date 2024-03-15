package study2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/14 16:07
 **/
public class D240314 {
	public long maxArrayValue(int[] nums) {
		// nums = [2,3,7,9,3]
		int length = nums.length;
		long sum = nums[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			sum = nums[i] <= sum ? sum + nums[i] : nums[i];
		}
		return sum;
	}


	/**
	 * 最长回文子串  偶数个数之和 +（奇数个数-1）之和 + 1 or 0
	 */
	public int longestPalindrome(String s) {
		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < chars.length; i++) {
			map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
		}
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				flag = true;
				sum += entry.getValue() - 1;
			} else {
				sum += entry.getValue();
			}
		}
		return flag ? sum + 1: sum;
	}
}
