package study2024;

import gogogo.ListNode;

import java.util.HashMap;
import java.util.Map;


/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/11 13:48
 **/
public class D240411 {

	public ListNode reverseList(ListNode head) {
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

	/**
	 * 1.11 最小覆盖子串
	 */
	public String minWindow(String s, String t) {
		if (s.length() < t.length()) {
			return "";
		}
		char[] charS = s.toCharArray();
		char[] charT = t.toCharArray();
		Map<Character, Integer> mapS = new HashMap<>();
		Map<Character, Integer> mapT = new HashMap<>();
		for (char c : charT) {
			mapT.put(c, mapT.getOrDefault(c, 0) + 1);
		}
		int len = Integer.MAX_VALUE, cnt = 0;
		String str = "";
		for (int left = 0, right = 0; left < charS.length; left++) {
			mapS.put(charS[left], mapS.getOrDefault(charS[left], 0) + 1);
			if (mapT.containsKey(charS[left]) && mapS.get(charS[left]) <= mapT.get(charS[left])) {
				cnt++;
			}
			//滑动
			while (left < right && (!mapT.containsKey(charS[left]) || mapS.get(charS[left]) > mapT.get(charS[left]))) {
				mapS.put(charS[left], mapS.get(charS[left]) - 1);
				left++;
			}
			if (cnt == charS.length && right - left + 1 < len) {
				len = right - left + 1;
				str.substring(left, right + 1);
			}
		}
		return str;
	}

	/**
	 * 合并有序链表
	 *
	 * @param
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}

	public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		ListNode tmp = new ListNode(Integer.MIN_VALUE), pre = tmp;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				tmp.next = list1;
				tmp = list1;
				list1 = list1.next;
			} else {
				tmp.next = list2;
				tmp = list2;
				list2 = list2.next;
			}
		}
		if (list1 == null) {
			tmp.next = list2;
		}
		if (list2 == null) {
			tmp.next = list1;
		}
		return pre.next;
	}

	}
