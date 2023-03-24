package April;

import November.LH.ListNode;

public class About408 {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        //head是奇数节点的头节点, odd是尾节点
        ListNode odd = head;
        // p是偶数节点的头节点, even是尾节点
        ListNode even = head.next;
        ListNode p = even;

        while (odd != null && odd.next != null && even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = p;
        return head;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //以空间换时间
        return null;
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(head.val - 1);
        pre.next = head;
        ListNode newHead = pre;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur.next = cur.next.next;
                }
                newHead.next = cur.next;
            } else {
                newHead = cur;
            }
            cur =  cur.next;
        }
        return pre.next;
    }
}
