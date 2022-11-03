package gogogo;

/**
 * @author xiaotian
 * @description 排序链表 要求:常数级空间复杂度和o（nlogn）的时间复杂度
 * @date 2022-10-17 16:58
 */
public class Day1017 {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        return mergeSort(head);

    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null && fastNode.next != null && /*关键点*/ fastNode.next.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
        }
        /*关键点*/
        ListNode midNode = slowNode.next;
        slowNode.next = null;
        ListNode leftNode = mergeSort(head);
        ListNode rightNode = mergeSort(midNode);
        ListNode mergeList = merge(leftNode, rightNode);//合并两个有序链表
        System.out.println(mergeList.toString());
        return mergeList;
    }


    private ListNode merge(ListNode headNode, ListNode midNode) {
        if (headNode == null) return midNode;
        if (midNode == null) return headNode;
        if (headNode.val < midNode.val) {
            headNode.next = merge(headNode.next, midNode);
            return headNode;
        } else {
            midNode.next = merge(headNode, midNode.next);
            return midNode;
        }
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(0);
        ListNode four = new ListNode(-4);
        ListNode five = new ListNode(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = null;
        Day1017 day1017 = new Day1017();
        day1017.mergeSort(one);
    }

}
