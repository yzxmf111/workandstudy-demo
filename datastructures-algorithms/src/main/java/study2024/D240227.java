package study2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/2/27 10:22
 **/
public class D240227 {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		//排序的目的在于去重 key one
		Arrays.sort(nums);
//		if (nums[0] > target) {
//			return res;
//		}
		for (int i = 0; i < nums.length - 3; i++) {
			//可剪枝
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
					if (nums[left] + nums[right] + nums[j] == target - nums[i]) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						while (left < right && nums[left] == nums[left - 1]) left++;
						while (left < right && nums[right] == nums[right + 1]) right--;
					} else if(nums[left] + nums[right] + nums[j] < target - nums[i]) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
//		D240227 d240227 = new D240227();
//		int[] a = {1000000000,1000000000,1000000000,1000000000};
//		List<List<Integer>> lists = d240227.fourSum(a, -294967296);
//		System.out.println(lists);
	}
}
