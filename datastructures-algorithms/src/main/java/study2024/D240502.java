package study2024;

import gogogo.ListNode;

/**
 * @author xiaotian
 * @description 合并多个有序链表
 * @date 2024-05-02 22:54
 */
public class D240502 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        //k代表lists的长度
        int k = lists.length;
        while (k > 1) {
            int idx = 0;
            for (int i = 0; i < k; i+=2) {
                if (i == k - 1) {
                    lists[idx++] = lists[i];
                } else {
                    lists[idx++] = mergeTwoList(lists[i], lists[i+1]);
                }
            }
            k = idx;
        }
        return lists[0];
    }


    private ListNode mergeTwoList(ListNode listOne, ListNode listTwo) {
        if (listOne == null) {
            return listTwo;
        }
        if (listTwo == null) {
            return listOne;
        }
        if (listOne.val < listTwo.val) {
            listOne.next = mergeTwoList(listOne.next, listTwo);
            return listOne;
        } else {
            listTwo.next = mergeTwoList(listOne, listTwo.next);
            return listTwo;
        }
    }

    //[[1,4,5],[1,3,4],[2,6]]

    public static void main(String[] args) {
        ListNode[] req = new ListNode[3];
        ListNode one = new ListNode(1);
        ListNode two  = new ListNode(4);
        ListNode three = new ListNode(5);
        one.next = two;
        two.next = three;
        req[0] = one;

        ListNode four = new ListNode(1);
        ListNode five  = new ListNode(3);
        ListNode six = new ListNode(4);
        four.next = five;
        five.next = six;
        req[1] = four;

        ListNode seven = new ListNode(2);
        ListNode eight  = new ListNode(6);
        seven.next = eight;
        req[2] = seven;
        D240502 d240502 = new D240502();
        d240502.mergeKLists(req);


    }
}
