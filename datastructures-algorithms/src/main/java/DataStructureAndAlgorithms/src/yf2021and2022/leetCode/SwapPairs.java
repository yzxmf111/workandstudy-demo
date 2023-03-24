package January.leetCode;

import November.ZS.ListNode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/17 17:40
 */


public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //迭代
        if (head == null || head.next == null) {
            return head;
        }
        //防止头结点丧失
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = pre;

        ListNode first = null;
        ListNode second = null;
        while (cur.next != null && cur.next.next != null) {
            //目的在于使我们不发生空指针异常
            first = cur.next;
            second = cur.next.next;
            first.next = second.next;
            second.next = cur.next ;
            cur.next = second;
            cur = first;
        }
        return pre.next;
    }
}
