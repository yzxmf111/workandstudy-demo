package study2024;

import gogogo.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author yifan.tian
 * @Description
 * @Date 2024/3/4 11:44
 **/
public class D240334 {
	//栈
//	public boolean isPalindrome(ListNode head) {
//		Deque<Integer> deque = new ArrayDeque<>();
//		ListNode cur = head;
//		while (head != null ) {
//			deque.addFirst(head.val);
//			head = head.next;
//		}
//		while (cur != null) {
//			Integer value = deque.removeFirst();
//			if (cur.val != value) {
//				return false;
//			}
//			cur = cur.next;
//		}
//		return true;
//	}


//	public boolean isPalindrome(ListNode head) {
//		if (head == null || head.next == null) return true;
//		ListNode reverseListNode = reverse(head);
//
//	}

	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);
		ListNode five = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
//		boolean palindrome = new D240334().isPalindrome(one);
//		System.out.println(palindrome);
	}

	public ListNode reverse(ListNode head){
		ListNode pre = null, cut = head, nxt = null;
		while (cut != null) {
			nxt = cut.next;
			cut.next = pre;
			pre = cut;
			cut = nxt;
		}
		return pre;
	}

}
