package DataStructureAndAlgorithms.src.gogogo.listNode;

import gogogo.ListNode;

/**
 * @author xiaotian
 * @description 链表相关算法
 * @date 2023-03-15 19:22
 */
public class Solution {

    //start->1->2->3->4  s->2->1
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode start = pre;
        start.next = head;
        while (start.next != null && start.next.next != null) {
            ListNode firstNode = start.next;
            ListNode secondNode = start.next.next;
            start.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            start = firstNode;
        }
        return pre.next;
    }

    //start->1->2->3->4
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode firstNode = head;
        ListNode secondNode = head.next;
        firstNode.next = swapPairs2(secondNode.next);
        secondNode.next = firstNode;
        return secondNode;
    }
    //public ListNode swapPairs(ListNode head) {
    //    //递归的终止条件
    //    if ( head == null || head.next == null) return head;
    //    //最小重复问题,当前层的处理逻辑,第一二节点交换并指向新的节点                //不要思考完整的调用栈，一级又一级，无从下手。
    //    ListNode firstNode = head;
    //    ListNode secondNode = head.next;
    //    firstNode.next = swapPairs(secondNode.next);
    //    secondNode.next = firstNode;
    //    return secondNode;
    //    //时间复杂度 O(n),空间复杂度O(n)
    //}

}
