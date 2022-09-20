package gogogo;

import io.swagger.models.auth.In;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaotian
 * @description
 * @date 2022-09-19 17:11
 */
public class Day0919 {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> mapForS = new HashMap<>();
        Map<Character, Integer> mapForT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapForT.put(t.charAt(i), mapForT.getOrDefault(t.charAt(i), 0) + 1);
        }
        int len = Integer.MAX_VALUE;
        int signalWordCount = 0;
        String ans = "";
        for (int left = 0, right = 0; right < s.length(); right++) {
            mapForS.put(s.charAt(right), mapForS.getOrDefault(s.charAt(right), 0) + 1);
            //如果ht表中也包含当前字符
            if (mapForT.containsKey(s.charAt(right))) {
                //并且hs表中的字符个数<=ht表中的字符个数,说明该字符是必须的，并且还未到达字符串t所要求的数量
                if (mapForS.get(s.charAt(right)) <= mapForT.get(s.charAt(right))) {
                    signalWordCount++;
                }
            }
            while (left < right && (!mapForT.containsKey(s.charAt(left)) ||
                    mapForS.get(s.charAt(left)) > mapForT.get(s.charAt(left)))) {
                mapForS.put(s.charAt(left), mapForS.get(s.charAt(left)) - 1);
                left++;
            }
            if (signalWordCount == t.length() && right - left + 1 < len) {
                len = right - left + 1;
                ans = s.substring(left, right + 1);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Day0919 day0919 = new Day0919();
        String s = day0919.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(s);
    }
}
