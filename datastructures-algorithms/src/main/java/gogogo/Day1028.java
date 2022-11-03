package gogogo;

import org.aspectj.weaver.ast.Var;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description 反转链表
 * @date 2022-10-28 15:55
 */
public class Day1028 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    public ListNode reverseList2(ListNode head) {
        //递归法 --走出舒适区，感觉好爽
        if (head == null || head.next == null) return head;//递归的终止条件
        ListNode cur = reverseList2(head.next); //递归
        head.next.next = head; //当前单元处理
        head.next = null;
        return cur;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap();//解决重复的问题
        Integer max = 0;  //返回结果
        int j = 0; //双指针
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //j作为一个指针的情况在与s = abba
                j = Math.max(i, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - j + 1);
        }
        return max;
    }

    public String minWindow(String s, String t) {
        //维护s串中滑动窗口中各个字符出现次数
        Map<Character, Integer> hs = new HashMap<>();
        //维护t串中各个字符出现次数
        Map<Character, Integer> ht = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0)+1);
        }
        String ans="";
        //cnt维护s串[left,right]中满足t串的元素的个数，记录相对应字符的总数
        int len=Integer.MAX_VALUE, cnt=0;
        //区间[left,right]表示当前滑动窗口
        for (int left=0,right = 0; right < s.length(); right++) {
            hs.put(s.charAt(right), hs.getOrDefault(s.charAt(right), 0)+1);
            //如果ht表中也包含当前字符
            if (ht.containsKey(s.charAt(right))) {
                //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                if (hs.get(s.charAt(right))<=ht.get(s.charAt(right))) {
                    cnt++;
                }
            }
            //收缩滑动窗口
            //如果左边界的值不在ht表中 或者 它在hs表中的出现次数多于ht表中的出现次数
            while(left < right && (!ht.containsKey(s.charAt(left)) || hs.get(s.charAt(left)) > ht.get(s.charAt(left)))){
                hs.put(s.charAt(left),hs.get(s.charAt(left)) - 1);
                left++;
            }
            //此时滑动窗口包含符串 t 的全部字符
            if (cnt==t.length()&&right-left + 1 <len) {
                len=right-left+1;
                ans=s.substring(left,right+1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        Day1028 day1028 = new Day1028();
        int res = day1028.lengthOfLongestSubstring("abba");
        System.out.println(res);
    }
}
