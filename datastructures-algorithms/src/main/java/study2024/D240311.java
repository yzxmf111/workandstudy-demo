package study2024;

import gogogo.ListNode;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/11 11:34
 **/
public class D240311 {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = null, cur = head, tmp = null;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null)  return list2;
		if (list2 == null)  return list1;
		if (list1.val <= list1.val) {
			list1.next = mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeTwoLists(list1, list2.next);
			return list2;
		}
	}

}
