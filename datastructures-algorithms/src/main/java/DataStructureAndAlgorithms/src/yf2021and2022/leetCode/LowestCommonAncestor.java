package DataStructureAndAlgorithms.src.yf2021and2022.leetCode;

/**
 * @description: dfs递归算法及其注意事项
 * @author: Tian
 * @time: 2021/1/27 16:25
 */


public class LowestCommonAncestor {
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

     class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ////递归的终止条件
    //if (root == null || root == p || root == q) return root;
    ////向下递归 & 当前层的处理逻辑
    ////4                                  2
    //TreeNode left = lowestCommonAncestor(root.left, p, q);
    //TreeNode right = lowestCommonAncestor(root.right, p, q);
    //if (left == null) return right;
    //if (right == null) return left;
    //return root;
}