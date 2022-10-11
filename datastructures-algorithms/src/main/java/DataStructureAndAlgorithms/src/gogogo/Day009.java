package gogogo;

import java.util.HashMap;
import java.util.Map;

public class Day009 {
    public static void main(String[] args) {
//        new ListNode()
//        hasCycle();
    }
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        int pos = 0;
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, pos++);
            head = head.next;
        }
        return false;
    }


    public static ListNode hasCycle2(ListNode head) {
        if (head == null || head.next == null) return null;
        Map<ListNode, Integer> map = new HashMap<>();
        int pos = 0;
        while (head != null) {
            if (map.containsKey(head)) {
                return head;
            }
            map.put(head, pos++);
            head = head.next;
        }
        return null;
    }
}