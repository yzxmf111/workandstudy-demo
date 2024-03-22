package study2024;

import gogogo.ListNode;

import java.util.Arrays;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/20 16:05
 **/
public class D240320 {
	public static void main(String[] args) {
		// D240320 d240320 = new D240320();
		// int[] ints = d240320.mergeSort(new int[]{2, 1, 4, 3, 6});
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(5);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		D240320 d240320 = new D240320();
		// ListNode listNode = d240320.mergeTwoLists(one);
		// System.out.println(listNode);
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		//关键在于找到关键的节点
		ListNode pre = new ListNode(-1);
		pre.next = head;
		ListNode end = pre;
		ListNode start, after;
		ListNode res = pre;
		while (end.next != null) {
			for (int i = 0; i < k; i++) {
				if (end != null) {
					end = end.next;
				} else {
					break;
				}
			}
			if (end == null) {
				break;
			}
			start = pre.next;
			after = end.next;
			end.next = null;
			pre.next = reverse(start);
			start.next = after;
			pre = start;
			end = start;
		}
		return res.next;
	}

	// 3,1,2,9,4
	// 0,1,2,3,4

	private ListNode reverse(ListNode start) {
		if (start == null || start.next == null) {
			return start;
		}
		// ListNode cur = reverse(start.next);
		// start.next.next = start;
		// start.next = null;
		// return cur;
		ListNode cur = start;
		ListNode pre = null;
		ListNode tmp = null;
		while (cur != null) {
			tmp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = tmp;
		}
		return pre;
	}

}
