package January.leetCode;

import November.ZS.ListNode;

import java.util.*;

/**
 * @description:
 * @author: Tian
 * @time: 2021/1/17 17:15
 */


public class Solution01 {

    public ListNode reverseList(ListNode head) {
       /* //方法一:迭代
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;*/
        //方法二:递归
        if (head.next == null) return head;
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }

    //
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        for (int num : nums) {
            //mark:统计频次
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return map.get(o1) - map.get(o2);
                    }
                }
        );
        int i = 0;
        for (Integer key : map.keySet()) {
            if (i < k) {
                queue.add(key);
                i++;
            } else {
                Integer peek = queue.peek();
                if (map.get(key) > map.get(peek)) {
                    queue.poll();
                    queue.add(key);
                }
            }
        }
        int[] res = new int[k];
        for (int j = 0; j < k; j++) {
            res[j] = queue.remove();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        Solution01 solution01 = new Solution01();
        int[] ints = solution01.topKFrequent(a, 2);
    }
}