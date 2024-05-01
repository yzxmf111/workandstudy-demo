package study2024;

import gogogo.ListNode;

import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/15 13:41
 **/
public class D240415 {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode cur = pre, end = pre, start, after;
		cur.next = head;
		while (left > 1) {
			cur = cur.next;
			left--;
		}
		while (right > 0) {
			end = end.next;
			right--;
		}
		after = end.next;
		end.next = null;
		start = cur.next;
		cur.next  = reverseList(start);
		start.next = after;
		return pre.next;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return cur;
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode cur = pre, end = pre, start, after;
		cur.next = head;
		while (cur != null) {
			int j = k;
			while (j > 0 && end != null) {
				end = end.next;
				j--;
			}
			if (end == null)  {
				break;
			}
			start = cur.next;
			after = end.next;
			end.next = null;
			cur.next = reverseList(start);
			start.next = after;
			cur = start;
			end = start;

		}
		return pre.next;
	}

}
