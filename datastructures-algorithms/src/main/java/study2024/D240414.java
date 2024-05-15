package study2024;

import gogogo.ListNode;

import java.util.*;

/**
 * @Author: yxxmf
 * @Date: 2024/04/14/16:46
 * @Description:
 */
public class D240414 {

    public static void main(String[] args) {
        // ListNode pre = new ListNode(-1);
        // ListNode one = new ListNode(1);
        // ListNode two = new ListNode(2);
        // one.next = two;
        // pre.next = one;
        // System.out.println(pre);
        // ClassLoader classLoader = new D240414().getClass().getClassLoader();
        // System.out.println(classLoader);
        // ClassLoader classLoader1 = new ArrayList<Integer>().getClass().getClassLoader();
        // System.out.println(classLoader1);
        System.out.println(testFinally());

    }


    public static String testFinally() {
        try {
            System.out.println("try执行了");
            return "success";
        }catch (Exception e) {

        } finally {
            System.out.println("finally 执行了 ");
        }
        return "meizhixing";
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        Map<ListNode, Integer> listNodeMap = new HashMap<>();
        int j = 0;
        while (head != null) {
            if (listNodeMap.containsKey(head)) {
                return true;
            }
            listNodeMap.put(head, j++);
            head = head.next;
       }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        Map<ListNode, Integer> listNodeMap = new HashMap<>();
        int j = 0;
        while (head != null) {
            if (listNodeMap.containsKey(head)) {
                return head;
            }
            listNodeMap.put(head, j++);
            head = head.next;
        }
        return null;
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (deque.size() > 0) {
            int size = deque.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.removeFirst();
                subList.add(treeNode.val);
                if (treeNode.right != null) {
                    deque.addLast(treeNode.right);
                }
                if (treeNode.left != null) {
                    deque.addLast(treeNode.left);
                }
            }
            if (res.size() % 2 != 0) {
                Collections.reverse(subList);
            }
            res.add(subList);
        }
        return res;
    }
}
