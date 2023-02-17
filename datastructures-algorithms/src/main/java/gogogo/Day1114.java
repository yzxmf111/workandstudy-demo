package gogogo;

import xiaotian.entity.TreeNode;

import java.util.*;

/**
 * @author xiaotian
 * @description
 * @date 2022-11-14 16:25
 */
public class Day1114 {

    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        Queue<Integer> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    return map.get(o1) - map.get(o2);
                }
        );
        Set<Integer> set = map.keySet();
        for (Integer num : set) {
            if (i < k) {
                queue.offer(num);
                i++;
            } else {
                Integer fre = map.get(num);
                if (fre > queue.peek()) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int[] res = new int[k];
        for (int j = 0; j < queue.size(); j++) {
            res[j] = queue.remove();
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null) return resList;
        //推荐使用Deque代替stack
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            List<Integer> subList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //mark:npe注意
                if (node != null) {
                    subList.add(node.val);
                    TreeNode left = node.getLeft();
                    TreeNode right = node.getRight();
                    //mark:npe注意
                    if (left != null) {
                        queue.offer(left);
                    }
                    if (right != null) {
                        queue.offer(right);
                    }
                }
            }
            resList.add(subList);
        }
        return resList;
    }

    //1-2-3-4-5
    //1、首先知道有几个节点
    public ListNode getKthFromEnd(ListNode head, int k) {

        ListNode pre = head, cur = head;
        int i = 0;
        while (cur != null) {
            cur = cur.next;
            i++;
        }

        i = i - k;
        while (pre != null && i >= 1) {
            pre = pre.next;
            i--;
        }
        return pre;
    }

    //两两交换链表的节点
    //1-2-3-4 and 1-2-3-4-5
    //递归 or 迭代 --双指针
    //public ListNode swapPairs(ListNode head) {
    //    if (head == null || head.next == null) return head;
    //    ListNode first = head, second = head;
    //    while (second != null /*&& second.next != null && second.next.next != null*/) {
    //
    //    }
    //     swapPairs(head);
    //}

    public static void main(String[] args) {

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        Day1114 day1114 = new Day1114();
        ListNode kthFromEnd = day1114.getKthFromEnd(one, 2);
        System.out.println(kthFromEnd);
    }

}