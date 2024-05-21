package study2024;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description 复习
 * @Date 2024/5/16 15:41
 **/
public class D240516 {
	//
	// public static void main(String[] args) {
	// 	int[] nums = new int[]{2, 7, 11, 15};
	// 	D240516 d240516 = new D240516();
	// 	int[] ints = d240516.twoSum(nums, 9);
	//
	// 	List<List<Integer>> lists = d240516.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
	// 	System.out.println(lists);
	// }

	/**
	 * 2 <= nums.length <= 104
	 * -109 <= nums[i] <= 109
	 * -109 <= target <= 109
	 * 只会存在一个有效答案
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[]{i, map.get(target - nums[i])};
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[]{};
	}

	/**
	 * 1 <= nums.length <= 200
	 * -109 <= nums[i] <= 109
	 * -109 <= target <= 109
	 *
	 * @param nums
	 * @param target
	 * @return
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					if ((long) nums[i] + nums[j] + nums[left] + nums[right] == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right + 1]) {
							right --;
						}
					} else if ((long)nums[i] + nums[j] + nums[left] + nums[right] > target) {
						right--;
					} else {
						left++;
					}

				}
			}
		}
		return res;
	}

	/**
	 * 1 <= nums.length <= 2 * 104
	 * -1000 <= nums[i] <= 1000
	 * -107 <= k <= 107
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		int sum = 0, count = 0;
		for (int left = 0; left < nums.length; left++) {
			for (int right = left; right < nums.length; right++) {
				sum += nums[right];
				if (sum == k) {
					count++;
				}
			}
			sum =  0;
		}
		return count;
	}

	/**
	 * 前缀和
	 * 1 <= nums.length <= 2 * 104
	 * -1000 <= nums[i] <= 1000
	 * -107 <= k <= 107
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum2(int[] nums, int k) {
		//key:前缀和
		// key：前缀和，value：key 对应的前缀和的个数
		Map<Integer, Integer> preSumFreq = new HashMap<>();
		// 对于下标为 0 的元素，前缀和为 0，个数为 1
		preSumFreq.put(0, 1);

		int preSum = 0;
		int count = 0;
		for (int num : nums) {
			preSum += num;

			// 先获得前缀和为 preSum - k 的个数，加到计数变量里
			if (preSumFreq.containsKey(preSum - k)) {
				count += preSumFreq.get(preSum - k);
			}

			// 然后维护 preSumFreq 的定义
			preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
		}
		return count;

	}

	/**
	 * 1 <= nums.length <= 105
	 * -104 <= nums[i] <= 104
	 * 1 <= k <= nums.length
	 * @param nums
	 * @param k
	 * @return
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		for (int left = 0; left <= nums.length - k; left++) {
			// for (int right = left; right < left + k; right++) {
				int num = findMax(nums, left, left + k - 1);
				list.add(num);
			// }
		}
		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}
		return res;
	}

	private int findMax(int[] nums, int left, int right) {
		 int max = nums[left];
		 while (left <= right) {
		 	max = Math.max(nums[left++], max);
		 }
		 return max;
	}

	public static void main(String[] args) {
		D240516 d240516 = new D240516();
		Deque<Integer> deque = new ArrayDeque<>();
		int[] ints = d240516.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7
		}, 3);

	}
}
