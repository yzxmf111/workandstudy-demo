package study2024;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yzxmf
 * @Date: 2024/05/26/17:22
 * @Description:
 */
public class D240526 {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = head.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Map<ListNode, Integer> map = new HashMap<>();
        int res = 0;
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, res++);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;
        boolean b = new D240526().hasCycle2(one);
        System.out.println(b);
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode start = evenNode;
        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        oddNode.next = start;
        return head;
    }
}
