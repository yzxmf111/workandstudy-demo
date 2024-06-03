package March;

import November.ZS.ListNode;

import java.util.*;
import study2024.TreeNode;

public class About316 {
    /* public static void main(String[] args) {
         ListNode one = new ListNode(1);
         ListNode two = new ListNode(2);
         ListNode three = new ListNode(3);
         ListNode four = new ListNode(4);
         one.next = two;
         two.next = three;
         three.next = four;
         About316 ans = new About316();
         ListNode listNode = ans.reverseKGroup(one, 2);
         System.out.println(listNode);
     }*/
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);//防止头指针丧失
        pre.next = head;
        ListNode first = pre;
        ListNode end = pre;
        while (end.next != null) {
            for (int i = 0; i < k; i++) {
                if (end != null) {
                    end = end.next;
                } else {
                    break;
                }
            }
            if (end == null) break;
            ListNode start = first.next;
            ListNode newHead = end.next;
            end.next = null;
            first.next = swapListNode(start);
            start.next = newHead;
            first = start;
            //mark1: 必不可少的一步
            end = start;
        }
        return pre.next;
    }

    private ListNode swapListNode(ListNode head) {
        //不用判断重复与否
        if (head == null || head.next == null) return head;
        ListNode cur = head;
        //mark2: 2->1->0 这样的连接方式无所谓 因为最终会变成 first - >2->1->newHead
        ListNode pre = new ListNode(0);
        ListNode temp;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        About316 ans = new About316();
        int kthMagicNumber = ans.getKthMagicNumber(643);
        System.out.println(kthMagicNumber);
    }

    public int getKthMagicNumber(int k) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> set = new HashSet<>();
        pq.add(1L);
        while (true) {
            Long val = pq.remove();
            //错误的方法
            //会出现大量的重复元素,虽然不会影响结果
            set.add(val);
            if (set.size() == k) return val.intValue();
            pq.add(val * 3);
            pq.add(val * 5);
            pq.add(val * 7);
        }
    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //正常情况下先考虑边界条件
        if (k == 0 || arr.length == 0) return new int[]{};
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        while (i < arr.length) {
            if (i < k) {
                pq.offer(arr[i]);
            } else {
                int ans = pq.peek();
                if (ans > arr[i]) {
                    pq.remove();
                    pq.offer(arr[i]);
                }
            }
            i++;
        }
        int[] nums = new int[k];
        for (int j = 0; j < nums.length; j++) {
            nums[j] = pq.remove();
        }
        return nums;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(n,n,list,"");
        return list;
    }

    private void dfs(int left, int right, List<String> list, String path) {
        if (left == 0 && right == 0) {
            list.add(path);
            return;
        }
        //剪枝
        if (left < right) return;
        if (left > 0) dfs(left - 1,right,list,path + "(");
        if (right > 0) dfs(left, right - 1, list, path + ")");
    }
}
