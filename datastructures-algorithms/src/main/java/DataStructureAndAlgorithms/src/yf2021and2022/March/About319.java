package March;

import November.ZS.ListNode;

public class About319 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        pre.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            first.next = second.next;
            cur.next = second;
            second.next = first;
            cur = first;
        }
        return pre.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode first = head;
        ListNode second = head.next;
        head.next = swapPairs2(head.next.next);
        second.next = first;
        return second;
    }

    public boolean isPalindrome(int x) {
        String s = "" + x;
        char[] chars = s.toCharArray();
        int left = 0, right = s.length();
        while (left <= right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) return head;
        ListNode pre = new ListNode(0);
        ListNode start = pre;
        ListNode end = pre;
        pre.next = head;
        while (n != 0) {
            start = start.next;
            n--;
        }
        while (start.next != null) {
            start = start.next;
            end = end.next;
        }
        end.next = end.next.next;
        return pre.next;
    }

    public boolean backspaceCompare(String S, String T) {

        return helper(S).equals(helper(T));
    }

    private String helper(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[i] == '#') {
                count++;
                continue;
            }
            if (count != 0) {
                count--;
                continue;
            }
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
