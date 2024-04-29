package study2024;

import gogogo.ListNode;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/29 17:30
 **/
public class D240429 {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		D240429 d240429 = new D240429();
		d240429.swapPair(listNode);
	}

	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		ListNode tmp = pre;
		tmp.next = head;
		while (tmp.next != null && tmp.next.next != null) {
			ListNode first = tmp.next;
			ListNode second = tmp.next.next;
			tmp.next = second;
			first.next = second.next;
			second.next = first;
			tmp = first;
		}
		return pre.next;
	}

	public ListNode swapPair(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		first.next = swapPair(second.next);
		second.next = first;
		return second;
	}

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		for (char c : charS) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		for (char c : charT) {
			map.put(c, map.getOrDefault(c, 0) - 1);
		}

		for (Integer value : map.values()) {
			if (value != 0) {
				return false;
			}
		}
		return true;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			List<String> orDefault = map.getOrDefault(String.valueOf(chars), new ArrayList<>());
			orDefault.add(strs[i]);
			map.put(String.valueOf(chars), orDefault);
		}
		return new ArrayList<>(map.values());
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

	public int maxArea(int[] height) {
		int max = 0, submax = 0, left = 0, right = height.length - 1;
		// for (int i = 0; i < height.length; i++) {
		// 	submax =
		// }
		//
		while (left < right) {
			submax = height[left] < height[right] ? (right - left) * height[left++] : (right - left) * height[right--];
			max = Math.max(submax, max);
		}
		return max;
	}
	// public int trap(int[] height) {
	// 	int right = 0;
	// 	int len = height.length - 1;
	//
	// 	for (int left = 0; left < len; left++) {
	// 		if (height[])
	// 	}
	// }
}