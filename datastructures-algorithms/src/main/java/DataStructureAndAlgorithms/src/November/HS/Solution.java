package November.HS;

import November.ZS.ListNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode one1 = new ListNode(1);
        ListNode one2 = new ListNode(1);
        ListNode one3 = new ListNode(1);
        ListNode one4 = new ListNode(2);
        ListNode one5 = new ListNode(3);
        one1.next = one2;
        one2.next = one3;
        one3.next = one4;
        one4.next = one5;
        solution.deleteDuplicates(one1);
    }
    /**
     * 删除重复
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write code here
        if (head == null) return head;
        ListNode pre = new ListNode(0);
        ListNode cur = pre;

        List<ListNode> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
       // int[] arr = new int[list.size()];
        Map<Integer, Integer> map = new HashMap<>();
        for (ListNode listNode : list) {
            if (!map.containsKey(listNode.val)) {
                map.put(listNode.val, 1);
            } else {
                map.put(listNode.val, map.get(listNode.val) + 1);
            }
        }
        Set<Integer> set = map.keySet();
        int i = 0;
        for (Integer l : set) {
            if (map.get(l) > 1) {
               arr.add(l);
            }
        }
      for(ListNode ln : list){
          if (!arr.contains(ln.val) && cur != null){
              cur.next = ln;
              cur = cur.next;
          }
      }
        return pre.next;
    }
}