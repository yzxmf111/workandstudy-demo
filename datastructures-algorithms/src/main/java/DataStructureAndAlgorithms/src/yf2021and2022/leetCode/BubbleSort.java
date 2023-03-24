package January.leetCode;

import November.ZS.ListNode;

import java.util.Arrays;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/27 17:07
 */


public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort b = new BubbleSort();
        int[] arr = {4,2,5,3,7,44};
        b.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1;j < arr.length - 1 - i; j++) {
                if (arr[i] > arr[j]) {
                    //交换位置
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }



        public ListNode oddEvenList(ListNode head) {

            if (head == null || head.next == null) return head;

            // head 为奇数链表的头节点，odd 为奇数链表的尾节点
            ListNode odd = head;
            // p 为偶数链表的头节点
            ListNode p = head.next;
            // even 为偶数链表的尾节点
            ListNode even = p;

            //因为先判断的 odd 所以它的约束条件要来前面
            while (odd.next != null && even.next != null) {

                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = p;
            return head;
        }



}
