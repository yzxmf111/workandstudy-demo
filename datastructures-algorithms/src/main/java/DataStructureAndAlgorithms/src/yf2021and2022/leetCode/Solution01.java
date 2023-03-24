package January.leetCode;

import November.ZS.ListNode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/17 17:15
 */


public class Solution01 {

    public ListNode reverseList(ListNode head) {
       /* //方法一:迭代
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;*/
        //方法二:递归
        if (head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}