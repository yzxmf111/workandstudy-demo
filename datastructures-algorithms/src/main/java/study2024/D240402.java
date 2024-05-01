package study2024;

import gogogo.ListNode;

import java.util.*;

/**
 * @Author yifan.tian
 * @Description 三数字之和、第三大的数、两两交换链表的结点（24）有效的字母异位词--242 二分查找--704 最近公共祖先---剑指offer68
 * @Date 2024/4/2 13:49
 **/
public class D240402 {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		if (nums[0] > 0) {
			return res;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] == 0) {
					res.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right + 1]) {
						right--;
					}
				} else if (nums[i] + nums[left] + nums[right] < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return res;
	}

	public int thirdMax(int[] nums) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		for (int num : nums) {
			treeSet.add(num);
			if (treeSet.size() > 3) {
				treeSet.pollFirst();
			}
		}
		return treeSet.size() == 3 ? treeSet.pollFirst() : treeSet.pollLast();
	}

	public ListNode swapPairs2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(-1);
		ListNode tmp = pre;
		pre.next = head;
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

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode first = head;
		ListNode second = head.next;
		first.next = swapPairs(head.next.next);
		second.next = first;
		return second;
	}

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> res = new ArrayList<>();
		if (strs == null || strs.length == 0) {
			return res;
		}
		Map<String, List<String>> tmpMap = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] chars = strs[i].toCharArray();
			Arrays.sort(chars);
			List<String> subList = tmpMap.getOrDefault(String.valueOf(chars), new ArrayList<>());
			subList.add(strs[i]);
			tmpMap.put(String.valueOf(chars), subList);
		}
		for (List<String> value : tmpMap.values()) {
			res.add(value);
		}
		return res;
	}

	public static void main(String[] args) {
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> lists = new D240402().groupAnagrams(strs);
	}

	public March.TreeNode lowestCommonAncestor(March.TreeNode root, March.TreeNode p, March.TreeNode q) {
		if (root == null || root == p || root == q) return root;
		March.TreeNode left = lowestCommonAncestor(root.left, p, q);
		March.TreeNode right = lowestCommonAncestor(root.right, p, q);
		if (left == null) return right;
		if (right == null) return left;
		return root;
	}

	}