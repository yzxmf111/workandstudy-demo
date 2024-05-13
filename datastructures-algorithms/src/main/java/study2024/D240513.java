package study2024;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/13 14:21
 **/
public class D240513 {

	/**
	 * 接雨水
	 * n == height.length
	 * 1 <= n <= 2 * 104
	 * 0 <= height[i] <= 105
	 * ans+=Math.min(pre[i], post[i]) - height[i];
	 *
	 * @param height
	 * @return
	 */
	public int trap(int[] height) {
		int n = height.length;
		int ans = 0;
		int[] preNums = new int[n];
		int[] postNums = new int[n];
		preNums[0] = height[0];
		postNums[n - 1] = height[n - 1];
		// for (int num : height) {
		// 	preNums
		// }
		for (int i = 1; i < n; i++) {
			preNums[i] = Math.max(preNums[i - 1], height[i]);
		}
		for (int j = n - 2; j >= 0; j--) {
			postNums[j] = Math.max(postNums[j + 1], height[j]);
		}
		for (int i = 0; i < height.length; i++) {
			ans += Math.min(postNums[i], preNums[i]) - height[i];
		}
		return ans;
	}

	/**
	 * 滑动窗口
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if (s.length() < p.length()) {
			return res;
		}
		int len = p.length();
		int[] sNums = new int[26];
		int[] pNums = new int[26];
		for (int i = 0; i < len; i++) {
			sNums[s.charAt(i) - 'a']++;
			pNums[p.charAt(i) - 'a']++;
		}
		if (Arrays.equals(sNums, pNums)) {
			res.add(0);
		}
		int left = 0;
		int right = len - left - 1;
		while (true) {
			sNums[s.charAt(left) - 'a']--;
			left++;
			right++;
			if (right > s.length() - 1) {
				break;
			}
			sNums[s.charAt(right) - 'a']++;
			if (Arrays.equals(sNums, pNums)) {
				res.add(left);
			}
		}
		return res;
	}

	/**
	 * 优美子数组
	 * 1 <= nums.length <= 50000
	 * 1 <= nums[i] <= 10^5
	 * 1 <= k <= nums.length
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numberOfSubarrays(int[] nums, int k) {
		//k:奇数的个数，v：偶数的个数+1
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int preOdd = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				preOdd++;
			}
			if (map.containsKey(preOdd - k)) {
				sum += map.get(preOdd - k);
			}
			map.put(preOdd, map.getOrDefault(preOdd, 0) + 1);
		}
		return sum;
	}

	public int numberOfSubarraysBest(int[] nums, int k) {
		int left = 0, right = 0, oddCnt = 0, res = 0;
		while (right < nums.length) {
			// 右指针先走，每遇到一个奇数则 oddCnt++。
			if ((nums[right++] & 1) == 1) {
				oddCnt++;
			}

			//  若当前滑动窗口 [left, right) 中有 k 个奇数了，进入此分支统计当前滑动窗口中的优美子数组个数。
			if (oddCnt == k) {
				// 先将滑动窗口的右边界向右拓展，直到遇到下一个奇数（或出界）
				// rightEvenCnt 即为第 k 个奇数右边的偶数的个数
				int tmp = right;
				while (right < nums.length && (nums[right] & 1) == 0) {
					right++;
				}
				int rightEvenCnt = right - tmp;
				// leftEvenCnt 即为第 1 个奇数左边的偶数的个数
				int leftEvenCnt = 0;
				while ((nums[left] & 1) == 0) {
					leftEvenCnt++;
					left++;
				}
				// 第 1 个奇数左边的 leftEvenCnt 个偶数都可以作为优美子数组的起点
				// (因为第1个奇数左边可以1个偶数都不取，所以起点的选择有 leftEvenCnt + 1 种）
				// 第 k 个奇数右边的 rightEvenCnt 个偶数都可以作为优美子数组的终点
				// (因为第k个奇数右边可以1个偶数都不取，所以终点的选择有 rightEvenCnt + 1 种）
				// 所以该滑动窗口中，优美子数组左右起点的选择组合数为 (leftEvenCnt + 1) * (rightEvenCnt + 1)
				res += (leftEvenCnt + 1)  * (rightEvenCnt + 1);

				// 此时 left 指向的是第 1 个奇数，因为该区间已经统计完了，因此 left 右移一位，oddCnt--
				left++;
				oddCnt--;
			}
		}
		return res;
	}

}
