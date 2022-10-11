package November.day1129;

import November.ZS.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode first = new ListNode(0);
        ListNode end = first;
        ListNode ans = first;
        end.next = head;

        //不必加end != null的条件
        while (end != null && end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
            }
            if (end == null) break;
            ListNode start = first.next;
            ListNode newHead = end.next;
            end.next = null;

            first.next = reverseListNode(start);
            start.next = newHead;
            first = start;
            end = first;
        }
        return ans.next;

    }

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        pre.next = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
//只可以迭代