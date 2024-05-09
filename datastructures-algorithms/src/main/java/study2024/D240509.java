package study2024;

import java.util.HashMap;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/9 10:39
 **/
public class D240509 {

	/**
	 * 统计优美子数组：前缀和
	 * @param nums
	 * @param k
	 * @return
	 */
	public int numberOfSubarrays(int[] nums, int k) {
		// k-v k:前缀和（奇数个数） v：有N个奇数的情况有几种(偶数个数+1)
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0;
		int preSum = 0;
		for (int num : nums) {
			if (num % 2 != 0) {//判断是否为奇数
				preSum++;
			}
			if (map.containsKey(preSum - k)) {
				count += map.get(preSum - k);
			}
			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
			// if (map.containsKey(preSum)) {//这个if 在这题中其实没用，只是为了保证模板完整性还是写了
			// 	map.put(preSum, map.get(preSum) + 1);
			// } else {
			// 	map.put(preSum, 1);
			// }
		}
		return count;
	}

	public static void main(String[] args) {
		int i = new D240509().numberOfSubarrays(new int[]{1, 1, 2, 1, 1}, 2);
		System.out.println(i);
	}
}
