package gogogo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-26 17:19
 */
public class Day0923 {

    //1.hash表   o(n) o(n)
    //2.双指针(快慢指针)循环  o(n) o(1)
    public boolean hasCycle(ListNode head) {
        ListNode first = head, second = first;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    //1.hash表   o(n) o(n)
    //2.双指针(快慢指针)循环  o(n) o(1)
    public boolean hasCycle2(ListNode head) {
        Map<ListNode, Integer> map = new HashMap<>();
        int index = 0;
        while (head != null) {
            if (map.get(head) != null) {
                return true;
            }
            map.put(head, index++);
            head = head.next;
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode first = head, second = first;
        boolean flag = false;
        while (first != null && first.next != null) {
            first = first.next.next;
            second = second.next;
            if (first == second) {
                flag = true;
                break;
            }
        }

        if (flag) {
            first = head;
            while (first != second) {
                first = first.next;
                second = second.next;
            }
            return first;
        }
        return null;
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
        ListNode listNode = detectCycle(one);
        System.out.println(listNode.val );
    }


    /**
     * 法一（快慢指针）
     * （1）通过快慢指针判断链表是否有环
     * （2）如果有环，则寻找入环的第一个节点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next; // 快指针每次比慢的多走一个
            slow = slow.next;
            if (Objects.equals(fast, slow)) { // 当快指针比慢指针多走一圈时，相遇便成环
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode start = head;  // start从起点开始，slow从与fast相遇处开始
            while (start != slow) { // 若start遇到slow，则相遇处即为入环的第一个节点
                start = start.next;
                slow = slow.next;
            }
            return start;
        } else {
            return null;
        }
    }

}
