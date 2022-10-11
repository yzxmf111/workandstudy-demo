package gogogo;

import java.util.HashMap;
import java.util.Map;

public class Day007 {

    public static void main(String[] args) {
        System.out.println(minWindow("abc", "b"));
    }

    //滑动窗口最重要的事情：1.数据的存储，2.窗口的滑动，3.何时为需要的结果
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        //滑动窗口，双指针，hashmap
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();
//        for (int i = 0; i < s.toCharArray().length; i++) {
//
//        }
        for (char c : t.toCharArray()) {
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        int len = Integer.MAX_VALUE;
        String ans = "";
        int left = 0 , count = 0;
        //何时为符合条件的答案： t.length() = count;
        //何时滑动
        for (int right = 0; right < s.length(); right++) {
            mapS.put(s.charAt(right), mapS.getOrDefault(s.charAt(right), 0) + 1);
            if (mapt.containsKey(s.charAt(right)) && mapS.get(s.charAt(right)) <= mapt.get(s.charAt(right))) {
                count++;
            }
            while (left < right && ( !mapt.containsKey(s.charAt(left)) || mapS.get(s.charAt(left)) > mapt.get(s.charAt(left))/*count > t.length()*/)) {
                mapS.put(s.charAt(left), mapS.get(s.charAt(left)) - 1);
                left ++;
            }
            if (count == t.length() &&  right - left + 1 < len) {
                len = right - left + 1;
                ans = s.substring(left, right + 1);
            }
        }
        return ans;
    }

}
