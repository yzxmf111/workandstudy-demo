package study2024;

import March.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yifan.tian
 * @Description 二叉树的层序遍历 组合
 * @Date 2024/3/26 13:53
 **/
public class D240326 {
	public List<List<Integer>> levelOrder(March.TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Queue<March.TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (queue.size() > 0) {
			final int size = queue.size();
			List<Integer> sunList = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				final TreeNode cur = queue.remove();
				sunList.add(cur.val);
				if (cur.left != null) {
					queue.offer(cur.left);
				}
				if (cur.right != null) {
					queue.offer(cur.right);
				}
			}
			res.add(sunList);
		}
		return res;
	}

}
