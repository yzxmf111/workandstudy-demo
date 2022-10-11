package DataStructureAndAlgorithms.src.gogogo;

import gogogo.ListNode;

public class Day010 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        Day010 day010 = new Day010();
        day010.reverseBetween(one, 2, 4);
    }

    //移动两个节点
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode pre = new ListNode(0);
        ListNode cur = pre, res = pre, start = null;
        pre.next = head;
        int i = 1, j = 0;
        while (i < left) {
            pre = pre.next;
            i++;
        }
        while (j < right) {
            cur = cur.next;
            j++;
        }
        start = pre.next;
        ListNode after = cur.next;
        cur.next = null;
        pre.next = reverse(start);
        start.next = after;
        return res.next;
    }

    //递归
    private ListNode reverse(ListNode head) {
        while (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
