package gogogo;

import javafx.beans.binding.When;

/**
 * @author xiaotian
 * @description 翻转链表II--迭代和递归皆可
 * @date 2022-11-03 17:54
 */
public class Day1103 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        //1、找到相应位置
        ListNode pre = new ListNode(0), cur = pre, res = pre, start = null,  temp = null;
        pre.next = head;
        while (left > 1) {
            pre = pre.next;
            left --;
        }
        while (right >= 1) {
            cur = cur.next;//2, 3, 4
            right --;      //3, 2, 1
        }
        //2、断开
        start = pre.next;
        temp = cur.next;
        cur.next = null;
        if (cur != null) {
            //3、翻转链表
            pre.next = reverseListNode(start);
        }
        //4、链接
        start.next = temp;
        return res.next;
    }

    private ListNode reverseListNode(ListNode head) {
        ListNode pre = null, cur = head, tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    //
    ////移动两个节点
    //public ListNode reverseBetween(ListNode head, int left, int right) {
    //    if (head == null || head.next == null || left == right) {
    //        return head;
    //    }
    //    ListNode pre = new ListNode(0);
    //    //res指向一个内存地址，之后pre和cur指向了新的内存地址
    //    ListNode cur = pre, res = pre, start = null;
    //    pre.next = head;
    //    int i = 1, j = 0;
    //    while (i < left) {
    //        // pre指向一个新的地址，但是链表之间的关系没断
    //        pre = pre.next;
    //        i++;
    //    }
    //    while (j < right) {
    //        cur = cur.next;
    //        j++;
    //    }
    //    start = pre.next;
    //    ListNode after = cur.next;
    //    cur.next = null;
    //    pre.next = reverse(start);
    //    start.next = after;
    //    return res.next;
    //}
    //
    ////递归
    //private ListNode reverse(ListNode head) {
    //    while (head == null || head.next == null) {
    //        return head;
    //    }
    //    ListNode cur = reverse(head.next);
    //    head.next.next = head;
    //    head.next = null;
    //    return cur;
    //}

//1.list
//2.双指针


    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(5);
        one.next = two;

        Day1103 day1103 = new Day1103();
        ListNode listNode = day1103.reverseBetween(one, 1, 2);
        System.out.println(listNode);
    }
}
