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
		final int i = new Combination().runeReserve(a);
		System.out.println(i);

		final List<List<Integer>> combine = new Combination().combine(4, 2);
		System.out.println(combine);
	}

	/**
	 * 排列组合---回溯算法---树的dfs（递归）---路径即结果
	 * // 1 <= n <= 20
	 * // 1 <= k <= n2
	 *
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> list = new ArrayList<>();
		Deque<Integer> path = new ArrayDeque<>();
		findRes(1, n, k, path, list);
		return list;
	}

	private void findRes(int begin, int n, int k, Deque<Integer> path, List<List<Integer>> list) {
		if (path.size() == k) {
			list.add(new ArrayList<>(path));
			return;
		}
		//begin才能做到不重复。是管理的同一层
		for (int i = begin; i <= n; i++) {
			path.addLast(i); //这里不能是begin而是i，否则不能按照一定的顺序进行搜索
			//i管理的是上下层
			//这里不能是begin+1而是i+1，否则不能按照一定的顺序进行搜索 从第二个数看起 [2.2]
			//[2,2]i是2,begin是1  [3,2]i是3,begin是1
			findRes( i + 1, n, k, path, list);
			logger.info("list = {}; path = {}",list, path);
			path.removeLast();
		}
	}
}
