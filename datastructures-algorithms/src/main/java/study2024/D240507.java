package study2024;

import javax.validation.constraints.Max;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/7 17:17
 **/
public class D240507 {

	public int longestConsecutive(int[] nums) {
		if (nums.length == 0 || nums.length == 1) {
			return nums.length;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int max = 0;
		for (int num : nums) {
			if (set.contains(num - 1)) {
				continue;
			}
			int res = 0;
			while (set.contains(num)) {
				res++;
				num++;
			}
			max = Math.max(res, max);
		}
		return max;
	}



	public int subarraySum(int[] nums, int k) {
		int res = 0;
		for (int left = 0; left < nums.length; left++) {
			int sum = 0;
			for (int right = left; right < nums.length; right++) {
				sum += nums[right];
				if (sum > k) {
					break;
				}
				if (sum == k) {
					res++;
				}
			}

		}
		return res;

	}

	// private void dfs(int begin, int n, int sum, int target, int[] nums, Deque<Integer> path, List<List<Integer>> res) {
	// 	if (sum == target) {
	// 		List<Integer> subRes = new ArrayList<>(path);
	// 		if (judgePath(subRes)) {
	// 			res.add(subRes);
	// 		}
	// 		return;
	// 	}
	// 	if (sum > target) {
	// 		return;
	// 	}
	// 	for (int i = begin; i < n; i++) {
	// 		path.addLast(i);
	// 		dfs(i + 1, n, sum + nums[i], target, nums, path, res);
	// 		path.removeLast();
	// 	}
	// }
	//
	// public boolean judgePath(List<Integer> subRes) {
	// 	subRes = subRes.stream().sorted().collect(Collectors.toList());
	// 	for (int i = 0; i < subRes.size(); i++) {
	// 		if (i+1 < subRes.size() && subRes.get(i+1) != subRes.get(i) + 1) {
	// 			return false;
	// 		}
	// 	}
	// 	return true;
	// }
	//




	public static void main(String[] args) {
		D240507 d240507 = new D240507();
		int i = d240507.subarraySum(new int[]{1,-1,0}, 0);
		System.out.println(i);
		// List<Integer> res = new ArrayList<>();
		// res.add(1);
		// res.add(3);
		// res.add(2);
		// d240507.judgePath(res);
	}
}
