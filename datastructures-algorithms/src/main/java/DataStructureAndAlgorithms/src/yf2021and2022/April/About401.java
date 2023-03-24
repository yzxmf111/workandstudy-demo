package April;

import November.LH.ListNode;

public class About401 {

    /**
     * 1-2-2-3-3-3-5
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {

                cur = cur.next;
            }
        }
        return head;
    }
}
