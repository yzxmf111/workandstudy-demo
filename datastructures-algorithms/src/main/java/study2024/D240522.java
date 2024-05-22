package study2024;

import gogogo.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/22 14:38
 **/
public class D240522 {
	public static void main(String[] args) {
		// Scanner sc2 = new Scanner(System.in);
		// int n = sc2.nextInt();
		// sc2.nextLine(); // 消费掉整数后的换行符
		// if (sc2.hasNextLine()) {
		// 	String[] s1 = sc2.nextLine().split(" ");
		// 	int[] nums = new int[s1.length];
		// 	for (int i = 0; i < s1.length; i++) {
		// 		nums[i] = Integer.parseInt(s1[i]);
		// 	}
		// 	System.out.println(Arrays.toString(nums));
		// }
		D240522 d240522 = new D240522();
		String abcabcbb = d240522.lengthOfLongestSubstring("abcabcbb");
		System.out.println(abcabcbb);

	}

	public String lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int[] a = new int[2];
		System.out.println(a.length);
		int j = 0;
		int max = 0;
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				j = Math.max(j, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			if (i - j + 1 > max) {
				start = j;
				end = i;
			}
			max = Math.max(max, i - j + 1);
		}
		return s.substring(start, end + 1);
	}

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}

	public ListNode reverseListBest(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null, tmp = null, cur = head;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode tmp = pre;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tmp.next = list1;
				list1 = list1.next;
			} else {
				tmp.next = list2;
				list2 = list2.next;
			}
			tmp = tmp.next;
		}
		if (list1 == null) {
			tmp.next = list2;
		}
		if (list2 == null) {
			tmp.next = list1;
		}
		return pre.next;
	}

	public ListNode mergeKLists2(ListNode[] lists) {
		ListNode res = null;
		for (ListNode list: lists) {
			res = mergeTwoList(res, list);
		}
		return res;
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		//k代表lists的长度
		int k = lists.length;

		while (k > 1) {
			int idx = 0;
			for (int i = 0; i < k; i+=2) {
				if (i == k - 1) {
					lists[idx++] = lists[i];
				} else {
					lists[idx++] = mergeTwoList(lists[i], lists[i+1]);
				}
			}
			k = idx;
		}
		return lists[0];
	}


	private ListNode mergeTwoList(ListNode listOne, ListNode listTwo) {
		if (listOne == null) {
			return listTwo;
		}
		if (listTwo == null) {
			return listOne;
		}
		if (listOne.val < listTwo.val) {
			listOne.next = mergeTwoList(listOne.next, listTwo);
			return listOne;
		} else {
			listTwo.next = mergeTwoList(listOne, listTwo.next);
			return listTwo;
		}
	}
}