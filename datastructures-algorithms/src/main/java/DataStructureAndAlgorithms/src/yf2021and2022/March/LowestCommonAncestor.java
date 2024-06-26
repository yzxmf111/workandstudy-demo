package March;


import study2024.TreeNode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/1 17:49
 */


public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if (left ==  null) return right;
        if (right == null) return left;
       return root;
    }
}
