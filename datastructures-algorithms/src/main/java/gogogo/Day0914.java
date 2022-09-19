package gogogo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description 最长不重复子串--滑动窗口
 * @date 2022-09-14 17:38
 */
public class Day0914 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int j = 0, max= 0;
        Map<Character, Integer> map = new HashMap<>();
        //abba
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != null) {
                //case:abba
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            max = Math.max(max, i - j + 1);
            map.put(s.charAt(i), i);
        }
        return max;
    }


    public static void main(String[] args) {
        Day0914 day0914 = new Day0914();
        int i = day0914.lengthOfLongestSubstring("abcabcbb");
        System.out.println(i);
    }

}
