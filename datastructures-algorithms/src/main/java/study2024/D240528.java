package study2024;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/5/28 15:05
 **/
public class D240528 {

	/**
	 * 输入：head = [4,2,1,3]
	 * 输出：[1,2,3,4]
	 *
	 * 链表中节点的数目在范围 [0, 5 * 104] 内
	 * -105 <= Node.val <= 105
	 *
	 * 链表排序：要求O(n log n) 时间复杂度和常数级空间复杂度下
	 * 归并排序可以满足O(n log n) 时间复杂度。
	 * 分治：分到不可再分再合并：合并两个有序链表
	 */
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		return divide(head);
	}

	private ListNode divide(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		ListNode mid = slow.next;
		slow.next = null;
		ListNode left = divide(head);
		ListNode right = divide(mid);
		return merge(left, right);
	}

	private ListNode merge(ListNode one, ListNode two) {
		if (one == null) {
			return two;
		}
		if (two == null) {
			return one;
		}
		if (one.val < two.val) {
			one.next = merge(one.next, two);
			return one;
		} else {
			two.next = merge(one, two.next);
			return two;
		}
	}

	public static void main(String[] args) {
		D240528 d240528 = new D240528();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		one.next = two;
		two.next = three;
		three.next = four;
		// ListNode listNode = d240528.sortList(one);
		// System.out.println(listNode);
		d240528.reorderList(one);
	}

	/**
	 * 输入: head = [1,2,3,4]
	 * 输出: [1,4,2,3]
	 * 链表的长度范围为 [1, 5 * 104]
	 * 1 <= node.val <= 1000
	 * @param head
	 */
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		Deque<ListNode> deque = new ArrayDeque<>();
		while (head != null) {
			deque.addLast(head);
			head = head.next;
		}
		ListNode pre = new ListNode(Integer.MIN_VALUE);
		ListNode cur = pre;
		while (deque.size() > 0) {
			pre.next = deque.removeFirst();
			pre = pre.next;
			if (deque.size() > 0) {
				pre.next = deque.removeLast();
				pre = pre.next;
			}
		}
	}
}
