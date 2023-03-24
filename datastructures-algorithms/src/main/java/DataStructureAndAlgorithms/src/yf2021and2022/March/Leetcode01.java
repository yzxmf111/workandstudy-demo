package March;

import November.LH.ListNode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/***
 * <p>
 *  3. throw, *throws*,*try-catch*区别?
 *
 * throw 相当于是产生了编译期异常,后边程序无法再运行了
 *
 * *throws*:不出现异常,后边的程序照常运行.出现异常,后边程序无法再运行了--jvm中断处理
 *
 * *try-catch*:出不出现异常,后边程序照常运行.
 * </p>
 */
public class Leetcode01 {

    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        char[] arr = s.toCharArray();
        boolean flag = false;
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(') deque.offer(')');
            else if (arr[i] == '[') deque.offerLast(']');
            else if (arr[i] == '{') deque.offerLast('}');
            else if (deque.isEmpty() || deque.pollLast() != arr[i]) {
                System.out.println(flag);
                break;
            }
        }
        if (deque.isEmpty()) {
            System.out.println(flag = true);
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return head;
        //关键在与找到要反转链表的前置节点和后边的节点
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode first = pre;
        ListNode end = pre;

        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                }
                if (end == null) break;;
            }
            if (end == null) break;;
            ListNode start = first.next;
            ListNode newHead = end.next;
            end.next = null;
            first.next = reverseListNode(start);
            start.next = newHead;
            //first.next = end;
            first = start;
            end = start;
        }
        return pre.next;

    }
    private ListNode reverseListNode(ListNode head){
        //迭代实现
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
