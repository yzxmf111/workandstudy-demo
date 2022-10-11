package January.leetCode;

import November.ZS.ListNode;

/**
 * @description:
 * @author: Tian
 * @time: 2021/2/25 21:04
 */


public class Solution2 {

    public ListNode swapPairs(ListNode head) {
        //递归的方法
        /*
        if (head == null || head.next == null) return head;
        ListNode firstNode = head;
        ListNode seconeNode = head.next;
        head.next = swapPairs(head.next.next);
        seconeNode.next = firstNode;
        return seconeNode;
        */
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode cur = pre; //最后的返回值
        pre.next = head;
        while(pre.next != null && pre.next.next != null ) {
            ListNode firstNode = pre.next;
            ListNode seconeNode = pre.next.next;
            pre.next = seconeNode;
            firstNode.next = seconeNode.next;
            seconeNode.next = firstNode;
            pre = firstNode;
        }
        return cur.next;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1); 
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
        three.next = four;
        Solution2 solution2 = new Solution2();
        ListNode listNode = solution2.swapPairs(one);
        System.out.println(" " + listNode);
    }
}
