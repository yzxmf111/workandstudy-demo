package study2024;



import java.util.HashMap;
import java.util.Map;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/2/21 16:30
 **/
public class D240221 {

	private Map<Integer, Integer> dic = new HashMap<>();


	/**
	 * 1.18.1 从前序与中序遍历序列构造二叉树（分治）
	 */
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			dic.put(inorder[i], i);
		}
		return recursion(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode recursion(int[] preorder, int[] inorder, int preTreLeft, int preTreRight, int inorderTreeLeft, int inorderTreeRight) {
		if (preTreLeft > preTreRight) {
			return null;
		}

		TreeNode root = new TreeNode(preorder[preTreLeft]);
		Integer inorderRootIndex = dic.get(preorder[preTreLeft]);
		Integer diffNum = inorderRootIndex - inorderTreeLeft;
		root.left = recursion(preorder, inorder, preTreLeft + 1, preTreLeft + diffNum, inorderTreeLeft, inorderRootIndex - 1);
		root.right = recursion(preorder, inorder, preTreLeft + 1 + diffNum, preTreRight,inorderRootIndex + 1, inorderTreeRight);
		return root;
	}

	public static void main(String[] args) {
		int[] pre = {3,9,20,15,7};
		int[] inorder = {9,3,15,20,7};
		D240221 d240221 = new D240221();
		TreeNode treeNode = d240221.buildTree(pre, inorder);
		System.out.println(treeNode);
	}
}
