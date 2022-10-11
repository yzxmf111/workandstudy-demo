package March;

import November.LH.ListNode;

public class About318 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        ListNode pre = new ListNode(0);
        ListNode first = pre;
        ListNode end = pre;
        pre.next = head;
        while (first != null && left - 1 > 0) {
            first = first.next;
            left--;
        }

        while (end != null && right > 0) {
            end = end.next;
            right--;
        }
        ListNode start = first.next;
        ListNode newHead = end.next;
        end.next = null;
        first.next = swap(start);
        start.next = newHead;
        return pre.next;
    }

    private ListNode swap(ListNode head) {
        ListNode pre = new ListNode(0);
        ListNode cur = head;
        ListNode temp;

        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

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


    class ParkingSystem {

        private int big;
        private int medium;
        private int small;

        public ParkingSystem(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            switch (carType) {
                case 1: {
                    if (big > 0) {
                        big--;
                        return true;
                    }
                }
                case 2: {
                    if (medium > 0) {
                        medium--;
                        return true;
                    }
                }
                case 3: {
                    if (small > 0) {
                        small--;
                        return true;
                    }
                }
                default:{
                    return false;
                }
            }
        }
    }

}
