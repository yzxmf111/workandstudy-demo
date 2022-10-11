package November.TLZF;

import November.ZS.ListNode;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one1 = new ListNode(4);
        ListNode one2 = new ListNode(2);
        ListNode one3 = new ListNode(5);
        ListNode one4 = new ListNode(7);
        ListNode one5 = new ListNode(3);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
        ListNode listNode = solution.sortList(one1);
        System.out.println(listNode);
    }

    public ListNode sortList(ListNode head) {
        //递归的终止条件
        if (head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode secondNode = head;
        while (firstNode != null && firstNode.next != null) {
            firstNode = firstNode.next.next;
            secondNode = secondNode.next;
        }
        ListNode midNode = secondNode.next;
        secondNode.next = null;//断开了链表
        //向左 + 向右
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(midNode);
        return merge(leftHead, rightHead);
    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {

        if (leftHead == null) return rightHead;
        if (rightHead == null) return leftHead;

        if (leftHead.val < rightHead.val) {
            leftHead.next = merge(leftHead.next, rightHead);
            return leftHead;
        } else {
            rightHead.next = merge(leftHead, rightHead.next);
            return rightHead;

        }
    }
}