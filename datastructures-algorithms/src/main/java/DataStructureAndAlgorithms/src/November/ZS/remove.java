package November.ZS;

public class remove {
    int begin = 0;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        //预先指针 + 双指针,递归/迭代 一次遍历
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode start = pre;
        ListNode end = pre;
        while (n != 0) {
            start = start.next;
            n--;
        }
        //start.next == null 就要终止了 .循环结束后正好end为要删除节点的前一个节点
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;

    }

}
