package November.practice02;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abcabcbb");
    }

    public int lengthOfLongestSubstring(String s) {
        //暴力法
        //滑动窗口HashSet(双指针),HashMap
        if (s.length() == 0) return 0;
        int max = 0,left = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i),i);
                max = Math.max(max,i - left +1);
            } else {
                left = Math.max(left,map.get(s.charAt(i)) +1);
            }

        }
        return max;
    }
}

