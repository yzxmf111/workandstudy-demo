package December.LeetCode;

import November.ZS.ListNode;

public class SwapListNodeFromNToM {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = new ListNode(0);
        ListNode start = pre;
        ListNode end  = pre;
        pre.next = head;
        int i = 1,j = 0;
        while (i < m) {
            start = start.next;
            i++;
        }

        while (j < n) {
            end = end.next;
            j++;
        }

        ListNode newHead = end.next;
        end.next = null;
        ListNode first = start.next;
        start.next = swap(first);
       first.next = newHead;
        return pre.next;
    }
    private ListNode swap(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        ListNode temp;

        while(cur != null ) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */



