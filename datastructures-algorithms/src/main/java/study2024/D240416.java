package study2024;

import gogogo.Day1017;
import gogogo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/4/16 16:41
 **/
public class D240416 {

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		// ListNode five = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		// four.next = five;
		// five.next = null;
		D240416 d240416 = new D240416();
		// d240416.sortList(one);

		System.out.println(d240416.isPalindrome(one));
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return dfs(head);
	}

	private ListNode dfs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode first = head, second = head, mid;
		while (first != null && first.next != null) {
			first = first.next.next;
			second = second.next;
		}
		mid = second;
		ListNode after = mid.next;
		mid.next = null;
		ListNode left = dfs(head);
		ListNode right = dfs(after);
		return mergeNode(left, right);
	}

	private ListNode mergeNode(ListNode left, ListNode right) {
		if (left == null) {
			return right;
		}
		if (right == null) {
			return left;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode cur = pre;
		while (left != null && right != null) {
			if (left.val < right.val) {
				cur.next = left;
				left = left.next;
			} else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		if (left == null) {
			cur.next = right;
		}
		if (right == null) {
			cur.next = left;
		}
		return pre.next;
	}

	public boolean isPalindrome(ListNode head) {
		Deque<Integer> deque = new ArrayDeque<>();
		ListNode cur = head;
		while (head != null) {
			deque.addFirst(head.val);
			head = head.next;
		}
		while (cur != null) {
			if (deque.removeFirst() != cur.val) {
				return false;
			}
			cur = cur.next;
		}
		return true;
	}
}
