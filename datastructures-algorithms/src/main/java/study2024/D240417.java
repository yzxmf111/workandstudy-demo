package study2024;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/17 14:40
 **/
public class D240417 {
	public int[] topK(int[] nums, int k) {
		Map<Integer, Integer> keyMap = new HashMap<>();
		Queue<Integer> queue = new PriorityQueue<>(
				(o1, o2) -> keyMap.get(o1) - keyMap.get(o2)
		);
		for (int num : nums) {
			keyMap.put(num, keyMap.getOrDefault(num, 0) + 1);
		}
		Set<Integer> set = keyMap.keySet();
		int j = 0;
		for (Integer key : set) {
			if (j < k) {
				queue.offer(key);
				j++;
			} else {
				Integer head = queue.peek();
				if (keyMap.get(key) > keyMap.get(head)) {
					queue.poll();
					queue.offer(key);
				}
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < res.length; i++) {
			res[i] = queue.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,1,1,2,2,3};
		new D240417().topK(nums, 2);
	}

	public int[] smallestK(int[] arr, int k) {
		if (k == 0 || arr == null || arr.length ==0) {
			return new int[]{};
		}
		Queue<Integer> queue = new PriorityQueue<>(
				(o1, o2) -> o2 - o1
		);
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				queue.offer(arr[i]);
			} else {
				Integer head = queue.peek();
				if (head > arr[i]) {
					queue.remove();
					queue.offer(arr[i]);
				}
			}
		}
		int[] res = new int[k];
		for (int i = 0; i < res.length; i++) {
			res[i] = queue.poll();
		}
		return res;
	}

	/**
	 * 此处应该当做队列
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addLast(root);
		while (deque.size() > 0) {
			int size = deque.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = deque.removeFirst();
				subList.add(treeNode.val);
				if (treeNode.left != null) {
					deque.addLast(treeNode.left);
				}
				if (treeNode.right != null) {
					deque.addLast(treeNode.right);
				}
			}
			res.add(subList);
		}
		return res;
	}

	public List<List<Integer>> levelOrder2(TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		deque.addLast(root);
		while (deque.size() > 0) {
			int size = deque.size();
			List<Integer> subList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				TreeNode treeNode = deque.removeFirst();
				subList.add(treeNode.val);
				if (treeNode.left != null) {
					deque.addLast(treeNode.left);
				}
				if (treeNode.right != null) {
					deque.addLast(treeNode.right);
				}
			}
			res.add(0, subList);
		}
		return res;
	}

	// public List<List<Integer>> levelOrder(Node root) {
	// 	if (root == null) {
	// 		return Collections.emptyList();
	// 	}
	// 	List<List<Integer>> res = new ArrayList<>();
	// 	Deque<TreeNode> deque = new LinkedList<>();
	// 	deque.addLast(root);
	// 	while (deque.size() > 0) {
	// 		int size = deque.size();
	// 		List<Integer> subList = new ArrayList<>();
	// 		for (int i = 0; i < size; i++) {
	// 			TreeNode treeNode = deque.removeFirst();
	// 			subList.add(treeNode.val);
	// 			List<Node> childs = treeNode.getChildren();
	// 			for (Node node : childs) {
	// 				deque.addLast(node);
	// 			}
	// 		}
	// 		res.add(subList);
	// 	}
	// 	return res;
	// }
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode() {}
	 *     TreeNode(int val) { this.val = val; }
	 *     TreeNode(int val, TreeNode left, TreeNode right) {
	 *         this.val = val;
	 *         this.left = left;
	 *         this.right = right;
	 *     }
	 * }
	 */
}
