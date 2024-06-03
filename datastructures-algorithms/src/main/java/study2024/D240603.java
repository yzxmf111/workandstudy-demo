package study2024;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/6/3 14:12
 **/
public class D240603 {

    public static void main(String[] args) {
        Integer[] nums = {1,23,43,23,423,534534,123};
        Arrays.sort(nums, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }

        });
        System.out.println(Arrays.toString(nums));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        dfs(res, root.left);
        dfs(res, root.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfss(root);
        return root;
    }

    private TreeNode dfss(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode left = dfss(root.left);
        TreeNode right = dfss(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode newRoot = new TreeNode(root1.val + root2.val);
        newRoot.left = mergeTrees(root1.left, root2.left);
        newRoot.right = mergeTrees(root1.right, root2.right);
        return newRoot;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }


    /**
     * 二叉树的深度
     * @param root
     * @return
     */
    public int calculateDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        List<List<Integer>> res = new ArrayList<>();
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
        return res.size();
    }

//
//    public TreeNode deduceTree(int[] preorder, int[] inorder) {
//
//    }
}
