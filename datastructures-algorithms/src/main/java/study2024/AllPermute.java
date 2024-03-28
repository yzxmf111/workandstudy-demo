package study2024;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description 全排列
 * @Date 2024/3/27 14:37
 **/
public class AllPermute {

	public static void main(String[] args) {
		int[] a = {3,3,0,3};
		final AllPermute allPermute = new AllPermute();
		allPermute.permute(a);

	}
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		Deque<Integer> queue = new ArrayDeque<>();
		boolean[] used = new boolean[nums.length];
		//排序是剪枝的前提
		Arrays.sort(nums);
		dfs(nums, queue, res, used);
		return res;
	}

	private void dfs(int[] nums, Deque<Integer> path, List<List<Integer>> res, boolean[] used) {
		if (path.size() == nums.length) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
					continue;
				}
				path.addLast(nums[i]);
				used[i] = true;
				dfs(nums, path, res, used);
				System.out.println("path = " + path);
				path.removeLast();
				used[i] = false;
			}
		}
	}
	//
	//
	// public List<List<Integer>> permuteUnique(int[] nums) {
	// 	List<List<Integer>> list = new ArrayList<>();
	// 	if (nums == null || nums.length == 0) return list;
	// 	boolean[] used = new boolean[nums.length];
	// 	Deque<Integer> deque = new ArrayDeque<>();
	// 	Arrays.sort(nums);
	// 	dfs(0, nums.length, nums, used, deque, list);
	// 	return list;
	// }
	//
	// private void dfs(int index, int length, int[] nums, boolean[] used, Deque<Integer> path, List<List<Integer>> list) {
	// 	if (index == length) {
	// 		list.add(new ArrayList<>(path));
	// 	}
	// 	for (int i = 0; i < nums.length; i++) {
	// 		//空间换时间
	// 		if (!used[i]) {
	// 			//画出递归树，used[i - 1] == false 怕在顶端出错
	// 			if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
	// 				continue;
	// 			}
	// 			path.addLast(nums[i]);
	// 			used[i] = true;
	//
	// 			dfs(index + 1, length, nums, used, path, list);
	//
	// 			path.removeLast();
	// 			used[i] = false;
	// 		}
	// 	}
	// }
}
