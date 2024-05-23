package study2024.acm;

import java.util.Scanner;

/**
 * @Author: yzxmf
 * @Date: 2024/05/21/22:37
 * @Description:
 */
public class TestInAndOut {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(",");
        ListNode head = converterListNode(nums);
        ListNode res = reverseListNode(head);
        System.out.println(res);
    }

    private static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    private static ListNode converterListNode(String[] nums) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode res = pre;
        for (int i = 0; i < nums.length; i++) {
            ListNode cur = new ListNode(Integer.parseInt(nums[i]));
            pre.next = cur;
            pre = pre.next;
        }
        return res.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            val = this.val;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}



