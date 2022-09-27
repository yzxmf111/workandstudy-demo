package gogogo;

/**
 * @author xiaotian
 * @description 合并两个有序链表
 * @date 2022-09-22 17:12
 */
public class Day0922 {
    //method-one：加入list，根据值排序，空间复杂度O(m+n) 时间复杂度O(log(m+n))
    //method-two:空间复杂度O(1) 时间复杂度O(m  or n))
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode cur = new ListNode();
        ListNode pre = cur;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return pre.next;
    }

    //       public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if (list1 == null) return list2;
//        if (list2 == null) return list1;
//
//        if (list1.val < list2.val) {
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        } else {
//            list2.next = mergeTwoLists(list2.next, list1);
//            return list2;
//        }
//    }
    //    递归写法
    //method-two:空间复杂度O(m or n) 时间复杂度O(m  or n))

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
