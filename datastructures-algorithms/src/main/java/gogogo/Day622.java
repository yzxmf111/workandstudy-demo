package gogogo;


import xiaotian.entity.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author xiaotian
 * @description
 * @date 2022-06-22 16:55
 */
public class Day622 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    /**
     * 需要根据当前层数遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) return resultList;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.peek() != null) {
            int n = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                subList.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            resultList.add(subList);
        }
        return resultList;
    }


    public static void main(String[] args) {
        int a = 102000 % 375;
        System.out.println(a);
    }
}
