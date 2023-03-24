package November.HelloBike;

import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.findMaxSubstr("abcabcbb");
        System.out.println(s);
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 找到输入字符串中连续不含重复字符的最长子串。如果有多个相同长度的，只需取第一个。
     *
     * @param str string字符串 非空字符串
     * @return string字符串
     */
    public String findMaxSubstr(String str) {
        // write code here
        if (str == null || str.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int bound = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                left = Math.max(left, map.get(str.charAt(i)) + 1);
            }
            map.put(str.charAt(i), i);
            bound = right;
            right = Math.max(right, i - left + 1);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - right; i++) {
            for (int j = i; j < i +  right; j++) {
                sb.append(str.charAt(i));
            }
            list.add(sb.toString());
        }
        String ans = "";
        for (String s : list) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) break;
                set.add(s.charAt(i));
            }
            ans = s;
            break;
        }
        return ans;

    }
}