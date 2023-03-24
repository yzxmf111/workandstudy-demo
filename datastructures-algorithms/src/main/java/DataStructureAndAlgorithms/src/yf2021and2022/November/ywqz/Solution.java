package November.ywqz;

import November.ZS.ListNode;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        solution.sortList(l1).toString();

    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        //使用归并排序,分而治之,要想分,必须先找到中间节点
         /*
            查找 当前链表的 “中点”
         */
        ListNode first_Node = head;
        ListNode slow_Node = head;
        while (first_Node != null || first_Node.next != null) {
            first_Node = first_Node.next.next;
            slow_Node = slow_Node.next;
        }
        ListNode mid_Node = slow_Node;
        slow_Node.next = null;//duankai
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(mid_Node);
        return merge(leftHead,rightHead);

    }

    private ListNode merge(ListNode leftHead, ListNode rightHead) {
        if (leftHead == null) return rightHead;
        if (rightHead == null) return leftHead;
        if (leftHead.val < rightHead.val) {
            leftHead.next = merge(leftHead.next,rightHead);
            return leftHead;
        } else {
            rightHead.next = merge(leftHead,rightHead.next);
            return rightHead;
        }
    }
}