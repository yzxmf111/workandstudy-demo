package study2024;

import gogogo.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description 最小覆盖子串
 * @date 2024-03-18 22:56
 */
public class D240318 {

    /**
     * 双指针、hashmap
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapForS = new HashMap<>();
        Map<Character, Integer> mapForT = new HashMap<>();
        //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
        int len = Integer.MAX_VALUE, cnt = 0;
        String res = "";
        for (char c : t.toCharArray()) {
            mapForT.put(c, mapForT.getOrDefault(c, 0) + 1);
        }
        for (int left = 0, right = 0; right < s.length(); right++) {
            mapForS.put(s.charAt(right), mapForS.getOrDefault(s.charAt(right), 0) + 1);
            //说明字符是必须的
            if (mapForT.containsKey(s.charAt(right)) && mapForT.get(s.charAt(right)) >= mapForS.get(s.charAt(right))) {
                cnt++;
            }
            while (left < right && (!mapForT.containsKey(s.charAt(left)) ||
                    mapForT.get(s.charAt(left)) < mapForS.get(s.charAt(left)))) {
                mapForS.put(s.charAt(left), mapForS.get(s.charAt(left)) - 1);
                left++;
            }
            if (cnt == t.length() && right - left + 1 < len) {
                len = right - left + 1;
                res = s.substring(left ,right + 1);
            }
        }
        return res;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode pre = new ListNode(-1000), cur = null, start = null, after =  null, res;
        pre.next = head;
        res = pre;
        cur = head;
        int i = 1, j = 1;
        while (i < left) {
            pre = pre.next;
            i++;
        }
        while (j < right) {
            cur = cur.next;
            j++;
        }
        start = pre.next;
        after = cur.next;
        cur.next = null;
        pre.next = reverse(start);
        start.next = after;
        return res.next;
    }

    private ListNode reverse(ListNode start) {
        if (start == null || start.next == null) {
            return start;
        }
        ListNode cur = reverse(start.next);
        start.next.next = start;
        start.next = null;
        return cur;
    }

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
        D240318 d240318 = new D240318();
        d240318.reverseBetween(one, 2, 4);
    }
}
