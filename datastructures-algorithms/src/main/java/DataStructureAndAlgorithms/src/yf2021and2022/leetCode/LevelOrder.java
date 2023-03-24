package January.leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/26 20:46
 */


public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        //java建议使用Deque来代替栈的实现
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (deque.size() > 0) {
            int size = deque.size();
            List<Integer> temp = new ArrayList<>();
            while (size > 0) {
                TreeNode curNode = deque.poll();
                temp.add(curNode.val);
                size--;//mark
                if (curNode.left != null) {
                    deque.offer(curNode.left);
                }
                if (curNode.right != null) {
                    deque.offer(curNode.right);
                }
            }
            list.add(temp);
        }
        return list;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
