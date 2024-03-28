package study2024;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description 排列组合：回溯算法
 * @Date 2024/3/26 14:03
 **/
public class Combination {
	private static final Logger logger =  LoggerFactory.getLogger(Combination.class);
	public int runeReserve(int[] runes) {
		//排序,双指针，滑动窗口
		if (runes.length == 0 || runes.length == 1) {
			return runes.length;
		}
		Arrays.sort(runes);
		int j = 0, max = 0;
		for (int i = 1; i < runes.length; i++) {
			if (runes[i] - runes[i - 1] > 1) {
				j = i;
			}
			max = Math.max(i - j + 1, max);
		}
		return max;
	}

	public static void main(String[] args) {
		int[] a = {1,3,5,4,1,7};
		int[] b = {2,3,6,7};
		final int i = new Combination().runeReserve(a);
		System.out.println(i);

		final List<List<Integer>> combine = new Combination().combine(4, 2);
		System.out.println(combine);

		final List<List<Integer>> lists = new Combination().combinationSum(b, 7);
		System.out.println(lists);
	}

	/**
	 * 排列组合---回溯算法---树的dfs（递归）---路径即结果
	 * // 1 <= n <= 20
	 * // 1 <= k <= n2
	 *
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		findRes(1, n, k, res, deque);
		return res;
	}

	private void findRes(int begin, int n, int k, List<List<Integer>> res, Deque<Integer> deque) {
		if (deque.size() == k) {
			res.add(new ArrayList<>(deque));
			return;
		}
		for (int i = begin; i <= n; i++) {
			deque.addLast(i);
			findRes(i + 1, n, k, res, deque);
			// System.out.println("deque = " + deque);
			deque.removeLast();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		Deque<Integer> deque = new ArrayDeque<>();
		int sum = 0;
		dfs( 0, candidates, res, sum, target, deque);
		return res;
	}

	private void dfs(int begin, int[] candidates,
	                 List<List<Integer>> res, int sum , int target, Deque<Integer> deque) {
		if (sum == target) {
			res.add(new ArrayList<>(deque));
			return;
		}
		if (sum > target) {
			return;
		}
		for (int i = begin; i < candidates.length; i++) {
			deque.addLast(candidates[i]);
			dfs(i, candidates, res, sum + candidates[i], target, deque);
			System.out.println("deque = " + deque+", sum = " + sum);
			deque.removeLast();
		}
	}





}
