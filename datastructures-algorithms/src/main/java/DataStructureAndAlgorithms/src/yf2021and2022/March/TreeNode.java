package March;

/**
 * @description:
 * @author: Tian
 * @time: 2021/3/1 16:10
 */


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
