package November.LH;

import November.ZS.ListNode;

class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        Solution solution = new Solution();
        solution.reverseList(l1);
    }

    public ListNode reverseList(ListNode head) {
        //迭代解决 不能违反线性表的原则  两种办法
        //递归解决
        if (head == null) return head;
        ListNode cur = head, pre = null, temp = null;
        while (cur != null) {
            temp = cur.next; //不使用temp的话 会让第二次循环的时候cur == null
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}