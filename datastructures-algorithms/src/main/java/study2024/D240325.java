package study2024;

import March.TreeNode;
import org.assertj.core.util.Lists;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/25 17:20
 **/
public class D240325 {

	/**
	 * 先序遍历：中左右
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversal(March.TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		dfs(root, res);
		return res;
	}

	private void dfs(TreeNode root, List<Integer> res) {
		if (root == null) {
			return;
		}
		res.add(root.val);
		dfs(root.left, res);
		dfs(root.right, res);
	}

	/**
	 * 前k个高频元素，小顶堆，o1-o2
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int[] topK(int[] nums, int k) {
		if (nums == null || nums.length < k) {
			return nums;
		}
		Map<Integer, Integer> map = new HashMap<>();
		Queue<Integer> queue = new PriorityQueue<>(
				(o1, o2) -> map.get(o1) - map.get(o2)
		);
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		final Set<Integer> keySet = map.keySet();
		int j = 0;
		for (Integer key : keySet) {
			if (j < k) {
				queue.offer(key);
				j++;
			} else {
				Integer peek = queue.peek();
				if (map.get(peek) < map.get(key)) {
					queue.poll();
					queue.offer(key);
				}
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.remove();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = {1,2,3};
		D240325 d240325 = new D240325();
		// int[] ints = d240325.topK(a, 2);
		d240325.smallestK(a,0);
	}

	/**
	 * 最小的k个数， 大顶堆，o2-o1
	 * @param arr
	 * @param k
	 * @return
	 */
	public int[] smallestK(int[] arr, int k) {
		if (k == 0 || arr == null || arr.length == 0) {
			return new int[]{};
		}
		Queue<Integer> queue = new PriorityQueue<>(
				(o1,o2) -> o2-o1
		);
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				queue.offer(arr[i]);
			} else {
				Integer peek = queue.peek();
				if (peek > arr[i]) {
					queue.remove();
					queue.offer(arr[i]);
				}
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = queue.remove();
		}
		return res;
	}

	/**
	 * 最近公共祖先
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		return root;
	}
}
