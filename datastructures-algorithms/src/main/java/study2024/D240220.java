package study2024;


import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/2/20 10:12
 **/
public class D240220 {

	int[] preorder;
	HashMap<Integer, Integer> dic = new HashMap<>();

	public static void main(String[] args) {
		D240220 d240220 = new D240220();
//		boolean valid = d240220.isValid("()}");
//		System.out.println(valid);

		String s = d240220.decodeString("2[a2[c]]");
		System.out.println(s);
	}

	public boolean isValid(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		for (Character c : s.toCharArray()) {
			if (c.equals('(')) {
				deque.addFirst(')');
			} else if (c.equals('[')) {
				deque.addFirst(']');
			} else if (c.equals('{')) {
				deque.addFirst('}');
			} else if (deque.isEmpty() || !c.equals(deque.removeFirst())) {
				return false;
			}
		}
		return deque.isEmpty();
	}

	public String decodeString(String s) {
		Deque<Integer> numStack = new LinkedList<>();
		Deque<String> strStack = new LinkedList<>();
		if (s == null || s.length() == 0) {
			return null;
		}
		char[] chars = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		Integer num = 0;
		int length = chars.length;
		for (int i = 0; i < length; i++) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				//防止 32[a] 出现
				num = num * 10 + Integer.parseInt(chars[i] + "");
			} else if (chars[i] == '[') {
				numStack.addFirst(num);
				strStack.addFirst(sb.toString());
				//置为原始值
				num = 0;
				sb = new StringBuilder();
			} else if (chars[i] == ']') {
				StringBuilder temp = new StringBuilder();
				Integer size = numStack.removeFirst();
				for (Integer j = 0; j < size; j++) {
					temp.append(sb);
				}
				sb = new StringBuilder().append(strStack.removeFirst()).append(temp.toString());
			} else {
				sb.append(chars[i]);
			}
		}
		return sb.toString();
	}
	private Map<Integer, Integer> indexMap;

	public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
		if (preorder_left > preorder_right) {
			return null;
		}

		// 前序遍历中的第一个节点就是根节点
		int preorder_root = preorder_left;
		// 在中序遍历中定位根节点
		int inorder_root = indexMap.get(preorder[preorder_root]);

		// 先把根节点建立出来
		TreeNode root = new TreeNode(preorder[preorder_root]);
		// 得到左子树中的节点数目
		int size_left_subtree = inorder_root - inorder_left;
		// 递归地构造左子树，并连接到根节点
		// 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
		root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
		// 递归地构造右子树，并连接到根节点
		// 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
		root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
		return root;
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构造哈希映射，帮助我们快速定位根节点
		indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
	}


}


